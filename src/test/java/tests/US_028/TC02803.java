package tests.US_028;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.merchantMealscenter.MerchantDashboard;
import pages.merchantMealscenter.MerchantOrders;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC02803 extends TestBaseRapor {

    MerchantDashboard merchantDashboard=new MerchantDashboard();
    MerchantOrders merchantOrders=new MerchantOrders();
    @Test
    public void test01() {
        merchantDashboard=new MerchantDashboard();
        merchantOrders=new MerchantOrders();
        extentTest = extentReports.createTest("Kabul edilen siparisin ait surucu bilgileri gorulur olmalidir", "Pozitif kabul edilen siparisin ait surucu bilgileri gorulme testi yapildi");
        merchantDashboard.signInMerchantMethod();
        extentTest.info("Merchant sitesine giris yapildi");
        merchantOrders.ordersButton.click();
        extentTest.info("Orders butonuna tiklandi");
        merchantOrders.ordersReadyButton.click();
        extentTest.info("Orders Ready butonuna tiklandi");
        merchantOrders.assignDriverButton.click();
        extentTest.info("Assign Driver butonuna tiklanir");
        Assert.assertTrue(false);
        extentTest.pass("Asiign Driver atama testi yapildi");
        Driver.closeDriver();


    }
}
