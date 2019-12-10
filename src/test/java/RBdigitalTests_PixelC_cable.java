import Pages.MainPage;
import Steps.PixelCSteps;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.touch.WaitOptions;
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
import java.time.Duration;
import java.util.List;

public class RBdigitalTests_PixelC_cable extends BaseTest {

    //WebDriver driver;
    //AppiumDriver driver;
    //AndroidDriver driver;
    MainPage mainPage;
    //BaseTest baseTest;

    String actualMagTitle;
    String actualComTitle;
    String actualAudioBookTitle;
    String actualBookTitle;
    String audiobookTitlewishlist;
    String bookTitlewishlist;
    String audiobookHold;
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
        cap.setCapability("deviceName", "Pixel C");
        cap.setCapability("udid", "6118001501");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "8.1.0");
        cap.setCapability("appPackage", "com.ocd");
        cap.setCapability("appActivity", "com.ocd.activity.SplashActivity");
        driver = new AndroidDriver(new URL(" http://127.0.0.1:4723/wd/hub"), cap);
        mainPage = new MainPage(driver);
        pixelCSteps = new PixelCSteps(driver);
        //baseTest = new BaseTest(driver);
        mainPage.Login("qauser", "password1");
    }

    @Test(enabled = false)
    public void Test_01_Login() throws Exception {
        //DesiredCapabilities cap = new DesiredCapabilities();
        //cap.setCapability("deviceName", "Redmi Note 4");
        //cap.setCapability("udid", "6dcfacac0604");
        //cap.setCapability("platformName", "Android");
        //cap.setCapability("platformVersion", "7.0");
        //cap.setCapability("appPackage", "com.ocd");
        //cap.setCapability("appActivity", "com.ocd.activity.SplashActivity");
        //driver = new AndroidDriver(new URL(" http://127.0.0.1:4723/wd/hub"), cap);
        //mainPage = new MainPage(driver);
        //baseTest = new BaseTest(driver);

        //mainPage.Login();

        //Assert.assertTrue(driver.findElement(By.xpath("//*[@class='android.widget.TextView'][@text='AUDIOBOOKS']")).isDisplayed());
        //Assert.assertTrue(driver.findElement(By.id("com.ocd:id/top_icon_menu")).isDisplayed());
        //Assert.assertTrue(driver.findElement(By.id("com.ocd:id/top_icon_search")).isDisplayed());
        //Assert.assertTrue(driver.findElement(By.xpath("//*[@class='android.widget.TextView'][@text='CHECKED OUT']")).isDisplayed());
    }

    @Test
    public void Test_02_MagazineCheckout_Return() throws InterruptedException {
        goToMagazinePage();
        actualMagTitle = getTitleOfElement(1);
        openElement(1);
        //String actualMagDescription = driver.findElement(By.id("com.ocd:id/activity_media_info_description")).getText();
        pressMagCheckout();
        thenIShouldSeeReadBtn();
        thenIShouldSeeReturnBtn();
        //Assert.assertEquals(actualMagDescription, "The Economist is a global weekly magazine written for those who share an uncommon interest in being well and broadly informed. Each issue explores domestic and international issues, business, finance, current affairs, science, technology and the arts.");
        goToCheckedOutPage();
        //returnMagazine(actualMagTitle);
        pixelCSteps.returnMagazine(actualMagTitle);
        //Assert.assertEquals(EconomistMagBeforeReturn, ""+actualMagTitle+"");
        thenIShouldNotSeeReturnBtn();
    }

    @Test(enabled = false)
    public void Test_03_MagazineReturn() throws InterruptedException {
        //WebDriverWait wait1 = new WebDriverWait(driver, 30);
        goToCheckedOutPage();
        returnMagazine(actualMagTitle);
        thenIShouldNotSeeReturnBtn();
    }

    @Test
    public void Test_04_ComicCheckout_Return() throws InterruptedException {
        goToComicsPage();
        actualComTitle = getTitleOfElement(1);
        openElement(1);
        //String actualComDescription = driver.findElement(By.id("com.ocd:id/activity_media_info_description")).getText();
        pressComCheckout();
        thenIShouldSeeReadBtn();
        thenIShouldSeeReturnBtn();
        ///Assert.assertTrue(actualComDescription.contains("Collects Captain Marvel"));
        goToCheckedOutPage();
        pixelCSteps.returnComic(actualComTitle);
        thenIShouldNotSeeReturnBtn();
        //List returnedComics = driver.findElements(By.xpath("//android.widget.TextView[@text='"+actualComTitle+"']"));
        //Assert.assertEquals(ComicBeforeReturn, ""+actualComTit
    }

    @Test(enabled = false)
    public void Test_05_ComicsReturn() throws InterruptedException {
        //WebDriverWait wait = new WebDriverWait(driver, 35);
        goToCheckedOutPage();
        returnComic(actualComTitle);
        List returnedComics = driver.findElements(By.xpath("//android.widget.TextView[@text='"+actualComTitle+"']"));
        //Assert.assertEquals(ComicBeforeReturn, ""+actualComTitle+"");
        Assert.assertEquals(returnedComics.size(), 0);
    }


    @Test
    public void Test_06_AudiobookCheckout() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 40);

        goToAudiobookPage();

        AndroidElement viewAllBtn = (AndroidElement) driver.findElement(By.id("com.ocd:id/titles_header_view_all"));
        viewAllBtn.click();

        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='RBdigital']")));
        driver.findElement(By.xpath("//android.widget.TextView[@text='RBdigital']")).click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/pagination_two")));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/filter_label")));

        //TouchAction tB = new TouchAction(driver);

        //int count = 0;
        //while (driver.findElements(By.xpath("//android.widget.TextView[@text='X-MEN: DAYS OF FUTURE PAST - SPECIAL']")).size() == 0 && count < 10){

        //    tB.press(PointOption.point(540, 640)).moveTo(PointOption.point(540, 600)).release().perform();

        //}

        //AndroidElement mag = (AndroidElement) driver.findElement(By.xpath("//android.widget.TextView[@text='US WEEKLY']"));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/sort_spinner_text_view")));

        AndroidElement titleAudioBook = (AndroidElement) driver.findElements(By.id("com.ocd:id/row_media_title")).get(0);
        actualAudioBookTitle = titleAudioBook.getText();

        openElement(0);

        if(driver.findElements(By.xpath("//android.widget.TextView[@text='PLAY']")).size() != 0){
            driver.findElement(By.xpath("//android.widget.TextView[@text='RETURN']")).click();
            driver.findElement(By.xpath("//android.widget.Button[@text='YES']")).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.id("com.ocd:id/activity_media_info_play")));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='PLAY']")));
        }

        pressCheckout();

        //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/confirmation_checkbox")));
        //AndroidElement confirmationCheckbox = (AndroidElement) driver.findElement(By.id("com.ocd:id/confirmation_checkbox"));
        //confirmationCheckbox.click();

        //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/dialog_ok_button")));
        //AndroidElement okButton = (AndroidElement) driver.findElement(By.id("com.ocd:id/dialog_ok_button"));
        //okButton.click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/activity_media_info_play")));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/activity_media_info_left_button")));
        thenIShouldSeeReadBtn();
        thenIShouldSeeReturnBtn();
        //Assert.assertTrue(actualAudioBookDescription.contains("Described as \"one of the best coming-of-age novels of the twentieth century,\" Theodore Weesner's modern American classic is now on audio! It's 1959. Sixteen-year-old Alex Housman has just stolen his fourteenth car and frankly doesn't know why. His divorced, working-class father grinds out the night shift at the local Chevy plant in Detroit and looks forward to the flask in his glove compartment and the open bottles of booze in his Flint, Michigan, home. Broke and fighting to survive, Alex and his father face the realities of estrangement, incarceration, and even violence as their lives unfold toward the climactic episode that a New York Times reviewer called \"one of the most profoundly powerful in American fiction.\" In this rich, beautifully crafted story, Weesner has written a transcendent piece of literature in deceptively simple language, painting a powerful portrait of a father and a son otherwise invisible among the mundane, everyday details of life in blue-collar America. It is a true and enduring American classic."));
    }

    @Test
    public void Test_07_AudiobookReturn() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);

        //driver.findElementById("com.ocd:id/top_icon_menu").click();
        //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='HOME']")));

        //AndroidElement checkedOUTTabMenu = (AndroidElement) driver.findElement(By.xpath("//android.widget.TextView[@text='CHECKED OUT']"));
        //checkedOUTTabMenu.click();

        //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='CHECKED OUT']")));

        goToCheckedOutPage();


        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(540, 500)).moveTo(PointOption.point(540, 800)).release().perform();

        //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='Anansi and the Magic Stick']")));

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.Button[@text='VIEW ALL']")));
        AndroidElement viewAllBtnForComics = (AndroidElement) driver.findElements(By.xpath("//android.widget.Button[@text='VIEW ALL']")).get(0);
        viewAllBtnForComics.click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/filter_label")));

        //int count = 0;
        //while (driver.findElements(By.xpath("//android.widget.TextView[@text='THE PASTOR'S KID']")).size() == 0 && count < 9){

        //  touchAction.press(PointOption.point(540, 900)).moveTo(PointOption.point(540, 500)).release().perform();
        //    count++;
        //}

        int count = 0;
        while (driver.findElements(By.xpath("//android.widget.TextView[@text='"+actualAudioBookTitle+"']")).size() == 0 && count < 9){

            touchAction.press(PointOption.point(540, 900)).moveTo(PointOption.point(540, 500)).release().perform();
            count++;
        }


        //String ComicBeforeReturn = driver.findElement(By.xpath("//android.widget.TextView[@text='"+actualAudioBookTitle+"']")).getText();


        //((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);
        //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.android.systemui:id/dismiss_task")));
        //((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);

        //AndroidElement lastAudioBook = (AndroidElement) driver.findElements(By.id("com.ocd:id/row_media_container")).get(1);
        //lastAudioBook.click();

        AndroidElement firstXBtn = (AndroidElement) driver.findElements(By.id("com.ocd:id/row_media_x")).get(0);
        firstXBtn.click();
        //Thread.sleep(1200);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("android:id/progress")));

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='"+actualAudioBookTitle+"']")));


        List returnedComics = driver.findElements(By.xpath("//android.widget.TextView[@text='"+actualAudioBookTitle+"']"));
        //Assert.assertEquals(ComicBeforeReturn, "THE PASTOR'S KID");
        Assert.assertEquals(returnedComics.size(), 0);
    }

    @Test
    public void Test_08_EBookCheckout(){
        WebDriverWait wait = new WebDriverWait(driver, 40);

        goToEBookViewAllPage();


        AndroidElement title = (AndroidElement) driver.findElements(By.id("com.ocd:id/row_media_title")).get(0);
        actualBookTitle = title.getText();

        openElement(0);

        if(driver.findElements(By.xpath("//android.widget.TextView[@text='READ']")).size() != 0){
            driver.findElement(By.xpath("//android.widget.TextView[@text='RETURN']")).click();
            driver.findElement(By.xpath("//android.widget.Button[@text='YES']")).click();
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/activity_media_info_play")));
        }

        pressCheckout();


        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/activity_media_info_play")));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/activity_media_info_left_button")));
        thenIShouldSeeReadBtn();
        thenIShouldSeeReturnBtn();
        //Assert.assertTrue(actualAudioBookDescription.contains("Raising funds to fulfill a nonprofit organization's goals is critical to its success"));
    }


    @Test
    public void Test_09_EBookReturn() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 40);

        //driver.findElementById("com.ocd:id/top_icon_menu").click();
        //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='HOME']")));

        //AndroidElement checkedOUTTabMenu = (AndroidElement) driver.findElement(By.xpath("//android.widget.TextView[@text='CHECKED OUT']"));
        //checkedOUTTabMenu.click();

        //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='CHECKED OUT']")));

        goToCheckedOutPage();


        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(540, 500)).moveTo(PointOption.point(540, 800)).release().perform();

        //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='Anansi and the Magic Stick']")));

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.Button[@text='VIEW ALL']")));
        Thread.sleep(1500);
        AndroidElement viewAllBtnForComics = (AndroidElement) driver.findElements(By.xpath("//android.widget.Button[@text='VIEW ALL']")).get(1);
        viewAllBtnForComics.click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/filter_label")));


        int count = 0;
        while (driver.findElements(By.xpath("//android.widget.TextView[@text='"+actualBookTitle+"']")).size() == 0 && count < 9){

            touchAction.press(PointOption.point(540, 900)).moveTo(PointOption.point(540, 500)).release().perform();
            count++;
        }

        //int count = 0;
        //while (driver.findElements(By.xpath("//android.widget.TextView[@text='THE LAW OF FUNDRAISING']")).size() == 0 && count < 9){

        //    touchAction.press(PointOption.point(540, 900)).moveTo(PointOption.point(540, 500)).release().perform();
        //    count++;
        // }


        //String ComicBeforeReturn = driver.findElement(By.xpath("//android.widget.TextView[@text='"+actualBookTitle+"']")).getText();


        //((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);
        //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.android.systemui:id/dismiss_task")));
        //((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);

        //AndroidElement lastAudioBook = (AndroidElement) driver.findElements(By.id("com.ocd:id/row_media_container")).get(2);
        //lastAudioBook.click();

        AndroidElement firstXBtn = (AndroidElement) driver.findElements(By.id("com.ocd:id/row_media_x")).get(0);
        firstXBtn.click();
        //Thread.sleep(1400);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("android:id/progress")));


        List returnedComics = driver.findElements(By.xpath("//android.widget.TextView[@text='"+actualBookTitle+"']"));
        //Assert.assertEquals(ComicBeforeReturn, "THE LAW OF FUNDRAISING");
        Assert.assertEquals(returnedComics.size(), 0);
    }

    @Test
    public void Test_10_SearchMagazine_Checkout_Return(){
        WebDriverWait wait = new WebDriverWait(driver, 40);
        AndroidElement searchIcon = (AndroidElement) driver.findElement(By.id("com.ocd:id/top_icon_search"));
        searchIcon.click();

        AndroidElement magazinesTab = (AndroidElement) driver.findElement(By.id("com.ocd:id/search_select_magazines"));
        magazinesTab.click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.EditText[@text='Name']")));
        //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.EditText[@text='Title']")));

        AndroidElement nameEdit = (AndroidElement) driver.findElement(By.xpath("//android.widget.EditText[@text='Name']"));
        nameEdit.sendKeys("PREVENTION");

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='Prevention Magazine Australia']")));

        AndroidElement searchCommit = (AndroidElement) driver.findElement(By.id("com.ocd:id/search_commit"));
        searchCommit.click();

        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='RBdigital']")));
        driver.findElement(By.xpath("//android.widget.TextView[@text='RBdigital']")).click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='PREVENTION']")));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='MAGAZINES']")));

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/sort_spinner_text_view")));
        openElement(1);

        //String actualMagDescription = driver.findElement(By.id("com.ocd:id/activity_media_info_description")).getText();


        if(driver.findElements(By.xpath("//android.widget.TextView[@text='READ']")).size() != 0){
            driver.findElement(By.xpath("//android.widget.TextView[@text='RETURN']")).click();
            driver.findElement(By.xpath("//android.widget.Button[@text='YES']")).click();
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/activity_media_info_play")));
        }

        pressCheckout();

        //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/confirmation_checkbox")));
        //AndroidElement confirmationCheckbox = (AndroidElement) driver.findElement(By.id("com.ocd:id/confirmation_checkbox"));
        //confirmationCheckbox.click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/dialog_ok_button")));
        AndroidElement okButton = (AndroidElement) driver.findElement(By.id("com.ocd:id/dialog_ok_button"));
        okButton.click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/activity_media_info_play")));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/activity_media_info_left_button")));

        AndroidElement returnBtn = (AndroidElement) driver.findElement(By.id("com.ocd:id/activity_media_info_left_button"));
        returnBtn.click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("android:id/button1")));
        AndroidElement yesBtn = (AndroidElement) driver.findElement(By.id("android:id/button1"));
        yesBtn.click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='CHECKOUT']")));

        Assert.assertTrue(driver.findElement(By.xpath("//android.widget.TextView[@text='CHECKOUT']")).isDisplayed());
        //Assert.assertTrue(actualMagDescription.contains("Prevention magazine gives you healthy solutions you can really live with."));
    }

    @Test
    public void Test_11_SearchComic_Checkout_Return(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        AndroidElement searchIcon = (AndroidElement) driver.findElement(By.id("com.ocd:id/top_icon_search"));
        searchIcon.click();

        AndroidElement comicsTab = (AndroidElement) driver.findElement(By.id("com.ocd:id/search_select_comics"));
        comicsTab.click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.EditText[@text='Name']")));
        //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.EditText[@text='Title']")));

        AndroidElement nameEdit = (AndroidElement) driver.findElement(By.xpath("//android.widget.EditText[@text='Name']"));
        nameEdit.sendKeys("MINISULK");

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='Minisulk']")));

        AndroidElement searchCommit = (AndroidElement) driver.findElement(By.id("com.ocd:id/search_commit"));
        searchCommit.click();

        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='RBdigital']")));
        driver.findElement(By.xpath("//android.widget.TextView[@text='RBdigital']")).click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='MINISULK']")));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='COMICS']")));

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/sort_spinner_text_view")));
        openElement(0);

        String actualComDescription = driver.findElement(By.id("com.ocd:id/activity_media_info_description")).getText();

        if(driver.findElements(By.xpath("//android.widget.TextView[@text='READ']")).size() != 0){
            driver.findElement(By.xpath("//android.widget.TextView[@text='RETURN']")).click();
            driver.findElement(By.xpath("//android.widget.Button[@text='YES']")).click();
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/activity_media_info_play")));
        }

        pressCheckout();

        //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/confirmation_checkbox")));
        //AndroidElement confirmationCheckbox = (AndroidElement) driver.findElement(By.id("com.ocd:id/confirmation_checkbox"));
        //confirmationCheckbox.click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/dialog_ok_button")));
        AndroidElement okButton = (AndroidElement) driver.findElement(By.id("com.ocd:id/dialog_ok_button"));
        okButton.click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/activity_media_info_play")));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/activity_media_info_left_button")));

        AndroidElement returnBtn = (AndroidElement) driver.findElement(By.id("com.ocd:id/activity_media_info_left_button"));
        returnBtn.click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("android:id/button1")));
        AndroidElement yesBtn = (AndroidElement) driver.findElement(By.id("android:id/button1"));
        yesBtn.click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='CHECKOUT']")));

        Assert.assertTrue(driver.findElement(By.xpath("//android.widget.TextView[@text='CHECKOUT']")).isDisplayed());
        Assert.assertTrue(actualComDescription.contains("Jeffrey Brown takes a break from books about girls for this humorous short story collection featuring fiction, gags and autobiography."));
    }


    @Test
    public void Test_12_SearchAudioBook_Checkout_Return(){
        WebDriverWait wait = new WebDriverWait(driver, 26);
        AndroidElement searchIcon = (AndroidElement) driver.findElement(By.id("com.ocd:id/top_icon_search"));
        searchIcon.click();

        AndroidElement audioBookTab = (AndroidElement) driver.findElement(By.id("com.ocd:id/search_select_audiobooks"));
        audioBookTab.click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.EditText[@text='Name']")));
        //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.EditText[@text='Title']")));

        AndroidElement nameEdit = (AndroidElement) driver.findElement(By.xpath("//android.widget.EditText[@text='Name']"));
        nameEdit.sendKeys("KINGS OF THE EARTH");

        //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='Minisulk']")));

        AndroidElement searchCommit = (AndroidElement) driver.findElement(By.id("com.ocd:id/search_commit"));
        searchCommit.click();

        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='RBdigital']")));
        driver.findElement(By.xpath("//android.widget.TextView[@text='RBdigital']")).click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='KINGS OF THE EARTH']")));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='AUDIOBOOKS']")));

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/sort_spinner_text_view")));
        openElement(0);

        String actualAudiobookDescription = driver.findElement(By.id("com.ocd:id/activity_media_info_description")).getText();

        pressCheckout();

        //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/confirmation_checkbox")));
        //AndroidElement confirmationCheckbox = (AndroidElement) driver.findElement(By.id("com.ocd:id/confirmation_checkbox"));
        //confirmationCheckbox.click();

        //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/dialog_ok_button")));
        //AndroidElement okButton = (AndroidElement) driver.findElement(By.id("com.ocd:id/dialog_ok_button"));
        //okButton.click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/activity_media_info_play")));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/activity_media_info_left_button")));

        AndroidElement returnBtn = (AndroidElement) driver.findElement(By.id("com.ocd:id/activity_media_info_left_button"));
        returnBtn.click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("android:id/button1")));
        AndroidElement yesBtn = (AndroidElement) driver.findElement(By.id("android:id/button1"));
        yesBtn.click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='CHECKOUT']")));

        Assert.assertTrue(driver.findElement(By.xpath("//android.widget.TextView[@text='CHECKOUT']")).isDisplayed());
        Assert.assertTrue(actualAudiobookDescription.contains("Author of the award-winning novel"));
    }


    @Test
    public void Test_13_SearchEBook_Checkout_Return(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        AndroidElement searchIcon = (AndroidElement) driver.findElement(By.id("com.ocd:id/top_icon_search"));
        searchIcon.click();

        AndroidElement EBookTab = (AndroidElement) driver.findElement(By.id("com.ocd:id/search_select_ebooks"));
        EBookTab.click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.EditText[@text='Name']")));
        //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.EditText[@text='Title']")));

        AndroidElement nameEdit = (AndroidElement) driver.findElement(By.xpath("//android.widget.EditText[@text='Name']"));
        nameEdit.sendKeys("SLOB");

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='Slob']")));

        AndroidElement searchCommit = (AndroidElement) driver.findElement(By.id("com.ocd:id/search_commit"));
        searchCommit.click();

        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='RBdigital']")));
        driver.findElement(By.xpath("//android.widget.TextView[@text='RBdigital']")).click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='SLOB']")));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='EBOOKS']")));

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/sort_spinner_text_view")));
        openElement(0);

        //String actualBookDescription = driver.findElement(By.id("com.ocd:id/activity_media_info_description")).getText();

        pressCheckout();

        //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/confirmation_checkbox")));
        //AndroidElement confirmationCheckbox = (AndroidElement) driver.findElement(By.id("com.ocd:id/confirmation_checkbox"));
        //confirmationCheckbox.click();

        //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/dialog_ok_button")));
        //AndroidElement okButton = (AndroidElement) driver.findElement(By.id("com.ocd:id/dialog_ok_button"));
        //okButton.click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/activity_media_info_play")));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/activity_media_info_left_button")));

        AndroidElement returnBtn = (AndroidElement) driver.findElement(By.id("com.ocd:id/activity_media_info_left_button"));
        returnBtn.click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("android:id/button1")));
        AndroidElement yesBtn = (AndroidElement) driver.findElement(By.id("android:id/button1"));
        yesBtn.click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='CHECKOUT']")));

        Assert.assertTrue(driver.findElement(By.xpath("//android.widget.TextView[@text='CHECKOUT']")).isDisplayed());
        //Assert.assertTrue(actualBookDescription.contains("By the Booker Award-winning bestselling author of The Gathering, The Green Road"));
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
    public void Test_15_AudiobookWishlist() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 40);

        goToAudiobookPage();

        AndroidElement viewAllBtn = (AndroidElement) driver.findElement(By.id("com.ocd:id/titles_header_view_all"));
        viewAllBtn.click();

        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='RBdigital']")));
        driver.findElement(By.xpath("//android.widget.TextView[@text='RBdigital']")).click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/pagination_two")));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/filter_label")));

        //TouchAction tB = new TouchAction(driver);

        //int count = 0;
        //while (driver.findElements(By.xpath("//android.widget.TextView[@text='X-MEN: DAYS OF FUTURE PAST - SPECIAL']")).size() == 0 && count < 10){

        //    tB.press(PointOption.point(540, 640)).moveTo(PointOption.point(540, 600)).release().perform();

        //}

        //AndroidElement mag = (AndroidElement) driver.findElement(By.xpath("//android.widget.TextView[@text='US WEEKLY']"));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/sort_spinner_text_view")));

        AndroidElement titleAudioBook = (AndroidElement) driver.findElements(By.id("com.ocd:id/row_media_title")).get(1);
        audiobookTitlewishlist = titleAudioBook.getText();

        openElement(1);

        //if (driver.findElements(By.xpath("//android.widget.TextView[@text='PLAY']")).size() != 0) {
        //    driver.findElement(By.xpath("//android.widget.TextView[@text='RETURN']")).click();
        //    driver.findElement(By.xpath("//android.widget.Button[@text='YES']")).click();
        //    wait.until(ExpectedConditions.elementToBeClickable(By.id("com.ocd:id/activity_media_info_play")));
        //}

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='ADD TO WISHLIST']")));
        AndroidElement addToWishlist = (AndroidElement) driver.findElement(By.xpath("//android.widget.TextView[@text='ADD TO WISHLIST']"));
        addToWishlist.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='ADD TO WISHLIST']")));

    }

    @Test
    public void Test_16_AudioBook_ReturnWishlist() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 45);

        goToWishlistPage();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.Button[@text='VIEW ALL']")));
        AndroidElement viewAllBtnForComics = (AndroidElement) driver.findElements(By.xpath("//android.widget.Button[@text='VIEW ALL']")).get(0);
        viewAllBtnForComics.click();

        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='RBdigital']")));
        driver.findElement(By.xpath("//android.widget.TextView[@text='RBdigital']")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("com.ocd:id/row_media_x")));

        AndroidElement firstXBtn = (AndroidElement) driver.findElements(By.id("com.ocd:id/row_media_x")).get(0);
        firstXBtn.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("android:id/progress")));

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='"+audiobookTitlewishlist+"']")));

        //Thread.sleep(3000);
        //List returnedAudioWishlist =  driver.findElements(By.xpath("//android.widget.TextView[@text='"+audiobookTitlewishlist+"']"));
        //Assert.assertEquals(returnedAudioWishlist.size(), 0);
    }

    @Test
    public void Test_17_EBookWishlist() {
        WebDriverWait wait = new WebDriverWait(driver, 40);

        goToEBookViewAllPage();


        AndroidElement title = (AndroidElement) driver.findElements(By.id("com.ocd:id/row_media_title")).get(2);
        bookTitlewishlist = title.getText();

        openElement(2);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='ADD TO WISHLIST']")));
        AndroidElement addToWishlist = (AndroidElement) driver.findElement(By.xpath("//android.widget.TextView[@text='ADD TO WISHLIST']"));
        addToWishlist.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='ADD TO WISHLIST']")));
    }

    @Test
    public void Test_18_Ebook_ReturnWishlist() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);

        goToWishlistPage();

        TouchAction tA = new TouchAction(driver);

        int count = 0;
        while (driver.findElements(By.xpath("//android.widget.TextView[@text='NEWSPAPERS']")).size() == 0 && count < 7){

            tA.press(PointOption.point(540, 640)).moveTo(PointOption.point(540, 600)).release().perform();
            count++;
        }

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.Button[@text='VIEW ALL']")));
        AndroidElement viewAllBtnForComics = (AndroidElement) driver.findElements(By.xpath("//android.widget.Button[@text='VIEW ALL']")).get(0);
        viewAllBtnForComics.click();


        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='RBdigital']")));
        driver.findElement(By.xpath("//android.widget.TextView[@text='RBdigital']")).click();


        wait.until(ExpectedConditions.elementToBeClickable(By.id("com.ocd:id/row_media_x")));

        AndroidElement firstXBtn = (AndroidElement) driver.findElements(By.id("com.ocd:id/row_media_x")).get(0);
        firstXBtn.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='"+bookTitlewishlist+"']")));

        //Thread.sleep(700);
        //List returnedAudioWishlist = driver.findElements(By.xpath("//android.widget.TextView[@text='"+bookTitlewishlist+"']"));
        //Assert.assertEquals(ComicBeforeReturn, "THE PASTOR'S KID");
        //Assert.assertEquals(returnedAudioWishlist.size(), 0);
    }

    @Test
    public void Test_19_AudiobookHold() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);

        goToAudiobookPage();

        TouchAction tA = new TouchAction(driver);

        int count = 0;
        while (driver.findElements(By.xpath("//android.widget.TextView[@text='MOST POPULAR']")).size() == 0 && count < 7){

            tA.press(PointOption.point(540, 630)).moveTo(PointOption.point(540, 600)).release().perform();
            count++;
        }

        //AndroidElement viewAllBtn = (AndroidElement) driver.findElements(By.id("com.ocd:id/titles_header_view_all")).get(1);
        //viewAllBtn.click();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.Button[@text='VIEW ALL']")));
        AndroidElement viewAllBtnForComics = (AndroidElement) driver.findElements(By.xpath("//android.widget.Button[@text='VIEW ALL']")).get(0);
        viewAllBtnForComics.click();

        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='RBdigital']")));
        driver.findElement(By.xpath("//android.widget.TextView[@text='RBdigital']")).click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/pagination_two")));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/filter_label")));


        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/sort_spinner_text_view")));

        AndroidElement titleAudioBook = (AndroidElement) driver.findElements(By.id("com.ocd:id/row_media_title")).get(0);
        audiobookHold = titleAudioBook.getText();

        openElement(0);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='DESCRIPTION']")));

        if (driver.findElements(By.xpath("//android.widget.TextView[@text='REMOVE HOLD']")).size() != 0) {
            driver.findElement(By.xpath("//android.widget.TextView[@text='REMOVE HOLD']")).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='HOLD']")));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='REMOVE HOLD']")));
        }

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='HOLD']")));
        AndroidElement hold = (AndroidElement) driver.findElement(By.xpath("//android.widget.TextView[@text='HOLD']"));
        hold.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='HOLD']")));
    }

    @Test
    public void Test_20_AudioBook_ReturnHold() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 20);

        goToHoldPage();

        //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.Button[@text='VIEW ALL']")));
        //AndroidElement viewAllBtnForComics = (AndroidElement) driver.findElements(By.xpath("//android.widget.Button[@text='VIEW ALL']")).get(0);
        //viewAllBtnForComics.click();

        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='RBdigital']")));
        driver.findElement(By.xpath("//android.widget.TextView[@text='RBdigital']")).click();

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(540, 500)).moveTo(PointOption.point(540, 800)).release().perform();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("com.ocd:id/row_media_x")));

        AndroidElement firstXBtn = (AndroidElement) driver.findElements(By.id("com.ocd:id/row_media_x")).get(0);
        firstXBtn.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='"+audiobookHold+"']")));

        //Thread.sleep(3000);
        //List returnedAudioWishlist =  driver.findElements(By.xpath("//android.widget.TextView[@text='"+audiobookTitlewishlist+"']"));
        //Assert.assertEquals(returnedAudioWishlist.size(), 0);
    }

    @Test
    public void Test_21_EBookHold() {
        WebDriverWait wait = new WebDriverWait(driver, 30);

        goToEBookViewAllPage();

        TouchAction tA = new TouchAction(driver);
        int count = 0;
        while (driver.findElements(By.xpath("//android.widget.TextView[@text='NEWLY ADDED']")).size() == 0 && count < 7){

            tA.press(PointOption.point(540, 640)).moveTo(PointOption.point(540, 600)).release().perform();
            count++;
        }

        //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.Button[@text='VIEW ALL']")));
        //AndroidElement viewAllBtnForComics = (AndroidElement) driver.findElements(By.xpath("//android.widget.Button[@text='VIEW ALL']")).get(0);
        //viewAllBtnForComics.click();


        AndroidElement firstEBook = (AndroidElement) driver.findElements(By.id("com.ocd:id/row_media_image")).get(0);
        firstEBook.click();

        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='RBdigital']")));
        driver.findElement(By.xpath("//android.widget.TextView[@text='RBdigital']")).click();

        AndroidElement titleEBook = (AndroidElement) driver.findElement(By.id("com.ocd:id/activity_media_info_title"));
        ebookHold = titleEBook.getText();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='DESCRIPTION']")));

        if (driver.findElements(By.xpath("//android.widget.TextView[@text='REMOVE HOLD']")).size() != 0) {
            driver.findElement(By.xpath("//android.widget.TextView[@text='REMOVE HOLD']")).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='HOLD']")));
        }

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='HOLD']")));
        AndroidElement hold = (AndroidElement) driver.findElement(By.xpath("//android.widget.TextView[@text='HOLD']"));
        hold.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='REMOVE HOLD']")));

    }

    @Test
    public void Test_22_eBook_ReturnHold() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 20);

        goToHoldPage();

        //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.Button[@text='VIEW ALL']")));
        //AndroidElement viewAllBtnForComics = (AndroidElement) driver.findElements(By.xpath("//android.widget.Button[@text='VIEW ALL']")).get(0);
        //viewAllBtnForComics.click();

        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='RBdigital']")));
        driver.findElement(By.xpath("//android.widget.TextView[@text='RBdigital']")).click();


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

    public void swipeVertical(AppiumDriver<MobileElement> driver, double startPercentage, double finalPercentage, int duration){
        Dimension size = driver.manage().window().getSize();
        int width = (int) (size.width/2);
        int startPoint = (int) (size.getHeight() * startPercentage);
        int endPoint = (int) (size.getHeight() * finalPercentage);
        new TouchAction(driver).press(PointOption.point(width, startPoint)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(duration))).moveTo(PointOption.point(width, endPoint)).release().perform();
    }
}
