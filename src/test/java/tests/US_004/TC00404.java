package tests.US_004;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.userMealscenter.UserHomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC00404 extends TestBaseRapor{

    @Test
    public void test01(){

        extentTest = extentReports.createTest("Footer bölümünde, blog yazıları bölümünün bulundugu ve doğru şekilde çalıştığı doğrulanmalıdır.");
        UserHomePage userHomePage = new UserHomePage();

        //Browser açılır.
        //"https://qa.mealscenter.com/" adresine gidilir.
        Driver.getDriver().get(ConfigReader.getProperty("mealCenterHomePageUrl"));
        extentTest.info("\"https://qa.mealscenter.com/\" adresine gidildi");

        //Sayfanın en altına inilir.
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.END).perform();
        extentTest.info("Sayfanın en altına inildi");

        //Footer bölümünde yer alan 'Blog' kısmının görünür olduğu test edilir
        Assert.assertTrue(userHomePage.footerBlog.isDisplayed());
        extentTest.pass("Footer bölümünde yer alan 'Blog' kısmının görünür olduğu test edildi");

        //"Discover the Best Vegetarian Food Delivery Options in Your Area" isimli blog bağlantısına tıklanır.
        userHomePage.footerDiscoverTheBest.click();
        extentTest.info("Discover the Best Vegetarian Food Delivery Options in Your Area\" isimli blog bağlantısına tıklandı");

        //Açılan sayfada yer alan metnin "Discover the Best Vegetarian Food Delivery Options in Your Area" başlığına sahip olduğu test edilir.
        String expectedText = "Discover the Best Vegetarian Food Delivery Options in Your Area";
        String actualText = userHomePage.blogTextBaslik.getText();
        Assert.assertEquals(expectedText,actualText);
        extentTest.pass("Açılan sayfada yer alan metnin \"Discover the Best Vegetarian Food Delivery Options in Your Area\" başlığına sahip olduğu test edildi");

        //Bir önceki sayfaya geri dönülür.
        Driver.getDriver().navigate().back();
        extentTest.info("Bir önceki sayfaya geri dönüldü");

        //"How to Eat Healthy with Food Delivery" isimli blog bağlantısına tıklanır.
        userHomePage.footerHowToEat.click();
        extentTest.info("\"How to Eat Healthy with Food Delivery\" isimli blog bağlantısına tıklandı");

        //Açılan sayfada yer alan metnin "How to Eat Healthy with Food Delivery" başlığına sahip olduğu test edilir.
        expectedText = "How to Eat Healthy with Food Delivery";
        actualText = userHomePage.blogTextBaslik.getText();
        Assert.assertEquals(expectedText,actualText);
        extentTest.pass("Açılan sayfada yer alan metnin \"How to Eat Healthy with Food Delivery\" başlığına sahip olduğu test edildi");

        //Bir önceki sayfaya geri dönülür.
        Driver.getDriver().navigate().back();
        extentTest.info("Bir önceki sayfaya geri dönüldü");

        //"The Benefits of Using a Food Delivery Platform for Your Healthy Lifestyle" isimli blog bağlantısına tıklanır.
        userHomePage.footerTheBenefits.click();
        extentTest.info("The Benefits of Using a Food Delivery Platform for Your Healthy Lifestyle\" isimli blog bağlantısına tıklandı");

        //Açılan sayfada yer alan metnin "The Benefits of Using a Food Delivery Platform for Your Healthy Lifestyle" başlığına sahip olduğu test edilir.
        expectedText = "The Benefits of Using a Food Delivery Platform for Your Healthy Lifestyle";
        actualText = userHomePage.blogTextBaslik.getText();
        Assert.assertEquals(expectedText,actualText);
        extentTest.pass("Açılan sayfada yer alan metnin \"The Benefits of Using a Food Delivery Platform for Your Healthy Lifestyle\" başlığına sahip olduğu test edildi");

        //Bir önceki sayfaya geri dönülür.
        Driver.getDriver().navigate().back();
        extentTest.info("Bir önceki sayfaya geri dönüldü");

        //"Discover Healthy Food Delivery Options for Your Whole Family" isimli blog bağlantısına tıklanır.
        //Açılan sayfada yer alan metnin "Discover Healthy Food Delivery Options for Your Whole Family" başlığına sahip olduğu test edilir.
        //Sayfa kapatılır.

    }

}
