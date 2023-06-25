package tests.US_019;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.merchantMealscenter.MerchantDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC01903 extends TestBaseRapor {
    /*
   "https://qa.mealscenter.com/account/login " sayfasına gidilir.
    Email kutusuna tıklanir
    Email kutusuna  "geçersiz mail" mailini gönderilir
    Password kutusuna geçilir
    Password kutusuna "geçersiz şifre" gönderilir
    "Sign in" butonuna tıklanır.
    "Unable to login. Check your login information and try again." yazısının çıktığı doğrulanır.
    Sayfa kapatılır.
     */
    MerchantDashboard merchantDashboard = new MerchantDashboard();

    @Test
    public void test01() {
       // Geçersiz e-posta veya şifre ile oturum açılamamalıdır
        extentTest = extentReports.createTest
                (" Geçersiz e-posta veya şifre ile oturum açılamama testi", "Negatif Login test edildi");

        //'https://qa.mealscenter.com/backoffice/auth/login' sayfasına gidilir
        Driver.getDriver().get(ConfigReader.getProperty("mealCenterMerchantPageUrl"));
        extentTest.info("'https://qa.mealscenter.com/backoffice/auth/login' sayfasına gidildi");

        Actions actions=new Actions(Driver.getDriver());

        //"Gecersiz mail" mailini gonderilir
        actions.sendKeys(merchantDashboard.usernameBox,ConfigReader.getProperty("singUpGecersizEmail3"))
                .sendKeys(Keys.TAB)
        // Password kutusuna "geçersiz şifre" gönderilir
                .sendKeys(ConfigReader.getProperty("singUpGecersizsifre3")).perform();
        extentTest.info("Gecersiz mail,gecersiz password girildi");

        //"Sign in" butonuna tıklanir
        merchantDashboard.signinButton.click();
        extentTest.info("'Sign in' butonuna tıklandi");

       // "Unable to login. Check your login information and try again." yazısının çıktığı doğrulanır.
        Assert.assertTrue(merchantDashboard.wrongLogiNnMesaj.isDisplayed());
        extentTest.pass("'Unable to login. Check your login information and try again.' yazısının çıktığı test edildi");

       // Sayfa Kapatilir
        Driver.getDriver().close();
        extentTest.info("Sayfa kapatildi");
    }
}
