
import org.junit.Assert;

import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebDriverException;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class TestSteps {


    public static void main(String[] args){
        System.setProperty("webdriver.geckoriver.driver", "geckodriver.exe");

        WebDriver driver = new FirefoxDriver(); // Web driver seçildi

        driver.get("https://www.n11.com/"); // Site açıldı

        WebDriverWait wait = new WebDriverWait(driver, 8);

        //////////////////////// 1. STEP
        System.out.println("-------Step 1-------");

        try{
            Assert.assertEquals("n11.com - Alışverişin Uğurlu Adresi",driver.getTitle());
            System.out.println("---Mainpage is succesfully opened---");
        }
        catch(InputMismatchException e){
            System.out.println("--Mainpage failed--");
        }

        /////////////////////// 2.STEP
        System.out.println("-------Step 2-------");

        WebElement buttonLogin = driver.findElement(By.xpath("//*[@class='btnSignIn']"));
        buttonLogin.click();
        System.out.println("--Button is clicked--");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='loginForm']/div[4]")));

        //get strings
        String getTitlePage=driver.getTitle();
        String getTitleLoginBox = driver.findElement(By.xpath("//*[@id='loginContainer']/div/div[1]/h2")).getText();
        String getTitleEmail = driver.findElement(By.xpath("//*[@id='loginForm']/div[1]/label")).getText();
        String getTitlePass = driver.findElement(By.xpath("//*[@id='loginForm']/div[2]/label")).getText();
        String getTitleLoginButton = driver.findElement(By.xpath("//*[@id='loginButton']")).getText();
        String getTitleFacebookButton = driver.findElement(By.xpath("//*[@id='loginForm']/div[4]")).getText();

        try{
            Assert.assertEquals("Giriş Yap - n11.com",getTitlePage );
            System.out.println("--Main title is checked--");
            Assert.assertEquals("Üye Girişi",getTitleLoginBox);
            System.out.println("--Login box Title is checked--");
            Assert.assertEquals("E-Posta Adresi",getTitleEmail);
            System.out.println("--Email box title is checked--");
            Assert.assertEquals("Şifre",getTitlePass );
            System.out.println("--Password box title is checked--");
            Assert.assertEquals("Üye Girişi",getTitleLoginButton );
            System.out.println("--Login button is checked--");
            Assert.assertEquals("Facebook ile Giriş",getTitleFacebookButton );
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

        id.sendKeys(""); //e-mail
        System.out.println("--Email is sent--");
        pass.sendKeys(""); //password
        System.out.println("--Password is sent--");
        buttonMemberLogin.click();


        WebDriver driver2 = driver;
        Actions act = new Actions(driver2); //hesabım menüsü açılması için
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='menuTitle']")));

        act.moveToElement(driver2.findElement(By.xpath("//*[@class='myAccountHolder customMenuItem hasMenu  withLocalization ']"))).perform(); ////hesabım menüsü açılması için

        //Get
        String getTitleMyAccount = driver.findElement(By.xpath("//*[@id='header']/div/div/div[2]/div[2]/div[2]/div[1]/a[1]")).getText();
        String getTitleMyName = driver.findElement(By.xpath("//*[@id='header']/div/div/div[2]/div[2]/div[2]/div[1]/a[2]")).getText();
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
            Assert.assertEquals("Hesabım",getTitleMyAccount );
            System.out.println("--Hesabım test edildi--");
            Assert.assertEquals("Yusuf Sar",getTitleMyName);
            System.out.println("--İsim ve soyisim test edildi--");
            Assert.assertEquals("Mevcut Sipariş",getTitleOrder);
            System.out.println("--Siparişlerim test edildi--");
            Assert.assertEquals("İstek Listem / Favorilerim",getTitleWishList );
            System.out.println("--İstek listesi test edildi--");
            Assert.assertEquals("İptal/Değişim/İade",getTitleCancel );
            System.out.println("--İptal, Değişim test edildi--");
            Assert.assertEquals("Kuponlarım",getTitleCoupons );
            System.out.println("--Kuponlarım test edildi--");
            Assert.assertEquals("Garajım",getTitleGarage );
            System.out.println("--Garajım test edildi --");
            Assert.assertEquals("Puanlarım",getTitlePoints );
            System.out.println("--Puanlarım test edildi--");
            Assert.assertEquals("Soru ve Cevaplar",getTitleQuestions );
            System.out.println("--Sorular ve cevaplar test edildi--");
            Assert.assertEquals("Bilgi Güncelleme",getTitleInfoUpdate );
            System.out.println("--Bilgi Güncelleme test edildi--");
            Assert.assertEquals("Çıkış Yap",getTitleExit );
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

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='resultText ']")));

        String getPageTitle = driver.getTitle();
        String getResultofSearch= driver.findElement(By.xpath("//*[@class='resultText ']")).getText();

        try {
            Assert.assertEquals("Samsung - n11.com",getPageTitle);
            System.out.println("--Title test edildi--");

            if(getResultofSearch.contains("Samsung") && getResultofSearch.contains("için") && getResultofSearch.contains("sonuç bulundu.")) {
                System.out.println("--Arama sonuçları test edildi--");
            }
        }
        catch (InputMismatchException e){
            System.out.println("--Step 5 failed--");
        }

        WebElement ul =driver.findElement(By.xpath("//*[@id='view']"));
        List<WebElement> list=ul.findElements(By.className("column"));


        //Sonuçlarda bazen başka markalar çıkabiliyor dolayısıyla bazı ürünler false dönüyor.
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

        String getPageNumber = driver.findElement(By.xpath("//*[@class='pagination']/a[@class='active ']")).getText();
        Assert.assertTrue("2".equals(getPageNumber));       //2.sayfada olunduğunu kontrol ediyor

        String getValue = driver.findElement(By.xpath("//*[@class='pageInfo']/input[@class='currentPage']")).getAttribute("value");
        Assert.assertTrue("2".equals(getValue));     //Sağ alt köşedekeki sayfa sayısının 2 olduğunu kontrol ediyor.

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

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='view' and contains(@class,'listView')]/ul/li[3]//*[@class='textImg followBtn']")));

        WebElement fav = driver.findElement(By.xpath("//div[@id='view' and contains(@class,'listView')]/ul/li[3]//*[@class='textImg followBtn']"));
        fav.click();
        System.out.println("--3.ürün için favorilere ekle'ye basıldı--");



        /////////////////////// 8.STEP
        System.out.println("-------Step 8-------");

        driver.findElement(By.xpath("//*[@id='header']/div/div/div[2]/div[2]/div[2]/div[1]/a[1]")).click();
        System.out.println("--Hesabım'a tıklandı--");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='myAccount']/div[1]/div[1]/div[2]/ul/li[12]/a")));

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

            Assert.assertEquals("Mevcut Sipariş",getTitleOrder1);
            System.out.println("--Mevcut Sipariş test edildi--");
            Assert.assertEquals("İptal/Değişim/İade",getTitleCancel1 );
            System.out.println("--İptal, Değişim test edildi--");
            Assert.assertEquals("Kuponlarım",getTitleCoupons1 );
            System.out.println("--Kuponlarım test edildi--");
            Assert.assertEquals("Garajım",getTitleGarage1 );
            System.out.println("--Garajım test edildi --");
            Assert.assertEquals("Puanlarım",getTitlePoints1 );
            System.out.println("--Puanlarım test edildi--");
            Assert.assertEquals("İstek Listelerim",getTitleWishList1 );
            System.out.println("--İstek listesi test edildi--");
            Assert.assertEquals("Yorumlarım",getTitleComments1 );
            System.out.println("--Yorumlarım test edildi--");
            Assert.assertEquals("Ürün Sorularım",getTitleQuestions1 );
            System.out.println("--Sorular ve cevaplar test edildi--");
            Assert.assertEquals("Üyelik Bilgilerim",getTitleInfoMember1 );
            System.out.println("--Bilgi Güncelleme test edildi--");
            Assert.assertEquals("Adreslerim",getTitleAddress1 );
            System.out.println("--Adreslerim test edildi--");
            Assert.assertEquals("Şifre Değiştir",getTitleChangePass1 );
            System.out.println("--Şifre Değiştirme test edildi--");
            Assert.assertEquals("Üyelik İptali",getTitleMemberCancel1 );
            System.out.println("--Üyelik İptali test edildi--");

            Assert.assertEquals("Siparişlerim",getMyOrders);
            System.out.println("--Siparişlerim test edildi--");
            Assert.assertEquals("Biletlerim",getMyTickets);
            System.out.println("--Biletlerim test edildi--");
            Assert.assertEquals("Yusuf Sar",getName);
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

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='myAccount']/div[3]/div[1]/h2")));

        String getTitleMyFavs = driver.getTitle();
        String getSubTitle = driver.findElement(By.xpath("//*[@id='myAccount']/div[3]/div[1]/h2")).getText();


        try {
            Assert.assertEquals("Favorilerim - n11.com",getTitleMyFavs);
            System.out.println("--Title test edildi--");
            Assert.assertEquals("Favorilerim",getSubTitle);
            System.out.println("--Subitle test edildi--");

            System.out.println("---Favorilerim ekranı açıldığı onaylandı---");

        }
        catch (InputMismatchException e){
            System.out.println("--Step 9 failed--");
        }

        /////////////////////// 10.STEP
        System.out.println("-------Step 10-------");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='view' and @class='listView']/ul/li/div/a")));

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

        try {
            List<WebElement> elementList = driver.findElements(By.xpath("//div[@class='group listingGroup wishListGroup']/div"));

            WebElement deleteButton = driver.findElement(By.xpath("//div[@id='view' and @class='listView']/ul/li/div/div[3]/span"));
            deleteButton.click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[5]/div/div/span")));

            WebElement okeyButton = driver.findElement(By.xpath("/html/body/div[5]/div/div/span"));
            okeyButton.click();
            System.out.println("--Ürünü sil tuşuna basıldı--");
            driver.navigate().refresh();

            List<WebElement> elementList1 = driver.findElements(By.xpath("//div[@class='group listingGroup wishListGroup']/div"));

            if(elementList1.size()<2){
                System.out.println("--Ürünün kaldırıldığı test edildi--"); //ürünün favorilerimde olmadığını kanıtlıyor
            }
            else {
                System.out.println("--Ürünün kaldırılamadı--");
            }
        }
        catch (InputMismatchException e){

        }

    }


}



