package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    /*
    Caso exitoso: Ingresar a la aplicación de saucedemo ingresando las
credenciales correctas (username: standard_user y password: secret_sauce)
y poder validar el label PRODUCTO en la lista de productos.
- Caso fallido: Ingresar a la aplicación de saucedemo ingresando las
credenciales erradas (username y password) y poder validar el mensaje
de error: Username and password do not match any user in this
service.

     */

    public void open(){
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }

    public void login(String user,String password){
        driver.findElement(By.id("user-name")).sendKeys(user);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
    }

    public String getTitleProducts(){
        WebElement titleProduct = driver.findElement(By.xpath("//span[text()='Products']"));
        return titleProduct.getText();

    }

    public String getTitlefailed(){
        WebElement titlefaield = driver.findElement(By.xpath("//h3[text()='Epic sadface: Username and password do not match any user in this service']"));
        return titlefaield.getText();

    }
}
