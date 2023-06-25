package tests.US_006;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.userMealscenter.UserHomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.util.List;

public class TC00610 extends TestBaseRapor {


    UserHomePage userHomePage = new UserHomePage();

    @Test
    public void test01() {
        userHomePage=new UserHomePage();
        extentTest = extentReports.createTest("Telefon ulke secim testi", "Pozitif sign up formu telefon ulke secim testi yapildi");

        //Kullanıcı "https://qa.mealscenter.com" sayfasına gider.
        Driver.getDriver().get(ConfigReader.getProperty("mealCenterHomePageUrl"));
        extentTest.info("https://qa.mealscenter.com  ana sayfasına gidildi");
        //Kullanıcı sign in butonuna tıklar
        userHomePage.signInButonu.click();
        extentTest.info("sign in butonuna tiklandi");

        //Kullanıcı sign up butonuna tıklar.
        userHomePage.singUpButton.click();
        extentTest.info("sign up butonuna tiklandi");
        ReusableMethods.wait(3);
        //Telefon dropdown menusune tiklanir.
        userHomePage.signUpdropdownTelefon.click();
        extentTest.info("telefon dropdown menusune tiklandi");
        List<WebElement> liste =Driver.getDriver().findElements(By.xpath("//a[@class='dropdown-item d-flex align-items-center']"));
        String actualIcerik="";
        for (WebElement each:liste
             ) {
            if (each.getText().equals("Turkey")){
                each.click();
                actualIcerik=each.getText();
            }
        }
        String expectedIcerik="Turkey";

        Assert.assertEquals(actualIcerik,expectedIcerik);
        extentTest.pass("telefon dropdown menusu testi yapildi");
        Driver.closeDriver();
    }
}
