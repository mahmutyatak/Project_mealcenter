package tests.US_013;

import org.openqa.selenium.Keys;
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

public class TC01305 extends TestBaseRapor {

    @Test
    public void paymentMethodsTesti(){
        UserStorePage userStorePage = new UserStorePage();
        UserProfilPage userProfilPage = new UserProfilPage();
        UserHomePage userHomePage = new UserHomePage();
        extentTest=extentReports.
                createTest("Ödeme metodu Testi","Sepet sayfasında " +
                        "'Payment Methods' bölümündeki seçeneklerin çalıştığı doğrulanır");
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
        ReusableMethods.scrollToElement(userStorePage.getUrunGorseli(7));
        // 4. ürünün 'Add to Cart' butonuna tıklanır
        userStorePage.getUrunAddToCartButon(7).click();
        ReusableMethods.bekle(2);
        extentTest.info("7. urun sepete eklendi");


        // Sepeti görütülemek için 'Checkout' butonuna tıklanır.
        userStorePage.checkoutButon.click();
        extentTest.info("Sepet sayfasına gidildi.");

        ReusableMethods.bekle(2);
        //'Add new payment ' bölümü görünür oluncaya kadar aşağı inilir.
        ReusableMethods.scrollToElement(userProfilPage.paymentMethodBaslik);
        extentTest.info(" 'Payment Methods' bölümüne inildi.");


        //'Saved payment methods' yazısı görünür ise,seçilmiş methodu silmek için 'Default' yazısının yanındaki butona tıklanır.
        try {
            if (userProfilPage.savedPaymentMethodYazisi.isDisplayed()){
                userProfilPage.odemeMetoduSilme.click();
                ReusableMethods.bekle(2);
                //'Delete' butonuna tıklanır.
                userProfilPage.odemeMetoduDelete.click();
                ReusableMethods.bekle(2);
                extentTest.info(" Daha önceden kaydedilmiş ödeme metodu silindi.");
                //userProfilPage.cashOnDelivery1.click();
            }
        } catch (Exception e) {
            //'Add new  payment method' bölümünde 'cash on delivery' seçeneğine tıklanır.
            //userProfilPage.cashOnDelivery1.click();
            // ReusableMethods.bekle(3);
        }

        //'Add new  payment method' bölümünde 'cash on delivery' seçeneğine tıklanır.
        userProfilPage.cashOnDelivery1.click();
        extentTest.info(" Yeni ödeme metodu eklemek için 'Cash on delivery' seçeneğine tıklandı.");

        //Açılan pencerede 'Add Cash' butonuna tıklanır.
        userProfilPage.addCash.click();
        extentTest.info("Açılan pencerede 'add cash' butonuna tıklandı.");

        ReusableMethods.bekle(2);
        //'saved payment method' bölümünde 'Cash on Delivery' seçeneğinin olduğu doğrulanır.
        Assert.assertTrue(userProfilPage.eklenmisCash.isDisplayed());
        extentTest.info("Kaydedilmiiş yöntemler bölümünde 'Cash on delivery' seçeneğinin olduğu doğrulandı.");

        //'Add new  payment method' bölümünde 'stripe' seçeneğine tıklanır.
        userProfilPage.stripe.click();
        extentTest.info(" Yeni ödeme metodu eklemek için 'Stripe' seçeneğine tıklandı.");

        //Açılan pencerede 'Kart numarası' bölümüne tıklanır ve kart numarası, son kullanma tarihi ve zip codu girilir.
        ReusableMethods.bekle(2);
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();

        ReusableMethods.bekle(4);

        actions.sendKeys(Keys.TAB).perform();
        ReusableMethods.bekle(2);
        actions.sendKeys("4242424242424242")
                .sendKeys("1126").sendKeys("123").sendKeys("12345").perform();
        extentTest.info("Kart numarası, son kullanım tarihi, cvc kodu ve zip kodu girildi.");

        //'Add Stripe' butonuna tıklanır.
        userProfilPage.addStripe.click();
        extentTest.info(" 'Add Stripe' butonuna tıklandı.");

        //'saved payment method'bölümünde 'Stripe' seçeneğinin olduğu doğrulanır.
        Assert.assertTrue(userProfilPage.eklenmisStripe.isDisplayed());
        extentTest.info("Kaydedilmiiş yöntemler bölümünde 'Stripe' seçeneğinin olduğu doğrulandı.");

        //'saved payment methods' bölümünden kaydedilmiş ödeme seçeneği silinir
        ReusableMethods.bekle(4);
        userProfilPage.odemeMetoduSilme.click();
        userProfilPage.odemeMetoduDelete.click();
        extentTest.info("Kaydedilmiş yöntemler bölümünden ödeme seçeneği silindi.");

        //Sayfa kapatılır
        Driver.closeDriver();
        extentTest.info("Sayfa kapatıldı.");
    }
}
