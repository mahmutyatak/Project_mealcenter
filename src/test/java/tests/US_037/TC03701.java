package tests.US_037;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.adminMealscenter.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC03701 extends TestBaseRapor {

        /*
                    Steps

            2- "Administrator Login" yazısının altında bulunan "Username" butonuna tıklanır ve "usarname" girilir.
                3- "Username"" butonunun altındaki ""Password"" butonuna tıklanır ve
    password bilgileri girilip ""Sign in"" butonuna tıklanır.
            4- "Sign in" butonuna tıklandığında açılan sayfada  "Merchant" butonuna tıklanır.
            5- Admin "Merchant" butonuna tıkladığında aynı butonun altında açılan "List" butonuna tıklar.
            6- Açılan sayfada bilgilerin görünürlüğü test edilir.
            7- Sayfa kapatılır.
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
            extentTest.info("Merchant linki tıklandı");
            adminDashboard.merchantListLink.click();
            extentTest.info("list butonu tıklandı");
            Assert.assertTrue(adminDashboard.merchantListLink.isDisplayed());
            extentTest.pass("merchant list'in görünürlüğü doğrulandı");
            adminDashboard.logOutMethod();
            extentTest.info("logout methodu ile sistemden çıkıldı.");
            Driver.closeDriver();

        }
    }


