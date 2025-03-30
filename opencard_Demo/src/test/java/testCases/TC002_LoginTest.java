package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;

public class TC002_LoginTest extends BaseClass
{
    @Test(groups={"Sanity","Master"})
    public void verify_login()
    {

        try {

            HomePage hp = new HomePage(driver);
            hp.clickMyAccount1();
            hp.clickLogin();

            LoginPage lp = new LoginPage(driver);
            lp.setLoginEmail(p.getProperty("email"));
            lp.setLoginPassword(p.getProperty("password"));
            lp.clickLoginbtn();

            //MyAccount
            MyAccountPage macc = new MyAccountPage(driver);
            boolean targetpage = macc.isMyAccountPageExists();

            Assert.assertTrue(targetpage);
            macc.clickLogOut();
        }
        catch (Exception e)
        {
            Assert.fail();
        }




    }
}
