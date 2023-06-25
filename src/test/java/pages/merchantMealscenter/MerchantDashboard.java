package pages.merchantMealscenter;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.userMealscenter.UserHomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class MerchantDashboard {

    //!!!!!!!!! KOD YAZMADAN ÖNCE KENDİ BRANCH'İNDE OLDUĞUNDAN EMİN OL !!!!!!!!!!!!!!!!!!!!
    //!!!!!!!!! KOD YAZMADAN ÖNCE KENDİ BRANCH'İNDE OLDUĞUNDAN EMİN OL !!!!!!!!!!!!!!!!!!!!
    //!!!!!!!!! KOD YAZMADAN ÖNCE KENDİ BRANCH'İNDE OLDUĞUNDAN EMİN OL !!!!!!!!!!!!!!!!!!!!

    //!!!!!!!! MAİN BRANCH'DE YAPACAĞIMIZ TEK İŞLEM PULL ETMEK !!!!!!!!!!!!!!!
    //!!!!!!!! MAİN BRANCH'DE YAPACAĞIMIZ TEK İŞLEM PULL ETMEK !!!!!!!!!!!!!!!
    //!!!!!!!! MAİN BRANCH'DE YAPACAĞIMIZ TEK İŞLEM PULL ETMEK !!!!!!!!!!!!!!!

    public MerchantDashboard(){

        PageFactory.initElements(Driver.getDriver(),this);

    }
    //!!!!!!!!!!!!!!!!!!  MERCHANT LOGİN   !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

    //Merchant/Login/Username
    @FindBy(xpath = "//input[@placeholder='Username']")
    public WebElement usernameBox;

    //Merchant/Login/Password
    @FindBy(xpath = "(//input[@placeholder='Password']")
    public WebElement passwordBox;

    //Merchant/Login/RememberMe
    @FindBy(xpath = "//input[@id='LoginForm_rememberMe']")
    public WebElement RememberMeRadioButton;

    //Merchant/Login/Forgot Password
    @FindBy(xpath = "//a[@class='dim underline']")
    public WebElement forgotPasswordClick;

    //Merchant/Login/Signin
    @FindBy(xpath = "//input[@name='yt0']")
    public WebElement signinButton;


    //Merchant/Login/App Store
    @FindBy(xpath = "//div[@class='d-flex justify-content-center']//div[1]//a[1]//img[1]")
    public WebElement AppStoreButton;

    //Merchant/Login/Google Play
    @FindBy(xpath = "//div[@class='d-flex justify-content-center']//div[1]//a[1]//img[1]")
    public WebElement googlePlayButton;

    //!!!!!!!!!!!!!!!!!!     ADMİN / ANASYAFA /HEADER BÖLÜMÜ LOCATE !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

    //Merchant/Dashboard/Profil ismi
    @FindBy(xpath = "//div[contains(@class,'line-bottom')]//a[@id='dropdownMenuLink']")
    public WebElement profilName;

    //Merchant/Dashboard/Profil ismi > Profile
    @FindBy(xpath = "(//a[@class='btn btn-sm dropdown-toggle text-truncate'])[1]")
    public WebElement profileButton;

    //Merchant/Dashboard/Profil ismi > Log Out
    @FindBy(xpath = "(//a[@class='dropdown-item'])[3]")
    public WebElement logOutButton;

    //Merchant/Dashboard/Profil DropDown>Profil Menusu
    @FindBy(xpath = "(//div[@class='card-body'])[1]")
    public WebElement profilMenuGenelBilgilerMenu;

    //Merchant/Dashboard/Profil DropDown>Profil
    @FindBy(xpath = "//a[@class='dropdown-item']")
    public WebElement dashboardProfilDropDown;

    //Merchant/Dashboard/Zil Logo
    @FindBy(xpath = "//span[@class='badge rounded-circle badge-danger count']")
    public WebElement zilLogo;

    //Merchant/Dashboard/Preview Store Logo
    @FindBy(xpath = "//a[@class='btn btn-sm']")
    public WebElement previewStoreLogo;

    //Merchant/Dashboard/Meals Center Resim Logosu
    @FindBy(xpath = "//a[@class='btn btn-sm']")
    public WebElement mealsCenterImageLogo;

    //Merchant/Login/Forgot> Yanlis Mesaj
    @FindBy(xpath = "//div[@class='errorMessage']")
    public WebElement wrongLoginMesaj;

    //Merchant/Profil DropDown/Profil>Profil Menusunde Firstname
    @FindBy(xpath = "(//input[@class='form-control form-control-text'])[1]")
    public WebElement profilFirstNameMenu;

    //Merchant/Profil DropDown/Profil>Profil Menusunde Lastname
    @FindBy(xpath = "(//input[@class='form-control form-control-text'])[2]")
    public WebElement profilLastNameMenu;


    //Merchant/Profil DropDown/Profil>Profil Menusunde Kullanici Adi
    @FindBy(xpath = "(//input[@class='form-control form-control-text'])[5]")
    public WebElement profilKullaniciAdiMenu;

    //Merchant/Profil DropDown/Profil>Profil Menusunde Sava Buttonu
    @FindBy(xpath = "//input[@value='Save']")
    public WebElement profilSaveButton;

    //Merchant/Profil DropDown/Profil>Profil Menusunde Update Yazisi
    @FindBy(xpath = "//div[@class='alert alert-success']")
    public WebElement profilUpdateYazisi;

    //Merchant/Profil DropDown/Profil>Profil Menusunde Email
    @FindBy(xpath = "(//input[@class='form-control form-control-text'])[3]")
    public WebElement profilEmailMenu;

    //Merchant/Profil DropDown/Profil>Profil Menusunde Kullanici Adi
    @FindBy(xpath = "(//input[@class='form-control form-control-text'])[4]")
    public WebElement profilTelefonMenu;

    //Merchant/Profil DropDown/Profil>Profil Menusunde Profil resmi ekleme menusu
    @FindBy(xpath = "//div[@class='row justify-content-between align-items-center']")
    public WebElement profilResimEklemeMenusu;

    //Merchant/Profil DropDown/Profil>Profil Menusunde Profil resmi ekleme butonu
    @FindBy(xpath = "(//button[@type='button'])[5]")
    public WebElement profilResimEklemeButonu;

    //Merchant/Profil DropDown/Profil>Profil Menusunde Profil resim secilen
    @FindBy(xpath = "//*[@id=\"modalUploader\"]/div/div/div[2]/div[2]/ul/li[1]/img")
    public WebElement profilResimOrnek;

    //Merchant/Profil DropDown/Profil>Profil Menusunde Profil resim secilen resmi ekleme butonu
    @FindBy(xpath = "//span[@class='label']")
    public WebElement profilSecilenResimAdFiles;

    //Merchant/Profil DropDown/Profil>Profil Menusunde sifre degistirme butonu
    @FindBy(xpath = "(//i[@class='zmdi zmdi-lock-outline'])[1]")
    public WebElement profilSifreDegistirmeButonu;

    //Merchant/Profil DropDown/Profil>Profil Menusunde sifre degistirme eski password menusu
    @FindBy(xpath = "(//label[@class='required'])[1]")
    public WebElement profilEskiSifreMenu;

    //Merchant/Profil DropDown/Profil>Profil Menusunde sifre degistirme yeni password menusu
    @FindBy(xpath = "(//label[@class='required'])[2]")
    public WebElement profilYeniSifreMenu;

    //Merchant/Profil DropDown/Profil>Profil Menusunde sifre degistirme yeni tekrar password menusu
    @FindBy(xpath = "(//label[@class='required'])[3]")
    public WebElement profilYeniSifreTekrarMenu;

    //Merchant/Profil DropDown/Profil>Profil Menusunde sifre degistirme save butonu
    @FindBy(xpath = "//*[@id=\"profile\"]")
    public WebElement profilYeniSifreSaveButonu;

    public void getResimText(int resimNo){
        //Admin/Anasayfa'daki üstte yer alan resimlerin içindeki yazıları getirir.

        String  dinamikXPaath="(//div[@class='report-inner'])["+resimNo+"]";
        WebElement istenenResimText=Driver.getDriver().findElement(By.xpath(dinamikXPaath));
    }


    //!!!!!!!!!!!!!!!!!!!    MERCHANT DASHBOARD SOL MENÜ LOCATE  !!!!!!!!!!!!!!!!!!!!!!!!!!

    //Merchant/Soldaki Menu List
    @FindBy(xpath = "//div[@id='vue-siderbar-menu']")
    public WebElement menuList;

    //Merchant/Soldaki menü bölümü /Dashboard Linki
    @FindBy(xpath = "//a[normalize-space()='Dashboard']")
    public WebElement dashboardLink;

    //Merchant/Soldaki menü bölümü /Merchant Linki
    @FindBy(xpath = "//a[normalize-space()='Merchant']")
    public WebElement merchantLink;

    //Merchant/Soldaki menü bölümü /Merchant Linki > İnfotmation Linki
    @FindBy(xpath = "//a[normalize-space()='Information']")
    public WebElement merchantInformationLink;

    //Merchant/Soldaki menü bölümü /Merchant Linki > Settings Linki
    @FindBy(xpath = "(//*[text()='Settings'])[4]")
    public WebElement merchantSettingsLink;

    //Merchant/Soldaki menü bölümü /Merchant Linki > Order Limit Linki
    @FindBy(xpath = "//a[normalize-space()='Order Limit']")
    public WebElement merchantOrderLimitLink;

    //Merchant/Soldaki menü bölümü /Merchant Linki > Banner Linki
    @FindBy(xpath = "//a[normalize-space()='Banner']")
    public WebElement merchantBannerLink;

    //Merchant/Soldaki menü bölümü /Merchant Linki > Pages Linki
    @FindBy(xpath = "//a[normalize-space()='Pages']")
    public WebElement merchantPagesLink;

    //Merchant/Soldaki menü bölümü /Merchant Linki > Menu Linki
    @FindBy(xpath = "//a[normalize-space()='Menu']")
    public WebElement merchantMenuLink;

    //Merchant/Soldaki menü bölümü /Orders Linki
    @FindBy(xpath = "(//a[normalize-space()='Orders'])[1]")
    public WebElement ordersLink;

    //Merchant/Soldaki menü bölümü /Orders Linki > New Orders Linki
    @FindBy(xpath = "//a[normalize-space()='New Orders']")
    public WebElement ordersNewOrdersLink;

    //Merchant/Soldaki menü bölümü /Orders Linki > Orders Processing Linki
    @FindBy(xpath = "//a[normalize-space()='Orders Processing']")
    public WebElement ordersOrdersProcessingLink;

    //Merchant/Soldaki menü bölümü /Orders Linki > Orders Ready Linki
    @FindBy(xpath = "//a[normalize-space()='Orders Ready']")
    public WebElement ordersOrdersReadyLink;

    //Merchant/Soldaki menü bölümü /Orders Linki > completed Linki
    @FindBy(xpath = "//a[@href='/backoffice/orders/completed']")
    public WebElement ordersCompletedLink;

    //Merchant/Soldaki menü bölümü /Orders Linki > Scheduled Linki
    @FindBy(xpath = "//a[normalize-space()='Scheduled']")
    public WebElement ordersScheduledLink;

    //Merchant/Soldaki menü bölümü /Orders Linki > All Orders Linki
    @FindBy(xpath = "//a[normalize-space()='All Orders']")
    public WebElement ordersAllOrdersLink;

    // ATTRIBUTES KISMI

    //Merchant/Soldaki menü bölümü /Attributes Linki
    @FindBy(xpath = "//a[normalize-space()='Attributes']")
    public WebElement attributesLink;

    //Merchant/Soldaki menü bölümü /Attributes Linki >Size linki
    @FindBy(xpath = "//a[normalize-space()='Size']")
    public WebElement attributesSizeLink;

    //Merchant/Soldaki menü bölümü /Attributes Linki > Ingredients linki
    @FindBy(xpath = "//a[normalize-space()='Ingredients']")
    public WebElement attributesIngredientsLink;

    //Merchant/Soldaki menü bölümü /Attributes Linki > Cooking Reference linki
    @FindBy(xpath = "//a[normalize-space()='Cooking Reference']")
    public WebElement attributesCookingReferenceLink;

    //MealsCenter/backoffice/attrmerchant
    @FindBy(xpath = "(//a[@href='javascript:;'])[5]")
    public WebElement attributesButonu;

    //MealsCenter/backoffice/attrmerchant/preview store butonu
    @FindBy(xpath = "(//a[@title=\"Preview store\"])[1]")
    public WebElement attributesPreviewStoreButonu;

    //MealsCenter/backoffice/attrmerchant/size list
    @FindBy(xpath = "//h5[text()='Size List']")
    public WebElement attributesSizeListYazisi;

    //MealsCenter/backoffice/attrmerchant/ingredients list
    @FindBy(xpath = "//h5[text()='Ingredients List']")
    public WebElement attributesIngredientsListYazisi;

    //MealsCenter/backoffice/attrmerchant/cooking reference list
    @FindBy(xpath = "//h5[text()='Cooking Reference List']")
    public WebElement attributesCookingReferenceListYazisi;

    //MealsCenter/backoffice/attrmerchant/add new butonu
    @FindBy(xpath = "//a[@type=\"button\"]")
    public WebElement attributesAddNewButonu;

    //MealsCenter/merchant/attrmerchant/searchBox
    @FindBy(xpath="//input[@type='search']")
    public WebElement attributesSearchBox;

    //MealsCenter/backoffice/attrmerchant/update butonu
    @FindBy(xpath = "//a[@data-original-title=\"Update\"]")
    public WebElement attributesUpdateButonu;

    //MealsCenter/backoffice/attrmerchant/delete butonu
    @FindBy(xpath = "//a[@data-original-title=\"Delete\"]")
    public WebElement attributesDeleteButonu;

    //MealsCenter/backoffice/attrmerchant/add new sayfasindaki size name kısmı
    @FindBy(xpath = "//label[text()='Size Name ']")
    public WebElement attributesSizeNameKismi;

    //MealsCenter/backoffice/attrmerchant/add new sayfasindaki status kısmındaki publish seçenegi
    @FindBy(xpath = "//option[text()='Publish']")
    public WebElement attributesStatusPublishKismi;

    //MealsCenter/backoffice/attrmerchant/add new sayfasindaki item translations butonu
    @FindBy(xpath = "//div[text()='Item translations']")
    public WebElement attributesItemTranslations;

    //MealsCenter/backoffice/attrmerchant/add new sayfasindaki japanese translation kismi
    @FindBy(xpath = "//label[text()='Enter Japanese name here']")
    public WebElement attributesJapaneseTranslation;

    //MealsCenter/backoffice/attrmerchant/add new sayfasindaki arabic translation kismi
    @FindBy(xpath = "//label[text()='Enter Arabic name here']")
    public WebElement attributesArabicTranslation;

    //MealsCenter/backoffice/attrmerchant/add new sayfasindaki save butonu
    @FindBy(xpath = "//input[@value=\"Save\"]")
    public WebElement attributesSaveButonu;

    //MealsCenter/backoffice/attrmerchant/previous butonu
    @FindBy(xpath = "//a[text()='Previous']")
    public WebElement attributesPreviousButonu;

    //MealsCenter/backoffice/attrmerchant/next butonu
    @FindBy(xpath = "//a[text()='Next']")
    public WebElement attributesNextButonu;

    //Merchant / Soldaki menü bölümü / Food Linki
    @FindBy(xpath = "//a[normalize-space()='Food']")
    public WebElement foodLink;

    //Merchant / Soldaki menü bölümü / Food Linki > Category Linki
    @FindBy(xpath = "//a[normalize-space()='Category']")
    public WebElement foodCategoryLink;

    //Merchant / Soldaki menü bölümü / Food Linki >Addon Category Linki
    @FindBy(xpath = "//a[normalize-space()='Addon Category']")
    public WebElement foodAddonCategoryLink;

    //Merchant / Soldaki menü bölümü / Food Linki > Addon Items Linki
    @FindBy(xpath = "//a[normalize-space()='Addon Items']")
    public WebElement foodAddonItemsLink;

    //Merchant / Soldaki menü bölümü / Food Linki > Items Linki
    @FindBy(xpath = "//a[normalize-space()='Items']")
    public WebElement foodItemsLink;

    //Merchant/Soldaki menü bölümü /Order Type Linki
    @FindBy(xpath = "//a[normalize-space()='Order Type']")
    public WebElement orderTypeLink;

    //Merchant/Soldaki menü bölümü /Order Type Linki > Delivery Linki
    @FindBy(xpath = "//a[normalize-space()='Delivery']")
    public WebElement orderTypeDeliveryLink;

    //Merchant/Soldaki menü bölümü /Order Type Linki > Pickup Linki
    @FindBy(xpath = "//a[normalize-space()='Pickup']")
    public WebElement orderTypePickupLink;

    //Merchant/Soldaki menü bölümü /Order Type Linki > Dinein Linki
    @FindBy(xpath = "//a[normalize-space()='Dinein']")
    public WebElement orderTypeDineinLink;

    //Merchant/Soldaki menü bölümü /Payment gatewayLinki
    @FindBy(xpath = "//a[normalize-space()='Payment gateway']")
    public WebElement paymentGatewayLink;

    //Merchant/Soldaki menü bölümü /Payment gatewayLinki > All payments Linki
    @FindBy(xpath = "//a[normalize-space()='All payments']")
    public WebElement paymentGatewayAllPaymentsLink;

    //Merchant/Soldaki menü bölümü /Payment gatewayLinki > Bank Deposit Linki
    @FindBy(xpath = "//a[normalize-space()='Bank Deposit']")
    public WebElement paymentGatewayBankDepositLink;

    //Merchant/Soldaki menü bölümü /Promo Linki
    @FindBy(xpath = "//a[normalize-space()='Promo']")
    public WebElement promoLink;

    //Merchant/Soldaki menü bölümü /Promo Linki > Coupon Linki
    @FindBy(xpath = "//a[normalize-space()='Coupon']")
    public WebElement promoCouponLink;

    //Merchant/Soldaki menü bölümü /Promo Linki > Coupon Linki > Update > Coupon Name kutusu
    @FindBy(xpath = "//input[@id='AR_voucher_voucher_name']")
    public WebElement promoCouponUpdateCouponNameBox;

    //Merchant/Soldaki menü bölümü /Promo Linki > Coupon Linki > Update > Coupon Type kutusu
    @FindBy(xpath = "//select[@id='AR_voucher_voucher_type']")
    public WebElement promoCouponUpdateCouponTypeBox;

    //Merchant/Soldaki menü bölümü /Promo Linki > Coupon Linki > Update > Amount kutusu
    @FindBy(xpath = "//input[@id='AR_voucher_amount']")
    public WebElement promoCouponUpdateAmountBox;

    //Merchant/Soldaki menü bölümü /Promo Linki > Coupon Linki > Update > Min Order kutusu
    @FindBy(xpath = "//input[@id='AR_voucher_min_order']")
    public WebElement promoCouponUpdateMinOrderBox;

    //Merchant/Soldaki menü bölümü /Promo Linki > Coupon Linki > Update > Days Available kutusu
    @FindBy(xpath = "(//span[@class='select2-selection select2-selection--multiple'])[1]")
    public WebElement promoCouponUpdateDaysAvaibleBox;


    //Merchant/Soldaki menü bölümü /Promo Linki > Coupon Linki > Update > Expiration kutusu
    @FindBy(xpath = "//input[@id='AR_voucher_expiration']")
    public WebElement promoCouponUpdateExpirationBox;

    //Merchant/Soldaki menü bölümü/Promo linki>Coupon Linki>Update>Expiration Kutusu>Dinamik tarih seçimi
    public void dinamikTarihSecimi(int gunNo){

        //buradaki günNo'yu seçerken gün numarasına göre seçiyoruz
        String dinamikXPath="//tbody/tr/td[text()='"+gunNo+"']";
        WebElement tarihElementi=Driver.getDriver().findElement(By.xpath(dinamikXPath));
        ReusableMethods.wait(2);
        tarihElementi.click();

    }

    //Merchant/Soldaki menü bölümü /Promo Linki > Coupon Linki > Update > Coupon Options kutusu
    @FindBy(xpath = "//select[@id='AR_voucher_used_once']")
    public WebElement promoCouponUpdateCouponOptionsBox;

    //Merchant/Soldaki menü bölümü /Promo Linki > Coupon Linki > Update > Status kutusu
    @FindBy(xpath = "//select[@id='AR_voucher_status']")
    public WebElement promoCouponUpdateStatusBox;

    //Merchant/Soldaki menü bölümü/Promo Linki >Coupon Linki>Update >Delete>Delete doğrulama
    @FindBy(xpath = "//a[@class='btn btn-green item_delete']")
    public WebElement promoCouponDeleteConfirmButton;

    //Merchant/Soldaki menü bölümü /Images Linki
    @FindBy(xpath = "//a[normalize-space()='Images']")
    public WebElement ImagesLink;

    //Merchant/Soldaki menü bölümü /Images Linki > Gallery Linki
    @FindBy(xpath = "//a[normalize-space()='Gallery']")
    public WebElement ImagesGalleryLink;

    //Merchant/Soldaki menü bölümü /Images Linki > Media Library Linki
    @FindBy(xpath = "//a[normalize-space()='Media Library']")
    public WebElement ImagesMediaLibraryLink;

    //Merchant/Soldaki menü bölümü /Account Linki
    @FindBy(xpath = "//a[normalize-space()='Account']")
    public WebElement accountLink;

    //Merchant/Soldaki menü bölümü / Account Linki > Statement Linki
    @FindBy(xpath = "//a[normalize-space()='Statement']")
    public WebElement accountStatementLink;

    //Merchant/Soldaki menü bölümü /Buyers Linki
    @FindBy(xpath = "//a[normalize-space()='Buyers']")
    public WebElement buyersLink;

    //Merchant/Soldaki menü bölümü /Buyers Linki > List Linki
    @FindBy(xpath = "//a[@href='/backoffice/customer/list']")
    public WebElement buyersListLink;

    //Merchant/Soldaki menü bölümü /Buyers Linki > Review Linki
    @FindBy(xpath = "//a[normalize-space()='Reviews']")
    public WebElement buyersReviewLink;

    //Merchant/Soldaki menü bölümü /Users Linki
    @FindBy(xpath = "//a[normalize-space()='Users']")
    public WebElement UsersLink;

    //Merchant/Soldaki menü bölümü /Users Linki > All User Linki
    @FindBy(xpath = "//a[normalize-space()='All User']")
    public WebElement UsersAllUserLink;

    //Merchant/Soldaki menü bölümü /Users Linki > All Roles Linki
    @FindBy(xpath = "//a[normalize-space()='All Roles']")
    public WebElement UsersAllRolesLink;

    //Merchant/Soldaki menü bölümü /Reports Linki
    @FindBy(xpath = "//a[normalize-space()='Reports']")
    public WebElement reportsLink;

    //Merchant/Soldaki menü bölümü /Reports Linki > Sales Report Linki
    @FindBy(xpath = "//a[normalize-space()='Sales Report']")
    public WebElement reportsSalesReportLink;

    //Merchant/Soldaki menü bölümü /Reports Linki > Sales Summary Linki
    @FindBy(xpath = "//a[normalize-space()='Sales Summary']")
    public WebElement reportsSalesSummaryLink;

    //Merchant/Soldaki menü bölümü /Reports Linki > Refund Report Linki
    @FindBy(xpath = "//a[normalize-space()='Refund Report']")
    public WebElement reportsRefundReportLink;


    //Merchant/Soldaki menü bölümü /Inventory Management Linki
    @FindBy(xpath = "//a[normalize-space()='Inventory Management']")
    public WebElement inventoryManagementLink;

    //Merchant/Soldaki menü bölümü /inventory Management Linki > Suppliers Linki
    @FindBy(xpath = "//a[normalize-space()='Suppliers']")
    public WebElement inventoryManagementSuppliersLink;


    //!!!!!!!!!!!!!!!!!!!!!!!!! MERCHANT / ANASAYFA / BODY BÖLÜMÜNDEKİ LİNKLER  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

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

    //Merchant/Dashboard/ Checkout All Reviews Butonu
    @FindBy(xpath = "//a[@class='w-100 btn btn-lg btn-info waves-effect waves-light mb-3']")
    public WebElement checkoutAllReviews;

    //!!!!!!!!!!!!!!!!!!!!!!!! TÜM ADMİN SAYFASINDA ORTAK OLAN LOCATELER   !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!


    //Merchant > Search Box(Arama Kutusu
    @FindBy(xpath = "//input[@placeholder='Search']")
    public WebElement searchBox;

    //Merchant > Search İcon Butonu
    @FindBy (xpath = "//i[@class='zmdi zmdi-search']")
    public WebElement searchIconButton;

    //Merchant > Save
    @FindBy (xpath = "//div[@class='container-fluid m-0 p-0']//input[@value='Save']")
    public WebElement saveButton;

    //Merchant > Update
    @FindBy (xpath = "(//a[@class='btn btn-light tool_tips'])[1]")
    public WebElement updateButton;

    //Merchant > Delete
    @FindBy (xpath = "(//a[@class='btn btn-light datatables_delete tool_tips'])[1]")
    public WebElement deleteButton;

    //Merchant > Merchant > Auto Login Button
    @FindBy (xpath = "(//a[@class='btn btn-light tool_tips'])[1]")
    public WebElement autoLoginButton;

    //Merchant > Orders > Download Button
    @FindBy (xpath = "(//a[@class='ref_pdf_order normal btn btn-light tool_tips'])[1]")
    public WebElement downloadButton;

    //Merchant > Add New Button
    @FindBy (xpath = "//a[@class='btn btn-black btn-circle']")
    public WebElement addNewButton;

    //Merchant > İnceleme(Göz) Butonu
    @FindBy (xpath = "(//a[@class='ref_view_transaction normal btn btn-light tool_tips'])[1]")
    public WebElement incelemeButton;

    //Merchant > Reports > Start date and end date Kutusu
    @FindBy (xpath = "//input[@placeholder='Start date -- End date']")
    public WebElement dateBox;


    //Merchant > Previous Butonu
    @FindBy (xpath = "//a[text()='Previous']")
    public WebElement previousButton;

    //Merchant > Next Butonu
    @FindBy (xpath = "//a[text()='Next']")
    public WebElement nextButton;

    //Merchant/Login/Forgot> Yanlis Mesaj
    @FindBy(xpath = "//div[@class='errorMessage']")
    public WebElement wrongLogiNnMesaj;

    //Merchant/Login/Forgot>Contact Email
    @FindBy(xpath = "//label[@for='AR_merchant_login_email_address']")
    public WebElement forgotPasswordLoginEmail;

    //Merchant/Login/Forgot>Password Menusu
    @FindBy(xpath = "//div[@class='main-container-wrap']")
    public WebElement forgotPasswordMenu;

    //Merchant/Login/Forgot>Request Email Butonu
    @FindBy(xpath = "//input[@type='submit']")
    public WebElement requestEmailButton;

    //Merchant/Login/Forgot>Yanlis giris mesaji
    @FindBy(xpath = "//div[@class='alert alert-success']")
    public WebElement emailHasbeenMesaj;

    public void signInMerchantMethod() {

        Driver.getDriver().get(ConfigReader.getProperty("mealCenterMerchantPageUrl"));

        Actions actions=new Actions(Driver.getDriver());

        actions.sendKeys(usernameBox,ConfigReader.getProperty("LaPalmeraUsername"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("LaPalmeraPassword")).perform();

        signinButton.click();
    }

    public void logOutMethod(){
        Actions actions = new Actions(Driver.getDriver());

        //Kullanıcı profiline tıklanır.
        ReusableMethods.wait(2);
        actions.click(profileButton).perform();


        ReusableMethods.wait(2);

        //Açılan dropdown menudeki "Logout" butonuna tıklanır.
        actions.click(Driver.getDriver().findElement(By.xpath("//div[@class='dropdown-menu show']//a[text()=' Logout ']"))).build().perform();
    }

    public boolean gorulurOlmaMethodu(WebElement element){

        boolean deger=element.isDisplayed();

        return deger;
    }
    public void merchantSitesiAnasayfaGiris(){
        UserHomePage userHomePage=new UserHomePage();
        Driver.getDriver().get(ConfigReader.getProperty("mealCenterMerchantPageUrl"));

        usernameBox.sendKeys(ConfigReader.getProperty("LaPalmeraUsername"));
        passwordBox.sendKeys(ConfigReader.getProperty("LaPalmeraPassword"));
        signinButton.click();
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

    // SON 5 URUNU GOSTEREN LİNKLER
    @FindBy(linkText = "All")
    public WebElement AllTusu;

    @FindBy(linkText = "Processing")
    public WebElement ProcessingTusu;

    @FindBy(linkText = "Ready")
    public WebElement ReadyTusu;


    @FindBy(linkText = "Completed")
    public WebElement CompletedTusu;

    @FindBy(linkText = "Popular items")
    public WebElement PopularitemsTusu;

    @FindBy(linkText = "Last 30 days sales")
    public WebElement LastdayssalesTusu;

    @FindBy(linkText = "View All Customer")
    public WebElement  ViewAllCustomerTusu;


    @FindBy(xpath = "//div[@class='mt-3 table-orders table-responsive']//table//tr//td[1]")
    public List<WebElement> table1;
    @FindBy(xpath = "//div[@class='mt-3 table-item table-responsive']//table//tr//td[1]")
    public List<WebElement> table2;

    @FindBy(xpath = "(//div[@class='card-body'])[12]//table//tr//td[1]")
    public List<WebElement> table3;

    @FindBy(xpath = "//table//tr//td[2]")
    public List<WebElement> table4;

    public boolean tabloListesindeOlma(List<WebElement> liste,String icerik){
        boolean sart=false;

        for (WebElement each:liste
        ) {
            if (each.getText().contains(icerik)){
                sart=true;
                break;
            }
        }
        return sart;
    }

    //!!!!!!!!!!!!!!!!!!!! MERCHANT /ORDER TYPE / DELİVERY !!!!!!!!!!!!!!!!!!!!!!!!!

    //Merchant/Soldaki menü bölümü /Order Type Linki > Delivery Linki /Settings butonu
    @FindBy(xpath = "(//i[@class='zmdi zmdi-settings'])[1]")
    public WebElement orderTypeSettingsButton;

    //Merchant/Soldaki menü bölümü /Order Type Linki > Delivery Linki /Enabled Opt butonu
    @FindBy(xpath = "(//input[@class='custom-control-input checkbox_child'])[1]")
    public WebElement orderTypeSettingEnabledOptButton;

    //Merchant/Soldaki menü bölümü /Order Type Linki > Delivery Linki /Free Delivery butonu
    @FindBy(xpath = "(//input[@class='custom-control-input checkbox_child'])[2]")
    public WebElement orderTypeSettingFreeDeliveryButton;

    //Merchant/Soldaki menü bölümü /Order Type Linki > Delivery Linki /Dynamic Charge Type menu
    @FindBy(xpath = "//select[@id='AR_option_merchant_delivery_charges_type']")
    public WebElement orderTypeSettingDynamicChargeTypeMenu;

    //Merchant/Soldaki menü bölümü /Order Type Linki > Delivery Linki /Services Fee Box
    @FindBy(xpath = "//input[@id='AR_option_merchant_service_fee']")
    public WebElement orderTypeSettingServicesFeeBox;

    //Merchant/Soldaki menü bölümü /Order Type Linki > Delivery Linki /Dynamic Rates Button
    @FindBy(xpath = "//*[@id=\"yw0\"]/li[2]/a")
    public WebElement orderTypeDynamicRatesButton;

    //Merchant/Soldaki menü bölümü/Order Type Linki >Delivery Linki/Dynamic Rates Button>Add New/Shipping Type
    @FindBy(xpath = "//select[@id='AR_shipping_rate_shipping_type']")
    public WebElement orderTypeDynamicRatesShippingTypeMenu;

    //Merchant/Soldaki menü bölümü/Order Type Linki >Delivery Linki/Dynamic Rates Button>Add New/From Box
    @FindBy(xpath = "//input[@id='AR_shipping_rate_distance_from']")
    public WebElement orderTypeDynamicRatesFromBox;

    //Merchant/Soldaki menü bölümü /Order Type Linki > Delivery Linki /Dynamic Rates Button>Add New/To Box
    @FindBy(xpath = "//input[@id='AR_shipping_rate_distance_to']")
    public WebElement orderTypeDynamicRatesToBox;

    //Merchant/Soldaki menü bölümü /Order Type Linki > Delivery Linki /Dynamic Rates Button>Add New/Miles Menu
    @FindBy(xpath = "//select[@id='AR_shipping_rate_shipping_units']")
    public WebElement orderTypeDynamicRatesMilesMenu;

    //Merchant/Soldaki menü bölümü /Order Type Linki > Delivery Linki /Dynamic Rates Button>Add New/Price Box
    @FindBy(xpath = "(//input[@Class='form-control form-control-text'])[3]")
    public WebElement orderTypeDynamicRatesPriceBox;

    //Merchant/Soldaki menü bölümü /Order Type Linki > Delivery Linki /Dynamic Rates Button>Add New/Min Box
    @FindBy(xpath = "(//input[@Class='form-control form-control-text'])[4]")
    public WebElement orderTypeDynamicRatesMinBox;

    //Merchant/Soldaki menü bölümü /Order Type Linki > Delivery Linki /Dynamic Rates Button>Add New/Max Box
    @FindBy(xpath = "(//input[@Class='form-control form-control-text'])[5]")
    public WebElement orderTypeDynamicRatesMaxBox;

    //Merchant/Soldaki menü bölümü /Order Type Linki > Delivery Linki /Dynamic Rates Button>Add New/Delivery estimation
    @FindBy(xpath = "//input[@class='form-control form-control-text estimation']")
    public WebElement orderTypeDynamicRatesDeliveryEstimationBox;

    //Merchant/Soldaki menü bölümü /Order Type Linki > Delivery Linki /Fixed Charge Butonu
    @FindBy(xpath = "(//*[text()='Fixed Charge'])[1]")
    public WebElement orderTypeFixedChargeButton;

    //Merchant/Soldaki menü bölümü /Order Type Linki > Delivery Linki /Hata yazısı mesajı
    @FindBy(xpath = "//div[@class='errorMessage']")
    public WebElement orderTypeErrorMessageText;

    //Merchant/Soldaki menü bölümü /Order Type Linki > Delivery Linki /Settings Saved  mesajı
    @FindBy(xpath = "//div[@class='alert alert-success']")
    public WebElement orderTypeSavedMessageText;

    //Merchant/Soldaki menü bölümü /Order Type Linki > Delivery Linki /Fixed Charge Butonu>Price Box
    @FindBy(xpath = "(//input[@Class='form-control form-control-text'])[1]")
    public WebElement orderTypeFixedChargePriceBox;

    //Merchant/Soldaki menü bölümü /Order Type Linki > Delivery Linki /Fixed Charge Butonu/Delivery Estimation Box
    @FindBy(xpath = "(//input[@Class='form-control form-control-text estimation'])[1]")
    public WebElement orderTypeFixedChargeDeliveryEstimationBox;

    //Merchant/Soldaki menü bölümü /Order Type Linki > Delivery Linki /Fixed Charge Butonu/Minumum Order Box
    @FindBy(xpath = "(//input[@Class='form-control form-control-text'])[2]")
    public WebElement orderTypeFixedChargeMinBox;

    //Merchant/Soldaki menü bölümü /Order Type Linki > Delivery Linki /Fixed Charge Butonu/Maximum Order Box
    @FindBy(xpath = "(//input[@Class='form-control form-control-text'])[3]")
    public WebElement orderTypeFixedChargeMaxBox;

    //Merchant/Soldaki menü bölümü /Order Type Linki > Delivery Linki /Fixed Charge Butonu/Delete butonu basınca çıkan delete butonu
    @FindBy(xpath = "//a[@class='btn btn-green item_delete']")
    public WebElement orderTypeAlertDeleteButton;
}
