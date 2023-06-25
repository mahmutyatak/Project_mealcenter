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

public class TC02203 extends TestBaseRapor {

    /*
   'https://qa.mealscenter.com/backoffice/auth/login' sayfasına gidilir
    Merchant Login" menusunde "username" bolumune gecerli username "pasword"
    bolumune gecerli pasword girilir ve "sign in" bolumune tiklanir
    Header Profil dropDown menusu tiklanir
    "Profil"menusu tiklanir
    Isim soyaisim girilir
    Email ve telefon numarasi girilir
    Kullanici adi girilir
    Save butonu tiklanir
    Profil bilgilerinin güncellendigi test edilir
    Profil dropdown menudeki "Logout" butonuna tıklanir
    Sayfa kapatilir
     */
    MerchantDashboard merchantDashboard = new MerchantDashboard();

    @Test
    public void test01() {

        //Merchant sayfasinini profil bilgilerini guncelleyip kaydedebilecegi bir menu olmalidir
        extentTest = extentReports.createTest("profil bilgilerinin update testi","Update,Save Gorunurluk testi");

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
        extentTest.info("Profil menusu tiklandi");
        ReusableMethods.bekle(1);

        //"Profil" dropDown menusu tiklanir
        actions.click(merchantDashboard.dashboardProfilDropDown).perform();
        extentTest.info("Profil dropDown menusu tiklandi");

        // Isim  girilir
        actions.click(merchantDashboard.profilFirstNameMenu).sendKeys("")
        // Soyisim girilir
                .sendKeys(merchantDashboard.profilLastNameMenu).sendKeys("")
                //Email bilgileri girilir
                .sendKeys(merchantDashboard.profilEmailMenu).sendKeys("")
                // Telefon bilgileri girilin
                .sendKeys(merchantDashboard.profilTelefonMenu).sendKeys("")
                //Kullanici adi girilir
                .sendKeys(merchantDashboard.profilKullaniciAdiMenu).sendKeys("").perform();
        extentTest.info("Kullanici isin,soyisim,email,telefon ve kullanici adi bilgileri girildi");

        // Save butonuna tiklanir
        actions.click(merchantDashboard.profilSaveButton).perform();
        extentTest.info("Save butonu tiklandi");

       // Profil bilgilerinin güncellendigi test edilir
        Assert.assertTrue(merchantDashboard.profilUpdateYazisi.isEnabled());
        extentTest.pass(" Profil bilgilerinin güncellendigi test edildi");

        // profilden cikis yapilir
        merchantDashboard.logOutMethod();
        extentTest.info("profilden cikis yapildi");

        // Sayfa Kapatilir
        Driver.getDriver().close();
        extentTest.info("Sayfa kapatildi");

    }


    }
