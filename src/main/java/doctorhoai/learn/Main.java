package doctorhoai.learn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Main {
    public static void main(String[] args) {
        WebDriver webDriver= new FirefoxDriver();
        webDriver.get("https://rahulshettyacademy.com");
        System.out.println(webDriver.getTitle());
    }
}