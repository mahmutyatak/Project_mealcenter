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

public class TC02401 extends TestBaseRapor {


    @Test
    public void test01() {

        MerchantFood merchantFood = new MerchantFood();
        MerchantDashboard merchantDashboard = new MerchantDashboard();


        extentTest = extentReports.createTest("Restaurantin category sayfasina erisilebilir olmalidir");
        merchantDashboard.signInMerchantMethod();
        extentTest.info("Merchant sitesine giris yapildi");
        merchantDashboard.foodLink.click();
        ReusableMethods.wait(2);
        extentTest.info("Food tusuna tiklandi");
        merchantFood.categoryLinki.click();
        extentTest.info("categorylinkine tiklandi");



        extentTest.info("enchiladas yazisinin gorunurlugu test edildi");
        WebElement enchiladasYazisi = Driver.getDriver().findElement(By.xpath("//h6[text()='Enchiladas ']"));
        Assert.assertTrue(enchiladasYazisi.isDisplayed());
        Driver.closeDriver();



    }
}
