package tests.US_028;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.merchantMealscenter.MerchantDashboard;
import pages.merchantMealscenter.MerchantOrders;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC02805 extends TestBaseRapor {

    MerchantDashboard merchantDashboard=new MerchantDashboard();
    MerchantOrders merchantOrders=new MerchantOrders();
    @Test
    public void test01() {
        merchantDashboard=new MerchantDashboard();
        merchantOrders=new MerchantOrders();
        extentTest = extentReports.createTest("Dagitima hazir olan  siparisin erteleme yapilabildigi dogrulanmalidir", "Pozitif dagitima hazir olan siparisin erteleme yapilabilme testi yapildi");
        merchantDashboard.signInMerchantMethod();
        extentTest.info("Merchant sitesine giris yapildi");
        merchantOrders.ordersButton.click();
        extentTest.info("Orders butonuna tiklandi");
        merchantOrders.ordersReadyButton.click();
        extentTest.info("Orders Ready butonuna tiklandi");
        merchantOrders.deliveryOnItsWay.click();
        extentTest.info("Delivery on its way tusuna taiklandi");
        ReusableMethods.wait(3);

        String expectedIcerik="delivery on its way";
        String actualIcerik=merchantOrders.deliveryYazisi.getText();
        Assert.assertEquals(actualIcerik,expectedIcerik);
        extentTest.pass("Ertleme testi yapildi.");

    }
    @Test
    public void test02() {
        merchantDashboard=new MerchantDashboard();
        merchantOrders=new MerchantOrders();
        extentTest = extentReports.createTest("Dagitima hazir olan  siparisin iptal edilebilmesi dogrulanmalidir.", "Pozitif dagitima hazir olan siparisin iptal edilme  testi yapildi");
        merchantOrders.deliveryFailed.click();
        extentTest.pass("Delivery failed tusuna basildi");
        String expectedIcerik="No results";
        String actualIcerik=merchantOrders.noResultYazisi.getText();
        System.out.println(actualIcerik);
        Assert.assertEquals(actualIcerik,expectedIcerik);
        extentTest.pass("Iptal edilen siparisin gorulmedigi dogrulandi");

    }
    @Test
    public void test03() {
        merchantDashboard=new MerchantDashboard();
        merchantOrders=new MerchantOrders();
        extentTest = extentReports.createTest("Dagitima hazir olan  siparisin onaylanabilmesi dogrulanmalidir.", "Pozitif dagitima hazir olan siparisin onaylanabilme  testi yapildi");
        merchantOrders.ordersButton.click();
        extentTest.info("Orders butonuna tiklandi");
        merchantOrders.ordersProceccingButton.click();
        extentTest.info("Orders Proceccing butonuna tiklandi");
        merchantOrders.readyForPickUpTusu.click();
        extentTest.info("Ready for pick up tusuna basildi");
        merchantOrders.ordersReadyButton.click();
        extentTest.info("Orders Ready butonuna tiklandi");
        merchantOrders.deliveredButton.click();
        extentTest.info("Delivered butonuna tiklanir");
        merchantOrders.CompletedButton.click();
        extentTest.info("Copleted tusuna tıklandi");

        String expectedIcerik="teamdort";
        String actualIcerik=merchantOrders.solSiparisListesi.getText();
        System.out.println(actualIcerik);
        Assert.assertTrue(actualIcerik.contains(expectedIcerik));
        extentTest.pass("Onaylanan siparisin ordersReady kisminde goruldugu dogrulandi");

    }
}
