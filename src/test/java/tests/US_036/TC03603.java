package tests.US_036;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.adminMealscenter.AdminDashboard;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC03603 extends TestBaseRapor {

    @Test(priority = 10)
    public void testDashboardCharts(){

        extentTest = extentReports.createTest("Admin Dashboard Grafik erişim testi", "Admin dashboard sayfasında görüntülenebilecek bir grafik olmalı");

        AdminDashboard adminDashboard = new AdminDashboard();

        //Sayfaya başarılı bir şekilde giriş yapılır.
        adminDashboard.signInMethodu();
        extentTest.info("Admin sayfasına Signin method'u ile giriş yapıldı");

        adminDashboard.dashboardLink.click();
        ReusableMethods.wait(2);
        extentTest.info("Dashboard tusuna tiklandi");

        Assert.assertTrue(adminDashboard.gorulurOlmaMethodu(adminDashboard.grafikElement));
        extentTest.pass("Genel satislarin oldugu grafigin görünürlüğü doğrulandı");

        adminDashboard.logOutMethod();
        extentTest.info("Logout method'u ile başarılı bir şekilde sistemden çıkış yapıldı");
    }

    @Test(priority = 20)
    public void testDashboardTable(){

        extentTest = extentReports.createTest("Admin Dashboard Tablo erişim testi", "Admin dashboard sayfasında görüntülenebilecek bir Tablo olmalı");

        AdminDashboard adminDashboard = new AdminDashboard();

        //Sayfaya başarılı bir şekilde giriş yapılır.
        adminDashboard.signInMethodu();
        extentTest.info("Admin sayfasına Signin method'u ile giriş yapıldı");

        adminDashboard.dashboardLink.click();
        ReusableMethods.wait(2);
        extentTest.info("Dashboard tusuna tiklandi");

        Assert.assertTrue(adminDashboard.gorulurOlmaMethodu(adminDashboard.getKartText(9)));
        extentTest.pass("Popular items tablosunun görünürlüğü doğrulandı");

        adminDashboard.logOutMethod();
        extentTest.info("Logout method'u ile başarılı bir şekilde sistemden çıkış yapıldı");
    }
}
