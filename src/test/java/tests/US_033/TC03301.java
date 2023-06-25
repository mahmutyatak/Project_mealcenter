package tests.US_033;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC03301 extends TestBaseRapor {



    @Test
    public void accessMerchantPage(){

        extentTest = extentReports.createTest("Merchant anasayfaya erişim testi","Merchant anasayfaya erişim sağlayabilmeli");

        //Browser açılır.
        //Url kısmına "https://qa.mealscenter.com/backoffice/merchant" yazılır ve tıklanır.
        Driver.getDriver().get(ConfigReader.getProperty("mealCenterMerchantPageUrl"));
        extentTest.info("Mealscenter Merchant anasayfasına gidildi");

        // Sayfa başlığı doğrulanır.
        String expextedTitle="Merchant Login";
        String actuallTitle=Driver.getDriver().getTitle();
        Assert.assertEquals(actuallTitle,expextedTitle);
        extentTest.pass("Basarili sekilde sayfaya erişildiği test edildi");

        //Sayfa kapatılır.
        Driver.getDriver().quit();

    }
}
