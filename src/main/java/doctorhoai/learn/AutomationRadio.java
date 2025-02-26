package doctorhoai.learn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomationRadio {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/automation-practice-form");
        WebElement RadioButton = driver.findElement(By.xpath("//label[normalize-space()='Male']"));
        RadioButton.click();
        RadioButton.isDisplayed();
        RadioButton.isEnabled();
        RadioButton.isSelected();

        System.out.println(RadioButton.getText());
        System.out.println(RadioButton.getAttribute("class"));
        System.out.println(RadioButton.getTagName());
    }
}
