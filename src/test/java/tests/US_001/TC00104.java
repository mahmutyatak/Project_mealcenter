package tests.US_001;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.userMealscenter.UserHomePage;
import utilities.*;

public class TC00104 extends TestBaseRapor {

    UserHomePage userHomePage;

    @Test (priority = 1)
    public void mealsCenterLogoTest() {
        UserHomePage userHomePage=new UserHomePage();
        extentTest = extentReports.createTest("Meals Center Home Page link testi", "Meals Center Home Page sayfasinda ki linklere erisim saglanabilmeli");

        //Browser acilir
        //Url'e gidilir
        //https://qa.mealscenter.com
        Driver.getDriver().get(ConfigReader.getProperty("mealCenterHomePageUrl"));
        extentTest.info("Mealscenter Home Page'e  gidildi");
        ReusableMethods.bekle(2);

        //Acilan sayfada header bolumundeki  Meals Center logosunun erisilebilir oldugu kontrol edilir
        Assert.assertTrue(userHomePage.mealsCenterLogo.isEnabled());
        extentTest.pass("Meals Center Home Page header bolumundeki Meals Center logosunun erisilebilir oldugu dogrulandi");


    }

    @Test(priority = 2)
    public void searchBoxLogoTest() {
        UserHomePage userHomePage=new UserHomePage();
        extentTest = extentReports.createTest("Meals Center Home Page link testi", "Meals Center Home Page sayfasinda ki linklere erisim saglanabilmeli");

        //Browser acilir
        //Url'e gidilir
        //https://qa.mealscenter.com
        Driver.getDriver().get(ConfigReader.getProperty("mealCenterHomePageUrl"));
        extentTest.info("Mealscenter Home Page'e  gidildi");
        ReusableMethods.bekle(5);
        //Acilan sayfada header bolumundeki  arama kutusunun  erisilebilir oldugu kontrol edilir
        Assert.assertTrue(userHomePage.adressSearchButonu.isEnabled());
        extentTest.pass("Meals Center Home Page header bolumundeki arama kutusunun erisilebilir oldugu dogrulandi");



    }

    @Test(priority = 3)
    public void mealsCenterLinkTest() {
        UserHomePage userHomePage=new UserHomePage();
        extentTest = extentReports.createTest("Meals Center Home Page link testi", "Meals Center Home Page sayfasinda ki linklere erisim saglanabilmeli");

        //Browser acilir
        //Url'e gidilir
        //https://qa.mealscenter.com
        Driver.getDriver().get(ConfigReader.getProperty("mealCenterHomePageUrl"));
        extentTest.info("Mealscenter Home Page'e  gidildi");
        ReusableMethods.bekle(2);
        userHomePage.acceptCookie.click();
        //Acilan sayfada footer bolumundeki  meals center linkinin  erisilebilir oldugu kontrol edilir
        JSUtils.scrollDownByJS();
        Assert.assertTrue(userHomePage.mealscenterLinkElementi.isEnabled());
        extentTest.pass("Meals Center Home Page footer bolumundeki meals center linkinin erisilebilir oldugu dogrulandi");

        //Sayfa kapatilir
        Driver.closeDriver();

    }

}