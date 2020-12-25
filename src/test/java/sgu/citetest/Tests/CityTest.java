package sgu.citetest.Tests;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import sgu.citetest.Pages.CityPage;
import sgu.citetest.Pages.LoginPage;
import sgu.citetest.Properties.ConfProperties;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

@RunWith(value = Parameterized.class)
public class CityTest {
    public static LoginPage loginPage;
    public static CityPage cityPage;
    public static WebDriver driver;
    private String city;

    public CityTest(String city) {
        this.city = city;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> GetCities()
    {
        return Arrays.asList(new Object[][]{
                { "Казань" }, { "Москва" }, { "Волгоград" },{ "Энгельс" }
        });
    }

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
        cityPage.clickCity(city);

        String currentCity = cityPage.getCityName();
        Assert.assertEquals(city, currentCity);
    }

    @AfterClass
    public static void quit() {
        driver.quit();
    }
}