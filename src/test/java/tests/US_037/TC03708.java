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

public class TC03708 extends TestBaseRapor {
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
       ReusableMethods.waitAndClick(adminDashboard.MerchantType);
        extentTest.info("Merchant type sayfasına girildi.");
       Driver.getDriver().findElement(By.xpath("//select[@id='AR_merchant_merchant_type']")).click();
       actions.sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).build().perform();
        extentTest.info("type değistirildi.");
       ReusableMethods.bekle(2);
       actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).build().perform();
       ReusableMethods.bekle(2);
       actions.sendKeys(Keys.ENTER).build().perform();
        actions.sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).build().perform();
        extentTest.info("orders seçeneği değistirildi");
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys("***********").perform();
        extentTest.info("commission seçeneği değistirildi");
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(Keys.ENTER).build().perform();
        actions.sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).build().perform();
        extentTest.info("Invoice terms seçeneği değistirildi.");
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
