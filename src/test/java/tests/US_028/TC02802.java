package tests.US_028;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.merchantMealscenter.MerchantDashboard;
import pages.merchantMealscenter.MerchantOrders;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC02802 extends TestBaseRapor {

    MerchantDashboard merchantDashboard=new MerchantDashboard();
    MerchantOrders merchantOrders=new MerchantOrders();
    @Test
    public void test01() {
        merchantDashboard=new MerchantDashboard();
        merchantOrders=new MerchantOrders();
        extentTest = extentReports.createTest("Dagitima hazir olan siparisin ait oldugu musteri bilgileri gorulur olmalidir", "Pozitif dagitima hazir olan siparisin ait oldugu musteri bilgileri gorulme testi yapildi");
        merchantDashboard.signInMerchantMethod();
        extentTest.info("Merchant sitesine giris yapildi");
        merchantOrders.ordersButton.click();
        extentTest.info("Orders butonuna tiklandi");
        merchantOrders.ordersReadyButton.click();
        extentTest.info("Orders Ready butonuna tiklandi");
        String expectedIcerik="teamdort";
        String actualIcerik=merchantOrders.customerBilgileri.getText();
        Assert.assertTrue(actualIcerik.contains(expectedIcerik));
        extentTest.pass("Siparisin ait oldugu musteri bilgileri gorulme testi yapildi");

    }
    @Test
    public void test02(){
        merchantDashboard=new MerchantDashboard();
        merchantOrders=new MerchantOrders();
        extentTest = extentReports.createTest("Dagitima hazir olan  siparisin ait oldugu musteri teslimat bilgileri gorulur olmalidir", "Pozitif dagitima hazir olan siparisin ait oldugu musteri teslimat bilgileri gorulme testi yapildi");
        String expectedIcerik="teamdort";
        String actualIcerik=merchantOrders.deliveryBilgileri.getText();
        Assert.assertTrue(actualIcerik.contains(expectedIcerik));
        extentTest.pass("Siparisin ait oldugu musteri teslimat bilgileri gorulme testi yapildi");
    }
    @Test
    public void test03() {
        merchantDashboard=new MerchantDashboard();
        merchantOrders=new MerchantOrders();
        extentTest = extentReports.createTest("Dagitima hazir olan siparisin odeme bilgileri gorulur olmalidir", "Pozitif daigitima hazir olan siparisin odeme bilgileri gorulme testi yapildi");
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.END).perform();
        extentTest.info("Sayfa en asagiya kaydirilir");
        ReusableMethods.wait(3);
        String expectedIcerik = "Payment";
        String actualIcerik = merchantOrders.paymentTable.getText();
        System.out.println(actualIcerik);
        Assert.assertTrue(actualIcerik.contains(expectedIcerik));
        extentTest.pass("Siparisin odeme gecmisi bilgileri gorulme testi yapildi");

    }
}
