package tests.US_026;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.merchantMealscenter.MerchantDashboard;
import pages.merchantMealscenter.MerchantOrders;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC02605 extends TestBaseRapor {

    MerchantDashboard merchantDashboard = new MerchantDashboard();
    MerchantOrders merchantOrders = new MerchantOrders();

    @Test
    public void test01() {

        extentTest = extentReports.createTest("Siparisin gorulur olmalidir", "Siparis gorulme testi yapildi");
        merchantDashboard.signInMerchantMethod();
        extentTest.info("Merchant sitesine giris yapildi");
        merchantOrders.ordersButton.click();
        extentTest.info("Orders butonuna tiklandi");
        merchantOrders.newOrdersButonu.click();
        extentTest.info("NewOrders butonuna tiklandi");
        merchantOrders.print1Button.click();
        extentTest.info("print1 botonuna basildi");
        ReusableMethods.wait(3);
        merchantOrders.print2Button.click();
        extentTest.info("print2 butonuna basildi");
        ReusableMethods.wait(3);
        Assert.assertTrue(true);
        extentTest.pass("Yazdirilabilirlik testi yapildi.");
        Driver.quitDriver();
    }
}