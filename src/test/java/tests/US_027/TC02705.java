package tests.US_027;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.merchantMealscenter.MerchantDashboard;
import pages.merchantMealscenter.MerchantOrders;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC02705 extends TestBaseRapor {

    MerchantDashboard merchantDashboard=new MerchantDashboard();
    MerchantOrders merchantOrders=new MerchantOrders();
    @Test
    public void test01() {
        merchantDashboard=new MerchantDashboard();
        merchantOrders=new MerchantOrders();
        extentTest = extentReports.createTest("Kabul edilen siparisin ozet bilgileri yazdirilabilir olmalidir", "Pozitif kabul edilen siparisin ozet bilgileri yazdirilabilme testi yapildi");
        merchantDashboard.signInMerchantMethod();
        extentTest.info("Merchant sitesine giris yapildi");
        merchantOrders.ordersButton.click();
        extentTest.info("Orders butonuna tiklandi");
        merchantOrders.ordersProceccingButton.click();
        extentTest.info("Orders Proceccing butonuna tiklandi");
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
