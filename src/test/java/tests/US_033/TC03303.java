package tests.US_033;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.merchantMealscenter.MerchantDashboard;
import utilities.Driver;
import utilities.JSUtils;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC03303 extends TestBaseRapor {

        @Test
        public void testCreatePromotion123(){
            Actions actions=new Actions(Driver.getDriver());
            extentTest=extentReports.createTest("Promo Menüsüne Coupon oluşturma testi","Promo menüsüne erişim sağlayıp Coupon oluşturabilmeliyim");
            MerchantDashboard merchantDashboard=new MerchantDashboard();
            merchantDashboard.signInMerchantMethod();
            extentTest.info("Merchant giriş sayfasına erişim sağlandı");
            // Promosyon Menüsüne erişim
            merchantDashboard.promoLink.click();
            extentTest.info("Promo menüsüne tıklandı");
            // Promosyon Menüsü sayfasının açıldığı doğrulanır.
            Assert.assertTrue(merchantDashboard.menuList.getText().contains("Promo"));
            extentTest.pass("Merchant sayfası menüsünde Promo seçeneğinin olduğu doğrulandı");
            //Promo menüsünün altında yer alan Coupon bölümüne tıklanır.
            merchantDashboard.promoCouponLink.click();
            extentTest.info("Promo menusu altında yer alan Coupon butonuna tıklandı");
            //Açılan sayfanın sağ üst bölümünde yer alan "Add New" butonuna tıklanır.
            merchantDashboard.addNewButton.click();
            extentTest.info("Add New butonuna tıklandı");
            //"Coupon name" kutusuna tıklanır.
            //Coupon name kutusuna kupon ismi girilir.
            actions.sendKeys(merchantDashboard.promoCouponUpdateCouponNameBox,"LaPalmeras Coupon")
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
            actions.sendKeys(merchantDashboard.promoCouponUpdateAmountBox,Keys.BACK_SPACE)
                    .sendKeys(Keys.BACK_SPACE)
                    .sendKeys(Keys.BACK_SPACE)
                    .sendKeys(Keys.BACK_SPACE)
                    .sendKeys("1")
                    .sendKeys(Keys.TAB).perform();
            extentTest.info("Kupon indirim miktarı girildi");
            //"Min Order" kutucuğuna tıklanır.
            //Minumum sipariş miktarı girilir.
            actions.sendKeys(merchantDashboard.promoCouponUpdateMinOrderBox,Keys.BACK_SPACE)
                    .sendKeys(Keys.BACK_SPACE)
                    .sendKeys(Keys.BACK_SPACE)
                    .sendKeys(Keys.BACK_SPACE)
                    .sendKeys("0")
                    .sendKeys(Keys.TAB).perform();
            extentTest.info("Minumum sipariş miktarı girildi");
            //"Days Available" kutucuğuna tıklanır.
            //Uygun günler seçilir.
            actions.click(merchantDashboard.promoCouponUpdateDaysAvaibleBox).perform();
            actions.sendKeys(Keys.ARROW_DOWN,Keys.ENTER).perform();
            extentTest.info("Uygun gün girildi");
            //"Expiration" kutucuğu seçilir.
            //Uygun tarih seçilir.
            actions.click(merchantDashboard.promoCouponUpdateExpirationBox).perform();
            Driver.getDriver().findElement(By.xpath("(//th[@class='next available'])[1]")).click();
            ReusableMethods.wait(1);

            actions.click(Driver.getDriver().findElement(By.xpath("(//td[text()='4'])[1]"))).perform();
            extentTest.info("Uygun tarih seçildi");
            //"Coupon Options"  kutucuğuna tıklanır.
            //Seçeneklerden birisi seçilir.
            actions.sendKeys(Keys.PAGE_DOWN).perform();
            ReusableMethods.wait(2);
            //merchantDashboard.dinamikTarihSecimi(31);
            extentTest.info("Kupon seçeneği belirlendi");
            //"Status" bölümüne geçilir.
            //"Publish" seçeneği seçilir.
            actions.click(merchantDashboard.promoCouponUpdateStatusBox).perform();
            actions.sendKeys(Keys.ARROW_DOWN)
                    .sendKeys(Keys.ARROW_DOWN)
                    .sendKeys(Keys.ENTER).perform();
            extentTest.info("Uygun durum belirlendi");
            //"Save" butonuna tıklanır.
            merchantDashboard.saveButton.click();
            extentTest.info("Save butonuna tıklandı");
            // Oluşturulan promosyonun listelendiği sayfaya yönlendirildiği doğrulanır.
            String pageSource = Driver.getDriver().findElement(By.xpath("//tbody/tr/td/h6")).getText();
            Assert.assertTrue(pageSource.contains("LaPalmeras Coupon"));
            extentTest.pass("Promosyon kuponunun oluşturulduğu doğrulandı");
            //"Delete" tuşuna tıklanır.
            merchantDashboard.deleteButton.click();

            //"Are you sure you want to permanently delete the selected item?" çıkan bilgilendirme kutucuğundaki "Delete" butonu tıklanır.
            ReusableMethods.wait(2);
            merchantDashboard.promoCouponDeleteConfirmButton.click();

            //Kullanıcı profiline tıklanır.
            //merchantDashboard.profileButton.click();
            //extentTest.info("Kullanıcı profiline tıklandı");



            //Açilan dropdown menudeki "Logout" butonuna tıklanır.
            merchantDashboard.logOutMethod();
            //actions.click(merchantDashboard.logOutButton).perform();
            extentTest.info("Logout butonuna tıklandı");
        }

}
