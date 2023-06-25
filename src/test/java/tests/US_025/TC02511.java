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

public class TC02511 extends TestBaseRapor {


    @Test(groups = "demo")
    public void test01() {

        MerchantFood merchantFood = new MerchantFood();
        MerchantDashboard merchantDashboard = new MerchantDashboard();

        extentTest = extentReports.createTest("Restaurantin item sayfasinda duzenleme olmalidir");
        merchantDashboard.signInMerchantMethod();
        extentTest.info("Merchant sitesine giris yapildi");
        merchantDashboard.foodLink.click();
        ReusableMethods.wait(2);
        extentTest.info("Food tusuna tiklandi");

        merchantFood.soldakiItemsButonu.click();
        extentTest.info("itemlinkine tiklandi");

        merchantFood.categoryAddNewYanindakiArtiTusu.click();
        Actions actions = new Actions(Driver.getDriver());
        actions.click(merchantFood.detailsItemNameKutusu).perform();
        extentTest.info("name kutucuguna girdi yapildi");
        ReusableMethods.bekle(2);
        actions.sendKeys("sarma")
                .sendKeys(Keys.TAB)
                .sendKeys("Yaprak sarma, asma yaprağına pirinç ve çeşitli baharat karışımlarının " +
                        "sarılmasıyla yapılan Türk mutfağına özgü bir yemek ve meze çeşididir. ")
                .sendKeys(Keys.TAB)
                .sendKeys("Yaprak sarma, asma yaprağına pirinç ve çeşitli baharat karışımlarının sarılmasıyla yapılan Türk mutfağına özgü bir yemek ve meze çeşididir. " +
                        "Soğuk haliyle meze olarak sıcak haliyle ana yemek olarak tüketilebilir.")


                .sendKeys(Keys.TAB).perform();
        ReusableMethods.bekle(2);
        actions.sendKeys(Keys.END).build().perform();
        extentTest.info("sayfanin  en altina inildi");
        actions.sendKeys(Keys.END).build().perform();


        WebElement category = Driver.getDriver().findElement(By.xpath("//span[@class='select2-selection select2-selection--multiple']"));
        actions.click(category).build().perform();
        extentTest.info("category'e tiklandi");

        JSUtils.scrollDownByJS();
        ReusableMethods.bekle(2);
        JSUtils.scrollDownByJS();

        actions.sendKeys(Keys.ARROW_DOWN,Keys.ENTER).perform();

        JSUtils.scrollDownByJS();
        ReusableMethods.bekle(2);
        JSUtils.scrollDownByJS();

        WebElement featured = Driver.getDriver().findElement(By.xpath("(//span[@class='select2-selection select2-selection--multiple'])[2]"));
        actions.click(featured).build().perform();
        extentTest.info("featured'a tiklandi");
        actions.sendKeys(Keys.ARROW_DOWN,Keys.ENTER).perform();


        merchantFood.backroundColorHex.click();
        extentTest.info("backroundColorHex'a tiklandi");
        ReusableMethods.bekle(2);

        merchantFood.pembeArkaYon.click();
        extentTest.info("pembeArkaYon'a tiklandi");
        ReusableMethods.bekle(2);

        merchantFood.tamamButonu.click();
        extentTest.info("tamamButonu'a tiklandi");
        ReusableMethods.bekle(2);


        merchantFood.categorySaveKutusu.click();

        actions.sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ENTER)
                .sendKeys(Keys.TAB).perform();

        //"Succesfully updated" yazısının çıktığı doğrulanır.
        WebElement update=Driver.getDriver().findElement(By.xpath("//div[@class='alert alert-success']"));
        Assert.assertTrue(update.isDisplayed());
        extentTest.pass("basarili bir sekilde guncelleme yapildigi dogrulandi");
        //Driver.closeDriver();


    }
}

