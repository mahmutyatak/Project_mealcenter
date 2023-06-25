package tests.US_027;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.merchantMealscenter.MerchantDashboard;
import pages.merchantMealscenter.MerchantOrders;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC02701 extends TestBaseRapor {
MerchantDashboard merchantDashboard=new MerchantDashboard();
MerchantOrders merchantOrders=new MerchantOrders();
    @Test
    public void test01() {
        merchantDashboard=new MerchantDashboard();
        merchantOrders=new MerchantOrders();
        //Reastaurantın toplam siparis adetinin gorulur oldugu dogrulanabilmelidir.
        extentTest = extentReports.createTest("Kabul edilen siparisin gorulur olmalidir", "Pozitif kabul edilen siparis gorulme testi yapildi");
        merchantDashboard.signInMerchantMethod();
        extentTest.info("Merchant sitesine giris yapildi");
        merchantOrders.ordersButton.click();
        extentTest.info("Orders butonuna tiklandi");
        merchantOrders.ordersProceccingButton.click();
        extentTest.info("Orders Proceccing butonuna tiklandi");

        String expectedIcerik="teamdort";
        String actualIcerik=merchantOrders.solSiparisListesi.getText();
        System.out.println(actualIcerik);
        Assert.assertTrue(actualIcerik.contains(expectedIcerik));
        extentTest.pass("Onaylanan siparisin proceccing kisminde goruldugu dogrulandi");
        Driver.closeDriver();
    }
}
