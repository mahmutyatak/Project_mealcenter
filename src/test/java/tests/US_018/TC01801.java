package tests.US_018;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.userMealscenter.UserHomePage;
import pages.userMealscenter.UserProfilPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import static org.testng.AssertJUnit.assertTrue;

public class TC01801 extends TestBaseRapor {
    /*
    'https://qa.mealscenter.com/account/login' sayfasına gidilir
    "Sign in" menusu  tıklanır
     Gecerli email ve password girilir
     Sing in butonu tiklanir
    'Profil'menusu tiklanir
    "Saved Stores" menusu tiklanir
     Acilan sayfadan beğendiği bir restoranı için "kalp" imajini tıklanir
     Secilen restorantlarin kaydedildigi test edilir
     Sayfa Kapatilir
     */
    UserHomePage userHomePage=new UserHomePage();
    UserProfilPage userProfilPage=new UserProfilPage();

    @Test
    public void test01(){

       // Kullanıcı sitede bulunan ve beğendigi restorantları
       // seçebilmeli ve kaydedebilmeli ve kayıtlı
       // mağazalarda görebilmeli ve restorantı kullanıcı profili içinde yer almalıdır.
        extentTest = extentReports.createTest("Begenilen restorantlarin secme,kaydetme  islemleri testi", "Update ve Delete islemleri ve gorunurluk test edildi");

        // 'https://qa.mealscenter.com/account/login' sayfasına gidilir
        Driver.getDriver().get(ConfigReader.getProperty("mealCenterLoginPage"));
        extentTest.info("https://qa.mealscenter.com/account/login sayfasına gidildi");

        // Cookie kabul edilir
        userHomePage.acceptCookie.click();
        extentTest.info("Cookies kabul edildi");

        ReusableMethods.bekle(1);

        //Gecerli email girilir
        userHomePage.signInUsernameBox.sendKeys("team4@hotmail.com");
        extentTest.info("Gecerli email girildi");

        //Gecerli password girilir
        userHomePage.signInPasswordBox.sendKeys("team4***");
        extentTest.info("Gecerli password girilir");

        // Sing in butonu tiklanir
        userHomePage.signUpKayitButton.click();
        extentTest.info("Sing in butonu tiklandi");

        // Adress Search menusu tiklanir
        userHomePage.adressSearchButonu.click();
        extentTest.info("Adress Search menusu tiklandi");

        // "Seattle" yazilir
        userHomePage.adressSearchButonu.sendKeys("Seattle");
        extentTest.info("Adress 'Seattle' yazildi");
        ReusableMethods.wait(2);

        // "Seattle adresi secilir
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();
        extentTest.info("Seattle adresi secildi");
        ReusableMethods.bekle(2);

        // profil butonu tiklanir
        userProfilPage.profilButton.click();
        extentTest.info("Profil butonu tiklandi");
        ReusableMethods.bekle(2);

        // ''Saved Stores" dropDownu tiklanir
        userProfilPage.savedStoresDropDown.click();
        extentTest.info("'Saved Stores' dropDownu tiklandi");

        // "Order Nov buttonu tiklanir
        userProfilPage.orderNownButton.click();
        extentTest.info("'Order Nov' buttonu tiklandi");

        // İstenilen restorantlar secilir
        userProfilPage.lapalmeraKalpEmoji.click();
        extentTest.info("'La Palmera' restoranti secildi");

        userProfilPage.starBucksKalpEmoji.click();
        extentTest.info("'StarBucks' restoranti secildi");

        userProfilPage.mcDonaldsKalpEmoji.click();
        extentTest.info("'McDonalds' restoranti secildi");

        //HomePage sayfasina geri donmek icin mealCenter logosu tiklanir
        userHomePage.mealsCenterLogo.click();
        extentTest.info("HomePage sayfasina geri donmek icin mealCenter logosu tiklandi");

        //Begenilen restontlari gormek icin profil butonu tiklanir
        userProfilPage.profilButton.click();
        extentTest.info("Begenilen restontlari gormek icin profil butonu tiklandi");

        // ''Saved Stores" dropDownu tiklanir
        userProfilPage.savedStoresDropDown.click();
        extentTest.info(" 'Saved Stores' dropDownu tiklandi");

        //Begenilen restorantlarin ''Saved Stores" menusunde goruldugu test edilir
        //McDonalds restorantinin gorunurlugu test edilir
        assertTrue(userProfilPage.mcDonaldsMenuLogo.isDisplayed());
        extentTest.pass("McDonalds restorantinin gorunurlugu test edildi");


        ReusableMethods.bekle(1);
        //La Palmera restorantinin gorunurlugu test edilir
        assertTrue(userProfilPage.lapalmeraMenuLogo.isDisplayed());
        extentTest.pass("La Palmera restorantinin gorunurlugu test edildi");

        ReusableMethods.bekle(1);
        //StarBucks restorantinin gorunurlugu test edilir
        assertTrue(userProfilPage.starBucksMenuLogo.isDisplayed());
        extentTest.pass("StarBucks restorantinin gorunurlugu test edildi");


       // Sayfa kapatilir
        Driver.getDriver().close();
        extentTest.info("Sayfa kapatildi");


    }
}
