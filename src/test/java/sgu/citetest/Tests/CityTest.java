package sgu.citetest.Tests;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import sgu.citetest.Pages.CityPage;
import sgu.citetest.Pages.LoginPage;
import sgu.citetest.Properties.ConfProperties;
import java.util.concurrent.TimeUnit;

public class CityTest {
    public static LoginPage loginPage;
    public static CityPage cityPage;
    public static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));

        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        cityPage = new CityPage(driver);

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("loginpage"));
    }

    @Test
    public void сityTest() throws InterruptedException {
        cityPage.clickChangeCity();
        cityPage.clickCity(ConfProperties.getProperty("city"));

        String city = cityPage.getCityName();
        Assert.assertEquals(ConfProperties.getProperty("city"), city);

        loginPage.clickLoginButton();
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.inputPasswd(ConfProperties.getProperty("password"));

        Thread.sleep(10000);

        loginPage.clickEnterLoginButton();
        loginPage.clickUserAccountMenu();
        loginPage.clickUserProfile();

        String cityInAddress = cityPage.getDeliveryAddress();
        Assert.assertEquals(city, cityInAddress);
    }

    @AfterClass
    public static void quit() {
        driver.quit();
    }
}