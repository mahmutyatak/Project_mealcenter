package tests.US_033;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.merchantMealscenter.MerchantDashboard;
import utilities.TestBaseRapor;

public class TC03302 extends TestBaseRapor {


    @Test
    public void accessPromoMenu(){

        extentTest=extentReports.createTest("Promo Menüsüne erişim testi","Promo menüsüne erişim sağlayabilmeli");
        MerchantDashboard merchantDashboard=new MerchantDashboard();

        merchantDashboard.signInMerchantMethod();
        extentTest.info("Merchant giriş sayfasına erişildi");

        // Promo Menüsüne tıklanır
        merchantDashboard.promoLink.click();
        extentTest.info("Promo menüsüne tıklandı");

        // Promosyon Menüsü sayfasının açıldığı doğrulanır.
        Assert.assertTrue(merchantDashboard.menuList.getText().contains("Promo"));
        extentTest.pass("Merchant sayfası menüsünde Promo seçeneğinin olduğu doğrulandı");

        merchantDashboard.logOutMethod();
        extentTest.info("Sistemden LogOut method'u ile çıkış yapıldı");
    }
}
