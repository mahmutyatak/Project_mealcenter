package tests.US_031;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.merchantMealscenter.MerchantDashboard;
import pages.merchantMealscenter.MerchantOrders;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC03103 extends TestBaseRapor {

    //Browser açılır.
    //Kullanıcı "https://qa.mealscenter.com/backoffice/auth/login"  adresine gider.
    //Restoran yoneticisi, username bolumune "lapalmeraAdmin " girer.
    //Restoran yoneticisi, password bolumune "1234567" girer.
    //Restoran yoneticisi,Sign in butonuna tiklar.
    //Restaurant yöneticisi tarafından sayfa açıldıktan sonra dashboard sütunun altında buluna "Orders" butonuna tıklanılır ve test edilir.
    //Restaurant yöneticisi tarafından orders kısmının altında yer alan "All Orders" butonuna tıklanılır.
    //Restaurant yöneticisi tarafından "All Orders" butonuna tıklanıldıktan sonra sayfada oluşturulmuş siparişlerin tamamı listenilir.
    //Restaurant yöneticisi tarafından "All Orders" butonuna tıklanıldığında görülen tamamlanmış
    //her siparişin sipariş numarası, adı, miktarı, fiyatı ve siparişin tamamlanma tarihi görünürlüğü test edilmelidir.
    MerchantDashboard merchantDashboard=new MerchantDashboard();
    MerchantOrders merchantOrders=new MerchantOrders();

    @Test
    public void test01(){

        extentTest=extentReports.createTest("All Orders menüsüne erişim testi","Restaurant yöneticisi all Orders menüsüne erişim sağlayabilmeli");
        merchantDashboard.signInMerchantMethod();
        extentTest.info("Merchant giriş sayfasına erişildi");

        merchantOrders.ordersButonu.click();
        ReusableMethods.bekle(1);
        extentTest.info("Orders menüsüne tıklandı");

        merchantOrders.allOrdersButonu.click();
        ReusableMethods.bekle(2);
        extentTest.info("All orders menüsüne tıklandı");

        extentTest = extentReports.createTest("Tüm siparislerin odeme bilgileri gorulur olmalidir", "Tüm siparislerin odeme bilgileri gorulme testi yapildi");
        Actions actions= new Actions(Driver.getDriver());
        actions.sendKeys(Keys.END).perform();
        extentTest.info("Sayfa en asagiya kaydirilir");
        ReusableMethods.wait(3);

        extentTest = extentReports.createTest("Tüm siparislerin odeme bilgileri gorulur olmalidir", "Tüm siparislerin odeme bilgileri gorulme testi yapildi");
        String nextButonu=new String();
        merchantOrders.nextButonu.click();
        ReusableMethods.wait(1);
        merchantOrders.nextButonu.click();
        ReusableMethods.wait(1);
        merchantOrders.nextButonu.click();
        ReusableMethods.wait(1);
        ReusableMethods.switchToWindow(nextButonu);
        extentTest.info("Sayfa en asagiya kaydirilir");
        ReusableMethods.wait(1);

        Driver.closeDriver();
    }
}
