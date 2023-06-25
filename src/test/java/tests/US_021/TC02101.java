package tests.US_021;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.merchantMealscenter.MerchantDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import static org.testng.AssertJUnit.assertTrue;

public class TC02101 extends TestBaseRapor {

    /*
    Browser açılır.'https://qa.mealscenter.com/backoffice/auth/login' sayfasına gidilir
    Merchant Login" menusunde "username" bolumune gecerli username
    "pasword"bolumune gecerli pasword girilir ve "sign in" butonu tiklanir.
    Dashboard menusunun gorunurlugu test edilir
     */
    MerchantDashboard merchantDashboard = new MerchantDashboard();

    @Test
    public void test01() {
       // Dashboard menusu restaurantla ilgili önemli verileri görünür olan bir  sayfa olmalıdır.
        extentTest = extentReports.createTest
                ("Dashboard menusu  görünürlük testi","Gorunurluk testi");

        //'https://qa.mealscenter.com/backoffice/auth/login' sayfasına gidilir
        Driver.getDriver().get(ConfigReader.getProperty("mealCenterMerchantPageUrl"));
        extentTest.info("'https://qa.mealscenter.com/backoffice/auth/login' sayfasına gidildi");
        Actions actions = new Actions(Driver.getDriver());

        //Username ve password bilgiler girilir
        actions.sendKeys(merchantDashboard.usernameBox, ConfigReader.getProperty("LaPalmeraUsername"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("LaPalmeraPassword")).perform();
        extentTest.info("Username ve password bilgiler girildi");

        //"Sign in" butonuna tıklanir
        merchantDashboard.signinButton.click();
        extentTest.info("Sign in butonu tıklandi");

        // Dashboard menusunun gorunurlugu ve ulasilabilirligi test edilir
        assertTrue(merchantDashboard.dashboardLink.isDisplayed());
       assertTrue(merchantDashboard.dashboardLink.isEnabled());
        extentTest.pass("Dashboard menusunun gorunurlugu ve ulasilabilirligi test edildi");

        // profilden cikis yapilir
        merchantDashboard.logOutMethod();
        extentTest.info("profilden cikis yapildi");

        // Sayfa Kapatilir
        Driver.getDriver().close();
        extentTest.info("Sayfa kapatildi");

    }
}
