import Pages.AudiobookPage;
import Pages.HoldPage;
import Pages.MainPage;
import Steps.CommonSteps;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class RBdigitalTests_Xiaomi_cable extends BaseTest {

    //WebDriver driver;
    //AppiumDriver driver;
    //AndroidDriver driver;
    MainPage mainPage;
    AudiobookPage audiobookPage;
    CommonSteps commonSteps;
    HoldPage holdPage;
    //BaseTest baseTest;

    String actualMagTitle;
    String actualComTitle;
    String actualAudioBookTitle;
    String actualBookTitle;
    String ebookHold;


    @AfterMethod
    void AfterMethod() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 45);
        //wait.until(ExpectedConditions.elementToBeClickable(By.id("com.ocd:id/top_icon_menu")));

        if(driver.findElements(By.id("This service is temporarily inaccessible. Please try again later.")).size()!=0){
            ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_BACK);
            Thread.sleep(400);
            ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_BACK);
        }

        if(driver.findElements(By.id("android:id/message")).size()!=0){
            driver.findElementById("android:id/button1").click();
        }
        //driver.findElementById("com.ocd:id/top_icon_menu").click();
        //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='HOME']")));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("com.ocd:id/top_icon_menu")));

        do{
            driver.findElementById("com.ocd:id/top_icon_menu").click();
        }
        while (driver.findElementsByXPath("//android.widget.TextView[@text='HOME']").size() == 0);
        driver.findElementByXPath("//android.widget.TextView[@text='HOME']").click();
    }

    @BeforeClass
    void beforeClass() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName", "Redmi Note 4");
        cap.setCapability("udid", "6dcfacac0604");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "7.0");
        cap.setCapability("appPackage", "com.ocd");
        cap.setCapability("appActivity", "com.ocd.activity.SplashActivity");
        driver = new AndroidDriver(new URL(" http://127.0.0.1:4723/wd/hub"), cap);
        mainPage = new MainPage(driver);
        audiobookPage = new AudiobookPage(driver);
        commonSteps = new CommonSteps(driver);
        holdPage = new HoldPage(driver);

        //baseTest = new BaseTest(driver);
        mainPage.Login("qauser", "password1");
    }

    @Test
    public void Test_MagazineCheckout_ReturningExistingItem_SuccessReturning() throws InterruptedException {
        goToMagazinePage();
        actualMagTitle = getTitleOfElement(2);
        openElement(2);
        //String actualMagDescription = driver.findElement(By.id("com.ocd:id/activity_media_info_description")).getText();
        pressMagCheckout();
        thenIShouldSeeReadBtn();
        thenIShouldSeeReturnBtn();
        //Assert.assertEquals(actualMagDescription, "The Economist is a global weekly magazine written for those who share an uncommon interest in being well and broadly informed. Each issue explores domestic and international issues, business, finance, current affairs, science, technology and the arts.");
        goToCheckedOutPage();
        returnMagazine(actualMagTitle);
        //Assert.assertEquals(EconomistMagBeforeReturn, ""+actualMagTitle+"");
        thenIShouldNotSeeReturnBtn();
    }

    @Test
    public void Test_ComicCheckout_ReturningExistingItem_SuccessReturning() throws InterruptedException {
        goToComicsPage();
        actualComTitle = getTitleOfElement(0);
        openElement(0);
        //String actualComDescription = driver.findElement(By.id("com.ocd:id/activity_media_info_description")).getText();
        pressComCheckout();
        thenIShouldSeeReadBtn();
        thenIShouldSeeReturnBtn();
        ///Assert.assertTrue(actualComDescription.contains("Collects Captain Marvel"));
        goToCheckedOutPage();
        returnComic(actualComTitle);
        thenIShouldNotSeeReturnBtn();
        //List returnedComics = driver.findElements(By.xpath("//android.widget.TextView[@text='"+actualComTitle+"']"));
        //Assert.assertEquals(ComicBeforeReturn, ""+actualComTit
    }

    @Test
    public void Test_AudiobookCheckout_ReturningExistingItem_SuccessReturning() throws InterruptedException {
        goToAudiobookPage();
        actualAudioBookTitle = getTitleOfElement(2);
        openElement(2);
        pressCheckoutAudiobook();
        thenIShouldSeeReadBtn();
        thenIShouldSeeReturnBtn();
        goToCheckedOutPage();
        openCheckedOutEAudioPage();
        returnAudiobook(actualAudioBookTitle);
        List returnedComics = driver.findElements(By.xpath("//android.widget.TextView[@text='"+actualAudioBookTitle+"']"));
        Assert.assertEquals(returnedComics.size(), 0);
    }

    @Test
    public void Test_EBookCheckout_ReturningExistingItem_SuccessReturning() throws InterruptedException {
        goToEBookViewAllPage();
        actualBookTitle = getTitleOfElement(1);
        openElement(1);
        pressCheckoutEBook();
        thenIShouldSeeReadBtn();
        thenIShouldSeeReturnBtn();
        goToCheckedOutPage();
        goToCheckedOutViewAllEbookPage();
        returnEbook(actualBookTitle);
        List returnedComics = driver.findElements(By.xpath("//android.widget.TextView[@text='"+actualBookTitle+"']"));
        Assert.assertEquals(returnedComics.size(), 0);
    }

    @Test
    public void Test_SearchMagazineByTitle_Checkout_ReturnFromDetailPage_SuccessReturning(){
        openSearch();
        searchMagazineByTitle("PREVENTION");
        openElementFromSearchResult(2);
        pressMagCheckout();
        thenIShouldSeeReadBtn();
        thenIShouldSeeReturnBtn();
        returnFromDetailPage();
        thenIShouldSeeCheckoutBtn();
    }

    @Test
    public void Test_SearchComicByTitle_Checkout_ReturnFromDetailPage_SuccessReturning(){
        openSearch();
        searchComicByTitle("MINISULK");
        openElementFromSearchResult(1);
        String actualComDescription = getDescriptionOfElement();
        pressComCheckout();
        thenIShouldSeeReadBtn();
        thenIShouldSeeReturnBtn();
        returnFromDetailPage();
        thenIShouldSeeCheckoutBtn();
        Assert.assertTrue(actualComDescription.contains("Jeffrey Brown takes a break from books about girls for this humorous short story collection featuring fiction, gags and autobiography."));
    }

    @Test
    public void Test_SearchAudiobookByTitle_Checkout_ReturnFromDetailPage_SuccessReturning(){
        openSearch();
        searchAudiobookByTitle("KINGS OF THE EARTH");
        openElementFromSearchResult(1);
        String actualAudiobookDescription = getDescriptionOfElement();
        pressCheckoutAudiobook();
        thenIShouldSeeReadBtn();
        thenIShouldSeeReturnBtn();
        returnFromDetailPage();
        thenIShouldSeeCheckoutBtn();
        Assert.assertTrue(actualAudiobookDescription.contains("Author of the award-winning novel"));
    }

    @Test
    public void Test_SearchEBookByTitle_Checkout_ReturnFromDetailPage_SuccessReturning(){
        openSearch();
        searchEbookByTitle("SLOB");
        openElementFromSearchResult(2);
        String actualEbookDescription = getDescriptionOfElement();
        pressCheckoutEBook();
        thenIShouldSeeReadBtn();
        thenIShouldSeeReturnBtn();
        returnFromDetailPage();
        thenIShouldSeeCheckoutBtn();
        Assert.assertTrue(actualEbookDescription.contains("funny and smart"));
    }

    @Test(enabled = false)
    public void Test_14_1_AcornTV_Checkout() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);

        driver.findElementById("com.ocd:id/top_icon_menu").click();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='HOME']")));

        AndroidElement entertainmentTabMenu = (AndroidElement) driver.findElement(By.xpath("//android.widget.TextView[@text='ENTERTAINMENT']"));
        entertainmentTabMenu.click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='ENTERTAINMENT']")));

        AndroidElement ACORNTV = (AndroidElement) driver.findElement(By.xpath("//android.widget.TextView[@text='ACORN TV - BRITISH TV']"));
        ACORNTV.click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.view.View[@text='800words']")));

        int count = 0;
        do {
            AndroidElement acornElement800words = (AndroidElement) driver.findElement(By.xpath("//android.view.View[@text='800words']"));
            acornElement800words.click();
            count++;
        }
        while (driver.findElements(By.id("access")).size() == 0 && count < 7);

        //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.view.View[@text='800words']")));

        do {
            AndroidElement checkoutBtn = (AndroidElement) driver.findElement(By.id("access"));
            checkoutBtn.click();
        }
        while (driver.findElements(By.id("access")).size() != 0);

        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='RBdigital']")));
        driver.findElement(By.xpath("//android.widget.TextView[@text='RBdigital']")).click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("close")));
        WebElement acseptAlert = driver.findElement(By.id("close"));
        acseptAlert.click();

        AndroidElement accessBtn = (AndroidElement) driver.findElement(By.xpath("//android.widget.Button[@text='ACCESS']"));
        accessBtn.click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("Welcome back to Acorn TV")));
        Assert.assertTrue(driver.findElement(By.id("Welcome back to Acorn TV")).isDisplayed());

        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_BACK);
        Thread.sleep(400);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_BACK);
    }

    @Test(enabled = false)
    public void Test_14_2_AcornTV_ReturnCheckout() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 40);

        goToCheckedOutPage();

        TouchAction tA = new TouchAction(driver);

        int count = 0;
        while (driver.findElements(By.xpath("//android.widget.TextView[@text='ENTERTAINMENT']")).size() == 0 && count < 14){

            tA.press(PointOption.point(540, 625)).moveTo(PointOption.point(540, 600)).release().perform();
            count++;
        }

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.Button[@text='VIEW ALL']")));
        Thread.sleep(1700);
        AndroidElement viewAllBtnForComics = (AndroidElement) driver.findElements(By.xpath("//android.widget.Button[@text='VIEW ALL']")).get(1);
        viewAllBtnForComics.click();


        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='RBdigital']")));
        driver.findElement(By.xpath("//android.widget.TextView[@text='RBdigital']")).click();


        AndroidElement firstXBtn = (AndroidElement) driver.findElements(By.id("com.ocd:id/row_media_x")).get(0);
        firstXBtn.click();


        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.Button[@text='YES']")));
        AndroidElement acseptAlert = (AndroidElement) driver.findElement(By.xpath("//android.widget.Button[@text='YES']"));
        acseptAlert.click();
        //Assert.assertTrue(driver.findElement(By.id("access")).isDisplayed());
    }

    @Test
    public void Test_AudiobookWishlist_ReturnWishlist_SuccessReturning() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 40);
        goToAudiobookViewAllPage();
        String audiobookTitlewishlist = getTitleOfElement(1);
        openElement(1);
        pressAddToWishlist();
        goToWishlistViewAllAudioBookPage();
        AndroidElement firstXBtn = (AndroidElement) driver.findElements(By.id("com.ocd:id/row_media_x")).get(0);
        firstXBtn.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("android:id/progress")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='"+audiobookTitlewishlist+"']")));
    }

    @Test
    public void Test_eBookWishlist_ReturnWishlist_SuccessReturning() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 40);
        goToEBookViewAllPage();
        String bookTitlewishlist = getTitleOfElement(2);
        openElement(2);
        pressAddToWishlist();
        goToWishlistViewAllEbookPage();
        AndroidElement firstXBtn = (AndroidElement) driver.findElements(By.id("com.ocd:id/row_media_x")).get(0);
        firstXBtn.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("android:id/progress")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='"+bookTitlewishlist+"']")));
    }

    @Test
    public void Test_AudiobookHold_ReturnHold_SuccessReturning() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        goToAudiobookPage();
        audiobookPage.scrollToMostPopular();
                //.goToViewAllPage(0);
        String audiobookHold = getTitleOfElement(0);
        openElement(0);
        commonSteps.pressHold();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='HOLD']")));
        goToHoldPage();
        holdPage.onHoldPageScrollToAudiobooks();
        holdPage.removeElement(0);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='"+audiobookHold+"']")));
    }

    @Test(enabled = false)
    public void Test_20_Audiobook_ReturnHold() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        goToHoldPage();
        holdPage.onHoldPageScrollToAudiobooks();
        holdPage.removeElement(0);
        //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='"+audiobookHold+"']")));
        //Thread.sleep(3000);
        //List returnedAudioWishlist =  driver.findElements(By.xpath("//android.widget.TextView[@text='"+audiobookTitlewishlist+"']"));
        //Assert.assertEquals(returnedAudioWishlist.size(), 0);
    }

    @Test
    public void Test_21_EBookHold() {
        WebDriverWait wait = new WebDriverWait(driver, 30);

        goToEBookPage();

        TouchAction tA = new TouchAction(driver);
        int count = 0;
        while (driver.findElements(By.xpath("//android.widget.TextView[@text='NEWLY ADDED']")).size() == 0 && count < 7){

            tA.press(PointOption.point(540, 640)).moveTo(PointOption.point(540, 600)).release().perform();
            count++;
        }

        //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.Button[@text='VIEW ALL']")));
        //AndroidElement viewAllBtnForComics = (AndroidElement) driver.findElements(By.xpath("//android.widget.Button[@text='VIEW ALL']")).get(0);
        //viewAllBtnForComics.click();
        openElement(1);
        //AndroidElement firstEBook = (AndroidElement) driver.findElements(By.id("com.ocd:id/row_media_image")).get(0);
        //firstEBook.click();

        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='RBdigital']")));
        driver.findElement(By.xpath("//android.widget.TextView[@text='RBdigital']")).click();

        AndroidElement titleEBook = (AndroidElement) driver.findElement(By.id("com.ocd:id/activity_media_info_title"));
        ebookHold = titleEBook.getText();

        commonSteps.pressHold();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='REMOVE HOLD']")));

    }

    @Test
    public void Test_22_eBook_ReturnHold() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 20);

        goToHoldPage();

        //((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);
        //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='RBdigital']")));
        //driver.findElement(By.xpath("//android.widget.TextView[@text='RBdigital']")).click();


        ebookHold = ebookHold.toUpperCase();
        if(driver.findElements(By.xpath("//android.widget.TextView[@text='"+ebookHold+"']")).size() == 0) {
            TouchAction tA = new TouchAction(driver);
            int count = 0;
            while (driver.findElements(By.xpath("//android.widget.TextView[@text='" + ebookHold + "']")).size() == 0 && count < 7) {

                tA.press(PointOption.point(540, 640)).moveTo(PointOption.point(540, 600)).release().perform();
                count++;
            }
        }

        wait.until(ExpectedConditions.elementToBeClickable(By.id("com.ocd:id/row_media_x")));

        AndroidElement firstXBtn = (AndroidElement) driver.findElements(By.id("com.ocd:id/row_media_x")).get(0);
        firstXBtn.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='"+ebookHold+"']")));

        //Thread.sleep(3000);
        //List returnedAudioWishlist =  driver.findElements(By.xpath("//android.widget.TextView[@text='"+audiobookTitlewishlist+"']"));
        //Assert.assertEquals(returnedAudioWishlist.size(), 0);
    }






    //public void swipeVertical(AppiumDriver<MobileElement> driver, double startPercentage, double finalPercentage, int duration){
    //    Dimension size = driver.manage().window().getSize();
     //   int width = (int) (size.width/2);
    //    int startPoint = (int) (size.getHeight() * startPercentage);
   //     int endPoint = (int) (size.getHeight() * finalPercentage);
    //    new TouchAction(driver).press(PointOption.point(width, startPoint)).moveTo(PointOption.point(width, endPoint)).release().perform();

   // }
}
