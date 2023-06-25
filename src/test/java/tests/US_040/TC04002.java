package tests.US_040;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.adminMealscenter.AdminDashboard;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC04002 extends TestBaseRapor {


    @Test
     public void accessPromoMenu(){

        extentTest=extentReports.createTest("Promo Menüsüne erişim testi",
                "Promo menüsüne erişim sağlayabilmeli");
        AdminDashboard adminDashboard=new AdminDashboard();

        adminDashboard.signInMethodu();
        extentTest.info("Admin giriş sayfasına erişildi");

        // Promosyon Menüsüne erişim
       adminDashboard.promoLink1.click();
        extentTest.info("Promo menüsüne tıklandı");

        //Coupon Menusune erisim
        adminDashboard.promoCouponLink1.click();

        // Coupon Menüsü sayfasının açıldığı doğrulanır.
        String expectedTitle="Coupon list";
        String actualTitle=Driver.getDriver().getTitle();
       Assert.assertEquals(actualTitle,expectedTitle);
       extentTest.pass("Admin sayfası menüsünde Coupon seçeneğinin olduğu doğrulandı");
        ReusableMethods.bekle(2);
        adminDashboard.logOutMethod();
       extentTest.info("Sistemden LogOut method'u ile çıkış yapıldı");

       //Sayfa kapatilir
        Driver.closeDriver();
    }


}
