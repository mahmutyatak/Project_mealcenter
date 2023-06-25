package tests.US_035;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.adminMealscenter.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC03503 extends TestBaseRapor {
    @Test
    public void adminNegatifLoginTesti(){
        AdminDashboard adminDashboard = new AdminDashboard();
        extentTest=extentReports.
                createTest("Admin Paneli Negatif Login Testi","Geçersiz verilerle admin paneline giriş" +
                        "yapılamayacağı doğrulanır.");

        //Browser açılır.
        //https://qa.mealscenter.com/backoffice/login sayfasına gidilir.
        Driver.getDriver().get(ConfigReader.getProperty("mealCenterAdminPageUrl"));
        extentTest.info("Administrator Login sayfasına gidildi");

        //username box' a geçerli bir username girilir.
        //password box' a geçersiz bir password girilir.
        //'Sign in' butonuna tıklanır.
        adminDashboard.adminGirisi(ConfigReader.getProperty("mustafaUsername"),"123");
        extentTest.info("Geçerli username ve geçersiz password girilerek sign In butonuna tıklandı.");

        //Başarılı bir şekilde giriş yapılamadığı doğrulanır.
        Assert.assertTrue(adminDashboard.gecersizGiris.isDisplayed());
        extentTest.info("Giriş yapılamadığı doğrulandı.");

        //username box' a geçersiz bir username girilir.
        //password box' a geçerli bir password girilir.
        //'Sign in' butonuna tıklanır.
        adminDashboard.adminGirisi("emir",ConfigReader.getProperty("mustafaPassword"));
        extentTest.info("Geçersiz username ve geçerli password girilerek sign In butonuna tıklandı.");

        //Başarılı bir şekilde giriş yapılamadığı doğrulanır.
        Assert.assertTrue(adminDashboard.gecersizGiris.isDisplayed());
        extentTest.info("Giriş yapılamadığı doğrulandı.");

        //username box' a geçesiz bir username girilir.
        //password box' a geçersiz bir password girilir.
        //'Sign in' butonuna tıklanır.
        adminDashboard.adminGirisi("emir","1234");
        extentTest.info("Geçersiz username ve geçersiz password girilerek sign In butonuna tıklandı.");

        //Başarılı bir şekilde giriş yapılamadığı doğrulanır.
        Assert.assertTrue(adminDashboard.gecersizGiris.isDisplayed());
        extentTest.info("Giriş yapılamadığı doğrulandı.");

        //Sayfa kapatılır.
        Driver.closeDriver();
        extentTest.info("Sayfa kapatıldı.");
    }
}
