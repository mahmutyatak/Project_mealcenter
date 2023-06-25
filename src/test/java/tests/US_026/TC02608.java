package tests.US_026;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.merchantMealscenter.MerchantDashboard;
import pages.merchantMealscenter.MerchantOrders;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.nio.file.Files;
import java.nio.file.Paths;

public class TC02608 extends TestBaseRapor {

    MerchantDashboard merchantDashboard=new MerchantDashboard();
    MerchantOrders merchantOrders=new MerchantOrders();
    @Test
    public void test01() {

        extentTest = extentReports.createTest("Siparisin gorulur olmalidir", "Siparis gorulme testi yapildi");
        merchantDashboard.signInMerchantMethod();
        extentTest.info("Merchant sitesine giris yapildi");
        merchantOrders.ordersButton.click();
        extentTest.info("Orders butonuna tiklandi");
        merchantOrders.newOrdersButonu.click();
        extentTest.info("NewOrders butonuna tiklandi");
        merchantOrders.ucnoktaBolumu.click();
        extentTest.info("UC nokta tusuna tiklanir");

        merchantOrders.contactCostumerUcnokta.click();
        extentTest.info("Contact customer bolumune tiklanir");

        String expectedIcerik= ("+90444444444");
        String actualIcerik= merchantOrders.contactCustomer.getText();
        Assert.assertTrue(actualIcerik.contains(expectedIcerik));

    }
    @Test
    public void test02() {

        extentTest = extentReports.createTest("Siparis erteleme yapildigi dogrulanmalidir", "Pozitif siparis erteleme testi yapildi");
        merchantOrders.contactCustomerOkayButonu.click();
        extentTest.info("okay tusuna basilir");
        merchantOrders.ucnoktaBolumu.click();
        extentTest.info("UC nokta tusuna tiklanir");
        merchantOrders.delayOrdercUcnokta.click();
        extentTest.info("Delay Order tusuna basilir");
        merchantOrders.delayOrderErteleme.click();
        extentTest.info("5 dakika erteleme tusuna basilir");
        merchantOrders.delayOrderConfirm.click();
        extentTest.info("Confirm tusuna basilir");
        Assert.assertFalse(merchantOrders.delayOrderErteleme.isSelected());
        extentTest.pass("Siparis erteleme testi yapildi");

    }
    @Test
    public void test03() {

        extentTest = extentReports.createTest("Siparis zaman cizelgesi gorulur dogrulanmalidir", "Pozitif siparis zaman cizelgesi testi yapildi");
        merchantOrders.ucnoktaBolumu.click();
        extentTest.info("UC nokta tusuna tiklanir");
        merchantOrders.timelineUcnokta.click();
        extentTest.info("Timeline tusuna basilir");
        String expectedIcerik="5min";
        String actualIcerik=merchantOrders.zamanInceleme.getText();
        System.out.println(actualIcerik);
        Assert.assertTrue(actualIcerik.contains(expectedIcerik));
        extentTest.pass("Zaman cizelgesi testi yapildi");


    }
    @Test
    public void test04() {

        extentTest = extentReports.createTest("Siparisin pdf olarak indirldigi dogrulanmalidir", "Pozitif siparisin pdf olarak indirilme  testi yapildi");
        merchantOrders.closeTimeline.click();
        extentTest.info("Timeline kapatildi");
        merchantOrders.ucnoktaBolumu.click();
        extentTest.info("UC nokta tusuna tiklanir");
        merchantOrders.downloadUcnokta.click();
        extentTest.info("Download tusuna basildi");
        ReusableMethods.wait(3);
        String dinamikDosyaYolu = System.getProperty("user.home") + "\\Downloads\\document.pdf";
        Assert.assertTrue(Files.exists(Paths.get(dinamikDosyaYolu)));
        extentTest.pass("Dosya indirilme testi yapildi");
        Driver.closeDriver();
    }
}
