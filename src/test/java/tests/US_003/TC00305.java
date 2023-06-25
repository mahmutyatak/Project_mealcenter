package tests.US_003;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.userMealscenter.UserHomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC00305 extends TestBaseRapor {

    //Browser açılır.
    //Kullanıcı "https://qa.mealscenter.com/"  adresine gider.
    //Body bölümünde yer alan "New restaurant Seattle" kısmında yer alan "Kosher Restaurant" butonuna tıklanır ve test edilir.
    //Açılan sayfada sol en üstte bulunan Meals Center ikonuna tıklanır ve "https://qa.mealscenter.com/" sayfasına geri gidilir.
    //
    //Body bölümünde yer alan "New restaurant Seattle" kısmında yer alan "Sichuanese Cuisine" butonuna tıklanır ve test edilir.
    //Açılan sayfada sol en üstte bulunan Meals Center ikonuna tıklanır ve "https://qa.mealscenter.com/" sayfasına geri gidilir.
    //
    //Body bölümünde yer alan "New restaurant Seattle" kısmında yer alan "Umi Sake House" butonuna tıklanır ve test edilir.
    //Açılan sayfada sol en üstte bulunan Meals Center ikonuna tıklanır ve "https://qa.mealscenter.com/" sayfasına geri gidilir.
    //
    //Body bölümünde yer alan "New restaurant Seattle" kısmında yer alan "La Palmera" butonuna tıklanır ve test edilir.
    //Açılan sayfada sol en üstte bulunan Meals Center ikonuna tıklanır ve "https://qa.mealscenter.com/" sayfasına geri gidilir.
    //
    //Body bölümünde yer alan "New restaurant Seattle" kısmında yer alan "Vegan Season" butonuna tıklanır ve test edilir.
    //Açılan sayfada sol en üstte bulunan Meals Center ikonuna tıklanır ve "https://qa.mealscenter.com/" sayfasına geri gidilir.
    //
    //Body bölümünde yer alan "New restaurant Seattle" kısmında sağ üstünde yer alan sağ ve sol butonlarına tıklanır.
    //Alt kısımdaki kayan restaurantlardan "Humble Pie" butonuna tıklanır ve test edilir.
    //Açılan sayfada sol en üstte bulunan Meals Center ikonuna tıklanır ve "https://qa.mealscenter.com/" sayfasına geri gidilir.
    //
    //Body bölümünde yer alan "New restaurant Seattle" kısmında sağ üstünde yer alan sağ ve sol butonlarına tıklanır.
    //Alt kısımdaki kayan restaurantlardan "7-Eleven" butonuna tıklanır ve test edilir.
    //Açılan sayfada sol en üstte bulunan Meals Center ikonuna tıklanır ve "https://qa.mealscenter.com/" sayfasına geri gidilir.
    //
    //Body bölümünde yer alan "New restaurant Seattle" kısmında sağ üstünde yer alan sağ ve sol butonlarına tıklanır.
    //Alt kısımdaki kayan restaurantlardan "Burger King" butonuna tıklanır ve test edilir.
    //Açılan sayfada sol en üstte bulunan Meals Center ikonuna tıklanır ve "https://qa.mealscenter.com/" sayfasına geri gidilir.
    //
    //Body bölümünde yer alan "New restaurant Seattle" kısmında sağ üstünde yer alan sağ ve sol butonlarına tıklanır.
    //Alt kısımdaki kayan restaurantlardan "ASPAVA" butonuna tıklanır ve test edilir.
    //Açılan sayfada sol en üstte bulunan Meals Center ikonuna tıklanır ve "https://qa.mealscenter.com/" sayfasına geri gidilir.
    //
    //Body bölümünde yer alan "New restaurant Seattle" kısmında sağ üstünde yer alan sağ ve sol butonlarına tıklanır.
    //Alt kısımdaki kayan restaurantlardan "KavurmacıNeco" butonuna tıklanır ve test edilir.
    //Açılan sayfada sol en üstte bulunan Meals Center ikonuna tıklanır ve "https://qa.mealscenter.com/" sayfasına geri gidilir.
    //
    //Body bölümünde yer alan "New restaurant Seattle" kısmında sağ üstünde yer alan sağ ve sol butonlarına tıklanır.
    //Alt kısımdaki kayan restaurantlardan "ceylan" butonuna tıklanır ve test edilir.
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



}
