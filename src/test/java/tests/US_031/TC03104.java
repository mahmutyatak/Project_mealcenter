package tests.US_031;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.merchantMealscenter.MerchantDashboard;
import pages.merchantMealscenter.MerchantOrders;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC03104 extends TestBaseRapor {

    //Browser açılır.
    //Kullanıcı "https://qa.mealscenter.com/backoffice/auth/login"  adresine gider.
    //Restoran yoneticisi, username bolumune "lapalmeraAdmin " girer.
    //Restoran yoneticisi, password bolumune "1234567" girer.
    //Restoran yoneticisi,Sign in butonuna tiklar.
    //Restaurant yöneticisi tarafından sayfa açıldıktan sonra dashboard sütunun altında buluna "Orders" butonuna tıklanılır ve test edilir.
    //Restaurant yöneticisi tarafından orders kısmının altında yer alan "All Orders" butonuna tıklanılır.
    //Restaurant yöneticisi tarafından "All Orders" butonuna tıklanıldıktan sonra sayfada tamamlanmış siparişlerin tamamı listenilir.
    //Restaurant yöneticisi tarafından arama butonuna "start date -- end date"  bilgileri gonderilir ve filtreleme test edilir.
    //Restaurant yöneticisi tarafından "Filters" butonuna tıklanılır ve filtreleme test edilir.



    @Test(groups = "demo")
    public void test01(){

        MerchantDashboard merchantDashboard=new MerchantDashboard();
        MerchantOrders merchantOrders=new MerchantOrders();

        extentTest=extentReports.createTest("All Orders menüsüne erişim testi","Restaurant yöneticisi all Orders menüsüne erişim sağlayabilmeli");
        merchantDashboard.signInMerchantMethod();
        extentTest.info("Merchant giriş sayfasına erişildi");

        merchantOrders.ordersButonu.click();
        ReusableMethods.bekle(1);
        extentTest.info("Orders menüsüne tıklandı");

        merchantOrders.allOrdersButonu.click();
        ReusableMethods.bekle(2);
        extentTest.info("All orders menüsüne tıklandı");

    }

    @Test(groups = "demo")
    public void test02(){

        MerchantOrders merchantOrders=new MerchantOrders();

        merchantOrders.allOrdersSearchBox.click();
        extentTest.info("Arama kutusuna tiklanildi");
        ReusableMethods.wait(1);
        WebElement searchBoxToday = Driver.getDriver().findElement(By.xpath("//li[text()='Today']"));
        searchBoxToday.click();
        extentTest.info("Filtreleme ile zaman secimi testi yapildi");

    }


    @Test(groups = "demo")
    public void test03() {

        MerchantOrders merchantOrders=new MerchantOrders();

        extentTest = extentReports.createTest("All orders siparisler tamamı turune filtrelenebilir oldugu dogrulanmalidir", "İleriki tarihe verilmiş siparisin turune gore filtrelenebilme  testi yapildi");
        merchantOrders.allOrdersFiltersButonu.click();
        extentTest.info("Filters butonuna tiklandi");

        ReusableMethods.wait(2);
        WebElement byCustomer = Driver.getDriver().findElement(By.xpath("(//div[@class='form-label-group mb-4'])[1]"));
        Actions actions= new Actions(Driver.getDriver());
        byCustomer.click();
        ReusableMethods.wait(2);
        extentTest.info("By customer butonuna tiklandi");

        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
        ReusableMethods.wait(1);
        extentTest.info("Customer  secildi");



        ReusableMethods.wait(2);
        WebElement byStatus = Driver.getDriver().findElement(By.xpath("(//div[@class='form-label-group mb-4'])[2]"));
        Actions actions1= new Actions(Driver.getDriver());
        byStatus.click();
        ReusableMethods.wait(2);
        extentTest.info("By status butonuna tiklandi");
        actions1.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
        ReusableMethods.wait(1);
        extentTest.info("New  secildi");


        extentTest.info("By order type butonuna tiklandi");
        ReusableMethods.wait(2);
        WebElement byOrderType = Driver.getDriver().findElement(By.xpath("(//div[@class='form-label-group mb-4'])[3]"));
        Actions actions2= new Actions(Driver.getDriver());
        byOrderType.click();
        ReusableMethods.wait(2);
        extentTest.info("By order type butonuna tiklandi");
        actions2.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
        ReusableMethods.wait(1);
        extentTest.info("Delivery  secildi");
        ReusableMethods.wait(1);

        WebElement applyFilters = Driver.getDriver().findElement(By.xpath("//button[text()='Apply Filters']"));
        applyFilters.click();
        ReusableMethods.wait(1);
        extentTest.info("Filtreleme sonucunda siparis turu ile musteri  bilgileri gorulme testi yapildi");
        ReusableMethods.wait(2);

    }

    @Test(groups = "demo")
    public void test04(){

        extentTest = extentReports.createTest("Tüm siparislerin odeme bilgileri gorulur olmalidir", "Tüm siparislerin odeme bilgileri gorulme testi yapildi");
        Actions actions= new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        extentTest.info("Sayfa en asagiya kaydirilir");
        ReusableMethods.wait(2);

       //Driver.closeDriver();

    }

}
