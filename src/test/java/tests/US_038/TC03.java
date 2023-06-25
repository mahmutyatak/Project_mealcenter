package tests.US_038;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.adminMealscenter.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.util.List;

public class TC03 extends TestBaseRapor {

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
        //3- "Order ID" butonuna tıklanır ve işlevselliği test edilir.
        WebElement orderIdElementi=Driver.getDriver().findElement(By.xpath("//th[@class='sorting sorting_desc']"));
        List<WebElement> siraliOrderList=Driver.getDriver().findElements(By.xpath("//td[@class='sorting_1']"));
        for (WebElement each: siraliOrderList
        ) {
            System.out.println(each.getText());
        }
        orderIdElementi.click();
        ReusableMethods.bekle(2);
        List<WebElement> orderListesiSirali = Driver.getDriver().findElements(By.xpath("//td[@class='sorting_1']"));
        for (WebElement each1: orderListesiSirali
        ) {
            System.out.println(each1.getText());
        }
        Assert.assertNotEquals(siraliOrderList,orderListesiSirali);
        extentTest.pass("Kuponlar Order ID sirasina gore listelendi");
        //Logout butonuna tiklanarak sistemden cikis yapilir
        adminDashboard.logOutMethod();
        //Sayfa kapatilir
        Driver.quitDriver();
    }
}
