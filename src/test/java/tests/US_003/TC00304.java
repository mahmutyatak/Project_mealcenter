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

import java.util.List;

import static utilities.Driver.driver;

public class TC00304 extends TestBaseRapor {

    //Browser açılır.
    //Kullanıcı "https://qa.mealscenter.com/"  adresine gider.
    //Body bölümünde yer alan "Read" butonlarına sırasıyla tıklanır ve test edilir.
    //Yazılar ve görsellerin görünür olduğu kontrol edilir.
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
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).build().perform();
        actions.sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).build().perform();
        ReusableMethods.bekle(1);

    }

    @Test
    public void Test02() {
        userHomePage.readButton.click();
        extentTest.info("Mealscenter Read butonu test edildi");
        ReusableMethods.bekle(1);

        userHomePage.mealsCenterLogo.click();
        ReusableMethods.bekle(2);

        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).build().perform();
        actions.sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).build().perform();
        ReusableMethods.bekle(2);

    }

    @Test
    public void Test03() {
        userHomePage.readButton2.click();
        extentTest.info("Mealscenter Read butonu test edildi");
        ReusableMethods.bekle(1);

        userHomePage.mealsCenterLogo.click();
        ReusableMethods.bekle(2);

        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).build().perform();
        actions.sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).build().perform();
        ReusableMethods.bekle(2);

    }
    @Test
    public void Test04() {
        userHomePage.readButton3.click();
        extentTest.info("Mealscenter Read butonu test edildi");
        ReusableMethods.bekle(1);

        userHomePage.mealsCenterLogo.click();
        ReusableMethods.bekle(2);

        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).build().perform();
        actions.sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).build().perform();
        ReusableMethods.bekle(2);

    }
    @Test
    public void Test05() {
        userHomePage.readButton4.click();
        extentTest.info("Mealscenter Read butonu test edildi");
        ReusableMethods.bekle(1);
        extentTest.pass("Mealscenter Read butonuna tıklanamaması test edildi");

        userHomePage.mealsCenterLogo.click();
        ReusableMethods.bekle(2);

        Driver.closeDriver();

    }
}
