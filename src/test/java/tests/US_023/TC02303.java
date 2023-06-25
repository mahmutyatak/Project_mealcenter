package tests.US_023;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.merchantMealscenter.MerchantDashboard;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC02303 extends TestBaseRapor {

MerchantDashboard merchantDashboard=new MerchantDashboard();
    @Test
    public void test01() {
        merchantDashboard=new MerchantDashboard();
        extentTest = extentReports.createTest("Son 5 saparisin durumunu gosteren tablodan son 5 siparisi gorulut oldugu dogrulanmalidir", "Son 5 saparisin durumunu gosteren tablodan son 5 siparisi gorulme testi yapildi");
        merchantDashboard.signInMerchantMethod();
        extentTest.info("Merchant sitesine giris yapildi");
        merchantDashboard.dashboardLink.click();
        ReusableMethods.wait(2);
        extentTest.info("Dashboard tusuna tiklandi");
        //ReusableMethods.scrollToElement(merchantDashboard.tablo);
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).
                sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).
                sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).
                sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).
                sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).
                sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).perform();
        extentTest.info("Sayfa son 5 urun ozetini gosteren bolume kaydirildi");
        merchantDashboard.AllTusu.click();
        extentTest.info("All tusuna tiklandi");

        Assert.assertTrue(merchantDashboard.tabloListesindeOlma(merchantDashboard.table1,"teamdort"));
        extentTest.pass("Son 5 urun listesi icerigi test edildi");




    }
    @Test
    public void test02(){
        merchantDashboard=new MerchantDashboard();
        extentTest = extentReports.createTest("Son 5 saparisin durumunu gosteren tablodan son 5 islemde olan siparisi gorulur oldugu dogrulanmalidir", "Son 5 saparisin durumunu gosteren tablodan son 5 islemde olan siparisi gorulme testi yapildi");
        merchantDashboard.ProcessingTusu.click();
        extentTest.info("Proceccing tusuna tiklandi");

        Assert.assertTrue(merchantDashboard.tabloListesindeOlma(merchantDashboard.table1,"teamdort"));
        extentTest.pass("Son 5 urun listesi  teamdort icerigi test edildi");
    }
    @Test
    public void test03(){
        merchantDashboard=new MerchantDashboard();
        extentTest = extentReports.createTest("Son 5 saparisin durumunu gosteren tablodan son 5 hazir olan siparisi gorulur oldugu dogrulanmalidir", "Son 5 saparisin durumunu gosteren tablodan son 5 hazir olan siparisi gorulme testi yapildi");
        merchantDashboard.ReadyTusu.click();
        extentTest.info("Ready tusuna tiklandi");

        Assert.assertTrue(merchantDashboard.tabloListesindeOlma(merchantDashboard.table1,"teamdort"));
        extentTest.pass("Son 5 urun listesi  teamdort icerigi test edildi");
    }
    @Test
    public void test04(){
        merchantDashboard=new MerchantDashboard();
        extentTest = extentReports.createTest("Son 5 saparisin durumunu gosteren tablodan son 5 tamamlanmis olan siparisi gorulur oldugu dogrulanmalidir", "Son 5 saparisin durumunu gosteren tablodan son 5 tamamlanmis olan siparisi gorulme testi yapildi");
        merchantDashboard.CompletedTusu.click();
        extentTest.info("Completed tusuna tiklandi");

        Assert.assertTrue(merchantDashboard.tabloListesindeOlma(merchantDashboard.table1,"teamdort"));
        extentTest.pass("Son 5 urun listesi  teamdort icerigi test edildi");
        Driver.closeDriver();
    }
}
