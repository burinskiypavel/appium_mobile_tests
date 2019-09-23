import Pages.MainPage;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class RBdigitalTests_Xiaomi_cable_2 extends BaseTest {

    MainPage mainPage;
    //BaseTest baseTest;

    String actualAudioBookTitle;
    String actualBookTitle;
    String audiobookTitlewishlist;
    String bookTitlewishlist;
    String audiobookHold;
    String ebookHold;


    @AfterMethod
    void AfterMethod() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);

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
        //baseTest = new BaseTest(driver);
        mainPage.Login("qauser", "password1");
    }


    @Test
    public void Test_19_AudiobookHold() {
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

        AndroidElement firstAudioBook = (AndroidElement) driver.findElements(By.id("com.ocd:id/row_media_container")).get(0);
        firstAudioBook.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='DESCRIPTION']")));

        if (driver.findElements(By.xpath("//android.widget.TextView[@text='REMOVE HOLD']")).size() != 0) {
            driver.findElement(By.xpath("//android.widget.TextView[@text='REMOVE HOLD']")).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='HOLD']")));
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

}
