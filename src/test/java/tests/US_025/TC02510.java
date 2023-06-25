package tests.US_025;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.merchantMealscenter.MerchantDashboard;
import pages.merchantMealscenter.MerchantFood;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC02510 extends TestBaseRapor {

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
        extentTest.info("gallery sitesine giris yapildi");
        WebElement CEO = Driver.getDriver().findElement(By.xpath("(//i[@class='zmdi zmdi-google-earth'])[1]"));
        actions.click(CEO).perform();
        extentTest.info("CEO'ya tiklandi");
        ReusableMethods.bekle(2);

        extentTest.info("ceo sayfasinda meta title veri girisi olmuyor");
        WebElement ceometatitle = Driver.getDriver().findElement(By.xpath(" //label[@for='AR_item_seo_meta_title']"));
        actions.click(ceometatitle).perform();



    }
}
