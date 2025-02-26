import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.List;
import java.util.UUID;

public class Page {
    private WebDriver driver;
    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test(testName = "Login successful")
    public void loginPage() throws InterruptedException {
        driver.get("https://notes-app-fe-iota.vercel.app");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        // get element
        WebElement inpUsername = driver.findElement(By.xpath("//input[@placeholder='Email']"));
        WebElement inpPassword = driver.findElement(By.xpath("//input[@placeholder='Mật khẩu']"));
        WebElement btnLogin = driver.findElement(By.xpath("//button[contains(text(),'Đăng Nhập')]"));

        // send key
        inpUsername.sendKeys("test@gmail.com");
        inpPassword.sendKeys("pass");
        btnLogin.click();
        Thread.sleep(5000);
        WebElement name = driver.findElement(By.xpath("//p[@class='text-sm font-medium']"));
        System.out.println(name );
        assertEquals(name.getText(),"Test");
    }

    @Test(testName = "Send key isn't email")
    public void inputNotEmail() {
        driver.get("https://notes-app-fe-iota.vercel.app");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        // get element
        WebElement inpUsername = driver.findElement(By.xpath("//input[@placeholder='Email']"));
        WebElement inpPassword = driver.findElement(By.xpath("//input[@placeholder='Mật khẩu']"));
        WebElement btnLogin = driver.findElement(By.xpath("//button[contains(text(),'Đăng Nhập')]"));

        // send key
        inpUsername.sendKeys("testgmail.com");
        inpPassword.sendKeys("pass");
        btnLogin.click();
        String message = inpUsername.getAttribute("validationMessage");
        assertNotNull(message);
    }

    @Test(testName = "Click Sign in")
    public void clickSignIn() throws InterruptedException {
        driver.get("https://notes-app-fe-iota.vercel.app/signup");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        //get elements
        WebElement btnSignIn = driver.findElement(By.xpath("//a[contains(text(),'Đăng nhập')]"));

        //event
        btnSignIn.click();
        Thread.sleep(2000);
        //assert
        WebElement title = driver.findElement(By.xpath("//h4[contains(text(),'Đăng Nhập')]"));
        assertEquals(title.getText(), "Đăng Nhập");
    }

    @Test(testName = "Click create account ")
    public void clickCreateAccount() throws InterruptedException {
        driver.get("https://notes-app-fe-iota.vercel.app");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        //get elements
        WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Tạo tài khoản')]"));

        //event
        signUpLink.click();
        Thread.sleep(2000);

        //assert
        WebElement title = driver.findElement(By.xpath("(//h4[contains(text(),'Đăng Ký')])[1]"));
        assertEquals(title.getText(), "Đăng Ký");
    }

    @Test(testName = "Create account(instance fail - email)")
    public void createAccountFail() throws InterruptedException {
        driver.get("https://notes-app-fe-iota.vercel.app");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        //get elements
        WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Tạo tài khoản')]"));

        //event
        signUpLink.click();
        Thread.sleep(2000);

        //assert
        WebElement title = driver.findElement(By.xpath("(//h4[contains(text(),'Đăng Ký')])[1]"));
        assertEquals(title.getText(), "Đăng Ký");

        //create account
            // get element
        WebElement username = driver.findElement(By.xpath("//input[@placeholder='Họ và tên']"));
        WebElement email = driver.findElement(By.xpath("//input[@placeholder='Email']"));
        WebElement password = driver.findElement(By.xpath("//input[@placeholder='Mật khẩu']"));
        WebElement btnSignUp = driver.findElement(By.xpath("//button[contains(text(),'Tạo Tài Khoản')]"));


            //event
        username.sendKeys("Dao Phan Quoc Hoai");
        email.sendKeys("hoaigmail.com");
        password.sendKeys("pass");
        btnSignUp.click();
            //assert
        Thread.sleep(2000);
        String message = email.getAttribute("validationMessage");
        assertNotNull(message);
    }

