package tests.US_026;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.merchantMealscenter.MerchantDashboard;
import pages.merchantMealscenter.MerchantOrders;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC02602 extends TestBaseRapor {
    MerchantDashboard merchantDashboard = new MerchantDashboard();
    MerchantOrders merchantOrders = new MerchantOrders();

    @Test
    public void test01() {
        //Reastaurantın toplam siparis adetinin gorulur oldugu dogrulanabilmelidir.
        extentTest = extentReports.createTest("Kabul edilen siparisin gorulur olmalidir", "Pozitif kabul edilen siparis gorulme testi yapildi");
        merchantDashboard.signInMerchantMethod();
        extentTest.info("Merchant sitesine giris yapildi");
        merchantOrders.ordersButton.click();
        extentTest.info("Orders butonuna tiklandi");
        merchantOrders.newOrdersButonu.click();
        extentTest.info("NewOrders Proceccing butonuna tiklandi");
    }


        @Test
        public void test02() {
            extentTest = extentReports.createTest("Siparisin ait oldugu musteri teslimat bilgileri gorulur olmalidir", "Pozitif kabul edilen siparisin ait oldugu musteri teslimat bilgileri gorulme testi yapildi");
            String expectedIcerik = "teamdort";
            String actualIcerik = merchantOrders.deliveryBilgileri.getText();
            Assert.assertTrue(actualIcerik.contains(expectedIcerik));
            extentTest.pass("Siparisin ait oldugu musteri teslimat bilgileri gorulme testi yapildi");
        }


        @Test
        public void test03 () {
            extentTest = extentReports.createTest("Siparisin gorulur olmalidir" ,"Siparis gorulme testi yapildi");
            Actions actions = new Actions(Driver.getDriver());
            actions.sendKeys(Keys.END).perform();
            extentTest.info("Sayfa en asagiya kaydirilir");
            ReusableMethods.wait(3);
            String expectedIcerik = "Payment";

            WebElement categoryLNewOrdersPaymentTablosu = Driver.getDriver().findElement(By.xpath("//table//tr[5]//td[2]"));
             String actualIcerik = categoryLNewOrdersPaymentTablosu.getText();
            System.out.println(actualIcerik);
            Assert.assertTrue(actualIcerik.contains(expectedIcerik));
            extentTest.pass("Siparisin odeme gecmisi bilgileri gorulme testi yapildi");
            Driver.closeDriver();
        }
    }


