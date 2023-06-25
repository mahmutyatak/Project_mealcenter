package tests.US_037;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.adminMealscenter.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC03706 extends TestBaseRapor {

    @Test
    public void test01() {
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
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        ReusableMethods.bekle(1);
        Driver.getDriver().findElement(By.xpath("//input[@value='1122555392']")).clear();
        ReusableMethods.waitAndSendText(adminDashboard.deliveryDistanceCovered,"-111111111111111");
        ReusableMethods.scrollToElement(adminDashboard.deliveryDistanceCovered);
       Assert.assertTrue(false,"mesafe negatir değer alamaz ama alıyor.");
       extentTest.pass("mesafenin pozitif olma değeri test edildi.");
        adminDashboard.logOutMethod();
        extentTest.info("logout methodu ile sistemden çıkıldı.");
        Driver.closeDriver();

    }
}
