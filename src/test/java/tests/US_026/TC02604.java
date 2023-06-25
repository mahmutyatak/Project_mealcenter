package tests.US_026;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.merchantMealscenter.MerchantDashboard;
import pages.merchantMealscenter.MerchantOrders;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC02604 extends TestBaseRapor {
    MerchantDashboard merchantDashboard=new MerchantDashboard();
    MerchantOrders merchantOrders=new MerchantOrders();
    @Test
    public void test01() {

        extentTest = extentReports.createTest("Siparisin gorulur olmalidir", "Siparis gorulme testi yapildi\"");
        merchantDashboard.signInMerchantMethod();
        extentTest.info("Merchant sitesine giris yapildi");
        merchantOrders.ordersButton.click();
        extentTest.info("Orders butonuna tiklandi");
        merchantOrders.newOrdersButonu.click();
        extentTest.info("NewOrders butonuna tiklandi");
        String expectedIcerik="Summary";
        String actualIcerik=merchantOrders.summaryBolumu.getText();
        Assert.assertTrue(actualIcerik.contains(expectedIcerik));
        extentTest.pass("siparisin ozet bilgileri gorulme testi yapildi");
        Driver.closeDriver();

    }
}

