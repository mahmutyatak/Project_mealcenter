package tests.US_027;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.merchantMealscenter.MerchantDashboard;
import pages.merchantMealscenter.MerchantOrders;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC02704 extends TestBaseRapor {
    MerchantDashboard merchantDashboard=new MerchantDashboard();
    MerchantOrders merchantOrders=new MerchantOrders();
    @Test
    public void test01() {
        merchantDashboard=new MerchantDashboard();
        merchantOrders=new MerchantOrders();
        extentTest = extentReports.createTest("Kabul edilen siparisin ozet bilgileri gorulur olmalidir", "Pozitif kabul edilen siparisin ozet bilgileri gorulme testi yapildi");
        merchantDashboard.signInMerchantMethod();
        extentTest.info("Merchant sitesine giris yapildi");
        merchantOrders.ordersButton.click();
        extentTest.info("Orders butonuna tiklandi");
        merchantOrders.ordersProceccingButton.click();
        extentTest.info("Orders Proceccing butonuna tiklandi");
        String expectedIcerik="Summary";
        String actualIcerik=merchantOrders.summaryBolumu.getText();
        Assert.assertTrue(actualIcerik.contains(expectedIcerik));
        extentTest.pass("Kabul edilen siparisin ozet bilgileri gorulme testi yapildi");
        Driver.closeDriver();

    }
}
