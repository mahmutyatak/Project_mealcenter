package tests.US_003;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC00308 extends TestBaseRapor {


    @DataProvider
    public Object[][] testData() {
        return new Object[][] {
                {"chrome"},
                {"firefox"}

        };
    }

    public WebDriver driver;

    @Test (dataProvider = "testData")

    public void test01(String browser) {

        extentTest = extentReports.createTest("Meals Center Home Page'e farkli browserlardan erisim testi", "Meals Center Home Page sayfasina firefox,chrome,edge ile erisim saglanabilmeli");

        Driver.getDriver(browser).get(ConfigReader.getProperty("mealCenterHomePageUrl"));
        extentTest.info("Mealscenter Home Page'e  gidildi");

        ReusableMethods.bekle(5);
        String expectedTitle="Meals Center";
        String actualTitle=Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
        extentTest.pass("Meals Center Home Page title dogrulandi");

        Driver.closeDriver();

    }
}
