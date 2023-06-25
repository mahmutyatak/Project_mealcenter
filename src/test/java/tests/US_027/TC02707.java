package tests.US_027;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.merchantMealscenter.MerchantDashboard;
import pages.merchantMealscenter.MerchantOrders;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC02707 extends TestBaseRapor {
    MerchantDashboard merchantDashboard=new MerchantDashboard();
    MerchantOrders merchantOrders=new MerchantOrders();
    @Test
    public void test01() {
        merchantDashboard=new MerchantDashboard();
        merchantOrders=new MerchantOrders();
        extentTest = extentReports.createTest("Kabul edilen siparisin turune filtrelenebilir oldugu dogrulanmalidir", "Pozitif kabul edilen siparisin turune gore filtrelenebilme  testi yapildi");
        merchantDashboard.signInMerchantMethod();
        extentTest.info("Merchant sitesine giris yapildi");
        merchantOrders.ordersButton.click();
        extentTest.info("Orders butonuna tiklandi");
        merchantOrders.ordersProceccingButton.click();
        extentTest.info("Orders Proceccing butonuna tiklandi");
        merchantOrders.orderTypeButton.click();
        extentTest.info("Order Type tusuna tiklandi");
        merchantOrders.orderTypeDelivery.click();
        extentTest.info("Delivery secenegi secildi");
        ReusableMethods.wait(2);
        String expectedIcerik="teamdort";
        String actualIcerik=merchantOrders.customerBilgileri.getText();
        Assert.assertTrue(actualIcerik.contains(expectedIcerik));
        extentTest.pass("Filtreleme sonucunda siparis turu ile musteri  bilgileri gorulme testi yapildi");

    }
    @Test
    public void test02() {
        merchantDashboard=new MerchantDashboard();
        merchantOrders=new MerchantOrders();
        extentTest = extentReports.createTest("Kabul edilen odeme turune filtrelenebilir oldugu dogrulanmalidir", "Pozitif kabul edilen odeme turune gore filtrelenebilme  testi yapildi");
        merchantOrders.orderTypeDelivery.click();
        extentTest.info("Delivery secenegi kaldirildi");

        merchantOrders.paymentTypeButton.click();
        extentTest.info("Payment Type butonuna tiklandi");
        merchantOrders.unpaidTypePayment.click();
        extentTest.info("Unpaid secenegi secildi");
        ReusableMethods.wait(2);
        String expectedIcerik="teamdort";
        String actualIcerik=merchantOrders.customerBilgileri.getText();
        Assert.assertTrue(actualIcerik.contains(expectedIcerik));
        extentTest.pass("Filtreleme sonucunda odeme turu ile musteri  bilgileri gorulme testi yapildi");
        Driver.closeDriver();

    }
}
