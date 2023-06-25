package tests.US_039;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.adminMealscenter.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC03901 extends TestBaseRapor {
    @Test
    public void accessAdminPage(){


        AdminDashboard adminDashboard=new AdminDashboard();
        extentTest = extentReports.createTest("Admin anasayfaya erişim testi","Admin anasayfaya erişim sağlayabilmeli");

        //Browser açılır.
        //Url kısmına "https://qa.mealscenter.com/backoffice/login" yazılır ve tıklanır.
        Driver.getDriver().get(ConfigReader.getProperty("mealCenterAdminPageUrl"));
        extentTest.info("Mealscenter Admin anasayfasına gidildi");

        // Sayfa başlığı doğrulanır.
        String expextedTitle="Administrator Login";
        String actuallTitle=Driver.getDriver().getTitle();
        Assert.assertEquals(actuallTitle,expextedTitle);
        extentTest.info("Basarili sekilde sayfaya erişildiği test edildi");

        //Sign in butonuna basilarak basarili admin girisi yapildigi dogrulanir
        adminDashboard.signInMethodu();
        extentTest.info("Basarili sekilde admin girisi yapildigi test edildi");


        //Header bolumunde kullanici adinin gorunur oldugu kontrol edilir
        String expectedText="Mustafa Çulha";
        String actualText=adminDashboard.kullaniciButonu.getText();
        Assert.assertEquals(actualText,expectedText);
        extentTest.pass("Header bolumunde kullanici adinin gorunur oldugu test edildi");

        //Kullanici profili bolumunden Logout butonuna tiklanarak cikis yapilir
        adminDashboard.logOutMethod();
        extentTest.info("Kullanici oturumu basarili bir sekilde kapatildi");

        //Sayfa kapatılır.
        Driver.getDriver().quit();

    }


}
