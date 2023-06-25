package pages.userMealscenter;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class UserHomePage {

    //!!!!!!!!! KOD YAZMADAN ÖNCE KENDİ BRANCH'İNDE OLDUĞUNDAN EMİN OL !!!!!!!!!!!!!!!!!!!!
    //!!!!!!!!! KOD YAZMADAN ÖNCE KENDİ BRANCH'İNDE OLDUĞUNDAN EMİN OL !!!!!!!!!!!!!!!!!!!!
    //!!!!!!!!! KOD YAZMADAN ÖNCE KENDİ BRANCH'İNDE OLDUĞUNDAN EMİN OL !!!!!!!!!!!!!!!!!!!!

    //!!!!!!!! MAİN BRANCH'DE YAPACAĞIMIZ TEK İŞLEM PULL ETMEK !!!!!!!!!!!!!!!
    //!!!!!!!! MAİN BRANCH'DE YAPACAĞIMIZ TEK İŞLEM PULL ETMEK !!!!!!!!!!!!!!!
    //!!!!!!!! MAİN BRANCH'DE YAPACAĞIMIZ TEK İŞLEM PULL ETMEK !!!!!!!!!!!!!!!

    public UserHomePage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

    //!!!!!!!!!!!!!!!! Meals Center Home Page Locate'ler

    // MealsCenter/cookie Decline butonu
    @FindBy(xpath = "//button[@class='el-button el-button--default is-round w-100']")
    public WebElement Declinecookie;


    //MealsCenter/Sol ust Logo butonu
    @FindBy(xpath = "(//img[@class='img-200'])[1]")
    public WebElement mealsCenterLogo;


    //MealsCenter/HomePage/adresAramaButonu
    @FindBy(xpath="(//input[@placeholder='Enter delivery address'])[1]")
    public WebElement adressSearchButonu;

    //MealsCenter/HomePage/cart ve Sepet Butonu
    @FindBy(xpath = "(//a[@class='ssm-toggle-navx'])[1]")
    public WebElement cartButonu;

    //MealsCenter/HomePage/Sign in Butonu
    @FindBy(xpath = "//a[text()='Sign in']")
    public WebElement signInButonu;

    //MealsCenter/HomePage/Hungry? We got you yazi elementi
    @FindBy(xpath= "(//h2[@class='text-center mb-3'])[1]")
    public WebElement HungryTextYazisi;

    //MealsCenter/HomePage/American yerel mutfak elementi
    @FindBy(xpath = "(//a[text()='American'])[1]")
    public WebElement americanMutfaklarElementi;

    //MealsCenter/HomePage/Mediterranean yerel mutfak elementi
    @FindBy(xpath = "(//a[text()='Mediterranean'])[1]")
    public WebElement mediterraneanMutfaklarElementi;


    //MealsCenter/HomePage/Sandwiches yerel mutfak elementi
    @FindBy(xpath = "(//a[text()='Sandwiches'])[1]")
    public WebElement sandwichesMutfaklarElementi;

    //MealsCenter/HomePage/Italian yerel mutfak elementi
    @FindBy(xpath = "(//a[text()='Italian'])[1]")
    public WebElement italianMutfaklarElementi;

    //MealsCenter/HomePage/Mexican yerel mutfak elementi
    @FindBy(xpath = "(//a[text()='Mexican'])[1]")
    public WebElement mexicanMutfaklarElementi;

    //MealsCenter/HomePage/Burgers yerel mutfak elementi
    @FindBy(xpath = "(//a[text()='Burgers'])[1]")
    public WebElement burgersMutfaklarElementi;

    //MealsCenter/HomePage/Japanese yerel mutfak elementi
    @FindBy(xpath = "(//a[text()='Japanese'])[1]")
    public WebElement japaneseMutfaklarElementi;

    //MealsCenter/HomePage/Thai yerel mutfak elementi
    @FindBy(xpath = "(//a[text()='Thai'])[1]")
    public WebElement thaiMutfaklarElementi;


    //MealsCenter/HomePage/Tum yerel mutfaklarin elementi index ile secilebilir
    @FindBy(xpath = "(//div[@class='col cuisineMainPage'])[1]")
    public WebElement cuisineDinamikLocate;

    //MealsCenter/HomePage/Chinese yerel mutfak elementi
    @FindBy(xpath = "(//a[text()='Chinese'])[1]")
    public WebElement chineseMutfaklarElementi;

    //MealsCenter/HomePage/Kosher yerel mutfak elementi
    @FindBy(xpath = "(//a[text()='Kosher'])[1]")
    public WebElement kosherMutfaklarElementi;

    //MealsCenter/HomePage/Halal yerel mutfak elementi
    @FindBy(xpath = "(//a[text()='Halal'])[1]")
    public WebElement halalMutfaklarElementi;


    //MealsCenter/HomePage/vegetarian yerel mutfak elementi
    @FindBy(xpath = "(//a[text()='Vegetarian'])[1]")
    public WebElement vegetarianMutfaklarElementi;


    //MealsCenter/HomePage/cuisine more butonu
    @FindBy(xpath = "//a[@class='btn btn-sm dropdown-toggle text-truncate shadow-none']")
    public
    WebElement cuisineMoreButonu;

    //MealsCenter/HomePage/populer Restaurant Sol ok Butonu
    @FindBy(xpath = "(//a[@class='owl-carousel-nav prev mr-4'])[1]")
    public WebElement solOkButonu;

    //MealsCenter/HomePage/populer Restaurant sag ok Butonu
    @FindBy(xpath = "(//a[@class='owl-carousel-nav next'])[1]")
    public WebElement sagOkButonu;

    //MealsCenter/HomePage/populer nearby text elementi
    @FindBy(xpath = "(//h5[@class='m-0 section-title'])[1]")
    public WebElement populerNearbyYaziElementi;


    //MealsCenter/HomePage/No minimum order butonu
    @FindBy(xpath = "(//div[@class='inner'])[1]")
    public WebElement noMinimumOrderElementi;

    //MealsCenter/HomePage/No minimum order butonu
    @FindBy(xpath = "(//div[@class='inner'])[2]")
    public WebElement trackYourDeliveryElementi;


    //MealsCenter/HomePage/No minimum order butonu
    @FindBy(xpath = "(//div[@class='inner'])[3]")
    public WebElement deliveryOnTimeElementi;

    //MealsCenter/HomePage/blog yazilari ilk elementi
    @FindBy(xpath = "mb-auto benefitsText")
    public WebElement blogElementi;


    //MealsCenter/HomePage/read butonu
    @FindBy(xpath = "(//a[text()='Read'])[1]")
    public WebElement readButton;

    //MealsCenter/HomePage/read butonu
    @FindBy(xpath = "(//a[text()='Read'])[2]")
    public WebElement readButton2;

    //MealsCenter/HomePage/read butonu
    @FindBy(xpath = "(//a[text()='Read'])[3]")
    public WebElement readButton3;

    //MealsCenter/HomePage/read butonu
    @FindBy(xpath = "(//a[text()='Read'])[4]")
    public WebElement readButton4;




    //MealsCenter/HomePage/New restaurant yazisi
    @FindBy(xpath = "(//h5[@class='m-0 section-title'])[2]")
    public WebElement newRestaurantYaziElementi;


    //MealsCenter/HomePage/New restaurant sol ok tusu
    @FindBy(xpath = "(//a[@class='owl-carousel-nav prev mr-4'])[2]")
    public WebElement newRestSolOk;

    //MealsCenter/HomePage/New restaurant sag ok tusu
    @FindBy(xpath = "(//a[@class='owl-carousel-nav next'])[2]")
    public WebElement newRestSagOk;


    //MealsCenter/HomePage/New restaurant altindaki restaurantlar
    @FindBy(xpath = "(//div[@class='mt-3 text-center w-100'])[7]")
    public WebElement newRestList;


    //MealsCenter/HomePage/Join butonu
    @FindBy(xpath = "btn btn-link w25")
    public WebElement joinButonu;

    //MealCenter/Hemepage/Footer bolumu
    @FindBy(xpath = "//div[@class='sub-footer']")
    public WebElement footer;


    //MealsCenter/HomePage/Footer Logo
    @FindBy(xpath = "(//img[@class='img-200'])[2]")
    public WebElement footerLogo;


    //MealsCenter/HomePage/facebook butonu
    @FindBy(xpath = "(//a[@class='facebook'])[1]")
    public WebElement facebookButonu;

    //MealsCenter/HomePage/instagram butonu
    @FindBy(xpath = "(//a[@class='instagram'])[1]")
    public WebElement instagramButonu;

    //MealsCenter/HomePage/linkedin butonu
    @FindBy(xpath = "(//a[@class='linkedin'])[1]")
    public WebElement linkedinButonu;


    //MealsCenter/HomePage/twitter butonu
    @FindBy(xpath = "(//a[@class='twitter'])[1]")
    public WebElement twitterButonu;


    //MealsCenter/HomePage/youtube butonu
    @FindBy(xpath = "(//a[@class='youtube'])[1]")
    public WebElement youtubeButonu;

    //mealCenter/Homepage/Meal Center Corp. bolumu
    @FindBy(xpath = "(//div[@class='col-lg-3 col-md-4 col-sm-6 col-6 mb-2'])[1]")
    public WebElement mealCenterCorpTumBolum;


    //MealsCenter/HomePage/Accept cookie butonu
    @FindBy(xpath = "//button[@class='el-button el-button--primary el-button--default is-round w-100']")
    public WebElement acceptCookie;

    //MealsCenter/HomePage/Contact us elementi
    @FindBy(xpath = "//a[text()='Contact us']")
    public WebElement contactUsElementi;

    //MealsCenter/HomePage/Terms and conditions elementi
    @FindBy(xpath = "//a[text()='Terms and conditions']")
    public WebElement termsandConditionsElementi;


    //MealsCenter/HomePage/Privacy Policy elementi
    @FindBy(xpath = "//a[text()='Privacy policy']")
    public WebElement privacyPolicyElementi;


    //MealsCenter/HomePage/Become a Partner elementi
    @FindBy(xpath = "//a[text()='Become a Partner']")
    public WebElement becomeaPartnerElementi;

    //MealsCenter/HomePage/footer Blog butonu
    @FindBy(xpath = "//h6[text()='Blog']")
    public WebElement blogButonu;

    //MealsCenter/HomePage/footer AppStore butonu
    @FindBy(xpath = "(//div[@class='p-2'])[1]")
    public WebElement appStoreButonu;

    //MealsCenter/HomePage/footer GooglePlay butonu
    @FindBy(xpath = "(//div[@class='p-2'])[2]")
    public WebElement googlePlayButonu;

    //MealsCenter/HomePage/footer mealscenterlink elementi
    @FindBy(xpath = "(//p[@class='m-0'])[44]")
    public WebElement mealscenterLinkElementi;

    //MealsCenter/HomePage/footer Meals Center Corp. 2023 yazi elementi
    @FindBy(xpath = "//p[text()='  © Meals Center Corp. 2023']")
    public WebElement mealsCenterCorpYaziElementi;

    //MealsCenter/HomePage/Body/ With Meals Center quality yazi elementi
    @FindBy(xpath = "//div[@class='w-100 text-center text-md-left']")
    public WebElement withMealsCenterQualityElementi;

    //MealsCenter/HomePage/Body/ telefon resim elementi
    @FindBy(xpath = "(//img[@class='mobileapp'])[1]")
    public WebElement phoneElementi;

    //MealsCenter/HomePage/Body/ mobile app yazi elementi
    @FindBy(xpath = "//div[@class='w-100 text-center text-md-right']")
    public WebElement mobileAppYaziElementi;

    //MealsCenter/HomePage/body New restaurant listesi index 7-24
    @FindBy(xpath = "(//img[@class='rounded-circle'])[7]")
    public WebElement newRestaurantListElementi;

    //MealsCenter/HomePage/body populer nearby Restaurant listesi index 9-31
    @FindBy(xpath = "(//div[@class='w-100 list-items p-0'])[9]")
    public WebElement popularNearbyListElementi;

    //MealsCenter/HomePage/Sign in butonu
    @FindBy(xpath = "//a[text()='Sign in']")
    public WebElement anaSayfaSignInButonu;

    //MealsCenter/HomePage>SignIn/usernameBox
    @FindBy(xpath = "//input[@autocomplete='new-username']")
    public WebElement signInUsernameBox;

    //MealsCenter/HomePage>SignIn/passwordBox
    @FindBy(xpath = "//input[@autocomplete='new-password']")
    public WebElement signInPasswordBox;

    //MealsCenter/HomePage>SignIn/Sign In button
    @FindBy(xpath = "//button[@class='btn btn-green w-100']")
    public WebElement signIn;

    public void kullaniciGirisi(String username,String password){
        anaSayfaSignInButonu.click();
        signInUsernameBox.sendKeys(username);
        signInPasswordBox.sendKeys(password);
        signIn.click();
    }

    //MealsCenter/HomePage > Privacy Policy/başlık yazı elementi
    @FindBy(xpath = "//div/h3")
    public WebElement gizPolSayfaBaslikYazisi;

    //MealsCenter/HomePage > Privacy Policy/kaçıncı başlığı istiyorsak
    public WebElement istenenBaslik(int sayi){
        WebElement istenenBaslik = Driver.getDriver().findElement(By.xpath("(//h2)["+sayi+"]"));
        return istenenBaslik;
    }


    public Boolean mealCenterFooterUrlTest(WebElement element,String expectedUrl){
        Driver.getDriver().get(ConfigReader.getProperty("mealCenterHomePageUrl"));
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.END).build().perform();
        ReusableMethods.wait(1);
        element.click();
        ReusableMethods.switchToWindowHandle(Driver.driver.getWindowHandles());
        return Driver.getDriver().getCurrentUrl().equals(expectedUrl);

    }

    //MealsCenter/HomePage > Contact Us Text
    @FindBy(xpath = "//div[@class='text-center mb-4']")
    public WebElement contactUsText;

    //MealsCenter/HomePage > Contact Us Form
    @FindBy(xpath = "//*[@id='upload-form']")
    public WebElement contactUsForm;

    //MealsCenter/HomePage > Contact Us Phone
    @FindBy(xpath = "//*[text()='Phone']")
    public WebElement contactUsPhonebolumu;

    //MealsCenter/HomePage > Contact Us Phone Text
    @FindBy(xpath = "(//font[@color='#ff0000'])[1]")
    public WebElement contacyUsPhoneText;

    //MealsCenter/HomePage > Contact Us Email Text
    @FindBy(xpath = "(//font[@color='#ff0000'])[2]")
    public WebElement contacyUsEmailText;

    //MealsCenter/HomePage > Contact Us Phone
    @FindBy(xpath = "//*[text()='Email']")
    public WebElement contactUsEmailbolumu;

    //MealsCenter/HomePage > Contact Us/ FullNameBox
    @FindBy(xpath = "//input[@id='AR_contact_fullname']")
    public WebElement contactUsFullNameBox;

    //MealsCenter/HomePage > Contact Us/ EmailBox
    @FindBy(xpath = "//input[@id='AR_contact_email_address']")
    public WebElement contactUsEmailBox;

    //MealsCenter/HomePage > Contact Us/ YourMessageBox
    @FindBy(xpath = "//*[@id='AR_contact_message']")
    public WebElement contactUsYourMessageBox;

    //MealsCenter/HomePage > Contact Us/ SubmitButton
    @FindBy(xpath = "//*[@value='Submit']")
    public WebElement contactUsSubmitButton;

    //MealsCenter/HomePage > Contact Us/ ContactUsPhoto
    @FindBy(xpath = "//*[@class='blogContactPhoto']")
    public WebElement contactUsPhoto;

    //MealsCenter/HomePage > Contact Us/ submitPassText
    @FindBy(xpath = "//div[@class='alert alert-success']")
    public WebElement contactUsSubmitSuccessMessage;

    @FindBy(xpath = "//div[@class='alert alert-danger']")
    public WebElement contactUsFullNameIsRequired;

    //MealsCenter/HomePage/SignIn>Sing up
    @FindBy(xpath = "//a[text()='Sign Up']")
    public WebElement singUpButton;
    //MealsCenter/HomePage/SignIn>Sing up
    @FindBy(xpath = "//div[@class='forms-center']")
    public WebElement signUpForm;
    //MealsCenter/HomePage/SignIn>Sing up
    @FindBy(xpath = "(//input[@class='form-control form-control-text'])[1]")
    public WebElement singUpName;
    //MealsCenter/HomePage/SignIn>Sing up
    @FindBy(xpath = "(//input[@class='form-control form-control-text'])[2]")
    public WebElement singUpSoyisim;
    //MealsCenter/HomePage/SignIn>Sing up
    @FindBy(xpath = "(//input[@class='form-control form-control-text'])[3]")
    public WebElement singUpEmail;
    //MealsCenter/HomePage/SignIn>Sing up
    @FindBy(xpath = "(//input[@class='form-control form-control-text'])[4]")
    public WebElement singUpsifre;
    //MealsCenter/HomePage/SignIn>Sing up
    @FindBy(xpath = "(//input[@class='form-control form-control-text'])[5]")
    public WebElement singUpIkinciSifre;
    //MealsCenter/HomePage/SignIn>Sing up
    @FindBy(xpath = "(//input[@type='text'])[3]")
    public WebElement singUpTelefon;
    //MealsCenter/HomePage/SignIn>Sing up
    @FindBy(xpath = "//button[@class='btn btn-green w-100']")
    public WebElement signUpKayitButton;
    //MealsCenter/HomePage/SignIn>Sing up
    @FindBy(xpath = "//button[@class='dropdown-toggle']")
    public WebElement signUpdropdownTelefon;


    public WebElement populerNearbyRListMethodu( int istenenIndex){
        String dinamkliste="(//img[@class='rounded'])["+istenenIndex+"]";
        WebElement nearbyDinamikList=Driver.getDriver().findElement(By.xpath(dinamkliste));

        return nearbyDinamikList;
    }

    @FindBy(xpath = "//a[@id='dropdownMenuLink']")
    public WebElement profilButton;

    @FindBy(xpath = "//a[@class='dropdown-item with-icon-logout']")
    public WebElement logOutButton;

    public WebElement newRestaurantListMethodu( int istenenIndex){
        String dinamkliste="(//img[@class='rounded-circle'])["+istenenIndex+"]";
        WebElement newRDinamikList=Driver.getDriver().findElement(By.xpath(dinamkliste));

        return newRDinamikList;
    }

    public void signInUserMethod(){
        //Browser açılır.
        //Url kısmına "https://qa.mealscenter.com/" yazılır ve tıklanır.
        Driver.getDriver().get(ConfigReader.getProperty("mealCenterHomePageUrl"));

        //Cookie'yi kabul eder.
        acceptCookie.click();

        Driver.getDriver().get("https://qa.mealscenter.com/account/login");

        //Açılan sayfada ;
        //Email kutusuna  "team4@hotmail.com" mailini gönderir.
        signInUsernameBox.sendKeys(ConfigReader.getProperty("singUpGecerliEmail"));


        //Password kutusuna geçer.
        //Password kutusuna "team4***" gönderir.
        signInPasswordBox.sendKeys(ConfigReader.getProperty("singUpGecerliSfre"));


        //"Sign in" butonuna tıklanır.
        signIn.click();
        ReusableMethods.wait(2);
    }

    public void logOutMethod(){

        Actions actions=new Actions(Driver.getDriver());

        //Kullanıcı profiline tıklanır.
        ReusableMethods.wait(2);

        actions.click(profilButton).build().perform();

        ReusableMethods.wait(2);

        //Açılan dropdown menudeki "Logout" butonuna tıklanır.
        actions.click(logOutButton).build().perform();
    }

    @FindBy(xpath = "(//div[@class='col-lg-3 col-md-4 col-sm-6 col-6 mb-2'])[3]")
    public WebElement footerBlog;

    @FindBy(xpath = "(//*[@class='position-relative '])[5]")
    public WebElement footerDiscoverTheBest;

    @FindBy(xpath = "(//*[@class='position-relative '])[6]")
    public WebElement footerHowToEat;

    @FindBy(xpath = "(//*[@class='position-relative '])[7]")
    public WebElement footerTheBenefits;

    @FindBy(xpath = "//*[@class='text-center mb-4']")
    public WebElement blogTextBaslik;

    //MealsCenter/HomePage/Terms and conditions > Orders and Payment elementi
    @FindBy(xpath = "//font[text()='Orders and Payment']")
    public WebElement OrdersAndPaymentElementi;

    //MealsCenter/HomePage/Terms and conditions > Terms and Conditions elementi
    @FindBy(xpath = "//em[contains(text(),'By placing an order through the Application, you a')]")
    public WebElement byPlacingElementi;

    @FindBy(xpath = "//form[@class='mb-5']")
    public WebElement becomeRestaurantForm;

    @FindBy(xpath = "//*[@id='restaurant_name']")
    public WebElement becomeAPartnerStoreNameBox;

    @FindBy(xpath = "//*[@class='position-relative search-geocomplete']")
    public WebElement becomeApartnerStoreAddressBox;

    @FindBy(xpath = "//*[@id='contact_email']")
    public WebElement becomeAPartnerEmailAddressBox;



    //Meals Center > Save Button'u
    @FindBy (xpath = "//div[@class='container-fluid m-0 p-0']//input[@value='Save']")
    public WebElement saveButton;


    //MealsCenter/HomePage>SignIn/Giriş yapılamadı sayfası
    @FindBy(xpath = "//div[@class='forms-center']//div[@class='alert alert-warning']")
    public WebElement signInErrorText;

    //User > İnceleme(Göz) Butonu
    @FindBy (xpath = "//i[@class='zmdi zmdi-eye']")
    public WebElement incelemeButton;

    //User > Forgot password Butonu
    @FindBy (xpath = "//a[@class='a-12']")
    public WebElement forgotPasswordButton;

    //User > Sign Up Butonu
    @FindBy (xpath = "//div[@class='mt-3 text-center']//a[@class='btn btn-white p-0 font14']")
    public WebElement SignUpButton;



    //Cuisine listesi index 1-8 arasi
    public WebElement cuisineDinamikMEthod(int istenenIndex){
        String dinamkliste="(//div[@class='col cuisineMainPage'])["+istenenIndex+"]";
        WebElement cuisineDinamikList=Driver.getDriver().findElement(By.xpath(dinamkliste));
        return cuisineDinamikList;
    }

    @FindBy(xpath = "//div[@class='form-label-group change_field_password']//i[@class='zmdi zmdi-eye']")
    public WebElement gozIsaretiKayit;

}