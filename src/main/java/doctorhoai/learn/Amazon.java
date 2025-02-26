package doctorhoai.learn;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.lazada.vn/");
        driver.findElement(By.id("q")).sendKeys("Mongeeeks M1");
        Thread.sleep(4000);
        driver.findElement(By.className("search-box__button--1oH7")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        Thread.sleep(4000);
        driver.findElement(By.linkText("ACM")).click();
    }
}
