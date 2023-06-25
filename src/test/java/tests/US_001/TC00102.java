package tests.US_001;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.userMealscenter.UserHomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC00102 extends TestBaseRapor {

    UserHomePage userHomePage=new UserHomePage();

    @Test
    public void TC_00102_verifyHomePageTitle(){



        extentTest=extentReports.createTest("Meals Center Home Page Title testi","Meals Center Home Page sayfasinin title'inin Meals Center oldugu dogrulanabilmeli");


        //Browser açılır.
        //Url kısmına "https://https://qa.mealscenter.com/" yazılır ve tıklanır.
        Driver.getDriver().get(ConfigReader.getProperty("mealCenterHomePageUrl"));
        extentTest.info("Mealscenter Home Page'e  gidildi");

        //Sayfanin title'inin "Meals Center" oldugu dogrulanir
        String expectedTitle="Meals Center";
        String actualTitle=Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
        extentTest.pass("Meals Center Home Page title dogrulandi");


        //Sayfa kapatılır.
       Driver.closeDriver();
    }
}
