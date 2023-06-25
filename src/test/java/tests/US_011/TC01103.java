package tests.US_011;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.userMealscenter.UserHomePage;
import pages.userMealscenter.UserProfilPage;
import pages.userMealscenter.UserStorePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC01103 extends TestBaseRapor {

    @Test
    public void sepeteEklenebilirlikTesti(){
        UserHomePage userHomePage = new UserHomePage();
        UserProfilPage userProfilPage = new UserProfilPage();
        UserStorePage userStorePage = new UserStorePage();
        extentTest=extentReports.
                createTest("Sepete eklenebilirlik Testi","Restauranta ait ürünlerin sepete eklenmiş olduğu doğrulanır");
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

        //Seçilen restaurantın ürünleri için 'Add to Cart' butonunun  görünür olduğu doğrulanır
        Assert.assertTrue(userStorePage.addToCartGorunurlugu(1));
        Assert.assertTrue(userStorePage.addToCartGorunurlugu(2));
        Assert.assertTrue(userStorePage.addToCartGorunurlugu(3));
        Assert.assertTrue(userStorePage.addToCartGorunurlugu(4));
        Assert.assertTrue(userStorePage.addToCartGorunurlugu(5));
        Assert.assertTrue(userStorePage.addToCartGorunurlugu(6));
        Assert.assertTrue(userStorePage.addToCartGorunurlugu(7));
        Assert.assertTrue(userStorePage.addToCartGorunurlugu(8));
        Assert.assertTrue(userStorePage.addToCartGorunurlugu(9));
        Assert.assertTrue(userStorePage.addToCartGorunurlugu(10));
        Assert.assertTrue(userStorePage.addToCartGorunurlugu(11));
        Assert.assertTrue(userStorePage.addToCartGorunurlugu(12));
        Assert.assertTrue(userStorePage.addToCartGorunurlugu(13));
        Assert.assertTrue(userStorePage.addToCartGorunurlugu(14));
        Assert.assertTrue(userStorePage.addToCartGorunurlugu(15));
        Assert.assertTrue(userStorePage.addToCartGorunurlugu(16));
        Assert.assertTrue(userStorePage.addToCartGorunurlugu(17));
        extentTest.info("Bütün ürünler için 'Add to Cart' butonunun görünür olduğu doğrulandı.");

        //Sepete eklemek için rastgele 5 üründe 'Add to Cart' butonuna tıklanır.
        userStorePage.istenenUrunAddToCartClick(3);
        userStorePage.istenenUrunAddToCartClick(5);
        userStorePage.istenenUrunAddToCartClick(8);
        userStorePage.istenenUrunAddToCartClick(11);
        userStorePage.istenenUrunAddToCartClick(12);
        extentTest.info("5 farklı ürün için 'Add to Cart' butonuna tıklandı.");

        //Sepeti görütülemek için 'Checkout' butonuna tıklanır.
        userStorePage.checkoutButon.click();
        extentTest.info("Sepet sayfası görüntülendi");

        //sepete 5 adet ürün eklnmiş olduğu doğrulanır
        int expectedUrunSayi = 5;
        int actualUrunSayi = userStorePage.sepeteEklenmisUrunGorseliSayisi();
        Assert.assertEquals(actualUrunSayi,expectedUrunSayi);
        extentTest.info("Sepete 5 adet ürünün eklenmiş olduğu doğrulandı");

        //Sayfa kapatılır.
        Driver.closeDriver();
    }
}
