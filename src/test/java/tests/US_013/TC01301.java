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

public class TC01301 extends TestBaseRapor {


    @Test
    public void test01() {
        UserHomePage userHomePage = new UserHomePage();
        UserProfilPage userProfilPage = new UserProfilPage();
        UserStorePage userStorePage = new UserStorePage();

            extentTest=extentReports.
                    createTest("Sepet fonksiyonları Testi","Sepette eklenmiş olan ürünlerin isimlerinin,miktarlarının ve fiyatlarının görüntülendiği doğrulanır");
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
            extentTest.info("7. urune kadar inildi");

            // 4. ürünün 'Add to Cart' butonuna tıklanır
            userStorePage.getUrunAddToCartButon(7).click();
            extentTest.info("7. urun sepete eklendi");

            // Sepeti görütülemek için 'Checkout' butonuna tıklanır.
            userStorePage.checkoutButon.click();
            extentTest.info("Sepet sayfasına gidildi.");

            //Sepet sayfasında eklenen ürünlerin görüntülendiği doğrulanır.
            Assert.assertTrue(userProfilPage.sepettekiIlkUrunIsmi.isDisplayed());
            extentTest.info("Sepet sayfasında eklenen ürünün ismi olduğu doğrulandı");

            //Sepet sayfasında eklenen ürünlerin miktarlarının görüntülendiği doğrulanır.
            Assert.assertTrue(userProfilPage.sepetteUrunMiktari.isDisplayed());
            extentTest.info("Sepet sayfasında eklenen ürünün miktarı olduğu doğrulandı");

            //Sepet sayfasında eklenen ürünlerin tutarının görüntülendiği doğrulanır.
            Assert.assertTrue(userProfilPage.sepettekiUrunFiyati.isDisplayed());
            extentTest.info("Sepet sayfasında eklenen ürünün fiyatı olduğu doğrulandı");


            ReusableMethods.bekle(2);
            Driver.closeDriver();

        }
}
