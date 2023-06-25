package tests.US_029;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.merchantMealscenter.MerchantDashboard;
import pages.merchantMealscenter.MerchantOrders;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC02906 extends TestBaseRapor {

    //Browser açılır.
    //Kullanıcı "https://qa.mealscenter.com/backoffice/auth/login"  adresine gider.
    //Restoran yoneticisi, username bolumune "lapalmeraAdmin " girer.
    //Restoran yoneticisi, password bolumune "1234567" girer.
    //Restoran yoneticisi,Sign in butonuna tiklar.
    //Restaurant yöneticisi tarafından sayfa açıldıktan sonra dashboard sütunun altında buluna "Orders" butonuna tıklanılır ve test edilir.
    //Restaurant yöneticisi tarafından orders kısmının altında yer alan "Completed" butonuna tıklanılır ve test edilir.
    //Restaurant yöneticisi tarafından "Completed" butonuna tıklanıldıktan sonra
    //sayfada tamamlanmış siparişlerin listesinin görünür olduğu test edilir.

    MerchantDashboard merchantDashboard = new MerchantDashboard();
    MerchantOrders merchantOrders = new MerchantOrders();

    @Test
    public void test01() {

        extentTest = extentReports.createTest("Siparisin onaylanarak Completed bolumune aktarildigi dogrulanmalidir", "Tamamlanan siparişin Completed bolumune aktarildigi gorulurlugu  testi yapildi");
        merchantDashboard.signInMerchantMethod();
        extentTest.info("Merchant sitesine giris yapildi");

        merchantOrders.ordersButton.click();
        ReusableMethods.bekle(1);
        extentTest.info("Orders butonuna tiklandi");

        merchantOrders.completedButonu.click();
        ReusableMethods.bekle(1);
        extentTest.info("Completed Butonu butonuna tiklandi");

        String expectedIcerik="teamdort";
        String actualIcerik=merchantOrders.solSiparisListesi.getText();
        System.out.println(actualIcerik);
        Assert.assertTrue(actualIcerik.contains(expectedIcerik));
        extentTest.pass("Tamamlanan siparisin 'Completed Today' kisminde goruldugu dogrulandi");
        ReusableMethods.bekle(3);

        Driver.closeDriver();

    }
}