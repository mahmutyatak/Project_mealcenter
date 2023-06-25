package tests.US_012;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC01201 extends TestBaseRapor {

    @Test
    public void test01(){
        extentTest = extentReports.createTest("\"https://qa.mealscenter.com/restaurants\" sayfasına gidilmeli ve erişilebilir olduğu doğrulanmalıdır.");

        //*[@id="vue-feed"]/div[4]/div[2]/div[3]/div/div[3]

        //"https://qa.mealscenter.com/restaurants" adresine gidilir
        Driver.getDriver().get("https://qa.mealscenter.com/restaurants");
        extentTest.info("\"https://qa.mealscenter.com/restaurants\" adresine gidildi");

        //Sayafanın Url'sinin "https://qa.mealscenter.com/restaurants" oldugu test edilir.
        String expectedUrl = "https://qa.mealscenter.com/restaurants";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl);
        extentTest.pass("Sayafanın Url'sinin \"https://qa.mealscenter.com/restaurants\" oldugu test edildi");

    }


}
