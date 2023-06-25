package tests.US_023;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.merchantMealscenter.MerchantDashboard;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC02305 extends TestBaseRapor {

    MerchantDashboard merchantDashboard = new MerchantDashboard();

    @Test
    public void test01() {
        merchantDashboard=new MerchantDashboard();
        extentTest = extentReports.createTest("Genel satislarin oldugu grafik gorulur olmalidir", "Pozitif genel satislarin grafigi gorulme testi yapildi");
        merchantDashboard.signInMerchantMethod();
        extentTest.info("Merchant sitesine giris yapildi");
        merchantDashboard.dashboardLink.click();
        ReusableMethods.wait(2);
        extentTest.info("Dashboard tusuna tiklandi");
        Assert.assertTrue(merchantDashboard.gorulurOlmaMethodu(merchantDashboard.getKartText(10)));
        extentTest.pass("Genel satislarin oldugu grafigin gorulurlugu testi yapildi");
        Driver.closeDriver();

    }
}
