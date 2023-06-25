package tests.US_037;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.adminMealscenter.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC03702 extends TestBaseRapor {
            /*
            1- Browser açılır ve "https://qa.mealscenter.com/backoffice/vendor/list" sayfasına gidilir.
            2- "All Merchant" sayfasındaki search box'a tıklanarak "LaPalmera" yazılır ve enter'a basılır.
            3- Arama sonuçlarında çıkan "La Palmera" yazısının sonundaki "Edit" butonuna tıklar ve
                açılan sayfanın görünürlüğünü test eder.
            4- "log out" yapılır ve sayfa kapatılır.
             */
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
                Assert.assertTrue(adminDashboard.tüm_sayfa_lokayti.isDisplayed());
                extentTest.pass("'Edit/Merchant/La palmera' sayfasının görünürlüğü test edildi.");
                adminDashboard.logOutMethod();
                extentTest.info("logout methodu ile sistemden çıkıldı.");
                Driver.closeDriver();
            }
}
