package doctorhoai.learn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class HandlingNestedFrame {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        List<WebElement> f = driver.findElements(By.tagName("frame"));
        System.out.println(f.size());

        driver.switchTo().frame(1);
        String BottomFrame = driver.findElement(By.tagName("body")).getText();
        System.out.println(BottomFrame);
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-top");
    }
}
