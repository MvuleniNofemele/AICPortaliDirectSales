package utility;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import com.aventstack.extentreports.reporter.configuration.Theme;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import testCases.Driver;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static utility.Constant.AlertCheck;

public class HtmlReporter extends ExcelUtils
{
    public static String htmlReport, captureScreen, apEnv, appCycle, appUrl, executionType, ScreenFolder ;
    public String testCase_Itr, testCase_ID, testCase_Name, dirPath, screenDirPath;
    public int IterationCnt, step_no, tc_no;
    public ExtentReports extent;
    public ExtentTest test;

//    public ExtentHtmlReporter htmlReporter;
    public ExtentTest node;

    public void setUpReportFolder(String preferbrowser) throws Exception
    {
        setExcelFile(Constant.Path_TestData + Driver.file_TestData,"Configuration");
        htmlReport=getCellData(2,1);
        captureScreen=getCellData(3,1);
        apEnv=getCellData(4,1);
        appCycle=getCellData(5,1);
        appUrl=getCellData(6,1);
        executionType=getCellData(7,1);
        tc_no=0;

        DateFormat dateFormat = new SimpleDateFormat ("ddMMyyyyHHmmss");
        Date date = new Date();
        String NowDateTime = dateFormat.format(date);
        dirPath=Driver.userDir + "\\TestResults\\" + "Result_" +  preferbrowser + "_" + NowDateTime;
//        dirPath=Driver.userDir + "\\TestResults\\" + "Result_" + NowDateTime;
        File file = new File(dirPath);
    }

    public void startResult(String browser) throws Exception{
        try{
            extent = new ExtentReports(dirPath+ "\\Result_"+browser+".html", false);
            extent.addSystemInfo ("Browser",browser);
            setExcelFile(Constant.Path_TestData + Driver.file_TestData,"Configuration");
            String sURL=getCellData(5,1);
            if (!(sURL.equalsIgnoreCase(""))) {
                extent.addSystemInfo("URL", sURL);
            }
            extent.loadConfig(new File(Constant.Path_Plugin + "\\extent-config.xml"));


//            htmlReporter = new ExtentHtmlReporter(dirPath+ "\\Result_"+browser+".html");
//            htmlReporter.config().setTheme(Theme.DARK);
//
//            extent = new ExtentReports();
//            extent.attachReporter(htmlReporter);

        }
        catch (Exception e){
            System.out.println ("Exception in HtmlReporter.startResult " + e.toString () );
            throw e;
        }
    }

    public void startTestCase(String testCaseName, String testDescription, String Browser) throws Exception {

        ScreenFolder = testCase_ID + "-" + testCase_Name + "_" +  testCase_Itr;
        screenDirPath = dirPath + "\\Screenshots\\" + ScreenFolder;
//        screenDirPath = dirPath + "\\" + ScreenFolder + "\\" + Browser;
        System.setProperty("ScreeshotPath_"+Browser, screenDirPath);
        try {
            Files.createDirectories (Paths.get (screenDirPath));
            String sScenario = testCaseName.split(" :-")[0];
            test = extent.startTest(testCaseName, testDescription);
            test.assignCategory(sScenario);

//            Files.createDirectories (Paths.get (screenDirPath));
//            test = extent.createTest(testCase_ID +": " + testCaseName);
//            String sScenario = testCaseName.split(" :-")[0];
//            node = test.createNode(sScenario);
        } catch (Exception e) {
            System.out.println ("Exception in HtmlReporter.startTestCase " + e.toString () );
            throw e;
        }
    }

