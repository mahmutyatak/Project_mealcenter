package tests.US_039;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.adminMealscenter.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC03904 extends TestBaseRapor {


    @Test(groups = "demo")
    public void verifyBalancetoRunningBalanceMerchantEarnings() {
        AdminDashboard adminDashboard = new AdminDashboard();

        extentTest = extentReports.createTest("Admin/Earnings/Merchant Earnings toplam balance degerlerine  erişim testi",
                "Admin tum Merchant Earnings listesinde balance degerlerinin ayni oldugu  dogrulanabilmeli");

        //Browser açılır.
        //Url kısmına "https://qa.mealscenter.com/backoffice/login" yazılır ve tıklanır.
        Driver.getDriver().get(ConfigReader.getProperty("mealCenterAdminPageUrl"));
        extentTest.info("Mealscenter Admin anasayfasına gidildi");

        //Sign in butonuna basilarak basarili admin girisi yapildigi dogrulanir
        adminDashboard.signInMethodu();
        extentTest.info("Basarili sekilde admin girisi yapildigi test edildi");

        //Earning sekmesine tiklanir
        adminDashboard.earningsLink1.click();
        extentTest.info("Earnings linkine tiklandi");

        //Merchang Earnings sayfasina tiklanir
        adminDashboard.earingsMerchantEarningsLink1.click();
        extentTest.info(" Merchant Earnings linkine tiklandi");

        //Merchant'in balance degeri ile
        //actions kisminda ki running balance degerinin ayni olup olmadigi dogrulanir
        adminDashboard.ilkBalanceDegeri.click();
        adminDashboard.actionElementi.click();
        String ilkBalanceText=adminDashboard.ilkBalanceDegeri.getText();
        extentTest.info(" Balance text degeri alindi");
        adminDashboard.runningBalanceDegeri.click();
        String runningBalanceText=adminDashboard.runningBalanceDegeri.getText();
        extentTest.info("Running  Balance text degeri alindi");

        Assert.assertEquals(ilkBalanceText,runningBalanceText);
        ReusableMethods.bekle(2);
        Driver.getDriver().findElement(By.xpath("(//span[@aria-hidden='true'])[1]")).click();
        extentTest.pass(" Balance ve Running Balance degeri ayni oldugu dogrulandi");

        //Logout butonuna tiklanarak sistemden cikis yapilir
        adminDashboard.logOutMethod();
        extentTest.info("Logout yapilarak sistemden cikis yapildi");

        //Sayfa kapatilir
        //Driver.quitDriver();

    }
}
