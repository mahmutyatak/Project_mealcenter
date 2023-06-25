package tests.US_009;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.userMealscenter.UserHomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.JSUtils;
import utilities.TestBaseRapor;

public class TC00902 extends TestBaseRapor {

    @Test
    public void privacyPolicyDogruIcerikTesti(){
        UserHomePage userHomePage = new UserHomePage();
        extentTest=extentReports.
                createTest("privacyPolicyIcerikTesti","Privacy Policy sayfasının içeriği doğrulanır");

        //Browser açılır.
        //qa.mealscenter.com sayfasına gidilir.
        Driver.getDriver().get(ConfigReader.getProperty("mealCenterHomePageUrl"));
        extentTest.info("Meals center anasayfaya gidildi");

        //cookie reddedilir
        userHomePage.Declinecookie.click();
        extentTest.info("cookie reddedildi");

        //sayfanın en altına inilir
        JSUtils.scrollDownByJS();
        extentTest.info("sayfanın altına inildi");

        //'Privacy policy' butonuna tıklanır.
        userHomePage.privacyPolicyElementi.click();
        extentTest.info("Privacy policy elementine tıklandı.");

        //açılan sayfada yazı başlıkları kontrol edilerek içeriğin
        // gizlilik politikası ile ilgili olduğu test edilir.
        String actualBaslik = userHomePage.istenenBaslik(1).getText();
        String expectedBaslik = "Information We Collect";
        Assert.assertEquals(actualBaslik,expectedBaslik);

        actualBaslik = userHomePage.istenenBaslik(2).getText();
        expectedBaslik = "How We Use Your Information";
        Assert.assertEquals(actualBaslik,expectedBaslik);

        actualBaslik = userHomePage.istenenBaslik(3).getText();
        expectedBaslik = "Disclosure of Your Information";
        Assert.assertEquals(actualBaslik,expectedBaslik);

        actualBaslik = userHomePage.istenenBaslik(4).getText();
        expectedBaslik = "Security of Your Information";
        Assert.assertEquals(actualBaslik,expectedBaslik);

        actualBaslik = userHomePage.istenenBaslik(5).getText();
        expectedBaslik = "Contact Us";
        Assert.assertEquals(actualBaslik,expectedBaslik);
        extentTest.info("açılan sayfada 5 başlığın da gizlilik politikası ile ilgili olduğu test edildi");

        Driver.closeDriver();
        extentTest.info("Sayfa kapatıldı");


    }
}
