package tests.US_026;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.merchantMealscenter.MerchantDashboard;
import pages.merchantMealscenter.MerchantOrders;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC02606 extends TestBaseRapor {

    //Isim ile siparisler arasında filtreleme  yapılabilir oldugu dogrulanbilmelidir.
//Soyisim ile siparisler arasında filtrleme yapabilir oldugu dogrulanmalidir
    MerchantDashboard merchantDashboard = new MerchantDashboard();
    MerchantOrders merchantOrders = new MerchantOrders();

    @Test
    public void test01() {


        extentTest = extentReports.createTest("Siparisin gorulur olmalidir", "Siparis gorulme testi yapildi");
        extentTest.info("Merchant sitesine giris yapildi");
        merchantOrders.ordersButton.click();
        extentTest.info("Orders butonuna tiklandi");
        merchantOrders.newOrdersButonu.click();
        extentTest.info("NewOrders butonuna tiklandi");
        merchantOrders.filtreSearchBox.sendKeys("teamdort");
        extentTest.info("Arama kutusuna isim gonderildi");
        String expectedIcerik = "teamdort";
        String actualIcerik = merchantOrders.solSiparisListesi.getText();
        Assert.assertTrue(actualIcerik.contains(expectedIcerik));
        extentTest.pass("Filtreleme sonucunda isim ile musteri  bilgileri gorulme testi yapildi");
    }

    @Test
    public void test02() {
        extentTest = extentReports.createTest("Kabul edilen siparisin soyisim ile filtrelenebilir oldugu dogrulanmalidir", "Pozitif kabul edilen siparisin soyisim ile filtrelenebilme  testi yapildi");

        Actions actions = new Actions(Driver.getDriver());
        actions.click(merchantOrders.filtreSearchBox).perform();
        actions.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).perform();
        ReusableMethods.wait(3);
        extentTest.info("isim bilgisi silindi");

        merchantOrders.filtreSearchBox.sendKeys("soy");
        extentTest.info("Arama kutusuna soyisim gonderildi");
        ReusableMethods.wait(3);
        String expectedIcerik = "soy";
        String actualIcerik = merchantOrders.solSiparisListesi.getText();
        Assert.assertTrue(actualIcerik.contains(expectedIcerik));
        extentTest.pass("Filtreleme sonucunda soyisim ile musteri  bilgileri gorulme testi yapildi");
        Driver.closeDriver();
    }
}
