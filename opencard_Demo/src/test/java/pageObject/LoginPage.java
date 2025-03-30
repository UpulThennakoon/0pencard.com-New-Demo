package pageObject;

import BasePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage  extends BasePage
{
    public LoginPage(WebDriver driver)
    {
        super(driver);
    }
    @FindBy(xpath = "//input[@id='input-email']")
    WebElement txtLogEmail;

    @FindBy(xpath = "//input[@id='input-password']")
    WebElement txLogPassword;

    @FindBy(xpath = "//input[@value='Login']")
    WebElement btnLogin;

    public void setLoginEmail(String lemail)
    {
        txtLogEmail.sendKeys(lemail);
    }
    public void setLoginPassword(String lpwd)
    {
        txLogPassword.sendKeys(lpwd);
    }
    public void clickLoginbtn()
    {
        btnLogin.click();
    }

}
