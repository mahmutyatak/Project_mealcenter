package tests.US_040;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.adminMealscenter.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC04001 extends TestBaseRapor {
    @Test
     public void accessAdminPage(){
        AdminDashboard adminDashboard;
        extentTest = extentReports.createTest("Admin anasayfaya erişim testi",
                "Admin anasayfaya erişim sağlayabilmeli");
         adminDashboard=new AdminDashboard();
        //Browser açılır.
        //Url kısmına "https://qa.mealscenter.com/backoffice/login" yazılır ve tıklanır.
        Driver.getDriver().get(ConfigReader.getProperty("mealCenterAdminPageUrl"));
        extentTest.info("Mealscenter Admin anasayfasına gidildi");

        //Admin olarak sisteme giris yapilabildigi  dogrulanir
        adminDashboard.signInMethodu();
        extentTest.info("Admin giriş sayfasına erişildi");

        // Sayfa başlığı doğrulanır.
        String expextedTitle="Back Office - Dashboard Admin";
        String actuallTitle=Driver.getDriver().getTitle();
        Assert.assertEquals(actuallTitle,expextedTitle);
        extentTest.pass("Basarili sekilde sayfaya erişildiği test edildi");

        //Logout ile sistemeden cikis yapilir
        adminDashboard.logOutMethod();

        //Sayfa kapatılır.
        Driver.getDriver().quit();

    }
}
