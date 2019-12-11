package Steps;

import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonSteps {
    public WebDriver driver;

    public CommonSteps(WebDriver driver) {
        this.driver = driver;
    }

    public void pressHold() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='DESCRIPTION']")));

        if (driver.findElements(By.xpath("//android.widget.TextView[@text='REMOVE HOLD']")).size() != 0) {
            driver.findElement(By.xpath("//android.widget.TextView[@text='REMOVE HOLD']")).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='HOLD']")));
        }

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='HOLD']")));
        AndroidElement hold = (AndroidElement) driver.findElement(By.xpath("//android.widget.TextView[@text='HOLD']"));
        hold.click();
    }

}
