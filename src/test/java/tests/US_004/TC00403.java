package tests.US_004;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.userMealscenter.UserHomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC00403 extends TestBaseRapor {

    @Test
    public void test01(){
        extentTest = extentReports.createTest("Footer bölümünde, \"Meals Center Corp.\" bölümünün görünür oldugu ve linklerin beklenilen şekilde çalıştığı doğrulanır.");

        UserHomePage userHomePage = new UserHomePage();

        //Browser açılır.
        //"https://qa.mealscenter.com/" adresine gidilir.
        Driver.getDriver().get(ConfigReader.getProperty("mealCenterHomePageUrl"));
        extentTest.info("\"https://qa.mealscenter.com/\" adresine gidildi");

        //Sayfanın en altına inilir.
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.END).perform();
        extentTest.info("Sayfanın en altına inildi");

        //"Meals Center Corp." bölümünün görünür olduğu test edilir
        Assert.assertTrue(userHomePage.mealCenterCorpTumBolum.isDisplayed());
        extentTest.pass("\"Meals Center Corp.\" bölümünün görünür olduğu test edildi");

        //"Contact us" linkine tıklanır.
        userHomePage.contactUsElementi.click();
        extentTest.info("\"Contact us\" linkine tıklandı");

        //Açılan sayfanın url'sinin "https://qa.mealscenter.com/contactus" olduğu test edilir.
        String expectedUrl = "https://qa.mealscenter.com/contactus";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
        extentTest.pass("Açılan sayfanın url'sinin \"https://qa.mealscenter.com/contactus\" olduğu test edildi");

        //Önceki sayfaya geri dönülür.
        Driver.getDriver().navigate();
        extentTest.info("Önceki sayfaya geri dönüldü");

        //Sayfanın en altına inilir.
        actions.sendKeys(Keys.END).perform();
        extentTest.info("Sayfanın en altına inildi");

        //"Terms and conditions" linkine tıklanır.
        userHomePage.termsandConditionsElementi.click();
        extentTest.info("\"Terms and conditions\" linkine tıklandı");

        //Açılan sayfanın url'sinin "https://qa.mealscenter.com/terms-and-conditions" olduğu test edilir.
        expectedUrl = "https://qa.mealscenter.com/terms-and-conditions";
        actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
        extentTest.pass("Açılan sayfanın url'sinin \"https://qa.mealscenter.com/terms-and-conditions\" olduğu test edildi");

        //Önceki sayfaya geri dönülür.
        Driver.getDriver().navigate();
        extentTest.info("Önceki sayfaya geri dönüldü");

        //Sayfanın en altına inilir.
        actions.sendKeys(Keys.END).perform();
        extentTest.info("Sayfanın en altına inildi");

        //"Privacy policy" linkine tıklanır.
        userHomePage.privacyPolicyElementi.click();
        extentTest.info("\"Privacy policy\" linkine tıklandı");

        //Açılan sayfanın url'sinin "https://qa.mealscenter.com/privacy-policy" olduğu test edilir.
        expectedUrl = "https://qa.mealscenter.com/privacy-policy";
        actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
        extentTest.pass("Açılan sayfanın url'sinin \"https://qa.mealscenter.com/privacy-policy\" olduğu test edildi");

    }
}
