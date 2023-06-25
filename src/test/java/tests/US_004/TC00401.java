package tests.US_004;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.userMealscenter.UserHomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.awt.image.Kernel;

public class TC00401 extends TestBaseRapor {

    @Test
    public void test01(){
        extentTest = extentReports.createTest("https://qa.mealscenter.com/' gidilmeli Footer bölümünün sayfanın en altında yer aldıgı ve görünür olduğu kontrol edilmelidir");

        UserHomePage userHomePage = new UserHomePage();

        //"https://qa.mealscenter.com/" adresine gidilir.
        Driver.getDriver().get(ConfigReader.getProperty("mealCenterHomePageUrl"));
        extentTest.info("\"https://qa.mealscenter.com/\" adresine gidildi");

        //Sayfanın en altına inilir.
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.END).perform();
        extentTest.info("Sayfanın en altına inildi");

        //Footer bölümünün görünür olduğu test edilir
        Assert.assertTrue(userHomePage.footer.isDisplayed());
        extentTest.pass("Footer bölümünün görünür olduğu test edildi");

    }
}
