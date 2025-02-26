package doctorhoai.learn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomatingFileUpload {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement uploadfile = driver.findElement(By.cssSelector("#file-upload"));
        uploadfile.sendKeys("C:\\Users\\Public\\Desktop\\TraceIDE.log");
    }
}
