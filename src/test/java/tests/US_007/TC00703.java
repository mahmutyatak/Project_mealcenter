package tests.US_007;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.userMealscenter.UserHomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC00703 extends TestBaseRapor {

    @Test
    public void test01(){
        extentTest = extentReports.createTest("Contact us sayfasında yer alan fonksiyonların beklenilen şekilde çalışmalı ve form yöneticiye başarılı bir şekilde gönderilebilmelidir.");

        UserHomePage userHomePage = new UserHomePage();
        //Browser açılır.
        //"https://qa.mealscenter.com/contactus" adresine gidilir.
        Driver.getDriver().get(ConfigReader.getProperty("mealCenterContactUs"));
        extentTest.info("\"https://qa.mealscenter.com/contactus\" adresine gidildi");

        //"Full name" kutusuna geçerli bir Ad-Soyad girilir.
        userHomePage.contactUsFullNameBox.sendKeys("denemeAd denemeSoyad");
        extentTest.info("\"Full name\" kutusuna geçerli bir Ad-Soyad girildi");

        //TAB yapılarak "Email address" kutusuna geçilir.
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).perform();
        extentTest.info("TAB yapılarak \"Email address\" kutusuna geçildi");

        //"Email address" kutusuna geçerli bir Email adresi girilir.
        userHomePage.contactUsEmailBox.sendKeys("deneme@mail.com");
        extentTest.info("\"Email address\" kutusuna geçerli bir Email adresi girildi");

        //TAB yapılarak "Your message" kutusuna geçilir.
        actions.sendKeys(Keys.TAB).perform();
        extentTest.info("TAB yapılarak \"Your message\" kutusuna geçildi");

        //"Your message"  kutusuna "Bu bir deneme mesajıdır" yazılır.
        userHomePage.contactUsYourMessageBox.sendKeys("Bu bie deneme mesajıdır");
        extentTest.info("\"Your message\"  kutusuna \"Bu bir deneme mesajıdır\" yazılır");

        //"Submit" butonuna tıklanır.
        userHomePage.contactUsSubmitButton.click();
        extentTest.info("\"Submit\" butonuna tıklandı");

        //"Your request has been sent." yazısının görünür olduğu test edilir.
        Assert.assertTrue(userHomePage.contactUsSubmitSuccessMessage.isDisplayed());
        extentTest.pass("\"Your request has been sent.\" yazısının görünür olduğu test edildi");

    }

}
