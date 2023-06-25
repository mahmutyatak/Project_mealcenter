package tests.US_033;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.merchantMealscenter.MerchantDashboard;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC03304 extends TestBaseRapor {

    @Test
    public void testPromotionMenuFunctions(){


        extentTest=extentReports.createTest("Promo Menüsünde Fonksiyon testi","Promo menüsünde oluşturulan coupon'u güncelleyebilmeli ve fonksiyonların çalıştığı kontrol edilebilmeli");
        MerchantDashboard merchantDashboard=new MerchantDashboard();
        Actions actions=new Actions(Driver.getDriver());

        merchantDashboard.signInMerchantMethod();
        extentTest.info("Merchant giriş sayfasına erişildi");

        // Promosyon Menüsüne erişim
        merchantDashboard.promoLink.click();
        extentTest.info("Promo menüsüne tıklandı");

        //Promo menüsünün altında yer alan Coupon bölümüne tıklanır.
        merchantDashboard.promoCouponLink.click();
        extentTest.info("Promo menusu altında yer alan Coupon butonuna tıklandı");

        //"Update(kalem)" tuşuna tıklanır.
        merchantDashboard.updateButton.click();
        extentTest.info("Update butonuna basıldı");

        // Update(Düzenleme) sayfasının açıldığı doğrulanır.
        SoftAssert softAssert=new SoftAssert();
        String expectedUrl="coupon_update";
        String actualUrl=Driver.getDriver().getCurrentUrl();
        softAssert.assertTrue(actualUrl.contains(expectedUrl),"Update Url test FAILED");
        extentTest.pass("Update sayfasına geçildiği doğrulandı");

        //"Coupon name" kutusuna tıklanır.
        //Coupon name kutusuna kupon ismi değiştirilir.
        actions.sendKeys(merchantDashboard.promoCouponUpdateCouponNameBox,"Palmera Food Coupon")
                .sendKeys(Keys.TAB).perform();
        extentTest.info("Kupon ismi güncellendi");
        ReusableMethods.wait(2);


        //"Coupon Type" kutusuna geçilir.
        //Açılan pencereden kupon tipi değiştirilir.
        actions.sendKeys(Keys.ARROW_UP)
                .sendKeys(Keys.ENTER)
                .sendKeys(Keys.TAB).perform();
        extentTest.info("Kupon type güncellendi");

        //"Amount" kutusuna geçilir.
        //Açılan kutucuğundaki belirlenen miktar değiştirilir.
        actions.sendKeys(merchantDashboard.promoCouponUpdateAmountBox,Keys.BACK_SPACE)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys("2")
                .sendKeys(Keys.TAB).perform();
        extentTest.info("Kupon indirim miktarı güncellendi");

        //"Min Order" kutucuğuna geçilir.
        //Minumum sipariş miktarı değiştirilir.
        actions.sendKeys(merchantDashboard.promoCouponUpdateMinOrderBox,Keys.BACK_SPACE)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys("1")
                .sendKeys(Keys.TAB).perform();
        extentTest.info("Minumum sipariş miktarı güncellendi");

        //"Days Available" kutucuğuna tıklanır.
        //Seçilen günler değiştirilir.
        actions.click(merchantDashboard.promoCouponUpdateDaysAvaibleBox).perform();
        actions.sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                        .sendKeys(Keys.ENTER).perform();
        extentTest.info("Kupon Günü  güncellendi");

        //"Expiration" kutucuğu seçilir.
        //Seçilen tarih değiştirilir.
        actions.sendKeys(merchantDashboard.promoCouponUpdateExpirationBox,"2023-03-30").perform();
        extentTest.info("Uygun tarih güncellendi");

        //"Coupon Options"  kutucuğuna geçilir.
        //Seçilen seçenek değiştirilir.
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.wait(2);
        merchantDashboard.dinamikTarihSecimi(30);
        extentTest.info("Kupon seçeneği güncellendi");

        //"Status" bölümüne geçilir.
        //"Pending for review" seçeneği seçilir.
        actions.click(merchantDashboard.promoCouponUpdateStatusBox).perform();
        actions.sendKeys(Keys.ARROW_UP)
                .sendKeys(Keys.ENTER).perform();
        extentTest.info("Uygun durum güncellendi");

        //"Save" butonuna tıklanır.
        merchantDashboard.saveButton.click();
        extentTest.info("Save butonuna tıklandı");

        //"Succesfully updated" yazısının çıktığı doğrulanır.
        String expectedText="Succesfully updated";
        String actualText=Driver.getDriver().findElement(By.xpath("//div[@class='alert alert-success']")).getText();
        softAssert.assertEquals(actualText,expectedText,"Değişiklikler yapılamıyor");
        extentTest.pass("Değişikliklerin başarılı bir şekilde yapıldığı doğrulandı");

        //Promo menüsünün altında yer alan Coupon bölümüne tıklanır.
        merchantDashboard.promoCouponLink.click();
        extentTest.info("Coupon linkine tıklandı");

        //"Delete" tuşuna tıklanır.
        merchantDashboard.deleteButton.click();
        extentTest.info("Delete butonuna tıklandı");

        //"Are you sure you want to permanently delete the selected item?" çıkan bilgilendirme kutucuğundaki "Delete" butonu tıklanır.
        ReusableMethods.wait(2);
        merchantDashboard.promoCouponDeleteConfirmButton.click();
        extentTest.info("Delete butonuna tıklandığı doğrulandı");

        //Oluşturulan kuponun kalıcı olarak silindiği doğrulanır.
        WebElement actualDeleteText=Driver.getDriver().findElement(By.xpath("//td[@class='dataTables_empty']"));

        softAssert.assertTrue(actualDeleteText.isDisplayed(),"delete test FAILED");
        extentTest.pass("Kuponun silindiği doğrulandı");

        softAssert.assertAll();
        //Sayfa kapatılır.

    }
}
