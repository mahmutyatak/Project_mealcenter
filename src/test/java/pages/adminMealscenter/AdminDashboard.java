package pages.adminMealscenter;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.nio.file.Watchable;

public class AdminDashboard {

    //!!!!!!!!! KOD YAZMADAN ÖNCE KENDİ BRANCH'İNDE OLDUĞUNDAN EMİN OL !!!!!!!!!!!!!!!!!!!!
    //!!!!!!!!! KOD YAZMADAN ÖNCE KENDİ BRANCH'İNDE OLDUĞUNDAN EMİN OL !!!!!!!!!!!!!!!!!!!!
    //!!!!!!!!! KOD YAZMADAN ÖNCE KENDİ BRANCH'İNDE OLDUĞUNDAN EMİN OL !!!!!!!!!!!!!!!!!!!!

    //!!!!!!!! MAİN BRANCH'DE YAPACAĞIMIZ TEK İŞLEM PULL ETMEK !!!!!!!!!!!!!!!
    //!!!!!!!! MAİN BRANCH'DE YAPACAĞIMIZ TEK İŞLEM PULL ETMEK !!!!!!!!!!!!!!!
    //!!!!!!!! MAİN BRANCH'DE YAPACAĞIMIZ TEK İŞLEM PULL ETMEK !!!!!!!!!!!!!!!

    public AdminDashboard(){

        PageFactory.initElements(Driver.getDriver(),this);

    }
    //!!!!!!!!!!!!!!!!!!  ADMİN Administrator Login   !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

    //Admin/Login/Username
    @FindBy(xpath = "//input[@placeholder='Username']")
    public WebElement usernameBox;

    //Admin/Login/Password
    @FindBy(xpath = "//input[@placeholder='Password']")
    public WebElement passwordBox;

    //Admin/Login/RememberMe
    @FindBy(xpath = "//input[@id='LoginForm_rememberMe']")
    public WebElement RememberMeRadioButton;

    //Admin/Login/Forgot Password
    @FindBy(xpath = "//a[@class='dim underline']")
    public WebElement forgotPasswordClick;

    //Admin/Login/Signin
    @FindBy(xpath = "//input[@name='yt0']")
    public WebElement signinButton;


    //Admin/Login/App Store
    @FindBy(xpath = "//div[@class='d-flex justify-content-center']//div[1]//a[1]//img[1]")
    public WebElement AppStoreButton;

    //Admin/Login/Google Play
    @FindBy(xpath = "//div[@class='d-flex justify-content-center']//div[1]//a[1]//img[1]")
    public WebElement googlePlayButton;

    //!!!!!!!!!!!!!!!!!!     ADMİN / ANASYAFA /HEADER BÖLÜMÜ LOCATE !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

    //Admin/Dashboard/Profil ismi
    @FindBy(xpath = "//div[contains(@class,'line-bottom')]//a[@id='dropdownMenuLink']")
    public WebElement profilName;

    //Admin/Dashboard/Profil ismi > Profile
    @FindBy(xpath = "(//a[@id='dropdownMenuLink'])[1]")
    public WebElement profileButton;

    //Admin/Dashboard/Profil ismi > Log Out
    @FindBy(xpath = "(//a[@class='dropdown-item'])[2]")
    public WebElement logOutButton;

    //Admin/Dashboard/Zil Logo
    @FindBy(xpath = "//span[@class='badge rounded-circle badge-danger count']")
    public WebElement zilLogo;

    //Admin/Dashboard/Preview Store Logo
    @FindBy(xpath = "//a[@class='btn btn-sm']")
    public WebElement previewStoreLogo;

    //Admin/Dashboard/Meals Center Resim Logosu
    @FindBy(xpath = "//a[@class='btn btn-sm']")
    public WebElement mealsCenterImageLogo;

    public void getResimText(int resimNo){
        //Admin/Anasayfa'daki üstte yer alan resimlerin içindeki yazıları getirir.

        String  dinamikXPaath="(//div[@class='report-inner'])["+resimNo+"]";
        WebElement istenenResimText=Driver.getDriver().findElement(By.xpath(dinamikXPaath));
    }

    //!!!!!!!!!!!!!!!!!!!!!!!!! ADMİN / ANASAYFA / SOL MENU LİSTESİNDEKİ LİNKLER  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

