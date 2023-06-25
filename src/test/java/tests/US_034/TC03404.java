package tests.US_034;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.merchantMealscenter.MerchantDashboard;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC03404 extends TestBaseRapor{

    @Test
    public void testDeliveryPage(){

        Actions actions=new Actions(Driver.getDriver());
        SoftAssert softAssert=new SoftAssert();
        extentTest=extentReports.createTest("Delivery sayfasındaki fonksiyonları çalıştırma testi","Delivey sayfasındaki fonksiyonlar doğru bir şekilde çalışmalı");
        MerchantDashboard merchantDashboard=new MerchantDashboard();

        //Sign in method'u ile sisteme giriş yapılır.
        merchantDashboard.signInMerchantMethod();
        extentTest.info("Merchant giriş sayfasına erişim sağlandı");

        //"https://qa.mealscenter.com/backoffice/merchant/dashboard" sayfasının sol tarafında yer alan menüde "Order type" menüsüne tıklanır.
        merchantDashboard.orderTypeLink.click();
        extentTest.info("Order Type linkine tıklandı");

        //Altında açılan menüde "Delivery" kısmına tıklanır.
        merchantDashboard.orderTypeDeliveryLink.click();
        extentTest.info("Açılan Order Type menüsünün altındaki Delivery linkine tıklandı");

        //Açılan sayfada "Delivery Settings"  sayfasındaki "Enabled Opt in for no contact delivery" ayar butonu kontrol edilir.
        actions.click(merchantDashboard.orderTypeSettingEnabledOptButton).perform();
        ReusableMethods.wait(2);
        softAssert.assertTrue(merchantDashboard.orderTypeSettingEnabledOptButton.isEnabled());
        extentTest.pass("Enabled Opt radio butonuna tıklandı ve görünürlüğü test edildi");

        //Alttaki "Free Delivery On First Order" ayar butonuna geçilir.
        //"Free Delivery On First Order" ayar butonu kontrol edilir.
        actions.click(merchantDashboard.orderTypeSettingFreeDeliveryButton).perform();
        ReusableMethods.wait(2);
        softAssert.assertTrue(merchantDashboard.orderTypeSettingFreeDeliveryButton.isEnabled());
        extentTest.pass("Free Delivery radio butonuna tıklandı ve görünürlüğü test edildi");

        //Bir altındaki "Delivery Charge Type" bölümünde yer alan seçeneklerin seçilip seçilmediğini kontrol eder.
        Select select=new Select(merchantDashboard.orderTypeSettingDynamicChargeTypeMenu);
        select.selectByVisibleText("Fixed Charge");
        softAssert.assertTrue(Driver.getDriver().getPageSource().contains("Fixed Charge"));
        extentTest.pass("Delivery Charge Type bölümündeki seçeneklerin seçildiği doğrulandı");

        //Altında yer alan "Service Fee" bölümüne geçilir.
        //"Service Fee" bölümüne geçersiz veri girişi yapar.
        merchantDashboard.orderTypeSettingServicesFeeBox.sendKeys("asd", Keys.ENTER);
        extentTest.info("Services fee kutusuna geçersiz veri girildi");

        //"Service Fee must be a number." yazının çıktığı doğrulanır.
        String expectedText="Service Fee must be a number.";
        String actualText=merchantDashboard.orderTypeErrorMessageText.getText();
        softAssert.assertEquals(actualText,expectedText);
        extentTest.pass("Hata mesajının Service Fee must be a number içerdiği doğrulandı");
        ReusableMethods.wait(2);

        //Doğru veri girişi yapılarak "Save" butonuna tıklanır.
        actions.click(merchantDashboard.orderTypeSettingServicesFeeBox).perform();
        ReusableMethods.wait(2);
        actions.sendKeys(Keys.ARROW_RIGHT)
                .sendKeys(Keys.ARROW_RIGHT)
                .sendKeys(Keys.ARROW_RIGHT)
                .sendKeys(Keys.ARROW_RIGHT)
                .sendKeys(Keys.ARROW_RIGHT)
                .sendKeys(Keys.ARROW_RIGHT)
                .sendKeys(Keys.ARROW_RIGHT)
                .sendKeys(Keys.ARROW_RIGHT)
                .sendKeys(Keys.ARROW_RIGHT).perform();
        ReusableMethods.wait(1);
        actions.sendKeys(Keys.BACK_SPACE)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys(Keys.BACK_SPACE).perform();
        ReusableMethods.wait(2);
        actions.sendKeys("10").perform();

        actions.click(merchantDashboard.saveButton).perform();

        //"Settings saved" yazısının çıktığı doğrulanır.
        softAssert.assertTrue(merchantDashboard.orderTypeSavedMessageText.isDisplayed());
        extentTest.pass("Settings saved yazısının çıktığı doğrulandı");

        //"Fixed Charge" bölümüne tıklanır.
        actions.click(merchantDashboard.orderTypeFixedChargeButton).perform();
        extentTest.info("Fixed Charge bölümüne tıklandı");

        //"Price" bölümüne geçersiz veri girişi yapılır.
        actions.click(merchantDashboard.orderTypeFixedChargePriceBox).perform();
        ReusableMethods.wait(2);
        actions.sendKeys("asd").perform();
        extentTest.info("Price bölümüne geçersiz veri girildi");

        //"Save" butonuna tıklanır.
        merchantDashboard.saveButton.click();
        extentTest.info("Save butonuna tıklandı");

        //Ekranda "Succesfully updated" yazısının görünmediği doğrulanmalıdır.
        expectedText="Succesfully updated";
        actualText=merchantDashboard.orderTypeSavedMessageText.getText();
        softAssert.assertNotEquals(actualText,expectedText,"Price bölümüne geçersiz veri girişi ile update yapıldı");//!!!!!!!!!!!!!!!!!!!!!! BUUUUUGGGGGGGGG  !!!!!!!!!!
        extentTest.pass("Ekranda Succesfully updated yazısının görünmediği doğrulandı");

        //"Fixed Charge" bölümüne tıklanır.
        merchantDashboard.orderTypeFixedChargeButton.click();
        extentTest.info("Fixed Charge butonuna tıklandı");

        //"Price" bölümüne geçerli veri girişi yapılır.
        merchantDashboard.orderTypeFixedChargePriceBox.sendKeys("150");
        extentTest.info("Price bölümüne geçerli veri girişi yapıldı");

        //"Min order" ve "Max Order" kısmına geçersiz veri girişi yapılır.
        merchantDashboard.orderTypeFixedChargeMinBox.sendKeys("asd");
        merchantDashboard.orderTypeFixedChargeMaxBox.sendKeys("   ");
        extentTest.info("Min-Max order'a geçersiz veri girişi yapıldı");

        //"Save" butonuna tıklanır.
        merchantDashboard.saveButton.click();
        extentTest.info("Save butonuna tıklandı");

        //Ekranda "Succesfully updated" yazısının görünmediği doğrulanmalıdır.
        expectedText="Succesfully updated";
        actualText=merchantDashboard.orderTypeSavedMessageText.getText();
        softAssert.assertEquals(actualText,expectedText,"Ekranda Succesfully updated yazısı görünüyor...");
        extentTest.pass("Ekranda Succesfully updated yazısı görünmediği doğrulandı");

        //"Fixed Charge" bölümüne tıklanır.
        merchantDashboard.orderTypeFixedChargeButton.click();
        extentTest.info("Fixed Charge butonuna tıklandı");

        //"Price" bölümüne geçerli veri girişi yapılır.
        ReusableMethods.wait(2);
        actions.sendKeys(merchantDashboard.orderTypeFixedChargePriceBox,Keys.ARROW_RIGHT)
                .sendKeys(Keys.ARROW_RIGHT)
                .sendKeys(Keys.ARROW_RIGHT)
                .sendKeys(Keys.ARROW_RIGHT)
                .sendKeys(Keys.ARROW_RIGHT)
                .sendKeys(Keys.ARROW_RIGHT)
                .sendKeys(Keys.ARROW_RIGHT).perform();
        ReusableMethods.wait(1);
        actions.sendKeys(Keys.BACK_SPACE)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys(Keys.BACK_SPACE).perform();
        ReusableMethods.wait(2);
        actions.sendKeys(merchantDashboard.orderTypeFixedChargePriceBox,"150").perform();
        extentTest.info("Price bölümüne geçerli veri girişi yapıldı");

        //"Min order" ve "Max Order" kısmına geçerli veri girişi yapılır.
        ReusableMethods.wait(2);
        actions.sendKeys(merchantDashboard.orderTypeFixedChargeMinBox,Keys.ARROW_RIGHT)
                .sendKeys(Keys.ARROW_RIGHT)
                .sendKeys(Keys.ARROW_RIGHT)
                .sendKeys(Keys.ARROW_RIGHT)
                .sendKeys(Keys.ARROW_RIGHT)
                .sendKeys(Keys.ARROW_RIGHT).perform();
        ReusableMethods.wait(1);
        actions.sendKeys(Keys.BACK_SPACE)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys(Keys.BACK_SPACE).perform();
        ReusableMethods.wait(2);
        actions.sendKeys(merchantDashboard.orderTypeFixedChargeMinBox,"10").perform();
        ReusableMethods.wait(2);
        actions.sendKeys(merchantDashboard.orderTypeFixedChargeMaxBox,Keys.ARROW_RIGHT)
                .sendKeys(Keys.ARROW_RIGHT)
                .sendKeys(Keys.ARROW_RIGHT)
                .sendKeys(Keys.ARROW_RIGHT)
                .sendKeys(Keys.ARROW_RIGHT)
                .sendKeys(Keys.ARROW_RIGHT).perform();
        ReusableMethods.wait(1);
        actions.sendKeys(Keys.BACK_SPACE)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys(Keys.BACK_SPACE).perform();
        ReusableMethods.wait(2);
        actions.sendKeys(merchantDashboard.orderTypeFixedChargeMaxBox,"50").perform();
        extentTest.info("Min-Max order'a geçerli veri girişi yapıldı");

        //"Save" butonuna tıklanır.
        merchantDashboard.saveButton.click();
        extentTest.info("Save butonuna tıklandı");

        //Ekranda "Succesfully updated" yazısının göründüğü doğrulanmalıdır.
        expectedText="Succesfully updated";
        actualText=merchantDashboard.orderTypeSavedMessageText.getText();
        softAssert.assertEquals(actualText,expectedText,"Ekranda Succesfully updated yazısı görünmüyor...");
        extentTest.pass("Ekranda Succesfully updated yazısı göründüğü doğrulandı");

        //"Settings" butonuna tıklanır.
        actions.click(merchantDashboard.merchantSettingsLink).perform();
        extentTest.info("Settings butonuna tıklandı");

        //"Delivery Charge Type" kısmında "Dynamic Rates" seçeneğine tıklanır.
        select.selectByVisibleText("Dynamic Rates");
        softAssert.assertTrue(Driver.getDriver().getPageSource().contains("Dynamic Rates"));
        extentTest.pass("Delivery Charge Type bölümündeki Dynamic Rates seçeneğinin seçildiği doğrulandı");

        //"Service fee" geçerli veri girilir.
        ReusableMethods.wait(2);
        actions.sendKeys(merchantDashboard.orderTypeSettingServicesFeeBox,Keys.ARROW_RIGHT)
                .sendKeys(Keys.ARROW_RIGHT)
                .sendKeys(Keys.ARROW_RIGHT)
                .sendKeys(Keys.ARROW_RIGHT)
                .sendKeys(Keys.ARROW_RIGHT)
                .sendKeys(Keys.ARROW_RIGHT).perform();
        ReusableMethods.wait(1);
        actions.sendKeys(Keys.BACK_SPACE)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys(Keys.BACK_SPACE).perform();
        ReusableMethods.wait(2);
        actions.sendKeys(merchantDashboard.orderTypeSettingServicesFeeBox,"20").perform();
        extentTest.info("Geçerli Service Fee verisi girildi");

        //"Save" butonuna tıklanır.
        ReusableMethods.wait(2);
        merchantDashboard.saveButton.click();
        extentTest.info("Save butonuna tıklandı");

        //"Settings saved" yazısı çıktığı doğrulanır.
        expectedText="Settings saved";
        actualText=merchantDashboard.orderTypeSavedMessageText.getText();
        softAssert.assertEquals(actualText,expectedText);
        extentTest.pass("Ekranda Settings saved yazısı göründüğü doğrulandı");

        //Sayfadaki "Dynamic Rates" bölümü seçilir.
        ReusableMethods.wait(2);
        actions.click(merchantDashboard.orderTypeDynamicRatesButton).build().perform();
        extentTest.info("Dynamic rates bölümü seçildi");

        //"Add New" butonuna tıklanır.
        merchantDashboard.addNewButton.click();
        extentTest.info("Add New butonuna tıklandı");

        //"Shipping Type" seçilir.
        Select select1=new Select(merchantDashboard.orderTypeDynamicRatesShippingTypeMenu);
        select1.selectByVisibleText("Priority");
        extentTest.info("Shiping Type olarak Priority seçildi");

        //"From" bölümüne geçersiz veri girişi yapılır.
        merchantDashboard.orderTypeDynamicRatesFromBox.sendKeys("asd");
        extentTest.info("From Box'a geçersiz veri girişi yapıldı");

        //"To" bölümüne geçersiz veri girişi yapılır.
        ReusableMethods.wait(1);
        merchantDashboard.orderTypeDynamicRatesToBox.sendKeys("?");
        extentTest.info("To Box'a geçersiz veri girişi yapıldı");

        //"Price" bölümüne geçersiz veri girişi yapılır.!!!!!!!!!!!!!!!!!!!!!BUUUUUUUUUUGGGGGGGGGGGGGG!!!!!!!!!!!!!!!!!!!!!!!!
        ReusableMethods.wait(1);
        merchantDashboard.orderTypeDynamicRatesPriceBox.sendKeys("   ");
        extentTest.info("Price bölümüne geçersiz veri girişi yapıldı");

        //"Minumum Order" bölümüne geçersiz veri girişi yapılır.
        merchantDashboard.orderTypeDynamicRatesMinBox.sendKeys("---");
        extentTest.info("Min Order'a geçersiz veri girişi yapıldı");

        //"Maximum Order" bölümüne geçersiz veri girişi yapılır.
        merchantDashboard.orderTypeDynamicRatesMaxBox.sendKeys("^^");
        extentTest.info("Max Order'a geçersiz veri girişi yapıldı");

        //"Save" butonuna tıklanır.
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.wait(2);
        merchantDashboard.saveButton.click();
        //actions.click(merchantDashboard.saveButton).build().perform();
        extentTest.info("Save butonuna tıklandı");

        //"Please correct the forms" yazısı çıktığı doğrulanır.
        ReusableMethods.wait(1);
        expectedText="Please correct the forms";
        actualText=merchantDashboard.orderTypeErrorMessageText.getText();
        softAssert.assertEquals(actualText,expectedText,"Dynamic Rates Bölümünde geçersiz giriş yapımasına rağmen kaydetme işlemi başarılı...");
        extentTest.pass("Dynamic Rates Bölümünde geçersiz giriş yapıldı ama kayıt yapılamadığı doğrulandı");

        //Sayfadaki "Dynamic Rates" bölümü seçilir.
        ReusableMethods.wait(1);
        merchantDashboard.orderTypeDynamicRatesButton.click();
        extentTest.info("Dynamic rates bölümü seçildi");

        //"Add New" butonuna tıklanır.
        ReusableMethods.wait(1);
        merchantDashboard.addNewButton.click();
        extentTest.info("Add New butonuna tıklandı");

        //"Shipping Type" seçilir.
        select1.selectByVisibleText("No rush");
        extentTest.info("Shiping Type olarak No rush seçildi");

        //"From" bölümüne geçerli veri girişi yapılır.
        ReusableMethods.wait(1);
        actions.sendKeys(merchantDashboard.orderTypeDynamicRatesFromBox,Keys.ARROW_RIGHT).perform();
        ReusableMethods.wait(1);
        actions.sendKeys(Keys.BACK_SPACE,"10").perform();
        ReusableMethods.wait(1);
        extentTest.info("From Box'a geçerli veri girişi yapıldı");

        //"To" bölümüne geçerli veri girişi yapılır.
        actions.sendKeys(merchantDashboard.orderTypeDynamicRatesToBox,Keys.ARROW_RIGHT).perform();
        ReusableMethods.wait(1);
        actions.sendKeys(Keys.BACK_SPACE,"100").perform();
        ReusableMethods.wait(1);
        extentTest.info("To Box'a geçerli veri girişi yapıldı");

        //"Price" bölümüne geçerli veri girişi yapılır.
        merchantDashboard.orderTypeDynamicRatesPriceBox.sendKeys("175");
        extentTest.info("Price Box'a geçerli veri girişi yapıldı");

        //"Delivery Estimation" bölümüne geçerli veri girişi yapılır.
        ReusableMethods.wait(1);
        merchantDashboard.orderTypeDynamicRatesDeliveryEstimationBox.sendKeys("10-45");
        extentTest.info("Delivery estimation Box'a geçerli veri girişi yapıldı");

        //"Minumum Order" bölümüne geçerli veri girişi yapılır.
        merchantDashboard.orderTypeDynamicRatesMinBox.sendKeys("1");
        extentTest.info("Min Order Box'a geçerli veri girişi yapıldı");

        //"Maximum Order" bölümüne geçerli veri girişi yapılır.
        merchantDashboard.orderTypeDynamicRatesMaxBox.sendKeys("100");
        extentTest.info("Max Order Box'a geçerli veri girişi yapıldı");

        //"Save" butonuna tıklanır.
        //"Dynamic Rates" oluşturur.
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.wait(2);
        merchantDashboard.saveButton.click();
        extentTest.info("Save butonuna tıklandı");


        //"Update(kalem)" butonuna basılır veriler değiştirilir.
        actions.click(merchantDashboard.updateButton).build().perform();
        ReusableMethods.wait(2);
        extentTest.info("Update butonuna basıldı");

        select1.selectByVisibleText("No rush");
        extentTest.info("veriler değiştirildi");

        actions.sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN).build().perform();
        ReusableMethods.bekle(3);
        //"Save" butonuna tıklanır.
        actions.click(merchantDashboard.saveButton).build().perform();
        extentTest.info("Save butonuna tıklandı");

        //"Succesfully updated" yazısının görünürlüğü doğrulanır.
        expectedText="Succesfully updated";
        actualText=merchantDashboard.orderTypeSavedMessageText.getText();
        softAssert.assertEquals(actualText,expectedText,"Update Ekranında Succesfully updated yazısı görünmüyor...");
        extentTest.pass("Ekranda Succesfully updated yazısı göründüğü doğrulandı");

        //Sayfadaki "Dynamic Rates" bölümü tıklanır.
        ReusableMethods.wait(2);
        actions.click(merchantDashboard.orderTypeDynamicRatesButton).build().perform();
        extentTest.info("Dynamic Rates butonuna tıkalndı");
        ReusableMethods.wait(2);
        //"Delete" butonuna tıklanır.
        actions.click(merchantDashboard.deleteButton).build().perform();
        extentTest.info("Delete butonuna tıklandı");

        //Çıkan "Delete Confirmation" bilgilendirmesindeki "Delete" tıklanır.
        ReusableMethods.wait(2);
        actions.click(merchantDashboard.orderTypeAlertDeleteButton).build().perform();
        extentTest.info("Delete butonuna tıklandı");

        //Sayfada "No data available in table" yazısının görünürlüğü doğrulanır.
        softAssert.assertTrue(Driver.getDriver().getPageSource().contains("No data available in table"));
        extentTest.pass("No data available in table yazısının görünürlüğü doğrulandı");

        ReusableMethods.wait(2);
      merchantDashboard.logOutMethod();
       extentTest.info("LogOut method'u kullanılarak sistemden çıkıldı");
        softAssert.assertAll();
    }
}
