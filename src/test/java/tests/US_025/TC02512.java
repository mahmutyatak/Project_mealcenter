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

public class TC02512 extends TestBaseRapor {
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

        WebElement delete = Driver.getDriver().findElement(By.xpath("(//i[@class='zmdi zmdi-delete'])[1]"));
        Actions actions = new Actions(Driver.getDriver());
        actions.click(delete).build().perform();
        WebElement sarma = Driver.getDriver().findElement(By.xpath("//h6[text()='sarma']"));

        Assert.assertTrue(sarma.isSelected());
        extentTest.pass("delete butonu calismiyor");




    }
}
