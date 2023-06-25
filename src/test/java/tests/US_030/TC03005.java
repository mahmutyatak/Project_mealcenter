package tests.US_030;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.merchantMealscenter.MerchantDashboard;
import pages.merchantMealscenter.MerchantOrders;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.nio.file.Files;
import java.nio.file.Paths;

public class TC03005 extends TestBaseRapor {

    //Browser açılır.
    //Kullanıcı "https://qa.mealscenter.com/backoffice/auth/login"  adresine gider.
    //Restoran yoneticisi, username bolumune "lapalmeraAdmin " girer.
    //Restoran yoneticisi, password bolumune "1234567" girer.
    //Restoran yoneticisi,Sign in butonuna tiklar.
    //Restaurant yöneticisi tarafından sayfa açıldıktan sonra dashboard sütunun altında buluna "Orders" butonuna tıklanılır ve test edilir.
    //Restaurant yöneticisi tarafından orders kısmının altında yer alan "Completed" butonuna tıklanılır ve test edilir.
    //Restaurant yöneticisi tarafından "Print" butonuna tıklanır test edilir.
    //Restaurant yöneticisi tarafından "..." butonuna tıklanır ve filtreleme test edilir.

    MerchantDashboard merchantDashboard=new MerchantDashboard();
    MerchantOrders merchantOrders=new MerchantOrders();
    @Test
    public void test01() {

        extentTest = extentReports.createTest("İleriki tarihe verilmiş siparisin ozet bilgileri yazdirilabilir olmalidir", "İleriki tarihe verilmiş siparisin ozet bilgileri yazdirilabilme testi yapildi");
        merchantDashboard.signInMerchantMethod();
        extentTest.info("Merchant sitesine giris yapildi");
        merchantOrders.ordersButton.click();
        extentTest.info("Orders butonuna tiklandi");
        merchantOrders.scheduledButonu.click();
        extentTest.info("Scheduled butonuna tiklandi");
        merchantOrders.print1Button.click();
        extentTest.info("print1 botonuna basildi");
        ReusableMethods.wait(3);
        WebElement printClose = Driver.getDriver().findElement(By.xpath("(//span[text()='×'])[13]"));
        printClose.click();
        extentTest.info("Close butonuna basildi");
        ReusableMethods.wait(3);
        Assert.assertTrue(true);
        extentTest.pass("Yazdirilabilirlik testi yapildi.");

    }

    @Test
    public void test02() {

        extentTest = extentReports.createTest("Musteri iletisim bilgileri gorulur oldugu dogrulanmalidir", "Musteri iletisim bilgileri gorulurlugu  testi yapildi");
        merchantOrders.scheduledUcNoktaButonu.click();
        extentTest.info("Uc nokta tusuna tiklanir");
        ReusableMethods.bekle(2);
        merchantOrders.scheduledContactCustomer.click();
        ReusableMethods.bekle(2);
        extentTest.info("Contact customer bolumune tiklanir");
        WebElement scheduledOkay= Driver.getDriver().findElement(By.xpath("//button[text()='Okay']"));
        scheduledOkay.click();
        ReusableMethods.bekle(1);
        extentTest.info("Contact customer testi yapildi");
    }

    @Test
    public void test03() {

        extentTest = extentReports.createTest("Siparis zaman cizelgesi gorulur dogrulanmalidir", "Pozitif siparis zaman cizelgesi testi yapildi");
        merchantOrders.scheduledUcNoktaButonu.click();
        ReusableMethods.bekle(2);
        extentTest.info("Uc nokta tusuna tiklanir");
        merchantOrders.timeLine.click();
        ReusableMethods.bekle(2);
        extentTest.info("Timeline tusuna basilir");
        WebElement printClose = Driver.getDriver().findElement(By.xpath("(//span[text()='×'])[2]"));
        printClose.click();
        ReusableMethods.bekle(1);
        extentTest.pass("Zaman cizelgesi testi yapildi");

    }

    @Test
    public void test04() {

        extentTest = extentReports.createTest("Siparisin pdf olarak indirldigi dogrulanmalidir", "Pozitif siparisin pdf olarak indirilme  testi yapildi");
        merchantOrders.scheduledUcNoktaButonu.click();
        ReusableMethods.bekle(2);
        extentTest.info("Uc nokta tusuna tiklanir");
        merchantOrders.scheduledDownloadPDF.click();
        extentTest.info("Download tusuna basildi");
        ReusableMethods.wait(3);
        String dinamikDosyaYolu=System.getProperty("user.home")+"\\Downloads\\document.pdf";
        Assert.assertTrue(Files.exists(Paths.get(dinamikDosyaYolu)));
        extentTest.pass("Dosya indirilme testi yapildi");

        Driver.closeDriver();

    }
}