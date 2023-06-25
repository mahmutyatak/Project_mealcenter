package tests.US_034;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.merchantMealscenter.MerchantDashboard;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC03401 extends TestBaseRapor {

    @Test
    public void testPageAccess(){

        extentTest=extentReports.createTest("Fixed Charge sayfasına erişim testi","Fixed Charge sayfasına erişim");
        MerchantDashboard merchantDashboard=new MerchantDashboard();

        merchantDashboard.signInMerchantMethod();
        extentTest.info("Mealscenter Merchant sayfasına yönetici girişi yapıldı");

        //Sol kısımda yer alan bölümden "Order Type" kısmına tıklanır.
        merchantDashboard.orderTypeLink.click();
        extentTest.info("Order Type linkine tıklandı");

        //Altında çıkan menülerden "Delivery" bölümü seçilir.
        merchantDashboard.orderTypeDeliveryLink.click();
        extentTest.info("Delivery linkine tıklandı");

        //Açılan sayfada "Fixed Charge" butonuna tıklanır.
        Select select=new Select(merchantDashboard.orderTypeSettingDynamicChargeTypeMenu);
        select.selectByVisibleText("Fixed Charge");
        extentTest.info("Delivery Charge Type menu'den Fixed Charge seçildi");

        //Save butonuna tıklanır
        merchantDashboard.saveButton.click();
        extentTest.info("Save butonuna tıklandı");

        //Fixed Charge butonuna tıklanır
        merchantDashboard.orderTypeFixedChargeButton.click();
        extentTest.info("Fixed charge butonuna tıklandı");

        //Açılan sayfanın Url'nin "https://qa.mealscenter.com/backoffice/services/fixed_charge" olduğu doğrulanır.
        String expectedUrl="https://qa.mealscenter.com/backoffice/services/fixed_charge";
        String actualUrl= Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl,"Fixed Charge sayfasına erişilemiyor");
        extentTest.pass("Fixed Charge sayfasına erişildiği doğrulandı");

       merchantDashboard.logOutMethod();
       extentTest.info("LogOut method'u ile sistemden çıkış yapıldı");

    }
}
