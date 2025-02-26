package doctorhoai.learn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandllingWindownAndTab {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        String MainTab = driver.getWindowHandle();
        System.out.println(MainTab);
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.google.com.vn/?hl=vi");
        driver.quit();
    }
}
