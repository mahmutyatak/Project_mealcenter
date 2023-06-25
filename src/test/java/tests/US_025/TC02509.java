package tests.US_025;

import org.openqa.selenium.By;
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

public class TC02509 extends TestBaseRapor {

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
        extentTest.info("update'e tiklandi");


        ReusableMethods.bekle(2);
        Actions actions = new Actions(Driver.getDriver());
        ReusableMethods.bekle(2);
        extentTest.info("gallery sitesine giris yapildi");
        WebElement gallery = Driver.getDriver().findElement(By.xpath("(//i[@class='zmdi zmdi-collection-image-o'])[1]"));
        actions.click(gallery).perform();
        ReusableMethods.bekle(2);

        WebElement Browse = Driver.getDriver().findElement(By.xpath("//button[text()='Browse']"));
        actions.click(Browse).perform();
        extentTest.info("browse'a tiklandi");

        WebElement burittocombo = Driver.getDriver().findElement(By.xpath("(//div[@class='file_wrapper']//li)[11]"));
        actions.click(burittocombo).perform();
        extentTest.info("burittocombo'a tiklandi");

        JSUtils.scrollDownByJS();
        ReusableMethods.bekle(2);


        WebElement addFiles = Driver.getDriver().findElement(By.xpath("(//button[@type='button'])[9]"));
        actions.click(addFiles).perform();
        extentTest.info("addFiles'a tiklandi");


        WebElement locateAlamadigimSaveKutusu = Driver.getDriver().findElement(By.xpath("//div[@class='container-fluid m-0 p-0']//input[@value='Save']"));
        actions.click(locateAlamadigimSaveKutusu).build().perform();
        extentTest.info("save'e tiklandi");

        WebElement basriliGuncellemeYazisi = Driver.getDriver().findElement(By.xpath("//div[@class='alert alert-success']"));
        Assert.assertTrue(basriliGuncellemeYazisi.isDisplayed());
        extentTest.pass("basarili bir sekilde guncelleme yapildigi dogrulandi");
        Driver.closeDriver();




    }
}

