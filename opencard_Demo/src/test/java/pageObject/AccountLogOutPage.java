package pageObject;

import BasePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountLogOutPage extends BasePage
{
    public AccountLogOutPage(WebDriver driver)
    {
        super(driver);
    }
    @FindBy(xpath = "//a[normalize-space()='Continue']")
    WebElement btnLogout ;

    public void ClickLogOut()
    {
        btnLogout.click();
    }

}
