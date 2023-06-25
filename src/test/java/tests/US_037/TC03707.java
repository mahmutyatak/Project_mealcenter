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

public class TC03707 extends TestBaseRapor {
    @Test
    public void test01() {
        extentTest=extentReports.createTest("Admin Merchant lits görünürlülük testi","list'deki bilgiler görünür olmalı");
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
        ReusableMethods.waitAndClick(adminDashboard.zone);
        extentTest.info("zone butonu tıklandı");
       Driver.getDriver().findElement(By.xpath("//textarea[@autocapitalize='none']")).click();
        extentTest.info("zone search butonu tıklandı.");
      actions.sendKeys(Keys.ARROW_DOWN).perform();
        extentTest.info("Açılan pencerede aşağı inildi.");
      actions.click().perform();
       ReusableMethods.waitAndClick(adminDashboard.saveButton);
        extentTest.info("Save butonuna tıklandı");
        String expectedYazi="Succesful";
        WebElement element=Driver.getDriver().findElement(By.xpath("//div[@class='alert alert-success']"));
        String actualElement=element.getText();
        Assert.assertTrue(actualElement.equals(expectedYazi));
        extentTest.pass("Değişiklik yapılıp yapılmadığı test edildi.");
        adminDashboard.logOutMethod();
        extentTest.info("logout methodu ile sistemden çıkıldı.");
        Driver.closeDriver();



    }
}
