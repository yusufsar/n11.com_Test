
import junit.framework.Assert;

import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebDriverException;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;



public class TestSteps {


    public static void main(String[] args){
        System.setProperty("webdriver.geckoriver.driver", "geckodriver.exe");

        WebDriver driver = new FirefoxDriver(); // Web driver seçildi

        driver.get("https://www.n11.com/"); // Site açıldı
        //WebElement mainPage=driver.findElement(By.xpath("//*[@id='header']/div/h1/a/img"));

        //////////////////////// 1. STEP
        System.out.println("-------Step 1-------");

        String expectedTitleMainPage= "n11.com - Alışverişin Uğurlu Adresi"; //olması gereken başlık elementi tanımlandı
        try{
            Assert.assertEquals(expectedTitleMainPage,driver.getTitle());
            System.out.println("---Mainpage is succesfully opened---");
        }
        catch(InputMismatchException e){
            System.out.println("--Mainpage failed--");
        }

        /////////////////////// 2.STEP
        System.out.println("-------Step 2-------");

        WebElement buttonLogin = driver.findElement(By.xpath("//*[@title='Giriş Yap']"));
        buttonLogin.click();
        System.out.println("--Button is clicked--");

        //expected strings
        String expectedTitlePage = "Giriş Yap - n11.com";
        String expectedTitleLoginBox = "Üye Girişi";
        String expectedTitleEmail = "E-Posta Adresi";
        String expectedTitlePass = "Şifre";
        String expectedTitleLoginButton = "Üye Girişi";
        String expectedTitleFacebookButton = "Facebook ile Giriş";

        //get strings
        String getTitlePage=driver.getTitle();
        String getTitleLoginBox = driver.findElement(By.xpath("//*[@id='loginContainer']/div/div[1]/h2")).getText();
        String getTitleEmail = driver.findElement(By.xpath("//*[@id='loginForm']/div[1]/label")).getText();
        String getTitlePass = driver.findElement(By.xpath("//*[@id='loginForm']/div[2]/label")).getText();
        String getTitleLoginButton = driver.findElement(By.xpath("//*[@id='loginButton']")).getText();
        String getTitleFacebookButton = driver.findElement(By.xpath("//*[@id='loginForm']/div[4]")).getText();

        try{
            Assert.assertEquals(expectedTitlePage,getTitlePage );
            System.out.println("--Main title is checked--");
            Assert.assertEquals(expectedTitleLoginBox,getTitleLoginBox);
            System.out.println("--Login box Title is checked--");
            Assert.assertEquals(expectedTitleEmail,getTitleEmail);
            System.out.println("--Email box title is checked--");
            Assert.assertEquals(expectedTitlePass,getTitlePass );
            System.out.println("--Password box title is checked--");
            Assert.assertEquals(expectedTitleLoginButton,getTitleLoginButton );
            System.out.println("--Login button is checked--");
            Assert.assertEquals(expectedTitleFacebookButton,getTitleFacebookButton );
            System.out.println("--Facebook button is checked--");

            System.out.println("---Login Page is correctly opened---");
        }
        catch(InputMismatchException e) {
            System.out.println("--Login page failed--");
        }

        /////////////////////// 3.STEP
        System.out.println("-------Step 3-------");

        WebElement id = driver.findElement(By.xpath("//input[@id='email' and @name='email']"));
        WebElement pass = driver.findElement(By.xpath("//input[@id='password' and @name='password'] "));
        WebElement buttonMemberLogin = driver.findElement(By.xpath("//*[@id='loginButton']"));

        id.sendKeys("yusufsar60@gmail.com");
        System.out.println("--Email is sent--");
        pass.sendKeys("deneme1234");
        System.out.println("--Password is sent--");
        buttonMemberLogin.click();



       //Expected
        String expectedTitleMyAccount = "Hesabım";
        String expectedTitleMyName = "Yusuf Sar";
        String expectedTitleOrder = "Mevcut Sipariş";
        String expectedTitleWishList = "İstek Listem / Favorilerim";
        String expectedTitleCancel = "İptal/Değişim/İade";
        String expectedTitleCoupons = "Kuponlarım";
        String expectedTitleGarage = "Garajım";
        String expectedTitlePoints = "Puanlarım";
        String expectedTitleQuestions = "Soru ve Cevaplar";
        String expectedTitleInfoUpdate = "Bilgi Güncelleme";
        String expectedTitleExit = "Çıkış Yap";


        WebDriver driver2 = driver;
        Actions act = new Actions(driver2); //hesabım menüsü açılması için



        //Get
        String getTitleMyAccount = driver.findElement(By.xpath("//*[@id='header']/div/div/div[2]/div[2]/div[2]/div[1]/a[1]")).getText();
        String getTitleMyName = driver.findElement(By.xpath("//*[@id='header']/div/div/div[2]/div[2]/div[2]/div[1]/a[2]")).getText();

        act.moveToElement(driver2.findElement(By.xpath("//*[@id='header']/div/div/div[2]/div[2]/div[2]"))).perform(); ////hesabım menüsü açılması için

        String getTitleOrder = driver.findElement(By.xpath("//*[@id='header']/div/div/div[2]/div[2]/div[2]/div[2]/div/a[1]")).getText();
        String getTitleWishList = driver.findElement(By.xpath("//*[@id='header']/div/div/div[2]/div[2]/div[2]/div[2]/div/a[2]")).getText();
        String getTitleCancel = driver.findElement(By.xpath("//*[@id='header']/div/div/div[2]/div[2]/div[2]/div[2]/div/a[3]")).getText();
        String getTitleCoupons = driver.findElement(By.xpath("//*[@id='header']/div/div/div[2]/div[2]/div[2]/div[2]/div/a[4]")).getText();
        String getTitleGarage = driver.findElement(By.xpath("//*[@id='header']/div/div/div[2]/div[2]/div[2]/div[2]/div/a[5]")).getText();
        String getTitlePoints = driver.findElement(By.xpath("//*[@id='header']/div/div/div[2]/div[2]/div[2]/div[2]/div/a[6]")).getText();
        String getTitleQuestions = driver.findElement(By.xpath("//*[@id='header']/div/div/div[2]/div[2]/div[2]/div[2]/div/a[7]")).getText();
        String getTitleInfoUpdate = driver.findElement(By.xpath("//*[@id='header']/div/div/div[2]/div[2]/div[2]/div[2]/div/a[8]")).getText();
        String getTitleExit = driver.findElement(By.xpath("//*[@id='header']/div/div/div[2]/div[2]/div[2]/div[2]/div/a[9]")).getText();

        try{
            Assert.assertEquals(expectedTitleMyAccount,getTitleMyAccount );
            System.out.println("--Hesabım test edildi--");
            Assert.assertEquals(expectedTitleMyName,getTitleMyName);
            System.out.println("--İsim ve soyisim test edildi--");
            Assert.assertEquals(expectedTitleOrder,getTitleOrder);
            System.out.println("--Siparişlerim test edildi--");
            Assert.assertEquals(expectedTitleWishList,getTitleWishList );
            System.out.println("--İstek listesi test edildi--");
            Assert.assertEquals(expectedTitleCancel,getTitleCancel );
            System.out.println("--İptal, Değişim test edildi--");
            Assert.assertEquals(expectedTitleCoupons,getTitleCoupons );
            System.out.println("--Kuponlarım test edildi--");
            Assert.assertEquals(expectedTitleGarage,getTitleGarage );
            System.out.println("--Garajım test edildi --");
            Assert.assertEquals(expectedTitlePoints,getTitlePoints );
            System.out.println("--Puanlarım test edildi--");
            Assert.assertEquals(expectedTitleQuestions,getTitleQuestions );
            System.out.println("--Sorular ve cevaplar test edildi--");
            Assert.assertEquals(expectedTitleInfoUpdate,getTitleInfoUpdate );
            System.out.println("--Bilgi Güncelleme test edildi--");
            Assert.assertEquals(expectedTitleExit,getTitleExit );
            System.out.println("--Çıkış test edildi--");

            System.out.println("---Kullanıcı başarılı bir şekilde giriş yaptı---");
        }
        catch(InputMismatchException e) {
            System.out.println("--Step 3 failed--");
        }

        /////////////////////// 4.STEP
        System.out.println("-------Step 4-------");

        WebElement search = driver.findElement(By.xpath("//input[@type='text' and @id='searchData']"));
        WebElement buttonSearch = driver.findElement(By.xpath("//*[@id='header']/div/div/div[2]/div[1]/a"));
        search.sendKeys("samsung");
        buttonSearch.click();

        System.out.println("---Arama alanından 'samsung' başarılı bir şekilde aratıldı---");

        /////////////////////// 5.STEP
        System.out.println("-------Step 5-------");

        String expectedPageTitle = driver.getTitle();
        String expectedResultofSearch= driver.findElement(By.xpath("//*[@id='contentListing']/div/div/div[2]/section[2]/div[1]/div[1]")).getText();

        String getPageTitle = "Samsung - n11.com";

        try {
            Assert.assertEquals(expectedPageTitle,getPageTitle);
            System.out.println("--Title test edildi--");

            if(expectedResultofSearch.contains("Samsung") && expectedResultofSearch.contains("için") && expectedResultofSearch.contains("sonuç bulundu.")) {
                System.out.println("--Arama sonuçları test edildi--");
            }
        }
        catch (InputMismatchException e){
            System.out.println("--Step 5 failed--");
        }

        WebElement ul =driver.findElement(By.xpath("//*[@id='view']"));
        List<WebElement> list=ul.findElements(By.className("column"));


        //Sonuçlarda bazen başka markalar çıkabiliyor dolayısıyla bazı ürünler falsa dönüyor.
        for(int i=1;i<list.size()+1;i++)
        {
            Boolean check= true;
            String li=ul.findElement(By.xpath("//*[@id='view']/ul/li[" + (i) + "]")).getText();
            if(li.contains("SAMSUNG") || (li.contains("Samsung")) || li.contains("samsung") ) {

                System.out.println(i+". ürün "+check);
        }
        else{
                check=false;
                System.out.println(check);
            }

        }
        /////////////////////// 6.STEP
        System.out.println("-------Step 6-------");

        driver.findElement(By.xpath("//*[@id='contentListing']/div/div/div[2]/div[3]/a[2]")).click();
        String getTitlePage2 = driver.getTitle();

        //String getPageNumber = driver.findElement(By.xpath("//a[@href='https://www.n11.com/arama?q=samsung&pg=2' and contains(@class, 'active')]")).getText();
        //System.out.println(getPageNumber);
        //a[@href='https://www.n11.com/arama?q=samsung&pg=2' and contains(@class, 'active')]

        try {
            if(getTitlePage2.contains("Samsung - n11.com - 2")){
                System.out.println("--Title test edildi--");
            }
            System.out.println("---2.Sayfada olunduğu test edildi---");
        }
        catch (InputMismatchException e){

        }
        /////////////////////// 7.STEP
        System.out.println("-------Step 7-------");

        String nameOfProduct = driver.findElement(By.xpath("//div[@id='view' and contains(@class,'listView')]/ul/li[3]/div/div/a")).getText(); //3. ürünün adı
        String nameOfFirm = driver.findElement(By.xpath("//div[@id='view' and contains(@class,'listView')]/ul/li[3]/div/a")).getText(); //3.ürünün frimasının adı

        WebElement fav = driver.findElement(By.xpath("//div[@id='view' and contains(@class,'listView')]/ul/li[3]//*[@class='textImg followBtn']"));
        fav.click();
        System.out.println("--3.ürün için favorilere ekle'ye basıldı--");



        /////////////////////// 8.STEP
        System.out.println("-------Step 8-------");
        driver.findElement(By.xpath("//*[@id='header']/div/div/div[2]/div[2]/div[2]/div[1]/a[1]")).click();
        System.out.println("--Hesabım'a tıklandı--");



        String expectedTitleOrder1 = "Mevcut Sipariş";
        String expectedTitleCancel1 = "İptal/Değişim/İade";
        String expectedTitleCoupons1 = "Kuponlarım";
        String expectedTitleGarage1 = "Garajım";
        String expectedTitlePoints1 = "Puanlarım";
        String expectedTitleWishList1 = "İstek Listelerim";
        String expectedTitleComments1 = "Yorumlarım";
        String expectedTitleQuestions1 = "Ürün Sorularım";
        String expectedTitleInfoMember1 = "Üyelik Bilgilerim";
        String expectedTitleAddres1 = "Adreslerim";
        String expectedTitleChangePass1 = "Şifre Değiştir";
        String expectedTitleMemberCancel1 = "Üyelik İptali";

        String expectedMyOrders = "Siparişlerim";
        String expectedTickets = "Biletlerim";
        String expectedName= "Yusuf Sar";



        //Get
        String getTitleOrder1 = driver.findElement(By.xpath("//*[@id='myAccount']/div[1]/div[1]/div[2]/ul/li[1]/a")).getText();
        String getTitleCancel1 = driver.findElement(By.xpath("//*[@id='myAccount']/div[1]/div[1]/div[2]/ul/li[2]/a")).getText();
        String getTitleCoupons1 = driver.findElement(By.xpath("//*[@id='myAccount']/div[1]/div[1]/div[2]/ul/li[3]/a")).getText();
        String getTitleGarage1 = driver.findElement(By.xpath("//*[@id='myAccount']/div[1]/div[1]/div[2]/ul/li[4]/a")).getText();
        String getTitlePoints1 = driver.findElement(By.xpath("//*[@id='myAccount']/div[1]/div[1]/div[2]/ul/li[5]/a")).getText();
        String getTitleWishList1 = driver.findElement(By.xpath("//*[@id='myAccount']/div[1]/div[1]/div[2]/ul/li[6]/a")).getText();
        String getTitleComments1 = driver.findElement(By.xpath("//*[@id='myAccount']/div[1]/div[1]/div[2]/ul/li[7]/a")).getText();
        String getTitleQuestions1 = driver.findElement(By.xpath("//*[@id='myAccount']/div[1]/div[1]/div[2]/ul/li[8]/a")).getText();
        String getTitleInfoMember1 = driver.findElement(By.xpath("//*[@id='myAccount']/div[1]/div[1]/div[2]/ul/li[9]/a")).getText();
        String getTitleAddress1 = driver.findElement(By.xpath("//*[@id='myAccount']/div[1]/div[1]/div[2]/ul/li[10]/a")).getText();
        String getTitleChangePass1 = driver.findElement(By.xpath("//*[@id='myAccount']/div[1]/div[1]/div[2]/ul/li[11]/a")).getText();
        String getTitleMemberCancel1 = driver.findElement(By.xpath("//*[@id='myAccount']/div[1]/div[1]/div[2]/ul/li[12]/a")).getText();

        String getMyOrders = driver.findElement(By.xpath("//*[@id='myAccount']/div[3]/div[1]/ul/li[1]/a")).getText();
        String getMyTickets = driver.findElement(By.xpath("//*[@id='myAccount']/div[3]/div[1]/ul/li[2]/a")).getText();
        String getName = driver.findElement(By.xpath("//*[@id='myAccount']/div[1]/div[1]/div[1]/strong")).getText();
        try{

            Assert.assertEquals(expectedTitleOrder1,getTitleOrder1);
            System.out.println("--Mevcut Sipariş test edildi--");
            Assert.assertEquals(expectedTitleCancel1,getTitleCancel1 );
            System.out.println("--İptal, Değişim test edildi--");
            Assert.assertEquals(expectedTitleCoupons1,getTitleCoupons1 );
            System.out.println("--Kuponlarım test edildi--");
            Assert.assertEquals(expectedTitleGarage1,getTitleGarage1 );
            System.out.println("--Garajım test edildi --");
            Assert.assertEquals(expectedTitlePoints1,getTitlePoints1 );
            System.out.println("--Puanlarım test edildi--");
            Assert.assertEquals(expectedTitleWishList1,getTitleWishList1 );
            System.out.println("--İstek listesi test edildi--");
            Assert.assertEquals(expectedTitleComments1,getTitleComments1 );
            System.out.println("--Yorumlarım test edildi--");
            Assert.assertEquals(expectedTitleQuestions1,getTitleQuestions1 );
            System.out.println("--Sorular ve cevaplar test edildi--");
            Assert.assertEquals(expectedTitleInfoMember1,getTitleInfoMember1 );
            System.out.println("--Bilgi Güncelleme test edildi--");
            Assert.assertEquals(expectedTitleAddres1,getTitleAddress1 );
            System.out.println("--Adreslerim test edildi--");
            Assert.assertEquals(expectedTitleChangePass1,getTitleChangePass1 );
            System.out.println("--Şifre Değiştirme test edildi--");
            Assert.assertEquals(expectedTitleMemberCancel1,getTitleMemberCancel1 );
            System.out.println("--Üyelik İptali test edildi--");

            Assert.assertEquals(expectedMyOrders,getMyOrders);
            System.out.println("--Siparişlerim test edildi--");
            Assert.assertEquals(expectedTickets,getMyTickets);
            System.out.println("--Biletlerim test edildi--");
            Assert.assertEquals(expectedName,getName);
            System.out.println("--İsim Soyisim test edildi--");



            System.out.println("---Hesabım ekranı açıldığı onaylandı---");
        }
        catch(InputMismatchException e) {
            System.out.println("--Step 3 failed--");
        }

        /////////////////////// 9.STEP
        System.out.println("-------Step 9-------");

        WebElement wishList = driver.findElement(By.xpath("//*[@id='myAccount']/div[1]/div[1]/div[2]/ul/li[6]/a"));
        wishList.click();
        System.out.println("--İstek Listesine tıklandı--");

        WebElement myFavorites= driver.findElement(By.xpath("//*[@id='myAccount']/div[3]/ul/li[1]/div/a/h4"));
        myFavorites.click();
        System.out.println("--Favorilerime tıklandı--");

        String expectedTitleMyFavs = "Favorilerim - n11.com";
        String expectedSubTitle= "Favorilerim";

        String getTitleMyFavs = driver.getTitle();
        String getSubTitle = driver.findElement(By.xpath("//*[@id='myAccount']/div[3]/div[1]/h2")).getText();

        // CLASS ACTIVE OLAYINI EKLEYEBİLİRİM

        try {
            Assert.assertEquals(expectedTitleMyFavs,getTitleMyFavs);
            System.out.println("--Title test edildi--");
            Assert.assertEquals(expectedSubTitle,getSubTitle);
            System.out.println("--Subitle test edildi--");

            System.out.println("---Favorilerim ekranı açıldığı onaylandı---");

        }
        catch (InputMismatchException e){
            System.out.println("--Step 9 failed--");
        }

        /////////////////////// 10.STEP
        System.out.println("-------Step 10-------");

        String nameOfTheProductInFavs = driver.findElement(By.xpath("//div[@id='view' and @class='listView']/ul/li/div/div/a")).getText();
        String nameOfTheFırmInFavs = driver.findElement(By.xpath("//div[@id='view' and @class='listView']/ul/li/div/a")).getText();


        try {
            Assert.assertEquals(nameOfTheProductInFavs,nameOfProduct);
            Assert.assertEquals(nameOfTheFırmInFavs,nameOfFirm);
            System.out.println("--Favoriye alınan ürünün doğruluğu test edildi--");

        }
        catch (InputMismatchException e){
            System.out.println("--Step 10 failed--");
        }

        /////////////////////// 11.STEP
        System.out.println("-------Step 11-------");
        WebElement x = driver.findElement(By.xpath("//div[@id='view' and @class='listView']/ul/li/div/div/a"));
        Boolean c;



        try {
            List<WebElement> elementList = driver.findElements(By.xpath("//div[@class='group listingGroup wishListGroup']/div"));

            WebElement deleteButton = driver.findElement(By.xpath("//div[@id='view' and @class='listView']/ul/li/div/div[3]/span"));
            deleteButton.click();
            WebElement okeyButton = driver.findElement(By.xpath("/html/body/div[5]/div/div/span"));
            okeyButton.click();
            System.out.println("--Ürünü sil tuşuna basıldı--");
            driver.navigate().refresh();

            List<WebElement> elementList1 = driver.findElements(By.xpath("//div[@class='group listingGroup wishListGroup']/div"));

            if(elementList1.size()<2){
                System.out.println("--Ürünün kaldırıldığı test edildi--");
            }
            else {
                System.out.println("--Ürünün kaldırılamadı--");
            }

        }
        catch (InputMismatchException e){

        }


    }


}



