package utility;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import testCases.Driver;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class WebDr extends HtmlReporter {


//    public String preferBrowser;
    public static Map<String, String> page_Objects = new HashMap<String, String> ();

    public WebDriver wdriver;



    public void openApplication(String URL, String preferBrowser) {
        try
        {
            DesiredCapabilities oCap = null;
            ChromeOptions options = new ChromeOptions();
            switch (preferBrowser)
            {
                case "Chrome":
                    System.setProperty("webdriver.chrome.driver", Constant.Chrome_Driver);
                    HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
                    chromePrefs.put("profile.default_content_settings.popups", 0);
                    chromePrefs.put("download.default_directory", Constant.Download);
                    options.setExperimentalOption("prefs", chromePrefs);
                    //options.addArguments("incognito");
                    DesiredCapabilities cap = DesiredCapabilities.chrome();
                    cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                    cap.setCapability(ChromeOptions.CAPABILITY, options);
                    wdriver = new ChromeDriver(cap);
                    wdriver.manage().deleteAllCookies();
                    break;
                case "HeadLess": System.setProperty("webdriver.chrome.driver", Constant.Chrome_Driver);
//                    ChromeOptions option = new ChromeOptions();
                    options = new ChromeOptions();
                    options.addArguments("--headless");
                    options.addArguments("window-size=1600,900");
                    wdriver = new ChromeDriver(options);break;
                case "IE":
                    System.setProperty("webdriver.ie.driver", Constant.IE_Driver);
                    oCap = DesiredCapabilities.internetExplorer();
                    oCap.setCapability("ignoreZoomSetting", true);
                    oCap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
                    wdriver = new InternetExplorerDriver (oCap);
                    break;
                case "Firefox":
                    System.setProperty("webdriver.gecko.driver", Constant.Firefox_Driver);
                    oCap = DesiredCapabilities.firefox();
                    oCap.setBrowserName("firefox");
                    wdriver= new FirefoxDriver(oCap);
                    wdriver.manage().deleteAllCookies();
                    break;
                case "Firefox_HeadLess":
                    System.setProperty("webdriver.gecko.driver", Constant.Firefox_Driver);
                    FirefoxOptions option = new FirefoxOptions();
                    option.setHeadless(true);
                    wdriver = new FirefoxDriver(option);
                    break;
                default:
                    break;
            }

            if (preferBrowser.equals("Mobile")) {
				/*client.launch(URL, Driver.instrument, true);//client.launch(activityURL, instrument, stopIfRunning);
				Thread.sleep(3000);
				client.elementSendText("", "", 0, ""); //client.elementSendText(zone, element, index, text);
				client.closeDevice();
				client.exit();*/
            }else{
                wdriver.get(URL);
                wdriver.manage().window().maximize();
                wdriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                wdriver.manage().timeouts().setScriptTimeout(60,TimeUnit.SECONDS);
//                WebElement html = wdriver.findElement(By.tagName("html"));
//                html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
//                Thread.sleep(2000);
                }
        }
        catch(Exception e)
        {
            System.out.println("Failed to create wdriver object for " + preferBrowser + " in Method openApplication in WebDr");
            throw e;
        }

    }

    public String getValue(String fieldName)
    {
        try
        {
            return Driver.dictionary.get(fieldName).trim();
        }
        catch(Exception e)
        {
            System.out.println("Exception in WebDr.getValue : " + fieldName + " - " + e.toString ());
            throw e;
        }
    }

    public WebElement getElement( String str) {
        try
        {
            String desc = page_Objects.get(str);
            String[] a = desc.split("\\|");
            WebDriverWait wait = new WebDriverWait(wdriver, 30);

            switch (a[0]) {
                case "ID":
//                    wait.until(ExpectedConditions.elementToBeClickable(wdriver.findElement(By.id(a[1]))));
                    return this.wdriver.findElement(By.id(a[1]));
                case "CLASSNAME":
//                    wait.until(ExpectedConditions.elementToBeClickable(wdriver.findElement(By.className(a[1]))));
                    return this.wdriver.findElement(By.className(a[1]));
                case "LINKTEXT":
//                    wait.until(ExpectedConditions.elementToBeClickable(wdriver.findElement(By.linkText(a[1]))));
                    return this.wdriver.findElement(By.linkText(a[1]));
                case "NAME":
//                    wait.until(ExpectedConditions.elementToBeClickable(wdriver.findElement(By.name(a[1]))));
                    return this.wdriver.findElement(By.name(a[1]));
                case "XPATH":
//                    wait.until(ExpectedConditions.elementToBeClickable(wdriver.findElement(By.xpath(a[1]))));
                    return this.wdriver.findElement(By.xpath(a[1]));
                default:
                    System.out.println("Function getElement cannot return object for " + str);
                    break;
            }
        }
        catch (Exception e)
        {
//            throw e;
        }
        return null;
    }

    //#######################################################################################
    public List<WebElement> getElements(String str) {

        try {
            String desc = page_Objects.get(str);
            String[] a = desc.split("\\|");
            switch (a[0]) {
                case "ID":
                    return wdriver.findElements(By.id(a[1]));
                case "XPATH":
                    return wdriver.findElements(By.xpath(a[1]));
                default:
                    break;
            }
        } catch (Exception e) {
            System.out.println("Exeption in WebDr.getElements - " + e);
            throw e;
        }
        return null;
    }

    //******************************************************************************************************************************
    public boolean exists(String elementName, boolean expected, String  description) throws Exception
    {
        boolean state = false;
        try {
            WebElement elmn = getElement(elementName);
            WebDriverWait wait = new WebDriverWait(wdriver, 60);
            wait.until(ExpectedConditions.visibilityOf(elmn));

            if (elmn.isDisplayed() && expected == true) {
                WriteStep(wdriver,description, elementName + ": Exists", elementName + ": Exists", "PASS");
                state = true;
            } else if (elmn.isDisplayed() && expected == false) {
                WriteStep(wdriver,description, elementName + ": Should not Exists", elementName + ": Exists", "FAIL");
                state = false;
            } else if (!elmn.isDisplayed() && expected == true) {
                WriteStep(wdriver,description, elementName + ": Exists", elementName + ": Does not exists", "FAIL");
                state = false;
            } else if (!elmn.isDisplayed() && expected == false) {
                WriteStep(wdriver,description, elementName + ": Does not exists", elementName + ": Does not exists", "PASS");
                state = true;
            }
        } catch (Exception e) {
            if (expected == true) {
                WriteStep(wdriver, description, elementName + ": Exists", elementName + ": Does not exists", "FAIL");
                state = false;
            } else if (expected == false) {
                WriteStep(wdriver,description, elementName + ": Does not exists", elementName + ": Does not exists", "PASS");
                state = true;
            }
        }
        return state;
    }

    //TODO: Method is to be verified by Akhilesh. Added by Lamlile on 25-04-2019
    public boolean isElementVisible(String elementName, boolean expected, String  description) throws Exception
    {
        boolean state = false;
        try {
            WebElement elmn = getElement(elementName);
            WebDriverWait wait = new WebDriverWait(wdriver, 60);
            wait.until(ExpectedConditions.visibilityOf(elmn));

            if (elmn.isDisplayed() && expected == true) {
                //WriteStep(wdriver,description, elementName + ": Exists", elementName + ": Exists", "PASS");
                state = true;
            } else if (elmn.isDisplayed() && expected == false) {
                //WriteStep(wdriver,description, elementName + ": Should not Exists", elementName + ": Exists", "FAIL");
                state = false;
            } else if (!elmn.isDisplayed() && expected == true) {
                //WriteStep(wdriver,description, elementName + ": Exists", elementName + ": Does not exists", "FAIL");
                state = false;
            } else if (!elmn.isDisplayed() && expected == false) {
                //WriteStep(wdriver,description, elementName + ": Does not exists", elementName + ": Does not exists", "PASS");
                state = true;
            }
        } catch (Exception e) {
            if (expected == true) {
                //WriteStep(wdriver, description, elementName + ": Exists", elementName + ": Does not exists", "FAIL");
                state = false;
            } else if (expected == false) {
                //WriteStep(wdriver,description, elementName + ": Does not exists", elementName + ": Does not exists", "PASS");
                state = true;
            }
        }
        return state;
    }

    //******************************************************************************************
    public boolean enabled(String elementName, boolean expected, String description) throws Exception {

        WebElement elmn = getElement(elementName);

        boolean state = false;
        try {
            if (elmn.isEnabled() && expected == true) {
                WriteStep(wdriver,description, elementName + ": should be enabled ", elementName + ": is enabled", "PASS");
                state = true;
            } else if (elmn.isEnabled() && expected == false) {
                WriteStep(wdriver,description, elementName + ": Should not be enabled ", elementName + ": is enabled", "FAIL");
                state = false;
            } else if (!elmn.isEnabled() && expected == true) {
                WriteStep(wdriver,description, elementName + ": should be enabled ", elementName + ": is not enabled", "FAIL");
                state = false;
            } else if (!elmn.isEnabled() && expected == false) {
                WriteStep(wdriver,description, elementName + ": Should not be enabled ", elementName + ": is not enabled", "PASS");
                state = true;
            }

        } catch (Exception e) {
            if (expected == true) {
                WriteStep(wdriver, description, elementName + ": should be enabled ", elementName + ": is not enabled", "FAIL");
                state = false;
            } else if (expected == false) {
                WriteStep(wdriver,description, elementName + ": Should not be enabled ", elementName + ": is not enabled", "PASS");
                state = true;

            }
//            throw e;
        }
        return state;

    }

    //******************************************************************************************

    public void setText(String elementName, String textToSet, String description) throws Exception {

        try {
            if (textToSet != null) {
                WebElement elmn = getElement(elementName);
                WebDriverWait wait = new WebDriverWait(wdriver, 30);
                wait.until(ExpectedConditions.visibilityOf(elmn));
                if (textToSet == "BLANK") {
                    textToSet = "";
                }
                elmn.clear();
                elmn.sendKeys(textToSet);
                WriteStep(wdriver,description, "Enter Text", "Entered - " + textToSet, "PASS");
            }
        } catch (Exception e) {
            System.out.println("Exeption in WebDr.ControlKeyStroke - " + e);
            WriteStep(wdriver,"Object not visible - " + description, "Enter Text", "Not Entered - " + textToSet, "FAIL");
            throw e;
        }

    }

    public void jsClick(String elementName, String description) throws Exception{
        try {
            WebElement elmn = getElement(elementName);
            WebDriverWait wait = new WebDriverWait(wdriver, 60);
            wait.until(ExpectedConditions.elementToBeClickable(elmn));
            if(elmn.isDisplayed()) {

                JavascriptExecutor jsClick = (JavascriptExecutor) wdriver;
                jsClick.executeScript ("arguments[0].click();", elmn);
                WriteStep(wdriver,description, "Click", "Clicked" , "PASS" );
            } else
            {
                WriteStep(wdriver,"Object not visible - " + description, "Click on " + description, "Not Clicked" , "FAIL" );
            }
        }catch(Exception e){
            WriteStep(wdriver,"Object not visible - " + description, elementName + ": Click", elementName + ": Not Clicked", "FAIL");
            System.out.println("Exeption in WebDr.click - "+ elementName + " - "+ e.toString ());
            throw e;
        }
    }
    public void click(String elementName, String description) throws Exception
    {
        try
        {
//            WebElement elmn = getElement(elementName);
//            JavascriptExecutor jsClick = (JavascriptExecutor)wdriver;
//            jsClick.executeAsyncScript("arguments[0].click()",elmn);

            WebElement elmn = getElement(elementName);
            WebDriverWait wait = new WebDriverWait(wdriver, 60);
            wait.until(ExpectedConditions.elementToBeClickable(elmn));
            if(elmn.isDisplayed())
            {
                Actions action = new Actions(wdriver);
                action.moveToElement(elmn).click().build().perform();
//                elmn.click();
                Thread.sleep (2000);
                WriteStep(wdriver,description, "Click", "Clicked" , "PASS" );
            }
            else
            {
                WriteStep(wdriver,"Object not visible - " + description, "Click on " + description, "Not Clicked" , "FAIL" );
            }
        }
        catch(Exception e){
            WriteStep(wdriver,"Object not visible - " + description, elementName + ": Click", elementName + ": Not Clicked", "FAIL");
            System.out.println("Exeption in WebDr.click - "+ elementName + " - "+ e.toString ());
            throw e;
        }
     }

//*******************************************************************************************************************
    public void select(String elementName,String selectBy, String value, String description) throws Exception
    {
        try
        {
            WebElement elmn = getElement(elementName);
            WebDriverWait wait = new WebDriverWait(wdriver, 30);
            wait.until(ExpectedConditions.visibilityOf(elmn));
            if(elmn.isDisplayed() && elmn.isEnabled())
            {
                Select oSel=new Select(elmn);
                if(selectBy=="value")
                {
                    oSel.selectByValue(value);
                }
                else if(selectBy=="index")
                {
                    oSel.selectByIndex(Integer.parseInt(value));
                }
                else if(selectBy=="text")
                {
                    oSel.selectByVisibleText(value);
                }
                elmn.click();
                WriteStep(wdriver,description, "Select " + value, "Selected value: " + value, "PASS");
            }
            else
            {
                WriteStep(wdriver,"Object not visible - " + description, "Select " + value, "Unable Select value: " + value, "FAIL");
            }
        }
        catch(Exception e){
            WriteStep(wdriver,"Object not visible - " + description, "Select Value: " + value, "Unable to select value: " + value, "FAIL");
            System.out.println("Exeption in WebDr.select - "+e.toString ());
            throw e;
        }

    }

    //***************************************************************************************************************
    public String selectRadioGroup(String elementName, String textToSelect, String description) throws Exception {
        String sAllList = "",sActualData ="";


        try {
            boolean boolSelected = false;
            List<WebElement> elmn = getElements(elementName);

            List<WebElement> rdGrp = elmn;
            for (int irgNum = 0; irgNum < rdGrp.size(); irgNum++) {
                sActualData = rdGrp.get(irgNum).getText().trim();
                if (sActualData.equals ("")){
                    sActualData = rdGrp.get(irgNum).getAttribute ("value");
                }
//                if(sActualData.contains ("-")){
//                    sActualData = sActualData.split ("-")[0];
//                }
                if (sActualData.contains (textToSelect.trim())) {
                    rdGrp.get(irgNum).click();
                    boolSelected = true;
                    sAllList = sAllList + " , " + sActualData;
                    WriteStep(wdriver,description, "Select Radio Button :" + textToSelect, textToSelect + ": Selected", "PASS");
                    break;
                }
            }

            if (!boolSelected) {
                WriteStep(wdriver,description, textToSelect + " should be in List", textToSelect + " not in the List : " + sAllList, "FAIL");
            }
        } catch (Exception e) {
            WriteStep(wdriver,"Object not visible - " + description, "Select Radiobutton: " + textToSelect, "Unable to select radio button: " + textToSelect, "FAIL");
            System.out.println("Exeption in WebDr.click - " + e);
            throw e;
        }
        return sActualData;
    }

    //******************************************************************************************
    public void dblClick(String elementName, String description) throws Exception {
        try {
            Actions action = new Actions(wdriver);
            WebElement elmn = getElement(elementName);
            action.doubleClick(elmn).perform();
            WriteStep(wdriver,description, elementName + ": Double Click", elementName + ": Clicked", "PASS");
        } catch (Exception e) {
            System.out.println("Exeption in WebDr.click - " + e);
            WriteStep(wdriver,"Object not visible - " + description, elementName + ": Double Click", elementName + ": Not Clicked", "FAIL");
            throw e;
        }

    }


    //******************************************************************************************
    public void rightClick(String elementName, String description) throws Exception {
        try {
            Actions action = new Actions(wdriver);
            WebElement elmn = getElement(elementName);
            action.contextClick(elmn).perform();
            WriteStep(wdriver,description, elementName + ": Right Click", elementName + ": Clicked", "PASS");

        } catch (Exception e) {
            System.out.println("Exeption in WebDr.click - " + e);
            WriteStep(wdriver,"Object not visible - " + description, elementName + "Right Click", elementName + ": Not Clicked", "FAIL");
            throw e;
        }

    }

    //******************************************************************************************

    public  void mouseOver(String elementName, String description) throws Exception {
        try {
            Actions action = new Actions(wdriver);
            WebElement elmn = getElement(elementName);
            action.moveToElement(elmn).perform();
            WriteStep(wdriver,description, "Mouse Over", "Mouse Moved", "PASS");

        } catch (Exception e) {
            System.out.println("Exeption in WebDr.click - " + e);
            WriteStep(wdriver,"Object not visible - " + description, "Mouse Over", "Mouse not moved", "FAIL");
            throw e;
        }
    }

    //******************************************************************************************
    public void ControlKeyStroke(String elementName, String KeyToEnter, String description) throws Exception {
        try {
            Actions action = new Actions(wdriver);
            WebElement elmn = getElement(elementName);
            action.sendKeys(Keys.chord(Keys.CONTROL, KeyToEnter)).perform();
            WriteStep(wdriver,description, "Key Stroke", "Key stroke entered", "PASS");
        } catch (Exception e) {
            System.out.println("Exeption in WebDr.ControlKeyStroke - " + e);
            WriteStep(wdriver,"Object not visible - " + description, "Key Stroke ", "Keys not entered", "FAIL");
            throw e;
        }
    }

    //******************************************************************************************

    public void setPwd(String elementName, String sPassword, String description) throws Exception {
        try {

            WebElement elmn = getElement(elementName);
            elmn.clear();
            String EncryptedPwd = java.util.Base64.getEncoder().encodeToString(sPassword.getBytes());
            elmn.sendKeys(new String(sPassword));
            WriteStep(wdriver,description, "Enter Password", " Password Entered - " + EncryptedPwd, "PASS");

        } catch (Exception e) {
            System.out.println("Exeption in WebDr.ControlKeyStroke - " + e);
            WriteStep(wdriver,"Object not visible - " + description, "Enter Text", "Not Entered - " + sPassword, "FAIL");
            throw e;
        }
    }

    //******************************************************************************************************************************************
    public void verifyText(String elementName, boolean matchSubString, String expectedText, String description) throws Exception {
        try {
            WebElement elmn = getElement(elementName);
            if (elmn.isDisplayed()) {
                String actualText = elmn.getText();
                if (matchSubString == true) {
                    if (actualText.contains(expectedText)) {
                        WriteStep(wdriver,description, "Verify Text - " + expectedText, "Verified - " + actualText, "PASS");
                    } else {
                        WriteStep(wdriver,description, "Verify Text -" + expectedText, "Verification failed - " + actualText, "FAIL");
                    }
                } else {
                    if (actualText.equals(expectedText)) {
                        WriteStep(wdriver,description, "Verify Text - " + expectedText, "Verified - " + actualText, "PASS");
                    } else {
                        WriteStep(wdriver,description, "Verify Text -" + expectedText, "Verification failed - " + actualText, "FAIL");
                    }
                }
            } else {
                WriteStep(wdriver,"Object not visible - " + description, "Verify Text -" + expectedText, "Not Verified", "FAIL");
            }
        } catch (Exception e) {
            System.out.println("Exeption in WebDr.verifyText - " + e);
            WriteStep(wdriver,"Object not visible - " + description, "Verify Text -" + expectedText, "Not Verified", "FAIL");
            throw e;
        }
    }

    //******************************************************************************************
    //To fetch the value within the tag
    //******************************************************************************************
    public String getText(String elementName, String description) throws Exception {
        String textValue = "";
        try {
            if (textValue != null) {
                WebElement elmn = getElement(elementName);
                if (elmn.isDisplayed()) {
                    textValue = elmn.getText();

                } else {
                    WriteStep(wdriver,"Object not visible - " + description, "Get value for " + description, "Object Not visible.", "FAIL");
                }
            }
        } catch (Exception e) {
            WriteStep(wdriver,"Object not visible - " + description, "Get value for " + description, "Object Not visible.", "FAIL");
            System.out.println("Exeption in WebDr.getROPropertyValue - " + e);
            throw e;
        }
        return textValue;
    }

    //******************************************************************************************
    public void verifyAttribute(String elementName, boolean matchSubString, String attribute, String expectedText, String description) throws Exception {
        try {
            WebElement elmn = getElement(elementName);
            if (elmn.isDisplayed()) {
                String actualText = elmn.getAttribute(attribute);
                if (matchSubString == true) {
                    if (actualText.contains(expectedText)) {
                        WriteStep(wdriver,description, "Verify Attribute - " + expectedText, "Verified - " + actualText, "PASS");
                    } else {
                        WriteStep(wdriver,description, "Verify Attribute -" + expectedText, "Verification failed - " + actualText, "FAIL");
                        throw new Exception("Failed");
                    }
                } else {
                    if (actualText.equals(expectedText)) {
                        WriteStep(wdriver,description, "Verify Attribute - " + expectedText, "Verified - " + actualText, "PASS");
                    } else {
                        WriteStep(wdriver,description, "Verify Attribute -" + expectedText, "Verification failed - " + actualText, "FAIL");
                        throw new Exception("Failed");
                    }
                }
            } else {
                WriteStep(wdriver,"Object not visible - " + description, "Verify Attribute -" + expectedText, "Not Verified", "FAIL");
            }
        } catch (Exception e) {
            WriteStep(wdriver,"Object not visible - " + description, "Verify Attribute -" + expectedText, "Not Verified", "FAIL");
            System.out.println("Exeption in WebDr.verifyAttribute - " + e);
            throw e;
        }
    }

    //******************************************************************************************

    public String getROPropertyValue(String elementName, String propertyName, String description) throws Exception
    {
        String propValue = "";
        try
        {
            if(propertyName!=null)
            {
                WebElement elmn = getElement(elementName);

                WebDriverWait wait = new WebDriverWait(wdriver, 30);
//                wait.until(ExpectedConditions.visibilityOf(elmn));
//                if(elmn.isDisplayed ())
                {
                    propValue = elmn.getAttribute(propertyName);
                }
//                else
//                {
//                    WriteStep(wdriver,"Object not visible - " + description, "Get '"+propertyName+"' for " + description, "Object Not visible." , "FAIL" );
//                }

            }
        }
        catch(Exception e){
            System.out.println("Exeption in WebDr.getROPropertyValue - "+e);
            WriteStep(wdriver,"Object not visible - " + description, "Get '"+propertyName+"' for " + description, "Object Not visible." , "FAIL" );
            throw e;
        }
        return propValue;
    }

    public String GenRSAID(int iage, String sGender) {
        // Get DOB from Age
        String DOB = GetDOB(iage);

        //Get Random Number based on Gender
        int GenNum;
        if (sGender == "Female") {
            GenNum = ThreadLocalRandom.current().nextInt(1000, 4999);
        } else {
            GenNum = ThreadLocalRandom.current().nextInt(5000, 9999);
        }


        int iCitizenship = 0;
        int iA = 8;

        String temp = DOB + GenNum + iCitizenship + iA;
        String RSAID = temp + generateLuhnDigit(temp);
        return RSAID;
    }

    public int generateLuhnDigit(String input) {
        int total = 0;
        int count = 0;
        int multiple = 0;

        for (int i = 0; i < input.length(); i++) {
            multiple = (count % 2) + 1;
            count++;
            int temp = multiple * Integer.parseInt(String.valueOf(input.charAt(i)));
            temp = (int) Math.floor(temp / 10) + (temp % 10);
            total += temp;

        }
        total = (total * 9) % 10;
        return total;

    }

    public String GetDOB(int age) {
        LocalDate now = LocalDate.now();
        LocalDate dob = now.minusYears(age);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMdd");
        String Date = dob.format(formatter);
        return Date;
    }

    //*********************************************************************************************
// Genarate Passport id
//*********************************************************************************************

    public static String genPassportID(int Count) {
        String PassportID = RandomStringUtils.randomAlphanumeric(Count);
        return PassportID;
    }

    //******************************************************************************************

    public void Verifyalerttext(String expectedText, String command) throws Exception {
        try {
            Alert alert = wdriver.switchTo().alert();
            String alertText = alert.getText();
            System.out.println(alertText);
            if (command.equalsIgnoreCase("accept")) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            Thread.sleep(3000);
            if (alertText.equals(expectedText)) {
                WriteStep(wdriver,"Validate text in Alert box", expectedText, alertText, "PASS");
            } else {
                WriteStep(wdriver,"Validate text in Alert box", expectedText, alertText, "FAIL");
            }
            Thread.sleep(4000);
        } catch (Exception e) {
            WriteStep(wdriver,"Validate text in Alert box", "Alert message should be same as Expected", "Alert box not displayed", "FAIL");
            throw e;
        }
    }

    //*****************************************************************************************************************************************************************
    public boolean isAlertPresent(WebDriver driver) {
        try {
            driver.switchTo().alert();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //******************************************************************************************************************************************
    public void validateString(String strExpected, String strActual, String description) throws Exception {
        try {

            if (strExpected.toUpperCase().equals ("NOT BLANK")) {

                if (strActual.length() == 0) {
                    WriteStep(wdriver,description, strExpected, strActual, "FAIL");
                } else {
                    WriteStep(wdriver,description, strExpected, strActual, "PASS");
                }

            } else if (strExpected.toUpperCase().equals ("OPTIONAL")) {

                WriteStep(wdriver,description, strExpected, strActual, "PASS");

            } else {
                if (strExpected.equalsIgnoreCase(strActual)) {
                    WriteStep(wdriver,description,  strExpected,  strActual, "PASS");
                } else {
                    WriteStep(wdriver,description,  strExpected,  strActual, "FAIL");
//                    throw new Exception("Failed");
                }
            }

        } catch (Exception e) {
            WriteStep(wdriver,description,"The actual text should match the actual","Object not displayed","FAIL");
            System.out.println("Exeption in WebDr.setText - " + e);
//            throw e;
        }
    }

    //******************************************************************************************
    public void setTextFromList(String elementName, String textToSet, String description) throws Exception {
        try {
            if (textToSet != null) {
                WebElement elmn = getElement(elementName);
                if (elmn.isDisplayed()) {
                    elmn.clear();
                    String xPAthText = "";
                    for(int aa = 0; aa<textToSet.length()-1;aa++){
                        String character = textToSet.substring(aa,aa+1);
                        elmn.sendKeys(character);
//                        Thread.sleep(200);
                        xPAthText = xPAthText + character;
                    }
//                    Thread.sleep(3000);
//                    elmn.sendKeys(Keys.ARROW_DOWN);
                    Thread.sleep(2000);
                    String xPATH = "//div[contains(text(),'"+xPAthText+"')]";
                    wdriver.findElement(By.xpath(xPATH)).click();
//                    elmn.sendKeys(Keys.RETURN);
                    WriteStep(wdriver,description, "Enter Text", "Entered - " + textToSet, "PASS");
                } else {
                    WriteStep(wdriver,"Object not visible - " + description, "Enter Text", "Not Entered - " + textToSet, "FAIL");
                }
            }
        } catch (Exception e) {
            WriteStep(wdriver,"Object not visible - " + description, "Enter Text", "Not Entered - " + textToSet, "FAIL");
            System.out.println("Exeption in WebDr.setTextFromList - " + e);
            throw e;
        }
    }

    //***********************************************************************************************************************************************************************************************************************************************************************/

    public  String getCelldata(WebDriver driver, String TableName, int RowNum, String ColName) throws Exception {
        String returnValue, sBaseElemXpath, colXpath_firstPart, colXpath_secondPart, colXpath_thirdPart, finalxpath;
        WebElement elmn = getElement(TableName);
        String desc = page_Objects.get(TableName);
        String[] a = desc.split("\\|");
        sBaseElemXpath = a[1];
        int ColNum;
        boolean ColFlag;
        returnValue = "";
        try {
            //Find the Column Number
            if (elmn.isDisplayed()) {
                colXpath_firstPart = sBaseElemXpath + "//tr[";
                colXpath_secondPart = "]/td[";
                colXpath_thirdPart = "]";
                List<WebElement> rows = elmn.findElements(By.tagName("tr"));
                WebElement HeaderRow = rows.get(0);
                List<WebElement> cells = HeaderRow.findElements(By.tagName("td"));
                if (cells.isEmpty()) {
                    cells = HeaderRow.findElements(By.tagName("th"));
                }
                ColNum = 0;
                ColFlag = false;
                for (WebElement cell : cells) {
                    ColNum++;
                    String cellText = cell.getText();
                    if (cellText.toLowerCase().equals(ColName.toLowerCase())) {
                        ColFlag = true;
                        finalxpath = colXpath_firstPart + RowNum + colXpath_secondPart + ColNum + colXpath_thirdPart;
                        returnValue = driver.findElement(By.xpath(finalxpath)).getText();
                        break;
                    }
                }
                if (ColFlag = false) {
                    WriteStep(wdriver,"Table : " + TableName + " Column :" + ColName, "Exist", "Does Not Exist", "FAIL");
                } else {
                    WriteStep(wdriver,"Table : " + TableName + " Column :" + ColName, "Exist", "Value : " + returnValue, "PASS");
                }
            }
            return returnValue;
        }
        catch (Exception e) {
            WriteStep(wdriver,"Object not visible - " + TableName, "Table should be present", "Table Not present" , "FAIL");
            System.out.println("Exeption in WebDr.dblClick - " + e);
            throw e;
        }
    }

    //*********************************************************************************************************************************************
    public void Highlight(String ObjName) throws Exception {
        WebElement elmn = getElement(ObjName);
        try {
            if (elmn.isDisplayed() && elmn.isEnabled()) {

                JavascriptExecutor jse = (JavascriptExecutor) wdriver;
                jse.executeScript("arguments[0].style.border='3px solid red'", elmn);
            }
        } catch (Exception e) {
            System.out.println("Exception in WebDr.Highlight- " + e);
            throw e;
        }
    }

    //******************************************************************************************

    public String GetcurrDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        String DateTime = dateFormat.format(date);
        return DateTime;
    }

    //******************************************************************************************

    public String GetcurrDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String Date1 = dateFormat.format(date);
        return Date1;
    }

    //******************************************************************************************

    public String GetDate() {
        DateFormat dateFormat = new SimpleDateFormat("ddMMyyyyHHmmss");
        Date date = new Date();
        String Date1 = dateFormat.format(date);
        return Date1;
    }

    //******************************************************************************************
    //Passing positive count will return future date
    //Passing negative count will return previous date
    public String GetdiffDate(int Count) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, (Count));
        String FutureDate = dateFormat.format(cal.getTime());
        return FutureDate;
    }

    //******************************************************************************************

    public  String GetprevDate(int Count) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, (Count));
        String PrevDate = dateFormat.format(cal.getTime());
        return PrevDate;
    }

    //******************************************************************************************

    public byte[] Password(String Pwd) {
        byte[] decodedBytes = org.apache.commons.codec.binary.Base64.decodeBase64(Pwd);
        return decodedBytes;
    }

    //*********************************************************************************************
