package tests.US_039;
import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.adminMealscenter.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;
public class TC03907 extends TestBaseRapor {
    //        *BUG*
    // Merchant Earnings sayfasinda ki arama kutusu aktif degil
    Actions actions;
    AdminDashboard adminDashboard;
    @Test
    public void bugSearchBox() {
        AdminDashboard adminDashboard = new AdminDashboard();
        SoftAssert softAssert=new SoftAssert();
        Actions actions=new Actions(Driver.getDriver());
        extentTest = extentReports.createTest("Admin/Earnings/Merchant Earnings arama kutusuna  erişim testi",
                "Admin tum Merchant Earnings sayfasinda arama  yapilabilmeli");
        //Browser açılır.
        //Url kısmına "https://qa.mealscenter.com/backoffice/login" yazılır ve tıklanır.
        Driver.getDriver().get(ConfigReader.getProperty("mealCenterAdminPageUrl"));
        extentTest.info("Mealscenter Admin anasayfasına gidildi");
        //Sign in butonuna basilarak basarili admin girisi yapildigi dogrulanir
        adminDashboard.signInMethodu();
        extentTest.info("Basarili sekilde admin girisi yapildigi test edildi");
        //Earning sekmesine tiklanir
        adminDashboard.earningsLink1.click();
        extentTest.info("Earnings linkine tiklandi");
        //Merchang Earnings sayfasina tiklanir
        adminDashboard.earingsMerchantEarningsLink1.click();
        extentTest.info(" Merchant Earnings linkine tiklandi");
        //Search box'a tiklanir
        // Bug = Merchant Earnings sayfasinda bulunan search box butonu aktif degil
        softAssert.assertTrue(adminDashboard.merchantSearchButonu.isSelected());
        extentTest.pass(" Merchant Earnings sayfasinda ki Search butonunda bug oldugu dogrulandi");
        adminDashboard.logOutMethod();
        softAssert.assertAll();
    }
    @Test
    public void bugSearchBoxRun(){
        AdminDashboard adminDashboard = new AdminDashboard();
        Actions actions=new Actions(Driver.getDriver());
        extentTest = extentReports.createTest("Admin/Earnings/Merchant Earnings arama kutusuna  erişim testi",
                "Admin tum Merchant Earnings sayfasinda arama  yapilabilmeli");
        //Browser açılır.
        //Url kısmına "https://qa.mealscenter.com/backoffice/login" yazılır ve tıklanır.
        Driver.getDriver().get(ConfigReader.getProperty("mealCenterAdminPageUrl"));
        extentTest.info("Mealscenter Admin anasayfasına gidildi");
        //Sign in butonuna basilarak basarili admin girisi yapildigi dogrulanir
        adminDashboard.signInMethodu();
        extentTest.info("Basarili sekilde admin girisi yapildigi test edildi");
        //Earning sekmesine tiklanir
        adminDashboard.earningsLink1.click();
        extentTest.info("Earnings linkine tiklandi");
        //Merchang Earnings sayfasina tiklanir
        adminDashboard.earingsMerchantEarningsLink1.click();
        extentTest.info(" Merchant Earnings linkine tiklandi");
        WebElement bosAlanaTiklama=Driver.getDriver().findElement(By.xpath("//p[@class='m-0 mr-2 text-muted']"));
        bosAlanaTiklama.click();
        ReusableMethods.bekle(3);
        actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
        ReusableMethods.bekle(3);
        actions.sendKeys("Burger King").perform();
        WebElement aramaSonucUrunText=Driver.getDriver().findElement(By.xpath("//tr/td[2]"));
        String expectedText="Burger King";
        String actualText=aramaSonucUrunText.getText();
        Assert.assertEquals(actualText,expectedText);
        extentTest.pass(" Arama sonuclarinin listelendigi test edildi");
        //Logout butonuna tiklanarak sistemden cikis yapilir
        adminDashboard.logOutMethod();
        extentTest.info("Logout yapilarak sistemden cikis yapildi");
    }
}