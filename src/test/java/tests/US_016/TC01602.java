package tests.US_016;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.userMealscenter.UserHomePage;
import pages.userMealscenter.UserProfilPage;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;
public class TC01602 extends TestBaseRapor {
    @Test(groups = "demo")
    public void addressAddAndDelete(){
        extentTest = extentReports.createTest("Kullanıcının adres bilgilerini görüntüleme, ekleme, değiştirme ve silme işlemlerini gerçekleştirebildiği ve bu değişikliklerin başarılı şekilde kaydedildiği doğrulanmalıdır");

        //Browser açılır
        //Method kullanırak Meal center sitesine kullanıcı girişi yapılır.
        UserHomePage userHomePage = new UserHomePage();
        userHomePage.signInUserMethod();
        extentTest.info("Method kullanırak Meal center sitesine kullanıcı girişi yapıldı");

        //"https://qa.mealscenter.com/account/addresses" adresine gidilir
        Driver.getDriver().get("https://qa.mealscenter.com/account/addresses");
        extentTest.info("Method kullanırak Meal center sitesine kullanıcı girişi yapıldı");

        UserProfilPage userProfilPage = new UserProfilPage();

        //'Add new address' butonunun görünür olduğu test edilir.
        Assert.assertTrue(userProfilPage.addNewAddressButton.isDisplayed());
        extentTest.pass("'Add new address' butonunun görünür olduğu test edildi");

        //'Add new address' butonuna tıklanır.
        userProfilPage.addNewAddressButton.click();
        extentTest.info("'Add new address' butonuna tıklandı");

        //'Enter delivery address' kutusuna 'San Francisco' girilir
        userProfilPage.enterDeliveryAddressBox.sendKeys("San Fancisco");
        extentTest.info("'Enter delivery address' kutusuna 'San Francisco' girildi");

        //Çıkan ilk sonucun 'San Francisco' olduğu test edilir.
        String actualAddress = userProfilPage.enterDeliveryAddressIlkSonuc.getText();
        String expectedAddress = "San Francisco";
        Assert.assertEquals(expectedAddress,actualAddress);
        extentTest.pass("Çıkan ilk sonucun 'San Francisco' olduğu test edildi");

        //'San Francisco' adresi seçilir.
        userProfilPage.enterDeliveryAddressIlkSonuc.click();
        extentTest.info("'San Francisco' adresi seçildi");

        //'Adjust pin' butonuna tıklanır.
        userProfilPage.addressAdjustPin.click();
        extentTest.info("'Adjust pin' butonuna tıklandı");

        //Açılan harita üzerinden pin kaydırılarak adres seçilir.
        Actions actions = new Actions(Driver.getDriver());
        actions.clickAndHold(userProfilPage.haritaPin).build().perform();

        actions.moveByOffset(10,10).build().perform();
        actions.click().perform();
        extentTest.info("Açılan harita üzerinden pin kaydırılarak adres seçildi");

        //'Save' butonuna tıklanır.
        userProfilPage.adresSaveButton.click();
        extentTest.info("'Save' butonuna tıklandı");

        //'Aparment, suite or floor' kutusuna değer girilir.
        userProfilPage.adresLocationNameBox.sendKeys("Adres adı");
        extentTest.info("'Aparment, suite or floor' kutusuna değer girildi");

        //'Meet outside' seçenegi seçilir.
        Select select = new Select(userProfilPage.adresDeliveryOptionsSecimi);
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

        //'Address label' başlığı altından 'School' seçenegi seçilir.
        for (WebElement eachElement:userProfilPage.addresLabel) {
            if (eachElement.getText().equals("School")){
                eachElement.click();
            }
        }
        extentTest.info("'Address label' başlığı altından 'School' seçenegi seçildi");

        //'Save' butonuna tıklanır.
        userProfilPage.adresSaveButton.click();
        extentTest.info("'Save' butonuna tıklandı");

        //Eklenen adresin kayıtlı adresler içerisinde yer aldığı doğrulanır.
        for (WebElement eachElement:userProfilPage.kayitliAdresler) {

            if (eachElement.getText().contains("San Francisco")){
                Assert.assertTrue(eachElement.isDisplayed());
                break;
            }
        }
        extentTest.pass("Eklenen adresin kayıtlı adresler içerisinde yer aldığı doğrulandı");

        //Eklenen adresi silmek için 'Delete' butonuna tıklanır.
        userProfilPage.deleteFirstAddress.click();
        extentTest.info("Eklenen adresi silmek için 'Delete' butonuna tıklandı");

        //Açılan Confirm eklanında 'Yes' butonuna tıklanır
        userProfilPage.addressDeleteYes.click();
        extentTest.info("Açılan Confirm eklanında 'Yes' butonuna tıklandı");

        ReusableMethods.wait(1);
        //Adresin başarılı bir şekilde silindiği doğrulanır
        boolean deleteAddress = true;
        for (WebElement eachElement:userProfilPage.kayitliAdresler) {
            if (eachElement.getText().contains("San Francisco")){
                System.out.println(eachElement.getText());
                deleteAddress = false;
            }
        }
        Assert.assertTrue(deleteAddress);
        extentTest.pass("Adresin başarılı bir şekilde silindiği doğrulandı");
    }
}
