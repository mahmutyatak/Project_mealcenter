package tests.US_039;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.adminMealscenter.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.util.List;

public class TC03906 extends TestBaseRapor {


    @Test
    public void verifyNameandUsedListTest() {
        AdminDashboard adminDashboard = new AdminDashboard();

        extentTest = extentReports.createTest("Admin/Earnings/Merchant Earnings listesine   erişim testi",
                "Admin tum Merchant Earnings listesinde merchantlarin isim ve kullanim sayisina gore listelendigi  dogrulanabilmeli");

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

        //merchant basligina tiklanir ve harfe gore siralama yaptigi kontrol edilir
        List<WebElement> rawMerchantListesi = Driver.getDriver().findElements(By.xpath("//tbody//tr//td[2]"));
        for (WebElement each: rawMerchantListesi
             ) {
            System.out.println(each.getText());
        }
        adminDashboard.merchantIsmeGoreSiralamaElementi.click();
        ReusableMethods.bekle(2);
        List<WebElement> rawMerchantListesiSirali = Driver.getDriver().findElements(By.xpath("//tbody//tr//td[2]"));
        for (WebElement each1: rawMerchantListesiSirali
             ) {
            System.out.println(each1.getText());
        }
        Assert.assertNotEquals(rawMerchantListesi,rawMerchantListesiSirali);
        extentTest.pass("Merchantlarin isim sirasina gore listelendigi dogrulandi");

        //Logout butonuna tiklanarak sistemden cikis yapilir
        adminDashboard.logOutMethod();
        extentTest.info("Logout yapilarak sistemden cikis yapildi");

        //Sayfa kapatilir
        Driver.quitDriver();
    }

    }
