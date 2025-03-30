package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.HomePage;
import pageObject.RegisterPage;




public class TC001_AccountRegistrationTest extends BaseClass
{


    @Test(groups = {"Regression","Master"})
    public void test()  {


        logger.info("*********** Starting AccountRegistrationTest********** ");
        try {

            HomePage hp = new HomePage(driver);
            hp.clickMyAccount1();
            logger.info("Click my account ");

            hp.clickRegister();
            logger.info("Click Register");

            Thread.sleep(5000);

            RegisterPage rp = new RegisterPage(driver);

            logger.info("Providing customer details  ");
            rp.setTxtFirstName(randomeString().toLowerCase());
            rp.setTxtLastName(randomeString().toUpperCase());
            rp.setTxtEmail(randomeString() + "@gmail.com");


            rp.setTxtTelephoneNumber(randomNumber());

            String password = randomAlphaNumber();
            rp.setTxtPassword(password);
            rp.setTxtConfirmPassword(password);
            rp.setChkPolicy();
            rp.setBtnContinue();

            logger.info("Validation expected message  ");

            String confirmation = rp.getConfirmation();
            Assert.assertEquals(confirmation, "Your Account Has Been Created!");
        }
        catch (Exception e)
        {
            logger.error("test failed");
            logger.debug("Debug log");
            Assert.fail();
        }
        logger.info("***********finished******** ");


    }


}
