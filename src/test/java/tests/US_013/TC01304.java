package tests.US_013;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.userMealscenter.UserHomePage;
import pages.userMealscenter.UserProfilPage;
import pages.userMealscenter.UserStorePage;
import utilities.*;

public class TC01304 extends TestBaseRapor {

    @Test
    public void chooseA_deliveryAddressTesti(){
        UserStorePage userStorePage = new UserStorePage();
        UserProfilPage userProfilPage = new UserProfilPage();
        UserHomePage userHomePage = new UserHomePage();
        extentTest=extentReports.
                createTest("Sipariş adresi Testi","Sepet sayfasında " +
                        "'Choose a delivery address' bölümündeki seçeneklerin çalıştığı doğrulanır");
        //Browser açılır.
        //    qa.mealscenter.com sayfasına gidilir
        Driver.getDriver().get(ConfigReader.getProperty("mealCenterHomePageUrl"));
        extentTest.info("Meals center anasayfaya gidildi");


        // cookie reddedilir
        userHomePage.Declinecookie.click();
        extentTest.info("Cookie reddedildi");

        //başarılı kullanıcı girişi ile kullanıcı anasayfasına gidilir
        userHomePage.kullaniciGirisi("team4@hotmail.com","team4***");
        ReusableMethods.bekle(2);
        extentTest.info("Geçerli username ve password ile giriş yapıldı");

        // adres Search Box a Seattle yazılır
        userProfilPage.adresSearchBox.sendKeys("Seattle");
        //Seattle adresine tıklanır
        userProfilPage.seattleAdres.click();
        extentTest.info("Adres arama kutusuna Seattle yazılarak adres seçildi.");


        // LaPalmera restaurantına tıklanır
        userProfilPage.laPalmera.click();
        extentTest.info("La Palmera restaurantı seçildi");

        // 5. ürüne kadar inilir
        ReusableMethods.scrollToElement(userStorePage.getUrunGorseli(7));
        // 4. ürünün 'Add to Cart' butonuna tıklanır
        userStorePage.getUrunAddToCartButon(7).click();
        extentTest.info("7. urun sepete eklendi");

        // Sepeti görütülemek için 'Checkout' butonuna tıklanır.
        userStorePage.checkoutButon.click();
        extentTest.info("Sepet sayfasına gidildi.");

        ReusableMethods.bekle(2);
        //'Choose a delivery address' bölümü görünür oluncaya kadar aşağı inilir.
        JSUtils.scrollDownByJS();
        extentTest.info(" 'Choose a delivery address bölümüne inildi.");

        //'Add new adress' butonuna tıklanır.
        userProfilPage.addNewAddress.click();
        extentTest.info("Add new Address butonuna tıklandı.");

        //'Choose a delivery address' kutusuna 'Houston' yazılır.
        userProfilPage.enterDeliveryAddress.sendKeys("Houston");
        //Açılan seçenekler penceresinden ilk sıradaki seçilir.
        userProfilPage.ilksiradakiAdres.click();
        extentTest.info("Adres arama kutusuna Houston yazılarak adres seçildi.");


        ReusableMethods.bekle(2);
        //Açılan pencerede 'adjust pin' butonuna tıklanır
        userProfilPage.adjustPin.click();
        extentTest.info("Açılan pencerede 'adjust pin' butonuna tıklandı.");

        Actions actions = new Actions(Driver.getDriver());
        actions.clickAndHold(userProfilPage.haritaPin).build().perform();

        actions.moveByOffset(10,10).build().perform();
        actions.click().perform();
        extentTest.info("Açılan harita üzerinden pin kaydırılarak adres seçildi");

        ReusableMethods.bekle(2);
       /* //Harita üzerinde konuma tıklanır
        userProfilPage.harita.click();
        extentTest.info("Haritada konum seçildi.");

        //Harita üzerinde konum seçilebildiği doğrulanır.(********BUG*******)

        Assert.assertTrue(userProfilPage.harita.isSelected());
        extentTest.info("Haritada konum seçilebildiği doğrulanır.");

        */




        //'Save' butonunun aktif olduğu doğrulanır(***********BUG**************)
        Assert.assertTrue(userProfilPage.haritaPinSave.isEnabled());
        extentTest.info("'Save' butonunun aktif olduğu doğrulandı.");

        //'Save' butonuna tıklandı
        userProfilPage.haritaPinSave.click();
        extentTest.info("'Save' butonuna tıklandı.");


        //Seçilmiş adresin girilen adres olduğu doğrulanır.
        String actualAdres=userProfilPage.seciliAdres.getText();
        String expectedAdres="Houston";
        Assert.assertTrue(actualAdres.contains(expectedAdres));
        extentTest.info("Seçilmiş adresin girilen adres olduğu doğrulandı.");


        //Sayfa kapatılır
        Driver.closeDriver();
        extentTest.info("Sayfa kapatıldı.");
    }
}
