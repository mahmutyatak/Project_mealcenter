package tests.US_012;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.userMealscenter.UserHomePage;
import pages.userMealscenter.UserProfilPage;
import pages.userMealscenter.UserStorePage;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC01202 extends TestBaseRapor {

    @Test
    public void test01(){
        UserStorePage userStorePage = new UserStorePage();
        UserProfilPage userProfilPage = new UserProfilPage();
        extentTest = extentReports.createTest("Test");

        //Method kullanırak Meal center sitesine kullanıcı girişi yapılır.
        UserHomePage userHomePage = new UserHomePage();
        userHomePage.signInUserMethod();
        extentTest.info("Method kullanırak Meal center sitesine kullanıcı girişi yapıldı");

        ReusableMethods.wait(2);

        // adres Search Box a Seattle yazılır
        Driver.getDriver().findElement(By.xpath("//*[@id=\"vue-home-search\"]/div[2]/input")).sendKeys("Seattle");

        //Seattle adresine tıklanır
        userProfilPage.seattleAdres.click();

        //"https://qa.mealscenter.com/restaurants" adresine gidilir.
        Driver.getDriver().get("https://qa.mealscenter.com/restaurants");
        System.out.println(Driver.getDriver().getCurrentUrl());
        extentTest.info("\"https://qa.mealscenter.com/restaurants\" adresine gidildi");

        //'Cuisines' bölümünden 'American' seçeneğine tıklanır.
        userStorePage.cuisinesAmericanDropbox.click();
        userStorePage.cuisinesItalianDropbox.click();

        //Listelenen restoranların american retoranları olduğu doğrulanır.
        ReusableMethods.wait(2);
        boolean kontrol= true;
        for (WebElement each:userStorePage.reatorantLocations) {
            ReusableMethods.wait(1);
            if (!(each.getText().contains("American")||each.getText().contains("Italian"))){
                kontrol = false;
            }
        }

        Assert.assertTrue(kontrol);

    }
}
