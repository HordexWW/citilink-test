package sgu.citetest.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    @FindBy(className = "AuthPopup")
    private WebElement logButton;

    @FindBy(className = "SignIn__action")
    private WebElement enterLogButton;

    @FindBy(name = "login")
    private WebElement loginField;

    @FindBy(name = "pass")
    private WebElement passwdField;

    @FindBy(className = "HeaderUserName")
    private WebElement userAccountMenu;

    @FindBy (partialLinkText = "Мой профиль")
    private WebElement userProfile;

    public void inputLogin(String login) {
        loginField.sendKeys(login);
    }
    public void inputPasswd(String passwd) {
        passwdField.sendKeys(passwd);
    }
    public void clickFirstLoginBtn() {
        logButton.click();
    }
    public void clickSecondLoginBtn() {
        enterLogButton.click();
    }
    public String getUserName() {
        return userAccountMenu.getText();
    }
    public void clickUserMenu() {
        userAccountMenu.click();
    }
    public void clickMyProfile() {
        userProfile.click();
    }

}
