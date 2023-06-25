package tests.US_036;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.adminMealscenter.AdminDashboard;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC03601 extends TestBaseRapor {

    @Test
    public void testDashboardPageIsAccessible(){

        extentTest=extentReports.createTest("Admin sayfasına erişim testi","Admin sayfasına geçerli bilgiler girilerek erişim sağlanabilmeli");

        AdminDashboard adminDashboard=new AdminDashboard();

        //Sayfaya başarılı bir şekilde giriş yapılır.
        adminDashboard.signInMethodu();
        extentTest.info("Admin sayfasına Signin method'u ile giriş yapıldı");

        //Açılan sayfanın Url'nin "https://qa.mealscenter.com/backoffice/admin/dashboard" olduğu doğrulanır.
        String expectedUrl="https://qa.mealscenter.com/backoffice/admin/dashboard";
        String actualUrl= Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl,"Admin sayfasının erişim sağlanamıyor...");
        extentTest.pass("Admin sayfasına başarılı bir şekilde erişim sağlandığı doğrulandı");

        //Logout method'u ile sistemden çıkış yapılır.
        adminDashboard.logOutMethod();
        extentTest.info("Logout method'u ile başarılı bir şekilde sistemden çıkış yapıldı");
    }
}
