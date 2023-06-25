package tests.US_022;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.merchantMealscenter.MerchantDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC02205 extends TestBaseRapor {

    /*
    Browser açılır
    https://qa.mealscenter.com/backoffice/auth/login' sayfasına gidilir
    Merchant Login" menusunde "username" bolumune gecerli username "pasword"
    bolumune gecerli pasword girilir ve "sign in" bolumune tiklanir
    Header bolumunde bulunan  Restorant yöneticisi menusunden "profil" menusu tiklanir
    'Change Password' şifre degistir menusunun gorunurlugu test edilir
    'Change Password' şifre degistir menusu butonu tiklanir
    Mevcut password girilir
    Yeni password girilir
    Yeni password tekrar girilir
    Save butonu tiklanir
    Yeni sifrenin kaydedildigi test edilir
    Profil dropdown menudeki "Logout" butonuna tıklanir
    Sayfa kapatilir
     */

    MerchantDashboard merchantDashboard = new MerchantDashboard();

    @Test
    public void test01() {

        //Merchant sayfasinini profil menusunde bulunan
        // 'Change Password' şifre degistir menusu gorunur ve aktif olmalidir
        extentTest = extentReports.createTest("'Change Password' şifre degistir menusu gorunur ve aktif olma testi",
                " Gorunurluk ve aktif olma testi");

        //'https://qa.mealscenter.com/backoffice/auth/login' sayfasına gidilir
        Driver.getDriver().get(ConfigReader.getProperty("mealCenterMerchantPageUrl"));
        extentTest.info("''https://qa.mealscenter.com/backoffice/auth/login' sayfasına gidildi");

        Actions actions = new Actions(Driver.getDriver());

        //Username ve password bilgiler girilir
        actions.sendKeys(merchantDashboard.usernameBox, ConfigReader.getProperty("LaPalmeraUsername"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("LaPalmeraPassword")).perform();
        extentTest.info("Username ve password bilgiler girildi");

        //"Sign in" butonuna tıklanir
        merchantDashboard.signinButton.click();
        extentTest.info("Sign in butonuna tıklandi");

        //"Profil"  menusu tiklanir
        merchantDashboard.profileButton.click();
        extentTest.info("Profil menusu tıklandi");
        ReusableMethods.bekle(1);

        //"Profil" dropDown menusu tiklanir
        actions.click(merchantDashboard.dashboardProfilDropDown).perform();
        extentTest.info("Profil dropDown menusu tiklan");

        //  'Change Password' şifre degistir menusunun gorunurlugu test edilir
        Assert.assertTrue(merchantDashboard.profilSifreDegistirmeButonu.isDisplayed());
        extentTest.pass(" Change Password' şifre degistir menusunun gorunurlugu test edildu");


        // 'Change Password' şifre degistir menusu butonu tiklanir
        actions.click(merchantDashboard.profilSifreDegistirmeButonu).perform();
        extentTest.info("Change Password' şifre degistir menusu butonu tiklandi");

        // Mevcut password girilir
        actions.click(merchantDashboard.profilEskiSifreMenu).sendKeys("mly123456").perform();
        extentTest.info("Mevcut password girildi");

        //Yeni sifre girilir
        actions.click(merchantDashboard.profilYeniSifreMenu) .sendKeys("mly11111").perform();
        extentTest.info("Yeni sifre girildi");

          //Yeni sifre tekrar girilir
        actions.click(merchantDashboard.profilYeniSifreTekrarMenu).sendKeys("mly11111").perform();
        extentTest.info("Yeni sifre tekrar girildi");

         // Save butonu tiklanir
        actions.click(merchantDashboard.profilYeniSifreSaveButonu).perform();
        extentTest.info("Save butonu tiklandi");

        // Yeni sifrenin kaydedildigi test edilir
        String expectedIcerik="Saved Stores";
        String actualIcerik=merchantDashboard.profilYeniSifreSaveButonu.getText();
        Assert.assertEquals(expectedIcerik,actualIcerik,"Save butonunun calismadigi icin yeni şifre kaydedilemedi");
        extentTest.pass("'Kaydet' butonu tiklanamadigi icin yeni şifre kaydedilemedigi test edildi");

        // profilden cikis yapilir
        merchantDashboard.logOutMethod();
        extentTest.info("profilden cikis yapildi");

        // Sayfa Kapatilir
        Driver.getDriver().close();
        extentTest.info("Sayfa kapatildi");;







    }
}
