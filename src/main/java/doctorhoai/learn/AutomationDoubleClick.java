package doctorhoai.learn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AutomationDoubleClick {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.plus2net.com/jquery/msg-demo/event-db1click.php");
        WebElement Dbutton = driver.findElement(By.id("b1"));
        Actions action = new Actions(driver);
        action.doubleClick(Dbutton).clickAndHold().build().perform();
    }
}
