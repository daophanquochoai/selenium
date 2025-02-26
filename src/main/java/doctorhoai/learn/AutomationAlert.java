package doctorhoai.learn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomationAlert {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[normalize-space()=\"Click for JS Alert\"]")).click();
        driver.switchTo().alert().accept();
        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().dismiss();
        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
        driver.switchTo().alert().sendKeys("Xin Chao");
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
    }
}
