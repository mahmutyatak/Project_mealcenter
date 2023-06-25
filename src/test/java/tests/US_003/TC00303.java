package tests.US_003;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.userMealscenter.UserHomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC00303 extends TestBaseRapor {

    //Browser açılır.
    //Kullanıcı "https://qa.mealscenter.com/"  adresine gider.
    //Body bölümündeki "Popular nearby Seattle" kısmının altında yer alan yazılar ve görsellerin görünür olduğu kontrol edilir.

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
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(1);

    }
    @Test
    public void Test02() {

        userHomePage.populerNearbyRListMethodu(11).click();
        extentTest.info("Mealscenter populer nearby Kosher Restaurant elementine gidildi");
        ReusableMethods.bekle(1);

        userHomePage.mealsCenterLogo.click();
        ReusableMethods.bekle(2);

        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(1);

    }

    @Test
    public void Test03() {

        userHomePage.populerNearbyRListMethodu(12).click();
        extentTest.info("Mealscenter populer nearby Sichuanese Cuisine elementine gidildi");
        ReusableMethods.bekle(1);

        userHomePage.mealsCenterLogo.click();
        ReusableMethods.bekle(2);

        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(1);

    }

    @Test
    public void Test04() {

        userHomePage.sagOkButonu.click();
        userHomePage.sagOkButonu.click();
        userHomePage.populerNearbyRListMethodu(13).click();
        extentTest.info("Mealscenter populer nearby Sichuanese Cuisine elementine gidildi");
        ReusableMethods.bekle(1);

        userHomePage.mealsCenterLogo.click();
        ReusableMethods.bekle(2);

        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(1);

    }

    @Test
    public void Test05() {

        userHomePage.sagOkButonu.click();
        userHomePage.sagOkButonu.click();
        userHomePage.populerNearbyRListMethodu(14).click();
        extentTest.info("Mealscenter populer nearby Sichuanese Cuisine elementine gidildi");
        ReusableMethods.bekle(1);

        userHomePage.mealsCenterLogo.click();
        ReusableMethods.bekle(2);

        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(1);

    }

}