    //Admin/Soldaki menü bölümü /Dashboard Linki
    @FindBy(xpath = "//a[text()='Dashboard']")
    public WebElement dashboardLink;

    //Admin/Soldaki menü bölümü /Merchant Linki
    @FindBy(xpath = "//a[text()='Merchant']")
    public WebElement merchantLink;

    //Admin/Soldaki menü bölümü /Merchant Linki > List Linki
    @FindBy(xpath = "//a[text()='List']")
    public WebElement merchantListLink;

    //Admin/Soldaki menü bölümü /Orders Linki
    @FindBy(xpath = "//a[text()='Orders']")
    public WebElement ordersLink;

    //Admin/Soldaki menü bölümü /Orders Linki > All Orders Linki
    @FindBy(xpath = "//a[text()='All order']")
    public WebElement ordersAllOrdersLink;

    //Admin/Soldaki menü bölümü /Earnings Linki
    @FindBy(xpath = "//a[text()='Earnings']")
    public WebElement earningsLink;

    //Admin/Soldaki menü bölümü /Orders Linki > Merchant Earnings Linki
    @FindBy(xpath = "//a[text()='Merchant Earnings']")
    public WebElement earingsMerchantEarningsLink;

    //Admin/Soldaki menü bölümü /Orders Linki > Merchant Earnings Create a Transaction Button
    @FindBy(xpath = "//button[@id='dropdownMenuButton']")
    public WebElement earingsMerchantEarningsCreateATransactionButton;

    //Admin/Soldaki menü bölümü /Promo Linki
    @FindBy(xpath = "//a[text()='Promo']")
    public WebElement promoLink;

    //Admin/Soldaki menü bölümü /Promo Linki > Coupon Linki
    @FindBy(xpath = "//a[text()='Coupon']")
    public WebElement promoCouponLink;

    //Admin/Soldaki menü bölümü /Promo Linki > Coupon Linki > Update > Coupon Name kutusu
    @FindBy(xpath = "//input[@id='AR_voucher_voucher_name']")
    public WebElement promoCouponUpdateCouponNameBox;

    //Admin/Soldaki menü bölümü /Promo Linki > Coupon Linki > Update > Coupon Type kutusu
    @FindBy(xpath = "//select[@id='AR_voucher_voucher_type']")
    public WebElement promoCouponUpdateCouponTypeBox;

    //Admin/Soldaki menü bölümü /Promo Linki > Coupon Linki > Update > Amount kutusu
    @FindBy(xpath = "//input[@id='AR_voucher_amount']")
    public WebElement promoCouponUpdateAmountBox;

    //Admin/Soldaki menü bölümü /Promo Linki > Coupon Linki > Update > Min Order kutusu
    @FindBy(xpath = "//input[@id='AR_voucher_min_order']")
    public WebElement promoCouponUpdateMinOrderBox;

    //Admin/Soldaki menü bölümü /Promo Linki > Coupon Linki > Update > Days Available kutusu
    @FindBy(xpath = "(//span[@class='select2-selection select2-selection--multiple'])[1]")
    public WebElement promoCouponUpdateDaysAvaibleBox;

    //Admin/Soldaki menü bölümü /Promo Linki > Coupon Linki > Update > Applicable to merchant kutusu
    @FindBy(xpath = "(//span[@class='select2-selection select2-selection--multiple'])[2]")
    public WebElement promoCouponUpdateApplicableMerchantBox;

    //Admin/Soldaki menü bölümü /Promo Linki > Coupon Linki > Update > Expiration kutusu
    @FindBy(xpath = "//input[@id='AR_voucher_expiration']")
    public WebElement promoCouponUpdateExpirationBox;


    //Admin/Soldaki menü bölümü /Promo Linki > Coupon Linki > Update > Coupon Options kutusu
    @FindBy(xpath = "//select[@id='AR_voucher_used_once']")
    public WebElement promoCouponUpdateCouponOptionsBox;

    //Admin/Soldaki menü bölümü /Promo Linki > Coupon Linki > Update > Status kutusu
    @FindBy(xpath = "//select[@id='AR_voucher_status']")
    public WebElement promoCouponUpdateStatusBox;

    //Admin/Soldaki menü bölümü /Buyers Linki
    @FindBy(xpath = "//a[text()='Buyers']")
    public WebElement buyersLink;

