package tests.US_035;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.adminMealscenter.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC03501 extends TestBaseRapor {
    @Test
    public void adminPaneligirisTesti(){
        AdminDashboard adminDashboard = new AdminDashboard();
        extentTest=extentReports.
                createTest("Admin Paneli Giriş Testi","Admin paneline giri sayfasının erişilebilir olduğu doğrulanır.");
        //Browser açılır.
        //https://qa.mealscenter.com/backoffice/login sayfasına gidilir.
        Driver.getDriver().get(ConfigReader.getProperty("mealCenterAdminPageUrl"));
        extentTest.info("Administrator Login sayfasına gidildi");

        //Sayfanın admin paneline giriş sayfası olduğu doğrulamak için "administrator login" yazısının görünür old test edilir
        Assert.assertTrue(adminDashboard.administratorLoginYazi.isDisplayed());
        extentTest.info("'Administrator Login' başlığının görünür olduğu doğrulandı.'");


        Assert.assertTrue(adminDashboard.usernameBox.isEnabled());
        extentTest.info("Admin paneline giriş için username box ın etkin olduğu doğrulandı");

        Assert.assertTrue(adminDashboard.passwordBox.isEnabled());
        extentTest.info("Admin paneline giriş için password box ın etkin olduğu doğrulandı");

        Assert.assertTrue(adminDashboard.signinButton.isEnabled());
        extentTest.info("Admin paneline giriş için SignIn butonunun etkin olduğu doğrulandı");

        //sayfa kapatılır.
        Driver.closeDriver();
        extentTest.info("Sayfa kapatıldı.");
    }
}
