package tests.US_022;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.merchantMealscenter.MerchantDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC02204 extends TestBaseRapor {

    /*
    https://qa.mealscenter.com/backoffice/auth/login' sayfasına gidilir
    Merchant Login" menusunde "username" bolumune gecerli username "pasword"
    bolumune gecerli pasword girilir ve "sign in" bolumune tiklanir
    Header bolumunde bulunan  Restorant yöneticisi menusunden "profil" menusu tiklanir
    Galery imaj menusu olduğu test edilir
    Galery İmaj browse tiklanir
    İstenilen resim tiklanir
    Profil resminin guncellendigi test edilir
    Profil dropdown menudeki "Logout" butonuna tıklanir
    Sayfa kapatilir
     */
    MerchantDashboard merchantDashboard = new MerchantDashboard();

    @Test
    public void test01() {
        //Merchant sayfasininin profiline resim eklenebilir,guncellenebilir bir menu olmalidir
        extentTest = extentReports.createTest("Merchant sayfasininin profiline resim eklenebilir,guncellenebilir testi",
                                            "Update,Save Gorunurluk testi");

        //'https://qa.mealscenter.com/backoffice/auth/login' sayfasına gidilir
        Driver.getDriver().get(ConfigReader.getProperty("mealCenterMerchantPageUrl"));
        extentTest.info("''https://qa.mealscenter.com/backoffice/auth/login' sayfasına gidildi");

        Actions actions = new Actions(Driver.getDriver());

        //Username ve password bilgiler girilir
        actions.sendKeys(merchantDashboard.usernameBox, ConfigReader.getProperty("LaPalmeraUsername"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("LaPalmeraPassword")).perform();
        extentTest.info("Username ve password bilgiler girildi");

        //"Sign in" butonuna tıklanir
        merchantDashboard.signinButton.click();
        extentTest.info("Sign in butonuna tıklandi");

        //"Profil"  menusu tiklanir
        merchantDashboard.profileButton.click();
        extentTest.info("Profil menusu tiklandi");
        ReusableMethods.bekle(1);

        //"Profil" dropDown menusu tiklanir
        actions.click(merchantDashboard.dashboardProfilDropDown).perform();
        extentTest.info("Profil dropDown menusu tiklandi");

       // Galery imaj menusu olduğu test edilir
        merchantDashboard.profilResimEklemeMenusu.isDisplayed();
        extentTest.pass(" Galery imaj menusu olduğu test edildi");

      //  Galery İmaj browse tiklanir
      merchantDashboard.profilResimEklemeButonu.click();
        extentTest.info(" Galery İmaj browse tiklandi");

        ReusableMethods.bekle(2);
      //  İstenilen resim tiklanir
        actions.click(merchantDashboard.profilResimOrnek).perform();
        extentTest.info("  İstenilen resim tiklanirdi");

      //  Add Files butonu tiklanir
       actions.click(merchantDashboard.profilSecilenResimAdFiles).perform();
        extentTest.info(" Add Files butonu tiklandi");

        ReusableMethods.bekle(2);
      //  Save butonu tiklanir
       actions.click(merchantDashboard.profilSaveButton) .perform();
        extentTest.info(" Save butonu tiklandi");

     // Profil resminin guncellendigi test edilir
        Assert.assertTrue(merchantDashboard.profilUpdateYazisi.isDisplayed());
        extentTest.pass(" Profil resminin guncellendigi test edildi");

        // profilden cikis yapilir
        merchantDashboard.logOutMethod();
        extentTest.info("profilden cikis yapildi");

        // Sayfa Kapatilir
        Driver.getDriver().close();
        extentTest.info("Sayfa kapatildi");;

    }
}
