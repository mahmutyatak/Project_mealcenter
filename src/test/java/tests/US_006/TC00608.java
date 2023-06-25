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

public class TC00608 extends TestBaseRapor {
    UserHomePage userHomePage = new UserHomePage();

    @Test(groups = "demo")
    public void test01() {
        userHomePage=new UserHomePage();
        //Kayıt islemi icin kullanılan isim,soyisim,email,password ve tel no kurallara uygun girilmelidir.
        extentTest = extentReports.createTest("Sing up formu yanlis sifre testi", "Negatif sign up formu sifre testi yapildi");

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
        //Kullanıcı telefon bolumune gecerli telefon gonderir
        userHomePage.singUpTelefon.sendKeys(ConfigReader.getProperty("singUpGecerliTelefon"));
        extentTest.info("telefon bolumune gecerli telefon gonderildi");

        //Kullanıcı sifre bolumune gecersiz sifre1 gonderir
        userHomePage.singUpsifre.sendKeys(ConfigReader.getProperty("singUpGecersizsifre1"));
        extentTest.info("sifre bolumune gecersiz sifre1 gonderildi");

        //Kullanıcı ikinic sifre bolumune gecerli ikinci sifre gonderir
        userHomePage.singUpIkinciSifre.sendKeys(ConfigReader.getProperty("singUpGecerliSfre"));
        extentTest.info("ikinci sifre bolumune gecerli ikinci sifre gonderildi");

        //Kullanıcı sign up butonuna tiklanir.
        userHomePage.signUpKayitButton.click();
        extentTest.info("sign up kayit butonuna tiklandi");

        Assert.assertTrue(userHomePage.signUpKayitButton.isEnabled());
        extentTest.pass("gecersiz sifre1 bilgisi ile siteye girilememe testi yapildi");
        ReusableMethods.wait(2);
    }
    @Test(groups = "demo")
    public void test02(){
        userHomePage=new UserHomePage();
        Actions actions=new Actions(Driver.getDriver());
        actions.click(userHomePage.singUpsifre).keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).
                sendKeys(Keys.BACK_SPACE).perform();
        ReusableMethods.wait(2);

        //Kullanıcı sifre bolumune gecersiz sifre2 gonderir
        userHomePage.singUpsifre.sendKeys(ConfigReader.getProperty("singUpGecersizsifre2"));
        extentTest.info("telefon bolumune gecersiz sifre2 gonderildi");

        //Kullanıcı sign up butonuna tiklanir.
        userHomePage.signUpKayitButton.click();
        extentTest.info("sign up kayit butonuna tiklandi");

        Assert.assertTrue(userHomePage.signUpKayitButton.isEnabled());
        extentTest.pass("gecersiz sifre2 bilgisi ile siteye girilememe testi yapildi");
        ReusableMethods.wait(2);

    }
    @Test(groups = "demo")
    public void test03(){
        userHomePage=new UserHomePage();
        Actions actions=new Actions(Driver.getDriver());
        actions.click(userHomePage.singUpsifre).keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).
                sendKeys(Keys.BACK_SPACE).perform();
        ReusableMethods.wait(2);

        //Kullanıcı sifre bolumune gecersiz sifre3 gonderir
        userHomePage.singUpsifre.sendKeys(ConfigReader.getProperty("singUpGecersizsifre3"));
        extentTest.info("telefon bolumune gecersiz sifre3 gonderildi");

        //Kullanıcı sign up butonuna tiklanir.
        userHomePage.signUpKayitButton.click();
        extentTest.info("sign up kayit butonuna tiklandi");

        Assert.assertTrue(userHomePage.signUpKayitButton.isEnabled());
        extentTest.pass("gecersiz sifre3 bilgisi ile siteye girilememe testi yapildi");
        ReusableMethods.wait(2);

    }
    @Test(groups = "demo")
    public void test04(){
        userHomePage=new UserHomePage();
        Actions actions=new Actions(Driver.getDriver());
        actions.click(userHomePage.singUpsifre).keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).
                sendKeys(Keys.BACK_SPACE).perform();
        ReusableMethods.wait(2);

        //Kullanıcı sifre bolumune gecersiz sifre4 gonderir
        userHomePage.singUpsifre.sendKeys(ConfigReader.getProperty("singUpGecersizsifre4"));
        extentTest.info("telefon bolumune gecersiz sifre4 gonderildi");

        //Kullanıcı sign up butonuna tiklanir.
        userHomePage.signUpKayitButton.click();
        extentTest.info("sign up kayit butonuna tiklandi");

        Assert.assertTrue(userHomePage.signUpKayitButton.isEnabled());
        extentTest.pass("gecersiz sifre4 bilgisi ile siteye girilememe testi yapildi");
        ReusableMethods.wait(2);


    }
    @Test(groups = "demo")
    public void test05(){
        userHomePage=new UserHomePage();
        userHomePage=new UserHomePage();
        String expectedIcerik=userHomePage.singUpsifre.getAttribute("type");
        userHomePage.gozIsaretiKayit.click();
        extentTest.info("Goz isaretine tiklandi");
        String actualIcerik=userHomePage.singUpsifre.getAttribute("type");
        Assert.assertNotEquals(actualIcerik,expectedIcerik);;
        extentTest.pass("Password kutusundaki Göz butonunun çalıştığı doğrulandı ");
        Driver.closeDriver();
    }

}
