package tests.US_006;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.userMealscenter.UserHomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC00604 extends TestBaseRapor {

    UserHomePage userHomePage = new UserHomePage();

    @Test
    public void test01() {
        userHomePage=new UserHomePage();
        //Kayıt islemi icin kullanılan isim,soyisim,email,password ve tel no kurallara uygun girilmelidir.
        extentTest = extentReports.createTest("Sing up formu yanlis isim testi", "Negatif sign up formu isim testi yapildi");

        //Kullanıcı "https://qa.mealscenter.com" sayfasına gider.
        Driver.getDriver().get(ConfigReader.getProperty("mealCenterHomePageUrl"));
        extentTest.info("https://qa.mealscenter.com  ana sayfasına gidildi");
        //Kullanıcı sign in butonuna tıklar
        userHomePage.signInButonu.click();
        extentTest.info("sign in butonuna tiklandi");

        //Kullanıcı sign up butonuna tıklar.
        userHomePage.singUpButton.click();
        extentTest.info("sign up butonuna tiklandi");

        //Kullanıcı isim bolumune gecersiz isim gonderir.
        userHomePage.singUpName.sendKeys(ConfigReader.getProperty("singUpGecersizFirstName"));
        extentTest.info("isim bolumune gecersiz isim gonderildi");

        //Kullanıcı soyisim bolumune gecerli soyisim gonderir
        userHomePage.singUpSoyisim.sendKeys("singUpGecerliLastName");
        extentTest.info("soyisim bolumune gecerli soyisim gonderildi");

        //Kullanıcı email bolumune gecerli email gonderir
        userHomePage.singUpEmail.sendKeys(ConfigReader.getProperty("singUpGecerliEmail"));
        extentTest.info("email bolumune gecerli email gonderildi");
        //Kullanıcı telefon bolumune gecerli telefon gonderir
        userHomePage.singUpTelefon.sendKeys(ConfigReader.getProperty("singUpGecerliTelefon"));
        extentTest.info("telefon bolumune  gecerli telefon gonderildi");

        //Kullanıcı sifre bolumune gecerli sifre gonderir
        userHomePage.singUpsifre.sendKeys(ConfigReader.getProperty("singUpGecerliSfre"));
        extentTest.info("sifre bolumune gecerli sifre gonderildi");

        //Kullanıcı ikinic sifre bolumune gecerli ikinci sifre gonderir
        userHomePage.singUpIkinciSifre.sendKeys(ConfigReader.getProperty("singUpGecerliSfre"));
        extentTest.info("ikinci sifre bolumune gecerli ikinci sifre gonderildi");

        //Kullanıcı sign up butonuna tiklanir.
        userHomePage.signUpKayitButton.click();
        extentTest.info("sign up kayit butonuna tiklandi");

        Assert.assertTrue(userHomePage.signUpKayitButton.isEnabled());
        extentTest.pass("gecersiz isim bilgisi ile siteye girilememe testi yapildi");
        ReusableMethods.wait(2);

        Driver.closeDriver();
    }
}
