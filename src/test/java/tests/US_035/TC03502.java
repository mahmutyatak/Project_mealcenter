package tests.US_035;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.adminMealscenter.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC03502 extends TestBaseRapor {

    @Test
    public void adminPozitifLoginTesti(){
        AdminDashboard adminDashboard = new AdminDashboard();
        extentTest=extentReports.
                createTest("Admin Paneli Pozitif Login Testi","Geçerli username ve geçerli password ile admin paneline " +
                        "giriş yapılabildiği doğrulanır.");

        ///Browser açılır.
        //https://qa.mealscenter.com/backoffice/login sayfasına gidilir.
        Driver.getDriver().get(ConfigReader.getProperty("mealCenterAdminPageUrl"));
        extentTest.info("Administrator Login sayfasına gidildi");

        //username box' a geçerli bir username girilir.
        //password box' a geçerli bir password girilir.
        //'Sign in' butonuna tıklanır.
        adminDashboard.adminGirisi(ConfigReader.getProperty("mustafaUsername"),ConfigReader.getProperty("mustafaPassword"));
        extentTest.info("Geçerli username ve geçerli password girilerek sign In butonuna tıklandı.");

        //Başarılı bir şekilde giriş yapıldığı doğrulanır.
        Assert.assertTrue(adminDashboard.profilName.isDisplayed());
        extentTest.info("Başarılı bir şekilde girildiği doğrulandı.");

        //Sayfa kapatılır.
        Driver.closeDriver();
        extentTest.info("Sayfa kapatıldı.");
    }
}
