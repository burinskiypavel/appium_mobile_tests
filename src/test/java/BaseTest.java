import Steps.CheckoutsSteps;
import Steps.PixelCSteps;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

import java.time.Duration;
import java.util.List;

public class BaseTest {
    //public WebDriver driver;
    AppiumDriver driver;
    WebDriverWait wait;
    PixelCSteps pixelCSteps;
    CheckoutsSteps checkoutsSteps;

    //private WebDriver webDriver;
    //public BaseTest(WebDriver driver2001) {
    //    this.driver = driver2001;
    //}


    @AfterClass
    void afterClass() {
        driver.quit();
        //driver.close();
    }

    public void goToComicsPage() {
        wait = new WebDriverWait(driver, 30);
        AndroidElement iconMenu = (AndroidElement) driver.findElement(By.id("com.ocd:id/top_icon_menu"));
        iconMenu.click();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='MAGAZINES & COMICS']")));
        AndroidElement magazineComicTab = (AndroidElement) driver.findElement(By.xpath("//android.widget.TextView[@text='MAGAZINES & COMICS']"));
        magazineComicTab.click();

        AndroidElement secondFromListMagCom = (AndroidElement) driver.findElementsById("com.ocd:id/menu_child_name").get(2);
        secondFromListMagCom.click();

        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='RBdigital']")));
        driver.findElement(By.xpath("//android.widget.TextView[@text='RBdigital']")).click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/filter_label")));
    }

    public void goToMagazinePage() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        AndroidElement iconMenu = (AndroidElement) driver.findElement(By.id("com.ocd:id/top_icon_menu"));
        iconMenu.click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='MAGAZINES & COMICS']")));
        AndroidElement magazineComicTab = (AndroidElement) driver.findElement(By.xpath("//android.widget.TextView[@text='MAGAZINES & COMICS']"));
        magazineComicTab.click();

        Thread.sleep(850);
        AndroidElement firstFromListMagazine = (AndroidElement) driver.findElementsById("com.ocd:id/menu_child_name").get(1);
        firstFromListMagazine.click();

        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='RBdigital']")));
        driver.findElement(By.xpath("//android.widget.TextView[@text='RBdigital']")).click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/filter_label")));
    }

    public void goToWishlistPage() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.findElementById("com.ocd:id/top_icon_menu").click();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='HOME']")));

        AndroidElement myAccountTabMenu = (AndroidElement) driver.findElement(By.xpath("//android.widget.TextView[@text='MY ACCOUNT']"));
        myAccountTabMenu.click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='MY ACCOUNT']")));

        //AndroidElement wishlistTabMenu = (AndroidElement) driver.findElement(By.xpath("//android.widget.TextView[@text='WISHLIST']"));
        AndroidElement wishlistTabMenu = (AndroidElement) driver.findElements(By.id("com.ocd:id/menu_child_icon")).get(1);
        wishlistTabMenu.click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='WISHLIST']")));
    }

    public void goToHoldPage() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.findElementById("com.ocd:id/top_icon_menu").click();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='HOME']")));

        AndroidElement myAccountTabMenu = (AndroidElement) driver.findElement(By.xpath("//android.widget.TextView[@text='MY ACCOUNT']"));
        myAccountTabMenu.click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='MY ACCOUNT']")));

        //AndroidElement wishlistTabMenu = (AndroidElement) driver.findElement(By.xpath("//android.widget.TextView[@text='WISHLIST']"));
        AndroidElement holdTabMenu = (AndroidElement) driver.findElements(By.id("com.ocd:id/menu_child_icon")).get(2);//2 hold
        holdTabMenu.click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='HOLDS']")));
    }

    public void goToCheckedOutPage() {
        WebDriverWait wait = new WebDriverWait(driver, 40);

        wait.until(ExpectedConditions.elementToBeClickable(By.id("com.ocd:id/top_icon_menu")));
        driver.findElementById("com.ocd:id/top_icon_menu").click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='CHECKED OUT']")));
        AndroidElement checkedOUTTabMenu = (AndroidElement) driver.findElement(By.xpath("//android.widget.TextView[@text='CHECKED OUT']"));
        checkedOUTTabMenu.click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='CHECKED OUT']")));
    }

    public void goToCheckedOutViewAllEbookPage() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 40);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(540, 500)).moveTo(PointOption.point(540, 800)).release().perform();

        Thread.sleep(1500);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.Button[@text='VIEW ALL']")));
        AndroidElement viewAllBtnForComics = (AndroidElement) driver.findElements(By.xpath("//android.widget.Button[@text='VIEW ALL']")).get(1);
        viewAllBtnForComics.click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/filter_label")));
    }

    public void goToAudiobookViewAllPage() {
        WebDriverWait wait = new WebDriverWait(driver, 40);
        AndroidElement iconMenu = (AndroidElement) driver.findElement(By.id("com.ocd:id/top_icon_menu"));
        iconMenu.click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='BOOKS']")));
        AndroidElement bookTab = (AndroidElement) driver.findElement(By.xpath("//android.widget.TextView[@text='BOOKS']"));
        bookTab.click();

        AndroidElement firstFromListAudioBook = (AndroidElement) driver.findElementsById("com.ocd:id/menu_child_name").get(1);
        firstFromListAudioBook.click();

        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='RBdigital']")));
        driver.findElement(By.xpath("//android.widget.TextView[@text='RBdigital']")).click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='AUDIOBOOKS']")));

        AndroidElement viewAllBtn = (AndroidElement) driver.findElement(By.id("com.ocd:id/titles_header_view_all"));
        viewAllBtn.click();

        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='RBdigital']")));
        driver.findElement(By.xpath("//android.widget.TextView[@text='RBdigital']")).click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/pagination_two")));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/filter_label")));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/sort_spinner_text_view")));
    }

    public void goToAudiobookPage() {
        WebDriverWait wait = new WebDriverWait(driver, 40);
        AndroidElement iconMenu = (AndroidElement) driver.findElement(By.id("com.ocd:id/top_icon_menu"));
        iconMenu.click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='BOOKS']")));
        AndroidElement bookTab = (AndroidElement) driver.findElement(By.xpath("//android.widget.TextView[@text='BOOKS']"));
        bookTab.click();

        AndroidElement firstFromListAudioBook = (AndroidElement) driver.findElementsById("com.ocd:id/menu_child_name").get(1);
        firstFromListAudioBook.click();

        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='RBdigital']")));
        driver.findElement(By.xpath("//android.widget.TextView[@text='RBdigital']")).click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='AUDIOBOOKS']")));
    }

    public void goToEBookViewAllPage() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        AndroidElement iconMenu = (AndroidElement) driver.findElement(By.id("com.ocd:id/top_icon_menu"));
        iconMenu.click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='BOOKS']")));
        AndroidElement bookTab = (AndroidElement) driver.findElement(By.xpath("//android.widget.TextView[@text='BOOKS']"));
        bookTab.click();

        AndroidElement firstFromListAudioBook = (AndroidElement) driver.findElementsById("com.ocd:id/menu_child_name").get(2);
        firstFromListAudioBook.click();

        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='RBdigital']")));
        driver.findElement(By.xpath("//android.widget.TextView[@text='RBdigital']")).click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='EBOOKS']")));

        AndroidElement viewAllBtn = (AndroidElement) driver.findElement(By.id("com.ocd:id/titles_header_view_all"));
        viewAllBtn.click();

        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='RBdigital']")));
        driver.findElement(By.xpath("//android.widget.TextView[@text='RBdigital']")).click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/pagination_two")));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/filter_label")));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/sort_spinner_text_view")));
    }

    public void goToEBookPage() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        AndroidElement iconMenu = (AndroidElement) driver.findElement(By.id("com.ocd:id/top_icon_menu"));
        iconMenu.click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='BOOKS']")));
        AndroidElement bookTab = (AndroidElement) driver.findElement(By.xpath("//android.widget.TextView[@text='BOOKS']"));
        bookTab.click();

        AndroidElement firstFromListAudioBook = (AndroidElement) driver.findElementsById("com.ocd:id/menu_child_name").get(2);
        firstFromListAudioBook.click();

        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='RBdigital']")));
        driver.findElement(By.xpath("//android.widget.TextView[@text='RBdigital']")).click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='EBOOKS']")));
    }

    public void pressCheckoutAudiobook() {
        WebDriverWait wait = new WebDriverWait(driver, 45);

        if(driver.findElements(By.xpath("//android.widget.TextView[@text='PLAY']")).size() != 0){
            driver.findElement(By.xpath("//android.widget.TextView[@text='RETURN']")).click();
            driver.findElement(By.xpath("//android.widget.Button[@text='YES']")).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.id("com.ocd:id/activity_media_info_play")));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='PLAY']")));
        }

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/activity_media_info_play")));
        AndroidElement checkoutBtn = (AndroidElement) driver.findElement(By.id("com.ocd:id/activity_media_info_play"));
        checkoutBtn.click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/activity_media_info_play")));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/activity_media_info_left_button")));
    }

    public void openElement(int number) {
        AndroidElement firstMag = (AndroidElement) driver.findElements(By.id("com.ocd:id/row_media_container")).get(number);
        firstMag.click();
    }

    public void openElementFromSearchResult(int number) {
        number = number - 1;
        AndroidElement firstMag = (AndroidElement) driver.findElements(By.id("com.ocd:id/row_media_container")).get(number);
        firstMag.click();
    }

    public String getTitleOfElement(int number) {
        AndroidElement titleMag = (AndroidElement) driver.findElements(By.id("com.ocd:id/row_media_title")).get(number);
        String actualTitle = titleMag.getText();
        return actualTitle;
    }

    public String getDescriptionOfElement() {
        String actualElementDescription = driver.findElement(By.id("com.ocd:id/activity_media_info_description")).getText();
        return actualElementDescription;
    }

    public void pressMagCheckout() {
        WebDriverWait wait = new WebDriverWait(driver, 49);

        if(driver.findElements(By.xpath("//android.widget.TextView[@text='READ']")).size() != 0){
           driver.findElement(By.xpath("//android.widget.TextView[@text='RETURN']")).click();
           driver.findElement(By.xpath("//android.widget.Button[@text='YES']")).click();
           wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/activity_media_info_play")));
           wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='READ']")));
        }

        AndroidElement checkoutBtn = (AndroidElement) driver.findElement(By.id("com.ocd:id/activity_media_info_play"));
        checkoutBtn.click();

        //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/confirmation_checkbox")));
        //AndroidElement confirmationCheckbox = (AndroidElement) driver.findElement(By.id("com.ocd:id/confirmation_checkbox"));
        //confirmationCheckbox.click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/dialog_ok_button")));
        AndroidElement okButton = (AndroidElement) driver.findElement(By.id("com.ocd:id/dialog_ok_button"));
        okButton.click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/activity_media_info_left_button")));
    }

    public void pressComCheckout() {
        WebDriverWait wait = new WebDriverWait(driver, 49);

        if(driver.findElements(By.xpath("//android.widget.TextView[@text='READ']")).size() != 0){
            driver.findElement(By.xpath("//android.widget.TextView[@text='RETURN']")).click();
            driver.findElement(By.xpath("//android.widget.Button[@text='YES']")).click();
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/activity_media_info_play")));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='READ']")));
        }

        AndroidElement checkoutBtn = (AndroidElement) driver.findElement(By.id("com.ocd:id/activity_media_info_play"));
        checkoutBtn.click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/dialog_ok_button")));
        AndroidElement okButton = (AndroidElement) driver.findElement(By.id("com.ocd:id/dialog_ok_button"));
        okButton.click();
    }

    public void returnMagazine(String actualMagTitle) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        TouchAction tA = new TouchAction(driver);
        int count = 0;
        while (driver.findElements(By.xpath("//android.widget.TextView[@text='"+actualMagTitle+"']")).size() == 0 && count < 7){

            tA.press(PointOption.point(540, 640)).moveTo(PointOption.point(540, 600)).release().perform();
            count++;
        }

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='"+actualMagTitle+"']")));
        String EconomistMagBeforeReturn = driver.findElement(By.xpath("//android.widget.TextView[@text='"+actualMagTitle+"']")).getText();

        Thread.sleep(1500);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.Button[@text='VIEW ALL']")));
        AndroidElement viewAllBtnForMagazine = (AndroidElement) driver.findElements(By.xpath("//android.widget.Button[@text='VIEW ALL']")).get(0);
        viewAllBtnForMagazine.click();

        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='RBdigital']")));
        driver.findElement(By.xpath("//android.widget.TextView[@text='RBdigital']")).click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/row_media_x")));
        //AndroidElement firstXBtn = (AndroidElement) driver.findElements(By.id("com.ocd:id/row_media_x")).get(0);
        //firstXBtn.click();
        //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("android:id/progress")));
        //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='"+actualMagTitle+"']")));
        AndroidElement mag = (AndroidElement) driver.findElements(By.id("com.ocd:id/row_media_container")).get(0);
        mag.click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='RETURN']")));

        driver.findElement(By.xpath("//android.widget.TextView[@text='RETURN']")).click();
        driver.findElement(By.xpath("//android.widget.Button[@text='YES']")).click();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/activity_media_info_play")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='READ']")));
    }

    public void returnComic(String actualComTitle) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 49);
        TouchAction tA = new TouchAction(driver);

        int count = 0;
        while (driver.findElements(By.xpath("//android.widget.TextView[@text='"+actualComTitle+"']")).size() == 0 && count < 7){

            tA.press(PointOption.point(540, 640)).moveTo(PointOption.point(540, 600)).release().perform();
            count++;
        }

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='"+actualComTitle+"']")));
        String ComicBeforeReturn = driver.findElement(By.xpath("//android.widget.TextView[@text='"+actualComTitle+"']")).getText();

        Thread.sleep(1500);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.Button[@text='VIEW ALL']")));
        AndroidElement viewAllBtnForComics = (AndroidElement) driver.findElements(By.xpath("//android.widget.Button[@text='VIEW ALL']")).get(0);
        viewAllBtnForComics.click();

        Thread.sleep(1200);

        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='RBdigital']")));
        driver.findElement(By.xpath("//android.widget.TextView[@text='RBdigital']")).click();
        //((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.MENU);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.ocd:id/row_media_x")));
        //AndroidElement firstXBtn = (AndroidElement) driver.findElements(By.id("com.ocd:id/row_media_x")).get(0);
        //firstXBtn.click();
        //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("android:id/progress")));
        //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='"+actualComTitle+"']")));
        AndroidElement mag = (AndroidElement) driver.findElements(By.id("com.ocd:id/row_media_container")).get(0);
        mag.click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='RETURN']")));

        driver.findElement(By.xpath("//android.widget.TextView[@text='RETURN']")).click();
        driver.findElement(By.xpath("//android.widget.Button[@text='YES']")).click();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/activity_media_info_play")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='READ']")));
    }

    public void thenIShouldSeeReturnBtn() {
        Assert.assertTrue(driver.findElement(By.id("com.ocd:id/activity_media_info_left_button")).isDisplayed());
    }

    public void thenIShouldSeeReadBtn() {
        Assert.assertTrue(driver.findElement(By.id("com.ocd:id/activity_media_info_play")).isDisplayed());
    }

    public void thenIShouldSeeCheckoutBtn() {
        Assert.assertTrue(driver.findElement(By.xpath("//android.widget.TextView[@text='CHECKOUT']")).isDisplayed());
    }

    public void thenIShouldNotSeeReturnBtn() {
        List btnAfterCheckout = driver.findElements(By.xpath("//android.widget.TextView[@text='RETURN']"));
        Assert.assertEquals(btnAfterCheckout.size(), 0);
    }

    public void openCheckedOutEAudioPage(){
        WebDriverWait wait = new WebDriverWait(driver, 45);
        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(540, 500)).moveTo(PointOption.point(540, 800)).release().perform();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.Button[@text='VIEW ALL']")));
        AndroidElement viewAllBtnForComics = (AndroidElement) driver.findElements(By.xpath("//android.widget.Button[@text='VIEW ALL']")).get(0);
        viewAllBtnForComics.click();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/filter_label")));
    }

    public void returnAudiobook(String actualAudioBookTitle) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        TouchAction touchAction = new TouchAction(driver);
        int count = 0;
        while (driver.findElements(By.xpath("//android.widget.TextView[@text='"+actualAudioBookTitle+"']")).size() == 0 && count < 9){

            touchAction.press(PointOption.point(540, 900)).moveTo(PointOption.point(540, 500)).release().perform();
            count++;
        }
        AndroidElement firstXBtn = (AndroidElement) driver.findElements(By.id("com.ocd:id/row_media_x")).get(0);
        firstXBtn.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("android:id/progress")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='"+actualAudioBookTitle+"']")));
    }

    public void returnEbook(String actualBookTitle){
        TouchAction touchAction = new TouchAction(driver);
        WebDriverWait wait = new WebDriverWait(driver, 30);

        int count = 0;
        while (driver.findElements(By.xpath("//android.widget.TextView[@text='"+actualBookTitle+"']")).size() == 0 && count < 9){

            touchAction.press(PointOption.point(540, 900)).moveTo(PointOption.point(540, 500)).release().perform();
            count++;
        }

        AndroidElement firstXBtn = (AndroidElement) driver.findElements(By.id("com.ocd:id/row_media_x")).get(0);
        firstXBtn.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("android:id/progress")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='"+actualBookTitle+"']")));
    }

    public void pressCheckoutEBook() {
        WebDriverWait wait = new WebDriverWait(driver, 30);

        if(driver.findElements(By.xpath("//android.widget.TextView[@text='READ']")).size() != 0){
            driver.findElement(By.xpath("//android.widget.TextView[@text='RETURN']")).click();
            driver.findElement(By.xpath("//android.widget.Button[@text='YES']")).click();
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/activity_media_info_play")));
        }

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/activity_media_info_play")));
        AndroidElement checkoutBtn = (AndroidElement) driver.findElement(By.id("com.ocd:id/activity_media_info_play"));
        checkoutBtn.click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/activity_media_info_play")));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/activity_media_info_left_button")));
    }

    public void pressCheckout() {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/activity_media_info_play")));
        AndroidElement checkoutBtn = (AndroidElement) driver.findElement(By.id("com.ocd:id/activity_media_info_play"));
        checkoutBtn.click();
    }

    public void searchMagazineByTitle(String title){
        WebDriverWait wait = new WebDriverWait(driver, 50);

        AndroidElement magazinesTab = (AndroidElement) driver.findElement(By.id("com.ocd:id/search_select_magazines"));
        magazinesTab.click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.EditText[@text='Name']")));

        AndroidElement nameEdit = (AndroidElement) driver.findElement(By.xpath("//android.widget.EditText[@text='Name']"));
        nameEdit.sendKeys(title);

        //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='Prevention Magazine Australia']")));

        AndroidElement searchCommit = (AndroidElement) driver.findElement(By.id("com.ocd:id/search_commit"));
        searchCommit.click();

        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='RBdigital']")));
        driver.findElement(By.xpath("//android.widget.TextView[@text='RBdigital']")).click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='"+title+"']")));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='MAGAZINES']")));

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/sort_spinner_text_view")));
    }

    public void searchComicByTitle(String title){
        WebDriverWait wait = new WebDriverWait(driver, 50);

        AndroidElement comicsTab = (AndroidElement) driver.findElement(By.id("com.ocd:id/search_select_comics"));
        comicsTab.click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.EditText[@text='Name']")));
        //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.EditText[@text='Title']")));

        AndroidElement nameEdit = (AndroidElement) driver.findElement(By.xpath("//android.widget.EditText[@text='Name']"));
        nameEdit.sendKeys(title);

        //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='Minisulk']")));

        AndroidElement searchCommit = (AndroidElement) driver.findElement(By.id("com.ocd:id/search_commit"));
        searchCommit.click();

        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='RBdigital']")));
        driver.findElement(By.xpath("//android.widget.TextView[@text='RBdigital']")).click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='"+title+"']")));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='COMICS']")));

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/sort_spinner_text_view")));
    }

    public void searchAudiobookByTitle(String title){
        WebDriverWait wait = new WebDriverWait(driver, 50);

        AndroidElement audioBookTab = (AndroidElement) driver.findElement(By.id("com.ocd:id/search_select_audiobooks"));
        audioBookTab.click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.EditText[@text='Name']")));
        //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.EditText[@text='Title']")));

        AndroidElement nameEdit = (AndroidElement) driver.findElement(By.xpath("//android.widget.EditText[@text='Name']"));
        nameEdit.sendKeys(title);

        //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='Minisulk']")));

        AndroidElement searchCommit = (AndroidElement) driver.findElement(By.id("com.ocd:id/search_commit"));
        searchCommit.click();

        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='RBdigital']")));
        driver.findElement(By.xpath("//android.widget.TextView[@text='RBdigital']")).click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='"+title+"']")));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='AUDIOBOOKS']")));

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/sort_spinner_text_view")));
    }

    public void searchEbookByTitle(String title){
        WebDriverWait wait = new WebDriverWait(driver, 50);


        AndroidElement EBookTab = (AndroidElement) driver.findElement(By.id("com.ocd:id/search_select_ebooks"));
        EBookTab.click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.EditText[@text='Name']")));
        //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.EditText[@text='Title']")));

        AndroidElement nameEdit = (AndroidElement) driver.findElement(By.xpath("//android.widget.EditText[@text='Name']"));
        nameEdit.sendKeys(title);

        //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='Slob']")));

        AndroidElement searchCommit = (AndroidElement) driver.findElement(By.id("com.ocd:id/search_commit"));
        searchCommit.click();

        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='RBdigital']")));
        driver.findElement(By.xpath("//android.widget.TextView[@text='RBdigital']")).click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='"+title+"']")));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='EBOOKS']")));

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/sort_spinner_text_view")));
    }

    public void openSearch() {
        AndroidElement searchIcon = (AndroidElement) driver.findElement(By.id("com.ocd:id/top_icon_search"));
        searchIcon.click();
    }

    public void returnFromDetailPage(){
        WebDriverWait wait = new WebDriverWait(driver, 40);

        AndroidElement returnBtn = (AndroidElement) driver.findElement(By.id("com.ocd:id/activity_media_info_left_button"));
        returnBtn.click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("android:id/button1")));
        AndroidElement yesBtn = (AndroidElement) driver.findElement(By.id("android:id/button1"));
        yesBtn.click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='CHECKOUT']")));

    }
}



    /*
    public void swipeVertical_(AppiumDriver<MobileElement> driver, double startPercentage, double finalPercentage, int duration){
    Dimension size = driver.manage().window().getSize();
    int width = (int) (size.width/2);
    int startPoint = (int) (size.getHeight() * startPercentage);
    int endPoint = (int) (size.getHeight() * finalPercentage);
    new TouchAction(driver).press(PointOption.point(width, startPoint)).moveTo(PointOption.point(width, endPoint)).release().perform();
}
    */

    /*
    public void Login_(){
        //WebDriverWait wait = new WebDriverWait(driver, 90);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/login_button")));
        driver.findElement(By.id("com.ocd:id/login_button")).click();
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='RBdigital']")));
        driver.findElement(By.xpath("//android.widget.TextView[@text='RBdigital']")).click();
        //((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/add_profile_user")));
        driver.findElement(By.id("com.ocd:id/add_profile_user")).sendKeys("qauser");
        if (((AndroidDriver) driver).isKeyboardShown()) {
            ((AppiumDriver) driver).hideKeyboard();
        }
        driver.findElement(By.id("com.ocd:id/add_profile_submit")).click();
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='RBdigital']")));
        driver.findElement(By.xpath("//android.widget.TextView[@text='RBdigital']")).click();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@class='android.widget.TextView'][@text='Select your library']")));
        TouchAction tA = new TouchAction((PerformsTouchActions) driver);
        tA.press(PointOption.point(540, 1420)).moveTo(PointOption.point(540, 355)).release().perform();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@class='android.widget.TextView'][@text='RBdigital Library']")));
        driver.findElement(By.xpath("//*[@class='android.widget.TextView'][@text='RBdigital Library']")).click();
        driver.findElement(By.id("com.ocd:id/add_profile_password")).sendKeys("password1");
        driver.findElement(By.id("com.ocd:id/add_profile_password_submit")).click();
        driver.findElement(By.id("com.android.packageinstaller:id/permission_deny_button")).click();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@class='android.widget.TextView'][@text='AUDIOBOOKS']")));
    }
    */





