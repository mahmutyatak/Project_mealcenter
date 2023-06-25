package tests.US_006;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.userMealscenter.UserHomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC00607 extends TestBaseRapor {

    UserHomePage userHomePage = new UserHomePage();

    @Test
    public void test01() {
        userHomePage=new UserHomePage();
        //Kayıt islemi icin kullanılan isim,soyisim,email,password ve tel no kurallara uygun girilmelidir.
        extentTest = extentReports.createTest("Sing up formu yanlis telefon testi", "Negatif sign up formu telefon testi yapildi");

        //Kullanıcı "https://qa.mealscenter.com" sayfasına gider.
        Driver.getDriver().get(ConfigReader.getProperty("mealCenterHomePageUrl"));
        extentTest.info("https://qa.mealscenter.com  ana sayfasına gidildi");
        //Kullanıcı sign in butonuna tıklar
        userHomePage.signInButonu.click();
        extentTest.info("sign in butonuna tiklandi");

        //Kullanıcı sign up butonuna tıklar.
        userHomePage.singUpButton.click();
        extentTest.info("sign up butonuna tiklandi");

        //Kullanıcı isim bolumune gecerli isim gonderir.
        userHomePage.singUpName.sendKeys(ConfigReader.getProperty("singUpGecerliFirstName"));
        extentTest.info("isim bolumune gecerli isim gonderildi");

        //Kullanıcı soyisim bolumune gecerli soyisim gonderir
        userHomePage.singUpSoyisim.sendKeys(ConfigReader.getProperty("singUpGecerliLastName"));
        extentTest.info("soyisim bolumune gecerli soyisim gonderildi");

        //Kullanıcı email bolumune gecerli email gonderir
        userHomePage.singUpEmail.sendKeys(ConfigReader.getProperty("singUpGecerliEmail"));
        extentTest.info("email bolumune gecerli email1 gonderildi");
        //Kullanıcı telefon bolumune gecersiz telefon1 gonderir
        userHomePage.singUpTelefon.sendKeys(ConfigReader.getProperty("singUpGecersizTelefon1"));
        extentTest.info("telefon bolumune  gecersiz telefon gonderildi");

        //Kullanıcı sifre bolumune gecerli sifre gonderir
        userHomePage.singUpsifre.sendKeys(ConfigReader.getProperty("singUpGecerliSfre"));
        extentTest.info("sifre bolumune gecerli sifre gonderildi");

        //Kullanıcı ikinic sifre bolumune gecerli ikinci sifre gonderir
        userHomePage.singUpIkinciSifre.sendKeys(ConfigReader.getProperty("singUpGecerliSfre"));
        extentTest.info("ikinci sifre bolumune gecerli ikinci sifre gonderildi");



        Assert.assertFalse(userHomePage.signUpKayitButton.isEnabled());
        extentTest.pass("gecersiz telefon1 bilgisi ile siteye girilememe testi yapildi");
        ReusableMethods.wait(2);
    }
    @Test
    public void test02(){
        userHomePage=new UserHomePage();
        Actions actions=new Actions(Driver.getDriver());
        actions.click(userHomePage.singUpTelefon).keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).
                sendKeys(Keys.BACK_SPACE).perform();
        ReusableMethods.wait(2);

        //Kullanıcı telefon bolumune gecersiz telefon2 gonderir
        userHomePage.singUpTelefon.sendKeys(ConfigReader.getProperty("singUpGecersizTelefon2"));
        extentTest.info("telefon bolumune gecersiz telefon2 gonderildi");

        //Kullanıcı sign up butonuna tiklanir.
        userHomePage.signUpKayitButton.click();
        extentTest.info("sign up kayit butonuna tiklandi");

        Assert.assertTrue(userHomePage.signUpKayitButton.isEnabled());
        extentTest.pass("gecersiz telefon2 bilgisi ile siteye girilememe testi yapildi");
        ReusableMethods.wait(2);
        Driver.closeDriver();
    }
}
