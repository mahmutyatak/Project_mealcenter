package tests.US_038;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.adminMealscenter.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC04 extends TestBaseRapor {
    @Test
    public void verifyListOrderId() {
        AdminDashboard adminDashboard = new AdminDashboard();
        extentTest = extentReports.createTest("Admin All Orders Order Id siralama testi",
                "Admin All Orders sayfasina erisim sağlanabilmeli ve siparisleri Order Id ye gore siralanabilmeli");
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
        //3- açılan sayfada "Actions" bölümündeki butonların işlevselliği test edilir.
        WebElement ilkSiparisElementi = Driver.getDriver().findElement(By.xpath("(//tr[@class='odd'])[1]"));
        WebElement ilkSiparisCustomer=Driver.getDriver().findElement(By.xpath("(//tr//td[5])[1]"));
        String expectedText=ilkSiparisCustomer.getText();
        WebElement actionsButonu = Driver.getDriver().findElement(By.xpath("(//i[@class='zmdi zmdi-eye'])[1]"));
        actionsButonu.click();
        WebElement actionsCustomer=Driver.getDriver().findElement(By.xpath("(//p[@class='m-0'])[9]"));
        String actualText=actionsCustomer.getText();
        Assert.assertEquals(actualText,expectedText);
        extentTest.info("ilk siparis musterisi ile actions kismindaki musteri isminin ayni oldugu test edildi");
        WebElement tablo=Driver.getDriver().findElement(By.xpath("//div[@class='card-body']"));
        Assert.assertTrue(!tablo.getText().isEmpty());
        extentTest.pass("siparis dokuman bilgilerinin  oldugu test edildi");
        //3- açılan sayfada bir siparisin dokuman olarak indirilebildigi test edilir.
        //Logout butonuna tiklanarak sistemden cikis yapilir
        adminDashboard.logOutMethod();
        //Sayfa kapatilir
        Driver.quitDriver();
    }
}
