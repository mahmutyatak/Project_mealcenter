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

public class TC01306 extends TestBaseRapor {

    @Test(groups = "demo")
    public void basariliSiparisTesti(){
        UserStorePage userStorePage = new UserStorePage();
        UserProfilPage userProfilPage = new UserProfilPage();
        UserHomePage userHomePage = new UserHomePage();
        extentTest=extentReports.
                createTest("Başarılı Sipariş Testi","Başarılı bir şekilde dipariş oluşturulabildiği doğrulanır.");
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
        userStorePage.getUrunAddToCartButon(7).click();
        extentTest.info("4. urun sepete eklendi");

        // Sepeti görütülemek için 'Checkout' butonuna tıklanır.
        userStorePage.checkoutButon.click();
        extentTest.info("Sepet sayfasına gidildi.");

        ReusableMethods.bekle(2);
        //'Add new payment ' bölümü görünür oluncaya kadar aşağı inilir.
        ReusableMethods.scrollToElement(userProfilPage.paymentMethodBaslik);
        extentTest.info(" 'Payment Methods' bölümüne inildi.");


        try {
            //Daha önceden kaydedilmiş bir ödeme seçeneği varsa 'place order' butonuna tıklanır.
            if (userProfilPage.savedPaymentMethodYazisi.isDisplayed()){
                userProfilPage.placeHolder.click();
                extentTest.info(" 'Place order' butonuna tıklandı.");

            }
        } catch (Exception e) {
            //Kaydedilmiş ödeme seçeneği yoksa 'cash on delivery' butonuna tıklanır,
            userProfilPage.cashOnDelivery1.click();
            ReusableMethods.bekle(3);
            // çıkan alertte 'add cash' butonuna tıklanır ve 'place order' butonuna tıklanır.
            userProfilPage.addCash.click();
            ReusableMethods.bekle(2);
            extentTest.info(" ödeme metodu eklendi.");
            //Place order butonuna tıklanır
            userProfilPage.placeHolder.click();
            extentTest.info(" 'Place order' butonuna tıklandı.");
        }


        ReusableMethods.bekle(3);
        //Siparişin tamamlandığı doğrulanır.
        Assert.assertTrue(userProfilPage.orderYazi.isDisplayed());
        extentTest.info(" Siparişin tamamlandığı doğrulandı.");

        //Sayfa kapatılır.
        //Driver.closeDriver();
        //extentTest.info("Sayfa kapatıldı.");
    }
}
