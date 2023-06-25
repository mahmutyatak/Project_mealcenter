package tests.US_028;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.merchantMealscenter.MerchantDashboard;
import pages.merchantMealscenter.MerchantOrders;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC02804 extends TestBaseRapor {
    MerchantDashboard merchantDashboard=new MerchantDashboard();
    MerchantOrders merchantOrders=new MerchantOrders();
    @Test
    public void test01() {
        merchantDashboard=new MerchantDashboard();
        merchantOrders=new MerchantOrders();
        extentTest = extentReports.createTest("Dagitima hazir olan  siparisin ozet bilgileri gorulur olmalidir", "Pozitif dagitima hazir olan siparisin ozet bilgileri gorulme testi yapildi");
        merchantDashboard.signInMerchantMethod();
        extentTest.info("Merchant sitesine giris yapildi");
        merchantOrders.ordersButton.click();
        extentTest.info("Orders butonuna tiklandi");
        merchantOrders.ordersReadyButton.click();
        extentTest.info("Orders Ready butonuna tiklandi");
        String expectedIcerik = "Summary";
        String actualIcerik = merchantOrders.summaryBolumu.getText();
        Assert.assertTrue(actualIcerik.contains(expectedIcerik));
        extentTest.pass("Dagitima hazir olan  siparisin ozet bilgileri gorulme testi yapildi");
        Driver.closeDriver();
     }

    }
