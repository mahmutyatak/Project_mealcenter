package tests.US_013;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.userMealscenter.UserHomePage;
import pages.userMealscenter.UserProfilPage;
import pages.userMealscenter.UserStorePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC01302 extends TestBaseRapor {

    @Test
    public void sepetSayfasiTesti() {
        UserHomePage userHomePage = new UserHomePage();
        UserProfilPage userProfilPage = new UserProfilPage();
        UserStorePage userStorePage = new UserStorePage();
        extentTest=extentReports.
                createTest("Sepet fonksiyonları Testi","Sepette sayfasında toplam tutar" +
                        "teslimat şekli,teslimat edresi ve ödeme şekli seçenekleri olduğu doğrulanır.");
        //Browser açılır.
        //    qa.mealscenter.com sayfasına gidilir
        Driver.getDriver().get(ConfigReader.getProperty("mealCenterHomePageUrl"));
        extentTest.info("Meals center anasayfaya gidildi");


        // cookie reddedilir
        userHomePage.Declinecookie.click();
        extentTest.info("Cookie reddedildi");

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
        ReusableMethods.scrollToElement(userStorePage.getUrunGorseli(5));
        // 4. ürünün 'Add to Cart' butonuna tıklanır
        userStorePage.getUrunAddToCartButon(4).click();
        extentTest.info("4. urun sepete eklendi");

        // Sepeti görütülemek için 'Checkout' butonuna tıklanır.
        userStorePage.checkoutButon.click();
        extentTest.info("Sepet sayfasına gidildi.");

        //Sepet sayfasında toplam tutarın görünür olduğu doğrulanır.
        Assert.assertTrue(userProfilPage.sepettekiToplamTutar.isDisplayed());
        extentTest.info("Sepette toplam tutarın görünür olduğu doğrulandı.");

        // Sepet sayfasında teslimat şekli ve zamanı seçeneğinin olduğu doğrulanır.
        Assert.assertTrue(userProfilPage.orderTypeAndTimeBaslik.isDisplayed());
        extentTest.info("Sepet sayfasında teslimat şekli ve zamanı seçeneklerinin olduğu doğrulandı.");

        //Sepet sayfasında teslimat edresi seçeneğinin olduğu doğrulanır.
        Assert.assertTrue(userProfilPage.chooseAdeliveryAdressBaslik.isDisplayed());
        extentTest.info("Sepet sayfasında teslimat adresi seçeneğinin olduğu doğrulandı.");

        //Sepet sayfasında ödeme şekli seçeneklerinin olduğu doğrulanır.
        Assert.assertTrue(userProfilPage.paymentMethodBaslik.isDisplayed());
        extentTest.info("Sepet sayfasında ödeme şekli seçeneğinin olduğu doğrulandı.");

        //sayfa kapatılır
        Driver.closeDriver();
        extentTest.info("Sayfa kapatıldı.");


    }
}
