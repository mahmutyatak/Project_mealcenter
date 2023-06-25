package tests.US_017;

import com.github.javafaker.Faker;
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

public class TC01701 extends TestBaseRapor {

    /*
        qa.mealscenter.com' sayfasına gidilir
        Cookie'yi kabul eder.
       "Sign in" menusu  tıklanır
        Gecerli email ve password girilir
        Ana menüdeki "Profil" bölümüne tiklanir
       "Ödeme Seçenekleri" seçeneğine tiklanir
        Odemeler menusunde "Yeni Odeme Ekle" butonu tiklanir
       "Yeni Ödeme Yöntemi Ekle" menusunden;
        Stripe menusu tiklanir ve "Kart Numarasi'' bolumune yanlis kart bilgileri girilir ve "Kaydet" butonu
        tiklanir.Odeme bilgileri kaydedilemedigi test edilir
       "Stripe menusu tiklanir ve "Kart Numarasi'' bolumune kart numarasi girilir ve "Kaydet" butonu
        tiklanir.Odeme bilgileri kaydedildigi test edilir
        Sayfa Kapatilir
        Odeme bilgilerini gorüntülendiği dogrulanir
        Açılan dropdown menudeki "Logout" butonuna tıklanir
         Sayfa kapatılır.
     */

    UserHomePage userHomePage=new UserHomePage();
    UserProfilPage userProfilPage=new UserProfilPage();
    Faker faker=new Faker();

    @Test
    public void test(){

        // Kullanıcı, hesabına ait ödeme bilgilerini
        // goruntulendigini ve yeni ödeme bilgilerinin kaydedildigini dogrulayin
        extentTest = extentReports.createTest("Odeme bilgilerinin gorunurluk testi", "Gorunurluk testi edildi");

        // 'https://qa.mealscenter.com/account/login' sayfasına gidilir
        Driver.getDriver().get(ConfigReader.getProperty("mealCenterMerchantSignUp"));
        extentTest.info("https://qa.mealscenter.com/account/login sayfasına gidildi");

        String lastNameFaker=faker.name().lastName();
        String internetFaker=faker.internet().emailAddress();
        String telefonFaker=faker.phoneNumber().cellPhone();

        // Profil isim girilir
       userHomePage.singUpName.sendKeys("Hasan");
        extentTest.info("Profil isim girildi");

       //Faker otomation Soyisim girilir
       userHomePage.singUpSoyisim.sendKeys(lastNameFaker);
        extentTest.info("Soyisim isim girildi");

       //Faker otomation Email girilir
       userHomePage.singUpEmail.sendKeys(internetFaker);
        extentTest.info("Email girildi");

       //Telefon bilgileri girilir
        userHomePage.singUpTelefon.sendKeys(telefonFaker);
       //userHomePage.singUpTelefon.sendKeys("4587487282");
        extentTest.info("Telefon no girildi");

       //Password girilir
       userHomePage.singUpsifre.sendKeys("hasan445.");
        extentTest.info("Password  girildi");

       //Password tekrar giriir
       userHomePage.singUpIkinciSifre.sendKeys("hasan445.");
        extentTest.info("Password tekrar girildi");

       // Sign in kayit butonu tiklanir
       userHomePage.signUpKayitButton.click();
        extentTest.info("Sign in kayit butonu tiklandi");
       ReusableMethods.bekle(2);

        Actions actions = new Actions(Driver.getDriver());

        //profil butonu tiklanir
        userProfilPage.profilButton.click();
        extentTest.info("profil butonu tiklandi");

        //  "Ödeme Seçenekleri" seçeneğine tiklanir
        userProfilPage.paymentOptions.click();
        extentTest.info("Ödeme Seçenekleri secenegine tiklandi");

       // Odeme bilgilerini gorüntülendiği dogrulanir
        String expectedIcerik="Add new payment";
        String actualIcerik=userProfilPage.addNewPaymont.getText();
        assertTrue(actualIcerik.contains(expectedIcerik));
        extentTest.pass("'Odeme bilgilerini gorüntülendigi test edildi");

        // Odemeler menusunde "Yeni Odeme Ekle" butonu tiklanir
        userProfilPage.addNewPaymont.click();
        extentTest.info("Odemeler menusunde 'Yeni Odeme Ekle' butonu tiklandi");
        ReusableMethods.bekle(2);

        // "Cash on delivery" menusu tiklanir
        userProfilPage.cashOnDeliveryButton.click();
        extentTest.info(" 'Cash on delivery' menusu tiklandi");

        // Add to Cash butonu tiklanir ve kapida ödeme yöntemi secilir
        userProfilPage.addTocashButton.click();
        extentTest.info(" 'Add to Cash butonu tiklandi");

        // Cash On delivery (kapida ödeme) seceneginin eklendigi test edilir
         expectedIcerik="Cash On delivery";
         actualIcerik=userProfilPage.cashOnDeliveryButton.getText();
        assertTrue(actualIcerik.contains(expectedIcerik));
        extentTest.pass("'Cash On delivery (kapida ödeme) seceneginin eklendigi test edildi");

       // "Stripe menusu tiklanir
        userProfilPage.stripeButton.click();
        extentTest.info("Stripe menusu tiklandi");

        ReusableMethods.bekle(2);

        // Kredi karti bilgileri girilir
        actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
        ReusableMethods.bekle(5);
        actions.sendKeys(Keys.TAB).perform();
        ReusableMethods.bekle(5);
                     actions.sendKeys("4242424242424242").sendKeys("1225").
                             sendKeys("235").sendKeys("14554").build().perform();
        extentTest.info(" Kredi karti bilgileri girildi");

        //"Odeme ekle" butonu tiklanir
        userProfilPage.addStrRipe.click();
        extentTest.info("Odeme ekle butonu tiklandi");

        //Kredi karti bilgilerinin basarili girildigi test edilir
        assertTrue (userProfilPage.krediKartıEklendiMenusu.isDisplayed());
        extentTest.pass("'Cash On delivery (kapida ödeme) seceneginin eklendigi test edildi");


        //Kredi karti bilgilerinin basarili girildigi test edilir
        assertTrue (userProfilPage.cashOdemeEklendiMenusu.isDisplayed());
        extentTest.pass("Kredi karti bilgilerinin basarili girildigi test edildi");

             // Sayfa Kapatilir
         Driver.getDriver().close();
        extentTest.info("Sayfa kapatildi");





    }

}
