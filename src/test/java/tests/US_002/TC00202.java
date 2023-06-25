package tests.US_002;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.userMealscenter.UserHomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import static org.testng.AssertJUnit.assertTrue;


public class TC00202 extends TestBaseRapor {

    /*
    'qa.mealscenter.com' sayfasına gidilir
    Cookie kabul edilir
    "Teslimat adresi girin' menusune bir adres girilir (Seattle)
    "Teslimat adresi girin menusunun kullanilabilirligi test edilir
    HomePage header bolumundeki 'Meals Center', Sign in ve Card Menusu imajının
    kaybolmadigi (gorunurlugu) test edilir
    Sayfa Kapatilir
     */
    UserHomePage userHomePage = new UserHomePage();

    @Test
    public void test01() {
        //Header bölümündeki herhangi bir fonksiyon,
        // sayfada herhangi bir konumdayken her zaman görülebilir oldugunu dogrulayin
        //(Meal Center imaji, Sign in ve Card Menusu,"Hungry? We got you" yazisi)
        extentTest = extentReports.createTest
       ("Header menulerin herhangi bir fonksiyonda iken gorunurluk testi", "Gorunurluk testi edildi");

        // HomePage sayfasina gidilir
        Driver.getDriver().get(ConfigReader.getProperty("mealCenterHomePageUrl"));
        extentTest.info("https://qa.mealscenter.com  ana sayfasına gidildi");

        // Cookie kabul edilir
        userHomePage.acceptCookie.click();
        extentTest.info("Cookies kabul edildi");

        // Adress Search menusu tiklanir
        userHomePage.adressSearchButonu.click();
        extentTest.info("Adres Search menusu tiklandi");

        // "Seattle" yazilir
        userHomePage.adressSearchButonu.sendKeys("Seattle");
        extentTest.info("Adrese Seattle yazildi");
        ReusableMethods.wait(2);

        // "Seattle adresi secilir
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();
        extentTest.info("Adres 'Seattle' oldugu test edildi");

        // Adresin "Seattle" secildigi  dogdurulanir
        Assert.assertTrue(userHomePage.adressSearchButonu.isDisplayed());
        extentTest.pass("Adresin 'Seattle' oldugu test edildi");

        // Meal Center logosunun kaybolmadigi(gorunurlugu) test edilir
        assertTrue(userHomePage.mealsCenterLogo.isDisplayed());
        extentTest.pass("Meal Center logosunun kaybolmadigi(gorunurlugu) test edildi");

       //  Sign in logosunun kaybolmadigi(gorunurlugu) test edilir
        assertTrue(userHomePage.signInButonu.isDisplayed());
        extentTest.pass("Sign in logosunun kaybolmadigi(gorunurlugu) test edildi");
      ReusableMethods.bekle(2);
      //  Card logosunun kaybolmadigi(gorunurlugu) test edilir
        assertTrue(userHomePage.cartButonu.isDisplayed());
        extentTest.pass("Card logosunun kaybolmadigi(gorunurlugu) test edildi");

        // Sayfa kapatilir
        Driver.getDriver().close();
        extentTest.info("Sayfa kapatildi");
    }
}

