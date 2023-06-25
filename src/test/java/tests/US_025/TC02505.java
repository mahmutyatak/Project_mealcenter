package tests.US_025;

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

public class TC02505 extends TestBaseRapor {

    MerchantFood merchantFood = new MerchantFood();
    MerchantDashboard merchantDashboard = new MerchantDashboard();

    @Test
    public void test01() {

        extentTest = extentReports.createTest("Restaurantin category sayfasinda duzenleme olmalidir");
        merchantDashboard.signInMerchantMethod();
        extentTest.info("Merchant sitesine giris yapildi");
        merchantDashboard.foodLink.click();
        ReusableMethods.wait(2);
        extentTest.info("Food tusuna tiklandi");


        merchantFood.soldakiItemsButonu.click();
        extentTest.info("itemlinkine tiklandi");

        ReusableMethods.bekle(2);
        merchantFood.updateKutusu.click();
        ReusableMethods.bekle(2);
        Actions actions = new Actions(Driver.getDriver());
        ReusableMethods.bekle(2);
        WebElement attribute = Driver.getDriver().findElement(By.xpath("//i[@class='zmdi zmdi-plus-circle-o']"));
        actions.click(attribute).perform();


        merchantFood.pointsEarnedButonu.click();
        actions.click(merchantFood.pointsEarnedButonu).keyDown(Keys.COMMAND).sendKeys("A").keyUp(Keys.COMMAND).
                sendKeys(Keys.BACK_SPACE).perform();

        ReusableMethods.bekle(2);
        actions.sendKeys("30.00").perform();

        JSUtils.scrollDownByJS();

        ReusableMethods.bekle(2);
        WebElement cookingReference = Driver.getDriver().findElement(By.xpath("(//span[@class='select2-selection select2-selection--multiple'])[1]"));
        actions.click(cookingReference).build().perform();
        actions.sendKeys(Keys.ARROW_DOWN,Keys.ENTER).perform();
        JSUtils.scrollDownByJS();

        ReusableMethods.bekle(2);
        WebElement ingredients = Driver.getDriver().findElement(By.xpath("(//span[@class='select2-selection select2-selection--multiple'])[2]"));
        actions.click(ingredients).build().perform();
        actions.sendKeys(Keys.ARROW_DOWN,Keys.ENTER).perform();
        JSUtils.scrollDownByJS();

        ReusableMethods.bekle(2);
        WebElement dish = Driver.getDriver().findElement(By.xpath("(//span[@class='select2-selection select2-selection--multiple'])[3]"));
        actions.click(dish).build().perform();
        actions.sendKeys(Keys.ARROW_DOWN,Keys.ENTER).perform();

        JSUtils.scrollDownByJS();
        ReusableMethods.bekle(2);
        WebElement DeliveryOptions = Driver.getDriver().findElement(By.xpath("(//span[@class='select2-selection select2-selection--multiple'])[4]"));
        actions.click(DeliveryOptions).build().perform();
        actions.sendKeys(Keys.ARROW_DOWN,Keys.ENTER).perform();



        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.ENTER).perform();
        extentTest.info("Uygun durum güncellendi");



        WebElement locateAlamadigimSaveKutusu = Driver.getDriver().findElement(By.xpath("//div[@class='container-fluid m-0 p-0']//input[@value='Save']"));
        actions.click(locateAlamadigimSaveKutusu).build().perform();

        WebElement basriliGuncellemeYazisi = Driver.getDriver().findElement(By.xpath("//div[@class='alert alert-success']"));

        Assert.assertTrue(basriliGuncellemeYazisi.isDisplayed());
        extentTest.pass("basarili bir sekilde guncelleme yapildigi dogrulandi");
        Driver.closeDriver();
    }
}
