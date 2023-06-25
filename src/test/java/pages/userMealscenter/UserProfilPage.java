package pages.userMealscenter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class UserProfilPage {

    //!!!!!!!!! KOD YAZMADAN ÖNCE KENDİ BRANCH'İNDE OLDUĞUNDAN EMİN OL !!!!!!!!!!!!!!!!!!!!
    //!!!!!!!!! KOD YAZMADAN ÖNCE KENDİ BRANCH'İNDE OLDUĞUNDAN EMİN OL !!!!!!!!!!!!!!!!!!!!
    //!!!!!!!!! KOD YAZMADAN ÖNCE KENDİ BRANCH'İNDE OLDUĞUNDAN EMİN OL !!!!!!!!!!!!!!!!!!!!

    //!!!!!!!! MAİN BRANCH'DE YAPACAĞIMIZ TEK İŞLEM PULL ETMEK !!!!!!!!!!!!!!!
    //!!!!!!!! MAİN BRANCH'DE YAPACAĞIMIZ TEK İŞLEM PULL ETMEK !!!!!!!!!!!!!!!
    //!!!!!!!! MAİN BRANCH'DE YAPACAĞIMIZ TEK İŞLEM PULL ETMEK !!!!!!!!!!!!!!!

    public UserProfilPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    //userProfilPage / kullanıcı isminin göründüğü yer
    @FindBy(xpath = "//li[@class='d-none d-lg-inline']")
    public WebElement kullaniciIsim;

    //UserProfilPage / adresSearchBox
    @FindBy(xpath = "(//input[@class='form-control form-control-text'])[1]")
    public WebElement adresSearchBox;

    //userProfilPage > searchBox'a Seattle yazdıktan sonra seçilecek Seattle adresi
    @FindBy (xpath="//h6[@class='m-0']")
    public WebElement seattleAdres;


    //userProfilPage > searchBox'a Seattle yazıp Seattle Seçtikten sonra çıkan Restaurantlar listesi
    public List<WebElement> restaurantlarListesi(){
        List<WebElement> restaurantlarListesi = Driver.getDriver()
                .findElements(By.xpath("//div[@class='el-image']"));

        return restaurantlarListesi;
    }

    // userProfilPage > searchBox'a Seattle yazıp SeattleSeçtikten sonra > LaPalmera Restaurantı
    @FindBy (xpath = "(//div[@class='el-image'])[2]")
    public WebElement laPalmera;

    // userProfilPage > searchBox'a Seattle yazıp SeattleSeçtikten sonra > LaPalmera Restaurantı >İstediğiniz ürünü sepete ekleme
    public void urunSepeteEkle(int urunNo){

        String dinamikXPath="(//a[@class='btn btn-grey quantity-add-cart'])["+urunNo+"]";
        Driver.getDriver().findElement(By.xpath(dinamikXPath)).click();
    }

    // userProfilPage > searchBox'a Seattle yazıp SeattleSeçtikten sonra > LaPalmera Restaurantı >Checkout Butonu
    @FindBy(xpath = "//a[@class='btn btn-green w-100 pointer d-flex justify-content-between']")
    public WebElement checkoutButton;

    // userProfilPage > LaPalmera Restaurantı >Checkout Butonu > Promotion Button
    @FindBy(xpath = "(//div[@class='flexcol'])[3]")
    public WebElement promotionButton;

    // userProfilPage > LaPalmera Restaurantı >Checkout Butonu > Promotion Button >La Palmera Promo
    @FindBy(xpath = "(//input[@type='radio'])[8]")
    public WebElement promotionLaPalmeraButton;

    // userProfilPage > LaPalmera Restaurantı >Checkout Butonu > Promotion Button >Save butonu
    @FindBy(xpath = "(//button[@class='btn btn-green w-100'])[5]")
    public WebElement saveButton;

    // userProfilPage > LaPalmera Restaurantı >Checkout Butonu > Promotion Button >Payment cash şekli
    @FindBy(xpath = "(//button[@class='btn btn-green w-100'])[5]")
    public WebElement cashPaymentLink;

    // userProfilPage > LaPalmera Restaurantı >Checkout Butonu > Promotion Button >Payment cash şekli > Add Cash butonu
    @FindBy(xpath = "(//button[@class='btn btn-green w-100'])[9]")
    public WebElement addCashButton;

    // userProfilPage > LaPalmera Restaurantı >Checkout Butonu > Promotion Button > Place order Butonu
    @FindBy(xpath = "//button[@class='btn btn-green w-100 pointer']")
    public WebElement placeOrderButton;

    // userProfilPage > LaPalmera Restaurantı > Seçilen ürün fiyatı
    @FindBy(xpath = "//div[text()='14.00$']")
    public WebElement indirimsizUrunFiyati;

    // userProfilPage > LaPalmera Restaurantı > Seçilen ürün fiyatı
    @FindBy(xpath = "//p[@class='m-0 mb-1']")
    public WebElement indirimliUrunFiyati;

    @FindBy(xpath = "//input[@id='location_name']")
    public WebElement adresLocationNameBox;

    @FindBy(xpath = "//*[@class='form-control custom-select']")
    public WebElement adresDeliveryOptionsSecimi;

    @FindBy(xpath = "//*[@id='delivery_instructions']")
    public WebElement adresAddDeliveryInstructionsBox;

    @FindBy(xpath = "//*[@class='btn']")
    public List<WebElement> addresLabel;

    @FindBy(xpath = "//span[text()='Save']")
    public WebElement adresSaveButton;

    @FindBy(xpath = "(//a[@class='btn btn-green'])[1]")
    public WebElement addNewAddressButton;

    @FindBy(xpath = "(//*[@class='form-control form-control-text'])[1]")
    public WebElement enterDeliveryAddressBox;

    @FindBy(xpath = "(//div[@class='search-geocomplete-results']//*[@class='m-0'])[1]")
    public WebElement enterDeliveryAddressIlkSonuc;

    @FindBy(xpath = "//div[@class='module truncate-overflow']")
    public WebElement addressText;

    @FindBy(xpath = "//div[@class='module truncate-overflow']")
    public List<WebElement> kayitliAdresler;

    @FindBy(xpath = "(//a[text()='Delete'])[1]")
    public WebElement deleteFirstAddress;

    @FindBy(xpath = "//button[text()='Yes']")
    public WebElement addressDeleteYes;

    @FindBy(xpath = "//a[@class='btn normal small']")
    public WebElement addressEdit;

    @FindBy(xpath = "//button[text()='Adjust pin']")
    public WebElement addressAdjustPin;

    @FindBy(xpath = "//img[@*='https://maps.gstatic.com/mapfiles/transparent.png']")
    public WebElement haritaPin;


    public int secilenUrunFiyat(WebElement element){
        String urunStr= element.getText();
        urunStr=urunStr.replaceAll("\\D","");
        int urunInt=Integer.parseInt(urunStr);

        return urunInt;
    }

    //***********CART SAYFASI LOCATE************//

    //cart/sepete eklenen 1. ürünün isim elementi
    @FindBy (xpath = "(//p[@class='mb-1'])[1]")
    public WebElement sepettekiIlkUrunIsmi;

    //cart/sepete eklenen 2. ürünün isim elementi
    @FindBy (xpath = "(//p[@class='mb-1'])[2]")
    public WebElement sepettekiIkinciUrunIsmi;

    //cart/sepetteki ilk urunun miktar elementi
    @FindBy (xpath = "(//div[@class='qty'])[2]")
    public WebElement sepetteUrunMiktari;

    //cart/sepetteki ilk urun fiyat elementi
    @FindBy (xpath = "//p[@class='mb-0']")
    public WebElement sepettekiUrunFiyati;

    //cart/sepetteki toplam tutar elementi
    @FindBy (xpath = "(//h6[@class='m-0'])[3]")
    public WebElement sepettekiToplamTutar;

    //cart/Order type and Time bölüm başlık elementi
    @FindBy (xpath = "(//h5[@class='m-0 ml-2 section-title'])[1]")
    public WebElement orderTypeAndTimeBaslik;

    //cart/Choose a delivery address bölüm başlık elementi
    @FindBy (xpath = "(//h5[@class='m-0 ml-2 section-title'])[2]")
    public WebElement chooseAdeliveryAdressBaslik;

    //cart/Payment Methods bölüm başlık elementi
    @FindBy (xpath = "(//h5[@class='m-0 ml-2 section-title'])[3]")
    public WebElement paymentMethodBaslik;

    //cart/ clear butonu
    @FindBy (xpath = "//u[text()='Clear']")
    public WebElement clearButon;

    // cart / order type and time/ delivery elementi
    @FindBy(xpath = "//div[@id='vue-transaction']")
    public WebElement deliveryButon;

    // cart / order type and time/ telefon elementi
    @FindBy (xpath = "//div[@id='vue-contactphone']")
    public WebElement phoneButon;

    // cart / order type and time/ promotion elementi
    @FindBy (xpath = "//div[@id='vue-promo']")
    public WebElement promotionButon;

    // cart / order type and time/ promotion elementi
    @FindBy (xpath = "(//a[@class='d-block chevron-section promo-section d-flex align-items-center rounded mb-2'])[2]")
    public WebElement promotionButon2;
    //

    // cart / order type and time /delivery > delivery radio button
    @FindBy (xpath = "(//label[@class='custom-control-label font14 bold'])[1]")
    public WebElement deliveryRadio;

    // cart / order type and time /delivery > dinein radio button
    @FindBy (xpath = "(//label[@class='custom-control-label font14 bold'])[2]")
    public WebElement dineInRadio;

    // cart / order type and time /delivery > pickup radio button
    @FindBy (xpath = "(//label[@class='custom-control-label font14 bold'])[3]")
    public WebElement pickUpRadio;

    // cart / order type and time /delivery > çarpı buton
    @FindBy (xpath = "(//i[@class='zmdi zmdi-close font20'])[2]")
    public WebElement deliverySecenekleriKapatmaButonu;

    // cart / order type and time /delivery > save buton
    @FindBy (xpath = "(//button[@class='btn btn-green w-100'])[2]")
    public WebElement deliverySecenekleriSaveButonu;

    // cart / order type and time /delivery > schedule for later buton
    @FindBy (xpath = "(//label[@class='btn'])[1]")
    public WebElement ScheduleButonu;

    // cart / order type and time /delivery > now buton
    @FindBy (xpath = "//input[@value='now']")
    public WebElement NowButonu;

    // cart / order type and time /delivery > tarih box
    @FindBy (xpath = "//select[@class='form-control custom-select mb-3']")
    public WebElement tarihBox;

    // cart / order type and time /delivery > tarih box/seçilecek tarih elementi
    @FindBy (xpath = "//option[@value='2023-03-31']")
    public WebElement tarihElementi;


    // cart / order type and time /delivery > saat box
    @FindBy (xpath = "//select[@id='delivery_time']")
    public WebElement saatBox;

    // cart / order type and time /delivery > tarih box/seçilecek saat elementi
    @FindBy (xpath = "//option[text()='1:15 AM - 1:30 AM']")
    public WebElement saatElementi;

    //cart / order type and time /delivery / bisikletgorseli
    @FindBy (xpath = "//i[@class='fas fa-biking']")
    public WebElement bisiklet;

    //cart / order type and time /delivery / sandalye gorseli
    @FindBy (xpath = "//i[@class='fas fa-chair']")
    public WebElement sandalye;

    //cart / order type and time /delivery / adam gorseli
    @FindBy (xpath = "//i[@class='fas fa-walking']")
    public WebElement adam;

    //cart / order type and time /delivery / teslimat zamanı yazı elementi
    @FindBy (xpath = "//p[text()='Schedule for later ']")
    public WebElement teslimatZamanYazisi;

    //cart / order type and time / phone > telefon numarası girilen alan
    @FindBy (xpath = "(//input[@type='text'])[1]")
    public WebElement telefonYazBox;

    //cart / order type and time / phone > continue
    @FindBy (xpath = "//span[text()='Continue']")
    public WebElement editNumberContinue;

    //cart / order type and time / phone > maile kod gönderilince çıkan yazı
    @FindBy (xpath = "//p[text()='Enter 6-digit code']")
    public WebElement weSentACodeYazi;

    //cart / order type and time / phone > çarpı elementi
    @FindBy (xpath = "(//i[@class='zmdi zmdi-close font20'])[4]")
    public WebElement editNumberKapatma;

    //cart / order type and time / promotion > seçilecek ilk kupon
    @FindBy (xpath = "(//label[@class='custom-control-label font14 bold'])[4]")
    public WebElement secilecekKupon;

    //cart / order type and time / promotion > save butonu
    @FindBy (xpath = "(//button[@class='btn btn-green w-100'])[5]")
    public WebElement promotionSave;

    //cart / order type and time / promotion / promotion applied yazısı
    @FindBy (xpath = "(//div[@class='flexcol'])[3]")
    public WebElement promotionDurumYazisi;

    //cart / order type and time / promotion > remove element
    @FindBy (xpath = "//span[text()='Remove']")
    public WebElement remove;


    //cart / choose a delivery address / add new address butonu
    @FindBy (xpath = "//span[@class='bold d-none d-md-block']")
    public WebElement addNewAddress;

    //cart /choose a delivery address / add new address>adres searchBox
    @FindBy (xpath = "(//input[@class='form-control form-control-text'])[4]")
    public WebElement enterDeliveryAddress;

    //cart / choose a delivery address / add new address>adres searchBox>adres yaz/ilk sıradaki element
    @FindBy (xpath = "(//li/a/h6)[1]")
    public WebElement ilksiradakiAdres;

    //cart / choose a delivery address>adres seç>adjust pin butonu
    @FindBy (xpath = "//button[@class='btn small btn-black']")
    public WebElement adjustPin;

    //cart / choose a delivery address>adres seç>adjust pin> harita elementi
    @FindBy (xpath = "//div[@aria-label='Harita']")
    public WebElement harita;

    //cart / choose a delivery address>adres seç>adjust pin> saveButton
    @FindBy (xpath = "(//div[@class='border flex-fill'])[4]")
    public WebElement haritaPinSave;

    //cart / choose a delivery address>seçili adres elementi
    @FindBy (xpath = "//span[@class='bold mr-1']")
    public WebElement seciliAdres;

    //cart / payment methods >saved payment methods yazısı
    @FindBy (xpath = "//h5[@class='mb-3']")
    public WebElement savedPaymentMethodYazisi;

    //cart / payment methods >saved payment methods/ method silmek için 3 nokta elementi
    @FindBy (xpath = "//i[@class='zmdi zmdi-more']")
    public WebElement odemeMetoduSilme;


    //cart / payment methods >saved payment methods/ method silmek için 3 nokta > delete
    @FindBy (xpath = "//a[@class='dropdown-item a-12']")
    public WebElement odemeMetoduDelete;

    //cart / payment methods >add new payment methods/ cash on delivery button
    @FindBy (xpath = "(//span[text()='Cash On delivery'])[1]")
    public WebElement cashOnDelivery1;

    //cart / payment methods >add new payment methods/ stripe button
    @FindBy (xpath = "(//span[@class='mr-1'])[4]")
    public WebElement stripe;

    //cart / payment methods >add new payment methods/ cash on delivery > add cash button
    @FindBy (xpath = "(//button[@class='btn btn-green w-100'])[9]")
    public WebElement addCash;

    //cart / payment methods >add new payment methods/ stripe button > kart no giriş
    @FindBy (xpath = "//span[@class='CardField-number CardField-child']")
    public WebElement kartNoYaz;

    @FindBy(xpath = "(//span[@class='InputContainer'])[2]")
    public WebElement kartSonKullanim;


    @FindBy(xpath = "(//span[@class='InputContainer'])[3]")
    public WebElement cvc;


    @FindBy(xpath = "(//span[@class='InputContainer'])[]")
    public WebElement zipCode;

    //cart / payment methods >add new payment methods/ stripe button > add stripe button
    @FindBy (xpath = "(//button[@class='btn btn-green w-100'])[10]")
    public WebElement addStripe;

    //cart / payment methods >saved payment methods/ stripe ekli mi
    @FindBy (xpath = "//div[@class='row no-gutters align-items-center chevron-section medium rounded mb-2 selected']")
    public WebElement eklenmisStripe;

    //cart / payment methods >saved payment methods/ cash ekli mi
    @FindBy (xpath = "//div[@class='col-lg-8 col-md-8 col-10 d-flex align-items-center']")
    public WebElement eklenmisCash;

    //cart / placeholder button
    @FindBy (xpath = "//span[text()='Place Order']")
    public WebElement placeHolder;

    //cart / placeholder > oluşturulmuş sipariş yazısı
    @FindBy (xpath = "(//p[@class='m-0 mb-1 bold'])[1]")
    public WebElement orderYazi;

    /*******************PAYMENT(ODEME) DROPDOWN*******************/

    //userProfilPage >Profil>DropDown logout Butonu
    @FindBy (xpath = "//a[@class='dropdown-item with-icon-logout']")
    public WebElement logoutButton;

    //userProfilPage >Profil>PaymentOptions Butonu
    @FindBy (xpath = "//a[@class= 'dropdown-item with-icon-payments'] ")
    public WebElement paymentOptions;

    //userProfilPage >Profil>Payment Opsions>Add New Payment Butonu
    @FindBy (xpath = "(//a[@class='btn btn-green'])[1]")
    public WebElement addNewPaymont;

    //userProfilPage >Profil>Payment Opsions
    @FindBy (xpath = "(//div[@class='flexcol'])[1]")
    public WebElement cashOnDeliveryButton;

    //userProfilPage >Profil>Payment Opsions
    @FindBy(xpath = "//div[@class='dropdown userprofile']")
    public WebElement profilButton;

    //userProfilPage >Profil>Payment Opsions
    @FindBy(xpath = "//img[@class='img-35']")
    public WebElement stripeButton;

    //userProfilPage >Profil>Payment Opsions
    @FindBy(xpath = "(//input[@class='InputElement is-empty Input Input--empty'])[1]")
    public WebElement krediKartiNo;

    //userProfilPage >Profil>Payment Opsions
    @FindBy(xpath = "/(//input[@class='InputElement is-complete Input'])[2]")
    public WebElement krediKartiSonKullanmaTarihi;

    //userProfilPage >Profil>Payment Opsions
    @FindBy(xpath = "/(//input[@class='InputElement is-complete Input'])[3]")
    public WebElement krediKartiCvcNo;

    //userProfilPage >Profil>Payment Opsions
    @FindBy(xpath = "/(//input[@class='InputElement is-complete Input'])[4]")
    public WebElement postaKodu;

    //userProfilPage >Profil>Payment Opsions KKarti Ekle butonu
    @FindBy(xpath = "(//button[@class='btn btn-green w-100'])[2]")
    public WebElement addStrRipe;

    //userProfilPage >Profil>Payment Opsions
    @FindBy(xpath = "(//*[@class='ml-2'][1]")
    public WebElement stripeBasariliEkleme;

    //userProfilPage >Profil>Payment Opsions
    @FindBy(xpath = "(//*[@class='ml-2'])[2]")
    public WebElement cashBasariliEkleme;

    @FindBy(xpath = "(//*[@class='ml-2'])[2]")
    public WebElement BasarisizKKartiBilgi;

    //userProfilPage >Profil>Payment Opsions
    @FindBy(xpath = "(//a[@class='btn normal small'])[1]")
    public WebElement kKartiEditButonu;


    //userProfilPage >Profil>Payment Opsions
    @FindBy(xpath = "(//a[@class='btn normal small'])[2]")
    public WebElement kKartiDeleteButonu;

    //userProfilPage >Profil>Payment Opsions
    @FindBy(xpath = "(//a[@class='btn normal small'])[3]")
    public WebElement cashEditButonu;

    //userProfilPage >Profil>Payment Opsions
    @FindBy(xpath = "(//a[@class='btn normal small'])[4]")
    public WebElement cashDeleteButonu;

    //userProfilPage >Profil>Payment Opsions>Kredi karti ödeme bilgisi
    @FindBy(xpath = "(//div[@class='card p-3 fixed-height card-listing'])[1]")
    public WebElement krediKartıEklendiMenusu;

    //userProfilPage >Profil>Payment Opsions>Nakit ödeme bilgisi
    @FindBy(xpath = "(//div[@class='card p-3 fixed-height card-listing'])[2]")
    public WebElement cashOdemeEklendiMenusu;


    /*******************PROFİL SAVES STORES(KAYİTLİ RESTORANT DROPDOWN*******************/

    //userProfilPage >Profil>DropDown Saves Stores(Kayitli Restorant)
    @FindBy (xpath = "//a[@class='dropdown-item with-icon-savedstore']")
    public WebElement savedStoresDropDown;


    //userProfilPage >Profil>DropDown Saves Stores(Kayitli Restorant)>Order Now Buton
    @FindBy (xpath = "(//a[@class='btn btn-green'])[1]")
    public WebElement orderNownButton;


    //userProfilPage >Profil>Saved Stored>La Palmera/Kalp Emoji
    @FindBy(xpath = "(//div[@class='col col-md-auto text-right'])[1]")
    public WebElement lapalmeraKalpEmoji;

    //userProfilPage >Profil>Saved Stored>StarBucks/Kalp Emoji
    @FindBy(xpath = "(//div[@class='col col-md-auto text-right'])[3]")
    public WebElement starBucksKalpEmoji;

    //userProfilPage >Profil>Saved Stored>McDonalds/Kalp Emoji
    @FindBy(xpath = "(//div[@class='col col-md-auto text-right'])[5]")
    public WebElement mcDonaldsKalpEmoji;



    //userProfilPage >Profil>DropDown Saves Stores(Kayitli Restorant)lar Logosu
    @FindBy(xpath = "(//img[@class='el-image__inner'])[1]")
    public WebElement mcDonaldsMenuLogo;


    //userProfilPage >Profil>Saved Stored>La Palmera/Kalp Emoji
    @FindBy(xpath = "(//img[@class='el-image__inner'])[2]")
    public WebElement lapalmeraMenuLogo;

    //userProfilPage >Profil>Saved Stored>StarBucks/Kalp Emoji
    @FindBy(xpath = "(//img[@class='el-image__inner'])[3]")
    public WebElement starBucksMenuLogo;


    /*******************SEPETE MENU EKLEME*******************/

    @FindBy (xpath = " (//*[@class='m-0 text-truncate'])[1]")
    public WebElement starbucksButton;

    @FindBy (xpath = "  (//a[@class='btn btn-grey xget-item-details'])[1]")
    public WebElement starbucksCoffee;

    @FindBy (xpath = "(//span[@class='label'])[8]")
    public WebElement addeToCart;

    @FindBy (xpath = " (//div[@class='flex-col'])[1]")
    public WebElement checkOutButton;

    @FindBy (xpath = "(//button[@class='btn btn-green w-100'])")
    public WebElement addTocashButton;

    //MealsCenter/HomePage >Basket/Summary text
    @FindBy(xpath = " (//*[@class='m-0'])[6]")//
    public WebElement summaryText;

    @FindBy(xpath = "//img[@src='/themes/karenderia_v2/assets/images/shopping-bag.svg']")
    public WebElement basketLogo;

    @FindBy (xpath = " (//*[@class='m-0 text-truncate'])[2]")
    public WebElement mcDonaltsButton;

}
