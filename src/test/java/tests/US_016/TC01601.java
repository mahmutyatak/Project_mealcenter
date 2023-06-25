package tests.US_016;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.userMealscenter.UserHomePage;
import pages.userMealscenter.UserProfilPage;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.util.List;

public class TC01601 extends TestBaseRapor {

    //"https://qa.mealscenter.com/account/addresses" adresine gidilmeli ve erişilebilir olduğu doğrulanmalıdır.
    //Kullanıcının adres bilgilerini içeren fonksiyonların, görünür ve işlevsel olduğu doğrulanmalıdır.
    //Kullanıcı adres bilgilerini görüntüleme, ekleme, değiştirme ve silme işlemlerini gerçekleştirebildiği ve bu
    // değişikliklerin başarılı şekilde kaydedildiği doğrulanmalıdır.

    @Test
    public void test01(){
        extentTest = extentReports.createTest("'https://qa.mealscenter.com/account/addresses' adresine gidilmeli ve erişilebilir olduğu doğrulanmalıdır.");

        //Browser açılır
        //Method kullanırak Meal center sitesine kullanıcı girişi yapılır.
        UserHomePage userHomePage = new UserHomePage();
        userHomePage.signInUserMethod();
        extentTest.info("Method kullanılarak kullanıcı girişi yapıldı");

        //"https://qa.mealscenter.com/account/addresses" adresine gidilir
        Driver.getDriver().get("https://qa.mealscenter.com/account/addresses");
        extentTest.info("'https://qa.mealscenter.com/account/addresses' adresine gidildi");

        //Gidilen sayfanın url'sinin "account/addresses" içerdiği test edilir
        String expectedUrlIcerik = "account/addresses";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));
        extentTest.pass("Gidilen sayfanın url'sinin 'account/addresses' içerdiği test edildi");
    }

    @Test
    public void test02() {

        extentTest = extentReports.createTest("Kullanıcının adres bilgilerini içeren fonksiyonların, görünür ve işlevsel olduğu ve kayıtlı adresleri üzerinde düzenleme yapabildiği doğrulanmalıdır.");

        UserProfilPage userProfilPage = new UserProfilPage();

        //"https://qa.mealscenter.com/account/addresses" adresine gidilir
        Driver.getDriver().get("https://qa.mealscenter.com/account/addresses");
        extentTest.info("\"https://qa.mealscenter.com/account/addresses\" adresine gidildi");

        //Kayıtlı adres düzenlemesi için 'Edit' butonuna tıklanır.
        userProfilPage.addressEdit.click();
        extentTest.info("Kayıtlı adres düzenlemesi için 'Edit' butonuna tıklandı");

        //'Adjust pin' butonuna tıklanır.
        userProfilPage.addressAdjustPin.click();
        extentTest.info("'Adjust pin' butonuna tıklandı");

        //Açılan harita üzerinden pin kaydırılarak adres seçilir.
        WebElement haritaPin = Driver.getDriver().findElement(By.xpath("//img[@*='https://maps.gstatic.com/mapfiles/transparent.png']"));

        Actions actions = new Actions(Driver.getDriver());
        actions.clickAndHold(haritaPin).build().perform();

        actions.moveByOffset(10,10).build().perform();
        actions.click().perform();
        extentTest.info("Açılan harita üzerinden pin kaydırılarak adres seçildi");

        //'Save' butonunun aktif olduğu test edilir.
        Assert.assertTrue(userProfilPage.adresSaveButton.isEnabled());
        extentTest.pass("'Save' butonunun aktif olduğu test edildi");

        //'Save' butonuna tıklanır.
        userProfilPage.adresSaveButton.click();
        extentTest.info("'Save' butonuna tıklandı");

        //'Aparment, suite or floor' kutusuna değer girilir.
        userProfilPage.adresLocationNameBox.sendKeys("Adres adı");
        extentTest.info("'Aparment, suite or floor' kutusuna değer girildi");

        //'Delivery options' seçeneklerinin 'Leave it at my door', 'Hand it to me', 'Meet outside' seçeneklerini icerdiği test edilir.
        Select select = new Select(userProfilPage.adresDeliveryOptionsSecimi);
        List<WebElement> deliveryOptionsList = select.getOptions();

        //'Meet outside' seçenegi seçilir.
        select.selectByVisibleText("Meet outside");
        extentTest.info("'Meet outside' seçenegi seçildi");

        //'Meet outside' seçeneginin seçildiği doğrulanır.
        String actualSelect = select.getFirstSelectedOption().getText();
        String expectedSelect = "Meet outside";
        Assert.assertEquals(expectedSelect,actualSelect);
        extentTest.pass("'Meet outside' seçeneginin seçildiği doğrulandı");

        //'Add delivery instructions' kutusuna bir değer girilir.
        userProfilPage.adresAddDeliveryInstructionsBox.sendKeys("Bu bir deneme yazısıdır");
        extentTest.info("'Add delivery instructions' kutusuna bir değer girildi");

        //'Address label' başlığı altındaki seçeneklerin görünür olduğu test edilir.
        for (WebElement eachElement:userProfilPage.addresLabel) {
            Assert.assertTrue(eachElement.isDisplayed());
        }
        extentTest.pass("'Address label' başlığı altındaki seçeneklerin görünür olduğu test edildi");

        //'Address label' başlığı altından 'School' seçenegi seçilir.
        for (WebElement eachElement:userProfilPage.addresLabel) {
            if (eachElement.getText().equals("School")){
                eachElement.click();
            }
        }
        extentTest.info("'Address label' başlığı altından 'School' seçenegi seçildi");

        //'Save' butonunun aktif olduğu test edilir.
        Assert.assertTrue(userProfilPage.adresSaveButton.isEnabled());
        extentTest.pass("'Save' butonunun aktif olduğu test edildi");

        //'Save' butonuna tıklanır.
        userProfilPage.adresSaveButton.click();
        extentTest.info("'Save' butonuna tıklandı");

    }

}
