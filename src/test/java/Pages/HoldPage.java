package Pages;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HoldPage {
    public WebDriver driver;

    public HoldPage(WebDriver driver2001) {
        this.driver = driver2001;
    }

    public void onHoldPageScrollToAudiobooks() throws InterruptedException {
        Thread.sleep(700);
        TouchAction touchAction = new TouchAction((PerformsTouchActions) driver);
        touchAction.press(PointOption.point(540, 500)).moveTo(PointOption.point(540, 800)).release().perform();
    }

    public void removeElement(int index) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("com.ocd:id/row_media_x")));
        AndroidElement firstXBtn = (AndroidElement) driver.findElements(By.id("com.ocd:id/row_media_x")).get(0);
        firstXBtn.click();
    }

}
