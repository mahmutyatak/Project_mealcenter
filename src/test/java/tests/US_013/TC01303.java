package tests.US_013;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.userMealscenter.UserHomePage;
import pages.userMealscenter.UserProfilPage;
import pages.userMealscenter.UserStorePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC01303 extends TestBaseRapor {

    @Test(groups = "demo")
    public void orderTypeandTimeTesti(){
        UserStorePage userStorePage = new UserStorePage();
        UserProfilPage userProfilPage = new UserProfilPage();
        UserHomePage userHomePage = new UserHomePage();

        extentTest=extentReports.
                createTest("Sipariş şekli ve zamanı Testi","Sepet sayfasında " +
                        "'Order Type and Time' bölümündeki seçeneklerin çalıştığı doğrulanır");
        //Browser açılır.
        //    qa.mealscenter.com sayfasına gidilir
        Driver.getDriver().get(ConfigReader.getProperty("mealCenterHomePageUrl"));
        extentTest.info("Meals center anasayfaya gidildi");


        // cookie reddedilir
        //userHomePage.Declinecookie.click();
        //extentTest.info("Cookie reddedildi");

        //başarılı kullanıcı girişi ile kullanıcı anasayfasına gidilir
        userHomePage.kullaniciGirisi("team4@hotmail.com","team4***");
        ReusableMethods.bekle(2);
        extentTest.info("Geçerli username ve password ile giriş yapıldı");

        // adres Search Box a Seattle yazılır
        userProfilPage.adresSearchBox.sendKeys("Seattle");
        //Seattle adresine tıklanır
        userProfilPage.seattleAdres.click();
        extentTest.info("Adres arama kutusuna Seattle yazılarak adres seçildi.");

        // LaPalmera restaurantına tıklanır
        userProfilPage.laPalmera.click();
        extentTest.info("La Palmera restaurantı seçildi");

        // 5. ürüne kadar inilir
        ReusableMethods.scrollToElement(userStorePage.getUrunGorseli(7));
        // 4. ürünün 'Add to Cart' butonuna tıklanır
        userStorePage.getUrunAddToCartButon(14).click();
        extentTest.info("14. urun sepete eklendi");

        // Sepeti görütülemek için 'Checkout' butonuna tıklanır.
        userStorePage.checkoutButon.click();
        extentTest.info("Sepet sayfasına gidildi.");

        ReusableMethods.bekle(2);
        //'Order Type and time' bölümündeki ilk butona tıklanır.
        userProfilPage.deliveryButon.click();
        extentTest.info("'Order Type and time' bölümündeki 'Delivery' seçeneğine tıklanır..");

        ReusableMethods.bekle(2);
        //Açılan pencerede 'delivery' seçilir.
        userProfilPage.deliveryRadio.click();
        extentTest.info("Açılan pencerede delivery butonuna tıklandı.");

        //'Save' butonuna tıklanır.
        userProfilPage.deliverySecenekleriSaveButonu.click();
        extentTest.info("Save butonuna basarak seçim kaydedildi.");

        //Teslimat şekli olarak 'delivery' seçildiği doğrulanır.
        Assert.assertTrue(userProfilPage.bisiklet.isDisplayed());
        extentTest.info("Teslimat şekli olarak 'delivery' seçildiği doğrulandı.");

        //Teslimat şeklini değiştirmek için 'Order Type and time' bölümündeki ilk butona tıklanır.
        userProfilPage.deliveryButon.click();
        extentTest.info("'Order Type and time' bölümündeki ilk butona tıklandı.");

        //Açılan pencerede 'dinein' seçilir.
        userProfilPage.dineInRadio.click();
        extentTest.info("Açılan pencerede dinein butonuna tıklandı.");

        //'Save' butonuna tıklanır.
        userProfilPage.deliverySecenekleriSaveButonu.click();
        extentTest.info("Save butonuna basarak seçim kaydedildi.");

        ReusableMethods.bekle(3);
        //Teslimat şekli olarak 'dinein' seçildiği doğrulanır.
        Assert.assertTrue(userProfilPage.sandalye.isDisplayed());
        extentTest.info("Teslimat şekli olarak 'dinein' seçildiği doğrulandı.");

        //Teslimat şeklini değiştirmek için 'Order Type and time' bölümündeki ilk butona tıklanır.
        userProfilPage.deliveryButon.click();
        extentTest.info("'Order Type and time' bölümündeki ilk butona tıklandı.");

        //Açılan pencerede 'pickup' seçilir.
        userProfilPage.pickUpRadio.click();
        extentTest.info("Açılan pencerede pickup butonuna tıklandı.");

        //'Save' butonuna tıklanır.
        userProfilPage.deliverySecenekleriSaveButonu.click();
        extentTest.info("Save butonuna basarak seçim kaydedildi.");

        //Teslimat şekli olarak 'pickup' seçildiği doğrulanır.
        Assert.assertTrue(userProfilPage.adam.isDisplayed());
        extentTest.info("Teslimat şekli olarak 'pickup' seçildiği doğrulandı.");


        ReusableMethods.bekle(2);
        //Scheduled bir sipariş oluşturmak için 'Order Type and time' kısmının altındaki butona tıklanır.
        userProfilPage.deliveryButon.click();
        extentTest.info("'Order Type and time' bölümündeki ilk butona tıklandı.");

        //Açılan pencerede 'delivery' seçilir.
        userProfilPage.deliveryRadio.click();
        extentTest.info("Açılan pencerede delivery butonuna tıklandı.");

        ReusableMethods.bekle(2);
        Actions actions = new Actions(Driver.getDriver());

        //'Schedule for later' butonuna tıklanır.
        actions.click(userProfilPage.ScheduleButonu).perform();
        extentTest.info(" 'Schedule for later butonuna tıklandı.");

        //Tarih kutusunda teslimat tarihi seçilir.
        actions.click(userProfilPage.tarihBox).perform();
        userProfilPage.tarihElementi.click();
        extentTest.info("Teslimat tarihi seçildi.");

        ReusableMethods.bekle(2);
        //Saat kutusunda teslimat saati seçilir.
        userProfilPage.saatBox.click();
        userProfilPage.saatElementi.click();
        extentTest.info("Teslimat saati seçildi.");

        //'Save' butonuna basılır.
        userProfilPage.deliverySecenekleriSaveButonu.click();
        extentTest.info("Save butonuna basarak seçim kaydedildi.");

        //teslimatın scheduled olarak planlandığı doğrulanır.
        String actualTeslimatZamanYazisi =userProfilPage.teslimatZamanYazisi.getText();
        Assert.assertTrue(actualTeslimatZamanYazisi.contains("later"));
        extentTest.info("Teslimatın ileri tarihli olarak planlandığı doğrulandı.");

        //Telefon numarasını düzenlemek için telefon numarası görüntülenen kutuya tıklanır.
        userProfilPage.phoneButon.click();
        extentTest.info("Telefon numarası görüntülenen bölüme tıklandı.");

        //Açılan pencerede telefon numarası kutusuna yeni numara yazılır.
        userProfilPage.telefonYazBox.sendKeys("234");
        extentTest.info("Açılan pencerede ilgili yere yeni telefon numarası yazıldı.");

        //'Continue' butonuna tıklanır.
        userProfilPage.editNumberContinue.click();
        extentTest.info("continue butonuna basıldı.");

        ReusableMethods.bekle(2);
        //Mail adresine doğrulama kodu gönderildiği doğrulanır.
        Assert.assertTrue(userProfilPage.weSentACodeYazi.isDisplayed());
        extentTest.info("Mail adresine doğrulama kodu gönderildiği doğrulandı.");

        //Pencere kapatılır.
        userProfilPage.editNumberKapatma.click();
        extentTest.info("Açılan pencere kapatıldı.");



        //Promosyon seçmek için 'Promotion available' butonuna tıklanır.
        userProfilPage.promotionButon.click();
        extentTest.info("Promosyon seçmek için promotion bölümüne tıklandı.");

        //Promosyonlardan birini seçmek için yanındaki butona tıklanır.
        userProfilPage.secilecekKupon.click();
        extentTest.info("Promosyonlardan birini seçmek için yanındaki butona tıklandı.");

        //'Save' butonuna tıklanır.
        userProfilPage.promotionSave.click();
        extentTest.info("Save butonuna basarak seçim kaydedildi.");


        //Promosyonun seçilmiş olduğu doğrulanır.
        Assert.assertTrue(userProfilPage.promotionDurumYazisi.getText().contains("applied"));
        ReusableMethods.bekle(2);
        extentTest.info("Promosyonun seçimiş olduğu doğrulandı.");

        //seçilen promosyonu değiştirmek veya kaldırmak için tekrar 'Promotion applied' butonuna tıklanır.
        userProfilPage.promotionButon.click();
        ReusableMethods.bekle(2);
        extentTest.info("Promosyonu değiştirmek veya kaldırmak için promotion bölümüne tıklandı.");

        //Önceden seçilmiş promosyonu kaldırmak için 'remove' butonuna tıklanır.
        userProfilPage.remove.click();
        extentTest.info("Önceden seçilmiş promosyonu kaldırmak için 'remove' butonuna tıklandı.");

        //'Save' butonunun aktif olduğu doğrulanır.(*********BUG**********)
        Assert.assertTrue(userProfilPage.promotionSave.isEnabled(),"Promosyon kaldırıldıktan sonra save butonu etkin hale gelmiyor.");
        extentTest.info("Save butonunun etkin olduğu doğrulandı");

        //'Save' butonuna tıklanır.
        userProfilPage.promotionSave.click();
        extentTest.info("Save butonuna tıklandı");

        //Promosyonun kaldırılmış olduğu doğrulanır.
        String expectedPromotionYazi = "available";
        String actualPromotionYazi =userProfilPage.promotionDurumYazisi.getText();
        System.out.println(actualPromotionYazi);
        Assert.assertTrue(actualPromotionYazi.contains(expectedPromotionYazi));
        extentTest.info("Promosyonun kaldırılmış olduğu doğrulandı");

        //Sayfa kapatılır
        //Driver.closeDriver();
        //extentTest.info("Sayfa kapatıldı.");
    }
}
