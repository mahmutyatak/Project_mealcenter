package tests.US_030;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.merchantMealscenter.MerchantDashboard;
import pages.merchantMealscenter.MerchantOrders;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC03002 extends TestBaseRapor {


    //Browser açılır.
    //Kullanıcı "https://qa.mealscenter.com/backoffice/auth/login"  adresine gider.
    //Restoran yoneticisi, username bolumune "lapalmeraAdmin " girer.
    //Restoran yoneticisi, password bolumune "1234567" girer.
    //Restoran yoneticisi,Sign in butonuna tiklar.
    //Restaurant yöneticisi tarafından sayfa açıldıktan sonra dashboard sütunun altında buluna "Orders" butonuna tıklanılır ve test edilir.
    //Restaurant yöneticisi tarafından orders kısmının altında yer alan "Scheduled" butonuna tıklanılır.
    //Restaurant yöneticisi tarafından "Scheduled" butonuna tıklanıldıktan sonra sayfada tamamlanmış siparişlerin tamamı listenilir.

    MerchantDashboard merchantDashboard = new MerchantDashboard();
    MerchantOrders merchantOrders = new MerchantOrders();

    @Test
    public void test01() {

        extentTest = extentReports.createTest("Scheduled menüsünün listesine erişim testi", "Restaurant yöneticisi scheduled menüsünün listesine erişim sağlayabilmeli");
        merchantDashboard.signInMerchantMethod();
        extentTest.info("Merchant giriş sayfasına erişildi");

        merchantOrders.ordersButonu.click();
        ReusableMethods.bekle(1);
        extentTest.info("Orders menüsüne tıklandı");

        merchantOrders.scheduledButonu.click();
        ReusableMethods.bekle(2);
        extentTest.info("Scheduled menüsüne tıklandı");

        extentTest = extentReports.createTest("İleri tarihli siparişlerin listelenmesi gorulur olmalidir", "İleri tarihlin siparişlerin listelerinin gorulme testi yapildi");
        Actions actions= new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        extentTest.info("Sayfa asagiya kaydirilir");
        ReusableMethods.wait(2);

        String expectedIcerik="teamdort";
        String actualIcerik=merchantOrders.solSiparisListesi.getText();
        System.out.println(actualIcerik);
        Assert.assertTrue(actualIcerik.contains(expectedIcerik));
        extentTest.pass("Tamamlanmış siparişlerin 'Scheduled Today' kısmında görüldüğü ve listelendiği dogrulandi");
        ReusableMethods.bekle(3);


        Driver.closeDriver();

    }
}
