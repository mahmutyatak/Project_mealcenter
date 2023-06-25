package tests.US_032;

import org.testng.annotations.Test;
import pages.merchantMealscenter.MerchantDashboard;
import pages.merchantMealscenter.MerchantOrders;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC03201 extends TestBaseRapor {

    //Browser açılır.
    //Kullanıcı "https://qa.mealscenter.com/backoffice/auth/login"  adresine gider.
    //Restoran yoneticisi, username bolumune "lapalmeraAdmin " girer.
    //Restoran yoneticisi, password bolumune "1234567" girer.
    //Restoran yoneticisi,Sign in butonuna tiklar.
    //Restaurant yöneticisi tarafından sayfa açıldıktan sonra dashboard sütunun altında buluna "Attributes" butonuna tıklanılır ve test edilir.
    //Restaurant yöneticisi tarafından attributes kısmının altında yer alan "Size" butonuna tıklanılır ve test edilir.
    //Restaurant yöneticisi tarafından attributes kısmının altında yer alan "Ingredients" butonuna tıklanılır ve test edilir.
    //Restaurant yöneticisi tarafından attributes kısmının altında yer alan "Cooking Reference" butonuna tıklanılır ve test edilir.


    @Test
    public void accessAttributesMerchantPage() {

        extentTest = extentReports.createTest("Attributes menüsüne erişim testi", "Restaurant yöneticisi attributes menüsüne erişim sağlayabilmeli");
        MerchantDashboard merchantDashboard = new MerchantDashboard();
        MerchantOrders merchantOrders = new MerchantOrders();

        ///Browser açılır.
        //Kullanıcı "https://qa.mealscenter.com/backoffice/auth/login"  adresine gider.
        //Restoran yoneticisi, username bolumune "lapalmeraAdmin " girer.
        //Restoran yoneticisi, password bolumune "1234567" girer.
        //Restoran yoneticisi,Sign in butonuna tiklar.
        merchantDashboard.signInMerchantMethod();
        extentTest.info("Merchant giriş sayfasına erişildi");


        //Restaurant yöneticisi tarafından sayfa açıldıktan sonra dashboard
        //sütunun altında buluna "Attributes" butonuna tıklanılır ve test edilir.
        merchantDashboard.attributesLink.click();
        ReusableMethods.bekle(3);
        extentTest.info("Attributes menüsüne tıklandı");

        //Restaurant yöneticisi tarafından attributes kısmının altında yer alan "Size" butonuna tıklanılır ve test edilir.
        merchantDashboard.attributesSizeLink.click();
        ReusableMethods.bekle(5);
        extentTest.info("Size menüsüne tıklandı");


        //Restaurant yöneticisi tarafından attributes kısmının altında yer alan "Ingredients" butonuna tıklanılır ve test edilir.
        merchantDashboard.attributesIngredientsLink.click();
        ReusableMethods.bekle(5);
        extentTest.info("Ingredients menüsüne tıklandı");


        //Restaurant yöneticisi tarafından attributes kısmının altında yer alan "Cooking Reference" butonuna tıklanılır ve test edilir.
        merchantDashboard.attributesCookingReferenceLink.click();
        ReusableMethods.bekle(5);
        extentTest.info("Cooking Reference menüsüne tıklandı");


    }
}
