package pages.merchantMealscenter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class MerchantFood {

    //!!!!!!!!! KOD YAZMADAN ÖNCE KENDİ BRANCH'İNDE OLDUĞUNDAN EMİN OL !!!!!!!!!!!!!!!!!!!!
    //!!!!!!!!! KOD YAZMADAN ÖNCE KENDİ BRANCH'İNDE OLDUĞUNDAN EMİN OL !!!!!!!!!!!!!!!!!!!!
    //!!!!!!!!! KOD YAZMADAN ÖNCE KENDİ BRANCH'İNDE OLDUĞUNDAN EMİN OL !!!!!!!!!!!!!!!!!!!!

    //!!!!!!!! MAİN BRANCH'DE YAPACAĞIMIZ TEK İŞLEM PULL ETMEK !!!!!!!!!!!!!!!
    //!!!!!!!! MAİN BRANCH'DE YAPACAĞIMIZ TEK İŞLEM PULL ETMEK !!!!!!!!!!!!!!!
    //!!!!!!!! MAİN BRANCH'DE YAPACAĞIMIZ TEK İŞLEM PULL ETMEK !!!!!!!!!!!!!!!

    public MerchantFood(){

        PageFactory.initElements(Driver.getDriver(),this);
    }
    ///  ITEMS SAYFASI


    //MealsCenter/merchant/food/soldakiItemsButonu
    @FindBy(xpath="//a[text()='Items']")
    public WebElement soldakiItemsButonu;

    //MealsCenter/merchant/food/itemListYazisi
    @FindBy(xpath="//h5[text()='Item list'])")
    public WebElement itemListYazisi;



    //MealsCenter/merchant/food/Items/addNewButonu
    @FindBy(xpath="//h5[text()='Add new']")
    public WebElement addNewButonu;


    //MealsCenter/merchant/food/Items/silmeKutusu//calismiyor//BUG
    @FindBy(xpath="//i[@class='zmdi zmdi-delete']")
    public WebElement silmeKutusu;

    //MealsCenter/merchant/food/Items/updateKutusu
    @FindBy(xpath="//i[@class='zmdi zmdi-border-color']")
    public WebElement updateKutusu;


    //MealsCenter/merchant/food/Items/5oDolarYazisi
    @FindBy(xpath="//p[text()='50.00$']")
    public WebElement itemsPrice;

    //MealsCenter/merchant/food/Items/appetizersYazisi
    @FindBy(xpath="//p[text()='Appetizers']")
    public WebElement appetizersYazisi;


    //MealsCenter/merchant/food/Items/searchBox//calismiyor/ BUG
    @FindBy(xpath="//label[text()='Search:']")
    public WebElement itemSearchBox;


    //MealsCenter/merchant/food/Items/itemsSortButonu
    @FindBy(xpath="((//a[@type='button'])[2]")
    public WebElement itemsSortButonu;

    //MealsCenter/merchant/food/Items/itemsSortButonu/AppetizersYazisisorttanSonra
    @FindBy(xpath="//li[text()='Appetizers ']")
    public WebElement appetizersYazisiSorttanSonra;


    //MealsCenter/merchant/food/Items/UpDate/Details/itemNameKutusu
    @FindBy(xpath="//input[@id='AR_item_item_name']")
    public WebElement detailsItemNameKutusu;


    //MealsCenter/merchant/food/Items/UpDate/Details/categoryKutusu
    @FindBy(xpath="(//span[@role='combobox'])[1]")
    public WebElement detailsCategoryKutusu;



    //MealsCenter/merchant/food/Items/UpDate/Details/itemsAppetizersYazisi
    @FindBy(xpath="//span[text()='Appetizers']")
    public WebElement detailsItemsAppetizersYazisi;

    //MealsCenter/merchant/food/Items/UpDate/Details/ItemsDetailsBrowseButonu
    @FindBy(xpath= "//button[text()='Browse']")
    public WebElement ItemsDetailsBrowseButonu;

    //MealsCenter/merchant/food/Items/UpDate/Details/burittoComboResmi
    @FindBy(xpath="(//div[@class='file_wrapper']//li)[1]")
    public WebElement burittoComboResmi;

    //MealsCenter/merchant/food/Items/UpDate/Details/addFilesButonu
    @FindBy(xpath="//span[text()='Add Files']")
    public WebElement detailsAddFilesButonu;

    //MealsCenter/merchant/food/Items/UpDate/Details/featuredSearchBox
    @FindBy(xpath="(//span[@role='combobox'])[2]")
    public WebElement featuredSearchBox;

    //MealsCenter/merchant/food/Items/UpDate/Details/bestSeller
    @FindBy(xpath="//span[text()='Best Seller']")
    public WebElement bestSeller;

    //MealsCenter/merchant/food/Items/UpDate/Details/backroundColorHex
    @FindBy(xpath="//input[@id='AR_item_color_hex']")
    public WebElement backroundColorHex;


    //MealsCenter/merchant/food/Items/UpDate/Details/pembeArkaYon
    @FindBy(xpath="//span[@style='background-color:rgb(244, 204, 204);']")
    public WebElement pembeArkaYon;

    //MealsCenter/merchant/food/Items/UpDate/Details/tamamButonu
    @FindBy(xpath="//button[text()='tamam']")
    public WebElement tamamButonu;

    //MealsCenter/merchant/food/Items/UpDate/Details/statusPublish
    @FindBy(xpath="//option[text()='Publish']")
    public WebElement statusPublish;

    //MealsCenter/merchant/food/Items/UpDate/Details/itemTranslationArtLogosu
    @FindBy(xpath="//i[@class='zmdi zmdi-plus']")
    public WebElement itemTranslationArtLogosu;


    //MealsCenter/merchant/food/Items/UpDate/Details/enterJapanesNameHereBoxu
    @FindBy(xpath="//input[@id='AR_item_item_name_translation_ja']")
    public WebElement enterJapanesNameHereBoxu;


    //MealsCenter/merchant/food/Items/UpDate/Details/itemsDetailsSaveButonu
    @FindBy(xpath="//input[@value='Save']")
    public WebElement itemsDetailsSaveButonu;


    //MealsCenter/merchant/food/Items/UpDate/Details/detailsSuccesfullyUpdatedYazisi
    @FindBy(xpath="//div[normalize-space()='Succesfully updated']")
    public WebElement detailsSuccesfullyUpdatedYazisi;



    //MealsCenter/merchant/food/Items/UpDate/priceButonu
    @FindBy(xpath="(//i)[14]")
    public WebElement priceButonu;


    //MealsCenter/merchant/food/Items/UpDate/priceUpdateButonu
    @FindBy(xpath="//i[@class='zmdi zmdi-border-color']")
    public WebElement priceUpdateButonu;


    ///MealsCenter/merchant/food/Items/UpDate/Price/updatePriceTakvim31martbutonu
    @FindBy(xpath="(//td[text()=31])[1]")
    public WebElement updatePriceTakvim31martbutonu;

    //MealsCenter/merchant/food/Items/UpDate/Price/UpdatePrice/SkuKutusu
    @FindBy(xpath="(//input[@type='text'])[6]")
    public WebElement SkuKutusu;

    ///MealsCenter/merchant/food/Items/UpDate/Price/PriceUpdatePriceSaveKutusu
    @FindBy(xpath="//input[@value='Save']")
    public WebElement PriceUpdatePriceSaveKutusu;

    ///MealsCenter/merchant/food/Items/UpDate/addon/addonSuccesfullyUpdatedYazisi
    @FindBy(xpath="//div[normalize-space()='Succesfully updated']")
    public WebElement priceSuccesfullyUpdatedYazisi;



    //MealsCenter/merchant/food/Items/UpDate/addonButonu
    @FindBy(xpath="(//i)[15]")
    public WebElement addonButonu;


    //MealsCenter/merchant/food/Items/UpDate/addon/requireAddonButonu
    @FindBy(xpath=" //label[@for='require_addon']")
    public WebElement requireAddonButonu;



    //MealsCenter/merchant/food/Items/UpDate/addon/artiTusu
    @FindBy(xpath="//i[@class='zmdi zmdi-plus']")
    public WebElement addonArtiTusu;


    //MealsCenter/merchant/food/Items/UpDate/addon/addonSelectItemPrice
    @FindBy(xpath="//select[@id='AR_item_addon_item_size_id']")
    public WebElement addonSelectItemPrice;

    //MealsCenter/merchant/food/Items/UpDate/Details/itemsDetailsSaveButonu
    @FindBy(xpath="//input[@value='Save']")
    public WebElement itemsAddonSaveButonu;

    //MealsCenter/merchant/food/Items/UpDate/addon/Please correct the forms yazisi//BUG var
    @FindBy(xpath="//div[@class='alert alert-danger']")
    public WebElement pleaseCorrectTheFormsYazisi;




    //MealsCenter/merchant/food/Items/UpDate/attributeButonu
    @FindBy(xpath=("//i)[16]"))
    public WebElement attributeButonu;

    //MealsCenter/merchant/food/Items/UpDate/attribute/pointsEarnedButonu
    @FindBy(xpath="//label[text()='Points earned']")
    public WebElement pointsEarnedButonu;



    //MealsCenter/merchant/food/Items/UpDate/avalabilityButonu
    @FindBy(xpath="(//i)[17]")
    public WebElement avalabilityButonu;


    //MealsCenter/merchant/food/Items/UpDate/avalability//monday
    @FindBy(xpath="//div[@class='custom-control custom-switch custom-switch-md mr-4'][4]")
    public WebElement avalabilityMondayButonu;


    //MealsCenter/merchant/food/Items/UpDate/inventoryButonu
    @FindBy(xpath="(//i)[18]")
    public WebElement inventoryButonu;

    //MealsCenter/merchant/food/Items/UpDate/inventorySkuKutusu
    @FindBy(xpath="//input[@class='form-control form-control-text']")
    public WebElement inventorySkuKutusu;

    //MealsCenter/merchant/food/Items/UpDate/inventory/itemsInventorySaveButonu;
    @FindBy(xpath="//input[@value='Save']")
    public WebElement itemsInventorySaveButonu;



    //MealsCenter/merchant/food/Items/UpDate/salesPromotionButonu
    @FindBy(xpath="(//i)[19]")
    public WebElement salesPromotionButonu;

    //MealsCenter/merchant/food/Items/UpDate/galleryButonu
    @FindBy(xpath="(//i)[20]")
    public WebElement galleryButonu;

    //MealsCenter/merchant/food/Items/UpDate/ceoButonu
    @FindBy(xpath="(//i)[21]")
    public WebElement ceoButonu;



    //Category Sayfasi ************************/////


    //MealsCenter/merchant/food/category/categoryYazisi
    @FindBy(xpath=" //h5[text()='Category List']")
    public WebElement categoryYazisi;


    //MealsCenter/merchant/food/category/categoryUpdateButonu
    @FindBy(xpath="//i[@class='zmdi zmdi-border-color']")
    public WebElement categoryUpdateButonu;

    //MealsCenter/merchant/food/category/categoryDeleteButonu
    @FindBy(xpath="//i[@class='zmdi zmdi-delete']")
    public WebElement categoryDeleteButonu;


    //MealsCenter/merchant/food/category/categoryAddNewYanindakiArtiTusu
    @FindBy(xpath="//i[@class='zmdi zmdi-plus']")
    public WebElement categoryAddNewYanindakiArtiTusu;


    //MealsCenter/merchant/food/category/update/details/nameKutucugu
    @FindBy(xpath="//input[@name='AR_category[category_name]']")
    public WebElement categoryUpdateDetailsNameKutucugu;

    // MealsCenter/merchant/food/category/update/details/dish
    @FindBy(xpath="//span[@role='combobox']")
    public WebElement categoryUpdateDetailsDishKutucugu;

    // MealsCenter/merchant/food/category/update/details/dish/meals
    @FindBy(xpath="//span[text()='Meals']")
    public WebElement categoryUpdateDetailsMealsKutucugu;


    ///MealsCenter/merchant/food/category/update/details/saveKutusu
    @FindBy(xpath="//input[@value='Save']")
    public WebElement categorySaveKutusu;

    ///MealsCenter/merchant/food/category/update/availability/AvailableAtSpecifiedTimes
    @FindBy(xpath="//div[@class='custom-control custom-switch custom-switch-md mr-4']")
    public WebElement availableAtSpecifiedTimes;


    ///MealsCenter/merchant/food/category/update/availability/availabilityMonday
    @FindBy(xpath="(//div[@class='custom-control custom-switch custom-switch-md mr-4'])[2]")
    public WebElement availabilityMonday;

    ///MealsCenter/merchant/food/category/update/availability/FromKutusu
    @FindBy(xpath="//input[@class='form-control form-control-text timepick datetimepicker-input'][1]")
    public WebElement fromKutusu;

    //MealsCenter/merchant/food/category/update/availability/ToKutusu
    @FindBy(xpath="//input[@class='form-control form-control-text timepick datetimepicker-input'][2]")
    public WebElement toKutusu;

    //MealsCenter/merchant/food/category/update/availability/saveKutusu
    @FindBy(xpath="//input[@value='Save']")
    public WebElement availabilityCategorySaveKutusu;


    @FindBy(xpath="//a[text()='Category']")
    public WebElement categoryLinki;


    @FindBy(xpath="//span[@class='selection']")
    public WebElement CategoryDdm;

    @FindBy(xpath="(//div[@class='col-4 text-right']//button)[1]")
    public WebElement categoryBrowse;

    @FindBy(xpath="//span[@class='selection']")
    public WebElement CategoryDish;

    @FindBy(xpath="//div[@class='btn-group pull-right notification-dropdown show']")
    public WebElement zilTusu;


    @FindBy(xpath="(//div[@class='file_wrapper']//li)[12]")
    public WebElement burittoCombo2;

    @FindBy(xpath="(//div[@class='col-4 text-right']//button)[2]")
    public WebElement categoryBrowse2;

    @FindBy(xpath="(//span[text()='Add Files'])[2]")
    public WebElement addFile2;

    @FindBy(xpath="//div[@class='col-4 text-right']//button")
    public WebElement itemBrowse;

























}
