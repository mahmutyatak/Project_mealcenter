package tests.US_034;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.merchantMealscenter.MerchantDashboard;
import utilities.TestBaseRapor;

public class TC03402 extends TestBaseRapor {

    @Test
    public void testPageAccess(){

        extentTest=extentReports.createTest("Order Type menüsüne erişim testi","Order type menüsüne erişim sağlanabilmeli");

        MerchantDashboard merchantDashboard=new MerchantDashboard();

        //Sign in method'u kullanılarak sisteme giriş yapılır
        merchantDashboard.signInMerchantMethod();
        extentTest.info("Mealscenter Merchant sayfasına yönetici girişi yapıldı");

        //"https://qa.mealscenter.com/backoffice/merchant/dashboard" sayfasının sol tarafında yer alan menüde "Order type" menüsünü içerdiği doğrulanır.
        Assert.assertTrue(merchantDashboard.menuList.getText().contains("Order Type"));
        extentTest.pass("Merchant sayfası menüsünde Order Type seçeneğinin olduğu doğrulandı");

        //LogOut method'u kullanılarak sistemden çıkılır.
        merchantDashboard.logOutMethod();
        extentTest.info("Sistemden LogOut method'u ile çıkış yapıldı");
    }
}
