package sgu.citetest.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BrushesPage {
    private WebDriver driver;

    public BrushesPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    @FindBy(className = "MainHeader__catalog")
    private WebElement catalogButton;

    @FindBy(partialLinkText = "Красота и здоровье")
    private WebElement beautyAndHealthButton;

    @FindBy(partialLinkText = "Зубные щетки и аксессуары")
    private WebElement brushesAndAccessoriesButton;

    @FindBy(partialLinkText = "Зубные щетки")
    private WebElement brushesButton;

    @FindBy(name = "input-min")
    private WebElement inputMin;

    @FindBy(name = "input-max")
    private WebElement inputMax;

    @FindBy(css = "body > div.MainWrapper > div.MainLayout.js--MainLayout.HeaderFixer > main > section > div.Container.Container_has-grid.ProductCardCategoryList.js--ProductCardCategoryList > div.block_data__gtm-js.block_data__pageevents-js.listing_block_data__pageevents-js.ProductCardCategoryList__products-container > div.ProductCardCategoryList__sorting-panel > div.ProductCardCategoryList__view-type > label.ProductCardCategoryList__icon.ProductCardCategoryList__icon_list > div > span")
    private WebElement horizontalViewButton;

    public void clickCatalogButton(){
        catalogButton.click();
    }

    public WebElement getBeautyAndHealthButton(){
        return beautyAndHealthButton;
    }

    public void clickBrushesAndAccessoriesButton(){
        brushesAndAccessoriesButton.click();
    }

    public void clickBrushesButton(){
        brushesButton.click();
    }

    public void enterInInputMin(){
        inputMin.clear();
        inputMin.sendKeys("999");
    }
    public void enterInInputMax(){
        inputMax.clear();
        inputMax.sendKeys("1999");
        inputMax.sendKeys(Keys.ENTER);
    }
    public void clickHorizontalViewButton() {
        horizontalViewButton.click();
    }
}
