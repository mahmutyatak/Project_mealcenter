package tests.US_025;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.merchantMealscenter.MerchantDashboard;
import pages.merchantMealscenter.MerchantFood;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC02501 extends TestBaseRapor {

    @Test
    public void test01() {

        MerchantFood merchantFood = new MerchantFood();
        MerchantDashboard merchantDashboard = new MerchantDashboard();


        extentTest = extentReports.createTest("Restaurantin item sayfasina erisilebilir olmalidir");
        merchantDashboard.signInMerchantMethod();
        extentTest.info("Merchant sitesine giris yapildi");
        merchantDashboard.foodLink.click();
        ReusableMethods.wait(2);
        extentTest.info("Item tusuna tiklandi");
        merchantFood.soldakiItemsButonu.click();
        extentTest.info("item linkine tiklandi");



        extentTest.info("item List yazisinin gorunurlugu ile syafaya erisim yapildigi  dogrulandi");

        WebElement itemlistyazisi = Driver.getDriver().findElement(By.xpath("//h5[text()='Item list']"));
        Assert.assertTrue(itemlistyazisi.isDisplayed());
        extentTest.pass("basarili bir sekilde sayfaya giris yapilabildigi dogrulandi");

        Driver.closeDriver();




    }
}

