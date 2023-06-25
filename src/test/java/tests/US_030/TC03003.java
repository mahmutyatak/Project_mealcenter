package tests.US_030;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.merchantMealscenter.MerchantDashboard;
import pages.merchantMealscenter.MerchantOrders;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC03003 extends TestBaseRapor {

    //Browser açılır.
    //Kullanıcı "https://qa.mealscenter.com/backoffice/auth/login"  adresine gider.
    //Restoran yoneticisi, username bolumune "lapalmeraAdmin " girer.
    //Restoran yoneticisi, password bolumune "1234567" girer.
    //Restoran yoneticisi,Sign in butonuna tiklar.
    //Restaurant yöneticisi tarafından sayfa açıldıktan sonra dashboard sütunun altında buluna "Orders" butonuna tıklanılır ve test edilir.
    //Restaurant yöneticisi tarafından orders kısmının altında yer alan "Scheduled" butonuna tıklanılır.
    //Restaurant yöneticisi tarafından "Scheduled" butonuna tıklanıldıktan sonra sayfada tamamlanmış siparişlerin tamamı listenilir.
    //Restaurant yöneticisi tarafından "Scheduled" butonuna tıklanıldığında görülen tamamlanmıştır.
    //her siparişin tamamlanma tarihi, sipariş numarası, adı, miktarı, fiyatı ve  görünürlüğü test edilmelidir.

    MerchantDashboard merchantDashboard = new MerchantDashboard();
    MerchantOrders merchantOrders = new MerchantOrders();

    @Test
    public void test01() {

        extentTest = extentReports.createTest("Scheduled menüsünün listesine erişim testi", "Restaurant yöneticisi completed menüsünün listesine erişim sağlayabilmeli");
        merchantDashboard.signInMerchantMethod();
        extentTest.info("Merchant giriş sayfasına erişildi");

        merchantOrders.ordersButonu.click();
        ReusableMethods.bekle(3);
        extentTest.info("Orders menüsüne tıklandı");

        merchantOrders.scheduledButonu.click();
        ReusableMethods.bekle(3);
        extentTest.info("Scheduled menüsüne tıklandı");
    }

    @Test
    public void test02() {
        extentTest = extentReports.createTest("İleriki tarihe verilmiş siparişlerin ait oldugu musteri teslimat bilgileri gorulur olmalidir", "İleriki tarihe verilmiş siparisin ait oldugu musteri teslimat bilgileri gorulme testi yapildi");
        String expectedIcerik = "teamdort";
        String actualIcerik = merchantOrders.deliveryBilgileri.getText();
        Assert.assertTrue(actualIcerik.contains(expectedIcerik));
        extentTest.pass("Siparisin ait oldugu musteri teslimat bilgileri gorulme testi yapildi");
    }

    @Test
    public void test03(){
        extentTest = extentReports.createTest("İleriki tarihe verilmiş siparisin odeme bilgileri gorulur olmalidir", "İleriki tarihe verilmiş siparisin odeme bilgileri gorulme testi yapildi");
        Actions actions= new Actions(Driver.getDriver());
        actions.sendKeys(Keys.END).perform();
        extentTest.info("Sayfa en asagiya kaydirilir");
        ReusableMethods.wait(3);
        WebElement categoryScheduledPaymentTablosu = Driver.getDriver().findElement(By.xpath("//table//tr[4]//td[1]"));
        String expectedIcerik="Payment";
        String actualIcerik = categoryScheduledPaymentTablosu.getText();
        System.out.println(actualIcerik);
        Assert.assertTrue(actualIcerik.contains(expectedIcerik));
        extentTest.pass("Siparisin odeme gecmisi bilgileri gorulme testi yapildi");

        Driver.closeDriver();
    }
}