    @Test(testName = "Create duplicate account")
    public void createDuplicateAccount() throws InterruptedException {
        driver.get("https://notes-app-fe-iota.vercel.app");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        //get elements
        WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Tạo tài khoản')]"));

        //event
        signUpLink.click();
        Thread.sleep(2000);

        //assert
        WebElement title = driver.findElement(By.xpath("(//h4[contains(text(),'Đăng Ký')])[1]"));
        assertEquals(title.getText(), "Đăng Ký");

        //create account
        // get element
        WebElement username = driver.findElement(By.xpath("//input[@placeholder='Họ và tên']"));
        WebElement email = driver.findElement(By.xpath("//input[@placeholder='Email']"));
        WebElement password = driver.findElement(By.xpath("//input[@placeholder='Mật khẩu']"));
        WebElement btnSignUp = driver.findElement(By.xpath("//button[contains(text(),'Tạo Tài Khoản')]"));


        //event
        username.sendKeys("Dao Phan Quoc Hoai");
        email.sendKeys("hoai@gmail.com");
        password.sendKeys("pass");
        btnSignUp.click();
        //assert
        Thread.sleep(2000);
        WebElement errorMessage = driver.findElement(By.xpath("//p[@class='text-red-500 text-xs']"));
        assertEquals("Người dùng đã tồn tại", errorMessage.getText());
    }

    @Test(testName = "Create account successful")
    public void createAccountSuccessful() throws InterruptedException {
        driver.get("https://notes-app-fe-iota.vercel.app");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        //get elements
        WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Tạo tài khoản')]"));

        //event
        signUpLink.click();
        Thread.sleep(2000);

        //assert
        WebElement title = driver.findElement(By.xpath("(//h4[contains(text(),'Đăng Ký')])[1]"));
        assertEquals(title.getText(), "Đăng Ký");

        //create account
        // get element
        WebElement username = driver.findElement(By.xpath("//input[@placeholder='Họ và tên']"));
        WebElement email = driver.findElement(By.xpath("//input[@placeholder='Email']"));
        WebElement password = driver.findElement(By.xpath("//input[@placeholder='Mật khẩu']"));
        WebElement btnSignUp = driver.findElement(By.xpath("//button[contains(text(),'Tạo Tài Khoản')]"));

        String nameRender = "Dao Phan Quoc Hoai " + UUID.randomUUID().toString();

        //event
        username.sendKeys(nameRender);
        email.sendKeys("hoai" + UUID.randomUUID().toString() + "@gmail.com");
        password.sendKeys("pass");
        btnSignUp.click();
        //assert
        Thread.sleep(2000);
        WebElement name = driver.findElement(By.xpath("//p[@class='text-sm font-medium']"));
        assertEquals(name.getText(), nameRender);
    }

    @Test(testName = "Log out account")
    public void logoutAccount() throws InterruptedException {
        driver.get("https://notes-app-fe-iota.vercel.app");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        // get element
        WebElement inpUsername = driver.findElement(By.xpath("//input[@placeholder='Email']"));
        WebElement inpPassword = driver.findElement(By.xpath("//input[@placeholder='Mật khẩu']"));
        WebElement btnLogin = driver.findElement(By.xpath("//button[contains(text(),'Đăng Nhập')]"));

        // send key
        inpUsername.sendKeys("test@gmail.com");
        inpPassword.sendKeys("pass");
        btnLogin.click();
        Thread.sleep(5000);
        WebElement name = driver.findElement(By.xpath("//p[@class='text-sm font-medium']"));
        System.out.println(name );
        assertEquals(name.getText(),"Test");

        // get element
        WebElement btnLogOut = driver.findElement(By.xpath("//button[contains(text(),'Đăng xuất')]"));

        //event
        btnLogOut.click();
        Thread.sleep(2000);

        //assert
        WebElement title = driver.findElement(By.xpath("//h4[contains(text(),'Đăng Nhập')]"));
        assertEquals(title.getText(), "Đăng Nhập");
    }

    @Test(testName = "Display create form")
    public void displayCreateForm() throws InterruptedException {
        loginPage();
        //get elements
        WebElement btnAdd = driver.findElement(By.xpath("//button[@class='w-16 h-16 bg-primary hover:bg-blue-600 cursor-pointer rounded-2xl flex items-center justify-center absolute right-10 bottom-10']"));

        //event
        btnAdd.click();
        Thread.sleep(2000);

        //assert
        WebElement btnCreate = driver.findElement(By.xpath("//button[contains(text(),'Thêm Mới')]"));
        assertEquals("Thêm Mới", btnCreate.getText());
    }

