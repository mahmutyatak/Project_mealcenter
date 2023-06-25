package tests.US_019;

import org.testng.annotations.Test;
import pages.merchantMealscenter.MerchantDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import static org.testng.AssertJUnit.assertTrue;

public class TC01901 extends TestBaseRapor {

      /*
        Kullanıcı "https://qa.mealscenter.com/backoffice/auth/login" sayfasına gidilir.
        Email kutusunun görünürlüğünü doğrulanir
        Password kutusunun görünürlüğünü doğrulanir
        Sayfa kapatılır..
     */
      MerchantDashboard merchantDashboard=new MerchantDashboard();

    @Test
    public void test01() {
       // "https://qa.mealscenter.com/backoffice/auth/login" sayfasının
       // görünür olduğunu doğrulanmalıdır.
        extentTest = extentReports.createTest
                ("Restaurant yöneticisi, geçerli e-posta adresi ve şifre ile sisteme giriş testi", "Login giris test edildi");
        extentTest = extentReports.createTest
                ("'https://qa.mealscenter.com/backoffice/auth/login' sayfasının" +
                        "  görünür olduğunu testi", "Gorunurluk testi edildi");

        //'https://qa.mealscenter.com/backoffice/auth/login' sayfasına gidilir
        Driver.getDriver().get(ConfigReader.getProperty("mealCenterMerchantPageUrl"));
        extentTest.info("'https://qa.mealscenter.com/backoffice/auth/login' sayfasına gidildi");

        // Email kutusunun görünürlüğünü doğrulanir.
        assertTrue(merchantDashboard.usernameBox.isDisplayed());
        extentTest.pass("Email kutusunun görünürlüğünü test edildi");

        //Password kutusunun görünürlüğünü doğrular.
        assertTrue(merchantDashboard.usernameBox.isDisplayed());
        extentTest.pass("Password kutusunun görünürlüğünü test edildi");

       //Sayfa kapatılır
        Driver.getDriver().close();
        extentTest.info("Sayfa kapatildi");


    }
}
