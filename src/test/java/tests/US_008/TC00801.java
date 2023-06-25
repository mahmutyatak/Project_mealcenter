package tests.US_008;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.userMealscenter.UserHomePage;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC00801 extends TestBaseRapor {

    @Test
    public void accessTermsAndConditionsPage(){

        UserHomePage userHomePage=new UserHomePage();

        Actions actions=new Actions(Driver.getDriver());

        extentTest=extentReports.createTest("Admin sayfasına erişim testi","Admin sayfasına geçerli bilgiler girilerek erişim sağlanabilmeli");


        //Sayfaya başarılı bir şekilde giriş yapılır.
        userHomePage.signInUserMethod();
        extentTest.info("User sayfasına Signin method'u ile giriş yapıldı");

        //End tuşu ile sayfanın footer bölümüne inilir.
        actions.sendKeys(Keys.END).build().perform();
        extentTest.info("End tuşu ile sayfanın alt kısmına inildi");

        //"Terms and Conditions" yazısının görüldüğü doğrulanır.
        Assert.assertTrue(userHomePage.termsandConditionsElementi.isDisplayed());
        extentTest.pass("User sayfasında Terms and Conditions linki görünürlüğü doğrulandı");

        //Sayfa Profil bilgisinin görüldüğü yere gitmek için home tuşuna tıklanır.
        actions.sendKeys(Keys.HOME).build().perform();
        extentTest.info("Home tuşuna tıklandı");

        userHomePage.logOutMethod();
        extentTest.info("Logout method'u ile başarılı bir şekilde sistemden çıkış yapıldı");
    }
}
