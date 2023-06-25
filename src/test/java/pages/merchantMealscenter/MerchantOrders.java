package pages.merchantMealscenter;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class MerchantOrders {

    //!!!!!!!!! KOD YAZMADAN ÖNCE KENDİ BRANCH'İNDE OLDUĞUNDAN EMİN OL !!!!!!!!!!!!!!!!!!!!
    //!!!!!!!!! KOD YAZMADAN ÖNCE KENDİ BRANCH'İNDE OLDUĞUNDAN EMİN OL !!!!!!!!!!!!!!!!!!!!
    //!!!!!!!!! KOD YAZMADAN ÖNCE KENDİ BRANCH'İNDE OLDUĞUNDAN EMİN OL !!!!!!!!!!!!!!!!!!!!

    //!!!!!!!! MAİN BRANCH'DE YAPACAĞIMIZ TEK İŞLEM PULL ETMEK !!!!!!!!!!!!!!!
    //!!!!!!!! MAİN BRANCH'DE YAPACAĞIMIZ TEK İŞLEM PULL ETMEK !!!!!!!!!!!!!!!
    //!!!!!!!! MAİN BRANCH'DE YAPACAĞIMIZ TEK İŞLEM PULL ETMEK !!!!!!!!!!!!!!!

    public MerchantOrders(){

        PageFactory.initElements(Driver.getDriver(),this);
    }


    // NEW ORDERS KISMI


    //MealsCenter/merchant/ordersButonu
    @FindBy(xpath ="(//a[@href='javascript:;'])[2]")
    public WebElement ordersButonu;


    //MealsCenter/merchant/newOrdersButonu
    @FindBy(xpath ="//a[text()='New Orders']")
    public WebElement newOrdersButonu;


    //MealsCenter/merchant/newOrdersYazisi
    @FindBy(xpath ="//h5[text()='New Orders']")
    public WebElement newOrdersYazisi;


    //MealsCenter/merchant/newOrdersSayfasi/acceptedButonu
    @FindBy(xpath ="//span[text()='Accepted']")
    public WebElement newOrdersAcceptedButonu;


    //MealsCenter/merchant/newOrdersSayfasi/rejectButonu
    @FindBy(xpath ="//span[text()='Reject']")
    public WebElement newOrdersRejectButonu;


    //MealsCenter/merchant/newOrdersSayfasi/PrintYazisi
    @FindBy(xpath="//button[text()='Print']")
    public WebElement  newOrdersPrintYazisi;


    //MealsCenter/merchant/newOrdersSayfasi/OrderTypeFiltresi
    @FindBy(xpath="//div[text()='Order type']")
    public WebElement newOrdersOrderTypeFiltresi;


    //MealsCenter/merchant/newOrdersSayfasi/deliveryFiltresi
    @FindBy(xpath="(//div[@class='filter-option-inner-inner'])[1]")
    public WebElement newOrdersDeliveryFiltresi;


    //MealsCenter/merchant/newOrdersSayfasi/ dineinFiltresi
    @FindBy(xpath="//span[text()='Dinein']")
    public WebElement  newOrdersDineinFiltresi;


    //MealsCenter/merchant/newOrdersSayfasi/ pickupFiltresi
    @FindBy(xpath="//span[text()='Pickup']")
    public WebElement  newOrderspickupFiltresi;


    //MealsCenter/merchant/newOrdersSayfasi/paymentStatus
    @FindBy(xpath="//div[text()='Payment status']")
    public WebElement  newOrderspaymentStatus;


    //MealsCenter/merchant/newOrdersSayfasi/paymentStatusPaid
    @FindBy(xpath="//span[text()='Paid']")
    public WebElement  paymentDropDown;


    //MealsCenter/merchant/newOrdersSayfasi/unpaidDropDown
    @FindBy(xpath="//span[text()='Unpaid']")
    public WebElement  newOrdersUnpaidDropDown;


    //MealsCenter/merchant/newOrdersSayfasi/failedDropDown
    @FindBy(xpath=  "//span[text()='Failed']")
    public WebElement  newOrdersFailedDropDown;


    //MealsCenter/merchant/newOrdersSayfasi/pendingDropDown
    @FindBy(xpath="   //span[text()='Pending']")
    public WebElement  newOrdersPendingDropDown;


    //MealsCenter/merchant/newOrdersSayfasi/cancelledDropDown
    @FindBy(xpath= "//span[text()='Cancelled']")
    public WebElement  newOrdersCancelledDropDown;


    //MealsCenter/merchant/newOrdersSayfasi/sort
    @FindBy(xpath="//div[text()='Sort']")
    public WebElement  sort;


    //MealsCenter/merchant/newOrdersSayfasi/newOrdersSayfasiOrder ID - Ascending
    @FindBy(xpath="//span[text()='Order ID - Ascending']")
    public WebElement  newOrdersSayfasisortOrderIDAscending;


    //MealsCenter/merchant/newOrdersSayfasi/newOrdersSayfasiOrder ID - Descending
    @FindBy(xpath ="//span[text()='Order ID - Descending']")
    public WebElement  newOrdersSayfasiOrderIDDescending;


    //MealsCenter/merchant/newOrdersSayfasi/newOrdersSayfasiDeliveryTimeAscending
    @FindBy(xpath="//span[text()='Delivery Time - Ascending']")
    public WebElement newOrdersSayfasiDeliveryTimeAscending;


    //MealsCenter/merchant/newOrdersSayfasi/newOrdersSayfasiDeliveryTimeDescending
    @FindBy(xpath= "//span[text()='Delivery Time - Descending']")
    public WebElement  newOrdersSayfasiDeliveryTimeDescending;


    //MealsCenter/merchant/newOrdersSayfasi/assignDriverButonu
    @FindBy(xpath = "//button[text()='Assign Driver']")
    public WebElement  assignDriverButonu;


    //MealsCenter/merchant/newOrdersSayfasi/ucNoktaButonu
    @FindBy(xpath ="(//a[@id='dropdownMenuLink'])[1]")
    public WebElement  ucNoktaButonu;


    //MealsCenter/merchant/newOrdersSayfasi/contactCustomer
    @FindBy(xpath="//a[text()='Contact customer']")
    public WebElement contactCustomer;


    //MealsCenter/merchant/newOrdersSayfasi/timeLine
    @FindBy(xpath="//a[text()='Timeline']")
    public WebElement timeLine;


    //MealsCenter/merchant/newOrdersSayfasi/pdf
    @FindBy(xpath="//a[text()='Download PDF (A4)']")
    public WebElement pdf;


    //MealsCenter/merchant/newOrdersSayfasi/acceptOrdersYazisi
    @FindBy(xpath="//div[text()='Accepting Orders']")
    public WebElement acceptOrdersYazisi;


    //MealsCenter/merchant/newOrdersSayfasi/acceptOrdersYazisiAltindakiSecenek
    @FindBy(xpath="(//button[text()='10 min(s)'])[1]")
    public WebElement acceptOrdersYazisiAltindakiSecenek;


    //MealsCenter/merchant/newOrdersSayfasi/searchBox
    @FindBy(xpath="//input[@type='search']")
    public WebElement newOrdersSearchBox;


    // COMPLETED KISMI


    //MealsCenter/backoffice/orders/completed
    @FindBy(xpath = "//a[@href=\"/backoffice/orders/completed\"]")
    public WebElement completedButonu;


    //MealsCenter/backoffice/orders/completed/Accepting orders butonu
    @FindBy(xpath = "//div[text()='Accepting Orders']")
    public WebElement completedAcceptingOrdersButonu;


    //MealsCenter/backoffice/orders/completed/Search kısmı
    @FindBy(xpath = "//input[@type='search']")
    public WebElement completedSearchButonu;


    //MealsCenter/backoffice/orders/completed/order type butonu
    @FindBy(xpath = "//div[text()='Order type']")
    public  WebElement completedOrderTypeButonu;


    //MealsCenter/backoffice/orders/completed/order type butonu altında bulunan delivery filtresi
    @FindBy(xpath = "(//span[text()='Delivery'])[1]")
    public  WebElement completedDeliveryFiltresi;


    //MealsCenter/backoffice/orders/completed/order type butonu altında bulunan dinein filtresi
    @FindBy(xpath = "//span[text()='Dinein']")
    public  WebElement completedDineinFiltresi;


    //MealsCenter/backoffice/orders/completed/order type butonu altında bulunan pick up filtresi
    @FindBy(xpath = "//span[text()='Pickup']")
    public  WebElement completedPickUpFiltresi;


    //MealsCenter/backoffice/orders/completed/payment status butonu
    @FindBy(xpath = "//div[text()='Payment status']")
    public  WebElement completedPaymentStatusButonu;


    //MealsCenter/backoffice/orders/completed/payment status butonu altında bulunan paid filtresi
    @FindBy(xpath = "//span[text()='Paid']")
    public  WebElement completedPaidFiltresi;


    //MealsCenter/backoffice/orders/completed/payment status butonu altında bulunan unpaid filtresi
    @FindBy(xpath = "//span[text()='Unpaid']")
    public  WebElement completedUnpaidFiltresi;


    //MealsCenter/backoffice/orders/completed/payment status butonu altında bulunan failed filtresi
    @FindBy(xpath = "//span[text()='Failed']")
    public  WebElement completedFailedFiltresi;


    //MealsCenter/backoffice/orders/completed/payment status butonu altında bulunan pending filtresi
    @FindBy(xpath = "//span[text()='Pending']")
    public  WebElement completedPendingFiltresi;


    //MealsCenter/backoffice/orders/completed/payment status butonu altında bulunan cancelled filtresi
    @FindBy(xpath = "/span[text()='Cancelled']")
    public  WebElement completedCancelledFiltresi;


    //MealsCenter/backoffice/orders/completed/sort butonu
    @FindBy(xpath = "//div[text()='Sort']")
    public  WebElement completedSortButonu;


    //MealsCenter/backoffice/orders/completed/sort butonu altında bulunan Order ID - Ascending filtresi
    @FindBy(xpath = "//span[text()='Order ID - Ascending']")
    public  WebElement completedOrderIDAscendingFiltresi;


    //MealsCenter/backoffice/orders/completed/sort butonu altında bulunan Order ID - Descending filtresi
    @FindBy(xpath = "//span[text()='Order ID - Descending']")
    public  WebElement completedOrderIDDescendingFiltresi;


    //MealsCenter/backoffice/orders/completed/sort butonu altında bulunan Delivery Time - Ascending filtresi
    @FindBy(xpath = "//span[text()='Delivery Time - Ascending']")
    public  WebElement completedDeliveryTimeAscendingFiltresi;


    //MealsCenter/backoffice/orders/completed/sort butonu altında bulunan Delivery Time - Descending filtresi
    @FindBy(xpath = "//span[text()='Delivery Time - Descending']")
    public  WebElement completedDeliveryTimeDescendingFiltresi;


    //MealsCenter/backoffice/orders/completed/completed today yazisi
    @FindBy(xpath = "//h5[text()='Completed Today']")
    public  WebElement completedTodayYazisi;


    //MealsCenter/backoffice/orders/completed/print butonu
    @FindBy(xpath = "//button[text()='Print']")
    public  WebElement completedPrintButonu;


    //MealsCenter/backoffice/orders/completed/... butonu
    @FindBy(xpath = "//a[@id='dropdownMenuLink']")
    public  WebElement completedUcNoktaButonu;


    //MealsCenter/backoffice/orders/completed/... butonu altında bulunan Contact customer secenegi
    @FindBy(xpath = "//a[text()='Contact customer']")
    public  WebElement completedContactCustomer;


    //MealsCenter/backoffice/orders/completed/... butonu altında bulunan timeline secenegi
    @FindBy(xpath = "//a[text()='Timeline']")
    public  WebElement completedTimeline;


    //MealsCenter/backoffice/orders/completed/... butonu altında bulunan download PDF (A4) secenegi
    @FindBy(xpath = "//a[text()='Download PDF (A4)']")
    public  WebElement completedDownloadPDF;


    // SCHEDULED KISMI


    //MealsCenter/backoffice/orders/scheduled
    @FindBy(xpath = "//a[@href=\"/backoffice/orders/scheduled\"]")
    public WebElement scheduledButonu;


    //MealsCenter/backoffice/orders/scheduled/Accepting orders butonu
    @FindBy(xpath = "//div[text()='Accepting Orders']")
    public WebElement scheduledAcceptingOrdersButonu;


    //MealsCenter/backoffice/orders/scheduled/Search kısmı
    @FindBy(xpath = "//input[@type='search']")
    public WebElement scheduledSearchButonu;


    //MealsCenter/backoffice/orders/scheduled/order type butonu
    @FindBy(xpath = "//div[text()='Order type']")
    public  WebElement scheduledOrderTypeButonu;


    //MealsCenter/backoffice/orders/scheduled/order type butonu altında bulunan delivery filtresi
    @FindBy(xpath = "(//span[text()='Delivery'])[1]")
    public  WebElement scheduledDeliveryFiltresi;


    //MealsCenter/backoffice/orders/scheduled/order type butonu altında bulunan dinein filtresi
    @FindBy(xpath = "//span[text()='Dinein']")
    public  WebElement scheduledDineinFiltresi;


    //MealsCenter/backoffice/orders/scheduled/order type butonu altında bulunan pick up filtresi
    @FindBy(xpath = "//span[text()='Pickup']")
    public  WebElement scheduledPickUpFiltresi;


    //MealsCenter/backoffice/orders/scheduled/payment status butonu
    @FindBy(xpath = "//div[text()='Payment status']")
    public  WebElement scheduledPaymentStatusButonu;


    //MealsCenter/backoffice/orders/scheduled/payment status butonu altında bulunan paid filtresi
    @FindBy(xpath = "//span[text()='Paid']")
    public  WebElement scheduledPaidFiltresi;


    //MealsCenter/backoffice/orders/scheduled/payment status butonu altında bulunan unpaid filtresi
    @FindBy(xpath = "//span[text()='Unpaid']")
    public  WebElement scheduledUnpaidFiltresi;


    //MealsCenter/backoffice/orders/scheduled/payment status butonu altında bulunan failed filtresi
    @FindBy(xpath = "//span[text()='Failed']")
    public  WebElement scheduledFailedFiltresi;


    //MealsCenter/backoffice/orders/scheduled/payment status butonu altında bulunan pending filtresi
    @FindBy(xpath = "//span[text()='Pending']")
    public  WebElement scheduledPendingFiltresi;


    //MealsCenter/backoffice/orders/scheduled/payment status butonu altında bulunan cancelled filtresi
    @FindBy(xpath = "/span[text()='Cancelled']")
    public  WebElement scheduledCancelledFiltresi;


    //MealsCenter/backoffice/orders/scheduled/sort butonu
    @FindBy(xpath = "//div[text()='Sort']")
    public  WebElement scheduledSortButonu;


    //MealsCenter/backoffice/orders/scheduled/sort butonu altında bulunan Order ID - Ascending filtresi
    @FindBy(xpath = "//span[text()='Order ID - Ascending']")
    public  WebElement scheduledOrderIDAscendingFiltresi;


    //MealsCenter/backoffice/orders/scheduled/sort butonu altında bulunan Order ID - Descending filtresi
    @FindBy(xpath = "//span[text()='Order ID - Descending']")
    public  WebElement scheduledOrderIDDescendingFiltresi;


    //MealsCenter/backoffice/orders/scheduled/sort butonu altında bulunan Delivery Time - Ascending filtresi
    @FindBy(xpath = "//span[text()='Delivery Time - Ascending']")
    public  WebElement scheduledDeliveryTimeAscendingFiltresi;


    //MealsCenter/backoffice/orders/scheduled/sort butonu altında bulunan Delivery Time - Descending filtresi
    @FindBy(xpath = "//span[text()='Delivery Time - Descending']")
    public  WebElement scheduledDeliveryTimeDescendingFiltresi;


    //MealsCenter/backoffice/orders/scheduled/accepted butonu
    @FindBy(xpath = "//span[text()='Accepted']")
    public WebElement scheduledAcceptedButonu;


    //MealsCenter/backoffice/orders/scheduled/accepted butonu
    @FindBy(xpath = "//span[text()='Reject']")
    public WebElement scheduledRejectButonu;


    //MealsCenter/backoffice/orders/scheduled/accepted butonu
    @FindBy(xpath = "//button[text()='Assign Driver']")
    public WebElement scheduledAssignDrivertButonu;


    //MealsCenter/backoffice/orders/scheduled/print butonu
    @FindBy(xpath = "//button[text()='Print']")
    public  WebElement scheduledPrintButonu;


    //MealsCenter/backoffice/orders/scheduled/... butonu
    @FindBy(xpath = "//a[@id='dropdownMenuLink']")
    public  WebElement scheduledUcNoktaButonu;


    //MealsCenter/backoffice/orders/scheduled/... butonu altında bulunan Contact customer secenegi
    @FindBy(xpath = "//a[text()='Contact customer']")
    public  WebElement scheduledContactCustomer;


    //MealsCenter/backoffice/orders/scheduled/... butonu altında bulunan timeline secenegi
    @FindBy(xpath = "//a[text()='Timeline']")
    public  WebElement scheduledTimeline;


    //MealsCenter/backoffice/orders/scheduled/... butonu altında bulunan download PDF (A4) secenegi
    @FindBy(xpath = "//a[text()='Download PDF (A4)']")
    public  WebElement scheduledDownloadPDF;


    // ALL ORDERS KISMI


    //MealsCenter/backoffice/orders/history
    @FindBy(xpath = "//a[@href=\"/backoffice/orders/history\"]")
    public WebElement allOrdersButonu;


    //MealsCenter/backoffice/orders/history/preview store butonu
    @FindBy(xpath = "(//a[@title=\"Preview store\"])[1]")
    public WebElement allOrdersPreviewStoreButonu;


    //MealsCenter/backoffice/orders/history/order history yazisi
    @FindBy(xpath = "//h5[text()='Order history']")
    public WebElement allOrdersOrderHistoryYazisi;


    //MealsCenter/merchant/allOrdersSayfasi/searchBox
    @FindBy(xpath="//input[@placeholder='Start date -- End date']")
    public WebElement allOrdersSearchBox;


    //MealsCenter/backoffice/orders/history/filters Butonu
    @FindBy(xpath = "//div[text()='Filters']")
    public WebElement allOrdersFiltersButonu;


    //MealsCenter/backoffice/orders/history/by customer Butonu
    @FindBy(xpath = "(//span[@role='combobox'])[2]")
    public WebElement byCustomerFiltersButonu;


    //MealsCenter/backoffice/orders/history/by order type Butonu
    @FindBy(xpath = "(//span[@role='combobox'])[3]")
    public WebElement byOrderTypeFiltersButonu;


    //MealsCenter/backoffice/orders/history/by status Butonu
    @FindBy(xpath = "(//span[@role='combobox'])[1]")
    public WebElement byStatusFiltersButonu;


    //MealsCenter/backoffice/orders/history/apply filters butonu
    @FindBy(xpath = "(//button[text()='Apply Filters']")
    public WebElement applyFiltersButonu;


    //MealsCenter/backoffice/orders/history/next butonu
    @FindBy(xpath = "//a[text()='Next']")
    public WebElement nextButonu;


    //MealsCenter/backoffice/orders/history/all orders goz ikonu
    @FindBy(xpath = "(//a[@target='_blank'])[3]")
    public WebElement allOrdersGozIkonu;


    //MealsCenter/backoffice/orders/history/all orders indirme ikonu
    @FindBy(xpath = "(//a[@target='_blank'])[4]")
    public WebElement allOrdersIndirmeIkonu;


    //MealsCenter/backoffice/orders/history/"Showing 0 to 0 of 0 entries" kısmı
    @FindBy(xpath = "//div[@id='DataTables_Table_0_info']")
    public WebElement allOrdersShowingEntries;


    //MealsCenter/backoffice/orders/history/previous butonu
    @FindBy(xpath = "//a[text()='Previous']")
    public WebElement allOrdersPreviousButonu;


    //MealsCenter/backoffice/orders/history/next butonu
    @FindBy(xpath = "//a[text()='Next']")
    public WebElement allOrdersNextButonu;

    //merchant<Orders<ORDERPROCESSİNG


    @FindBy(linkText ="Orders" )
    public WebElement ordersButton;

    @FindBy(linkText = "Orders Ready")
    public WebElement ordersReadyButton;

    @FindBy(linkText = "Orders Processing")
    public WebElement ordersProceccingButton;

    @FindBy(xpath = "(//div[@class='d-flex justify-content-between align-items-center'])[2]")
    public WebElement solSiparisListesi;

    @FindBy(xpath = "(//div[@class='d-flex mt-3'])[1]")
    public WebElement customerBilgileri;

    @FindBy(xpath = "(//div[@class='d-flex mt-3'])[2]")
    public WebElement deliveryBilgileri;

    @FindBy(xpath = "//table//tr[4]//td[2]")
    public WebElement paymentTable;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement assignDriverButton;

    @FindBy(xpath = "//div[@class='card-body pt-3']")
    public WebElement summaryBolumu;

    @FindBy(xpath = "//button[@class='btn btn-black normal']")
    public WebElement print1Button;

    @FindBy(xpath = "//div[@class='modal-footer justify-content-end border-0']//button[2]")
    public WebElement print2Button;

    @FindBy(xpath = "//input[@class='form-control py-2 border-right-0 border']")
    public WebElement filtreSearchBox;


    @FindBy(xpath = "(//div[@class='filter-option'])[1]")
    public WebElement orderTypeButton;

    @FindBy(xpath = "(//div[@class='inner show']//a)[1]")
    public WebElement orderTypeDelivery;

    @FindBy(xpath = "(//div[@class='filter-option'])[2]")
    public WebElement paymentTypeButton;

    @FindBy(xpath = "(//div[@class='inner show']//a)[5]")
    public WebElement unpaidTypePayment;

    @FindBy(xpath = "//div[@class='dropdown dropleft']")
    public WebElement ucnoktaBolumu;

    @FindBy(xpath = "//div[@class='dropdown-menu show']//a[1]")
    public WebElement contactCostumerUcnokta;

    @FindBy(xpath = "//div[@class='bootbox-body']")
    public WebElement contactCustomerTelefon;

    @FindBy(xpath = "//div[@class='modal-footer']//button[@class='btn btn-green small pl-4 pr-4 bootbox-accept']")
    public WebElement contactCustomerOkayButonu;

    @FindBy(xpath = "//div[@class='dropdown-menu show']//a[2]")
    public WebElement delayOrdercUcnokta;

    @FindBy(xpath = "//div[@class='modal-body']//button[1]")
    public WebElement delayOrderErteleme;

    @FindBy(xpath = "//div[@class='modal-footer']//button[1]")
    public WebElement delayOrderConfirm;


    @FindBy(xpath = "(//div[@class='modal-body position-relative']//p[2][@class='m-0 text-muted'])[1]")
    public WebElement zamanInceleme;

    @FindBy(xpath = "//div[@class='dropdown-menu show']//a[3]")
    public WebElement timelineUcnokta;

    @FindBy(xpath = "(//div[@class='modal-footer']//button[@class='btn btn-green pl-4 pr-4'])[2]")
    public WebElement closeTimeline;

    @FindBy(xpath = "//div[@class='dropdown-menu show']//a[4]")
    public WebElement downloadUcnokta;

    @FindBy(xpath = "//button[@class='btn-green btn normal mr-2 font13 mb-3 mb-xl-0']")
    public WebElement readyForPickUpTusu;


    //MealsCenter/merchant/newOrdersSayfasi/unpaidDropDown
    @FindBy(xpath="//span[text()='Paid']")
    public WebElement  newOrderspaidDropDown;

    @FindBy(xpath = "(//div[@class='col']//button)[1]")
    public WebElement deliveryOnItsWay;

    @FindBy(xpath = "//div[@class='ml-3']//h6")
    public WebElement deliveryYazisi;

    @FindBy(xpath = "(//div[@class='col']//button)[3]")
    public WebElement deliveryFailed;

    @FindBy(xpath = "//div[@class='alert alert-warning mb-2']//p")
    public WebElement noResultYazisi;

    @FindBy(xpath = "(//div[@class='col']//button)[2]")
    public WebElement deliveredButton;

    @FindBy(linkText = "Completed")
    public WebElement CompletedButton;

}
