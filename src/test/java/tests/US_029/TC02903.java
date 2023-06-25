package tests.US_029;

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

public class TC02903 extends TestBaseRapor {

    //Browser açılır.
    //Kullanıcı "https://qa.mealscenter.com/backoffice/auth/login"  adresine gider.
    //Restoran yoneticisi, username bolumune "lapalmeraAdmin " girer.
    //Restoran yoneticisi, password bolumune "1234567" girer.
    //Restoran yoneticisi,Sign in butonuna tiklar.
    //Restaurant yöneticisi tarafından sayfa açıldıktan sonra dashboard sütunun altında buluna "Orders" butonuna tıklanılır ve test edilir.
    //Restaurant yöneticisi tarafından orders kısmının altında yer alan "Completed" butonuna tıklanılır.
    //Restaurant yöneticisi tarafından "Completed" butonuna tıklanıldıktan sonra sayfada tamamlanmış siparişlerin tamamı listenilir.
    //Restaurant yöneticisi tarafından"Completed" butonuna tıklanıldığında görülen tamamlanmış
    //her siparişin tamamlanma tarihi, sipariş numarası, adı, miktarı, fiyatı ve  görünürlüğü test edilmelidir.

    MerchantDashboard merchantDashboard = new MerchantDashboard();
    MerchantOrders merchantOrders = new MerchantOrders();

    @Test
    public void test01() {

        extentTest = extentReports.createTest("Completed menüsünün listesine erişim testi", "Restaurant yöneticisi completed menüsünün listesine erişim sağlayabilmeli");
        merchantDashboard.signInMerchantMethod();
        extentTest.info("Merchant giriş sayfasına erişildi");

        merchantOrders.ordersButonu.click();
        ReusableMethods.bekle(3);
        extentTest.info("Orders menüsüne tıklandı");

        merchantOrders.completedButonu.click();
        ReusableMethods.bekle(3);
        extentTest.info("Completed menüsüne tıklandı");
    }

    @Test
    public void test02() {
        extentTest = extentReports.createTest("Tamamlanmış siparişlerin ait oldugu musteri teslimat bilgileri gorulur olmalidir", "Tamamlanmış siparisin ait oldugu musteri teslimat bilgileri gorulme testi yapildi");
        String expectedIcerik = "teamdort";
        String actualIcerik = merchantOrders.deliveryBilgileri.getText();
        Assert.assertTrue(actualIcerik.contains(expectedIcerik));
        extentTest.pass("Siparisin ait oldugu musteri teslimat bilgileri gorulme testi yapildi");
    }

    @Test
    public void test03(){
        extentTest = extentReports.createTest("Tamamlanan siparisin odeme bilgileri gorulur olmalidir", "Tamamlnamış siparisin odeme bilgileri gorulme testi yapildi");
        Actions actions= new Actions(Driver.getDriver());
        actions.sendKeys(Keys.END).perform();
        extentTest.info("Sayfa en asagiya kaydirilir");
        ReusableMethods.wait(3);
        WebElement categoryCompletedPaymentTablosu = Driver.getDriver().findElement(By.xpath("//table//tr[4]//td[1]"));
        String expectedIcerik="Payment";
        String actualIcerik = categoryCompletedPaymentTablosu.getText();
        System.out.println(actualIcerik);
        Assert.assertTrue(actualIcerik.contains(expectedIcerik));
        extentTest.pass("Siparisin odeme gecmisi bilgileri gorulme testi yapildi");

        Driver.closeDriver();
    }
}
