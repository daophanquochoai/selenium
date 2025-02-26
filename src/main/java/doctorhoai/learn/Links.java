package doctorhoai.learn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Links {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());
        for( int i = 0 ; i < links.size() ; i++ ){
            System.out.println(links.get(i).getText());
            System.out.println(links.get(i).getAttribute("href"));
        }
    }
}
