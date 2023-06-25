package tests.US_022;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.merchantMealscenter.MerchantDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC02201 extends TestBaseRapor {

    /*
    https://qa.mealscenter.com/backoffice/auth/login' sayfasına gidilir
    Merchant Login" menusunde "username" bolumune gecerli username "pasword"
    bolumune gecerli pasword girilir ve "sign in" bolumune tiklanir
    Header bolumunde bulunan  Restorant yöneticisi menusunden "profil" menusunun
    gorunurlugu test edilir
    Sayfa Kapatilir
     */
    MerchantDashboard merchantDashboard = new MerchantDashboard();

    @Test
    public void test01() {
      // Merchant  sayfasinin header bolumunde  profil
       // dropDown menusunun görünür olmalıdır
        extentTest = extentReports.createTest("Profil DropDown menusunun görünürlük testi","Gorunurluk testi");

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

       // Restorant yöneticisi menusunden "profil" menusunun gorunurlugu test edilir
        Assert.assertTrue(merchantDashboard.profilName.isDisplayed());
        extentTest.pass(" Restorant yöneticisi menusunden 'profil' menusunun gorunurlugu test edildi");

        // profilden cikis yapilir
        merchantDashboard.logOutMethod();
        extentTest.info("profilden cikis yapildi");

        // Sayfa Kapatilir
        Driver.getDriver().close();
        extentTest.info("Sayfa kapatildi");
    }
}