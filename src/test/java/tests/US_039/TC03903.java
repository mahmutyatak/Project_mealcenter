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

public class TC03903 extends TestBaseRapor {



    @Test
    public void verifyTotalyMerchantEarnings() {
        AdminDashboard adminDashboard = new AdminDashboard();

        extentTest = extentReports.createTest("Admin/Earnings/Merchant Earnings sayfasina  erişim testi",
                "Admin tum Merchant Earnings listesi toplam balance degerlerine erisim sağlayabilmeli");

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

        //Merchant Earnings sayfasina tiklanir
        adminDashboard.earingsMerchantEarningsLink1.click();
        extentTest.info(" Merchant Earnings linkine tiklandi");

        //Balance kismi altinda merchantlarin toplam bakiyelerinin goruntulenebilir oldugu dogrulanmalidir

      List<WebElement> tumBalanceListesi = Driver.getDriver().findElements(By.xpath("//tbody/tr//td/b"));
      int count=1;
        for (WebElement each:tumBalanceListesi
             ) {
            System.out.println(count+each.getText());
            count++;
            Assert.assertTrue(each.isDisplayed());
            extentTest.pass(" Merchant'larin toplam degerlerinin goruntulendigi dogrulandi");

        }


        //Logout butonuna tiklanarak sistemden cikis yapilir
        adminDashboard.logOutMethod();
        extentTest.info("Logout yapilarak sistemden cikis yapildi");

        //Sayfa kapatilir
        Driver.quitDriver();




    }

}