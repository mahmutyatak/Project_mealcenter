package tests.US_006;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.userMealscenter.UserHomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC00602 extends TestBaseRapor {
    //Siteye kayıt olabilmek için kullanıcı adı,
    // e-posta adresi ve parola gibi temel bilgilerin girilebileceği bir kayıt formu mevcut olmalı
    UserHomePage userHomePage=new UserHomePage();
    @Test
    public void test01(){
        userHomePage=new UserHomePage();
    extentTest=extentReports.createTest("Sing up formu testi","Pozitif sign up formu testi yapildi");

    //Kullanıcı "https://qa.mealscenter.com" sayfasına gider.
    Driver.getDriver().get(ConfigReader.getProperty("mealCenterHomePageUrl"));
    extentTest.info("https://qa.mealscenter.com  ana sayfasına gidildi");
    //Kullanıcı sign in butonuna tıklar
    userHomePage.signInButonu.click();
    extentTest.info("sign in butonuna tiklandi");

    //Kullanıcı sign up butonuna tıklar.
    userHomePage.singUpButton.click();
    extentTest.info("sign up butonuna tiklandi");

        Assert.assertTrue(userHomePage.signUpForm.isDisplayed());
        extentTest.pass("Siteye kayıt olabilmek için kullanıcı adı,e-posta adresi ve parola gibi temel bilgilerin girilebileceği bir kayıt formu oldugu testi yapidi.");
        Driver.closeDriver();
}
}
