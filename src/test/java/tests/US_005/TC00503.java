package tests.US_005;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.userMealscenter.UserHomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC00503 extends TestBaseRapor {

    @Test
    public void testLoginFunctionality(){

        extentTest = extentReports.createTest("User Login sayfası fonksiyon çalıştırma testi","User login sayfasındaki fonksiyonları çalıştırabilmeli");

        UserHomePage userHomePage=new UserHomePage();
        Actions actions=new Actions(Driver.getDriver());
        SoftAssert softAssert=new SoftAssert();

        //Browser açılır.
        //Kullanıcı "https://qa.mealscenter.com/account/login " sayfasına gider.
        Driver.getDriver().get(ConfigReader.getProperty("mealCenterLoginPage"));
        extentTest.info("Kullanıcı Login sayfasına gidildi");

        //Cookie'yi kabul eder.
        actions.click(userHomePage.acceptCookie).build().perform();
        extentTest.info("Cookie kabul edildi");

        //İlk Window Handle değeri alınır
        String ilkWHD=Driver.getDriver().getWindowHandle();
        extentTest.info("İlk WHD alındı");

        //Email kutusuna mail girilir
        actions.click(userHomePage.signInUsernameBox).sendKeys("team4@hotmail.com").build().perform();
        extentTest.info("Email kutusuna mail girildi");

        //Password kutusuna şifre girer
        actions.click(userHomePage.signInPasswordBox).sendKeys("1234567").build().perform();
        extentTest.info("Password kutusuna şifre girildi");

        //Şifrenin görünmediğini doğrular
        softAssert.assertEquals(userHomePage.signInPasswordBox.getAttribute("type"), "password");
        extentTest.pass("Şifrenin görünmediği doğrulandı");

        //Password kutusunun yanındaki göze tıklar.
        actions.click(userHomePage.incelemeButton).build().perform();
        ReusableMethods.wait(2);
        extentTest.info("Password kutusunun yanındaki göze tıklandı");

        //Şifrenin göründüğü doğrular
        softAssert.assertEquals(userHomePage.signInPasswordBox.getAttribute("type"), "text","inceleme butonu çalışmıyor");
        extentTest.pass("Password kutusundaki Göz butonunun çalıştığı doğrulandı ");

        //"Forgot password? " tıklar
        actions.click(userHomePage.forgotPasswordButton).build().perform();
        extentTest.info("Forgot password? a tıklandı");

        //"Forgot password? " 'e tıklayınca "https://qa.mealscenter.com/account/forgot_pass" sayfasına yönlendirdiğini dogrular
        String expectedUrl="https://qa.mealscenter.com/account/forgot_pass";
        String actualUrl=Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualUrl,expectedUrl,"Forgot Password sayfasına yönlendirmiyor...");
        ReusableMethods.wait(2);
        extentTest.pass("İlgili sayfaya yönlendirildiği doğrulandı");

        //Login sayfasına geri döner
        Driver.getDriver().navigate().back();
        ReusableMethods.wait(2);
        extentTest.info("Login sayfasına dönüldü");

        //"Sign Up" butonuna tıklar
        actions.click(userHomePage.singUpButton).build().perform();
        extentTest.info("Sign Up a tıklandı");

        //"https://qa.mealscenter.com/account/signup?redirect= " sayfasına yönlendirildigini doğrular
        expectedUrl="https://qa.mealscenter.com/account/signup?redirect=";
        actualUrl=Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualUrl,expectedUrl);
        extentTest.pass("İlgili sayfaya yönlendirildiği doğrulandı");

        //Sayfa kapatılır.
        softAssert.assertAll();
    }
}
