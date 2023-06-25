package tests.US_024;

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

public class TC02402 extends TestBaseRapor {


    @Test
    public void test01() {

        MerchantFood merchantFood = new MerchantFood();
        MerchantDashboard merchantDashboard = new MerchantDashboard();

        extentTest = extentReports.createTest("Restaurantin category sayfasina duzenleme olmalidir");
        merchantDashboard.signInMerchantMethod();
        extentTest.info("Merchant sitesine giris yapildi");
        merchantDashboard.foodLink.click();
        ReusableMethods.wait(2);
        extentTest.info("Food tusuna tiklandi");
        merchantFood.categoryLinki.click();
        extentTest.info("categorylinkine tiklandi");

        merchantFood.categoryUpdateButonu.click();
        ReusableMethods.bekle(2);
        Actions actions = new Actions(Driver.getDriver());
        actions.click(merchantFood.categoryUpdateDetailsNameKutucugu).perform();
        ReusableMethods.bekle(2);
        actions.sendKeys(" kek")
                .sendKeys(Keys.TAB)
                .sendKeys("cok guzel")
                .sendKeys(Keys.ENTER).perform();

        actions.moveToElement(merchantFood.CategoryDdm).click().perform();
        ReusableMethods.bekle(2);

        WebElement CategoryMeals = Driver.getDriver().findElement(By.xpath("//span[text()='Meals']"));
        CategoryMeals.click();
        actions.sendKeys(Keys.END).build().perform();
        merchantFood.categoryBrowse.click();
        extentTest.info("browse tiklandi");
        JSUtils.scrollDownByJS();
        JSUtils.scrollDownByJS();
        ReusableMethods.bekle(2);
        actions.sendKeys(Keys.END).build().perform();
        merchantFood.burittoComboResmi.click();
        extentTest.info("combo resmine  tiklandi");
        ReusableMethods.bekle(2);
        merchantFood.detailsAddFilesButonu.click();
        actions.sendKeys(Keys.END).build().perform();
        ReusableMethods.bekle(2);
        extentTest.info("details ad files'a tiklandi");
        ReusableMethods.bekle(2);

        extentTest.info("categoryBrowse2 yazisina tiklandi");
        merchantFood.categoryBrowse2.click();
        ReusableMethods.bekle(2);
        actions.sendKeys(Keys.END).build().perform();
        JSUtils.scrollDownByJS();


        extentTest.info("burittoCombo2  tiklandi");
        merchantFood.burittoCombo2.click();
        ReusableMethods.bekle(2);
        extentTest.info("addFile2  tiklandi");
        merchantFood.addFile2.click();
        JSUtils.scrollDownByJS();
        JSUtils.scrollDownByJS();
        ReusableMethods.bekle(2);


        actions.sendKeys(Keys.END).build().perform();
        extentTest.info("en asagiya  inildi");

        ReusableMethods.bekle(2);

        actions.sendKeys(Keys.END).build().perform();
        actions.sendKeys(Keys.END).build().perform();

        actions.sendKeys(Keys.END).build().perform();
        JSUtils.scrollDownByJS();



        actions.sendKeys(Keys.END).build().perform();

        actions.sendKeys(Keys.END).build().perform();
        ReusableMethods.bekle(2);




        actions.sendKeys(Keys.END).build().perform();
        WebElement locateAlamadigimSaveKutusu = Driver.getDriver().findElement(By.xpath("//div[@class='container-fluid m-0 p-0']//input[@value='Save']"));
        actions.click(locateAlamadigimSaveKutusu).build().perform();
        extentTest.info("kaydetmek icin save butonuna tiklandi");


        WebElement SuccesfullyupdatedYazisi = Driver.getDriver().findElement(By.xpath(("//div[@class='alert alert-success']")));
        extentTest.info("guncelleme isleminin yapildigi test edildi");
        Assert.assertTrue(SuccesfullyupdatedYazisi.isDisplayed());
        extentTest.pass("basarili bir sekilde guncelleme yapildigi dogrulandi");
        //Driver.closeDriver();
    }
}


