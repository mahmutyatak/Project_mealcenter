package tests.US_003;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.userMealscenter.UserHomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC00302 extends TestBaseRapor {

    //Browser açılır.
    //Kullanıcı "https://qa.mealscenter.com/"  adresine gider.
    //Body bölümünün en başında bulunan yerel mutfaklar kısmındaki "American" butonuna tıklanır ve test edilir.
    //Açılan sayfada sol en üstte bulunan Meals Center ikonuna tıklanır ve "https://qa.mealscenter.com/" sayfasına geri gidilir.
    //
    //Body bölümünün en başında bulunan yerel mutfaklar kısmındaki "Mediterranean" butonuna tıklanır ve test edilir.
    //Açılan sayfada sol en üstte bulunan Meals Center ikonuna tıklanır ve "https://qa.mealscenter.com/" sayfasına geri gidilir.
    //
    //Body bölümünün en başında bulunan yerel mutfaklar kısmındaki "Sandwiches" butonuna tıklanır ve test edilir.
    //Açılan sayfada sol en üstte bulunan Meals Center ikonuna tıklanır ve "https://qa.mealscenter.com/" sayfasına geri gidilir.
    //
    //Body bölümünün en başında bulunan yerel mutfaklar kısmındaki "Italian" butonuna tıklanır ve test edilir.
    //Açılan sayfada sol en üstte bulunan Meals Center ikonuna tıklanır ve "https://qa.mealscenter.com/" sayfasına geri gidilir.
    //
    //Body bölümünün en başında bulunan yerel mutfaklar kısmındaki "Mexican" butonuna tıklanır ve test edilir.
    //Açılan sayfada sol en üstte bulunan Meals Center ikonuna tıklanır ve "https://qa.mealscenter.com/" sayfasına geri gidilir.
    //
    //Body bölümünün en başında bulunan yerel mutfaklar kısmındaki "Burgers" butonuna tıklanır ve test edilir.
    //Açılan sayfada sol en üstte bulunan Meals Center ikonuna tıklanır ve "https://qa.mealscenter.com/" sayfasına geri gidilir.
    //
    //Body bölümünün en başında bulunan yerel mutfaklar kısmındaki "Japanese" butonuna tıklanır ve test edilir.
    //Açılan sayfada sol en üstte bulunan Meals Center ikonuna tıklanır ve "https://qa.mealscenter.com/" sayfasına geri gidilir.
    //
    //Body bölümünün en başında bulunan yerel mutfaklar kısmındaki "Thai" butonuna tıklanır ve test edilir.
    //Açılan sayfada sol en üstte bulunan Meals Center ikonuna tıklanır ve "https://qa.mealscenter.com/" sayfasına geri gidilir.
    //
    //Body bölümünün en başında bulunan yerel mutfaklar kısmındaki "More" butonuna tıklanır aşağıda çıkan "Chinese" butonuna tıklanır ve test edilir.
    //Açılan sayfada sol en üstte bulunan Meals Center ikonuna tıklanır ve "https://qa.mealscenter.com/" sayfasına geri gidilir.
    //
    //Body bölümünün en başında bulunan yerel mutfaklar kısmındaki "More" butonuna tıklanır aşağıda çıkan "Kosher" butonuna tıklanır ve test edilir.
    //Açılan sayfada sol en üstte bulunan Meals Center ikonuna tıklanır ve "https://qa.mealscenter.com/" sayfasına geri gidilir.
    //
    //Body bölümünün en başında bulunan yerel mutfaklar kısmındaki "More" butonuna tıklanır aşağıda çıkan "Halal" butonuna tıklanır ve test edilir.
    //Açılan sayfada sol en üstte bulunan Meals Center ikonuna tıklanır ve "https://qa.mealscenter.com/" sayfasına geri gidilir.
    //
    //Body bölümünün en başında bulunan yerel mutfaklar kısmındaki "More" butonuna tıklanır aşağıda çıkan "Vegetarian" butonuna tıklanır ve test edilir.
    //Açılan sayfada sol en üstte bulunan Meals Center ikonuna tıklanır ve "https://qa.mealscenter.com/" sayfasına geri gidilir.
    UserHomePage userHomePage=new UserHomePage();
    @Test
    public void Test01() {

        extentTest = extentReports.createTest("Meals Center Home Page erisim testi", "Meals Center Home Page sayfasina erisim saglanabilmeli");
        Driver.getDriver().get(ConfigReader.getProperty("mealCenterHomePageUrl"));
        ReusableMethods.bekle(1);
        extentTest.info("Mealscenter Home Page'e  gidildi");

        //Sayfanin Url'inin  "https://qa.mealscenter.com/" oldugu dogrulanir
        String actualUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(ConfigReader.getProperty("mealCenterHomePageUrl")));
        extentTest.pass("Meals Center Home Page Url dogrulandi");
        ReusableMethods.bekle(1);

        userHomePage.acceptCookie.click();
        ReusableMethods.bekle(1);
        extentTest.info("Cookie kabul edildi");

        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(1);

    }

    @Test
    public void Test02() {

        userHomePage.cuisineDinamikMEthod(1).click();
        extentTest.info("Mealscenter American Mutfak elementine gidildi");
        ReusableMethods.bekle(1);

        userHomePage.mealsCenterLogo.click();
        ReusableMethods.bekle(2);

        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(1);

    }

    @Test
    public void Test03() {

        userHomePage.cuisineDinamikMEthod(2).click();
        extentTest.info("Mealscenter Mediterranean Mutfak elementine gidildi");
        ReusableMethods.bekle(1);

        userHomePage.mealsCenterLogo.click();
        ReusableMethods.bekle(2);

        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(1);

    }

    @Test
    public void Test04() {

        userHomePage.cuisineDinamikMEthod(3).click();
        extentTest.info("Mealscenter Sandwiches Mutfak elementine gidildi");
        ReusableMethods.bekle(1);

        userHomePage.mealsCenterLogo.click();
        ReusableMethods.bekle(2);

        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(1);

    }

    @Test
    public void Test05() {

        userHomePage.cuisineDinamikMEthod(4).click();
        extentTest.info("Mealscenter Italian Mutfak elementine gidildi");
        ReusableMethods.bekle(1);

        userHomePage.mealsCenterLogo.click();
        ReusableMethods.bekle(2);

        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(1);

    }

    @Test
    public void Test06() {

        userHomePage.cuisineDinamikMEthod(5).click();
        extentTest.info("Mealscenter Mexican Mutfak elementine gidildi");
        ReusableMethods.bekle(1);

        userHomePage.mealsCenterLogo.click();
        ReusableMethods.bekle(2);

        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(1);

    }

    @Test
    public void Test07() {

        userHomePage.cuisineDinamikMEthod(6).click();
        extentTest.info("Mealscenter Burgers Mutfak elementine gidildi");
        ReusableMethods.bekle(1);

        userHomePage.mealsCenterLogo.click();
        ReusableMethods.bekle(2);

        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(1);

    }

    @Test
    public void Test08() {

        userHomePage.cuisineDinamikMEthod(7).click();
        extentTest.info("Mealscenter Japanese Mutfak elementine gidildi");
        ReusableMethods.bekle(1);

        userHomePage.mealsCenterLogo.click();
        ReusableMethods.bekle(2);

        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(1);

    }

    @Test
    public void Test09() {

        userHomePage.cuisineDinamikMEthod(8).click();
        extentTest.info("Mealscenter Thai Mutfak elementine gidildi");
        ReusableMethods.bekle(2);

        userHomePage.mealsCenterLogo.click();
        ReusableMethods.bekle(3);

        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(1);

    }

    @Test
    public void Test10() {

        userHomePage.cuisineMoreButonu.click();
        extentTest.info("Mealscenter Chinese Mutfak elementine gidildi");
        ReusableMethods.bekle(2);

        userHomePage.chineseMutfaklarElementi.click();
        ReusableMethods.bekle(2);

        userHomePage.mealsCenterLogo.click();
        ReusableMethods.bekle(2);

        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(1);

    }

    @Test
    public void Test11() {

        userHomePage.cuisineMoreButonu.click();
        extentTest.info("Mealscenter Kosher Mutfak elementine gidildi");
        ReusableMethods.bekle(1);

        userHomePage.kosherMutfaklarElementi.click();
        ReusableMethods.bekle(1);

        userHomePage.mealsCenterLogo.click();
        ReusableMethods.bekle(2);

        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(1);

    }

    @Test
    public void Test12() {

        userHomePage.cuisineMoreButonu.click();
        extentTest.info("Mealscenter Halal Mutfak elementine gidildi");
        ReusableMethods.bekle(1);

        userHomePage.halalMutfaklarElementi.click();
        ReusableMethods.bekle(1);

        userHomePage.mealsCenterLogo.click();
        ReusableMethods.bekle(2);

        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(1);

    }

    @Test
    public void Test13() {

        userHomePage.cuisineMoreButonu.click();
        extentTest.info("Mealscenter Vegetarian Mutfak elementine gidildi");
        ReusableMethods.bekle(1);

        userHomePage.vegetarianMutfaklarElementi.click();
        ReusableMethods.bekle(1);

        userHomePage.mealsCenterLogo.click();
        ReusableMethods.bekle(2);

        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(1);

        Driver.closeDriver();

    }

}
