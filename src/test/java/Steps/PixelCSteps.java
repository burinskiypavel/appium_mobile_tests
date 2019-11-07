package Steps;

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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PixelCSteps {

    static AppiumDriver driver;
    WebDriverWait wait;

    public PixelCSteps(AppiumDriver driver1) {
        driver =  driver1;
    }

    public void returnMagazine(String actualMagTitle) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        TouchAction tA = new TouchAction(driver);
        int count = 0;
        while (driver.findElements(By.xpath("//android.widget.TextView[@text='"+actualMagTitle+"']")).size() == 0 && count < 7){

            tA.press(PointOption.point(540, 640)).moveTo(PointOption.point(540, 600)).release().perform();
            count++;
        }

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='"+actualMagTitle+"']")));
        String EconomistMagBeforeReturn = driver.findElement(By.xpath("//android.widget.TextView[@text='"+actualMagTitle+"']")).getText();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.Button[@text='VIEW ALL']")));
        Thread.sleep(1500);
        AndroidElement viewAllBtnForMagazine = (AndroidElement) driver.findElements(By.xpath("//android.widget.Button[@text='VIEW ALL']")).get(2);
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

        //swipeVertical(driver, 0.6, 0.3, 1);
        int count = 0;
        while (driver.findElements(By.xpath("//android.widget.TextView[@text='"+actualComTitle+"']")).size() == 0 && count < 7){

            tA.press(PointOption.point(540, 638)).moveTo(PointOption.point(540, 600)).release().perform();
            count++;
        }

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='"+actualComTitle+"']")));
        String ComicBeforeReturn = driver.findElement(By.xpath("//android.widget.TextView[@text='"+actualComTitle+"']")).getText();

        int count2 = 0;
        do {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.Button[@text='VIEW ALL']")));
            AndroidElement viewAllBtnForComics = (AndroidElement) driver.findElements(By.xpath("//android.widget.Button[@text='VIEW ALL']")).get(1);
            viewAllBtnForComics.click();
        }
        while(driver.findElements(By.xpath("//android.widget.Button[@text='VIEW ALL']")).size() != 0 && count2 < 5);

        Thread.sleep(1000);

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

    public void swipeVertical(AppiumDriver<MobileElement> driver, double startPercentage, double finalPercentage, int duration){
        Dimension size = driver.manage().window().getSize();
        int width = (int) (size.width/2);
        int startPoint = (int) (size.getHeight() * startPercentage);
        int endPoint = (int) (size.getHeight() * finalPercentage);
        new TouchAction(driver).press(PointOption.point(width, startPoint)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(duration))).moveTo(PointOption.point(width, endPoint)).release().perform();
    }

}
