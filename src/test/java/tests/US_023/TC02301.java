package tests.US_023;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.merchantMealscenter.MerchantDashboard;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC02301 extends TestBaseRapor {

    MerchantDashboard merchantDashboard = new MerchantDashboard();

    @Test(groups = "demo")
    public void test01() {
        merchantDashboard=new MerchantDashboard();
        //Reastaurantın toplam siparis adetinin gorulur oldugu dogrulanabilmelidir.
        extentTest = extentReports.createTest("Restaurantin toplam siparis adedi gorulur olmalidir", "Pozitif restaurantin toplam siparis adedi gorulme testi yapildi");
        merchantDashboard.signInMerchantMethod();
        extentTest.info("Merchant sitesine giris yapildi");
        merchantDashboard.dashboardLink.click();
        ReusableMethods.wait(2);
        extentTest.info("Dashboard tusuna tiklandi");
        Assert.assertTrue(merchantDashboard.gorulurOlmaMethodu(merchantDashboard.getResimText2(1)));
        extentTest.pass("Reastaurantın toplam siparis adeti gorulurlugu testi yapildi");

    }

    @Test(groups = "demo")
    public void test02() {
        merchantDashboard=new MerchantDashboard();
        extentTest = extentReports.createTest("Restaurantin iptal edilen toplam siparis adedi gorulur olmalidir", "Pozitif restaurantin iptal edilen toplam siparis adedi gorulme testi yapildi");
        //Reastaurantın iptal edilen toplam siparis sayısını gorulur oldugu dogrulanabilmelidir.
        merchantDashboard.dashboardLink.click();
        extentTest.info("Dashboard tusuna tiklandi");
        ReusableMethods.wait(2);
        Assert.assertTrue(merchantDashboard.gorulurOlmaMethodu(merchantDashboard.getResimText2(2)));
        extentTest.pass("Reastaurantın iptal edilen toplam siparis adeti gorulurlugu testi yapildi");
    }

    @Test(groups = "demo")
    public void test03() {
        merchantDashboard=new MerchantDashboard();
        extentTest = extentReports.createTest("Restaurantin toplam geri odeme yaptigi tutar gorulur olmalidir", "Pozitif restaurantin toplam geri odeme yaptigi tutarin gorulme testi yapildi");
        //Reastaurantın iptal edilen toplam siparis sayısını gorulur oldugu dogrulanabilmelidir.
        merchantDashboard.dashboardLink.click();
        extentTest.info("Dashboard tusuna tiklandi");
        ReusableMethods.wait(2);
        Assert.assertTrue(merchantDashboard.gorulurOlmaMethodu(merchantDashboard.getResimText2(3)));
        extentTest.pass("Restaurantin toplam geri odeme yaptigi tutarin gorulme testi yapildi");
    }

    @Test(groups = "demo")
    public void test04() {
        merchantDashboard=new MerchantDashboard();
        extentTest = extentReports.createTest("Restaurantin toplam satis tutari gorulur olmalidir", "Pozitif restaurantin toplam satis  tutarin gorulme testi yapildi");
        //Reastaurantın iptal edilen toplam siparis sayısını gorulur oldugu dogrulanabilmelidir.
        merchantDashboard.dashboardLink.click();
        extentTest.info("Dashboard tusuna tiklandi");
        ReusableMethods.wait(2);
        Assert.assertTrue(merchantDashboard.gorulurOlmaMethodu(merchantDashboard.getResimText2(4)));
        extentTest.pass("Restaurantin toplam satis tutarin gorulme testi yapildi");
        //Driver.closeDriver();
    }
}


