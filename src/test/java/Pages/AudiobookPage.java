package Pages;

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

public class AudiobookPage {
    public WebDriver driver;

    public AudiobookPage(WebDriver driver2001) {
        this.driver = driver2001;
    }

    public AudiobookPage scrollToMostPopular() throws InterruptedException {
        TouchAction tA = new TouchAction((PerformsTouchActions) driver);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        Thread.sleep(1000);
        int count = 0;
        while (driver.findElements(By.xpath("//android.widget.TextView[@text='MOST POPULAR']")).size() == 0 && count < 7){

            tA.press(PointOption.point(540, 630)).moveTo(PointOption.point(540, 600)).release().perform();
            count++;
        }
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.Button[@text='VIEW ALL']")));
        return this;
    }

    public AudiobookPage scrollToFirstHold() throws InterruptedException {
        TouchAction tA = new TouchAction((PerformsTouchActions) driver);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        Thread.sleep(1000);
        int count = 0;
        while (driver.findElements(By.xpath("//android.widget.TextView[@text='HOLD']")).size() == 0 && count < 7){

            tA.press(PointOption.point(540, 630)).moveTo(PointOption.point(540, 600)).release().perform();
            count++;
        }
        //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.Button[@text='VIEW ALL']")));
        return this;
    }

    public AudiobookPage goToViewAllPage(int index){
        WebDriverWait wait = new WebDriverWait(driver, 30);

        AndroidElement viewAllBtnForComics = (AndroidElement) driver.findElements(By.xpath("//android.widget.Button[@text='VIEW ALL']")).get(index);
        viewAllBtnForComics.click();

        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='RBdigital']")));
        driver.findElement(By.xpath("//android.widget.TextView[@text='RBdigital']")).click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/filter_label")));

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.ocd:id/sort_spinner_text_view")));
        return this;
    }

}
