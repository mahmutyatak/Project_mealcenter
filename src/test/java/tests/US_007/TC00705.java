package tests.US_007;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.userMealscenter.UserHomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC00705 extends TestBaseRapor {

    @Test
    public void test01(){
        extentTest = extentReports.createTest("\"Email address\" kutusuna herhangi bir değer girilmediğinde veya girilen mail adresi \"@mail.com\" uzantılarını içermediginde, Contact us formunun submit edilemediği doğrulanmalıdır.");

        UserHomePage userHomePage = new UserHomePage();

        //Browser açılır.
        //"https://qa.mealscenter.com/contactus" adresine gidilir.
        Driver.getDriver().get(ConfigReader.getProperty("mealCenterContactUs"));
        extentTest.info("\"https://qa.mealscenter.com/contactus\" adresine gidildi");

        //"Full name" kutusuna geçerli bir Ad-Soyad girilir.
        userHomePage.contactUsFullNameBox.sendKeys("Ali Veli");
        extentTest.info("\"Full name\" kutusuna geçerli bir Ad-Soyad girildi");

        //İki defa TAB yapılarak "Your message" kutusuna geçilir.
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
        extentTest.info("İki defa TAB yapılarak \"Your message\" kutusuna geçildi");

        //"Your message"  kutusuna "Bu bir deneme mesajıdır" yazılır.
        actions.sendKeys("Bu bir deneme mesajıdır").perform();
        extentTest.info("\"Your message\"  kutusuna \"Bu bir deneme mesajıdır\" yazıldı");

        //"Submit" butonuna tıklanır.
        userHomePage.contactUsSubmitButton.click();
        extentTest.info("\"Submit\" butonuna tıklandı");

        //"Email address is required" yazısının görünür olduğu test edilir.
        String expectedText = "Email address is required";
        String actualText = userHomePage.contactUsFullNameIsRequired.getText();
        Assert.assertEquals(expectedText,actualText);
        extentTest.pass("\"Email address is required\" yazısının görünür olduğu test edildi");

        //Sayfa yeniden yüklenir
        Driver.getDriver().navigate().refresh();
        extentTest.info("Sayfa yeniden yüklendi");

        //"Full name" kutusuna geçerli bir Ad-Soyad girilir.
        userHomePage.contactUsFullNameBox.sendKeys("Ali Veli");
        extentTest.info("\"Full name\" kutusuna geçerli bir Ad-Soyad girildi");

        //TAB yapılarak "Email address" kutusuna geçilir.
        actions.sendKeys(Keys.TAB).perform();
        extentTest.info("TAB yapılarak \"Email address\" kutusuna geçildi");

        //"Email address" kutusuna "@mail.com" uzantısı içermeyen bir giriş yapılır.
        actions.sendKeys("deneme");
        extentTest.info("\"Email address\" kutusuna \"@mail.com\" uzantısı içermeyen bir giriş yapıldı");

        //TAB yapılarak "Your message" kutusuna geçilir.
        actions.sendKeys(Keys.TAB).perform();
        extentTest.info("TAB yapılarak \"Your message\" kutusuna geçildi");

        //"Your message"  kutusuna "Bu bir deneme mesajıdır" yazılır.
        actions.sendKeys("Bu bir deneme mesajıdır").perform();
        extentTest.info("\"Your message\"  kutusuna \"Bu bir deneme mesajıdır\" yazıldı");

        //"Submit" butonuna tıklanır.
        //"Submit" butonuna tıklanır.
        userHomePage.contactUsSubmitButton.click();
        extentTest.info("\"Submit\" butonuna tıklandı");

        //"Invalid email address" yazısının görünür olduğu test edilir.
        expectedText = "Invalid email address";
        actualText = userHomePage.contactUsFullNameIsRequired.getText();
        Assert.assertEquals(expectedText,actualText);
        extentTest.pass("\"Invalid email address\" yazısının görünür olduğu test edildi");

    }
}