    //Admin/Soldaki menü bölümü /Buyers Linki > Customer Linki
    @FindBy(xpath = "//a[text()='Customers']")
    public WebElement buyersCustomerLink;

    //Admin/Soldaki menü bölümü /Buyers Linki > Review Linki
    @FindBy(xpath = "//a[text()='Reviews']")
    public WebElement buyersReviewLink;

    //Admin/Soldaki menü bölümü /Reports Linki
    @FindBy(xpath = "//a[text()='Reports']")
    public WebElement reportsLink;

    //Admin/Soldaki menü bölümü /Reports Linki > Meerchant Registration Linki
    @FindBy(xpath = "//a[text()='Merchant Registration']")
    public WebElement reportsMerchantRegistrationLink;

    //Admin/Soldaki menü bölümü /Reports Linki > Membership Payment Linki
    @FindBy(xpath = "//a[text()='Membership Payment']")
    public WebElement reportsMembershipPaymentLink;

    //Admin/Soldaki menü bölümü /Reports Linki > Merchant Sales Linki
    @FindBy(xpath = "//a[text()='Merchant Sales']")
    public WebElement reportsMerchantSalesLink;

    //Admin/Soldaki menü bölümü /Reports Linki > Order Earning Linki
    @FindBy(xpath = "//a[text()='Order earnings']")
    public WebElement reportsOrderEarningsLink;

    //Admin/Soldaki menü bölümü /Reports Linki > Refund Report Linki
    @FindBy(xpath = "//a[text()='Refund Report']")
    public WebElement reportsRefundReportLink;

    //Admin/Soldaki menü bölümü /Reports Linki > Driver Earning Linki
    @FindBy(xpath = "//a[text()='Driver Earnings']")
    public WebElement reportsDriverEarningsLink;

    //Admin/Soldaki menü bölümü /Reports Linki > Driver Wallet Linki
    @FindBy(xpath = "//a[text()='Driver wallet']")
    public WebElement reportsDriverWalletLink;

    //Admin/Soldaki menü bölümü /Media Library Linki
    @FindBy(xpath = "//a[text()='Media Library']")
    public WebElement mediaLibraryLink;

    //Admin/Soldaki menü bölümü /Media Library Linki > Media List Linki
    @FindBy(xpath = "//a[@class='nav-link active']")
    public WebElement mediaLibraryMediaListLink;

    //Admin/Soldaki menü bölümü /Media Library Linki > ✔ Button
    @FindBy(xpath = "//a[@class='nav-link active']")
    public WebElement mediaLibraryOKButton;

    //Admin/Soldaki menü bölümü /Media Library Linki > Delete File Button
    @FindBy(xpath = "//span[@class='label']")
    public WebElement mediaLibraryDeleteFileButton;

    //Admin/Soldaki menü bölümü /Media Library Linki > Upload New Button
    @FindBy(xpath = "//a[@class='nav-link']")
    public WebElement mediaLibraryUploadNewButton;

    //Admin/Soldaki menü bölümü /Media Library Linki > Select Files Button
    @FindBy(xpath = "//a[@class='btn btn-green fileinput-button dz-clickable']")
    public WebElement mediaLibraryUploadNewSelectFilesButton;

    //!!!!!!!!!!!!!!!!!!!!!!!!! ADMİN / ANASAYFA / BODY BÖLÜMÜNDEKİ LİNKLER  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

   public void bodyElementLinkClick(int linkNo){

       /* ELEMENT            NO
          All                1
          Processing         2
          Ready              3
          Completed          4
          Popular items      5
          Last 30 days sales 6
          Popular merchants  7
          Popular by review  8
        */

       String dinamikXPath="(//li[@class='nav-item'])["+linkNo+"]";

       Driver.getDriver().findElement(By.xpath(dinamikXPath)).click();
   }

    //Admin/Dashboard/ Checkout All Reviews Butonu
    @FindBy(xpath = "//a[@class='w-100 btn btn-lg btn-info waves-effect waves-light mb-3']")
    public WebElement checkoutAllReviews;


   //!!!!!!!!!!!!!!!!!!!!!!!! TÜM ADMİN SAYFASINDA ORTAK OLAN LOCATELER   !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!


    //Admin > Search Box(Arama Kutusu
    @FindBy(xpath = "//input[@placeholder='Search']")
    public WebElement searchBox;

