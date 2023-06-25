package tests.US_007;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.userMealscenter.UserHomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC00702 extends TestBaseRapor {

    @Test
    public void test01(){
        extentTest = extentReports.createTest("Contact us sayfası, ziyaretçilerin web sitesi yöneticileri ile iletişim kurabilecekleri bir araç içermeli ve bu aracın foksiyonları görünür olmalıdır");
        UserHomePage userHomePage = new UserHomePage();

        //Browser açılır.
        //"https://qa.mealscenter.com/contactus" adresine gidilir.
        Driver.getDriver().get(ConfigReader.getProperty("mealCenterContactUs"));
        extentTest.info("\"https://qa.mealscenter.com/contactus\" adresine gidildi");

        //Form başlığının "Contact Us" oldugu test edilir.
        String expectedText = "Contact Us";
        String actualText = userHomePage.contactUsText.getText();
        Assert.assertEquals(expectedText,actualText);
        extentTest.pass("Form başlığının \"Contact Us\" oldugu test edildi");

        //Sayfada "Contact Us" formunun görünür olduğu test edilir
        Assert.assertTrue(userHomePage.contactUsForm.isDisplayed());
        extentTest.pass("Sayfada \"Contact Us\" formunun görünür olduğu test edildi");

        //Müşteri desteği için "Phone" bölümünün görünür olduğu test edilir.
        Assert.assertTrue(userHomePage.contactUsPhonebolumu.isDisplayed());
        extentTest.pass("Müşteri desteği için \"Phone\" bölümünün görünür olduğu test edildi");

        //"Phone" bölümünün "1-800-123-4567" destek numarasını içerdiği test edilir.
        String expectedPhone = "1-800-123-4567";
        String actualPhone = userHomePage.contacyUsPhoneText.getText();
        Assert.assertEquals(expectedPhone,actualPhone);
        extentTest.pass("\"Phone\" bölümünün \"1-800-123-4567\" destek numarasını içerdiği test edildi");


        //Müşteri desteği için "Email" bölümünün görünür olduğu test edilir.
        Assert.assertTrue(userHomePage.contactUsEmailbolumu.isDisplayed());
        extentTest.pass("Müşteri desteği için \"Email\" bölümünün görünür olduğu test edildi");

        //"Email" bölümünün "info@mealscenter.com" destek mailini içerdiği test edilir.
        String expectedMail = "info@mealscenter.com";
        String actualMail = userHomePage.contacyUsEmailText.getText();
        Assert.assertEquals(expectedMail,actualMail);
        extentTest.pass("\"Email\" bölümünün \"info@mealscenter.com\" destek mailini içerdiği test edildi");

        //"Full name" kutusunun görünür olduğu test edilir.
        Assert.assertTrue(userHomePage.contactUsFullNameBox.isDisplayed());
        extentTest.pass("\"Full name\" kutusunun görünür olduğu test edildi");

        //"Email address" kutusunun görünür olduğu test edilir.
        Assert.assertTrue(userHomePage.contactUsEmailBox.isDisplayed());
        extentTest.pass("\"Email address\" kutusunun görünür olduğu test edildi");

        //"Your message" kutusunun görünür olduğu test edilir.
        Assert.assertTrue(userHomePage.contactUsYourMessageBox.isDisplayed());
        extentTest.pass("\"Your message\" kutusunun görünür olduğu test edildi");

        //"Submit" butonunun görünür olduğu test edilir.
        Assert.assertTrue(userHomePage.contactUsSubmitButton.isDisplayed());
        extentTest.pass("\"Submit\" butonunun görünür olduğu test edildi");

        //İlgili görsel içeriğin görünür olduğu test edilir.
        Assert.assertTrue(userHomePage.contactUsPhoto.isDisplayed());
        extentTest.pass("İlgili görsel içeriğin görünür olduğu test edildi");

        //Sayfa kapatılır.


    }

}
