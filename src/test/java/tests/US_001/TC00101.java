package tests.US_001;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.userMealscenter.UserHomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC00101 extends TestBaseRapor {


    UserHomePage userHomePage=new UserHomePage();
    @Test
    public void TC_00101_accessHomePage() {

        extentTest = extentReports.createTest("Meals Center Home Page erisim testi", "Meals Center Home Page sayfasina erisim saglanabilmeli");


            //Browser açılır.
            //Url kısmına "https://https://qa.mealscenter.com/" yazılır ve tıklanır.
            Driver.getDriver().get(ConfigReader.getProperty("mealCenterHomePageUrl"));
            extentTest.info("Mealscenter Home Page'e  gidildi");


        //Sayfanin Url'inin  "https://qa.mealscenter.com/" oldugu dogrulanir
        String actualUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(ConfigReader.getProperty("mealCenterHomePageUrl")));
        extentTest.pass("Meals Center Home Page Url dogrulandi");



            //Sayfa kapatılır.
            Driver.closeDriver();

    }

    }




