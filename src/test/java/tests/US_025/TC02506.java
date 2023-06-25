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

public class TC02506 extends TestBaseRapor {

    MerchantFood merchantFood = new MerchantFood();
    MerchantDashboard merchantDashboard = new MerchantDashboard();

    @Test
    public void test01() {

        extentTest = extentReports.createTest("Restaurantin category sayfasina duzenleme olmalidir");
        merchantDashboard.signInMerchantMethod();
        extentTest.info("Merchant sitesine giris yapildi");
        merchantDashboard.foodLink.click();
        ReusableMethods.wait(2);
        extentTest.info("Food tusuna tiklandi");

        //i[@class='zmdi zmdi-money-box']
        merchantFood.soldakiItemsButonu.click();
        extentTest.info("itemlinkine tiklandi");

        ReusableMethods.bekle(2);
        merchantFood.updateKutusu.click();
        ReusableMethods.bekle(2);


        //Availibilit kismina gecildi
        Actions  actions = new Actions(Driver.getDriver());
        WebElement avalibity = Driver.getDriver().findElement(By.xpath("//i[@class='zmdi zmdi-assignment-check']"));
        actions.click(avalibity).perform();
        ReusableMethods.bekle(2);

        //check tusuna basildi
        WebElement artiTusu = Driver.getDriver().findElement(By.xpath("(//i[@class='zmdi zmdi-plus-circle-o'])[2]"));
        artiTusu.click();
        ReusableMethods.bekle(3);
        JSUtils.scrollDownByJS();
        JSUtils.scrollDownByJS();




       //save tusuna basildi
        WebElement locateAlamadigimSaveKutusu = Driver.getDriver().findElement(By.xpath("//div[@class='container-fluid m-0 p-0']//input[@value='Save']"));
        actions.click(locateAlamadigimSaveKutusu).build().perform();
        WebElement basriliGuncellemeYazisi = Driver.getDriver().findElement(By.xpath("//div[@class='alert alert-success']"));

        Assert.assertTrue(basriliGuncellemeYazisi.isDisplayed());
        extentTest.pass("basarili bir sekilde guncelleme yapildigi dogrulandi");
        Driver.closeDriver();


    }
}


