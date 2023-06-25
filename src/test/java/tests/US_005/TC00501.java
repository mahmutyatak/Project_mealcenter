package tests.US_005;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.userMealscenter.UserHomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC00501 extends TestBaseRapor {


    @Test
    public void testLoginPage(){

        extentTest=extentReports.createTest("Meals center login sayfası erişim testi","Meals center login sayfasındaki fonksiyonların görünürlüğü doğrulanmalı");

        UserHomePage userHomePage=new UserHomePage();

        SoftAssert softAssert=new SoftAssert();

        Actions actions=new Actions(Driver.getDriver());

        //Browser açılır.
        //Kullanıcı "https://qa.mealscenter.com/" sayfasına gider.
        Driver.getDriver().get(ConfigReader.getProperty("mealCenterHomePageUrl"));
        extentTest.info("Meals center login sayfası açıldı");

        //Cookie'yi kabul eder.
        userHomePage.acceptCookie.click();
        extentTest.info("Cookie kabul edildi");

        //Sign in butonuna tıklanır.
        userHomePage.signInButonu.click();
        extentTest.info("Sign in butonuna tıklandı");

        //Email kutusunun görünürlüğünü doğrular.
        softAssert.assertTrue(userHomePage.signInUsernameBox.isDisplayed(),"Meals center login sayfasında email kutusu gözükmüyor...");
        extentTest.pass("Meals center login sayfasında email kutusunun görünürlüğü doğrulandı");

        //Password kutusunun görünürlüğünü doğrular.
        softAssert.assertTrue(userHomePage.signInPasswordBox.isDisplayed(),"Meals center login sayfasında password kutusu gözükmüyor...");
        extentTest.pass("Meals center login sayfasında password kutusunun görünürlüğü doğrulandı");

        softAssert.assertAll();
        //sayfa kapatılır
        Driver.closeDriver();
        extentTest.info("closeDriver method'u ile sayfa kapatıldı");



    }

}
