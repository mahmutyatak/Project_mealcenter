package tests.US_039;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.adminMealscenter.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.util.List;

public class TC03902 extends TestBaseRapor {

  public   AdminDashboard adminDashboard;
    @Test
    public void verifyMerchantEarnings() {
        AdminDashboard adminDashboard = new AdminDashboard();

        extentTest = extentReports.createTest("Admin/Earnings/Merchant Earnings sayfasina  erişim testi",
                "Admin tum Merchant Earnings listesine erişim saglanabilmeli ve balance degerlerini goruntuleyilmeli ");

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

        //Merchant Earning sayfasinin gorunur oldugu dogrulanir
        Assert.assertTrue(adminDashboard.merchantIsmeGoreSiralamaElementi.isDisplayed());
        extentTest.pass(" Merchant Earnings linkinin gorunur oldugu dogrulandi");
    }
        @Test
     public void DisplayAllofMerchantBalance(){
            AdminDashboard adminDashboard = new AdminDashboard();

            extentTest = extentReports.createTest("Admin/Earnings/Merchant Earnings sayfasina  erişim testi",
                    "Admin tum Merchant Earnings listesine erişim sağlayabilmeli");

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

        //Tum Merchant'larin bakiyelerinin gorunur oldugu dogrulanir
       WebElement tumBalanceList=Driver.getDriver().findElement(By.xpath("(//div[@class='col-sm-12'])[1]//table//tr//td"));
        List<WebElement> tumBalanceListesi = Driver.getDriver().findElements(By.xpath("(//div[@class='col-sm-12'])[1]//table//tr//td"));
        for (WebElement each : tumBalanceListesi
        ) {
            if (!each.getText().isEmpty()) {
                System.out.println( each.getText());
            }
        Assert.assertNotNull(each.getText());
            extentTest.pass(" Merchant bakiyelerinin goruntulendigi dogrulandi");

        }
            //Logout butonuna tiklanarak sistemden cikis yapilir
            adminDashboard.logOutMethod();

            //Sayfa kapatilir
            Driver.quitDriver();
    }


}
