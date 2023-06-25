package tests.US_025;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.merchantMealscenter.MerchantDashboard;
import pages.merchantMealscenter.MerchantFood;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC02508 extends TestBaseRapor {

    MerchantFood merchantFood = new MerchantFood();
    MerchantDashboard merchantDashboard = new MerchantDashboard();

    @Test
    public void test01() {
        ;
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
        extentTest.info("salesPromotion sitesine giris yapildi");

        WebElement salesPromotion = Driver.getDriver().findElement(By.xpath("//i[@class='zmdi zmdi-drink']"));
        actions.click(salesPromotion).perform();
        ReusableMethods.bekle(2);



        //Sayfada "No data available in table" yazısının görünürlüğü doğrulanır.
        Assert.assertTrue(Driver.getDriver().getPageSource().contains("No data available in table"));
        extentTest.pass("No data available in table yazısının görünürlüğü doğrulandı");
        Driver.closeDriver();
    }
}


