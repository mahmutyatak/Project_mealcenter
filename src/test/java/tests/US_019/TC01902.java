package tests.US_019;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.merchantMealscenter.MerchantDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC01902 extends TestBaseRapor {

    /*
    "https://qa.mealscenter.com/account/login " sayfasına gidilir.
    Username ve password bilgiler girilir
    "Sign in" butonuna tıklanir
    Merchant menüsüne erişilir
    Merchant menüsü sayfasının açıldığın doğrulanir
    Profil menusu tiklanir
    Açılan dropdown menudeki "Logout" butonuna tıklanir
    Sayfa kapatılır.
     */
    MerchantDashboard merchantDashboard=new MerchantDashboard();

    @Test
    public void test01() {

       // Restaurant yöneticisi, geçerli e-posta adresi ve şifre ile sisteme giriş yapabilmelidir.
        extentTest = extentReports.createTest
                ("Restaurant yöneticisi, geçerli e-posta adresi ve şifre ile sisteme giriş testi", "Pozitif Login test edildi");

        //'https://qa.mealscenter.com/backoffice/auth/login' sayfasına gidilir
        Driver.getDriver().get(ConfigReader.getProperty("mealCenterMerchantPageUrl"));
        extentTest.info("https://qa.mealscenter.com/backoffice/auth/login sayfasına gidildi");

        Actions actions=new Actions(Driver.getDriver());

       //Username ve password bilgiler girilir
        actions.sendKeys(merchantDashboard.usernameBox,ConfigReader.getProperty("LaPalmeraUsername"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("LaPalmeraPassword")).perform();
        extentTest.info("Username ve password bilgiler girildi");

      //"Sign in" butonuna tıklanir
        merchantDashboard.signinButton.click();
        extentTest.info("'Sign in' butonuna tıklandi");

      // Merchant menüsü sayfasının açıldığı doğrulanir
        String expectedTitle="Dashboard";
        String actualTittle= Driver.getDriver().getTitle();
        Assert.assertEquals(expectedTitle,actualTittle);
        extentTest.pass("Merchant menüsü sayfasının açıldığı  test edildi");

        // profilden cikis yapilir
        merchantDashboard.logOutMethod();
        extentTest.info("Profilden cikis yapildi");

        // Sayfa Kapatilir
        Driver.getDriver().close();
        extentTest.info("Sayfa kapatildi");
    }
}
