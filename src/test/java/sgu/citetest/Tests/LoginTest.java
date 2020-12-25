package sgu.citetest.Tests;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import sgu.citetest.Pages.LoginPage;
import sgu.citetest.Properties.ConfProperties;

import java.util.concurrent.TimeUnit;

public class LoginTest {

    private static LoginPage loginPage;
    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("loginpage"));
        loginPage = new LoginPage(driver);
    }

    @Test
    public void loginTest() throws InterruptedException {
        loginPage.clickLoginButton();
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.inputPasswd(ConfProperties.getProperty("password"));

        Thread.sleep(10000);

        loginPage.clickEnterLoginButton();
        String user = loginPage.getUserName();
        Assert.assertEquals(ConfProperties.getProperty("name"), user);
    }

    @AfterClass
    public static void quit() {
        driver.quit();
    }

}
