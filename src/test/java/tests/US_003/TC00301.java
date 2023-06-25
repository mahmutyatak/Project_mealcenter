package tests.US_003;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.userMealscenter.UserHomePage;
import utilities.*;

public class TC00301 extends TestBaseRapor {

    //Browser açılır.
    //Kullanıcı "https://qa.mealscenter.com/"  adresine gider.
    //Body bölümünün görünür olduğu test edilir.

    UserHomePage userHomePage=new UserHomePage();
    @Test
    public void Test01() {

        extentTest = extentReports.createTest("Meals Center Home Page erisim testi", "Meals Center Home Page sayfasina erisim saglanabilmeli");

        Driver.getDriver().get(ConfigReader.getProperty("mealCenterHomePageUrl"));
        extentTest.info("Mealscenter Home Page'e  gidildi");

        String actualUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(ConfigReader.getProperty("mealCenterHomePageUrl")));
        ReusableMethods.bekle(2);
        extentTest.pass("Meals Center Home Page Url dogrulandi");

        JSUtils.scrollDownByJS();
        ReusableMethods.bekle(2);
        extentTest.pass("Meals Center body bölümünün görünür olduğu test edildi");
        Driver.closeDriver();

    }

}
