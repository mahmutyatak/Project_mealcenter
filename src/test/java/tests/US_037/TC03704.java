package tests.US_037;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.adminMealscenter.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC03704 extends TestBaseRapor {
    @Test
    public void test01() {
        extentTest = extentReports.createTest("Admin Merchant lits görünürlülük testi", "list'deki bilgiler görünür olmalı");
        Driver.getDriver().get(ConfigReader.getProperty("mealCenterAdminPageUrl"));
        AdminDashboard adminDashboard = new AdminDashboard();
        Actions actions = new Actions(Driver.getDriver());
        adminDashboard.signInMethodu();
        extentTest.info("sign in methodu ile sisteme giriş yapıldı.");
        adminDashboard.merchantLink.click();
        extentTest.info("'Merchant' linki tıklandı");
        adminDashboard.merchantListLink.click();
        extentTest.info("list butonu tıklandı");
        actions.click(adminDashboard.search_elementi)
                .sendKeys("La Palmera" + Keys.ENTER).perform();
        extentTest.info("arama butonuna tıklandı ve 'La Palmera' yazılıp enter tuşuna basıldı");
        actions.click(adminDashboard.edit_butonu).perform();
        extentTest.info("Edit butonuna tıklandı");
        adminDashboard.merchantAdmin_addres.click();
        Driver.getDriver().findElement(By.xpath("(//input[@type='text'])[2]")).clear();
        extentTest.info("Alan temizlendi");
        ReusableMethods.waitAndSendText(adminDashboard.geolocation,"-955555555588855");
        extentTest.info("alana eksi değer girildi");
        actions.sendKeys(Keys.TAB).perform();
        ReusableMethods.waitAndSendText(adminDashboard.geolocation2,"-955555555588855");
        extentTest.info("alana eksi değer girildi");
        Driver.getDriver().findElement(By.xpath("(//input[@type='text'])[4]")).clear();
        extentTest.info("alan temizlendi");
        ReusableMethods.waitAndSendText(adminDashboard.geolocation3,"-955555555588855");
        extentTest.info("alana eksi değer girildi");
        actions.click(adminDashboard.saveButton).perform();
        extentTest.info("Save butonuna basıldı.");
        String expectedYazi="Succesful";
        WebElement element=Driver.getDriver().findElement(By.xpath("//div[@class='alert alert-success']"));
        String actualElement=element.getText();
        Assert.assertFalse(actualElement.equals(expectedYazi));
        extentTest.pass("expectedYazi ile actualElement eşleşmemeliydi çünkü coğrafi lokasyon değerleri eksi değer alamaz");


    }
}
