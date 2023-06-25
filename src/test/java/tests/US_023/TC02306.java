package tests.US_023;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.merchantMealscenter.MerchantDashboard;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC02306 extends TestBaseRapor {

    MerchantDashboard merchantDashboard = new MerchantDashboard();

    @Test
    public void test01() {
        merchantDashboard=new MerchantDashboard();
        extentTest = extentReports.createTest("Musteri puanlarinin oldugu grafik gorulur olmalidir", "Pozitif musteri puanlari  grafigi gorulme testi yapildi");
        merchantDashboard.signInMerchantMethod();
        extentTest.info("Merchant sitesine giris yapildi");
        merchantDashboard.dashboardLink.click();
        ReusableMethods.wait(2);
        extentTest.info("Dashboard tusuna tiklandi");
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.END).perform();
        extentTest.info("Sayfa en asagiya indirildi");
        ReusableMethods.wait(2);
        Assert.assertTrue(merchantDashboard.gorulurOlmaMethodu(merchantDashboard.getKartText(12)));
        extentTest.pass("Musteri puanlarinin  oldugu grafigin gorulurlugu testi yapildi");
        Driver.closeDriver();
    }
}
