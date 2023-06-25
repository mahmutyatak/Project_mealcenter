package tests.US_020;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.merchantMealscenter.MerchantDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC02001 extends TestBaseRapor {

    /*
        'https://qa.mealscenter.com/backoffice/auth/login' sayfasına gidilir
        "Merchant Login" menusunde "Forgot password" bağlantısına tıklanir
        "Forgot password" sayfasina gidildigi dogrulanir
         Gecerli e-posta adresi girilir
        "Request E-mail" butonu tıklanir
        "Hesabınıza e-posta gönderildi."mesajindan gorunurlugu test edilir
         Sayfa Kapatilir
     */
    MerchantDashboard merchantDashboard = new MerchantDashboard();

    @Test
    public void test01() {

         //  Restorant yöneticisi olarak password bilgileri unuttuğunda yeni şifre oluşturabilmelidir
        extentTest = extentReports.createTest
      ("Restorant yöneticisi olarak pasword bilgileri unuttuğunda yeni şifre oluşturabilme testi",
              "Yeni sifre belirleme test edildi");

        //'https://qa.mealscenter.com/backoffice/auth/login' sayfasına gidilir
        Driver.getDriver().get(ConfigReader.getProperty("mealCenterMerchantPageUrl"));
        extentTest.info("'https://qa.mealscenter.com/backoffice/auth/login' sayfasına gidildi");

       // 'Forgot password' bağlantısına tıklanir
        merchantDashboard.forgotPasswordClick.click();
        extentTest.info(" 'Forgot password' bağlantısına tıklandi");

        // "Forgot password" sayfasina gidildigi dogrulanir
        Assert.assertTrue(merchantDashboard.forgotPasswordMenu.isEnabled());
        extentTest.pass("'Unable to login. Check your login information and try again.' yazısının çıktığı test edildi");
        ReusableMethods.bekle(2);

        Actions actions=new Actions(Driver.getDriver());
       // Gecerli e-posta adresi girilir
        actions.click(merchantDashboard.forgotPasswordLoginEmail).perform();
        ReusableMethods.bekle(1);
        extentTest.info(" 'Gecerli e-posta adresi girildi");
        actions.sendKeys("info@apalmera.com").perform();
        ReusableMethods.bekle(1);

        //"Request E-mail" butonu tıklanir
        actions.click(merchantDashboard.requestEmailButton).perform();
        extentTest.info(" 'Gecerli e-mail adresi girildi");

        //"Hesabınıza e-posta gönderildi."mesajindan gorunurlugu test edilir
        Assert.assertTrue(merchantDashboard.emailHasbeenMesaj.isDisplayed());
        extentTest.pass("Hesabınıza e-posta gönderildi mesajindan gorunurlugu test edildi");

        // Sayfa Kapatilir
        Driver.getDriver().close();
        extentTest.info("Sayfa kapatildi");

    }
}