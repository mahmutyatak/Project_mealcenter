package tests.US_002;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.userMealscenter.UserHomePage;
import pages.userMealscenter.UserProfilPage;
import pages.userMealscenter.UserStorePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC00203 extends TestBaseRapor {


    UserHomePage userHomePage = new UserHomePage();
    UserProfilPage userProfilPage=new UserProfilPage();
    UserStorePage userStorePage=new UserStorePage();




    /*
    'qa.mealscenter.com' sayfasına gidilir
    Cookie'yi kabul eder.
    "Sign in" menusu  tıklanır
    Gecerli email ve password girilir
    Anasayfada yemekler bolumunde "Amerikan" menusu tiklanir.
    İstenilen restoranttan bir menu secilir
    Sepete eklenir.
    Sepette ve Card bolumune tiklanir
    Sepete eklenen urun odeme yapilmadan sonuclandirilmadan
    Kullanici hesabi tiklanir "Guvenli Cikiş tiklanir ve cikis yapilir.
    Açılan dropdown menudeki "Logout" butonuna tıklanir
    Sayfa kapatılır.
     */

    @Test(groups = "demo")
    public void test() {
        UserHomePage userHomePage = new UserHomePage();
        UserProfilPage userProfilPage=new UserProfilPage();
        // Home page sayfasının header bölümünde yer alan
        //"Card" ve "Basket Logosunun"menusunun
        // Kullanici "güvenli cikiş" yaptiktan sonra Sepet
        //  menusun boş oldugunu dogrulayin

        extentTest = extentReports.createTest("Kullanici 'güvenli cikiş' yaptiktan sonra" +
                " Sepet  testi menusun boş oldugunun testi", "Gorunurluk test edildi");

        // 'qa.mealscenter.com' sayfasına gidilir
        Driver.getDriver().get(ConfigReader.getProperty("mealCenterHomePageUrl"));
        extentTest.info("https://qa.mealscenter.com  ana sayfasına gidildi");

        // Cookees kabul edilir
        Actions actions = new Actions(Driver.getDriver());
        actions.click(userHomePage.acceptCookie).build().perform();
        extentTest.info("Cookies kabul edildi");

        // Adress Searc bolumunden adres secilir
        userHomePage.adressSearchButonu.click();
        userHomePage.adressSearchButonu.sendKeys("Seattle");
        ReusableMethods.wait(2);
        actions.sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();
        extentTest.info("Adress Searc bolumunden adres secildi");
        ReusableMethods.wait(1);

        // Login bolumune sign in butonu tiklanir
        userHomePage.signInButonu.click();
        extentTest.info(" Login bolumune sign in butonu tiklandi");

        //  gecerli email girilir
        actions.click(userHomePage.signInUsernameBox).sendKeys("team4@hotmail.com").perform();
        extentTest.info(" gecerli email girildi");

        //gecerli password girilir
        actions.click(userHomePage.signInPasswordBox).sendKeys("team4***").perform();
        extentTest.info(" gecerli password girildi");

        //Sign in butonu tiklanir
        userHomePage.signIn.click();
        extentTest.info(" Sign in butonu tiklandi");

        // "Amerikan" menusu tiklanir
        userHomePage.americanMutfaklarElementi.click();
        extentTest.info("Amerikan' menusu tiklandi");

        //McDonalds restorantı tiklanir
        userProfilPage.mcDonaltsButton.click();
        extentTest.info("StarBuck' restoranti tiklandi");

        userStorePage.getUrunAddToCartButon(1).click();
        ReusableMethods.bekle(2);
        extentTest.info("Sepete urun eklendi");

        // Kullanici profili tiklanir
        userProfilPage.profilButton.click();
        extentTest.info("Kullanici profili tiklandi");

        // Kullanici profilinden "çıkış" butonu tiklanir  cikis yapilir
        userProfilPage.logoutButton.click();
        extentTest.info(" Kullanici profilinden 'çıkış' butonu tiklandi cikis yapildi");

        ReusableMethods.bekle(1);

        //Sepet dropDown menusune tiklanir
        userProfilPage.basketLogo.click();
        extentTest.info(" Sepet dropDown menusune tiklandi");

        ReusableMethods.bekle(2);

        // Kullanici cikisindan sonra "Sepet" menusunun boş oldugu test edilir
        String expectedIcerik="You don't have any orders here";
        String actualIcerik=userProfilPage.summaryText.getText();
        Assert.assertTrue(actualIcerik.contains(expectedIcerik),"Kullanici guvenli cikis yapmasina ragmen sepette urun gozukuyor ");
        extentTest.fail("'Sepet' menusunun boş oldugu test edilemedi");

        ReusableMethods.bekle(2);


        // Sayfa kapatilir
        extentTest.info("Sayfa kapatildi");



    }
}
