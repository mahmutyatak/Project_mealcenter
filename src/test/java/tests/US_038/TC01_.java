package tests.US_038;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.adminMealscenter.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC01_ extends TestBaseRapor {

    @Test
        public void verifyEnabledAllFunctions(){
            AdminDashboard adminDashboard=new AdminDashboard();
            extentTest = extentReports.createTest("Admin All Orders erişim testi",
                    "Admin All Orders sayfasina erisim sağlanabilmeli ve tum basliklarin gorunur oldugu dogrulanabilmeli");
            //Browser açılır.
            //Url kısmına "https://qa.mealscenter.com/backoffice/login" yazılır ve tıklanır.
            Driver.getDriver().get(ConfigReader.getProperty("mealCenterAdminPageUrl"));
            extentTest.info("Mealscenter Admin anasayfasına gidildi");
            // Sayfa başlığı doğrulanır.
            String expextedTitle="Administrator Login";
            String actuallTitle=Driver.getDriver().getTitle();
            Assert.assertEquals(actuallTitle,expextedTitle);
            extentTest.info("Basarili sekilde sayfaya erişildiği test edildi");
            //Sign in butonuna basilarak basarili admin girisi yapildigi dogrulanir
            adminDashboard.signInMethodu();
            extentTest.info("Basarili sekilde admin girisi yapildigi test edildi");
            //2-login olunduğunda sırasıyla "Orders" butonuna ve altında açılan "All order" butonuna tıklanır.
            adminDashboard.ordersLink.click();
            adminDashboard.ordersAllOrdersLink.click();
            Assert.assertTrue(ordersBasliklari(1).isDisplayed());
            Assert.assertTrue(ordersBasliklari(2).isDisplayed());
            Assert.assertTrue(ordersBasliklari(3).isDisplayed());
            Assert.assertTrue(ordersBasliklari(4).isDisplayed());
            extentTest.pass("All Orders'daki tum basliklarin gorunur oldugu dogrulandi");
            //Logout butonuna tiklanarak sistemden cikis yapilir
            adminDashboard.logOutMethod();
            //Sayfa kapatilir
            Driver.quitDriver();
        }
        public WebElement ordersBasliklari(int istenenIndex){
            String ordersdinamikText= "(//p[@class='m-0 mr-2 text-muted text-truncate'])["+istenenIndex+"]";
            WebElement ordersListeName=Driver.getDriver().findElement(By.xpath(ordersdinamikText));
            return  ordersListeName;
        }
    }

