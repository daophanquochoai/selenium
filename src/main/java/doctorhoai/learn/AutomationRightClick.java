package doctorhoai.learn;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class AutomationRightClick {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        WebElement images = driver.findElement(By.xpath("//a[contains(text(),'Hình ảnh')]"));
        Actions action = new Actions(driver);
        action.contextClick(images).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
    }
}
