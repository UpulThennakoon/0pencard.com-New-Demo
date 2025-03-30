package pageObject;

import BasePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {

    public RegisterPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='input-firstname']")
    WebElement txtFirstName;
    @FindBy(xpath = "//input[@id='input-lastname']")
    WebElement txtLastName;
    @FindBy(xpath = "//input[@id='input-email']")
    WebElement txtEmail;
    @FindBy(xpath = "//input[@id='input-telephone']")
    WebElement txtTelephoneNumber;
    @FindBy(id = "input-password")
    WebElement txtPassword;
    @FindBy(xpath = "//input[@id='input-confirm']")
    WebElement txtConfirmPassword;
    @FindBy(xpath = "//input[@name='agree']")
    WebElement chkPolicy;
    @FindBy(xpath = "//input[@value='Continue']")
    WebElement btnContinue;
    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
    WebElement msgConfirmation;

    public void setTxtFirstName(String fname)
    {
        txtFirstName.sendKeys(fname);
    }

    public void setTxtLastName(String lname)
    {
        txtLastName.sendKeys(lname);
    }
    public void setTxtEmail(String mail)
    {
        txtEmail.sendKeys(mail);
    }
    public void setTxtTelephoneNumber(String tnumber)
    {
        txtTelephoneNumber.sendKeys(tnumber);
    }
    public void setTxtPassword(String pwd)
    {
        txtPassword.sendKeys(pwd);
    }
    public void setTxtConfirmPassword(String cpwd)
    {
        txtConfirmPassword.sendKeys(cpwd);
    }
    public void setChkPolicy()
    {
        chkPolicy.click();
    }
    public void setBtnContinue()
    {
        btnContinue.click();
    }
    public String getConfirmation()
   {
       try{
           return (msgConfirmation.getText());
       }
       catch (Exception e)
       {
           return (e.getMessage());
       }
   }

}