    //Admin > Search İcon Butonu
    @FindBy (xpath = "//i[@class='zmdi zmdi-search']")
    public WebElement searchIconButton;

    //Admin > Save
    @FindBy (xpath = "//div[@class='container-fluid m-0 p-0']//input[@value='Save']")
    public WebElement saveButton;

    //Admin > Update
    @FindBy (xpath = "(//a[@class='btn btn-light tool_tips'])[1]")
    public WebElement updateButton;

    //Admin > Delete
    @FindBy (xpath = "(//a[@class='btn btn-light datatables_delete tool_tips'])[1]")
    public WebElement deleteButton;

    //Admin > Merchant > Auto Login Button
    @FindBy (xpath = "(//a[@class='btn btn-light tool_tips'])[1]")
    public WebElement autoLoginButton;

    //Admin > Orders > Download Button
    @FindBy (xpath = "(//a[@class='ref_pdf_order normal btn btn-light tool_tips'])[1]")
    public WebElement downloadButton;

    //Admin > Add New Button
    @FindBy (xpath = "//a[@class='btn btn-black btn-circle']")
    public WebElement addNewButton;

    //Admin > İnceleme(Göz) Butonu
    @FindBy (xpath = "(//a[@class='ref_view_transaction normal btn btn-light tool_tips'])[1]")
    public WebElement incelemeButton;

    //Admin > Reports > Start date and end date Kutusu
    @FindBy (xpath = "//input[@placeholder='Start date -- End date']")
    public WebElement dateBox;

    //Admin > Reports > Filitre Butonu
    @FindBy (xpath = "//button[@class='ml-2 btn btn-yellow normal']")
    public WebElement filterButton;

    //Admin > Reports > All Status Kutusu
    @FindBy (xpath = "//button[@class='ml-2 btn btn-yellow normal']")
    public WebElement allStatusBox;

    //Admin > Previous Butonu
    @FindBy (xpath = "//a[text()='Previous']")
    public WebElement previousButton;

    //Admin > Next Butonu
    @FindBy (xpath = "//a[text()='Next']")
    public WebElement nextButton;


