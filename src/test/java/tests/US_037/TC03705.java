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

public class TC03705 extends TestBaseRapor {

    @Test
    public void test01(){
       extentTest=extentReports.createTest("Admin Merchant lits görünürlülük testi","list'deki bilgiler görünür olmalı");
        Driver.getDriver().get(ConfigReader.getProperty("mealCenterAdminPageUrl"));
        AdminDashboard adminDashboard=new AdminDashboard();
        Actions actions=new Actions(Driver.getDriver());
        adminDashboard.signInMethodu();
        extentTest.info("sign in methodu ile sisteme giriş yapıldı.");
        adminDashboard.merchantLink.click();
        extentTest.info("'Merchant' linki tıklandı");
        adminDashboard.merchantListLink.click();
        extentTest.info("list butonu tıklandı");
        actions.click(adminDashboard.search_elementi)
                .sendKeys("La Palmera"+ Keys.ENTER).perform();
        extentTest.info("arama butonuna tıklandı ve 'La Palmera' yazılıp enter tuşuna basıldı");
        actions.click(adminDashboard.edit_butonu).perform();
       extentTest.info("Edit butonuna tıklandı");
        adminDashboard.merchantAdmin_addres.click();
        Driver.getDriver().findElement(By.xpath("(//input[@type='text'])[1]")).clear();
        extentTest.info("adres alanı temizlendi.");
        ReusableMethods.waitAndSendText(adminDashboard.address_details,"OBAMA,TRUMP BUSH SOKAK BRUS TEETH CADDE");
        extentTest.info("yeni adres girildi.");
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(Keys.TAB).perform();
        extentTest.info("bug olan yeerler ayrı bir classda çalıştırılmak üzere şimdilik atlandı");
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(Keys.ARROW_UP).perform();
        extentTest.info("açılan dropddownda yukarı çıkıldı.");
        actions.sendKeys(Keys.ENTER).perform();
        ReusableMethods.waitAndClick(adminDashboard.saveButton);
        extentTest.info("save butonuna basılarak kaydedildi.");
        String expectedYazi="Succesful";
        WebElement element=Driver.getDriver().findElement(By.xpath("//div[@class='alert alert-success']"));
        String actualElement=element.getText();
        Assert.assertTrue(actualElement.equals(expectedYazi));
        extentTest.pass("istenen değişikliklerin yapılıp yapılmadığı test edildii.");
        adminDashboard.logOutMethod();
        extentTest.info("logout methodu ile sistemden çıkıldı.");
        Driver.closeDriver();



    }
}
