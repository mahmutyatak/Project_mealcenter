package tests.US_023;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.merchantMealscenter.MerchantDashboard;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC02302  extends TestBaseRapor {
    //Ozet bilgiler bolumunde haftalık satıs tutarını gorulur oldugu dogrulanmalidir.
    //Ozet bilgiler bolumunde haftalık kazanc tutarını gorulur oldugu dogrulanmalidir.
    //Ozet bilgiler bolumunde toplam tutarını gorulur oldugu dogrulanmalidir.
    //Ozet bilgiler bolumunde gunluk kabul edilmis siparis miktarını gorulur oldugu dogrulanmalidir
    //Ozet bilgiler bolumunde gunluk teslim edilmis siparis miktarını gorulur oldugu dogrulanmalidir.
    //Ozet bilgiler bolumunde gunluk satis tutarini gorulur oldugu dogrulanmalidir
    //Ozet bilgiler bolumunde gunluk geri odeme tutarini gorulur oldugu dogrulanmalidir.
    MerchantDashboard merchantDashboard=new MerchantDashboard();

    @Test
    public void test01(){
        merchantDashboard=new MerchantDashboard();
        extentTest = extentReports.createTest("Ozet bilgiler bolumunda haftalik satis tutari gorulur olmalidir", "Pozitif haftalik satis tutari gorulme testi yapildi");
        merchantDashboard.signInMerchantMethod();
        extentTest.info("Merchant sitesine giris yapildi");
        merchantDashboard.dashboardLink.click();
        ReusableMethods.wait(2);
        extentTest.info("Dashboard tusuna tiklandi");
        Assert.assertTrue(merchantDashboard.gorulurOlmaMethodu(merchantDashboard.getKartText(1)));
        extentTest.pass("Haftalik satis tutari gorulurlugu testi yapildi");


    }
    @Test
    public void test02(){
        merchantDashboard=new MerchantDashboard();
        extentTest = extentReports.createTest("Ozet bilgiler bolumunda haftalik kazanc tutari gorulur olmalidir", "Pozitif haftalik kazanc tutari gorulme testi yapildi");
        merchantDashboard.dashboardLink.click();
        ReusableMethods.wait(2);
        extentTest.info("Dashboard tusuna tiklandi");
        Assert.assertTrue(merchantDashboard.gorulurOlmaMethodu(merchantDashboard.getKartText(2)));
        extentTest.pass("Haftalik kazanc tutari gorulurlugu testi yapildi");
    }
    @Test
    public void test03(){
        merchantDashboard=new MerchantDashboard();
        extentTest = extentReports.createTest("Ozet bilgiler bolumunda toplam tutari gorulur olmalidir", "Pozitif toplam tutari gorulme testi yapildi");
        merchantDashboard.dashboardLink.click();
        ReusableMethods.wait(2);
        extentTest.info("Dashboard tusuna tiklandi");
        Assert.assertTrue(merchantDashboard.gorulurOlmaMethodu(merchantDashboard.getKartText(3)));
        extentTest.pass("Toplam tutarin gorulurlugu testi yapildi");
    }
    @Test
    public void test04(){
        merchantDashboard=new MerchantDashboard();
        extentTest = extentReports.createTest("Ozet bilgiler bolumunda gunluk kabul edilmis siparis mistari gorulur olmalidir", "Pozitif gunluk kabul edilmis siparis miktari gorulme  testi yapildi");
        merchantDashboard.dashboardLink.click();
        ReusableMethods.wait(2);
        extentTest.info("Dashboard tusuna tiklandi");
        Assert.assertTrue(merchantDashboard.gorulurOlmaMethodu(merchantDashboard.getKartText(4)));
        extentTest.pass("Gunluk kabul edilmis siparis miktari gorulme testi yapildi");
    }
    @Test
    public void test05(){
        merchantDashboard=new MerchantDashboard();
        extentTest = extentReports.createTest("Ozet bilgiler bolumunda gunluk teslim edilmis siparis mistari gorulur olmalidir", "Pozitif gunluk teslim edilmis siparis miktari gorulme  testi yapildi");
        merchantDashboard.dashboardLink.click();
        ReusableMethods.wait(2);
        extentTest.info("Dashboard tusuna tiklandi");
        Assert.assertTrue(merchantDashboard.gorulurOlmaMethodu(merchantDashboard.getKartText(5)));
        extentTest.pass("Gunluk teslim edilmis siparis miktari gorulme testi yapildi");
    }
    @Test
    public void test06(){
        merchantDashboard=new MerchantDashboard();
        extentTest = extentReports.createTest("Ozet bilgiler bolumunda gunluk satis tutari gorulur olmalidir", "Pozitif gunluk satis tutari gorulme  testi yapildi");
        merchantDashboard.dashboardLink.click();
        ReusableMethods.wait(2);
        extentTest.info("Dashboard tusuna tiklandi");
        Assert.assertTrue(merchantDashboard.gorulurOlmaMethodu(merchantDashboard.getKartText(6)));
        extentTest.pass("Gunluk satis tutari gorulme testi yapildi");
    }
    @Test
    public void test07(){
        merchantDashboard=new MerchantDashboard();
        extentTest = extentReports.createTest("Ozet bilgiler bolumunda gunluk geri odeme tutari gorulur olmalidir", "Pozitif gunluk geri odeme tutari gorulme  testi yapildi");
        merchantDashboard.dashboardLink.click();
        ReusableMethods.wait(2);
        extentTest.info("Dashboard tusuna tiklandi");
        Assert.assertTrue(merchantDashboard.gorulurOlmaMethodu(merchantDashboard.getKartText(7)));
        extentTest.pass("Gunluk geri odeme tutari gorulme testi yapildi");
        Driver.closeDriver();
    }


}
