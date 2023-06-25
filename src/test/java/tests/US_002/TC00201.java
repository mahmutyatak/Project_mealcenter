package tests.US_002;

import org.testng.annotations.Test;
import pages.userMealscenter.UserHomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import static org.testng.AssertJUnit.assertTrue;

public class TC00201 extends TestBaseRapor {

    /*
    'qa.mealscenter.com' sayfasına gidilir
    Cookie kabul edilir
    "Teslimat adresi girin' menusune bir adres girilir (Seattle)
    "Teslimat adresi girin menusunun kullanilabilirligi test edilir
    HomePage header bolumundeki 'Meals Center', Sign in ve Card Menusu imajının
    kaybolmadigi (gorunurlugu) test edilir
    Sayfa Kapatilir
     */
    UserHomePage userHomePage=new UserHomePage();

        @Test
        public void test() {
             // Header bölümündeki menulerin görülebilir ve aktif ve oldugunu dogrulayin
             //  (Meal Center imaji, Sign in ve Card Menusu,"Hungry? We got you" yazisi)
            extentTest = extentReports.createTest("Header bolumunde bulunan menulerin gorunurluk testi", "Gorunurluk testi edildi");

            //HomePage sayfasina gidilir
            Driver.getDriver().get(ConfigReader.getProperty("mealCenterHomePageUrl"));
            extentTest.info("https://qa.mealscenter.com  ana sayfasına gidildi");

            // Cookie kabul edilir
            userHomePage.acceptCookie.click();
            extentTest.info("Cookies kabul edildi");

            // "Hungry? We got you" yazisinin gorunurlugu test edilir
            assertTrue(userHomePage.HungryTextYazisi.isEnabled());
            extentTest.pass("Hungry? We got you'' yazisinin gorunurlugu test edildi");

            // 'Meals Center'logosu görünürlügütest edilir
            assertTrue(userHomePage.mealsCenterLogo.isDisplayed());
            extentTest.pass("Meals Center'logosu görünürlügü test edildi");

            // 'Meals Center'logosu aktifligi tiklanabilirligi test edilir
            assertTrue(userHomePage.mealsCenterLogo.isEnabled());
            extentTest.pass("Meals Center'logosu tiklanabilirligi, aktifligi test edildi");
            userHomePage.mealsCenterLogo.click();

               // 'Sign in' menusu görünürlügü test edilir
            assertTrue(userHomePage.signInButonu.isDisplayed());
            extentTest.pass("Sign in menusu görünürlügü test edildi");

             //'Basket menusu  görünürlüğü test edilir
            assertTrue(userHomePage.cartButonu.isDisplayed());
            extentTest.pass("Basket menusunun görünürlügü test edildi");

            //  Sign in Butonuna tiklandiginda login sayfasinin acildigi test edilir
            userHomePage.signInButonu.click();
            String expectedIcerik="login";
            String actualIcerik=Driver.getDriver().getCurrentUrl();
            assertTrue(actualIcerik.contains(expectedIcerik));
            extentTest.pass("Sign in butonun görünürlügü test edildi");
            // Sayfa kapatilir
            Driver.getDriver().close();

        }


    }





