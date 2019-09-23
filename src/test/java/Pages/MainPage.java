package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    public WebDriver driver;
    //private WebDriver webDriver;
    public MainPage(WebDriver driver2001) {
        this.driver = driver2001;
    }

    public void Login(String username, String password){
        WebDriverWait wait = new WebDriverWait(driver, 90);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/login_button")));
        MobileElement loginBtn = (MobileElement) driver.findElement(By.id("com.ocd:id/login_button"));
        loginBtn.click();

        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='RBdigital']")));
        driver.findElement(By.xpath("//android.widget.TextView[@text='RBdigital']")).click();
        //((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/add_profile_user")));
        AndroidElement userName = (AndroidElement) driver.findElement(By.id("com.ocd:id/add_profile_user"));
        userName.sendKeys(username);

        if (((AndroidDriver) driver).isKeyboardShown()) {
            ((AppiumDriver) driver).hideKeyboard();
        }

        AndroidElement nextBtn = (AndroidElement) driver.findElement(By.id("com.ocd:id/add_profile_submit"));
        nextBtn.click();

        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='RBdigital']")));
        driver.findElement(By.xpath("//android.widget.TextView[@text='RBdigital']")).click();


        if(driver.findElements(By.id("com.ocd:id/heading")).size() != 0){
            driver.findElement(By.id("com.ocd:id/dismiss")).click();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.ocd:id/heading")));
        }

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@class='android.widget.TextView'][@text='Select your library']")));
        TouchAction tA = new TouchAction((PerformsTouchActions) driver);
        tA.press(PointOption.point(540, 1420)).moveTo(PointOption.point(540, 355)).release().perform();


        if(driver.findElements(By.id("com.ocd:id/heading")).size() != 0){
            driver.findElement(By.id("com.ocd:id/dismiss")).click();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.ocd:id/heading")));
        }

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@class='android.widget.TextView'][@text='RBdigital Library']")));
        AndroidElement RbdigitalLibrary = (AndroidElement) driver.findElement(By.xpath("//*[@class='android.widget.TextView'][@text='RBdigital Library']"));
        RbdigitalLibrary.click();

        AndroidElement password1 = (AndroidElement) driver.findElement(By.id("com.ocd:id/add_profile_password"));
        password1.sendKeys(password);

        AndroidElement passwordSubmit = (AndroidElement) driver.findElement(By.id("com.ocd:id/add_profile_password_submit"));
        passwordSubmit.click();

        AndroidElement AllowRBdigitalAccesstoFilesOnYourDevice = (AndroidElement) driver.findElement(By.id("com.android.packageinstaller:id/permission_deny_button"));
        AllowRBdigitalAccesstoFilesOnYourDevice.click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@class='android.widget.TextView'][@text='AUDIOBOOKS']")));

    }
}
