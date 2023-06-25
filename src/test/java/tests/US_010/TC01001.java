package tests.US_010;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.userMealscenter.UserHomePage;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC01001 extends TestBaseRapor {

    UserHomePage userHomePage = new UserHomePage();

    @Test
    public void test01(){

        extentTest = extentReports.createTest("\"https://qa.mealscenter.com/merchant/signup\" adresine gidilmeli ve bu adresin erişilebilir olduğu doğrulanmalıdır");

        //Browser açılır.
        //"https://qa.mealscenter.com/merchant/signup" adresine gidilir.
        Driver.getDriver().get("https://qa.mealscenter.com/merchant/signup");
        extentTest.info("\"https://qa.mealscenter.com/merchant/signup\" adresine gidildi");

        //Gidilen sayfanın url'sinin "https://qa.mealscenter.com/merchant/signup" olduğu test edilir.
        String expectedUrl = "https://qa.mealscenter.com/merchant/signup";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl);
        extentTest.pass("Gidilen sayfanın url'sinin \"https://qa.mealscenter.com/merchant/signup\" olduğu test edildi");

    }

    @Test
    public void test02(){
        extentTest = extentReports.createTest("Restoran başvuru sayfası, restoran sahiplerinin web sitesinde yer alabilmek için başvuru yapabildiği bir araç içermeli ve bu aracın fonksiyonlarının görünür olduğu doğrulanmalıdır");

        //Sayfanın restoran sahipleri için bir başvuru aracı içerdiği doğrulanmalıdır
        Assert.assertTrue(userHomePage.becomeRestaurantForm.isDisplayed());
        extentTest.pass("Sayfanın restoran sahipleri için bir başvuru aracı içerdiği doğrulandı");

        //"Store name" kutusunun görünür olduğu test edilir.
        Assert.assertTrue(userHomePage.becomeAPartnerStoreNameBox.isDisplayed());
        extentTest.pass("\"Store name\" kutusunun görünür olduğu test edildi");

        //"Store adress" kutusunun görünür olduğu test edilir.
        Assert.assertTrue(userHomePage.becomeApartnerStoreAddressBox.isDisplayed());
        extentTest.pass("\"Store adress\" kutusunun görünür olduğu test edildi");

        //"Email adress" kutusunun görünür olduğu test edilir.
        Assert.assertTrue(userHomePage.becomeAPartnerEmailAddressBox.isDisplayed());
        extentTest.pass("\"Email adress\" kutusunun görünür olduğu test edildi");



    }
}
