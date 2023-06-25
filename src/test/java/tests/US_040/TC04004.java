package tests.US_040;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.adminMealscenter.AdminDashboard;
import utilities.Driver;
import utilities.JSUtils;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.util.List;

public class TC04004 extends TestBaseRapor {

    @Test
    public void updateAndDeleteCouponTest(){


         extentTest=extentReports.createTest("Promo Menüsünde Fonksiyon testi",
                "Promo menüsünde oluşturulan coupon'u güncelleyebilmeli,silebilmeli fonksiyonların çalıştığı kontrol edilebilmeli");
        AdminDashboard adminDashboard=new AdminDashboard();
        Actions actions=new Actions(Driver.getDriver());

        adminDashboard.signInMethodu();
        extentTest.info("Admin giriş sayfasına erişildi");

        // Promosyon Menüsüne erişim
        adminDashboard.promoLink1.click();
        extentTest.info("Promo menüsüne tıklandı");

        //Promo menüsünün altında yer alan Coupon bölümüne tıklanır.
        adminDashboard.promoCouponLink1.click();
        extentTest.info("Promo menusu altında yer alan Coupon butonuna tıklandı");

        //"Update(kalem)" tuşuna tıklanır.
        adminDashboard.updateButton.click();
        extentTest.info("Update butonuna basıldı");

        // Update(Düzenleme) sayfasının açıldığı doğrulanır.
        SoftAssert softAssert=new SoftAssert();
        String expectedUrl="coupon_update";
        String actualUrl=Driver.getDriver().getCurrentUrl();
        softAssert.assertTrue(actualUrl.contains(expectedUrl),"Update Url test FAILED");
        extentTest.pass("Update sayfasına geçildiği doğrulandı");

        //"Coupon name" kutusuna tıklanır.
        //Coupon name kutusuna kupon ismi değiştirilir.
        actions.sendKeys(adminDashboard.promoCouponUpdateCouponNameBox1,"1")
                .sendKeys(Keys.TAB).perform();
        extentTest.info("Kupon ismi güncellendi");
        ReusableMethods.wait(2);


        //"Coupon Type" kutusuna geçilir.
        //Açılan pencereden kupon tipi değiştirilir.
        actions.sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ENTER)
                .sendKeys(Keys.TAB).perform();
        extentTest.info("Kupon type güncellendi");

        //"Amount" kutusuna geçilir.
        //Açılan kutucuğundaki belirlenen miktar değiştirilir.
        actions.sendKeys(adminDashboard.promoCouponUpdateAmountBox,Keys.BACK_SPACE)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys("1")
                .sendKeys(Keys.TAB).perform();
        extentTest.info("Kupon indirim miktarı guncellendi");

        //"Min Order" kutucuğuna geçilir.
        //Minumum sipariş miktarı değiştirilir.
        actions.sendKeys(adminDashboard.promoCouponUpdateMinOrderBox,Keys.BACK_SPACE)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys("0")
                .sendKeys(Keys.TAB).perform();
        extentTest.info("Minumum sipariş miktarı guncellendi");

        //"Days Available" kutucuğuna tıklanır.
        //Seçilen günler değiştirilir.
        actions.click(adminDashboard.promoCouponUpdateDaysAvaibleBox).perform();
        actions.sendKeys(Keys.ARROW_DOWN,Keys.ENTER).perform();
        extentTest.info("Uygun gün guncellendi");
        JSUtils.scrollDownByJS();
        ReusableMethods.bekle(2);

        actions.click(adminDashboard.applicabletoMerchant).perform();
        ReusableMethods.bekle(2);
        actions.sendKeys(Keys.ENTER).perform();
        extentTest.info("Applicable to Merchant seçildi");

        //"Expiration" kutucuğu seçilir.
        //Seçilen tarih değiştirilir.
//        actions.click(adminDashboard.promoCouponUpdateExpirationBox).perform();
//        ReusableMethods.bekle(2);
//        Driver.getDriver().findElement(By.xpath("(//div[@class='calendar-table']//table//tr[5]//td[6])[1]")).click();
//        // actions.sendKeys("2023-03-31").perform();
//        ReusableMethods.bekle(2);

        //"Coupon Options"  kutucuğuna geçilir.
        //Seçilen seçenek değiştirilir.
        Select select=new Select(adminDashboard.promoCouponUpdateCouponOptionsBox);
        //actions.click(adminDashboard.promoCouponUpdateCouponOptionsBox).perform();
        ReusableMethods.bekle(2);
        select.selectByIndex(2);
        //actions.sendKeys(Keys.ARROW_DOWN,Keys.ENTER).perform();
        ReusableMethods.wait(2);
        //adminDashboard.dinamikTarihSecimi(31);
        extentTest.info("Kupon seçeneği güncellendi");

        //"Status" bölümüne geçilir.
        //"Pending for review" seçeneği seçilir.
        Select select1 = new Select(adminDashboard.promoCouponUpdateStatusBox);
        select1.selectByIndex(2);
        ReusableMethods.bekle(2);
        extentTest.info("Uygun durum güncellendi");
        ReusableMethods.bekle(2);

        //"Save" butonuna tıklanır.
        adminDashboard.saveButton1.click();
        extentTest.info("Save butonuna tıklandı");

        //"Succesfully updated" yazısının çıktığı doğrulanır.
        String expectedText="Succesfully updated";
        String actualText=Driver.getDriver().findElement(By.xpath("//div[@class='alert alert-success']")).getText();
        softAssert.assertEquals(actualText,expectedText,"Değişiklikler yapılamıyor");
        extentTest.pass("Değişikliklerin başarılı bir şekilde yapıldığı doğrulandı");
        ReusableMethods.bekle(2);
        //Promo menüsünün altında yer alan Coupon bölümüne tıklanır.
        actions.click(adminDashboard.solMenuCouponElementi).perform();
        extentTest.info("Coupon linkine tıklandı");


        //"Delete" tuşuna tıklanır.
        adminDashboard.deleteButton.click();
        extentTest.info("Delete butonuna tıklandı");

        //"Are you sure you want to permanently delete the selected item?" çıkan bilgilendirme kutucuğundaki "Delete" butonu tıklanır.
        ReusableMethods.wait(2);
        adminDashboard.promoCouponDeleteConfirmButton.click();
        extentTest.info("Delete butonuna tıklandığı doğrulandı");

        //Oluşturulan kuponun kalıcı olarak silindiği doğrulanır.
        List<WebElement> actualDeleteText=Driver.getDriver().findElements(By.xpath("//tr//td[2]"));

        String expectedDeleteName="1LaPalmera1";
        softAssert.assertFalse(actualDeleteText.contains(expectedDeleteName),"delete test FAILED");
        extentTest.pass("Kuponun silindiği doğrulandı");

        softAssert.assertAll();
        //Sayfa kapatılır.
        Driver.getDriver().quit();

    }
}
