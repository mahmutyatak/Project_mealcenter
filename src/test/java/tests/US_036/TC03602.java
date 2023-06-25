package tests.US_036;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.adminMealscenter.AdminDashboard;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC03602 extends TestBaseRapor {

    @Test
    public void testDashboardSummary() {
        extentTest = extentReports.createTest("Admin sayfasına erişim testi", "Admin sayfasına geçerli bilgiler girilerek erişim sağlanabilmeli");

        AdminDashboard adminDashboard = new AdminDashboard();

        SoftAssert softAssert=new SoftAssert();

        Actions actions=new Actions(Driver.getDriver());

        //Sayfaya başarılı bir şekilde giriş yapılır.
        adminDashboard.signInMethodu();
        extentTest.info("Admin sayfasına Signin method'u ile giriş yapıldı");

        //Sayfanın üst bölümünde yer alan "Commission this week" yazının görünürlüğünü doğrular.
        softAssert.assertTrue(adminDashboard.gorulurOlmaMethodu(adminDashboard.getKartText(1)));
        extentTest.pass("Commission this week yazısının görünür olduğu doğrulandı");

        //Sayfayı bir pagedown aşağı kaydırır.
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        ReusableMethods.wait(2);
        extentTest.info("sayfa bir pagedown aşağı kaydırıldı");

        //Sayfada "Last Orders" yazısının görünürlüğünü doğrular.
        softAssert.assertTrue(adminDashboard.gorulurOlmaMethodu(adminDashboard.getBodyBaslikText(1)));
        extentTest.pass("Last Orders yazısının görünürlüğü doğrulandı");

        //Sayfayı bir pagedown aşağı kaydırır.
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        ReusableMethods.wait(2);
        extentTest.info("sayfa bir pagedown aşağı kaydırıldı");

        //Sayfada "Popular items" yazısının görünürlüğünü doğrular.
        softAssert.assertTrue(adminDashboard.gorulurOlmaMethodu(adminDashboard.getBodyBaslikText(2)));
        extentTest.pass("Popular items yazısının görünürlüğü doğrulandı");

        //Sayfayı bir pagedown aşağı kaydırır.
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        ReusableMethods.wait(2);
        extentTest.info("sayfa bir pagedown aşağı kaydırıldı");

        //Sayfada "Popular merchants" yazısının görünürlüğünü doğrular.
        softAssert.assertTrue(adminDashboard.gorulurOlmaMethodu(adminDashboard.getBodyBaslikText(2)));
        extentTest.pass("Popular items yazısının görünürlüğü doğrulandı");

        actions.sendKeys(Keys.HOME).build().perform();

        adminDashboard.logOutMethod();
        extentTest.info("Logout method'u ile başarılı bir şekilde sistemden çıkış yapıldı");
        softAssert.assertAll();
    }
}
