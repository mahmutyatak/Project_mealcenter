package tests.US_040;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.adminMealscenter.AdminDashboard;
import utilities.Driver;
import utilities.JSUtils;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC04003 extends TestBaseRapor {

    @Test(groups = "demo")
    public void testCreatePromotion(){

        Actions actions=new Actions(Driver.getDriver());

        extentTest=extentReports.createTest("Promo Menüsüne Coupon oluşturma testi",
                "Promo menüsüne erişim sağlayıp Coupon oluşturabilmeli");
        AdminDashboard adminDashboard=new AdminDashboard();

        adminDashboard.signInMethodu();
        extentTest.info("Merchant giriş sayfasına erişim sağlandı");

        // Promosyon Menüsüne erişim
        adminDashboard.promoLink1.click();
        extentTest.info("Promo menüsüne tıklandı");

        // Promosyon Menüsü sayfasının açıldığı doğrulanır.
        Assert.assertTrue(adminDashboard.menuList.getText().contains("Promo"));
        extentTest.pass("Merchant sayfası menüsünde Promo seçeneğinin olduğu doğrulandı");

        //Promo menüsünün altında yer alan Coupon bölümüne tıklanır.
        adminDashboard.promoCouponLink1.click();
        extentTest.info("Promo menusu altında yer alan Coupon butonuna tıklandı");

        //Açılan sayfanın sağ üst bölümünde yer alan "Add New" butonuna tıklanır.
        adminDashboard.addNewButton.click();
        extentTest.info("Add New butonuna tıklandı");

        //"Coupon name" kutusuna tıklanır.
        //Coupon name kutusuna kupon ismi girilir.
        actions.sendKeys(adminDashboard.promoCouponUpdateCouponNameBox1,"LaPalmera1")
                .sendKeys(Keys.TAB).perform();
        extentTest.info("Kupon ismi girildi");
        ReusableMethods.wait(2);

        //"Coupon Type" kutusuna tıklanır.
        //Açılan pencereden kupon tipi belirlenir.
        actions.sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ENTER)
                .sendKeys(Keys.TAB).perform();
        extentTest.info("Kupon type belirlendi");

        //"Amount" kutusuna tıklanır.
        //Açılan kutucuğa belirlenen miktar girilir.
        actions.sendKeys(adminDashboard.promoCouponUpdateAmountBox,Keys.BACK_SPACE)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys("1")
                .sendKeys(Keys.TAB).perform();
        extentTest.info("Kupon indirim miktarı girildi");

        //"Min Order" kutucuğuna tıklanır.
        //Minumum sipariş miktarı girilir.
        actions.sendKeys(adminDashboard.promoCouponUpdateMinOrderBox,Keys.BACK_SPACE)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys("0")
                .sendKeys(Keys.TAB).perform();
        extentTest.info("Minumum sipariş miktarı girildi");

        //"Days Available" kutucuğuna tıklanır.
        //Uygun günler seçilir.
        actions.click(adminDashboard.promoCouponUpdateDaysAvaibleBox).perform();
        actions.sendKeys(Keys.ARROW_DOWN,Keys.ENTER).perform();
        extentTest.info("Uygun gün girildi");
        JSUtils.scrollDownByJS();
        ReusableMethods.bekle(2);

        actions.click(adminDashboard.applicabletoMerchant).perform();
        ReusableMethods.bekle(2);
        actions.sendKeys(Keys.ENTER).perform();
        extentTest.info("Applicable to Merchant seçildi");

        //"Expiration" kutucuğu seçilir.
        //Uygun tarih seçilir.
        actions.click(adminDashboard.promoCouponUpdateExpirationBox1).perform();
        ReusableMethods.bekle(2);
        Driver.getDriver().findElement(By.xpath("(//div[@class='calendar-table']//table//tr[5]//td[6])[1]")).click();
        // actions.sendKeys("2023-03-31").perform();
        ReusableMethods.bekle(2);
        extentTest.info("Uygun tarih seçildi");

        //"Coupon Options"  kutucuğuna tıklanır.
        //Seçeneklerden birisi seçilir.
        Select select=new Select(adminDashboard.promoCouponUpdateCouponOptionsBox);
        //actions.click(adminDashboard.promoCouponUpdateCouponOptionsBox).perform();
        ReusableMethods.bekle(2);
        select.selectByIndex(2);
        //actions.sendKeys(Keys.ARROW_DOWN,Keys.ENTER).perform();
        ReusableMethods.wait(2);
        //adminDashboard.dinamikTarihSecimi(31);
        extentTest.info("Kupon seçeneği belirlendi");

        //"Status" bölümüne geçilir.
        //"Publish" seçeneği seçilir.
        //actions.click(adminDashboard.promoCouponUpdateStatusBox).perform();
        Select select1 = new Select(adminDashboard.promoCouponUpdateStatusBox);
        select1.selectByIndex(2);
        ReusableMethods.bekle(2);
        extentTest.info("Uygun durum belirlendi");

        //"Save" butonuna tıklanır.
        adminDashboard.saveButton1.click();
        extentTest.info("Save butonuna tıklandı");

        // Oluşturulan promosyonun listelendiği sayfaya yönlendirildiği doğrulanır.
        String pageSource = Driver.getDriver().findElement(By.xpath("//tbody/tr/td/h6")).getText();
        Assert.assertTrue(pageSource.contains("LaPalmera1"));
        extentTest.pass("Promosyon kuponunun oluşturulduğu doğrulandı");

//        //"Delete" tuşuna tıklanır.
//        adminDashboard.deleteButton.click();
//        extentTest.info("Delete butonuna tıklandı");
//
//        //"Are you sure you want to permanently delete the selected item?" çıkan bilgilendirme kutucuğundaki "Delete" butonu tıklanır.
//        ReusableMethods.wait(2);
//        adminDashboard.promoCouponDeleteConfirmButton.click();
//        extentTest.info("Delete butonuna tıklandığı doğrulandı");

        //Açılan dropdown menudeki "Logout" butonuna tıklanır.
        adminDashboard.logOutMethod();
        extentTest.info("Logout butonuna tıklandı");

        //Sayfa kapatılır.
        //Driver.getDriver().quit();
    }
}