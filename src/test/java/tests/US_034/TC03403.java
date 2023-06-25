package tests.US_034;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.merchantMealscenter.MerchantDashboard;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC03403 extends TestBaseRapor {

    @Test
    public void test(){

        extentTest=extentReports.createTest("Settings sayfa testi","Delivery Settings sayfasını içerdiği doğrulanmalı");

        MerchantDashboard merchantDashboard=new MerchantDashboard();

        //Sign in method'u kullanılarak sisteme giriş yapılır
        merchantDashboard.signInMerchantMethod();
        extentTest.info("Mealscenter Merchant sayfasına yönetici girişi yapıldı");

        //"https://qa.mealscenter.com/backoffice/merchant/dashboard" sayfasının sol tarafında yer alan menüde "Order type" menüsüne tıklanır.
        merchantDashboard.orderTypeLink.click();
        extentTest.info("Order Type linkine tıklandı");

        //Altında açılan menüde "Delivery" kısmına tıklanır.
        merchantDashboard.orderTypeDeliveryLink.click();
        extentTest.info("Order Type Menüsü altında bulunan Delivery linkine tıklandı");

        //Açılan sayfada "Delivery Settings" yazısının görünürlüğü doğrulanır.
        String pageSource= Driver.getDriver().getPageSource();
        Assert.assertTrue(pageSource.contains("Settings"),"Sayfa Settings içermiyor");
        extentTest.pass("Delivery Settings yazısının görünürlüğü doğrulandı");

        //LogOut method'u kullanılarak sistemden çıkılır.
        merchantDashboard.logOutMethod();
        extentTest.info("Sistemden LogOut method'u ile çıkış yapıldı");
    }
}