    public void signInMethodu() {    ////YYY
        Driver.getDriver().get("https://qa.mealscenter.com/backoffice/login");
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(usernameBox, ConfigReader.getProperty("mustafaUsername"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("mustafaPassword")).perform();
        signinButton.click();
    }

    //Admin/Soldaki Menu List      YYYY
    @FindBy(xpath = "//div[@class='sidebar-wrap']")
    public WebElement menuList;

    //Admin/Sagdaki Kullanici butonu ///YYY
    @FindBy(xpath = "(//a[@id='dropdownMenuLink'])[1]")
    public WebElement kullaniciButonu;


    public void logOutMethod() {    ///YYY

        Actions actions=new Actions(Driver.getDriver());

        ReusableMethods.bekle(2);
        //Kullanıcı profiline tıklanır.
        actions.click(profileButton).build().perform();
        ReusableMethods.bekle(2);

        //Açılan dropdown menudeki "Logout" butonuna tıklanır.
        actions.click(logOutButton).build().perform();

    }

    //Admin/Soldaki menü bölümü/Promo linki>Coupon Linki>Update>Expiration Kutusu>Dinamik tarih seçimi
    public void dinamikTarihSecimi(int gunNo) {

        //buradaki günNo'yu seçerken gün numarasına göre seçiyoruz
        String dinamikXPath = "//tbody/tr/td[text()='" + gunNo + "']";
        WebElement tarihElementi = Driver.getDriver().findElement(By.xpath(dinamikXPath));
        ReusableMethods.wait(2);
        tarihElementi.click();

    }

    //Admin/Promo/Add Coupon/Applicable to Merchant butonu
    @FindBy(xpath = "(//span[@class='select2-selection select2-selection--multiple'])[2]")
    public WebElement applicabletoMerchant;

    //Admin/Soldaki menü bölümü/Promo Linki >Coupon Linki>Update >Delete>Delete doğrulama  YYYY
    @FindBy(xpath = "//a[@class='btn btn-green item_delete']")
    public WebElement promoCouponDeleteConfirmButton;

    //Admin/Earnings>Merchant Earnings/update/balance elementi
    @FindBy(xpath = "(//th[@class='sorting'])[2]")
    public WebElement balanceElementi;

    //Admin/Earnings>Merchant Earnings/action elementi
    @FindBy(xpath = "(//i[@class='zmdi zmdi-eye'])[1]")
    public WebElement actionElementi;

    //Admin/merchant/list=>search elementi
    @FindBy(xpath = "//input[@type='search']")
    public WebElement search_elementi;

    //Admin/merchant/list=>Edit elementi
    @FindBy(xpath = "(//a[@data-placement='top'])[1]")
    public WebElement edit_butonu;

    //  //Admin/merchant/list/Edit=>tüm sayfa
    @FindBy(xpath = "//div[@class='main-container']")
    public WebElement tüm_sayfa_lokayti;




    //////////////administrator login//////////////

    //Admin/Login/administrator login yazısı
    @FindBy(xpath = "//h6")
    public WebElement administratorLoginYazi;

    //Admin / login /username box
    @FindBy(xpath = "//input[@placeholder='Username']")
    public WebElement usernameKutu;

    //Admin / login / password box
    @FindBy(xpath = "//input[@placeholder='Password']")
    public WebElement passwordKutu;


    // admin girisi method
    public void adminGirisi(String username,String password){
        usernameKutu.sendKeys(username);
        passwordKutu.sendKeys(password);
        signinButton.click();
    }

    //Admin / Login /Incorrect password or username yazı elementi
    @FindBy (xpath = "//div[@class='errorMessage']")
    public WebElement gecersizGiris;

    public boolean gorulurOlmaMethodu(WebElement element){

        boolean deger=element.isDisplayed();

        return deger;
    }

    public WebElement getKartText(int resimNo){
        //Admin/Anasayfa'daki üstte yer alan resimlerin içindeki yazıları getirir.

        String  dinamikXPaath="(//div[@class='card-body'])["+resimNo+"]";
        WebElement istenenKartText=Driver.getDriver().findElement(By.xpath(dinamikXPaath));
        return istenenKartText;
    }

    public WebElement getResimText2(int resimNo){
        //Admin/Anasayfa'daki üstte yer alan resimlerin içindeki yazıları getirir.

        String  dinamikXPaath="(//div[@class='report-inner'])["+resimNo+"]";
        WebElement istenenResimText=Driver.getDriver().findElement(By.xpath(dinamikXPaath));
        return istenenResimText;
    }

    //Admin sayfası Body bölümü başlık listesi döndüren method
    public WebElement getBodyBaslikText(int baslikNo){

        // 1=Last Orders
        // 2=Popular Items
        // 3=Popular Merchants

        String dinamikXPath="(//h5[@class='m-0'])["+baslikNo+"]";

        WebElement istenenBaslik=Driver.getDriver().findElement(By.xpath(dinamikXPath));

        return istenenBaslik;
    }

    //Admin / Dassboard / Grafik
    @FindBy(xpath = "//*[@class='highcharts-background']")
    public WebElement grafikElement;


    //Admin/Merchant Earnings/Merchant listesini isme gore siralama elementi  //Eklenmedi
    @FindBy(xpath = "//th[contains(text(),'Merchant')]")
    public WebElement merchantIsmeGoreSiralamaElementi;

    //Merchant/Coupon list 2. sayfa elementi
    @FindBy(xpath = "//a[contains(text(),'2')]") ///Eklenmedi
    public WebElement ikinciSayfa;

    //Promo/Coupon / isme gore siralama elementi
    @FindBy(xpath = "(//th[@aria-controls='DataTables_Table_0'])[2]") ///Eklenmedi
    public WebElement couponNameElementi;

    //Merchant Earnings/ isme gore siralama elementi
    @FindBy(xpath = "(//th[@class='sorting'])[1]")
    public WebElement merchantSiralama;

    //Promo/Coupon / kullanim sayisina  gore siralama elementi
    @FindBy(xpath = "(//th[@aria-controls='DataTables_Table_0'])[3]")
    public WebElement usedElementi;

    //Promo / balance sirasiz deger
    @FindBy(xpath = "(//tbody/tr//td/b)[1]")
    public WebElement ilkBalanceDegeri;


    //Promo/ actions/ running balance elementi
    @FindBy(xpath = "(//div[@class='col-sm-12'])[2]//table//tr[1]//td[4]")
    public WebElement runningBalanceDegeri;

    //Merchant Earnings Search butonu
    @FindBy(xpath = "//div[@id='DataTables_Table_0_filter']")
    public WebElement merchantSearchButonu;

    //Dashboard/Promo>Coupon elementi
    @FindBy(xpath = "//li[@class='position-relative promo_coupon active']")
    public WebElement solMenuCouponElementi;

    //Promo>Coupon / Search buton elementi
    @FindBy(xpath = "//input[@class='form-control rounded search w-25']")
    public WebElement couponSearchBoxElementi;

    //Admin/Soldaki menü bölümü /Earnings Linki
    @FindBy(xpath = "//li[@class='admin_earnings']")
    public WebElement earningsLink1;


    //Admin/Soldaki menü bölümü /Orders Linki > Merchant Earnings Linki
    @FindBy(xpath = "//li[@class='position-relative earnings_merchant']")
    public WebElement earingsMerchantEarningsLink1;


    //Admin/Soldaki menü bölümü /Promo Linki
    @FindBy(xpath = "//li[@class='promo']")
    public WebElement promoLink1;

    //Admin/Soldaki menü bölümü /Promo Linki > Coupon Linki
    @FindBy(xpath = "//ul//li[@class='position-relative promo_coupon']")
    public WebElement promoCouponLink1;

    //Admin/Soldaki menü bölümü /Promo Linki > Coupon Linki > Update > Coupon Name kutusu
    @FindBy(xpath = "(//input[@class='form-control form-control-text'])[1]")
    public WebElement promoCouponUpdateCouponNameBox1;


    //Admin/Soldaki menü bölümü /Promo Linki > Coupon Linki > Update > Expiration kutusu
    @FindBy(xpath = "//input[@class='form-control form-control-text datepick error']")
    public WebElement promoCouponUpdateExpirationBox1;

    //Admin > Save
    @FindBy(xpath = "//div[@class='container-fluid m-0 p-0']//input[@value='Save']")
    public WebElement saveButton1;

    @FindBy(xpath = "(//input[@type='text'])[1]")
    public WebElement restaurantName;

    //Admin/merchant/list/Edit Merchant=>browse
    @FindBy(xpath = "(//button[@type='button'])[3]")
    public WebElement browseButonu;


    //Admin/merchant/list/Edit Merchantbrowse=>upload new
    @FindBy(xpath = "(//div[@class='modal-header pb-1 bg-light']//a)[2]")
    public WebElement uploadNew;

    //Admin/merchant/list/Edit Merchantbrowse/upload new=>select files
    @FindBy(xpath = "(//div[@class='text-center']//a)[1]")
    public WebElement selectFiles;


    @FindBy(xpath = "//div[@role='textbox']")
    public WebElement aboutButonu;

    @FindBy(xpath = "(//div[@class='form-label-group mt-2'])[2]")
    public WebElement shortAbout;

    @FindBy(xpath = "(//span[@aria-hidden=\"true\"])[8]")
    public WebElement merchantInformationServicesPickUp;

    @FindBy(xpath = "(//span[@role='combobox'])[3]")
    public WebElement tags;

    @FindBy(xpath = "//li[text()='No results']")
    public WebElement noResult;

    @FindBy(xpath = "(//span[@aria-hidden='true'])[11]")
    public WebElement featured;

    @FindBy(xpath = "//input[@value='Save']")
    public WebElement saveInformation;

    @FindBy(xpath = "//div[@class='alert alert-success']")
    public WebElement basarılıKayit;

    @FindBy(xpath = "//input[@value='1122555392']")
    public WebElement deliveryDistanceCovered;

    @FindBy(xpath = "(//input[@type='text'])[2]")
    public WebElement geolocation;

    @FindBy(xpath = "(//input[@type='text'])[3]")
    public WebElement geolocation2;

    @FindBy(xpath = "(//input[@type='text'])[4]")
    public WebElement geolocation3;
    @FindBy(xpath = "(//a[@href='/backoffice/vendor/address/id/7'])[1]")
    public WebElement merchantAdmin_addres;


    @FindBy(xpath = "(//input[@type='text'])[1]")
    public WebElement address_details;

    @FindBy(xpath = "(//a[@href='/backoffice/vendor/zone/id/7'])[1]")
    public WebElement zone;

    @FindBy(xpath = "(//a[@href='/backoffice/vendor/membership/id/7'])[1]")
    public WebElement MerchantType;











}
