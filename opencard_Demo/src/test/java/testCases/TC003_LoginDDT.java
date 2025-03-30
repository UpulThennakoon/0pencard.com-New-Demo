package testCases;

import org.openxmlformats.schemas.drawingml.x2006.chart.CTRotY;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObject.AccountLogOutPage;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import utilities.DataProviders;

public class TC003_LoginDDT  extends BaseClass
{



    @Test(dataProvider ="LoginData",dataProviderClass = DataProviders.class,groups = "DataDriven")
    public void verify_loginDDT(String email,String pws,String exp)
        {

            try {
            HomePage hp = new HomePage(driver);
            hp.clickMyAccount1();
            hp.clickLogin();

            LoginPage lp = new LoginPage(driver);
            lp.setLoginEmail(email);
            lp.setLoginPassword(pws);
            lp.clickLoginbtn();

            //MyAccount
            MyAccountPage macc = new MyAccountPage(driver);
            boolean targetpage = macc.isMyAccountPageExists();

            AccountLogOutPage aclogout = new AccountLogOutPage(driver);

            if (exp.equalsIgnoreCase("Valid")) {
                if (targetpage == true) {
                    macc.clickLogOut();
                    aclogout.ClickLogOut();
                    Assert.assertTrue(true);

                } else {
                    Assert.assertTrue(false);
                }

            }
            if (exp.equalsIgnoreCase("Invalid")) {
                if (targetpage == true) {
                    macc.clickLogOut();
                    aclogout.ClickLogOut();
                    Assert.assertTrue(false);

                } else {
                    Assert.assertTrue(true);
                }
            }
        }
        catch(Exception e)
        {
            Assert.fail();
        }




    }

}
