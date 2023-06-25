package tests.US_027;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.merchantMealscenter.MerchantDashboard;
import pages.merchantMealscenter.MerchantOrders;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC02709 extends TestBaseRapor {
    MerchantDashboard merchantDashboard=new MerchantDashboard();
    MerchantOrders merchantOrders=new MerchantOrders();
    @Test
    public void test01() {
        merchantDashboard=new MerchantDashboard();
        merchantOrders=new MerchantOrders();
        extentTest = extentReports.createTest("Siparisin onaylanarak Orders Ready bolumune aktarildigi dogrulanmalidir", "Pozitif Siparisin onaylanarak Orders Ready bolumune aktarildigi gorulurlugu  testi yapildi");
        merchantDashboard.signInMerchantMethod();
        extentTest.info("Merchant sitesine giris yapildi");
        merchantOrders.ordersButton.click();
        extentTest.info("Orders butonuna tiklandi");
        merchantOrders.ordersProceccingButton.click();
        extentTest.info("Orders Proceccing butonuna tiklandi");
        merchantOrders.readyForPickUpTusu.click();
        extentTest.info("Ready for pick up tusuna basildi");
        merchantOrders.ordersReadyButton.click();
        extentTest.info("Orders ready bolumune tiklanir");

        String expectedIcerik="teamdort";
        String actualIcerik=merchantOrders.solSiparisListesi.getText();
        System.out.println(actualIcerik);
        Assert.assertTrue(actualIcerik.contains(expectedIcerik));
        extentTest.pass("Onaylanan siparisin Orders Ready kisminde goruldugu dogrulandi");
        Driver.closeDriver();

    }
}
