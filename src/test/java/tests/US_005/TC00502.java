package tests.US_005;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.userMealscenter.UserHomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC00502 extends TestBaseRapor {

    @Test
    public void testSuccessLogin() {

        extentTest = extentReports.createTest("User anasayfaya erişim testi","User anasayfaya erişim sağlayabilmeli");

        UserHomePage userHomePage=new UserHomePage();
        SoftAssert softAssert=new SoftAssert();

        //Browser açılır.
        //Url kısmına "https://qa.mealscenter.com/" sayfasına gider.
        Driver.getDriver().get(ConfigReader.getProperty("mealCenterHomePageUrl"));
        extentTest.info("Meals Center anasayfası açıldı");

        //Cookie'yi kabul eder.
        userHomePage.acceptCookie.click();
        extentTest.info("Cookie kabul edildi");

        //"https://qa.mealscenter.com/account/login" sayfası açılır.
        Driver.getDriver().get(ConfigReader.getProperty("mealCenterLoginPage"));
        extentTest.info("Login sayfası açıldı");

        //Açılan sayfada ;
        //Email kutusuna  "team4@hotmail.com" mailini gönderir.
        userHomePage.signInUsernameBox.sendKeys(ConfigReader.getProperty("singUpGecerliEmail"));
        extentTest.info("Geçerli email girildi");

        //Password kutusuna geçer.
        //Password kutusuna "team4***" gönderir.
        userHomePage.signInPasswordBox.sendKeys(ConfigReader.getProperty("singUpGecerliSfre"));
        extentTest.info("Geçerli password girildi");

        //"Sign in" butonuna tıklanır.
        userHomePage.signIn.click();
        extentTest.info("SignIn butonuna tıklandı");
        ReusableMethods.wait(2);

        //Assert sınıfını kullanarak kullanıcının doğru şekilde giriş yaptığını doğrular.
        String expectedTitle="Meals Center";
        String actualTitle=Driver.getDriver().getTitle();
        softAssert.assertEquals(actualTitle,expectedTitle,"Kullanıcı giriş yapamadı");
        extentTest.pass("kullanıcı doğru şekilde giriş yaptı");

        //Kullanıcının isminin sayfada görüntülendiğini kontrol eder.
        String expectedProfilName="teamdort";
        String actualProfilName=userHomePage.profilButton.getText();
        softAssert.assertEquals(actualProfilName,expectedProfilName,"Kullanıcı ismi gözükmüyor...");
        extentTest.pass("Kullanıcının ismi sayfada görüntülendi");

        //Kullanıcı profiline tıklar
        userHomePage.profilButton.click();
        extentTest.info("Kullanıcı profiline tıklandı");
        ReusableMethods.wait(2);

        //Açılan dropdown menudeki "Logout" butonuna tıklar
        userHomePage.logOutButton.click();
        extentTest.info("Logout butonuna tıklandı");


    }

}
