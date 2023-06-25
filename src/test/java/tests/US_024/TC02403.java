package tests.US_024;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.merchantMealscenter.MerchantDashboard;
import pages.merchantMealscenter.MerchantFood;
import utilities.Driver;
import utilities.JSUtils;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;
public class TC02403 extends TestBaseRapor {


    @Test(groups = "demo")
    public void test01() {

        MerchantFood merchantFood = new MerchantFood();

        MerchantDashboard merchantDashboard = new MerchantDashboard();

        extentTest = extentReports.createTest("Restaurantin category sayfasina duzenleme olmalidir");
        merchantDashboard.signInMerchantMethod();
        extentTest.info("Merchant sitesine giris yapildi");
        merchantDashboard.foodLink.click();
        ReusableMethods.wait(2);
        extentTest.info("Food tusuna tiklandi");
        merchantFood.categoryLinki.click();
        extentTest.info("categorylinkine tiklandi");

        merchantFood.categoryUpdateButonu.click();
        extentTest.info("category update butonuna tiklandi");
        ReusableMethods.bekle(2);

        extentTest.info("category avalibiltiy kismina gecildi");
        WebElement categoryAavailability = Driver.getDriver().findElement(By.xpath(("//i[@class='zmdi zmdi-time-countdown']")));
        categoryAavailability.click();
        ReusableMethods.bekle(2);

        extentTest.info("checkAll yazisina tiklandi");
        WebElement checkAllYazisi = Driver.getDriver().findElement(By.xpath(("//a[@type='button']")));
        checkAllYazisi.click();
        JSUtils.scrollDownByJS();


        ReusableMethods.bekle(2);

        Actions actions = new Actions(Driver.getDriver());
        extentTest.info("sayfanin en altina inildi");
        actions.sendKeys(Keys.END).build().perform();
        actions.sendKeys(Keys.END).build().perform();
        extentTest.info("save butonuna basildi");
        WebElement Save = Driver.getDriver().findElement(By.xpath(("//div[@class='container-fluid m-0 p-0']//input[@value='Save']")));
        actions.click(Save).build().perform();


        WebElement SuccesfullyupdatedYazisi = Driver.getDriver().findElement(By.xpath(("//div[text()=' Succesfully updated ']")));
        extentTest.info("guncelleme isleminin yapildigi test edildi");
        Assert.assertTrue(SuccesfullyupdatedYazisi.isDisplayed());
        extentTest.pass("basarili bir sekilde guncelleme yapildigi dogrulandi");

        //Driver.closeDriver();
    }
}

