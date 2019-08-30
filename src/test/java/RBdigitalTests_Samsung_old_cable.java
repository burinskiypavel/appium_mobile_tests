import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class RBdigitalTests_Samsung_old_cable {

    //WebDriver driver;
    AppiumDriver driver;
    //AndroidDriver driver;

    String actualBookTitle;


    @AfterClass
    void afterClass() {
        driver.quit();
        //driver.close();
    }

    @AfterMethod
    void AfterMethod() {
        // clean up system after test
        WebDriverWait wait = new WebDriverWait(driver, 90);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/top_icon_menu")));
        driver.findElementById("com.ocd:id/top_icon_menu").click();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='HOME']")));
        driver.findElementByXPath("//android.widget.TextView[@text='HOME']").click();
    }

    @Test
    public void Test_01_runRbdigital_Login() throws Exception {
        //WebDriver wait = new WebDriverWait(driver, 30);


        DesiredCapabilities cap = new DesiredCapabilities();
        //cap.setCapability("deviceName", "Galaxy S6");
        cap.setCapability("deviceName", "Galaxy S6");
        cap.setCapability("udid", "03157df3ca4d2722");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "7.0");
        cap.setCapability("appPackage", "com.ocd");
        cap.setCapability("appActivity", "com.ocd.activity.SplashActivity");

        //URL url = new URL(" http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver(new URL(" http://127.0.0.1:4723/wd/hub"), cap);

        //MobileElement loginBtn = (MobileElement) driver.findElement(By.id("com.ocd:id/login_button"));
        //loginBtn.click();


        WebDriverWait wait = new WebDriverWait(driver, 90);


        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/login_button")));
        MobileElement loginBtn = (MobileElement) driver.findElement(By.id("com.ocd:id/login_button"));
        loginBtn.click();


        //driver.findElementByAccessibilityId("add_profile_user");


        //driver.findElementByXPath("//*[@class='android.widget.EditText'][@text='Enter username or email']");
        //driver.findElement(MobileBy.AndroidUIAutomator("new UiSeclector().resurceId(\"com.ocd:id/add_profile_user\").instance(3)"));


        //driver.findElementById("com.ocd:id/add_profile_user");
        //username.

        //driver.runAppInBackground(Duration.ofSeconds(1));


        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.android.systemui:id/dismiss_task")));
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);
        //((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.HOME);
        //try {
        //     Activity activity = new Activity("com.ocd", "com.ocd.activity.SplashActivity");
        //    activity.setStopApp(false);
        //    ((AndroidDriver) driver).startActivity(activity);
        //((AndroidDriver<MobileElement>) driver).startActivity(activity);
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }


        //((StartsActivity)driver).currentActivity();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/add_profile_user")));
        AndroidElement userName = (AndroidElement) driver.findElement(By.id("com.ocd:id/add_profile_user"));
        userName.sendKeys("qauser");

        if (((AndroidDriver) driver).isKeyboardShown()) {
            ((AppiumDriver) driver).hideKeyboard();
        }


        AndroidElement nextBtn = (AndroidElement) driver.findElement(By.id("com.ocd:id/add_profile_submit"));
        nextBtn.click();


        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.android.systemui:id/dismiss_task")));
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);


        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@class='android.widget.TextView'][@text='Select your library']")));
        TouchAction tA = new TouchAction(driver);
        tA.press(PointOption.point(540, 1420)).moveTo(PointOption.point(540, 355)).release().perform();
        //swipeVertical(driver, 0.2, 0.8, 1);

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@class='android.widget.TextView'][@text='RBdigital Library']")));
        AndroidElement RbdigitalLibrary = (AndroidElement) driver.findElement(By.xpath("//*[@class='android.widget.TextView'][@text='RBdigital Library']"));
        RbdigitalLibrary.click();

        AndroidElement password = (AndroidElement) driver.findElement(By.id("com.ocd:id/add_profile_password"));
        password.sendKeys("password1");

        AndroidElement passwordSubmit = (AndroidElement) driver.findElement(By.id("com.ocd:id/add_profile_password_submit"));
        passwordSubmit.click();

        AndroidElement AllowRBdigitalAccesstoFilesOnYourDevice = (AndroidElement) driver.findElement(By.id("com.android.packageinstaller:id/permission_deny_button"));
        AllowRBdigitalAccesstoFilesOnYourDevice.click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@class='android.widget.TextView'][@text='AUDIOBOOKS']")));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='android.widget.TextView'][@text='AUDIOBOOKS']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("com.ocd:id/top_icon_menu")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("com.ocd:id/top_icon_search")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='android.widget.TextView'][@text='CHECKED OUT']")).isDisplayed());

    }

    /*
    @Test
    public void Test_02_RbdigitalMagazineCheckout(){
        WebDriverWait wait = new WebDriverWait(driver, 90);

        AndroidElement iconMenu = (AndroidElement) driver.findElement(By.id("com.ocd:id/top_icon_menu"));
        iconMenu.click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='MAGAZINES & COMICS']")));
        AndroidElement magazineComicTab = (AndroidElement) driver.findElement(By.xpath("//android.widget.TextView[@text='MAGAZINES & COMICS']"));
        magazineComicTab.click();

        //driver.findElementByXPath("(//*[@resource-id='com.ocd:id/menu_child_name'][@text='MAGAZINES']").click();

        AndroidElement firstFromListMagazine = (AndroidElement) driver.findElementsById("com.ocd:id/menu_child_name").get(1);
        firstFromListMagazine.click();


        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.android.systemui:id/dismiss_task")));
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);
        //((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.HOME);
        //try {
        //    Activity activity = new Activity("com.ocd", "com.ocd.activity.SplashActivity");
        //    activity.setStopApp(false);
        //    ((AndroidDriver) driver).startActivity(activity);
        //((AndroidDriver<MobileElement>) driver).startActivity(activity);
        // } catch (Exception e) {
        //   e.printStackTrace();
        // }

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/filter_label")));

        //AndroidElement mag = (AndroidElement) driver.findElement(By.xpath("//android.widget.TextView[@text='US WEEKLY']"));
        AndroidElement firstMag = (AndroidElement) driver.findElements(By.id("com.ocd:id/row_media_container")).get(2);
        firstMag.click();

        String actualMagDescription = driver.findElement(By.id("com.ocd:id/activity_media_info_description")).getText();

        AndroidElement checkoutBtn = (AndroidElement) driver.findElement(By.id("com.ocd:id/activity_media_info_play"));
        checkoutBtn.click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/confirmation_checkbox")));
        AndroidElement confirmationCheckbox = (AndroidElement) driver.findElement(By.id("com.ocd:id/confirmation_checkbox"));
        confirmationCheckbox.click();

        AndroidElement okButton = (AndroidElement) driver.findElement(By.id("com.ocd:id/dialog_ok_button"));
        okButton.click();

        Assert.assertTrue(driver.findElement(By.id("com.ocd:id/activity_media_info_play")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("com.ocd:id/activity_media_info_left_button")).isDisplayed());
        Assert.assertEquals(actualMagDescription, "The Economist is a global weekly magazine written for those who share an uncommon interest in being well and broadly informed. Each issue explores domestic and international issues, business, finance, current affairs, science, technology and the arts.");
    }

    @Test
    public void Test_03_RbdigitalMagazineReturn() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 80);

        driver.findElementById("com.ocd:id/top_icon_menu").click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='CHECKED OUT']")));
        AndroidElement checkedOUTTabMenu = (AndroidElement) driver.findElement(By.xpath("//android.widget.TextView[@text='CHECKED OUT']"));
        checkedOUTTabMenu.click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='CHECKED OUT']")));
        TouchAction tA = new TouchAction(driver);

        int count = 0;
        while (driver.findElements(By.xpath("//android.widget.TextView[@text='THE ECONOMIST']")).size() == 0 && count < 7){

            tA.press(PointOption.point(540, 640)).moveTo(PointOption.point(540, 600)).release().perform();

        }

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='THE ECONOMIST']")));
        String EconomistMagBeforeReturn = driver.findElement(By.xpath("//android.widget.TextView[@text='THE ECONOMIST']")).getText();


        //AndroidElement com = (AndroidElement) driver.findElement(By.xpath("//android.widget.TextView[@text='THE ECONOMIST']"));
        //com.click();
        //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='RETURN']")));
        //AndroidElement returnBtn = (AndroidElement) driver.findElement(By.xpath("//android.widget.TextView[@text='RETURN']"));
        //returnBtn.click();
        //AndroidElement yesConfirmBtn = (AndroidElement) driver.findElement(By.id("android:id/button1"));
        //yesConfirmBtn.click();
        //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='CHECKOUT']")));


        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.Button[@text='VIEW ALL']")));
        Thread.sleep(1500);
        AndroidElement viewAllBtnForMagazine = (AndroidElement) driver.findElements(By.xpath("//android.widget.Button[@text='VIEW ALL']")).get(0);
        Thread.sleep(1500);
        viewAllBtnForMagazine.click();

        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.android.systemui:id/dismiss_task")));
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.MENU);

        AndroidElement firstXBtn = (AndroidElement) driver.findElements(By.id("com.ocd:id/row_media_x")).get(0);
        firstXBtn.click();


        List btnAfterCheckout = driver.findElements(By.xpath("//android.widget.TextView[@text='RETURN']"));
        Assert.assertEquals(EconomistMagBeforeReturn, "THE ECONOMIST");
        Assert.assertEquals(btnAfterCheckout.size(), 0);
    }

    @Test
    public void Test_04_RbdigitalComicCheckout(){
        WebDriverWait wait = new WebDriverWait(driver, 90);

        AndroidElement iconMenu = (AndroidElement) driver.findElement(By.id("com.ocd:id/top_icon_menu"));
        iconMenu.click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='MAGAZINES & COMICS']")));
        AndroidElement magazineComicTab = (AndroidElement) driver.findElement(By.xpath("//android.widget.TextView[@text='MAGAZINES & COMICS']"));
        magazineComicTab.click();


        AndroidElement secondFromListMagCom = (AndroidElement) driver.findElementsById("com.ocd:id/menu_child_name").get(2);
        secondFromListMagCom.click();


        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.android.systemui:id/dismiss_task")));
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);


        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/filter_label")));

        AndroidElement secondPage = (AndroidElement) driver.findElement(By.id("com.ocd:id/pagination_five"));
        secondPage.click();

        //TouchAction tB = new TouchAction(driver);

        //int count = 0;
        //while (driver.findElements(By.xpath("//android.widget.TextView[@text='X-MEN: DAYS OF FUTURE PAST - SPECIAL']")).size() == 0 && count < 10){

        //    tB.press(PointOption.point(540, 640)).moveTo(PointOption.point(540, 600)).release().perform();

        //}

        //AndroidElement mag = (AndroidElement) driver.findElement(By.xpath("//android.widget.TextView[@text='US WEEKLY']"));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='STAR TREK: BEST OF KLINGONS']")));
        AndroidElement firsComfrom2page = (AndroidElement) driver.findElements(By.id("com.ocd:id/row_media_container")).get(2);
        firsComfrom2page.click();

        String actualComDescription = driver.findElement(By.id("com.ocd:id/activity_media_info_description")).getText();

        AndroidElement checkoutBtn = (AndroidElement) driver.findElement(By.id("com.ocd:id/activity_media_info_play"));
        checkoutBtn.click();

        //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/confirmation_checkbox")));
        //AndroidElement confirmationCheckbox = (AndroidElement) driver.findElement(By.id("com.ocd:id/confirmation_checkbox"));
        //confirmationCheckbox.click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/dialog_ok_button")));
        AndroidElement okButton = (AndroidElement) driver.findElement(By.id("com.ocd:id/dialog_ok_button"));
        okButton.click();

        Assert.assertTrue(driver.findElement(By.id("com.ocd:id/activity_media_info_play")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("com.ocd:id/activity_media_info_left_button")).isDisplayed());
        Assert.assertTrue(actualComDescription.contains("Sharpen your bat'leth and prepare for war in this collection of unforgettable Klingon tales from the Star Trek universe. Including the original 4-part DC start to The Original Series as well as the 6-issue \"Klingons: Blood Will Tell\" series by Scott and David Tipton, this volume is fierce and loyal to the Empire. Heghlu'meH QaQ jajvam! Author: Scott Tipton, David Tipton, Mike W. Barr. Illustrator: David Messina, Tom Sutton, Ricardo Villigran, Sharp Bros. TM CBS Studios Inc. © 2013 Paramount Pictures Corp. STAR TREK and related marks and logos are trademarks of CBS Studios Inc. All Rights Reserved."));
    }

    @Test
    public void Test_05_RbdigitalComicsReturn(){
        WebDriverWait wait = new WebDriverWait(driver, 130);

        driver.findElementById("com.ocd:id/top_icon_menu").click();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='HOME']")));

        AndroidElement checkedOUTTabMenu = (AndroidElement) driver.findElement(By.xpath("//android.widget.TextView[@text='CHECKED OUT']"));
        checkedOUTTabMenu.click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='CHECKED OUT']")));

        TouchAction tA = new TouchAction(driver);

        int count = 0;
        while (driver.findElements(By.xpath("//android.widget.TextView[@text='STAR TREK, VOL. 5']")).size() == 0 && count < 7){

            tA.press(PointOption.point(540, 640)).moveTo(PointOption.point(540, 600)).release().perform();
            count++;
        }

        //TouchAction tA = new TouchAction(driver);
        //tA.press(PointOption.point(540, 800)).moveTo(PointOption.point(540, 600)).release().perform();


        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='STAR TREK, VOL. 5']")));
        String ComicBeforeReturn = driver.findElement(By.xpath("//android.widget.TextView[@text='STAR TREK, VOL. 5']")).getText();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.Button[@text='VIEW ALL']")));
        AndroidElement viewAllBtnForComics = (AndroidElement) driver.findElements(By.xpath("//android.widget.Button[@text='VIEW ALL']")).get(0);
        viewAllBtnForComics.click();

        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.android.systemui:id/dismiss_task")));
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);
        //((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.MENU);

        AndroidElement firstXBtn = (AndroidElement) driver.findElements(By.id("com.ocd:id/row_media_x")).get(0);
        firstXBtn.click();

        List returnedComics = driver.findElements(By.xpath("//android.widget.TextView[@text='STAR TREK, VOL. 5']"));
        Assert.assertEquals(ComicBeforeReturn, "STAR TREK, VOL. 5");
        Assert.assertEquals(returnedComics.size(), 0);
    }


    @Test
    public void Test_06_RbdigitalAudiobookCheckout(){
        WebDriverWait wait = new WebDriverWait(driver, 90);

        AndroidElement iconMenu = (AndroidElement) driver.findElement(By.id("com.ocd:id/top_icon_menu"));
        iconMenu.click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='BOOKS']")));
        AndroidElement bookTab = (AndroidElement) driver.findElement(By.xpath("//android.widget.TextView[@text='BOOKS']"));
        bookTab.click();


        AndroidElement firstFromListAudioBook = (AndroidElement) driver.findElementsById("com.ocd:id/menu_child_name").get(1);
        firstFromListAudioBook.click();


        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.android.systemui:id/dismiss_task")));
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);


        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='AUDIOBOOKS']")));

        AndroidElement viewAllBtn = (AndroidElement) driver.findElement(By.id("com.ocd:id/titles_header_view_all"));
        viewAllBtn.click();

        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.android.systemui:id/dismiss_task")));
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/pagination_two")));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/filter_label")));

        //TouchAction tB = new TouchAction(driver);

        //int count = 0;
        //while (driver.findElements(By.xpath("//android.widget.TextView[@text='X-MEN: DAYS OF FUTURE PAST - SPECIAL']")).size() == 0 && count < 10){

        //    tB.press(PointOption.point(540, 640)).moveTo(PointOption.point(540, 600)).release().perform();

        //}

        //AndroidElement mag = (AndroidElement) driver.findElement(By.xpath("//android.widget.TextView[@text='US WEEKLY']"));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/sort_spinner_text_view")));
        AndroidElement secondAudioBook = (AndroidElement) driver.findElements(By.id("com.ocd:id/row_media_container")).get(0);
        secondAudioBook.click();

        String actualAudioBookDescription = driver.findElement(By.id("com.ocd:id/activity_media_info_description")).getText();

        AndroidElement checkoutBtn = (AndroidElement) driver.findElement(By.id("com.ocd:id/activity_media_info_play"));
        checkoutBtn.click();

        //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/confirmation_checkbox")));
        //AndroidElement confirmationCheckbox = (AndroidElement) driver.findElement(By.id("com.ocd:id/confirmation_checkbox"));
        //confirmationCheckbox.click();

        //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/dialog_ok_button")));
        //AndroidElement okButton = (AndroidElement) driver.findElement(By.id("com.ocd:id/dialog_ok_button"));
        //okButton.click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/activity_media_info_play")));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/activity_media_info_left_button")));
        Assert.assertTrue(driver.findElement(By.id("com.ocd:id/activity_media_info_play")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("com.ocd:id/activity_media_info_left_button")).isDisplayed());
        Assert.assertTrue(actualAudioBookDescription.contains("Described as \"one of the best coming-of-age novels of the twentieth century,\" Theodore Weesner's modern American classic is now on audio! It's 1959. Sixteen-year-old Alex Housman has just stolen his fourteenth car and frankly doesn't know why. His divorced, working-class father grinds out the night shift at the local Chevy plant in Detroit and looks forward to the flask in his glove compartment and the open bottles of booze in his Flint, Michigan, home. Broke and fighting to survive, Alex and his father face the realities of estrangement, incarceration, and even violence as their lives unfold toward the climactic episode that a New York Times reviewer called \"one of the most profoundly powerful in American fiction.\" In this rich, beautifully crafted story, Weesner has written a transcendent piece of literature in deceptively simple language, painting a powerful portrait of a father and a son otherwise invisible among the mundane, everyday details of life in blue-collar America. It is a true and enduring American classic."));
    }

    @Test
    public void Test_07_RbdigitalAudiobookReturn() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 130);

        driver.findElementById("com.ocd:id/top_icon_menu").click();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='HOME']")));

        AndroidElement checkedOUTTabMenu = (AndroidElement) driver.findElement(By.xpath("//android.widget.TextView[@text='CHECKED OUT']"));
        checkedOUTTabMenu.click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='CHECKED OUT']")));

        //TouchAction tA = new TouchAction(driver);

        //int count = 0;
       // while (driver.findElements(By.xpath("//android.widget.TextView[@text='VITRIOL THE HUNTER']")).size() == 0 && count < 7){

          //  tA.press(PointOption.point(540, 640)).moveTo(PointOption.point(540, 600)).release().perform();

        //}

        //TouchAction tA = new TouchAction(driver);
        //tA.press(PointOption.point(540, 800)).moveTo(PointOption.point(540, 600)).release().perform();



        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(540, 500)).moveTo(PointOption.point(540, 800)).release().perform();

        //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='Anansi and the Magic Stick']")));

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.Button[@text='VIEW ALL']")));
        Thread.sleep(1500);
        AndroidElement viewAllBtnForComics = (AndroidElement) driver.findElements(By.xpath("//android.widget.Button[@text='VIEW ALL']")).get(0);
        viewAllBtnForComics.click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/filter_label")));

        int count = 0;
        while (driver.findElements(By.xpath("//android.widget.TextView[@text='FROM NORVELT TO NOWHERE']")).size() == 0 && count < 9){

            touchAction.press(PointOption.point(540, 900)).moveTo(PointOption.point(540, 500)).release().perform();
            count++;
        }


        String ComicBeforeReturn = driver.findElement(By.xpath("//android.widget.TextView[@text='FROM NORVELT TO NOWHERE']")).getText();


        //((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);
        //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.android.systemui:id/dismiss_task")));
        //((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);

        //AndroidElement lastAudioBook = (AndroidElement) driver.findElements(By.id("com.ocd:id/row_media_container")).get(2);
        //lastAudioBook.click();

        AndroidElement firstXBtn = (AndroidElement) driver.findElements(By.id("com.ocd:id/row_media_x")).get(0);
        firstXBtn.click();

        List returnedComics = driver.findElements(By.xpath("//android.widget.TextView[@text='FROM NORVELT TO NOWHERE']"));
        Assert.assertEquals(ComicBeforeReturn, "FROM NORVELT TO NOWHERE");
        Assert.assertEquals(returnedComics.size(), 0);
    }


    @Test
    public void Test_08_RbdigitalEBookCheckout(){
        WebDriverWait wait = new WebDriverWait(driver, 90);

        AndroidElement iconMenu = (AndroidElement) driver.findElement(By.id("com.ocd:id/top_icon_menu"));
        iconMenu.click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='BOOKS']")));
        AndroidElement bookTab = (AndroidElement) driver.findElement(By.xpath("//android.widget.TextView[@text='BOOKS']"));
        bookTab.click();


        AndroidElement firstFromListAudioBook = (AndroidElement) driver.findElementsById("com.ocd:id/menu_child_name").get(2);
        firstFromListAudioBook.click();


        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.android.systemui:id/dismiss_task")));
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);


        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='EBOOKS']")));

        AndroidElement viewAllBtn = (AndroidElement) driver.findElement(By.id("com.ocd:id/titles_header_view_all"));
        viewAllBtn.click();

        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.android.systemui:id/dismiss_task")));
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/pagination_two")));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/filter_label")));

        //TouchAction tB = new TouchAction(driver);

        //int count = 0;
        //while (driver.findElements(By.xpath("//android.widget.TextView[@text='X-MEN: DAYS OF FUTURE PAST - SPECIAL']")).size() == 0 && count < 10){

        //    tB.press(PointOption.point(540, 640)).moveTo(PointOption.point(540, 600)).release().perform();

        //}

        //AndroidElement mag = (AndroidElement) driver.findElement(By.xpath("//android.widget.TextView[@text='US WEEKLY']"));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/sort_spinner_text_view")));


        AndroidElement title = (AndroidElement) driver.findElements(By.id("com.ocd:id/row_media_title")).get(1);
        actualBookTitle = title.getText();

        AndroidElement secondEBook = (AndroidElement) driver.findElements(By.id("com.ocd:id/row_media_container")).get(1);
        secondEBook.click();


        AndroidElement checkoutBtn = (AndroidElement) driver.findElement(By.id("com.ocd:id/activity_media_info_play"));
        checkoutBtn.click();

        //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/confirmation_checkbox")));
        //AndroidElement confirmationCheckbox = (AndroidElement) driver.findElement(By.id("com.ocd:id/confirmation_checkbox"));
        //confirmationCheckbox.click();

        //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/dialog_ok_button")));
        //AndroidElement okButton = (AndroidElement) driver.findElement(By.id("com.ocd:id/dialog_ok_button"));
        //okButton.click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/activity_media_info_play")));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/activity_media_info_left_button")));
        Assert.assertTrue(driver.findElement(By.id("com.ocd:id/activity_media_info_play")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("com.ocd:id/activity_media_info_left_button")).isDisplayed());
        //Assert.assertTrue(actualAudioBookDescription.contains("Raising funds to fulfill a nonprofit organization's goals is critical to its success"));
    }

    @Test
    public void Test_09_RbdigitalEBookReturn() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 90);

        driver.findElementById("com.ocd:id/top_icon_menu").click();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='HOME']")));

        AndroidElement checkedOUTTabMenu = (AndroidElement) driver.findElement(By.xpath("//android.widget.TextView[@text='CHECKED OUT']"));
        checkedOUTTabMenu.click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='CHECKED OUT']")));

        //TouchAction tA = new TouchAction(driver);

        //int count = 0;
        // while (driver.findElements(By.xpath("//android.widget.TextView[@text='VITRIOL THE HUNTER']")).size() == 0 && count < 7){

        //  tA.press(PointOption.point(540, 640)).moveTo(PointOption.point(540, 600)).release().perform();

        //}

        //TouchAction tA = new TouchAction(driver);
        //tA.press(PointOption.point(540, 800)).moveTo(PointOption.point(540, 600)).release().perform();



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

        List returnedComics = driver.findElements(By.xpath("//android.widget.TextView[@text='"+actualBookTitle+"']"));
        //Assert.assertEquals(ComicBeforeReturn, "THE LAW OF FUNDRAISING");
        Assert.assertEquals(returnedComics.size(), 0);
    }

    @Test
    public void Test_10_SearchMagazine_Checkout_Return(){
        WebDriverWait wait = new WebDriverWait(driver, 90);
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
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.android.systemui:id/dismiss_task")));
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='PREVENTION']")));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='MAGAZINES']")));

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/sort_spinner_text_view")));
        AndroidElement firstMagFromSearch = (AndroidElement) driver.findElements(By.id("com.ocd:id/row_media_container")).get(0);
        firstMagFromSearch.click();

        String actualMagDescription = driver.findElement(By.id("com.ocd:id/activity_media_info_description")).getText();

        AndroidElement checkoutBtn = (AndroidElement) driver.findElement(By.id("com.ocd:id/activity_media_info_play"));
        checkoutBtn.click();

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
        Assert.assertTrue(actualMagDescription.contains("Prevention magazine gives you healthy solutions you can really live with."));
    }

    @Test
    public void Test_11_SearchComic_Checkout_Return(){
        WebDriverWait wait = new WebDriverWait(driver, 90);
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
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.android.systemui:id/dismiss_task")));
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='MINISULK']")));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='COMICS']")));

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/sort_spinner_text_view")));
        AndroidElement firstComFromSearch = (AndroidElement) driver.findElements(By.id("com.ocd:id/row_media_container")).get(0);
        firstComFromSearch.click();

        String actualComDescription = driver.findElement(By.id("com.ocd:id/activity_media_info_description")).getText();

        AndroidElement checkoutBtn = (AndroidElement) driver.findElement(By.id("com.ocd:id/activity_media_info_play"));
        checkoutBtn.click();

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
        WebDriverWait wait = new WebDriverWait(driver, 90);
        AndroidElement searchIcon = (AndroidElement) driver.findElement(By.id("com.ocd:id/top_icon_search"));
        searchIcon.click();

        AndroidElement audioBookTab = (AndroidElement) driver.findElement(By.id("com.ocd:id/search_select_audiobooks"));
        audioBookTab.click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.EditText[@text='Name']")));
        //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.EditText[@text='Title']")));

        AndroidElement nameEdit = (AndroidElement) driver.findElement(By.xpath("//android.widget.EditText[@text='Name']"));
        nameEdit.sendKeys("KINGS OF THE YUKON");

        //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='Minisulk']")));

        AndroidElement searchCommit = (AndroidElement) driver.findElement(By.id("com.ocd:id/search_commit"));
        searchCommit.click();

        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.android.systemui:id/dismiss_task")));
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='KINGS OF THE YUKON']")));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='AUDIOBOOKS']")));

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/sort_spinner_text_view")));
        AndroidElement firstAudiobookFromSearch = (AndroidElement) driver.findElements(By.id("com.ocd:id/row_media_container")).get(0);
        firstAudiobookFromSearch.click();

        String actualAudiobookDescription = driver.findElement(By.id("com.ocd:id/activity_media_info_description")).getText();

        AndroidElement checkoutBtn = (AndroidElement) driver.findElement(By.id("com.ocd:id/activity_media_info_play"));
        checkoutBtn.click();

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
        Assert.assertTrue(actualAudiobookDescription.contains("A stunning new voice in nature writing makes an epic journey along the Yukon River to give us the stories of its people and its protagonist"));
    }


    @Test
    public void Test_13_SearchEBook_Checkout_Return(){
        WebDriverWait wait = new WebDriverWait(driver, 90);
        AndroidElement searchIcon = (AndroidElement) driver.findElement(By.id("com.ocd:id/top_icon_search"));
        searchIcon.click();

        AndroidElement EBookTab = (AndroidElement) driver.findElement(By.id("com.ocd:id/search_select_ebooks"));
        EBookTab.click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.EditText[@text='Name']")));
        //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.EditText[@text='Title']")));

        AndroidElement nameEdit = (AndroidElement) driver.findElement(By.xpath("//android.widget.EditText[@text='Name']"));
        nameEdit.sendKeys("THE GREEN ROAD");

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='The Green Road']")));

        AndroidElement searchCommit = (AndroidElement) driver.findElement(By.id("com.ocd:id/search_commit"));
        searchCommit.click();

        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.android.systemui:id/dismiss_task")));
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='THE GREEN ROAD']")));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='EBOOKS']")));

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/sort_spinner_text_view")));
        AndroidElement firstBookFromSearch = (AndroidElement) driver.findElements(By.id("com.ocd:id/row_media_container")).get(0);
        firstBookFromSearch.click();

        String actualBookDescription = driver.findElement(By.id("com.ocd:id/activity_media_info_description")).getText();

        AndroidElement checkoutBtn = (AndroidElement) driver.findElement(By.id("com.ocd:id/activity_media_info_play"));
        checkoutBtn.click();

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
        Assert.assertTrue(actualBookDescription.contains("By the Booker Award-winning bestselling author of The Gathering, The Green Road"));
    }

*/
    @Test
    public void Test_14_AcornTV_Checkout() {
        WebDriverWait wait = new WebDriverWait(driver, 90);

        driver.findElementById("com.ocd:id/top_icon_menu").click();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='HOME']")));

        AndroidElement entertainmentTabMenu = (AndroidElement) driver.findElement(By.xpath("//android.widget.TextView[@text='ENTERTAINMENT']"));
        entertainmentTabMenu.click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='ENTERTAINMENT']")));

        AndroidElement ACORNTV = (AndroidElement) driver.findElement(By.xpath("//android.widget.TextView[@text='ACORN TV - BRITISH TV']"));
        ACORNTV.click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.view.View[@text='800words']")));

        AndroidElement acornElement800words = (AndroidElement) driver.findElement(By.xpath("//android.view.View[@text='800words']"));
        acornElement800words.click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("access")));
        AndroidElement checkoutBtn = (AndroidElement) driver.findElement(By.id("access"));
        checkoutBtn.click();

    }




    public void swipeVertical(AppiumDriver<MobileElement> driver, double startPercentage, double finalPercentage, int duration){
        Dimension size = driver.manage().window().getSize();
        int width = (int) (size.width/2);
        int startPoint = (int) (size.getHeight() * startPercentage);
        int endPoint = (int) (size.getHeight() * finalPercentage);
        new TouchAction(driver).press(PointOption.point(width, startPoint)).moveTo(PointOption.point(width, endPoint)).release().perform();

    }
}