    public HtmlReporter WriteStep(WebDriver driver, String description, String expected, String actual, String Status ) throws Exception
    {
        String snapPath = null;
        try
        {
            setExcelFile(Constant.Path_TestData + Driver.file_TestData, "Configuration");
            String ScreenShotCapture = getCellData(2,1);

            switch (ScreenShotCapture) {
                case "On Every Step" : snapPath = takeSnap(driver,description);break;
                case "On Error": if (Status.toUpperCase().equals("FAIL")) {
                    snapPath = takeSnap(driver,description);
                }break;
                case "Never": snapPath = "";break;
            }
            String ScreenshotPath = "./Screenshots/" + ScreenFolder + "\\" + snapPath + ".png";
            if (snapPath.equals ("")){
                if(Status.toUpperCase().equals("PASS")){
//                    test.pass("Desc: " + description +   " -||- Expected: " + expected + " -||- Actual: " + actual );
                    test.log(LogStatus.PASS,"Desc: " + description +   " -||- Expected: " + expected + " -||- Actual: " + actual );
                }else if(Status.toUpperCase().equals("FAIL")){
//                    test.fail(" Desc: " +description + " -||- Expected: " + expected+ " -||- Actual: " + actual);
                    test.log(LogStatus.FAIL," Desc: " +description + " -||- Expected: " + expected+ " -||- Actual: " + actual);
                }else if(Status.toUpperCase().equals("FATAL")){
//                    test.fatal(" Desc: " +description + " -||- Expected: " + expected+ " -||- Actual: " + actual);
                    test.log(LogStatus.FATAL, " Desc: " +description + " -||- Expected: " + expected+ " -||- Actual: " + actual);
                }
            }
            else{
                if(Status.toUpperCase().equals("PASS")){
//                    test.pass("Desc: " + description +   " -||- Expected: " + expected + " -||- Actual: " + actual + test.addScreenCaptureFromPath(ScreenshotPath));
//                    node.pass("");
                    test.log(LogStatus.PASS,"Desc: " + description +   " -||- Expected: " + expected + " -||- Actual: " + actual + test.addScreenCapture(ScreenshotPath));
                }else if(Status.toUpperCase().equals("FAIL")){
//                    test.fail("Desc: " + description +   " -||- Expected: " + expected + " -||- Actual: " + actual + test.addScreenCaptureFromPath(ScreenshotPath));
                    test.log(LogStatus.FAIL," Desc: " +description + " -||- Expected: " + expected+ " -||- Actual: " + actual+ test.addScreenCapture(ScreenshotPath));
                }else if(Status.toUpperCase().equals("FATAL")){
//                    test.fatal ("Desc: " + description +   " -||- Expected: " + expected + " -||- Actual: " + actual + test.addScreenCaptureFromPath(ScreenshotPath));
                    test.log(LogStatus.FATAL, " Desc: " +description + " -||- Expected: " + expected+ " -||- Actual: " + actual+ test.addScreenCapture(ScreenshotPath));
                }
            }

            System.out.println("Desc: " + description +  " Expected: " + expected + " Actual: " + actual + " - Status: " + Status);

        }
        catch (Exception e)
        {
            System.out.println ("Exception in HtmlReporter.WriteStep " + e.toString () );
            throw e;
        }
        return this;

    }

    public String takeSnap(WebDriver driver, String Description) {
        DateFormat dateFormat = new SimpleDateFormat ("ddMMyyyyHHmmss");
        Date date = new Date();
        String NowDateTime = dateFormat.format(date);

        String strGetScreenshotPath = "";
        String ImageFilePath = "";
        try {
            String browserName  = driver.toString();
            if(browserName.contains("Chrome")){
                strGetScreenshotPath = System.getProperty("ScreeshotPath_Chrome");
            }else if(browserName.contains("Firefox")) {
                strGetScreenshotPath = System.getProperty("ScreeshotPath_Firefox");
            }else if(browserName.contains("IE")) {
                strGetScreenshotPath = System.getProperty("ScreeshotPath_IE");
            }
            ImageFilePath = strGetScreenshotPath + "\\" + Description.trim() + "_" + NowDateTime + ".png";
//            ImageFilePath = "../../../" + NowDateTime + ".png";

            AlertCheck = isAlertPresent(driver);
            if(AlertCheck) {
                BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
//                ImageIO.write(image, "png", new File(HtmlReporter.screenDirPath+"\\Step-" + HtmlReporter.step_no + ".png"));
                ImageIO.write(image,"png",new File (ImageFilePath));
            } else {

                File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(scrFile, new File(ImageFilePath));

//                Screenshot scrFile = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
//                ImageIO.write(scrFile.getImage(),"PNG",new File(ImageFilePath));
            }
        } catch (Exception e) {

        }
//        return ImageFilePath;
        return Description.trim() + "_" + NowDateTime;

    }

    public boolean isAlertPresent(WebDriver driver) {
        try {
            driver.switchTo().alert();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void endTestcase() {
        extent.endTest(test);
    }

    public void endTestReport() {
        extent.flush();
    }

}
