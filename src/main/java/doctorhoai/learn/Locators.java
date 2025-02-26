package doctorhoai.learn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class Locators {
    public static void main(String[] args) throws InterruptedException {
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        webDriver.get("https://rahulshettyacademy.com/locatorspractice/");
        webDriver.findElement(By.id("inputUsername")).sendKeys("rahul");
        webDriver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");
        webDriver.findElement(By.className("signInBtn")).click();
        Thread.sleep(1000);
        System.out.println(webDriver.findElement(By.tagName("p")).getText());
        Assert.assertEquals("You are successfully logged in.", webDriver.findElement(By.tagName("p")).getText());
    }
}
