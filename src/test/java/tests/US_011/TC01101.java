package tests.US_011;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.userMealscenter.UserHomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.JSUtils;
import utilities.TestBaseRapor;

public class TC01101 extends TestBaseRapor {

    @Test
    public void RestaurantGorunurluguTesti(){
        UserHomePage userHomePage = new UserHomePage();

        extentTest=extentReports.
                createTest("Restaurant gorunurlugu","Kullanıcı anasayfasında farklı restaurantların görünür olduğu test edilir");
        //Browser açılır.
        // qa.mealscenter.com anasayfasına gidilir
        Driver.getDriver().get(ConfigReader.getProperty("mealCenterHomePageUrl"));
        extentTest.info("Meals center anasayfaya gidildi");

        //cookie reddedilir
        userHomePage.Declinecookie.click();
        extentTest.info("Cookie reddedildi");

        //başarılı kullanıcı girişi ile kullanıcı anasayfasına gidilir
        userHomePage.kullaniciGirisi("team4@hotmail.com","team4***");
        extentTest.info("Geçerli username ve password ile giriş yapıldı");

        //Açılan sayfada aşağı doğru inilir.
        JSUtils.scrollAllUpByJS();
        extentTest.info("Sayfada aşağı doğru inildi");

        //Farklı restaurantların görünür olduğu doğrulanır.
        Assert.assertTrue(userHomePage.populerNearbyRListMethodu(9).isDisplayed());
        Assert.assertTrue(userHomePage.populerNearbyRListMethodu(10).isDisplayed());
        Assert.assertTrue(userHomePage.populerNearbyRListMethodu(11).isDisplayed());
        Assert.assertTrue(userHomePage.populerNearbyRListMethodu(12).isDisplayed());
        Assert.assertTrue(userHomePage.populerNearbyRListMethodu(13).isDisplayed());
        Assert.assertTrue(userHomePage.populerNearbyRListMethodu(14).isDisplayed());
        Assert.assertTrue(userHomePage.populerNearbyRListMethodu(15).isDisplayed());
        extentTest.info("Farklı restaurantların göründüğü doğrulandı");

        //Sayfa kapatılır
        Driver.closeDriver();
    }
}
