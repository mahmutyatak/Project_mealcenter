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

    public class TC02404 extends TestBaseRapor {

        MerchantFood merchantFood = new MerchantFood();
        MerchantDashboard merchantDashboard = new MerchantDashboard();


        @Test
        public void test01() {


            extentTest = extentReports.createTest("Restaurantin category sayfasina ekleme olmalidir");
            merchantDashboard.signInMerchantMethod();
            extentTest.info("Merchant sitesine giris yapildi");
            merchantDashboard.foodLink.click();
            ReusableMethods.wait(2);
            extentTest.info("Food tusuna tiklandi");
            merchantFood.categoryLinki.click();
            extentTest.info("categorylinkine tiklandi");

            merchantFood.categoryAddNewYanindakiArtiTusu.click();
            extentTest.info("yeni bir categori eklemek arti butonuna tiklandi");
            Actions actions = new Actions(Driver.getDriver());
            extentTest.info("name kutucugu tiklandi");
            actions.click(merchantFood.categoryUpdateDetailsNameKutucugu).perform();
            ReusableMethods.bekle(2);
            extentTest.info(" ilgili bilgiler bosluklara yazildi ");
            actions.sendKeys("borek")
                    .sendKeys(Keys.TAB)
                    .sendKeys("cok guzel").perform();
            ReusableMethods.bekle(2);



            // merchantFood.zilTusu.click();
            // ReusableMethods.bekle(2);


            merchantFood.categoryBrowse.click();
            extentTest.info("browse tiklandi");
            JSUtils.scrollDownByJS();
            ReusableMethods.bekle(2);
            merchantFood.burittoComboResmi.click();
            extentTest.info("combo resmine  tiklandi");
            ReusableMethods.bekle(2);
            merchantFood.detailsAddFilesButonu.click();
            ReusableMethods.bekle(2);
            extentTest.info("details ad files'a tiklandi");
            ReusableMethods.bekle(2);

            extentTest.info("categoryBrowse2 yazisina tiklandi");
            merchantFood.categoryBrowse2.click();
            ReusableMethods.bekle(2);
            actions.sendKeys(Keys.END).build().perform();
            ReusableMethods.bekle(2);
            extentTest.info("burittoCombo2  tiklandi");
            merchantFood.burittoCombo2.click();
            ReusableMethods.bekle(2);
            extentTest.info("addFile2  tiklandi");
            ReusableMethods.bekle(2);
            merchantFood.addFile2.click();
            JSUtils.scrollDownByJS();
            JSUtils.scrollDownByJS();
            ReusableMethods.bekle(2);
            actions.moveToElement(merchantFood.CategoryDish).click().perform();

            actions.sendKeys(Keys.END).build().perform();
            extentTest.info("en asagiya  inildi");

            ReusableMethods.bekle(2);
            WebElement MealKutusu = Driver.getDriver().findElement(By.xpath("//span[text()='Meals']"));
            actions.moveToElement(MealKutusu).click();
            extentTest.info("meal kutusuna tiklandi");


            ReusableMethods.bekle(2);
            actions.sendKeys(Keys.END).build().perform();

            ReusableMethods.bekle(2);
            actions.sendKeys(Keys.END).build().perform();
            ReusableMethods.bekle(2);
            WebElement locateAlamadigimSaveKutusu = Driver.getDriver().findElement(By.xpath("//div[@class='container-fluid m-0 p-0']//input[@value='Save']"));
            actions.click(locateAlamadigimSaveKutusu).build().perform();
            extentTest.info("kaydetmek icin save butonuna tiklandi");
            WebElement succesfulCreatedYazisi = Driver.getDriver().findElement(By.xpath("//div[@class='alert alert-success']"));
            ReusableMethods.bekle(2);
            Assert.assertTrue(succesfulCreatedYazisi.isDisplayed());
            extentTest.info("succesful creat yazisi ile basarili bir sekilde kaydedildigi tesst edildi");
            extentTest.pass("basarili bir sekilde yeniden categori yapildigi dogrulandi");
            Driver.closeDriver();

        }
    }


