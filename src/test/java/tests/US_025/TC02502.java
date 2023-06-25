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

public class TC02502 extends TestBaseRapor {
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
        merchantFood.soldakiItemsButonu.click();
        extentTest.info("itemlinkine tiklandi");


        ReusableMethods.bekle(2);
        merchantFood.updateKutusu.click();
        ReusableMethods.bekle(2);
        Actions actions = new Actions(Driver.getDriver());
        ReusableMethods.bekle(3);
        actions.click(merchantFood.detailsItemNameKutusu).perform();
        actions.sendKeys(" please ")
                .sendKeys(Keys.TAB)
                .sendKeys("Yaprak sarma, asma yaprağına pirinç ve çeşitli baharat" +
                        " karışımlarının sarılmasıyla yapılan Türk mutfağına özgü bir yemek ve meze çeşididir. ")

                .sendKeys(Keys.TAB)
                .sendKeys(" Yaprak sarma, asma yaprağına pirinç ve çeşitli baharat karışımlarının sarılmasıyla yapılan Türk mutfağına özgü bir yemek ve meze çeşididir. " +
                        "Soğuk haliyle meze olarak sıcak haliyle ana yemek olarak tüketilebilir. ")
                .sendKeys(Keys.TAB).perform();
        ReusableMethods.bekle(2);
        actions.sendKeys(Keys.END).build().perform();
        actions.sendKeys(Keys.END).build().perform();


        WebElement category = Driver.getDriver().findElement(By.xpath("//span[@class='select2-selection select2-selection--multiple']"));
        category.click();


        ReusableMethods.bekle(2);
        JSUtils.scrollDownByJS();
        merchantFood.itemBrowse.click();
        extentTest.info("browse tiklandi");
        JSUtils.scrollDownByJS();
        JSUtils.scrollDownByJS();
        ReusableMethods.bekle(2);
        merchantFood.burittoComboResmi.click();
        extentTest.info("combo resmine  tiklandi");
        ReusableMethods.bekle(2);
        Actions actions1 = new Actions(Driver.getDriver());
        actions1.sendKeys(Keys.TAB);

        actions1.click(merchantFood.bestSeller).perform();
        extentTest.info("bestSeller tiklandi");
        ReusableMethods.bekle(2);


        merchantFood.backroundColorHex.click();
        extentTest.info("backroundColorHex tiklandi");
        ReusableMethods.bekle(2);

        merchantFood.pembeArkaYon.click();
        extentTest.info("pembeArkaYon tiklandi");
        ReusableMethods.bekle(2);

        merchantFood.tamamButonu.click();
        extentTest.info("tamamButonu tiklandi");
        ReusableMethods.bekle(2);


        merchantFood.categorySaveKutusu.click();
        extentTest.info("save butonuna tiklandi");

        actions.sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ENTER)
                .sendKeys(Keys.TAB).perform();
        extentTest.pass("basarili bir sekilde guncelleme yapildigi dogrulandi");
        Driver.closeDriver();

    }
}

