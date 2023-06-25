package pages.userMealscenter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class UserStorePage {

    //!!!!!!!!! KOD YAZMADAN ÖNCE KENDİ BRANCH'İNDE OLDUĞUNDAN EMİN OL !!!!!!!!!!!!!!!!!!!!
    //!!!!!!!!! KOD YAZMADAN ÖNCE KENDİ BRANCH'İNDE OLDUĞUNDAN EMİN OL !!!!!!!!!!!!!!!!!!!!
    //!!!!!!!!! KOD YAZMADAN ÖNCE KENDİ BRANCH'İNDE OLDUĞUNDAN EMİN OL !!!!!!!!!!!!!!!!!!!!

    //!!!!!!!! MAİN BRANCH'DE YAPACAĞIMIZ TEK İŞLEM PULL ETMEK !!!!!!!!!!!!!!!
    //!!!!!!!! MAİN BRANCH'DE YAPACAĞIMIZ TEK İŞLEM PULL ETMEK !!!!!!!!!!!!!!!
    //!!!!!!!! MAİN BRANCH'DE YAPACAĞIMIZ TEK İŞLEM PULL ETMEK !!!!!!!!!!!!!!!

    public UserStorePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    //userProfilPage > LaPalmera seç/LaPalmeraYazisi
    @FindBy(xpath = "(//div[@class='w-50 align-self-center'])[1]")
    public WebElement laPalmeraYazisi;

    //userProfilPage > LaPalmera//urungorselleri
    @FindBy (xpath = "//div[@class='item-image-preview']")
    public WebElement urunGorseli;

    //userProfilPage > LaPalmera / urungorselleri listesi
    public List<WebElement> urunGorselList(){
        List<WebElement> urunGorselleriListesi=Driver.getDriver().
                findElements(By.xpath("//div[@class='item-image-preview']"));
        return urunGorselleriListesi;
    }

    //userProfilPage > LaPalmera / kaçıncı ürünün gorselini seçmek istiyorsak
    public WebElement getUrunGorseli (int sayi){
        WebElement istenenUrunGorseli = Driver.getDriver().
                findElement(By.xpath("(//div[@class='item-image-preview'])["+sayi+"]"));
        return istenenUrunGorseli;
    }

    //userProfilPage > LaPalmera / urun acıklamaları
    @FindBy (xpath = "//div/p/span")
    public WebElement urunAciklamasi;

    //userProfilPage > LaPalmera / urun acıklamaları listesi
    public List<WebElement> urunAciklamaList(){
        List<WebElement> urunAciklamalariListesi=Driver.getDriver().
                findElements(By.xpath("//div/p/span"));
        return urunAciklamalariListesi;
    }


    ////userProfilPage > LaPalmera / urun Fiyatları
    @FindBy (xpath = "//div[@class='btn-group btn-group-toggle input-group-small']")
    public WebElement urunFiyati;

    //userProfilPage > LaPalmera / urun acıklamaları listesi
    public List<WebElement> urunFiyatlariListesi(){
        List<WebElement> urunFiyatlariListesi=Driver.getDriver().
                findElements(By.xpath("//div[@class='btn-group btn-group-toggle input-group-small']"));
        return urunFiyatlariListesi;
    }



    //userProfilPage > LaPalmera / Add To Cart listesi
    public List<WebElement> addToCartList(){
        List<WebElement> addToCartListesi=Driver.getDriver().
                findElements(By.xpath("//a[text()=' Add to cart ']"));
        return addToCartListesi;
    }

    //userProfilPage > LaPalmera / kaçıncı ürünün Add To Cart butonunu seçmek istiyorsak
    public WebElement getUrunAddToCartButon (int sayi){
        WebElement istenenUrunAddToCartButon = Driver.getDriver().
                findElement(By.xpath("(//a[text()=' Add to cart '])["+sayi+"]"));
        return istenenUrunAddToCartButon;
    }

    //userProfilPage > LaPalmera >sepete ürün ekledikten sonra checkout butonu
    @FindBy(xpath = "//a[@class='btn btn-green w-100 pointer d-flex justify-content-between']")
    public WebElement checkoutButon;

    public void istenenUrunAddToCartClick(int sayi){
        String dinamikXpath ="(//a[text()=' Add to cart '])["+sayi+"]";
        Driver.getDriver().findElement(By.xpath(dinamikXpath)).click();
    }


    // add To Cart butonu görünüyor  mu test etmek için Assert içinde çağırılacak method
    public boolean addToCartGorunurlugu (int sayi){
        String dinamikXpath ="(//a[text()=' Add to cart '])["+sayi+"]";
        WebElement istenenAddToCartButton=Driver.getDriver().findElement(By.xpath(dinamikXpath));
        return istenenAddToCartButton.isDisplayed();
    }

    public int sepeteEklenmisUrunGorseliSayisi(){
        List<WebElement> urunGorselleri =Driver.
                getDriver().findElements(By.xpath("//div[@class='el-image']"));
        return urunGorselleri.size();
    }

    @FindBy(xpath = "//*[@id='vue-feed']/div[4]/div[2]/div[3]/div/div[3]")
    public List<WebElement> reatorantLocations;

    @FindBy(xpath = "//label[@for='cuisine1']")
    public WebElement cuisinesAmericanDropbox;

    @FindBy(xpath = "//label[@for='cuisine8']")
    public WebElement cuisinesItalianDropbox;

}
