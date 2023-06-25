package tests.US_014;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.userMealscenter.UserHomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC01401 extends TestBaseRapor {

    //"https://qa.mealscenter.com/account/profile" adresine gidilmeli ve erişilebilir olduğu doğrulanmalıdır.
    //Kullanıcının profil bilgilerini içeren fonksiyonların, görünür ve işlevsel olduğu doğrulanmalıdır.
    //Kullanıcı profil bilgilerini değiştirebilmeli ve değiştirebildiği doğrulanmalıdır.
    //Yapılan profil bilgisi değişikliği sonrası değişikliklerin başarılı bir şekilde kaydedildiği doğrulanmalıdır.

    @Test(groups = "demo")
    public void test01(){
        UserHomePage userHomePage = new UserHomePage();
        extentTest = extentReports.createTest("\"https://qa.mealscenter.com/account/profile\" adresine gidilmeli ve erişilebilir olduğu doğrulanmalıdır.");

        //Method kullanırak Meal center sitesine kullanıcı girişi yapılır.
        //Browser açılır.
        //Url kısmına "https://qa.mealscenter.com/" yazılır ve tıklanır.
        Driver.getDriver().get(ConfigReader.getProperty("mealCenterHomePageUrl"));

        //Cookie'yi kabul eder.
        userHomePage.acceptCookie.click();

        Driver.getDriver().get("https://qa.mealscenter.com/account/login");

        //Açılan sayfada ;
        //Email kutusuna  "team4@hotmail.com" mailini gönderir.
        userHomePage.signInUsernameBox.sendKeys("userdemo@mail.com");


        //Password kutusuna geçer.
        //Password kutusuna "team4***" gönderir.
        userHomePage.signInPasswordBox.sendKeys("user1234.");


        //"Sign in" butonuna tıklanır.
        userHomePage.signIn.click();
        ReusableMethods.wait(2);
        extentTest.info("Method kullanırak Meal center sitesine kullanıcı girişi yapıldı");

        //"https://qa.mealscenter.com/account/profile" adresine gidilir.
        Driver.getDriver().get("https://qa.mealscenter.com/account/profile");

        //Gidilen sayfanın url'sinin "https://qa.mealscenter.com/account/profile" oldugu doğrulanır.
        String expectedUrl = "https://qa.mealscenter.com/account/profile";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl);

        Driver.getDriver().manage().window().setSize(new Dimension(600,600));

        ReusableMethods.wait(5);

        Driver.getDriver().findElement(By.xpath("//div[@class='owl-stage']//a[text()='Manage Account']")).click();

        ReusableMethods.wait(2);


    }
}
