package tests.US_005;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.userMealscenter.UserHomePage;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC00504 extends TestBaseRapor {

    @DataProvider
    public static Object[][] testData(){

        String[][] negatifKullaniciBilgileri={{"asd","   "},{"team4hotmail.com","?"},{"   ","123"},{"?@mail.com","***"}};


        return negatifKullaniciBilgileri;
    }


    @Test(dataProvider = "testData")
    public void testNegatifLogin(String email,String password) {

        extentTest=extentReports.createTest("Negatif login testi","Geçersiz veri girişi ile giriş yapılamamalı");
        SoftAssert softAssert=new SoftAssert();
        Actions actions=new Actions(Driver.getDriver());

        ReusableMethods.bekle(3);
        UserHomePage userHomePage=new UserHomePage();
        //Browser açılır.
        //Kullanıcı "https://qa.mealscenter.com/account/login" sayfasına gider.
        Driver.getDriver().get("https://qa.mealscenter.com/account/login");
        extentTest.info("Login sayfasına gidildi");

        //Cookie'yi kabul eder.
        actions.click(userHomePage.acceptCookie).build().perform();
        extentTest.info("Cookie kabul edildi");

        //Email kutusuna  "geçersiz mail" mailini gönderir.
        actions.click(userHomePage.signInUsernameBox).sendKeys(email).build().perform();
        extentTest.info("Geçersiz mail girildi");

        //Password kutusuna "geçersiz şifre" gönderir.
        actions.click(userHomePage.signInPasswordBox).sendKeys(password).build().perform();
        ReusableMethods.wait(2);
        extentTest.info("Geçersiz password girildi");

        //"Sign in" butonuna tıklanır.
       actions.click( userHomePage.signInButonu).build().perform();
        ReusableMethods.wait(2);
        extentTest.info("Sign in butonuna tıklandı");

        //Giriş Yapılamadığı doğrulanır
        softAssert.assertTrue(userHomePage.signInUsernameBox.isEnabled());
        extentTest.pass("Girişyapılamadığı doğrulandı");

        softAssert.assertAll();
        //Sayfa kapatılır.
       Driver.closeDriver();


    }
}
