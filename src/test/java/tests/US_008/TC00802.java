package tests.US_008;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.userMealscenter.UserHomePage;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC00802 extends TestBaseRapor {

    @Test
    public void testTermsAndConditions(){

        UserHomePage userHomePage=new UserHomePage();

        Actions actions=new Actions(Driver.getDriver());

        SoftAssert softAssert=new SoftAssert();

        extentTest=extentReports.createTest("İade ve ödeme koşullarına erişim testi","Terms ve Conditions bilgilerine erişim sağlanabilmeli");

        //Sayfaya başarılı bir şekilde giriş yapılır.
        userHomePage.signInUserMethod();
        extentTest.info("User sayfasına Signin method'u ile giriş yapıldı");

        //"End" tuşuna basarak sayfanın footer bölümüne inilir.
        actions.sendKeys(Keys.END).build().perform();
        extentTest.info("End tuşu ile sayfanın footer bölümüne inildi");

        //"terms-and-conditions" bağlantısının mevcut olduğunu doğrulanır.
        softAssert.assertTrue(userHomePage.termsandConditionsElementi.isEnabled());
        extentTest.pass("terms-and-conditions bağlantısının mevcut olduğu doğrulandı");

        //"Terms and Conditions" bölümüne tıklanır.
        ReusableMethods.wait(2);
        userHomePage.termsandConditionsElementi.click();
        extentTest.info("Terms and Conditions bağlantısına tıklandı");

        // "https://qa.mealscenter.com/terms-and-conditions" sayfasına yönlendirildiği doğrulanır.
        String expectedUrl="https://qa.mealscenter.com/terms-and-conditions";
        String actualUrl=Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualUrl,expectedUrl,"Terms ve Conditions sayfasına erişilemedi");
        extentTest.pass("Terms ve Conditions sayfasına yönlendirildiği doğrulandı");

        //"pagedown" tuşuna basılır.
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        extentTest.info("Pagedown tuşu ile sayfa aşağı kaydırıldı");

        //Body'deki "Orders and Payment" başlığı altındaki iade koşullarının "By placing an order through the Application, you agree to our cancellation policy. You may cancel an order up to 24 hours before the scheduled delivery time. If you cancel an order within 24 hours of the scheduled delivery time, you may be charged the full amount of the order."olduğu doğrulanır.
        String expectedText="By placing an order through the Application, you agree to our cancellation policy. You may cancel an order up to 24 hours before the scheduled delivery time. If you cancel an order within 24 hours of the scheduled delivery time, you may be charged the full amount of the order.";
        String actualText=userHomePage.byPlacingElementi.getText();

        softAssert.assertTrue(actualText.contains(expectedText),"Orders Payment sayfası iade koşullarını içermiyor");
        extentTest.pass("Orders and Payment sayfası iade koşullarını içediği doğrulandı");

        //Home tuşu ile sayfanın Header bölümüne gidilir
        actions.sendKeys(Keys.HOME).build().perform();
        extentTest.info("Home tuşu ile sayfanın Header bölümüne gidildi");
        ReusableMethods.wait(1);

        softAssert.assertAll();
        userHomePage.logOutMethod();
        extentTest.info("Logout method'u ile başarılı bir şekilde sistemden çıkış yapıldı");

    }
}
