package tests.US_026;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.merchantMealscenter.MerchantDashboard;
import pages.merchantMealscenter.MerchantOrders;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC02607 extends TestBaseRapor {
    MerchantDashboard merchantDashboard=new MerchantDashboard();
    MerchantOrders merchantOrders=new MerchantOrders();
    @Test
    public void test01() {

        extentTest = extentReports.createTest("Siparisin gorulur olmalidir", "Siparis gorulme testi yapildi");
        merchantDashboard.signInMerchantMethod();
        extentTest.info("Merchant sitesine giris yapildi");
        merchantOrders.ordersButton.click();
        extentTest.info("Orders butonuna tiklandi");
        merchantOrders.newOrdersButonu.click();
        extentTest.info("NewOrders butonuna tiklandi");
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

        extentTest = extentReports.createTest("Kabul edilen odeme turune filtrelenebilir oldugu dogrulanmalidir", "Pozitif kabul edilen odeme turune gore filtrelenebilme  testi yapildi");
        merchantOrders.orderTypeDelivery.click();
        extentTest.info("Delivery secenegi kaldirildi");

        merchantOrders.paymentTypeButton.click();
        extentTest.info("Payment Type butonuna tiklandi");
        merchantOrders.newOrdersUnpaidDropDown.click();
        extentTest.info("Unpaid secenegi secildi");
        ReusableMethods.wait(3);
        String expectedIcerik="teamdort";
        String actualIcerik=merchantOrders.customerBilgileri.getText();
        Assert.assertTrue(actualIcerik.contains(expectedIcerik));
        extentTest.pass("Filtreleme sonucunda odeme turu ile musteri  bilgileri gorulme testi yapildi");
        ReusableMethods.wait(2);
        Driver.closeDriver();

    }
}

