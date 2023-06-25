package tests.US_026;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.merchantMealscenter.MerchantDashboard;
import pages.merchantMealscenter.MerchantOrders;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC02603 extends TestBaseRapor {
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
        extentTest.info("NewOrders Proceccing butonuna tiklandi");
        extentTest.info("Assign Driver butonuna tiklanir");
        merchantOrders.assignDriverButton.click();
        extentTest.info("Assign Driver butonuna tiklanir");
        Assert.assertTrue(false);
        extentTest.pass("Asiign Driver atama testi yapildi");
        Driver.closeDriver();


    }
}
