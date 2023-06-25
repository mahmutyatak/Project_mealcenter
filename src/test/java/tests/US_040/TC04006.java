package tests.US_040;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.adminMealscenter.AdminDashboard;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC04006 extends TestBaseRapor {

    //       *BUG*
    // search kutusuna metin girilebiliyor fakat arama yapmiyor

    @Test
     public void searchPromotion() {

        Actions actions = new Actions(Driver.getDriver());

        extentTest = extentReports.createTest("Promo Menüsüne coupon arama  testi",
                "Promo menüsüne erişim sağlayıp Couponlar arasinda arama islemi yapabilmeli");
        AdminDashboard adminDashboard = new AdminDashboard();

        adminDashboard.signInMethodu();
        extentTest.info("Merchant giriş sayfasına erişim sağlandı");

        // Promosyon Menüsüne erişim
        adminDashboard.promoLink1.click();
        extentTest.info("Promo menüsüne tıklandı");

        // Promosyon Menüsü sayfasının açıldığı doğrulanır.
        Assert.assertTrue(adminDashboard.menuList.getText().contains("Promo"));
        extentTest.info("Merchant sayfası menüsünde Promo seçeneğinin olduğu doğrulandı");

        //Promo menüsünün altında yer alan Coupon bölümüne tıklanır.
        adminDashboard.promoCouponLink1.click();
        extentTest.info("Promo menusu altında yer alan Coupon butonuna tıklandı");

        //Coupon bolumunde search box'a tiklanir
        //Bug!!!! search box'a yazi gonderiliyor fakat arama islemi yapilamiyor
        adminDashboard.couponSearchBoxElementi.sendKeys("LaPalmera");
        ReusableMethods.bekle(2);
        Assert.assertTrue(adminDashboard.couponSearchBoxElementi.isSelected());
        extentTest.pass("Coupon sayfasinda arama kutusunun calismadigi test edildi");

        //Kullanici profili bolumunden Logout butonuna tiklanarak cikis yapilir
        adminDashboard.logOutMethod();

        //Sayfa kapatilir
        Driver.closeDriver();

    }
}
