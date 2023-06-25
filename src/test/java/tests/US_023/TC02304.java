package tests.US_023;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.merchantMealscenter.MerchantDashboard;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC02304 extends TestBaseRapor {
    //En cok satılan urunlerin gorulur oldugu dogrulanmalidir.
    //Son 30 gunde en cok satilan urunlerin grafigini gorulur oldugu dogrulanmalidir
    //En cok satın alma yapan musterileri gorulur oldugu dogrulanmalidir.
    //Tum satın alma yapan musterileri gorulur oldugu dogrulanmalidir.
    MerchantDashboard merchantDashboard=new MerchantDashboard();
    @Test
    public void test01(){
        merchantDashboard=new MerchantDashboard();
            extentTest = extentReports.createTest("Encok satilan urunlerin gorulur oldugu dogrulanmalidir", "En cok satilan urunlerin gorulme testi yapildi");
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
                    sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).
                    sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).
                    sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).
                    sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).
                    sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).
                    sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).perform();
            extentTest.info("Sayfa en cok satilan urunleri gosteren bolume kaydirildi");

            merchantDashboard.PopularitemsTusu.click();
            extentTest.info("populer items tusuna tiklandi");

            Assert.assertTrue(merchantDashboard.tabloListesindeOlma(merchantDashboard.table2,"Appetizers"));
            extentTest.pass("Populer urunlerin goruldugu testi yapildi");
    }
    @Test
    public void test02(){
        merchantDashboard=new MerchantDashboard();
        extentTest = extentReports.createTest("Encok satilan urunlerin grafiginin gorulur oldugu dogrulanmalidir", "En cok satilan urunlerin grafiginin gorulme testi yapildi");
        merchantDashboard.LastdayssalesTusu.click();
        extentTest.info("Last days tusuna tiklandi");

        Assert.assertTrue(merchantDashboard.gorulurOlmaMethodu(merchantDashboard.getKartText(9)));
        extentTest.pass("SOn 30 gunde yapılan satislari gösteren grafigin goruldugu test edildi");
    }
    @Test
    public void test03(){
        merchantDashboard=new MerchantDashboard();
        extentTest = extentReports.createTest("Encok satin alma yapan musterilerin gorulur oldugu dogrulanmalidir", "En cok satin alma yapan musterilerin  gorulme testi yapildi");
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.ARROW_UP).sendKeys(Keys.ARROW_UP).sendKeys(Keys.ARROW_UP).
                sendKeys(Keys.ARROW_UP).sendKeys(Keys.ARROW_UP).perform();

        Assert.assertTrue(merchantDashboard.tabloListesindeOlma(merchantDashboard.table3,"teamdort"));
        extentTest.pass("Encok satin alma yapan musterilerin gorulur oldugu test edildi");
    }
    @Test
    public void test04(){
        merchantDashboard=new MerchantDashboard();
        extentTest = extentReports.createTest("Encok satin alma yapan musterilerin tamaminin gorulur oldugu dogrulanmalidir", "En cok satin alma yapan musterilerin tamaminin gorulme testi yapildi");
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).
                sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).perform();
        merchantDashboard.ViewAllCustomerTusu.click();
        extentTest.info("Custumer tusuna tiklanir");



        Assert.assertTrue(merchantDashboard.tabloListesindeOlma(merchantDashboard.table4,"John"));
        extentTest.pass("Tum musterilerin gorulme testi yapildi");
        Driver.closeDriver();
    }


}