// Killing the Process
//*********************************************************************************************

    public boolean isProcessRunning(String serviceName) throws Exception {
        Process p = Runtime.getRuntime().exec("tasklist");
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                p.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.contains(serviceName)) {
                return true;
            }
        }

        return false;

    }

    //*********************************************************************************************
    public void killProcess(String serviceName) throws Exception {
        boolean status = isProcessRunning("tasklist");
        if (status) {
            Runtime.getRuntime().exec("taskkill /F /IM " + serviceName);
        }
    }

    //*********************************************************************************************

    public boolean verifyPageDisplayed(String pageName, int WaitSecs) throws Exception {
        boolean pageStatus;
        String sPageTitle;

        try {
            WebDriverWait wait = new WebDriverWait(wdriver, WaitSecs);
            boolean element = wait.until(ExpectedConditions.titleContains(pageName));

            sPageTitle = wdriver.getTitle();
            if (element) {
                pageStatus = true;
                WriteStep(wdriver,sPageTitle, "Page Displayed", "Page Displayed", "PASS");
            } else {
                pageStatus = false;
                WriteStep(wdriver,sPageTitle, "Page Displayed", "Page Not Displayed", "FAIL");
            }
            return pageStatus;
        } catch (Exception e) {
            throw e;
        }
    }

    //******************************************************************************************
    // Calculate Age from DOB(DD/MM/YYYY)
    public int getAge(String strDOB) {

        int age;
        String[] Temp = strDOB.split("/");
        int DOBday = Integer.parseInt(Temp[0]);
        int DOBmonth = Integer.parseInt(Temp[1]);
        int DOByear = Integer.parseInt(Temp[2]);
        final Calendar calenderToday = Calendar.getInstance();
        int currentYear = calenderToday.get(Calendar.YEAR);
        int currentMonth = 1 + calenderToday.get(Calendar.MONTH);
        int todayDay = calenderToday.get(Calendar.DAY_OF_MONTH);

        age = currentYear - DOByear;
        if (DOBmonth > currentMonth) {
            --age;
        } else if (DOBmonth == currentMonth) {
            if (DOBday > todayDay) {
                --age;
            }
        }
        return age;
    }


    //******************************************************************************************************************

    public int getRowCount(String TableName) throws Exception {

        int returnValue = 0;
        WebElement elmn = getElement(TableName);
        try {
            //Find the Column Number
            if (elmn.isDisplayed()) {
                List<WebElement> rows = elmn.findElements(By.tagName("tr"));
                returnValue = rows.size();
            }
            return returnValue;
        }
        catch (Exception e) {
            System.out.println("Exeption in WebDr.dblClick - " + e);
            throw e;
        }
    }

    //********************************************************************************************************************
    public void openNewApplicationTab(String URL) throws Exception
    {
        Robot r;
        ArrayList<String> tabs;
        r = new Robot();
        r.keyPress(KeyEvent.VK_CONTROL);
        r.keyPress(KeyEvent.VK_T);
        r.keyRelease(KeyEvent.VK_CONTROL);
        r.keyRelease(KeyEvent.VK_T);
        Thread.sleep(2000);
        tabs = new ArrayList<String> (wdriver.getWindowHandles());
        SwitchTabs(tabs.size());
        Thread.sleep(2000);
        wdriver.get(URL);
        WriteStep(wdriver,"Open New URL Tab","Opened a new URL in a new Tab " , "Opened a new URL in a new Tab", "PASS");
    }


   //***********************************************************************************************************************
   public boolean SwitchTabs(int tabNumber) throws Exception
   {
       ArrayList<String> tabs;
       int reqTab = tabNumber - 1;
       Thread.sleep(5000);

       try
       {
           tabs = new ArrayList<String> (wdriver.getWindowHandles());
           if(tabs.size() > 1)
           {
               wdriver.switchTo().window(tabs.get(reqTab));
               WriteStep(wdriver,"opening a new tab", "Switch to tab " + tabNumber, "Switched to tab " + tabNumber, "PASS");
               return true;
           }
           else
           {
               System.out.println("Ony one tab is open in browser");
               wdriver.switchTo().window(tabs.get(reqTab));
               WriteStep(wdriver,"opening a new tab", "Switch to tab " + tabNumber, "Switched to tab " + tabNumber, "PASS");
               return true;
           }
       }
       catch (Exception e)
       {
           WriteStep(wdriver,"opening a new tab", "Switch to tab " + tabNumber, "Switched to tab " + tabNumber, "FAIL");
           throw e;
       }
   }

   //*************************************************************************************************************************
    public String dateConversion(String date1) {
        SimpleDateFormat formatter =new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        SimpleDateFormat parse =new SimpleDateFormat("dd MMMM yyyy HH:mm:ss");
        Date dDate = null;
        String sDate = null;
        try{

            dDate = formatter.parse((date1));
            sDate = parse.format(dDate);

        }catch(Exception e){
            System.out.println(e.getMessage()+" "+e.getCause());

        }
        return sDate;
    }

    //****************************************************************************************************************************

    public  Boolean VerifyPDFText(String InputURL, String Value) throws Exception {
        URL url = new URL(InputURL);
        InputStream is = url.openStream();
        BufferedInputStream fileToParse = new BufferedInputStream(is);
        PDDocument document = null;
        try {
            document = PDDocument.load(fileToParse);
            String output = new PDFTextStripper().getText(document);
            Boolean found = output.contains(Value);
            return found;
        } finally {
            if (document != null) {
                document.close();
            }
            fileToParse.close();
        }

    }

    //====================================================================================
    public void validateNumbers(String strExpected, String strActual, String description) {
        strExpected = strExpected.replace(",", "");
        strActual = strActual.replace(",", "");
        try
        {		if (strExpected.equals("") || strActual.equals("")){
            WriteStep(wdriver, description, "Expected : " + strExpected, "Actual - " + strActual, "FAIL" );
        }
        else{
            Double iExpected = Double.parseDouble(strExpected);
            Double iActuial = Double.parseDouble(strActual);
            if(iExpected.equals(iActuial))
            {
                WriteStep(wdriver, description, "Expected : " + strExpected, "Actual - " + strActual, "PASS" );
            }
            else
            {
                WriteStep(wdriver, description, "Expected : " + strExpected, "Actual - " + strActual, "FAIL" );
            }
        }
        }
        catch(Exception e){System.out.println("Exeption in WebDr.setText - "+e);}
    }

    public String ReadOutlookMsg(String strSubjectLine) throws Exception{
        Runtime rt = Runtime.getRuntime ();
        String strEmailData = "";
        try{

            String vbsPath =  Constant.Path_Plugin + "ReadMail.vbs  ";
            Process p = rt.exec ("wscript " + vbsPath + strSubjectLine);
            p.waitFor ();
            File file = new File( Driver.userDir + "\\MailData.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            strEmailData = new String(Files.readAllBytes(Paths.get(Driver.userDir + "\\MailData.txt")));
            br.close ();
            file.delete ();
        }
        catch (Exception e){

            throw e;
        }
        return  strEmailData;
    }

    public void jsScroll(String elemenName, String description) throws Exception{
        try {
            WebElement elmn = getElement(elemenName);
            WebDriverWait wait = new WebDriverWait(wdriver, 60);
            wait.until(ExpectedConditions.elementToBeClickable(elmn));
            if(elmn.isDisplayed()) {

                JavascriptExecutor jsScroll = (JavascriptExecutor) wdriver;
                jsScroll.executeScript ("arguments[0].scrollIntoView();", elmn);
                //js.executeScript("arguments[0].scrollIntoView();", Element);
                WriteStep(wdriver,description, "Scroll", "Scrolled" , "PASS" );
            } else
            {
                WriteStep(wdriver,"Object not visible - " + description, "Scroll on " + description, "Not Scrolled" , "FAIL" );
            }

        } catch (Exception e) {
            // TODO: handle exception
            throw e;
        }

    }


}
