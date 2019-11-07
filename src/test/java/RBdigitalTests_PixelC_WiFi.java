import io.appium.java_client.*;
import io.appium.java_client.android.*;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import java.net.URL;
import java.time.Duration;
import java.util.List;

public class RBdigitalTests_PixelC_WiFi {

    //WebDriver driver;
    AppiumDriver driver;
    //AndroidDriver driver;
    BaseTest baseTest;



    //@AfterClass
    //void afterClass() {
        //driver.close();
    //    driver.quit();
   // }

    @AfterMethod
    void AfterMethod() {
        // clean up system after test
        WebDriverWait wait = new WebDriverWait(driver, 90);
        driver.findElementById("com.ocd:id/top_icon_menu").click();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='HOME']")));
        driver.findElementByXPath("//android.widget.TextView[@text='HOME']").click();
    }


    @Test
    public void Test_01_RunRbdigital_Login() throws Exception {

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName", "Pixel C");
        //cap.setCapability("udid", "6118001501");
        cap.setCapability("udid", "6118001501");// 10.3.21.165:5555
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "8.1.0.");
        cap.setCapability("appPackage", "com.ocd");
        cap.setCapability("appActivity", "com.ocd.activity.SplashActivity");

        cap.setCapability("noReset", false);


        //((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);


        //URL url = new URL(" http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver(new URL(" http://127.0.0.1:4723/wd/hub"), cap);

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

        AndroidElement nextBtn = (AndroidElement) driver.findElement(By.id("com.ocd:id/add_profile_submit"));
        nextBtn.click();


        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);
        //((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.HOME);
        //try {
        //    Activity activity = new Activity("com.ocd", "com.ocd.activity.SplashActivity");
         //   activity.setStopApp(false);
         //   ((AndroidDriver) driver).startActivity(activity);
            //((AndroidDriver<MobileElement>) driver).startActivity(activity);
       // } catch (Exception e) {
       //     e.printStackTrace();
        //}


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
        AndroidElement firstMag = (AndroidElement) driver.findElements(By.id("com.ocd:id/row_media_container")).get(0);
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
        WebDriverWait wait = new WebDriverWait(driver, 130);

        driver.findElementById("com.ocd:id/top_icon_menu").click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='CHECKED OUT']")));
        AndroidElement checkedOUTTabMenu = (AndroidElement) driver.findElement(By.xpath("//android.widget.TextView[@text='CHECKED OUT']"));
        checkedOUTTabMenu.click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='THE ECONOMIST']")));
        String EconomistMagBeforeReturn = driver.findElement(By.xpath("//android.widget.TextView[@text='THE ECONOMIST']")).getText();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.Button[@text='VIEW ALL']")));

        //List<WebElement> a = driver.findElements(By.xpath("//android.widget.Button[@text='VIEW ALL']"));
        //a.get(2).click();

        AndroidElement viewAllBtnForMagazine = (AndroidElement) driver.findElements(By.xpath("//android.widget.Button[@text='VIEW ALL']")).get(2);
        viewAllBtnForMagazine.click();

        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);
        //((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.MENU);

        AndroidElement firstXBtn = (AndroidElement) driver.findElements(By.id("com.ocd:id/row_media_x")).get(0);
        firstXBtn.click();

        List returnedEconomistMag = driver.findElements(By.xpath("//android.widget.TextView[@text='THE ECONOMIST']"));
        Assert.assertEquals(EconomistMagBeforeReturn, "THE ECONOMIST");
        Assert.assertEquals(returnedEconomistMag.size(), 0);
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

        //AndroidElement mag = (AndroidElement) driver.findElement(By.xpath("//android.widget.TextView[@text='US WEEKLY']"));
        AndroidElement ninethCom = (AndroidElement) driver.findElements(By.id("com.ocd:id/row_media_container")).get(8);
        ninethCom.click();

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
        Assert.assertTrue(actualComDescription.contains("Collects Uncanny X-Men (1963) #101-110. Wolverine, Nightcrawler, Storm, Colossus; Endowed with unique abilities, these mutants were summoned by Professor X to rescue the original X-Men, an underground organization sworn to protect those that fear and hate them. Relive their original adventures; discover the human within the hero and the truth behind the legend!"));
    }

    @Test
    public void Test_05_RbdigitalComicsReturn(){
        WebDriverWait wait = new WebDriverWait(driver, 130);

        driver.findElementById("com.ocd:id/top_icon_menu").click();

        AndroidElement checkedOUTTabMenu = (AndroidElement) driver.findElement(By.xpath("//android.widget.TextView[@text='CHECKED OUT']"));
        checkedOUTTabMenu.click();

        swipeVertical(driver, 0.7, 0.2, 1);


        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='UNCANNY X-MEN MASTERWORKS VOL. 2 - Special']")));
        String ComicBeforeReturn = driver.findElement(By.xpath("//android.widget.TextView[@text='UNCANNY X-MEN MASTERWORKS VOL. 2 - Special']")).getText();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.Button[@text='VIEW ALL']")));
        AndroidElement viewAllBtnForComics = (AndroidElement) driver.findElements(By.xpath("//android.widget.Button[@text='VIEW ALL']")).get(3);
        viewAllBtnForComics.click();

        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);
        //((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.MENU);

        AndroidElement firstXBtn = (AndroidElement) driver.findElements(By.id("com.ocd:id/row_media_x")).get(0);
        firstXBtn.click();

        List returnedComics = driver.findElements(By.xpath("//android.widget.TextView[@text='UNCANNY X-MEN MASTERWORKS VOL. 2 - Special']"));
        Assert.assertEquals(ComicBeforeReturn, "UNCANNY X-MEN MASTERWORKS VOL. 2 - Special");
        Assert.assertEquals(returnedComics.size(), 0);
    }

    @Test(enabled=false)
    public void runRbdigital_Register() throws Exception {

        DesiredCapabilities cap = new DesiredCapabilities();
        //cap.setCapability("deviceName", "Galaxy S6");
        cap.setCapability("deviceName", "Pixel C");
        cap.setCapability("udid", "6118001501");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "8.1.0.");
        cap.setCapability("appPackage", "com.ocd");
        cap.setCapability("appActivity", "com.ocd.activity.SplashActivity");

        //cap.setCapability("automationName", "uiautomator2");


        //cap.setCapability("autoGrantPermissions", true);


        //URL url = new URL(" http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver(new URL(" http://127.0.0.1:4723/wd/hub"), cap);


        WebDriverWait wait = new WebDriverWait(driver, 90);

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/register_button")));
        MobileElement registerBtn = (MobileElement) driver.findElement(By.id("com.ocd:id/register_button"));
        registerBtn.click();

        MobileElement chooseCountryDropdown = (MobileElement) driver.findElement(By.id("android:id/text1"));
        chooseCountryDropdown.click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@class='android.widget.CheckedTextView'][@text='USA']")));
        MobileElement usa = (MobileElement) driver.findElement(By.xpath("//*[@class='android.widget.CheckedTextView'][@text='USA']"));
        usa.click();

        MobileElement chooseStateBtn = (MobileElement) driver.findElement(By.id("com.ocd:id/btn_choose"));
        chooseStateBtn.click();

        MobileElement chooseStateDropdown = (MobileElement) driver.findElement(By.id("android:id/text1"));
        chooseStateDropdown.click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@class='android.widget.CheckedTextView'][@text='Maryland']")));
        MobileElement Maryland = (MobileElement) driver.findElement(By.xpath("//*[@class='android.widget.CheckedTextView'][@text='Maryland']"));
        Maryland.click();

        MobileElement chooseLibraryBtn = (MobileElement) driver.findElement(By.id("com.ocd:id/btn_choose"));
        chooseLibraryBtn.click();


        //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@class='android.widget.EditText'][@text='Tap and Search']")));
        //MobileElement chooseLibraryEdit = (MobileElement) driver.findElement(By.id("com.ocd:id/library_search_box"));


        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.HOME);
        try {
            Activity activity = new Activity("com.ocd", "com.ocd.activity.SplashActivity");
            activity.setStopApp(false);
            ((AndroidDriver) driver).startActivity(activity);
            //((AndroidDriver<MobileElement>) driver).startActivity(activity);
        } catch (Exception e) {
            e.printStackTrace();
        }

        WebElement chooseLibraryEdit =  driver.findElement(By.xpath("//*[@class='android.widget.EditText'][@text='Tap and Search']"));
        chooseLibraryEdit.sendKeys("testtest");

        MobileElement chooseLibrarySerchResult = (MobileElement) driver.findElement(By.id("com.ocd:id/btn_choose"));
        chooseLibrarySerchResult.click();

        MobileElement createAccountBtn = (MobileElement) driver.findElement(By.id("com.ocd:id/btn_choose"));
        createAccountBtn.click();

        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.HOME);
        try {
            Activity activity = new Activity("com.ocd", "com.ocd.activity.SplashActivity");
            activity.setStopApp(false);
            ((AndroidDriver) driver).startActivity(activity);
            //((AndroidDriver<MobileElement>) driver).startActivity(activity);
        } catch (Exception e) {
            e.printStackTrace();
        }

        MobileElement PrivacyPolicyCheckBox = (MobileElement) driver.findElement(By.id("com.ocd:id/checkbox_agree"));
        PrivacyPolicyCheckBox.click();

        MobileElement accessCode = (MobileElement) driver.findElement(By.xpath("//*[@class='android.widget.EditText'][@text='Enter access code']"));
        accessCode.sendKeys("pointbreak");

        MobileElement userName = (MobileElement) driver.findElement(By.xpath("//*[@class='android.widget.EditText'][@text='Create username']"));
        userName.sendKeys("jul5@gmail.com");

        MobileElement password = (MobileElement) driver.findElement(By.xpath("//*[@class='android.widget.EditText'][@text='Create password']"));
        password.sendKeys("12345qw");

        MobileElement cofirmPassword = (MobileElement) driver.findElement(By.xpath("//*[@class='android.widget.EditText'][@text='Confirm password']"));
        cofirmPassword.sendKeys("12345qw");

        MobileElement firstName = (MobileElement) driver.findElement(By.xpath("//*[@class='android.widget.EditText'][@text='Enter first name']"));
        firstName.sendKeys("jul3Test");

        MobileElement lastName = (MobileElement) driver.findElement(By.xpath("//*[@class='android.widget.EditText'][@text='Enter last name']"));
        lastName.sendKeys("QA");

        MobileElement email = (MobileElement) driver.findElement(By.xpath("//*[@class='android.widget.EditText'][@text='Enter email address']"));
        email.sendKeys("jul5@gmail.com");

        MobileElement ConfirmEmail = (MobileElement) driver.findElement(By.xpath("//*[@class='android.widget.EditText'][@text='Confirm email address']"));
        ConfirmEmail.sendKeys("jul5@gmail.com");

        MobileElement postalCode = (MobileElement) driver.findElement(By.xpath("//*[@class='android.widget.EditText'][@text='Enter postal code']"));
        postalCode.sendKeys("12345");


        if(((AndroidDriver) driver).isKeyboardShown()) {
            driver.hideKeyboard();
        }


        MobileElement registerBtnCofirm = (MobileElement) driver.findElement(By.id("com.ocd:id/btn_choose"));
        registerBtnCofirm.click();
        Thread.sleep(1000);
        MobileElement allowRBdigitalToAccessPhotosMediaAndFilesOnYourDevice = (MobileElement) driver.findElement(By.id("com.android.packageinstaller:id/permission_deny_button"));
        allowRBdigitalToAccessPhotosMediaAndFilesOnYourDevice.click();
        Thread.sleep(1000);

        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='android.widget.TextView'][@text='HOME']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("com.ocd:id/top_icon_menu")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("com.ocd:id/top_icon_search")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='android.widget.TextView'][@text='AUDIOBOOKS']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='android.widget.Button'][@text='VIEW ALL']")).isDisplayed());


    }

    //public static void minimizeMaximize() {
    //    try {
    //        driver.runAppInBackground(10);
    //        ((AndroidDriver) driver).startActivity("appPackage", "appActivity");
   //     } catch (Exception e) {
    //        e.printStackTrace();
   //     }
  //  }

    //public static void minimizeMaximize() {
      //  try {
     //       driver.runAppInBackground(10);
     //       ((AndroidDriver) driver).startActivity("com.example.test", "com.example.LaunchApp");
    //    } catch (Exception e) {
    //        e.printStackTrace();
     //   }
   // }

    public void swipeVertical(AppiumDriver<MobileElement> driver, double startPercentage, double finalPercentage, int duration){
        Dimension size = driver.manage().window().getSize();
        int width = (int) (size.width/2);
        int startPoint = (int) (size.getHeight() * startPercentage);
        int endPoint = (int) (size.getHeight() * finalPercentage);
        new TouchAction(driver).press(PointOption.point(width, startPoint)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(duration))).moveTo(PointOption.point(width, endPoint)).release().perform();
    }
}