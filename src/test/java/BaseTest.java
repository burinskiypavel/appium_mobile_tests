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
import org.testng.annotations.AfterClass;

import java.time.Duration;

public class BaseTest {
    //public WebDriver driver;
    AppiumDriver driver;
    WebDriverWait wait;

    //private WebDriver webDriver;
    //public BaseTest(WebDriver driver2001) {
    //    this.driver = driver2001;
    //}

    @AfterClass
    void afterClass() {
        //driver.quit();
        driver.close();
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
    }

    public void pressCheckout() {
        AndroidElement checkoutBtn = (AndroidElement) driver.findElement(By.id("com.ocd:id/activity_media_info_play"));
        checkoutBtn.click();
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

    public void goToMagazinePage(WebDriverWait wait) {
        wait = new WebDriverWait(driver, 30);
        AndroidElement iconMenu = (AndroidElement) driver.findElement(By.id("com.ocd:id/top_icon_menu"));
        iconMenu.click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='MAGAZINES & COMICS']")));
        AndroidElement magazineComicTab = (AndroidElement) driver.findElement(By.xpath("//android.widget.TextView[@text='MAGAZINES & COMICS']"));
        magazineComicTab.click();

        AndroidElement firstFromListMagazine = (AndroidElement) driver.findElementsById("com.ocd:id/menu_child_name").get(1);
        firstFromListMagazine.click();
    }
}


