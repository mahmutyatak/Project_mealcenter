package tests.US_007;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.userMealscenter.UserHomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC00704 extends TestBaseRapor {

    @Test
    public void test01(){
        extentTest = extentReports.createTest("\"Full name\" kutusuna herhangi bir değer girilmediğinde veya sadece sayısal ifadeler içeren bir değer girildiğinde, Contact us formunun submit edilemediği doğrulanmalıdır.");
        UserHomePage userHomePage = new UserHomePage();

        //Browser açılır.
        //"https://qa.mealscenter.com/contactus" adresine gidilir.
        Driver.getDriver().get(ConfigReader.getProperty("mealCenterContactUs"));
        extentTest.info("\"https://qa.mealscenter.com/contactus\" adresine gidildi");

        //"Email address" kutusuna geçerli bir Email adresi girilir.
        userHomePage.contactUsEmailBox.sendKeys("deneme@mail.com");
        extentTest.info("\"Email address\" kutusuna geçerli bir Email adresi girildi");

        //TAB yapılarak "Your message" kutusuna geçilir.
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).perform();

        //"Your message"  kutusuna "Bu bir deneme mesajıdır" yazılır.
        userHomePage.contactUsYourMessageBox.sendKeys("Bu bir deneme mesajıdır");
        extentTest.info("\"Your message\"  kutusuna \"Bu bir deneme mesajıdır\" yazıldı");

        //"Submit" butonuna tıklanır.
        userHomePage.contactUsSubmitButton.click();
        extentTest.info("\"Submit\" butonuna tıklandı");

        //"Full name is required" yazısının görünür olduğu test edilir.
        Assert.assertTrue(userHomePage.contactUsFullNameIsRequired.isDisplayed());
        extentTest.pass("\"Full name is required\" yazısının görünür olduğu test edildi");

        //Sayfa yeniden yüklenir
        Driver.getDriver().navigate().refresh();
        extentTest.info("Sayfa yeniden yüklendi");

        //"Full name" kutusuna sayısal bir değer girilir.
        userHomePage.contactUsFullNameBox.sendKeys("12345");
        extentTest.info("\"Full name\" kutusuna sayısal bir değer girildi");

        //"Email address" kutusuna geçerli bir Email adresi girilir.
        userHomePage.contactUsEmailBox.sendKeys("deneme@mail.com");
        extentTest.info("\"Email address\" kutusuna geçerli bir Email adresi girildi");

        //TAB yapılarak "Your message" kutusuna geçilir.
        actions.sendKeys(Keys.TAB).perform();
        extentTest.info("TAB yapılarak \"Your message\" kutusuna geçildi");

        //"Your message"  kutusuna "Bu bir deneme mesajıdır" yazılır.
        actions.sendKeys("Bu bir deneme mesajıdır").perform();
        extentTest.info("\"Your message\"  kutusuna \"Bu bir deneme mesajıdır\" yazıldı");

        //"Submit" butonuna tıklanır.
        userHomePage.contactUsSubmitButton.click();
        extentTest.info("\"Submit\" butonuna tıklandı");

        //"Full name is required" yazısının görünür olduğu test edilir.
        Assert.assertTrue(userHomePage.contactUsFullNameIsRequired.isDisplayed());
        extentTest.pass("\"Full name is required\" yazısının görünür olduğu test edildi");

    }

}
