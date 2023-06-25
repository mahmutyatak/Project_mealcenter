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

public class TC02904 extends TestBaseRapor {

    //Browser açılır.
    //Kullanıcı "https://qa.mealscenter.com/backoffice/auth/login"  adresine gider.
    //Restoran yoneticisi, username bolumune "lapalmeraAdmin " girer.
    //Restoran yoneticisi, password bolumune "1234567" girer.
    //Restoran yoneticisi,Sign in butonuna tiklar.
    //Restaurant yöneticisi tarafından sayfa açıldıktan sonra dashboard sütunun altında buluna "Orders" butonuna tıklanılır ve test edilir.
    //Restaurant yöneticisi tarafından orders kısmının altında yer alan "Completed" butonuna tıklanılır.
    //Restaurant yöneticisi tarafından "Completed" butonuna tıklanıldıktan sonra sayfada tamamlanmış siparişlerin tamamı listenilir.
    //Restaurant yöneticisi tarafından arama butonuna isim soyisim gonderilir ve filtreleme test edilir.
    //Restaurant yöneticisi tarafından "Order Type" butonuna tıklanır çıkan "Delivery" butonuna tıklanır ve filtreleme test edilir.
    //Restaurant yöneticisi tarafından "Payment Status" butonuna tıklanır çıkan "Paid" butonuna tıklanır ve filtreleme test edilir.

    MerchantDashboard merchantDashboard=new MerchantDashboard();
    MerchantOrders merchantOrders=new MerchantOrders();

    @Test
    public void test01() {

        extentTest = extentReports.createTest("Tamamlanan siparisin isim ile filtrelenebilir oldugu dogrulanmalidir", "Tamamlanan siparisin isim ile filtrelenebilme  testi yapildi");
        merchantDashboard.signInMerchantMethod();
        extentTest.info("Merchant sitesine giris yapildi");
        merchantOrders.ordersButton.click();
        extentTest.info("Orders butonuna tiklandi");
        merchantOrders.completedButonu.click();
        extentTest.info("Completed butonuna tiklandi");
        merchantOrders.filtreSearchBox.sendKeys("teamdort");
        extentTest.info("Arama kutusuna isim gonderildi");
        ReusableMethods.wait(2);
        String expectedIcerik="teamdort";
        String actualIcerik=merchantOrders.solSiparisListesi.getText();
        Assert.assertTrue(actualIcerik.contains(expectedIcerik));
        extentTest.pass("Filtreleme sonucunda isim ile musteri  bilgileri gorulme testi yapildi");
    }
    @Test
    public void test02(){
        extentTest = extentReports.createTest("Tamamlanan siparisin soyisim ile filtrelenebilir oldugu dogrulanmalidir", "Tamamlanan siparisin soyisim ile filtrelenebilme  testi yapildi");

        Actions actions=new Actions(Driver.getDriver());
        actions.click(merchantOrders.filtreSearchBox).perform();
        actions.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).perform();
        ReusableMethods.wait(2);
        extentTest.info("isim bilgisi silindi");

        merchantOrders.filtreSearchBox.sendKeys("soy");
        extentTest.info("Arama kutusuna soyisim gonderildi");
        ReusableMethods.wait(2);
        String expectedIcerik="soy";
        String actualIcerik=merchantOrders.solSiparisListesi.getText();
        Assert.assertTrue(actualIcerik.contains(expectedIcerik));
        extentTest.pass("Filtreleme sonucunda soyisim ile musteri  bilgileri gorulme testi yapildi");

    }

    @Test
    public void test03() {

        extentTest = extentReports.createTest("Tamamlanan siparisin turune filtrelenebilir oldugu dogrulanmalidir", "Pozitif kabul edilen siparisin turune gore filtrelenebilme  testi yapildi");
        merchantOrders.completedOrderTypeButonu.click();
        extentTest.info("Order Type tusuna tiklandi");

        merchantOrders.completedDeliveryFiltresi.click();
        extentTest.info("Delivery secenegi secildi");
        ReusableMethods.wait(2);
        String expectedIcerik="teamdort";
        String actualIcerik=merchantOrders.customerBilgileri.getText();
        Assert.assertTrue(actualIcerik.contains(expectedIcerik));
        extentTest.pass("Filtreleme sonucunda siparis turu ile musteri  bilgileri gorulme testi yapildi");

    }

    @Test
    public void test04() {

        extentTest = extentReports.createTest("Kabul edilen odeme turune filtrelenebilir oldugu dogrulanmalidir", "Pozitif kabul edilen odeme turune gore filtrelenebilme  testi yapildi");
        merchantOrders.orderTypeDelivery.click();
        extentTest.info("Delivery secenegi kaldirildi");

        merchantOrders.completedPaymentStatusButonu.click();
        extentTest.info("Payment Type butonuna tiklandi");

        merchantOrders.completedPaidFiltresi.click();
        extentTest.info("Paid secenegi secildi");
        ReusableMethods.wait(2);
        WebElement completedCustomerBilgileri = Driver.getDriver().findElement(By.xpath("(//div[@class='d-flex mt-3'])[1]"));
        String expectedIcerik="teamdort";
        String actualIcerik=completedCustomerBilgileri.getText();
        Assert.assertTrue(actualIcerik.contains(expectedIcerik));
        extentTest.pass("Filtreleme sonucunda odeme turu ile musteri  bilgileri gorulme testi yapildi");

        Driver.closeDriver();

    }
}
