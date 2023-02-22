import demo.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OpenDemo {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = getDriver();
    }

    @Test
    public void loginSuccess() {
        LoginPage loginpage = new LoginPage(driver);
        loginpage.open();
        loginpage.login("standard_user", "secret_sauce");
        Assert.assertEquals(loginpage.getTitleProducts(), "PRODUCTS");
    }

    @Test
    public void loginfailed() {
        LoginPage loginpage = new LoginPage(driver);
        loginpage.open();
        loginpage.login("standard_user", "secret_sauce2");
        Assert.assertEquals(loginpage.getTitlefailed(), "Epic sadface: Username and password do not match any user in this service");
    }

    @AfterMethod
    public void quit() {

        driver.quit();
    }

    private WebDriver getDriver() {


        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();


    }
}
