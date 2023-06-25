package tests.US_007;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC00701 extends TestBaseRapor {

    @Test
    public void contactUsUrlTest(){
        extentTest = extentReports.createTest("'https://qa.mealscenter.com/contactus' adresine gidilmeli, bu adresin erişilebilir oldugu doğrulanmalıdır");
        //Browser açılır.
        //"https://qa.mealscenter.com/contactus" adresine gidilir.
        Driver.getDriver().get("https://qa.mealscenter.com/contactus");
        extentTest.info("'https://qa.mealscenter.com/contactus' adresine gidildi");

        //Gidilen sayfanın url'sinin "https://qa.mealscenter.com/contactus" olduğu test edilir.
        String expectedUrl = "https://qa.mealscenter.com/contactus";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
        extentTest.pass("Gidilen sayfanın url'sinin 'https://qa.mealscenter.com/contactus' olduğu test edildi.");

    }

}
