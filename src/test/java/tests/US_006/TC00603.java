package tests.US_006;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.userMealscenter.UserHomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC00603 extends TestBaseRapor {


    UserHomePage userHomePage = new UserHomePage();

    @Test
    public void test01() {
        userHomePage=new UserHomePage();
        //Kayıt formunda bulunan bolumler erisilebilir ve doldurabilir olmalı
        extentTest = extentReports.createTest("Sing up formu ulasilabilme testi", "Pozitif sign up formu ulasilabilme testi yapildi");

        //Kullanıcı "https://qa.mealscenter.com" sayfasına gider.
        Driver.getDriver().get(ConfigReader.getProperty("mealCenterHomePageUrl"));
        extentTest.info("https://qa.mealscenter.com  ana sayfasına gidildi");
        //Kullanıcı sign in butonuna tıklar
        userHomePage.signInButonu.click();
        extentTest.info("sign in butonuna tiklandi");

        //Kullanıcı sign up butonuna tıklar.
        userHomePage.singUpButton.click();
        extentTest.info("sign up butonuna tiklandi");

        //Kullanıcı isim bolumune tıklar
        userHomePage.singUpName.sendKeys(ConfigReader.getProperty("singUpGecerliFirstName"));
        extentTest.info("isim bolumune tiklandi");

        //Kullanıcı soyisim bolumune tıklar
        userHomePage.singUpSoyisim.sendKeys("singUpGecerliLastName");
        extentTest.info("soyisim bolumune tiklandi");

        //Kullanıcı email bolumune tıklar
        userHomePage.singUpEmail.sendKeys(ConfigReader.getProperty("singUpGecerliEmail"));
        extentTest.info("email bolumune tiklandi");
        //Kullanıcı telefon bolumune tıklar
        userHomePage.singUpTelefon.sendKeys(ConfigReader.getProperty("singUpGecerliTelefon"));
        extentTest.info("telefon bolumune tiklanir");

        //Kullanıcı sifre bolumune tıklar
        userHomePage.singUpsifre.sendKeys(ConfigReader.getProperty("singUpGecerliSfre"));
        extentTest.info("sifre bolumune tiklandi");

        //Kullanıcı ikinic sifre bolumune tıklar
        userHomePage.singUpIkinciSifre.sendKeys(ConfigReader.getProperty("singUpGecerliSfre"));
        extentTest.info("ikinci sifre bolumune tiklanir");

        Assert.assertTrue(userHomePage.signUpKayitButton.isEnabled());
        extentTest.pass("tum bolumlere ulasma testi yapildi");

        Driver.closeDriver();

    }
}
