package tests.US_017;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.userMealscenter.UserHomePage;
import pages.userMealscenter.UserProfilPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC01702 extends TestBaseRapor {
          /*
        'qa.mealscenter.com' sayfasına gidilir
        Cookie'yi kabul eder.
        Ana menüdeki ""Profil"" bölümüne tiklanir
        ""Ödeme Seçenekleri"" seçeneği tİklanir
        Ödeme bilgileri sayfasında degistirmek istediği ödeme bilgisi secilir
        Degistirme işlemini onaylar.
        Silmek istedigi ödeme bilgisi secilir
        Sistem, ödeme bilgisini başarıyla siler ve kullanıcıya bilgi verir.
        Açılan dropdown menudeki "Logout" butonuna tıklanir
        Sayfa kapatılır.
          */


    UserHomePage userHomePage=new UserHomePage();
    UserProfilPage userProfilPage=new UserProfilPage();

    @BeforeClass
    public void setUp(){

        // Kayitli Odeme seceneklerinin degistirme ve silme islemleri test edilir
        extentTest = extentReports.createTest("Odeme bilgilerinin degistirme ve silme islemleri testi", "Update ve Delete islemleri test edildi");

        // 'https://qa.mealscenter.com/account/login' sayfasına gidilir
        Driver.getDriver().get(ConfigReader.getProperty("mealCenterLoginPage"));
        extentTest.info("https://qa.mealscenter.com/account/login  sayfasına gidildi");

        // Cookie kabul edilir
        userHomePage.acceptCookie.click();
        extentTest.info("Cookies kabul edildi");

        //Gecerli Email girilir
        userHomePage.signInUsernameBox.sendKeys("team4@hotmail.com");
        extentTest.info("Gecerli email girildi");

        //Password girilir
        userHomePage.signInPasswordBox.sendKeys(ConfigReader.getProperty("singUpGecerliSfre"));
        extentTest.info("Gecerli password girildi");

        // Sig in Butonu tiklanir
        userHomePage.signUpKayitButton.click();
        extentTest.info("Sig in Butonu tiklandi");
        ReusableMethods.bekle(2);

        //profil menusu tiklanir
        userProfilPage.profilButton.click();
        extentTest.info("Profil menusu tiklandi");

        ReusableMethods.bekle(2);

        Actions actions=new Actions(Driver.getDriver());

        //  "Ödeme Seçenekleri" dropDown u tiklanir
        actions.click(userProfilPage.paymentOptions).perform();
        extentTest.info("Ödeme Seçenekleri dropDown u tiklandi");
        ReusableMethods.bekle(2);
    }
    @Test
    public void test01() {
        //Kredi Karti bigilerinin güncellenme menusunun secildigi test edilir
        Assert.assertTrue(userProfilPage.kKartiEditButonu.isSelected(),"Kredi karti bilgileri guncellenemedi");
        extentTest.fail("'Kredi Karti bigilerinin güncelleme islemin yapilamadigi test edildi");
    }
    @Test
    public void test02() {
        // Cash(Nakit odeme bilgilerinin guncelleme menusunun secildigi test edilir
        Assert.assertTrue(userProfilPage.cashEditButonu.isSelected(),"Cash bilgileri guncellenemedi");
        extentTest.fail("Cash(Nakit odeme bilgilerinin guncelleme isleminin yapilamadigi test edildi");

    }
    @Test
    public void test03() {
        //Kredi Karti bigilerinin silindigi test edilir
        userProfilPage.kKartiDeleteButonu.click();
        Assert.assertTrue( userProfilPage.kKartiDeleteButonu.isSelected(),"Kart bilgileri silinemedi");
        extentTest.fail("Kredi Karti bigilerinin silinemedigi test edildi");
    }
    @Test
    public void test04() {
        //Cash(Nakit odeme bilgilerinin silindigi test edilir
         userProfilPage.cashDeleteButonu.click();
        Assert.assertTrue(userProfilPage.cashDeleteButonu.isSelected(),"Cash bilgileri silinemedi");
        extentTest.fail("Cash(Nakit odeme bilgilerinin silinemedigi test edildi");
    }
    @AfterClass
    public void thearDown(){
        //profil menusu tiklanir
        userProfilPage.profilButton.click();
        extentTest.info("Profil menusu tiklandi");

        // profilden cikis yapilir
        userProfilPage.logoutButton.click();
        extentTest.info("Profilden cikis yapildi");

        // Sayfa Kapatilir
        Driver.getDriver().close();
        extentTest.info("Sayfa Kapatildi");
    }
}