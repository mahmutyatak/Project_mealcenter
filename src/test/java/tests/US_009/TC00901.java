package tests.US_009;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.userMealscenter.UserHomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC00901 extends TestBaseRapor {

    @Test
    public void privacyPolicyTesti(){
        UserHomePage userHomePage = new UserHomePage();
        extentTest=extentReports.
                createTest("privacyPolicyTesti","Privacy Policy butonunun görünür olduğu ve sayfaya yönlendirdiği doğrulanır");

        //Browser açılır.
        //qa.mealscenter.com sayfasına gidilir.
        Driver.getDriver().get(ConfigReader.getProperty("mealCenterHomePageUrl"));
        extentTest.info("Meals Center anasayfaya gidildi");

        //Cookie reddedilir
        userHomePage.Declinecookie.click();
        extentTest.info("cookie kabul edildi");

        //Privacy Policy elementine kadar inilir.
        ReusableMethods.scrollToElement(userHomePage.privacyPolicyElementi);
        extentTest.info("Privacy Policy elementine kadar inildi");

        //'Privacy policy' butonunun göründüğü test edilir.
        Assert.assertTrue(userHomePage.privacyPolicyElementi.isDisplayed());
        extentTest.info("'Privacy policy' butonunun göründüğü test edildi");


        //'Privacy policy' butonuna tıklanır.
        userHomePage.privacyPolicyElementi.click();
        extentTest.info("'Privacy policy' butonuna tıklandı");

        // 'Privacy policy' sayfasının açıldığı doğrulanır.
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("privacy-policy"));
        extentTest.info("Açılan sayfa url'inin privacy-policy içerdiği test edildi");


        //Açılan sayfada 'Privacy Policy' başlığının olduğu doğrulanır.
        Assert.assertTrue(userHomePage.gizPolSayfaBaslikYazisi.getText().equals("Privacy policy"));
        extentTest.info("açılan sayfada Privacy policy başlığı olduğu doğrulandı");

        Driver.closeDriver();

    }
}
