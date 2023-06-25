package tests.US_037;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.adminMealscenter.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC03703 extends TestBaseRapor {
    /*
        1- Browser açılır ve "https://qa.mealscenter.com/backoffice/vendor/list" sayfasına gidilir.
        2- Açılan sayfada "Actions" bölümünde bulunan "Edit" butonuna tıklar.
        3- Admin açılan "Merchant information"("https://qa.mealscenter.com/backoffice/vendor/edit/id/7")  sayfasında
            "Restaurant name" butonuna tıklar. "team 4" yazar
        4- Admin, "Restaurant Slug" butonuna tıklar. Butondaki yazıyı siler.
           "team108" yazar.
        5- Admin, "Contact Name" butonuna tıklar. Butondaki yazıyı siler.  "team" yazar.
        6- Admin, "Contact Phone" butonuna tıklar. Butondaki yazıyı siler.  "11111111" yazar.
        7-  Admin, "Contact email" butonuna tıklar. Butondaki yazıyı siler.  "team108@gmil.com" yazar
        8-  Admin,"About" butonunun işlevselliğini kontrol eder.
        9-  Admin,"Short About" butonunun işlevselliğini kontrol eder.
        10-  Admin,"Cuisine" butonunun işlevselliğini kontrol eder.
        11-  Admin,"Services" butonunun işlevselliğini kontrol eder.
        12-  "log out" yapılır ve sayfa kapatılır.

     */
    @Test(groups = "demo")
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
        ReusableMethods.wait(4);
        actions.click(adminDashboard.edit_butonu).perform();
        extentTest.info("Edit butonuna tıklandı");
        Driver.getDriver().findElement(By.xpath("(//input[@type='text'])[1]")).clear();
        extentTest.info("icerik silindi");
        actions.click(adminDashboard.restaurantName).sendKeys("team108@gmil.com"+Keys.TAB+"team 4").perform();
        extentTest.info("yeni icerik eklendi");
        actions.sendKeys(Keys.TAB+"team108").perform();
        actions.sendKeys(Keys.TAB+"111111111"+Keys.TAB).perform();
        actions.sendKeys("team108@wisequarter.com").perform();
        actions.click(adminDashboard.aboutButonu).build().perform();
        extentTest.info("gereklibilgiler girildi ve about butonuna tıklandi");
        ReusableMethods.bekle(1);
        Driver.getDriver().findElement(By.xpath("//div[@role='textbox']")).clear();
        extentTest.info("icerik silindi");
        ReusableMethods.bekle(1);
        adminDashboard.aboutButonu.sendKeys("Hırsız, çaldığı elbiseyi satmak için gittiği pazarda, " +
                "bir başkasına çaldırmış. Akşam eve döndüğünde hanımı sormuş:\n" +
                "— “Elbiseyi kaça sattın? "+
                "Hırsız gülümseyerek:\n" +
                "— “Maliyetine.”demiş.\nNasreddin Hoca’dan hoşlanmayan komşularından birisi günün birinde onu yolu üzerinde durdurur ve bilmiş, bilmiş konuşmaya başlar:\n" +
                " -“Hoca Efendi, senin için ‘Evliya oldu, erdi’ diyorlar. Doğrusu inanmadım, eğer kerametin varsa benim dört ayaklı eşeğimi iki ayaklı yap da inanayım.” der.\n" +
                " Adamın sözlerine sinirlenen Nasreddin Hoca;\n" +
                " -“Be adam, ben eşeğin ayaklarını dörtten ikiye indirebilir miyim, bilmem. Fakat sen biraz daha konuşursan senin ayaklarını dörde çıkarabilirim.” deyiverir.\n" +
                "\n"+Keys.TAB);
        extentTest.info("yeni icerik eklendi");
        ReusableMethods.bekle(1);
        Driver.getDriver().findElement(By.xpath("//textarea[@name='AR_merchant[short_description]']")).clear();
        extentTest.info("icerik silindi");
        ReusableMethods.waitAndClick(adminDashboard.shortAbout);

        actions.sendKeys("Bir yaz günü öğle sıcağında Nasreddin Hoca, komşu köye gitmektedir. Bir yandan güneş tepeden yakar, bir yandan da susuzluk içini kavurur. Dili damağına yapışmak üzere iken yolu bir çeşmeye uğrar. Olacak bu ya, adamın birisi de ‘su boşa akmasın’ diye çeşmenin oluğuna ağaç parçası tıkamıştır. Hoca, oluğu tıkayan ağaç parçasına var gücüyle asılır, asılır, bir iki denemeden sonra tıpayı çıkarıverir. Çıkarır çıkarmasına da çıkarmasıyla birlikte basınçlı su Hoca’nın üstünü başını ıslatır. Bütün bu olan bitenlere kızan Nasreddin Hoca, suyun karşısına geçerek;\n" +
                "\n" +
                "-“Boşuna tıkamamışlar senin ağzını... Demek ki, hak etmişsin!” der.").build().perform();
        actions.sendKeys(Keys.TAB).perform();
        extentTest.info("yeni icerik eklendi");
        ReusableMethods.bekle(1);
        actions.sendKeys(Keys.ENTER).build().perform();
        extentTest.info("entera basildi");
        actions.sendKeys(Keys.ARROW_DOWN).build().perform();
        extentTest.info("açılan pencerede aşagı inildi ");
        actions.sendKeys(Keys.ENTER).build().perform();
        actions.sendKeys(Keys.TAB).perform();
        adminDashboard.merchantInformationServicesPickUp.click();
        extentTest.info("açılan pencerede yukarı çıkıldı ");
        actions.sendKeys(Keys.ENTER).perform();
        ReusableMethods.waitAndClick(adminDashboard.saveInformation);
        String expected_icerik="Succesfully updated";
        WebElement element=Driver.getDriver().findElement(By.xpath("//div[@class='alert alert-success']"));
        String kayitElementi=element.getText();
        Assert.assertTrue(kayitElementi.contains(expected_icerik));
        extentTest.pass("sayfada gerekli değişikliklerin yapıldığı test edildi");
        adminDashboard.logOutMethod();
        extentTest.info("logout methodu ile sistemden çıkıldı.");
        //Driver.closeDriver();
    }
}
