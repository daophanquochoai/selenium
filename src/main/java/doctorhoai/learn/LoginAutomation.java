package doctorhoai.learn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginAutomation {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        System.out.println(password);
        password.sendKeys("admin123");
        WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
        System.out.println(username);
        username.sendKeys("Admin");
        WebElement buttonLogin = driver.findElement(By.xpath("//button[@type='submit']"));
        System.out.println(buttonLogin);
        buttonLogin.click();

        WebElement welcome = driver.findElement(By.className("oxd-userdropdown-name"));
        System.out.println(welcome.getText());

        //navigation
        driver.navigate().to("");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();


    }
}