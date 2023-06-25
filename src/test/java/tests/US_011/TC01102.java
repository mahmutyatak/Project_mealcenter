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

public class TC01102 extends TestBaseRapor {


    @Test
    public void restaurantIcerikTesti(){
        UserHomePage userHomePage = new UserHomePage();
        UserProfilPage userProfilPage = new UserProfilPage();
        UserStorePage userStorePage = new UserStorePage();
        extentTest=extentReports.
                createTest("Restaurant Icerik Testi","Restauranta ait ürünlerin görselleri, açıklamaları ve fiyatları olduğu doğrulanır.");
        //Browser açılır.
        // qa.mealscenter.com da başarılı kullanıcı girişi ile kullanıcı anasayfasına gidilir
        Driver.getDriver().get(ConfigReader.getProperty("mealCenterHomePageUrl"));
        extentTest.info("Meals center anasayfaya gidildi");

        //cookie reddedilir
        userHomePage.Declinecookie.click();
        extentTest.info("Cookie reddedildi");

        //başarılı kullanıcı girişi ile kullanıcı anasayfasına gidilir
        userHomePage.kullaniciGirisi("team4@hotmail.com","team4***");
        extentTest.info("Geçerli username ve password ile giriş yapıldı");

        ReusableMethods.bekle(2);
        //adres kutusuna seattle yazılarak adres seçilir
        userProfilPage.adresSearchBox.sendKeys("Seattle");
        ReusableMethods.bekle(2);
        userProfilPage.seattleAdres.click();
        extentTest.info("Adres arama kutusuna Seattle yazılarak adres seçildi.");

        //Açılan sayfada LaPalmera restaurantına tıklanır
        userProfilPage.laPalmera.click();
        extentTest.info("La Palmera restaurantı seçildi");

        //Restaurant sayfasında ürünlere ait görsellerin göründüğü test edilir
        Assert.assertTrue(userStorePage.getUrunGorseli(1).isDisplayed());
        Assert.assertTrue(userStorePage.getUrunGorseli(2).isDisplayed());
        Assert.assertTrue(userStorePage.getUrunGorseli(3).isDisplayed());
        Assert.assertTrue(userStorePage.getUrunGorseli(4).isDisplayed());
        Assert.assertTrue(userStorePage.getUrunGorseli(5).isDisplayed());
        Assert.assertTrue(userStorePage.getUrunGorseli(6).isDisplayed());
        Assert.assertTrue(userStorePage.getUrunGorseli(7).isDisplayed());
        Assert.assertTrue(userStorePage.getUrunGorseli(8).isDisplayed());
        Assert.assertTrue(userStorePage.getUrunGorseli(9).isDisplayed());
        Assert.assertTrue(userStorePage.getUrunGorseli(10).isDisplayed());
        Assert.assertTrue(userStorePage.getUrunGorseli(11).isDisplayed());
        Assert.assertTrue(userStorePage.getUrunGorseli(12).isDisplayed());
        Assert.assertTrue(userStorePage.getUrunGorseli(13).isDisplayed());
        Assert.assertTrue(userStorePage.getUrunGorseli(14).isDisplayed());
        Assert.assertTrue(userStorePage.getUrunGorseli(15).isDisplayed());
        Assert.assertTrue(userStorePage.getUrunGorseli(16).isDisplayed());
        Assert.assertTrue(userStorePage.getUrunGorseli(17).isDisplayed());
        extentTest.info("Ürünlere ait görsellerin görünür olduğu doğrulandı");


        int expectedUrunSayisi = userStorePage.urunGorselList().size(); //17
        int actualUrunAciklamasiSayisi = userStorePage.urunAciklamaList().size();

        //Restaurantın sayfasındaki ürünlerin açıklamalrının olduğu test edilir
        Assert.assertEquals(actualUrunAciklamasiSayisi,expectedUrunSayisi,"Her ürünün açıklaması yok.");
        extentTest.info("Her bir ürün görseli için ürün açıklaması olduğu doğrulandı.");

        int actualUrunFiyatiSayisi = userStorePage.urunFiyatlariListesi().size();

        //Restaurantın sayfasındaki ürünlerin fiyatlarının olduğu test edilir
        Assert.assertEquals(actualUrunFiyatiSayisi,expectedUrunSayisi,"Her ürünün fiyat bilgisi yok");
        extentTest.info("Her bir ürün görseli için ürün fiyatı olduğu doğrulandı.");



        Driver.closeDriver();
    }
}
