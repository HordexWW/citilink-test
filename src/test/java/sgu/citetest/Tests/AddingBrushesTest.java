package sgu.citetest.Tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import sgu.citetest.Pages.BrushesPage;
import sgu.citetest.Pages.CityPage;
import sgu.citetest.Pages.LoginPage;
import sgu.citetest.Properties.ConfProperties;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AddingBrushesTest {
    public static LoginPage loginPage;
    public static WebDriver driver;
    public static BrushesPage brushesPage;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));

        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        brushesPage = new BrushesPage(driver);

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("loginpage"));
    }
    @Test
    public void addBrushesTest(){
        brushesPage.clickCatalogButton();

        Actions actions = new Actions(driver);
        actions.moveToElement(brushesPage.getBeautyAndHealthButton()).build().perform();

        brushesPage.clickBrushesAndAccessoriesButton();
        brushesPage.clickBrushesButton();

        brushesPage.enterInInputMin();
        brushesPage.enterInInputMax();


        brushesPage.clickHorizontalViewButton();


        List<WebElement> elements =  driver.findElements(By.className("ProductCardHorizontal__description-block"));
        //elements.get(0).findElement(By.partialLinkText("В корзину")).click();
    }
//    @AfterClass
//    public static void quit() {
//        driver.quit();
//    }

}
