package utilities;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import testCases.BaseClass;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ExtentReportManager implements ITestListener
{
    public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public ExtentTest test;

    String repName;
    public void onStart( ITestContext testContext)
    {
        /*
        SimpleDateFormat df= new SimpleDateFormat ("yyyy.MM.dd.HH.mm.ss");
        Date dt=new Date();
        String currentdatetimestamp=df.format(df)
         */
        String timeStamp=new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());
        repName="Test-Report-"+timeStamp+".html";
        sparkReporter=new ExtentSparkReporter(".\\reports\\"+repName);//specify location of the report file


        sparkReporter.config().setDocumentTitle("opencart Automation Report");//Title of the report
        sparkReporter.config().setReportName("opencart Functional Testing");//name of the report
        sparkReporter.config().setTheme(Theme.DARK);

        extent= new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Application","opencart");
        extent.setSystemInfo("Module","Admin");
        extent.setSystemInfo("Sub Module","Customers");
        extent.setSystemInfo("Environment","QA");


        String os=testContext.getCurrentXmlTest().getParameter("os");
        extent.setSystemInfo("operating System",os);

        String browser=testContext.getCurrentXmlTest().getParameter("browser");
        extent.setSystemInfo("Browser",browser);

        List<String> includedGroup=testContext.getCurrentXmlTest().getIncludedGroups();
        if(!includedGroup.isEmpty())
        {
            extent.setSystemInfo("Groups",includedGroup.toString());
        }

    }
    public void onTestSuccess(ITestResult result)
    {
        test=extent.createTest(result.getClass().getName());
        test.assignCategory(result.getMethod().getGroups());//to Display groups in report
        test.log(Status.PASS,result.getName()+ "got Success executed");

    }

    public void onTestFailure(ITestResult result)
    {
        test=extent.createTest(result.getClass().getName());
        test.assignCategory(result.getMethod().getGroups());

        test.log(Status.FAIL,result.getName()+"got failed");
        test.log(Status.INFO,result.getThrowable().getMessage());

        try{
            String imgPath=new BaseClass().captureScreen(result.getName());
            test.addScreenCaptureFromPath(imgPath);
        }
        catch (IOException e1)
        {
            e1.printStackTrace();
        }

    }
    public  void onTestSkipped(ITestResult result)
    {
        test=extent.createTest(result.getClass().getName());
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.SKIP,result.getName()+"got Skipped");
        test.log(Status.INFO,result.getThrowable().getMessage());
    }
    public  void onFinish(ITestContext testContext)
    {
        extent.flush();

       // String pathOfExtentReport=System.getProperty("user.dir")+"\\reports\\"+repName;
      //  File extentReport=new File(pathOfExtentReport);
      //  try
      //  {
     //       Desktop.getDesktop().browse(extentReport.toURI());
    //    } catch (IOException e) {
      //      e.printStackTrace();
     //   }
    }
}
