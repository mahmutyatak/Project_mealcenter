package tests.US_040;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.adminMealscenter.AdminDashboard;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.util.List;

public class TC04005 extends TestBaseRapor {


    @Test
    public void verifyListCouponTest() {

         Actions actions = new Actions(Driver.getDriver());

        extentTest = extentReports.createTest("Promo Menüsüne Coupon siralama oluşturma testi",
                "Promo menüsüne erişim sağlayıp Coupon'lari isme ve kullanim sayisina gore listeleyebilmeli");
        AdminDashboard adminDashboard = new AdminDashboard();

        adminDashboard.signInMethodu();
        extentTest.info("Admin giriş sayfasına erişim sağlandı");

        // Promosyon Menüsüne erişim
        adminDashboard.promoLink1.click();
        extentTest.info("Promo menüsüne tıklandı");

        // Promosyon Menüsü sayfasının açıldığı doğrulanır.
        Assert.assertTrue(adminDashboard.menuList.getText().contains("Promo"));
        extentTest.info("Admin sayfası menüsünde Promo seçeneğinin olduğu doğrulandı");

        //Promo menüsünün altında yer alan Coupon bölümüne tıklanır.
        adminDashboard.promoCouponLink1.click();
        extentTest.info("Promo menusu altında yer alan Coupon butonuna tıklandı");

        //Name butonuna tiklanir
        System.out.println("--------------------");
        ReusableMethods.bekle(2);
        adminDashboard.couponNameElementi.click();
        ReusableMethods.bekle(5);
        List<WebElement> siraliCouponList=Driver.getDriver().findElements(By.xpath("//tr//td[2]"));
        char ilkHarf=siraliCouponList.get(0).getText().toLowerCase().charAt(0);
        boolean sart=true;
        for (int i = 0; i <siraliCouponList.size() ; i++) {
            if (!(ilkHarf <= siraliCouponList.get(i).getText().toLowerCase().charAt(0))) {
                sart = false;
            }
            ilkHarf=siraliCouponList.get(i).getText().toLowerCase().charAt(0);
        }
        //Kuponlarin harfe gore siralandigi dogrulanir
        Assert.assertTrue(sart);
        extentTest.pass("Kuponlar harf sirasina gore listelendi");




        //#Used butonuna tiklanir
        System.out.println("--------------------");
        ReusableMethods.bekle(2);
        adminDashboard.usedElementi.click();
        ReusableMethods.bekle(2);
        List<WebElement> UsedList=Driver.getDriver().findElements(By.xpath("//tr//td[2]"));
       char ilkUsed=UsedList.get(0).getText().toLowerCase().charAt(0);
        boolean sartUsed=true;
        for (int i = 0; i <UsedList.size() ; i++) {
            if (!(ilkHarf <= UsedList.get(i).getText().toLowerCase().charAt(0))) {
                sartUsed = false;
            }
            ilkUsed=UsedList.get(i).getText().toLowerCase().charAt(0);
        }
        //Kuponlarin kullanim miktarina gore siralandigi dogrulanir
        Assert.assertTrue(!sartUsed);
        extentTest.pass("Kuponlar kullanim sirasina gore listelendi");
        ReusableMethods.bekle(2);

        //Kullanici profili bolumunden Logout butonuna tiklanarak cikis yapilir
        adminDashboard.logOutMethod();
        //Sayfa kapatilir
        Driver.closeDriver();


    }
}