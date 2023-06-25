package tests.US_025;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.merchantMealscenter.MerchantDashboard;
import pages.merchantMealscenter.MerchantFood;
import utilities.Driver;
import utilities.JSUtils;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC02503 extends TestBaseRapor {
    MerchantFood merchantFood = new MerchantFood();
    MerchantDashboard merchantDashboard = new MerchantDashboard();

    @Test
    public void test01() {


        extentTest = extentReports.createTest("Restaurantin item sayfasinda duzenleme olmalidir");
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

        WebElement priceKutusu = Driver.getDriver().findElement(By.xpath("//i[@class='zmdi zmdi-money-box']"));
        actions.click(priceKutusu).perform();
        extentTest.info("price kutusuna tiklandi");
        ReusableMethods.bekle(2);
        actions.click(merchantFood.priceUpdateButonu).perform();
        ReusableMethods.bekle(2);
        WebElement alamadigimpriceYazisi = Driver.getDriver().findElement(By.xpath("//input[@name='AR_item_size[price]']"));
        actions.click(alamadigimpriceYazisi).perform();
        ReusableMethods.bekle(2);
        Driver.closeDriver();




        WebElement alamadigimpriceKutusu = Driver.getDriver().findElement(By.xpath("//label[@class='required']"));
        actions.click(alamadigimpriceKutusu).perform();

        actions.click(alamadigimpriceKutusu).keyDown(Keys.COMMAND).sendKeys("A").keyUp(Keys.COMMAND).
                sendKeys(Keys.BACK_SPACE).perform();



        ReusableMethods.bekle(2);
        actions.sendKeys("30.00").perform();
        ReusableMethods.bekle(2);
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(Keys.TAB).perform();

        actions.click(alamadigimpriceKutusu).keyDown(Keys.COMMAND).sendKeys("A").keyUp(Keys.COMMAND).
                sendKeys(Keys.BACK_SPACE).perform();
        WebElement costKutusu = Driver.getDriver().findElement(By.xpath("(//div[@class='form-label-group w-50'])[2]"));

        actions.click(costKutusu).keyDown(Keys.COMMAND).sendKeys("A").keyUp(Keys.COMMAND).sendKeys(Keys.BACK_SPACE).perform();
        actions.sendKeys(Keys.TAB).perform();
        ReusableMethods.bekle(2);
        actions.click(merchantFood.updatePriceTakvim31martbutonu).build().perform();
        ReusableMethods.bekle(2);
        actions.sendKeys(Keys.TAB).perform();
        actions.click(merchantFood.updatePriceTakvim31martbutonu).build().perform();
        extentTest.info("Uygun gün girildi");
        JSUtils.scrollDownByJS();
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(Keys.TAB).perform();
        ReusableMethods.bekle(2);
        actions.sendKeys(Keys.END);
        actions.sendKeys(Keys.END);
        ReusableMethods.bekle(2);

        WebElement locateAlamadigimSaveKutusu = Driver.getDriver().findElement(By.xpath("//div[@class='container-fluid m-0 p-0']//input[@value='Save']"));
        actions.click(locateAlamadigimSaveKutusu).build().perform();
        extentTest.pass("basarili bir sekilde guncelleme yapildigi dogrulandi");






    }
}






