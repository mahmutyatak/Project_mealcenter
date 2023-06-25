package tests.US_038;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.adminMealscenter.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC02 extends TestBaseRapor{
    @Test
        public void verifyFiltersAllOrders() {
            AdminDashboard adminDashboard = new AdminDashboard();
            extentTest = extentReports.createTest("Admin sayfasinda All Orders sekmesinde siparisleri filtreleme secenegine  erişim testi",
                    "Admin All Orders sayfasina erisim sağlanabilmeli ve secilen tarihlere gore filtreleme islemi yapilabilmeli");
            //Browser açılır.
            //Url kısmına "https://qa.mealscenter.com/backoffice/login" yazılır ve tıklanır.
            Driver.getDriver().get(ConfigReader.getProperty("mealCenterAdminPageUrl"));
            extentTest.info("Mealscenter Admin anasayfasına gidildi");
            // Sayfa başlığı doğrulanır.
            String expextedTitle = "Administrator Login";
            String actuallTitle = Driver.getDriver().getTitle();
            Assert.assertEquals(actuallTitle, expextedTitle);
            extentTest.info("Basarili sekilde sayfaya erişildiği test edildi");
            //Sign in butonuna basilarak basarili admin girisi yapildigi dogrulanir
            adminDashboard.signInMethodu();
            extentTest.info("Basarili sekilde admin girisi yapildigi test edildi");
            //2-login olunduğunda sırasıyla "Orders" butonuna ve altında açılan "All order" butonuna tıklanır.
            adminDashboard.ordersLink.click();
            adminDashboard.ordersAllOrdersLink.click();
            //3- "Start date--End date" butonuna tıklanır ve işlevselliği test edilir.
            //2023-03-03 to 2023-04-03
            WebElement dateFiltreleme = Driver.getDriver().findElement(By.xpath("//input[@class='form-control py-2 border-right-0 border']"));
            ReusableMethods.bekle(2);
            dateFiltreleme.sendKeys("2023-03-03 to 2023-04-03", Keys.ENTER);
            ReusableMethods.bekle(3);
            WebElement filtelenmisSecim = Driver.getDriver().findElement(By.xpath("//td[@class='dataTables_empty']"));
            String expectedResult = "No data available in table";
            String actualResult = filtelenmisSecim.getText();
            Assert.assertEquals(actualResult, expectedResult);
            extentTest.pass("Basarili sekilde filtreleme  yapildigi ve sonuclarin listelendigi test edildi");
            //Logout butonuna tiklanarak sistemden cikis yapilir
            adminDashboard.logOutMethod();
            //Sayfa kapatilir
            Driver.quitDriver();

        }
    }


