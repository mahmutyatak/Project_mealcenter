package tests.US_024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.merchantMealscenter.MerchantDashboard;
import pages.merchantMealscenter.MerchantFood;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC02405 extends TestBaseRapor {
    MerchantFood merchantFood = new MerchantFood();
    MerchantDashboard merchantDashboard = new MerchantDashboard();



    @Test
    public void test01() {

        extentTest = extentReports.createTest("Restaurantin category sayfasina silme olmalidir");
    merchantDashboard.signInMerchantMethod();
    extentTest.info("Merchant sitesine giris yapildi");
    merchantDashboard.foodLink.click();
    ReusableMethods.wait(2);
    extentTest.info("Food tusuna tiklandi");
    merchantFood.categoryLinki.click();
    extentTest.info("categorylinkine tiklandi");

        merchantFood.categoryDeleteButonu.click();
        extentTest.info("delete butonuna tiklandi");
        ReusableMethods.bekle(2);
        WebElement categoryDeleteTusu = Driver.getDriver().findElement(By.xpath("//a[@class='btn btn-green item_delete']"));
        categoryDeleteTusu.click();
        ReusableMethods.bekle(2);

        extentTest.info("Basarili bi sekilde silindigi test edildi ");
        Assert.assertTrue(merchantFood.categoryYazisi.isDisplayed());
        extentTest.pass("basarili bir sekilde silindigi dogrulandi");
        Driver.closeDriver();

    }

}
