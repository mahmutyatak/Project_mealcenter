package tests.US_003;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.userMealscenter.UserHomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC00307 extends TestBaseRapor {

    //Browser açılır.
    //Kullanıcı "https://qa.mealscenter.com/"  adresine gider.
    //Body bölümünün en altında yer alan yazıların ve görsellerin görünür olduğu kontrol edilir.

    UserHomePage userHomePage=new UserHomePage();

    @Test
    public void Test01() {

        extentTest = extentReports.createTest("Meals Center Home Page erisim testi", "Meals Center Home Page sayfasina erisim saglanabilmeli");
        Driver.getDriver().get(ConfigReader.getProperty("mealCenterHomePageUrl"));
        ReusableMethods.bekle(1);
        extentTest.info("Mealscenter Home Page'e  gidildi");

        //Sayfanin Url'inin  "https://qa.mealscenter.com/" oldugu dogrulanir
        String actualUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(ConfigReader.getProperty("mealCenterHomePageUrl")));
        extentTest.pass("Meals Center Home Page Url dogrulandi");
        ReusableMethods.bekle(1);

        userHomePage.acceptCookie.click();
        ReusableMethods.bekle(1);
        extentTest.info("Cookie kabul edildi");

        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(1);

    }


    @Test
    public void Test02() {

        extentTest = extentReports.createTest("Meals Center Home Page erisim testi", "Meals Center Home Page sayfasina erisim saglanabilmeli");
        // Sayfanın en altındaki görseli kontrol et
        WebElement img = Driver.getDriver().findElement(By.xpath("(//div[@class='mb-0 row']//div[@class='col-lg-4 col-md-4 mb-4 mb-lg-3'])[2]"));
        System.out.println(img.getText());
        Assert.assertTrue(img.isDisplayed(), "Görselin görünürlügü test edildi");
        ReusableMethods.bekle(1);
        extentTest.info("Mealscenter Home Page sayfasındaki image görünürlügü dogrulandı");

        // Sayfanın en altındaki metni kontrol et
        WebElement text1 =Driver.getDriver().findElement(By.xpath("(//div[@class='mb-0 row']//div[@class='col-lg-4 col-md-4 mb-4 mb-lg-3'])[1]"));
        Assert.assertTrue(text1.isDisplayed(), "Metin görünürlügü test edildi");
        ReusableMethods.bekle(1);
        extentTest.info("Mealscenter Home Page sayfasındaki text görünürlügü dogrulandı");

        WebElement text2 = Driver.getDriver().findElement(By.xpath("(//div[@class='mb-0 row']//div[@class='col-lg-4 col-md-4 mb-4 mb-lg-3'])[3]"));
        Assert.assertTrue(text2.isDisplayed(), "Metin görünürlügü test edildi");
        ReusableMethods.bekle(1);
        extentTest.info("Mealscenter Home Page sayfasındaki text görünürlügü dogrulandı");

        Driver.closeDriver();

    }
}