    @Test(testName = "Validation in input ( create todo )")
    public void validationInputTodo() throws InterruptedException {
        displayCreateForm();

        //get element
        WebElement btnCreate = driver.findElement(By.xpath("//button[contains(text(),'Thêm Mới')]"));

        //event
        btnCreate.click();
        Thread.sleep(2000);

        //assert
        WebElement error = driver.findElement(By.xpath("//p[@class='text-red-500 text-xs pt-4']"));
        assertEquals("Tiêu đề không được để tróng.",error.getText());
    }

    @Test(testName = "Create todo fail ( content is blank)")
    public void validationInputContentBlank() throws InterruptedException {
        displayCreateForm();
        //get element
        WebElement inputTitle = driver.findElement(By.xpath("//input[@placeholder='Nhập tiêu đề ...']"));
        WebElement btnCreate = driver.findElement(By.xpath("//button[contains(text(),'Thêm Mới')]"));

        //event
        inputTitle.sendKeys("title 1");
        btnCreate.click();
        Thread.sleep(2000);

        // assert
        WebElement error = driver.findElement(By.xpath("//p[@class='text-red-500 text-xs pt-4']"));
        assertEquals("Nội dung không được để tróng.", error.getText());
    }

    @Test(testName = "Create todo successful")
    public void createTodoSuccessful() throws InterruptedException {
        displayCreateForm();
        //get element
        List<WebElement> listTodo = driver.findElements(By.xpath("//div[@class='grid grid-cols-3 gap-4 mt-8']/div"));
        int countTodo = listTodo.size();
        WebElement inputTitle = driver.findElement(By.xpath("//input[@placeholder='Nhập tiêu đề ...']"));
        WebElement btnCreate = driver.findElement(By.xpath("//button[contains(text(),'Thêm Mới')]"));
        WebElement inputContent = driver.findElement(By.xpath("//textarea[@placeholder='Nhập nội dung ...']"));

        //event
        inputTitle.sendKeys("Title 1");
        inputContent.sendKeys("Content 1");
        btnCreate.click();
        Thread.sleep(5000);

        //assert
        listTodo = driver.findElements(By.xpath("//div[@class='grid grid-cols-3 gap-4 mt-8']/div"));
        assertEquals(listTodo.size()-1, countTodo);
    }

    @Test(testName = "Delete todo")
    public void deleteTodo() throws InterruptedException {
        loginPage();

        //get element
        WebElement btnDelete = driver.findElement(By.cssSelector("div.grid.grid-cols-3.gap-4.mt-8>div:first-child>div.mt-2>div.gap-2>svg:nth-child(2)"));
        //event
        btnDelete.click();
        List<WebElement> listTodo = driver.findElements(By.xpath("//div[@class='grid grid-cols-3 gap-4 mt-8']/div"));
        int countTodo = listTodo.size();

        WebElement btnDeleteAccept = driver.findElement(By.cssSelector("div[class='flex items-center justify-center cursor-pointer px-4 py-1 rounded bg-green-50 hover:bg-green-100']"));
        btnDeleteAccept.click();

        //assert
        Thread.sleep(2000);
        listTodo = driver.findElements(By.xpath("//div[@class='grid grid-cols-3 gap-4 mt-8']/div"));
        assertEquals(countTodo-1, listTodo.size());
    }

    @Test(testName = "Delete todo but cancel")
    public void deleteTodoButCancel() throws InterruptedException {
        loginPage();

        //get element
        WebElement btnDelete = driver.findElement(By.cssSelector("div.grid.grid-cols-3.gap-4.mt-8>div:first-child>div.mt-2>div.gap-2>svg:nth-child(2)"));
        //event
        btnDelete.click();
        List<WebElement> listTodo = driver.findElements(By.xpath("//div[@class='grid grid-cols-3 gap-4 mt-8']/div"));
        int countTodo = listTodo.size();

        WebElement btnDeleteAccept = driver.findElement(By.cssSelector("div[class='flex items-center justify-center cursor-pointer px-4 py-1 rounded bg-red-50 hover:bg-red-100']"));
        btnDeleteAccept.click();

        //assert
        Thread.sleep(2000);
        listTodo = driver.findElements(By.xpath("//div[@class='grid grid-cols-3 gap-4 mt-8']/div"));
        assertEquals(countTodo, listTodo.size());

    }
}
