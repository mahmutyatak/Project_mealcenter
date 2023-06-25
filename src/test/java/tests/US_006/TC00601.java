package tests.US_006;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.userMealscenter.UserHomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC00601 extends TestBaseRapor {

    //Kullanıcının siteye kayıt olması icin "sign up"butonu aktif olamlıdır.

    //Kayıt formunda bulunan bolumler erisilebilir ve doldurabilir olmalı
    //Kayıt islemi icin kullanılan isim,soyisim,email,password ve tel no kurallara uygun girilmelidir.
    //Kullanıcının kayıt tamamlaması yapabilmesi icin "sign up" butonu aktif olmalıdır.
UserHomePage userHomePage=new UserHomePage();
    @Test
    public void test01(){
        userHomePage=new UserHomePage();
        //Kullanıcının siteye kayıt olması icin "sign up"butonu aktif olamlıdır.
        extentTest=extentReports.createTest("Sing up buton testi","Pozitif sign up buton testi yapildi");

        //Kullanıcı "https://qa.mealscenter.com" sayfasına gider.
        Driver.getDriver().get(ConfigReader.getProperty("mealCenterHomePageUrl"));
        extentTest.info("https://qa.mealscenter.com  ana sayfasına gidildi");
        //Kullanıcı sign in butonuna tıklar
        userHomePage.signInButonu.click();
        extentTest.info("sign in butonuna tiklandi");

        //Kullanıcı sign up butonuna tıklar.
        userHomePage.singUpButton.click();
        extentTest.info("sign up butonuna tiklandi");

        String expectedIcerik="signup";
        String actualIcerik=Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualIcerik.contains(expectedIcerik));
        extentTest.pass("Sin up butonu aktifligi testi yapildi");
        Driver.closeDriver();
    }
}
