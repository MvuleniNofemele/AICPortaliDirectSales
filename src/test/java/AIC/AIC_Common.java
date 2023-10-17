package AIC;

import AIC_POM.AIC_Common_POM;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utility.WebDr;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class AIC_Common extends WebDr {

    public int age = ThreadLocalRandom.current().nextInt(25, 100);
    public String gender = (ThreadLocalRandom.current().nextInt(1000, 9999)>=5000 ? "Male" : "Female");
    String sID_Number = getValue("ID_Number");
    String sProcessName;
    String sFirstName = getValue("FirstName");
    String sLastName = getValue("Surname");
    String sVehicleFinanced = getValue("isVehicleFinanced");

    public AIC_Common(WebDriver wdriver, ExtentTest test)
    {
        this.wdriver = wdriver;
        this.test = test;
    }
    /*Comment to be pushed to git*/
    /*second comment*/

    public boolean fn_selectCampaign()
    {
        AIC_Common_POM.SetPage_Common();
        String sFirstNametext;
        String sLastNametext;
        boolean blnSelectCampaign = false;
        String sTestScenario = getValue("TestCase_Name");

        try {
            //sID_Number = "8111237528093";
            String lblCampaign = wdriver.findElement(By.xpath("//h1[normalize-space()='Campaign Members']")).getText();
            validateString(lblCampaign,"Campaign Members","label Campaign members should be displayed");
            //wdriver.findElement(By.xpath("//a[@id='templ:cam_reg:0:campai:7:select_link']")).click();

            for (int j=1;j<=100;j++)
            {
                sFirstNametext = wdriver.findElement(By.xpath("//table[@class='x13s']/tbody/tr["+j+"]/td[1]/span")).getText();//First Name on campaign members list
                sLastNametext = wdriver.findElement(By.xpath("//table[@class='x13s']/tbody/tr["+j+"]/td[1]/following-sibling::td[1]/span[1]")).getText();//Last Name on campaign members list

                if(sFirstNametext.equalsIgnoreCase(sFirstName) && sLastNametext.equalsIgnoreCase(sLastName))
                {
                    sProcessName = wdriver.findElement(By.xpath("//table[@class='x13s']/tbody/tr["+j+"]/td[8]/span")).getText();//Process Name on campaign members list
                    Thread.sleep(2000);
                    wdriver.findElement(By.xpath("//table[@class='x13s']/tbody/tr["+j+"]/td[10]/span/table/tbody/tr/td/a")).click();//click on the select
                    break;
                }

            }

            switch (sProcessName){
                case "":
                case "Insured":
                    fn_Current();
                    fn_Insured();
                    break;
                case "Needs":
                    fn_Current();
                    fn_needsSelectionAndFillUp(sTestScenario);
                    break;
                case "Quote":
                    fn_Current();
                    fn_Quoting();
                    break;
                case "Underwriting":
                    fn_Current();
                    fn_Underwriting();
                    break;
                case "Summary":
                    fn_Current();
                    fn_Summary();
                    break;
                case "Status":
                    fn_Status();
                    fn_Quoting();
                case "Documents":
                    fn_Current();
                    fn_Documents();
                case "Referrals":
                    fn_Current();
                    fn_Referrals();
                case "Notes":
                    fn_Current();
                    fn_Quoting();
                    break;
                default: fn_Current();
            }

            blnSelectCampaign = true;

        }catch (Exception e) {
            System.out.println("Exception in Campaign script "  + e );
            //throw e;
        }

        return blnSelectCampaign;
    }

    public boolean fn_Current() throws Exception
    {
        AIC_Common_POM.SetPage_Common();
        boolean currentScreen = false;

        try {
            Thread.sleep(2000);

            //Validate the current page screen
            exists("lblCurrent", true, "'Current' label should be visible"); // This method is not working

            //Click the Next button
            click("btnNext", "Click 'Next' button");

            currentScreen = true;
        }catch (Exception e) {
            throw e;
        }

        return currentScreen;
    }

    public boolean fn_Insured() throws Exception
    {
        AIC_Common_POM.SetPage_Common();
        boolean insuredScreen = false;
        String sTestScenario = getValue("TestCase_Name");

        try {
            Thread.sleep(3000);
            //validateString("lblGeneral","General","General label should be visible");
            select("drpLeadIndicator","text","AVAF New business","Select Lead Indicator");
            select("drpITC","text","Yes","Select ITC Check drop down");
            select("drpPolicycancelledbycompany","text","No","Select ITC Check drop down");
            select("drpHouseholdclaims_past3years","text","No","Select ITC Check drop down");
//          select("drpLossLast3yrs","text","3","Select ITC Check drop down");
//          click("btnSave", "Click 'Save' button");//click 'save' button
            wdriver.findElement(By.xpath("//a[contains(.,'Save')]")).click();

            //Call Needs screen
            fn_needsSelectionAndFillUp(sTestScenario);

            insuredScreen = true;

        }catch (Exception e) {
            throw e;
        }

        return insuredScreen;
    }

    public boolean fn_Needs()throws Exception
    {
        boolean needsScreen = false;

        try {

            needsScreen = true;
        }catch (Exception e) {
            throw e;
        }

        return needsScreen;
    }

    public boolean fn_Quoting() throws Exception
    {
        AIC_Common_POM.SetPage_Common();
        boolean quotingScreen = false;
        //testing date format
        String pattern = "M-dd-yyyy";
        String dateInString =new SimpleDateFormat(pattern).format(new Date());
        System.out.println(dateInString);
        String sVehicleDiscountLoading = getValue("VehicleDiscountLoading");
        String sBuildingDiscountLoading = getValue("BuildingDiscountLoading");
        String sHouseDiscountLoading = getValue("HouseDiscountLoading");
        String sMCDiscountLoading = getValue("MCDiscountLoading");

        try {

            //exists("txtEffctveDate",true,"Verify valid quote text is visible");
            String txtEffDate = wdriver.findElement(By.xpath("//label[@for='templ:t_r_con:0:effective_date::content'][contains(.,'Effective date')]")).getText();
            System.out.println("Displaying effective " + txtEffDate);
            Thread.sleep(3000);

            //Click Refresh button
            Thread.sleep(1000);
            click("refreshButton","click the refresh button");//click refresh button
            Thread.sleep(1000);
            click("refreshButton","click the refresh button");//click refresh button
            
            Thread.sleep(5000);
            setText("effctveDate",dateInString,"set effective date");//click effective date
            click("genQSDButtton","click Quote summary document");//click quote summary document
            click("btnOk","click OK button");//click OK button after generating policy schedule document
            Thread.sleep(3000);
            click("btnDetails","click Details button");//click details button

            //Load/Discount on quoting

            /*
            for (int j=1;j<=100;j++)
            {
                String sCover = wdriver.findElement(By.xpath("//table[@class='x13s']/tbody/tr[" + j + "]/td/span")).getText();//Verify text cover exists

                if(sCover.equalsIgnoreCase("Vehicle"))
                {
                    wdriver.findElement(By.xpath("//table[@class='x13s']/tbody/tr[" + j + "]/td/following-sibling::td/following-sibling::td/following-sibling::td/following-sibling::td/following-sibling::td/following-sibling::td")).click();//set text for vehicle discount/load
                    Thread.sleep(2000);
                    //setText("//table[@class='x13s']/tbody/tr[" + j + "]/td/following-sibling::td/following-sibling::td/following-sibling::td/following-sibling::td/following-sibling::td/following-sibling::td",sVehicleDiscountLoading,"Set Load/discount for vehicle");
                    //wdriver.findElement(By.xpath("//table[@class='x13s']/tbody/tr[" + j + "]/td/following-sibling::td/following-sibling::td/following-sibling::td/following-sibling::td/following-sibling::td/following-sibling::td")).sendKeys(sVehicleDiscountLoading);
                    String cVehicle = wdriver.findElement(By.xpath("//table[@class='x13s']/tbody/tr[" + j + "]/td/following-sibling::td/following-sibling::td/following-sibling::td/following-sibling::td/following-sibling::td/following-sibling::td")).toString();
                    setText(cVehicle,sVehicleDiscountLoading,"Set Load/discount for vehicle");
                    Thread.sleep(4000);
                    break;
                }
                wdriver.findElement(By.xpath("//div[@class='x1ez'][contains(.,'Discount/Loading %')]")).click();//Click outside text
                Thread.sleep(5000);

                if(sCover.equalsIgnoreCase("Motorcycle"))
                {
                    wdriver.findElement(By.xpath("//table[@class='x13s']/tbody/tr[" + j + "]/td/following-sibling::td/following-sibling::td/following-sibling::td/following-sibling::td/following-sibling::td/following-sibling::td")).sendKeys(sVehicleDiscountLoading);//set text for vehicle discount/load
                    Thread.sleep(4000);
                    break;
                }
                wdriver.findElement(By.xpath("//div[@class='x1ez'][contains(.,'Discount/Loading %')]")).click();//Click outside text
                Thread.sleep(5000);

                if(sCover.equalsIgnoreCase("Building"))
                {
                    wdriver.findElement(By.xpath("//table[@class='x13s']/tbody/tr[" + j + "]/td/following-sibling::td/following-sibling::td/following-sibling::td/following-sibling::td/following-sibling::td/following-sibling::td")).sendKeys(sVehicleDiscountLoading);//set text for vehicle discount/load
                    Thread.sleep(4000);
                    break;
                }
                wdriver.findElement(By.xpath("//div[@class='x1ez'][contains(.,'Discount/Loading %')]")).click();//Click outside text
                Thread.sleep(5000);

                if(sCover.equalsIgnoreCase("House"))
                {
                    wdriver.findElement(By.xpath("//table[@class='x13s']/tbody/tr[" + j + "]/td/following-sibling::td/following-sibling::td/following-sibling::td/following-sibling::td/following-sibling::td/following-sibling::td")).sendKeys(sVehicleDiscountLoading);//set text for vehicle discount/load
                    Thread.sleep(4000);
                    break;
                }

            }

             */

            //Load/Discount on quoting


//            Thread.sleep(3000);
//            if (isElementVisible("verifyVehicle",true,"Verify the vehicle cover"))
//            {
////                click("loadDiscVehicle","click edit text vehicle load/discount");
////                Thread.sleep(3000);
//                setText("loadDiscVehicle",sVehicleDiscountLoading,"Set Load/discount for vehicle");
////                wdriver.findElement(By.xpath("(//table[@class='x13s']/tbody/tr[5]/td/following-sibling::td/following-sibling::td/following-sibling::td/following-sibling::td/following-sibling::td/following-sibling::td/span)[1]")).sendKeys(sVehicleDiscountLoading);
//                Thread.sleep(5000);
//                wdriver.findElement(By.xpath("//div[@class='x1ez'][contains(.,'Discount/Loading %')]")).click();//Click outside text
//                Thread.sleep(5000);
//            }

            /*
            if (isElementVisible("verifyMotorcycle",true,"Verify the motorcyle cover"))
            {
//                click("loadDiscMotorcyle","click edit text motorcycle load/discount");
//                Thread.sleep(4000);
                setText("loadDiscMotorcyle",sMCDiscountLoading,"Set Load/discount for motorcycle");
                Thread.sleep(5000);
                wdriver.findElement(By.xpath("//div[@class='x1ez'][contains(.,'Discount/Loading %')]")).click();//Click outside text
                Thread.sleep(5000);
            }
            
             */

            /*
            if (isElementVisible("verifyBuilding",true,"Verify the building cover"))
            {
//                click("loadDiscBuilding","click edit text building load/discount");
//                Thread.sleep(4000);
                setText("loadDiscBuilding",sBuildingDiscountLoading,"Set Load/discount for building");
                Thread.sleep(5000);
                wdriver.findElement(By.xpath("//div[@class='x1ez'][contains(.,'Discount/Loading %')]")).click();//Click outside text
                Thread.sleep(5000);
            }
*/

//            if (isElementVisible("verifyHouse",true,"Verify the house cover"))
//            {
////                click("loadDiscHouse","click edit text house load/discount");
////                Thread.sleep(4000);
//                setText("loadDiscHouse",sHouseDiscountLoading,"Set Load/discount for house");
//                Thread.sleep(5000);
//                wdriver.findElement(By.xpath("//div[@class='x1ez'][contains(.,'Discount/Loading %')]")).click();//Click outside text
//                Thread.sleep(5000);
//            }
            
            click("saveButton","click save button");// click save button
            click("bckButton","click back button");//click back button

//            String txtProRata = wdriver.findElement(By.xpath("//h1[@class='x2b'][contains(.,'Pro Rata')]")).getText();
//            validateString(txtProRata,"Pro Rata","Validate the Pro rata");

            //validateString("lblTotalPremium","Total Premiums","verify Total premium is visible");//check Total premium label is displayed
            click("acceptButton","click accept button");//click accept button
            fn_Underwriting();

            quotingScreen = true;
        }catch (Exception e) {
            throw e;
        }

        return quotingScreen;
    }

    public boolean fn_Underwriting() throws Exception
    {
        AIC_Common_POM.SetPage_Common();
        boolean underwriting = false;

        Date today = new Date();
        SimpleDateFormat formattedDate = new SimpleDateFormat("dd-MMM-yyyy");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, 1);  // number of days to add
        String tomorrow = (String)(formattedDate.format(c.getTime()));
        System.out.println("Tomorrows date is " + tomorrow);

        System.out.println("print pro rata date: " + tomorrow);

        String sTestScenario = getValue("TestCase_Name");
        String sBuildingBond = getValue("BuildingBond");
        String sMotorcycleFinanced = getValue("MotorcycleFinanced");
        String sCaravanTrailerFinanced = getValue("CaravanTrailerFinanced");

        try {
                //String VAlnk = wdriver.findElement(By.xpath("//a[@id='templ:t_r_con:0:selected_item_link_18068_2']")).getText();//VA link
                //String HHlnk = wdriver.findElement(By.xpath("//a[contains(@id,'3')][@title='Edit'][contains(.,'House')]")).getText();//HH link

//                String VAlnk = wdriver.findElement(By.tagName("lnkVA")).getText();
//                String HHlnk = wdriver.findElement(By.tagName("lnkHH")).getText();

                //Banking details
//                if(exists("checkAvailable",true,"check banking details fields")){
//
//                }else {

                    click("lnkBankingDetails", "click banking details link");//click banking details link
                    Thread.sleep(4000);
                    click("chkBusinessAccount", "click check business account checkbox");//click business account checkbox
                    setText("txtAccntHolderNam", "ALTRON FINANC PTY LTD", "verify account holder name");//set text account holder name
                    setText("txtAccntHolderID", "200101358307", "verify account holder ID");//set text account holder ID
                    setText("txtAccntNumb", "4047707617", "verify account number");//set text account number
                    select("selctAccntType", "text", "Cheque", "select account type");//select account type
                    select("selctBankName", "text", "ABSA BANK LIMITED", "select bank name");//select bank name
                    Thread.sleep(4000);
                    click("btnValidate", "click button validate");//click validate button
                    click("chkMonthDebit", "click Month End Debit checkbox");//click Month debit checkbox
                    Thread.sleep(3000);

                    setText("chkboxProRata",tomorrow,"enter Pro rata date");//set pro rata date
                    click("chkAccntHolderConfrm", "click account holder confirmation");//click Account holder confirmation checkbox
                    click("btnSave", "click button save");//click save button

//                }

            switch (sTestScenario){

                case "iDirect_REQ_idirect_001_SEC01":
                    //House Content
                    click("lnkHH","click HH link");//click HH link
                    Thread.sleep(1000);
                    select("selctRegistredOwner","text","Insured","select registered owner for HH");//select registered owner for HH
                    click("saveBtn", "click save button");//click save button

                    //Electronic
                    click("lnkElect", "click electronic link");//click proceed button
                    setText("txtSerialNum","328329H34LD","set text serial number number");//serial number for electronic
                    click("saveElectBtn", "click electronic save button");//click electronic save button

//                  Building
                    /*
                    click("addBldLink","Click Building link");//building link
                    select("drpDwnBldRegNumber","text","Insured","Select Building Registered owner");

                    if(sBuildingBond.equalsIgnoreCase("Yes - Closed Bond") || sBuildingBond.equalsIgnoreCase("Yes - Open Bond"))
                    {
                        setText("txtFncAgrmtNmb","328329","set text finance agreement number");
                    }

                    click("btnBldSave","click save button for building");
                     */

                    //Vehicle
                    click("lnkVA","click the VA link");
                    setText("regNo","34UTIGP","Enter Registration Number");

                    if(sVehicleFinanced.equalsIgnoreCase("Yes"))
                    {
                        setText("txtFinanceExpryDate","02/03/2028","Enter Vehicle Expiry date");
                    }
                    setText("VinNo","VIN899343949SKDS","Enter Registration Number");
                    select("empSector","text","Administration","select emp sector");
                    click("vaSaveBtn","click save button for vehicle");

                    //Caravan/Trailer
                    click("addCTLink","Click CT link");//Caravan Trailer link
                    setText("txtRegOwner","Insurer","set text registered owner");
                    setText("txtRegNumber","DFD23GP","set text registration number");
                    if(sCaravanTrailerFinanced.equalsIgnoreCase("Yes"))
                    {
                        setText("txtFinanceExpryDate","02/03/2028","Enter Caravan/Trailer Expiry date"); //Regular Driver License Date
                    }
                    click("CTbtnSave","Click save button");

                    //Motorcycle
                    click("addMCLink","Click Motorcycle link");//motorcycle link
                    setText("txtMCRegNumber","GSD434NW","set text registration number");
                    setText("txtMCEngNumber","283KJSADH934","set text engine number");

                    if(sMotorcycleFinanced.equalsIgnoreCase("Yes"))
                    {
                        click("iconDate","click the date icon");
                        Thread.sleep(2000);
                        click("upArrwDate","click the up date arrow");
                        click("dayDate","click the date day");
                    }
                    click("btnMCSave","click save button for motorcycle");

                    click("btnProceed", "click proceed button");//click proceed button
                    fn_Summary();
                    break;

                case "iDirect_REQ_idirect_001_SEC02":
                    //House Content
                    click("lnkHH","click HH link");//click HH link
                    Thread.sleep(1000);
                    select("selctRegistredOwner","text","Insured","select registered owner for HH");//select registered owner for HH
                    click("saveBtn", "click save button");//click save button

                    //Electronic
                    click("lnkElect", "click electronic link");//click proceed button
                    setText("txtSerialNum","328329H34LD","set text serial number number");//serial number for electronic
                    click("saveElectBtn", "click electronic save button");//click electronic save button

//                  Building
                    /*
                    click("addBldLink","Click Building link");//building link
                    select("drpDwnBldRegNumber","text","Insured","Select Building Registered owner");
                    if(sBuildingBond.equalsIgnoreCase("Yes - Closed Bond") || sBuildingBond.equalsIgnoreCase("Yes - Open Bond"))
                    {
                        setText("txtFncAgrmtNmb","328329","set text finance agreement number");
                    }
                    click("btnBldSave","click save button for building");
                     */

                    //Vehicle
                    click("lnkVA","click the VA link");
                    setText("regNo","34UTIGP","Enter Registration Number");
                    if(sVehicleFinanced.equalsIgnoreCase("Yes"))
                    {
                        setText("txtFinanceExpryDate","02/03/2028","Enter Vehicle Expiry date");
                    }
                    setText("VinNo","VIN899343949SKDS","Enter Registration Number");
                    select("empSector","text","Administration","select emp sector");
                    click("vaSaveBtn","click save button for vehicle");

                    //Caravan/Trailer
                    click("addCTLink","Click CT link");//Caravan Trailer link
                    setText("txtRegOwner","Insurer","set text registered owner");
                    setText("txtRegNumber","DFD23GP","set text registration number");
                    if(sCaravanTrailerFinanced.equalsIgnoreCase("Yes"))
                    {
                        setText("txtFinanceExpryDate","02/03/2028","Enter Caravan/Trailer Expiry date"); //Regular Driver License Date
                    }
                    click("CTbtnSave","Click save button");

                    //Motorcycle
                    click("addMCLink","Click Motorcycle link");//motorcycle link
                    setText("txtMCRegNumber","GSD434NW","set text registration number");
                    setText("txtMCEngNumber","283KJSADH934","set text engine number");
                    if(sMotorcycleFinanced.equalsIgnoreCase("Yes"))
                    {
                        click("iconDate","click the date icon");
                        Thread.sleep(2000);
                        click("upArrwDate","click the up date arrow");
                        click("dayDate","click the date day");
                    }
                    click("btnMCSave","click save button for motorcycle");

                    click("btnProceed", "click proceed button");//click proceed button
                    fn_Summary();
                    break;

                case "iDirect_REQ_idirect_001_SEC03":
                    //House Content
                    click("lnkHH","click HH link");//click HH link
                    Thread.sleep(1000);
                    select("selctRegistredOwner","text","Insured","select registered owner for HH");//select registered owner for HH
                    click("saveBtn", "click save button");//click save button

                    //Electronic
                    click("lnkElect", "click electronic link");//click proceed button
                    setText("txtSerialNum","328329H34LD","set text serial number number");//serial number for electronic
                    click("saveElectBtn", "click electronic save button");//click electronic save button

//                  Building
                    click("addBldLink","Click Building link");//building link
                    select("drpDwnBldRegNumber","text","Insured","Select Building Registered owner");

                    if(sBuildingBond.equalsIgnoreCase("Yes - Closed Bond") || sBuildingBond.equalsIgnoreCase("Yes - Open Bond"))
                    {
                        setText("txtFncAgrmtNmb","328329","set text finance agreement number");
                    }

                    click("btnBldSave","click save button for building");

                    //Vehicle
                    click("lnkVA","click the VA link");
                    setText("regNo","34UTIGP","Enter Registration Number");

                    if(sVehicleFinanced.equalsIgnoreCase("Yes"))
                    {
                        setText("txtFinanceExpryDate","02/03/2028","Enter Vehicle Expiry date");
                    }
                    setText("VinNo","VIN899343949SKDS","Enter Registration Number");
                    select("empSector","text","Administration","select emp sector");
                    click("vaSaveBtn","click save button for vehicle");

                    //Caravan/Trailer
                    click("addCTLink","Click CT link");//Caravan Trailer link
                    setText("txtRegOwner","Insurer","set text registered owner");
                    setText("txtRegNumber","DFD23GP","set text registration number");
                    if(sCaravanTrailerFinanced.equalsIgnoreCase("Yes"))
                    {
                        setText("txtFinanceExpryDate","02/03/2028","Enter Caravan/Trailer Expiry date"); //Regular Driver License Date
                    }
                    click("CTbtnSave","Click save button");

                    //Motorcycle
                    click("addMCLink","Click Motorcycle link");//motorcycle link
                    setText("txtMCRegNumber","GSD434NW","set text registration number");
                    setText("txtMCEngNumber","283KJSADH934","set text engine number");

                    if(sMotorcycleFinanced.equalsIgnoreCase("Yes"))
                    {
                        click("iconDate","click the date icon");
                        Thread.sleep(2000);
                        click("upArrwDate","click the up date arrow");
                        click("dayDate","click the date day");
                    }
                    click("btnMCSave","click save button for motorcycle");

                    click("btnProceed", "click proceed button");//click proceed button
                    fn_Summary();
                    break;
                case "iDirect_REQ_idirect_001_SEC04":
                    //House Content

                    click("lnkHH","click HH link");//click HH link
                    Thread.sleep(1000);
                    select("selctRegistredOwner","text","Insured","select registered owner for HH");//select registered owner for HH
                    click("saveBtn", "click save button");//click save button

                    //Electronic
                    click("lnkElect", "click electronic link");//click proceed button
                    setText("txtSerialNum","328329H34LD","set text serial number number");//serial number for electronic
                    click("saveElectBtn", "click electronic save button");//click electronic save button



//                  Building
                    click("addBldLink","Click Building link");//building link
                    select("drpDwnBldRegNumber","text","Insured","Select Building Registered owner");

                    if(sBuildingBond.equalsIgnoreCase("Yes - Closed Bond") || sBuildingBond.equalsIgnoreCase("Yes - Open Bond"))
                    {
                        setText("txtFncAgrmtNmb","328329","set text finance agreement number");
                    }

                    click("btnBldSave","click save button for building");

                    //Vehicle

                    click("lnkVA","click the VA link");
                    setText("regNo","34UTIGP","Enter Registration Number");
                    if(sVehicleFinanced.equalsIgnoreCase("Yes"))
                    {
                        setText("txtFinanceExpryDate","02/03/2028","Enter Vehicle Expiry date");
                    }
                    setText("VinNo","VIN899343949SKDS","Enter Registration Number");
                    select("empSector","text","Administration","select emp sector");
                    click("vaSaveBtn","click save button for vehicle");

                    //Caravan/Trailer
                    click("addCTLink","Click CT link");//Caravan Trailer link
                    setText("txtRegOwner","Insurer","set text registered owner");
                    setText("txtRegNumber","DFD23GP","set text registration number");
                    if(sCaravanTrailerFinanced.equalsIgnoreCase("Yes"))
                    {
                        setText("txtFinanceExpryDate","02/03/2028","Enter Caravan/Trailer Expiry date"); //Regular Driver License Date
                    }
                    click("CTbtnSave","Click save button");

                    //Motorcycle
                    click("addMCLink","Click Motorcycle link");//motorcycle link
                    setText("txtMCRegNumber","GSD434NW","set text registration number");
                    setText("txtMCEngNumber","283KJSADH934","set text engine number");

                    if(sMotorcycleFinanced.equalsIgnoreCase("Yes"))
                    {
                        click("iconDate","click the date icon");
                        Thread.sleep(2000);
                        click("upArrwDate","click the up date arrow");
                        click("dayDate","click the date day");
                    }
                    click("btnMCSave","click save button for motorcycle");

                    click("btnProceed", "click proceed button");//click proceed button
                    fn_Summary();
                    break;

                case "iDirect_REQ_idirect_002_SEC05":

                    //House Content
                    click("lnkHH","click HH link");//click HH link
                    Thread.sleep(1000);
                    select("selctRegistredOwner","text","Insured","select registered owner for HH");//select registered owner for HH
                    click("saveBtn", "click save button");//click save button

                    //Electronic
                    click("lnkElect", "click electronic link");//click proceed button
                    setText("txtSerialNum","328329H34LD","set text serial number number");//serial number for electronic
                    click("saveElectBtn", "click electronic save button");//click electronic save button

//                  Building
                    click("addBldLink","Click Building link");//building link
                    select("drpDwnBldRegNumber","text","Insured","Select Building Registered owner");

                    if(sBuildingBond.equalsIgnoreCase("Yes - Closed Bond") || sBuildingBond.equalsIgnoreCase("Yes - Open Bond"))
                    {
                        setText("txtFncAgrmtNmb","328329","set text finance agreement number");
                    }

                    click("btnBldSave","click save button for building");

                    //Vehicle

                    click("lnkVA","click the VA link");
                    setText("regNo","34UTIGP","Enter Registration Number");
                    if(sVehicleFinanced.equalsIgnoreCase("Yes"))
                    {
                        setText("txtFinanceExpryDate","02/03/2023","Enter Vehicle Expiry date");
                    }
                    setText("VinNo","VIN899343949SKDS","Enter Registration Number");
                    select("empSector","text","Administration","select emp sector");
                    click("vaSaveBtn","click save button for vehicle");

                    //Caravan/Trailer
                    click("addCTLink","Click CT link");//Caravan Trailer link
                    setText("txtRegOwner","Insurer","set text registered owner");
                    setText("txtRegNumber","DFD23GP","set text registration number");
                    if(sCaravanTrailerFinanced.equalsIgnoreCase("Yes"))
                    {
                        setText("txtFinanceExpryDate","02/03/2023","Enter Caravan/Trailer Expiry date"); //Regular Driver License Date
                    }
                    click("CTbtnSave","Click save button");

                    //Motorcycle
                    click("addMCLink","Click Motorcycle link");//motorcycle link
                    setText("txtMCRegNumber","GSD434NW","set text registration number");
                    setText("txtMCEngNumber","283KJSADH934","set text engine number");

                    if(sMotorcycleFinanced.equalsIgnoreCase("Yes"))
                    {
                        click("iconDate","click the date icon");
                        Thread.sleep(2000);
                        click("upArrwDate","click the up date arrow");
                        click("dayDate","click the date day");
                    }
                    click("btnMCSave","click save button for motorcycle");

                    click("btnProceed", "click proceed button");//click proceed button
                    fn_Summary();
                    break;

                case "iDirect_REQ_idirect_003_SEC08":
                    //House Content
                    click("lnkHH","click HH link");//click HH link
                    Thread.sleep(1000);
                    select("selctRegistredOwner","text","Insured","select registered owner for HH");//select registered owner for HH
                    click("saveBtn", "click save button");//click save button

                    //Electronic
                    click("lnkElect", "click electronic link");//click proceed button
                    setText("txtSerialNum","328329H34LD","set text serial number number");//serial number for electronic
                    click("saveElectBtn", "click electronic save button");//click electronic save button

//                  Building
                    click("addBldLink","Click Building link");//building link
                    select("drpDwnBldRegNumber","text","Insured","Select Building Registered owner");

                    if(sBuildingBond.equalsIgnoreCase("Yes - Closed Bond") || sBuildingBond.equalsIgnoreCase("Yes - Open Bond"))
                    {
                        setText("txtFncAgrmtNmb","328329","set text finance agreement number");
                    }

                    click("btnBldSave","click save button for building");

                    //Vehicle
                    click("lnkVA","click the VA link");
                    setText("regNo","34UTIGP","Enter Registration Number");
                    setText("VinNo","VIN899343949SKDS","Enter Registration Number");
                    select("empSector","text","Administration","select emp sector");
                    click("vaSaveBtn","click save button for vehicle");

                    //Caravan/Trailer
                    click("addCTLink","Click CT link");//Caravan Trailer link
                    setText("txtRegOwner","Insurer","set text registered owner");
                    setText("txtRegNumber","DFD23GP","set text registration number");
                    if(sCaravanTrailerFinanced.equalsIgnoreCase("Yes"))
                    {
                        setText("txtFinanceExpryDate","02/03/2023","Enter Caravan/Trailer Expiry date"); //Regular Driver License Date
                    }
                    click("CTbtnSave","Click save button");

                    //Motorcycle
                    click("addMCLink","Click Motorcycle link");//motorcycle link
                    setText("txtMCRegNumber","GSD434NW","set text registration number");
                    setText("txtMCEngNumber","283KJSADH934","set text engine number");

                    if(sMotorcycleFinanced.equalsIgnoreCase("Yes"))
                    {
                        click("iconDate","click the date icon");
                        Thread.sleep(2000);
                        click("upArrwDate","click the up date arrow");
                        click("dayDate","click the date day");
                    }
                    click("btnMCSave","click save button for motorcycle");

                    click("btnProceed", "click proceed button");//click proceed button
                    fn_Summary();
                    break;

                case "iDirect_REQ_idirect_003_SEC09":
                    //House Content
                    click("lnkHH","click HH link");//click HH link
                    Thread.sleep(1000);
                    select("selctRegistredOwner","text","Insured","select registered owner for HH");//select registered owner for HH
                    click("saveBtn", "click save button");//click save button

                    //Electronic
                    click("lnkElect", "click electronic link");//click proceed button
                    setText("txtSerialNum","328329H34LD","set text serial number number");//serial number for electronic
                    click("saveElectBtn", "click electronic save button");//click electronic save button

//                  Building
                    click("addBldLink","Click Building link");//building link
                    select("drpDwnBldRegNumber","text","Insured","Select Building Registered owner");

                    if(sBuildingBond.equalsIgnoreCase("Yes - Closed Bond") || sBuildingBond.equalsIgnoreCase("Yes - Open Bond"))
                    {
                        setText("txtFncAgrmtNmb","328329","set text finance agreement number");
                    }

                    click("btnBldSave","click save button for building");

                    //Vehicle
                    /*
                    click("lnkVA","click the VA link");
                    setText("regNo","34UTIGP","Enter Registration Number");
                    setText("VinNo","VIN899343949SKDS","Enter Registration Number");
                    select("empSector","text","Administration","select emp sector");
                    click("vaSaveBtn","click save button for vehicle");

                     */

                    //Caravan/Trailer
                    click("addCTLink","Click CT link");//Caravan Trailer link
                    setText("txtRegOwner","Insurer","set text registered owner");
                    setText("txtRegNumber","DFD23GP","set text registration number");
                    if(sCaravanTrailerFinanced.equalsIgnoreCase("Yes"))
                    {
                        setText("txtFinanceExpryDate","02/03/2023","Enter Caravan/Trailer Expiry date"); //Regular Driver License Date
                    }
                    click("CTbtnSave","Click save button");

                    //Motorcycle
                    click("addMCLink","Click Motorcycle link");//motorcycle link
                    setText("txtMCRegNumber","GSD434NW","set text registration number");
                    setText("txtMCEngNumber","283KJSADH934","set text engine number");

                    if(sMotorcycleFinanced.equalsIgnoreCase("Yes"))
                    {
                        click("iconDate","click the date icon");
                        Thread.sleep(2000);
                        click("upArrwDate","click the up date arrow");
                        click("dayDate","click the date day");
                    }
                    click("btnMCSave","click save button for motorcycle");

                    click("btnProceed", "click proceed button");//click proceed button
                    fn_Summary();
                    break;

                case "iDirect_REQ_idirect_003_SEC10":
                    //House Content
                    click("lnkHH","click HH link");//click HH link
                    Thread.sleep(1000);
                    select("selctRegistredOwner","text","Insured","select registered owner for HH");//select registered owner for HH
                    click("saveBtn", "click save button");//click save button

                    //Electronic
                    click("lnkElect", "click electronic link");//click proceed button
                    setText("txtSerialNum","328329H34LD","set text serial number number");//serial number for electronic
                    click("saveElectBtn", "click electronic save button");//click electronic save button

//                  Building
                    click("addBldLink","Click Building link");//building link
                    select("drpDwnBldRegNumber","text","Insured","Select Building Registered owner");

                    if(sBuildingBond.equalsIgnoreCase("Yes - Closed Bond") || sBuildingBond.equalsIgnoreCase("Yes - Open Bond"))
                    {
                        setText("txtFncAgrmtNmb","328329","set text finance agreement number");
                    }

                    click("btnBldSave","click save button for building");

                    //Vehicle
                    click("lnkVA","click the VA link");
                    setText("regNo","34UTIGP","Enter Registration Number");
                    setText("VinNo","VIN899343949SKDS","Enter Registration Number");
                    select("empSector","text","Administration","select emp sector");
                    click("vaSaveBtn","click save button for vehicle");

                    //Caravan/Trailer
                    click("addCTLink","Click CT link");//Caravan Trailer link
                    setText("txtRegOwner","Insurer","set text registered owner");
                    setText("txtRegNumber","DFD23GP","set text registration number");
                    if(sCaravanTrailerFinanced.equalsIgnoreCase("Yes"))
                    {
                        setText("txtFinanceExpryDate","02/03/2023","Enter Caravan/Trailer Expiry date"); //Regular Driver License Date
                    }
                    click("CTbtnSave","Click save button");

                    //Motorcycle
                    click("addMCLink","Click Motorcycle link");//motorcycle link
                    setText("txtMCRegNumber","GSD434NW","set text registration number");
                    setText("txtMCEngNumber","283KJSADH934","set text engine number");

                    if(sMotorcycleFinanced.equalsIgnoreCase("Yes"))
                    {
                        click("iconDate","click the date icon");
                        Thread.sleep(2000);
                        click("upArrwDate","click the up date arrow");
                        click("dayDate","click the date day");
                    }
                    click("btnMCSave","click save button for motorcycle");

                    click("btnProceed", "click proceed button");//click proceed button
                    fn_Summary();
                    break;

                case "iDirect_REQ_idirect_004_SEC11":

                    //House Content
                    click("lnkHH","click HH link");//click HH link
                    Thread.sleep(1000);
                    select("selctRegistredOwner","text","Insured","select registered owner for HH");//select registered owner for HH
                    click("saveBtn", "click save button");//click save button

                    //Electronic
                    click("lnkElect", "click electronic link");//click proceed button
                    setText("txtSerialNum","328329H34LD","set text serial number number");//serial number for electronic
                    click("saveElectBtn", "click electronic save button");//click electronic save button

//                  Building
                    click("addBldLink","Click Building link");//building link
                    select("drpDwnBldRegNumber","text","Insured","Select Building Registered owner");

                    if(sBuildingBond.equalsIgnoreCase("Yes - Closed Bond") || sBuildingBond.equalsIgnoreCase("Yes - Open Bond"))
                    {
                        setText("txtFncAgrmtNmb","328329","set text finance agreement number");
                    }

                    click("btnBldSave","click save button for building");

                    //Vehicle
                    click("lnkVA","click the VA link");
                    setText("regNo","34UTIGP","Enter Registration Number");
                    setText("VinNo","VIN899343949SKDS","Enter Registration Number");
                    select("empSector","text","Administration","select emp sector");
                    click("vaSaveBtn","click save button for vehicle");

                    //Caravan/Trailer
                    click("addCTLink","Click CT link");//Caravan Trailer link
                    setText("txtRegOwner","Insurer","set text registered owner");
                    setText("txtRegNumber","DFD23GP","set text registration number");
                    if(sCaravanTrailerFinanced.equalsIgnoreCase("Yes"))
                    {
                        setText("txtFinanceExpryDate","02/03/2023","Enter Caravan/Trailer Expiry date"); //Regular Driver License Date
                    }
                    click("CTbtnSave","Click save button");

                    //Motorcycle
                    click("addMCLink","Click Motorcycle link");//motorcycle link
                    setText("txtMCRegNumber","GSD434NW","set text registration number");
                    setText("txtMCEngNumber","283KJSADH934","set text engine number");

                    if(sMotorcycleFinanced.equalsIgnoreCase("Yes"))
                    {
                        click("iconDate","click the date icon");
                        Thread.sleep(2000);
                        click("upArrwDate","click the up date arrow");
                        click("dayDate","click the date day");
                    }
                    click("btnMCSave","click save button for motorcycle");

                    click("btnProceed", "click proceed button");//click proceed button
                    fn_Summary();
                    break;

                case "iDirect_REQ_idirect_004_SEC12":

                    //House Content
                    click("lnkHH","click HH link");//click HH link
                    Thread.sleep(1000);
                    select("selctRegistredOwner","text","Insured","select registered owner for HH");//select registered owner for HH
                    click("saveBtn", "click save button");//click save button

                    //Electronic
                    click("lnkElect", "click electronic link");//click proceed button
                    setText("txtSerialNum","328329H34LD","set text serial number number");//serial number for electronic
                    click("saveElectBtn", "click electronic save button");//click electronic save button

//                  Building
                    click("addBldLink","Click Building link");//building link
                    select("drpDwnBldRegNumber","text","Insured","Select Building Registered owner");

                    if(sBuildingBond.equalsIgnoreCase("Yes - Closed Bond") || sBuildingBond.equalsIgnoreCase("Yes - Open Bond"))
                    {
                        setText("txtFncAgrmtNmb","328329","set text finance agreement number");
                    }

                    click("btnBldSave","click save button for building");

                    //Vehicle
                    /*
                    click("lnkVA","click the VA link");
                    setText("regNo","34UTIGP","Enter Registration Number");
                    setText("VinNo","VIN899343949SKDS","Enter Registration Number");
                    select("empSector","text","Administration","select emp sector");
                    click("vaSaveBtn","click save button for vehicle");

                     */

                    //Caravan/Trailer
                    click("addCTLink","Click CT link");//Caravan Trailer link
                    setText("txtRegOwner","Insurer","set text registered owner");
                    setText("txtRegNumber","DFD23GP","set text registration number");
                    if(sCaravanTrailerFinanced.equalsIgnoreCase("Yes"))
                    {
                        setText("txtFinanceExpryDate","02/03/2023","Enter Caravan/Trailer Expiry date"); //Regular Driver License Date
                    }
                    click("CTbtnSave","Click save button");

                    //Motorcycle
                    click("addMCLink","Click Motorcycle link");//motorcycle link
                    setText("txtMCRegNumber","GSD434NW","set text registration number");
                    setText("txtMCEngNumber","283KJSADH934","set text engine number");

                    if(sMotorcycleFinanced.equalsIgnoreCase("Yes"))
                    {
                        click("iconDate","click the date icon");
                        Thread.sleep(2000);
                        click("upArrwDate","click the up date arrow");
                        click("dayDate","click the date day");
                    }
                    click("btnMCSave","click save button for motorcycle");

                    click("btnProceed", "click proceed button");//click proceed button
                    fn_Summary();
                    break;

                case "iDirect_REQ_idirect_004_SEC13":

                    //House Content
                    click("lnkHH","click HH link");//click HH link
                    Thread.sleep(1000);
                    select("selctRegistredOwner","text","Insured","select registered owner for HH");//select registered owner for HH
                    click("saveBtn", "click save button");//click save button

                    //Electronic
                    click("lnkElect", "click electronic link");//click proceed button
                    setText("txtSerialNum","328329H34LD","set text serial number number");//serial number for electronic
                    click("saveElectBtn", "click electronic save button");//click electronic save button

//                  Building
                    click("addBldLink","Click Building link");//building link
                    select("drpDwnBldRegNumber","text","Insured","Select Building Registered owner");

                    if(sBuildingBond.equalsIgnoreCase("Yes - Closed Bond") || sBuildingBond.equalsIgnoreCase("Yes - Open Bond"))
                    {
                        setText("txtFncAgrmtNmb","328329","set text finance agreement number");
                    }

                    click("btnBldSave","click save button for building");

                    //Vehicle
                    click("lnkVA","click the VA link");
                    setText("regNo","34UTIGP","Enter Registration Number");
                    setText("VinNo","VIN899343949SKDS","Enter Registration Number");
                    select("empSector","text","Administration","select emp sector");
                    click("vaSaveBtn","click save button for vehicle");

                    //Caravan/Trailer
                    click("addCTLink","Click CT link");//Caravan Trailer link
                    setText("txtRegOwner","Insurer","set text registered owner");
                    setText("txtRegNumber","DFD23GP","set text registration number");
                    if(sCaravanTrailerFinanced.equalsIgnoreCase("Yes"))
                    {
                        setText("txtFinanceExpryDate","02/03/2023","Enter Caravan/Trailer Expiry date"); //Regular Driver License Date
                    }
                    click("CTbtnSave","Click save button");

                    //Motorcycle
                    click("addMCLink","Click Motorcycle link");//motorcycle link
                    setText("txtMCRegNumber","GSD434NW","set text registration number");
                    setText("txtMCEngNumber","283KJSADH934","set text engine number");

                    if(sMotorcycleFinanced.equalsIgnoreCase("Yes"))
                    {
                        click("iconDate","click the date icon");
                        Thread.sleep(2000);
                        click("upArrwDate","click the up date arrow");
                        click("dayDate","click the date day");
                    }
                    click("btnMCSave","click save button for motorcycle");

                    click("btnProceed", "click proceed button");//click proceed button
                    fn_Summary();
                    break;

                case "iDirect_REQ_idirect_005_SEC14":
                    //House Content
                    click("lnkHH","click HH link");//click HH link
                    Thread.sleep(1000);
                    select("selctRegistredOwner","text","Insured","select registered owner for HH");//select registered owner for HH
                    click("saveBtn", "click save button");//click save button

                    //Electronic
                    click("lnkElect", "click electronic link");//click proceed button
                    setText("txtSerialNum","328329H34LD","set text serial number number");//serial number for electronic
                    click("saveElectBtn", "click electronic save button");//click electronic save button

//                  Caravan/Trailer
                    click("addCTLink","Click CT link");//Caravan Trailer link
                    setText("txtRegOwner","Insurer","set text registered owner");
                    setText("txtRegNumber","DFD23GP","set text registration number");
                    click("CTbtnSave","Click save button");
                    click("btnProceed", "click proceed button");//click proceed button
                    fn_Summary();
                    break;

                case "iDirect_REQ_idirect_005_SEC15":

                    //House Content
                    click("lnkHH","click HH link");//click HH link
                    Thread.sleep(1000);
                    select("selctRegistredOwner","text","Insured","select registered owner for HH");//select registered owner for HH
                    click("saveBtn", "click save button");//click save button

                    //Electronic
                    click("lnkElect", "click electronic link");//click proceed button
                    setText("txtSerialNum","328329H34LD","set text serial number number");//serial number for electronic
                    click("saveElectBtn", "click electronic save button");//click electronic save button

//                  Caravan/Trailer
                    click("addCTLink","Click CT link");//Caravan Trailer link
                    setText("txtRegOwner","Insurer","set text registered owner");
                    setText("txtRegNumber","DFD23GP","set text registration number");
                    click("CTbtnSave","Click save button");
                    click("btnProceed", "click proceed button");//click proceed button
                    fn_Summary();
                    break;

                case "iDirect_REQ_idirect_005_SEC16":

                    //House Content
                    click("lnkHH","click HH link");//click HH link
                    Thread.sleep(1000);
                    select("selctRegistredOwner","text","Insured","select registered owner for HH");//select registered owner for HH
                    click("saveBtn", "click save button");//click save button

                    //Electronic
                    click("lnkElect", "click electronic link");//click proceed button
                    setText("txtSerialNum","328329H34LD","set text serial number number");//serial number for electronic
                    click("saveElectBtn", "click electronic save button");//click electronic save button

//                  Caravan/Trailer
                    click("addCTLink","Click CT link");//Caravan Trailer link
                    setText("txtRegOwner","Insurer","set text registered owner");
                    setText("txtRegNumber","DFD23GP","set text registration number");
                    click("CTbtnSave","Click save button");
                    click("btnProceed", "click proceed button");//click proceed button
                    fn_Summary();
                    break;

                case "iDirect_REQ_idirect_006_SEC17":

                    //House Content
                    click("lnkHH","click HH link");//click HH link
                    Thread.sleep(1000);
                    select("selctRegistredOwner","text","Insured","select registered owner for HH");//select registered owner for HH
                    click("saveBtn", "click save button");//click save button

                    //Electronic
                    click("lnkElect", "click electronic link");//click proceed button
                    setText("txtSerialNum","328329H34LD","set text serial number number");//serial number for electronic
                    click("saveElectBtn", "click electronic save button");//click electronic save button

//                  Building
                    click("addBldLink","Click Building link");//building link
                    select("drpDwnBldRegNumber","text","Insured","Select Building Registered owner");

                    if(sBuildingBond.equalsIgnoreCase("Yes - Closed Bond") || sBuildingBond.equalsIgnoreCase("Yes - Open Bond"))
                    {
                        setText("txtFncAgrmtNmb","328329","set text finance agreement number");
                    }

                    click("btnBldSave","click save button for building");

                    //Vehicle
                    click("lnkVA","click the VA link");
                    setText("regNo","34UTIGP","Enter Registration Number");
                    setText("VinNo","VIN899343949SKDS","Enter Registration Number");
                    select("empSector","text","Administration","select emp sector");
                    click("vaSaveBtn","click save button for vehicle");

                    //Caravan/Trailer
                    click("addCTLink","Click CT link");//Caravan Trailer link
                    setText("txtRegOwner","Insurer","set text registered owner");
                    setText("txtRegNumber","DFD23GP","set text registration number");

                    if(sCaravanTrailerFinanced.equalsIgnoreCase("Yes"))
                    {
                        setText("txtFinanceExpryDate","02/03/2023","Enter Caravan/Trailer Expiry date"); //Regular Driver License Date
                    }

                    click("CTbtnSave","Click save button");

//                  Motorcycle
                    //Motorcycle
                    click("addMCLink","Click Motorcycle link");//motorcycle link
                    setText("txtMCRegNumber","GSD434NW","set text registration number");
                    setText("txtMCEngNumber","283KJSADH934","set text engine number");

                    if(sMotorcycleFinanced.equalsIgnoreCase("Yes"))
                    {
                        click("iconDate","click the date icon");
                        Thread.sleep(2000);
                        click("upArrwDate","click the up date arrow");
                        click("dayDate","click the date day");
                    }
                    click("btnMCSave","click save button for motorcycle");

                    click("btnProceed", "click proceed button");//click proceed button
                    fn_Summary();
                    break;

                case "iDirect_REQ_idirect_007_SEC21":
                    //House Content
                    click("lnkHH","click HH link");//click HH link
                    Thread.sleep(1000);
                    select("selctRegistredOwner","text","Insured","select registered owner for HH");//select registered owner for HH
                    click("saveBtn", "click save button");//click save button

                    //Electronic
                    click("lnkElect", "click electronic link");//click proceed button
                    setText("txtSerialNum","328329H34LD","set text serial number number");//serial number for electronic
                    click("saveElectBtn", "click electronic save button");//click electronic save button

//                  Building
                    click("addBldLink","Click Building link");//building link
                    select("drpDwnBldRegNumber","text","Insured","Select Building Registered owner");

                    if(sBuildingBond.equalsIgnoreCase("Yes - Closed Bond") || sBuildingBond.equalsIgnoreCase("Yes - Open Bond"))
                    {
                        setText("txtFncAgrmtNmb","328329","set text finance agreement number");
                    }

                    click("btnBldSave","click save button for building");

                    //Vehicle
                    click("lnkVA","click the VA link");
                    setText("regNo","34UTIGP","Enter Registration Number");
                    setText("VinNo","VIN899343949SKDS","Enter Registration Number");
                    select("empSector","text","Administration","select emp sector");
                    click("vaSaveBtn","click save button for vehicle");

                    //Caravan/Trailer
                    click("addCTLink","Click CT link");//Caravan Trailer link
                    setText("txtRegOwner","Insurer","set text registered owner");
                    setText("txtRegNumber","DFD23GP","set text registration number");
                    if(sCaravanTrailerFinanced.equalsIgnoreCase("Yes"))
                    {
                        setText("txtFinanceExpryDate","02/03/2023","Enter Caravan/Trailer Expiry date"); //Regular Driver License Date
                    }
                    click("CTbtnSave","Click save button");

                    //Motorcycle
                    click("addMCLink","Click Motorcycle link");//motorcycle link
                    setText("txtMCRegNumber","GSD434NW","set text registration number");
                    setText("txtMCEngNumber","283KJSADH934","set text engine number");

                    if(sMotorcycleFinanced.equalsIgnoreCase("Yes"))
                    {
                        click("iconDate","click the date icon");
                        Thread.sleep(2000);
                        click("upArrwDate","click the up date arrow");
                        click("dayDate","click the date day");
                    }
                    click("btnMCSave","click save button for motorcycle");

                    click("btnProceed", "click proceed button");//click proceed button
                    fn_Summary();
                    break;

                case "iDirect_REQ_idirect_007_SEC22":
                    //House Content
                    click("lnkHH","click HH link");//click HH link
                    Thread.sleep(1000);
                    select("selctRegistredOwner","text","Insured","select registered owner for HH");//select registered owner for HH
                    click("saveBtn", "click save button");//click save button

                    //Electronic
                    click("lnkElect", "click electronic link");//click proceed button
                    setText("txtSerialNum","328329H34LD","set text serial number number");//serial number for electronic
                    click("saveElectBtn", "click electronic save button");//click electronic save button

//                  Building
                    click("addBldLink","Click Building link");//building link
                    select("drpDwnBldRegNumber","text","Insured","Select Building Registered owner");

                    if(sBuildingBond.equalsIgnoreCase("Yes - Closed Bond") || sBuildingBond.equalsIgnoreCase("Yes - Open Bond"))
                    {
                        setText("txtFncAgrmtNmb","328329","set text finance agreement number");
                    }

                    click("btnBldSave","click save button for building");

                    //Vehicle
                    /*
                    click("lnkVA","click the VA link");
                    setText("regNo","34UTIGP","Enter Registration Number");
                    setText("VinNo","VIN899343949SKDS","Enter Registration Number");
                    select("empSector","text","Administration","select emp sector");
                    click("vaSaveBtn","click save button for vehicle");

                     */

                    //Caravan/Trailer
                    click("addCTLink","Click CT link");//Caravan Trailer link
                    setText("txtRegOwner","Insurer","set text registered owner");
                    setText("txtRegNumber","DFD23GP","set text registration number");
                    if(sCaravanTrailerFinanced.equalsIgnoreCase("Yes"))
                    {
                        setText("txtFinanceExpryDate","02/03/2023","Enter Caravan/Trailer Expiry date"); //Regular Driver License Date
                    }
                    click("CTbtnSave","Click save button");

                    //Motorcycle
                    click("addMCLink","Click Motorcycle link");//motorcycle link
                    setText("txtMCRegNumber","GSD434NW","set text registration number");
                    setText("txtMCEngNumber","283KJSADH934","set text engine number");

                    if(sMotorcycleFinanced.equalsIgnoreCase("Yes"))
                    {
                        click("iconDate","click the date icon");
                        Thread.sleep(2000);
                        click("upArrwDate","click the up date arrow");
                        click("dayDate","click the date day");
                    }
                    click("btnMCSave","click save button for motorcycle");

                    click("btnProceed", "click proceed button");//click proceed button
                    fn_Summary();
                    break;

                case "iDirect_REQ_idirect_008_SEC23":
                    //House Content
                    click("lnkHH","click HH link");//click HH link
                    Thread.sleep(1000);
                    select("selctRegistredOwner","text","Insured","select registered owner for HH");//select registered owner for HH
                    click("saveBtn", "click save button");//click save button

                    //Electronic
                    click("lnkElect", "click electronic link");//click proceed button
                    setText("txtSerialNum","328329H34LD","set text serial number number");//serial number for electronic
                    click("saveElectBtn", "click electronic save button");//click electronic save button

//                  Building
                    click("addBldLink","Click Building link");//building link
                    select("drpDwnBldRegNumber","text","Insured","Select Building Registered owner");

                    if(sBuildingBond.equalsIgnoreCase("Yes - Closed Bond") || sBuildingBond.equalsIgnoreCase("Yes - Open Bond"))
                    {
                        setText("txtFncAgrmtNmb","328329","set text finance agreement number");
                    }

                    click("btnBldSave","click save button for building");

                    //Vehicle
                    click("lnkVA","click the VA link");
                    setText("regNo","34UTIGP","Enter Registration Number");
                    setText("VinNo","VIN899343949SKDS","Enter Registration Number");
                    select("empSector","text","Administration","select emp sector");
                    click("vaSaveBtn","click save button for vehicle");

                    //Caravan/Trailer
                    click("addCTLink","Click CT link");//Caravan Trailer link
                    setText("txtRegOwner","Insurer","set text registered owner");
                    setText("txtRegNumber","DFD23GP","set text registration number");
                    if(sCaravanTrailerFinanced.equalsIgnoreCase("Yes"))
                    {
                        setText("txtFinanceExpryDate","02/03/2023","Enter Caravan/Trailer Expiry date"); //Regular Driver License Date
                    }
                    click("CTbtnSave","Click save button");

                    //Motorcycle
                    click("addMCLink","Click Motorcycle link");//motorcycle link
                    setText("txtMCRegNumber","GSD434NW","set text registration number");
                    setText("txtMCEngNumber","283KJSADH934","set text engine number");

                    if(sMotorcycleFinanced.equalsIgnoreCase("Yes"))
                    {
                        click("iconDate","click the date icon");
                        Thread.sleep(2000);
                        click("upArrwDate","click the up date arrow");
                        click("dayDate","click the date day");
                    }
                    click("btnMCSave","click save button for motorcycle");

                    click("btnProceed", "click proceed button");//click proceed button
                    fn_Summary();
                    break;

                case "iDirect_REQ_idirect_008_SEC24":
                    //House Content
                    click("lnkHH","click HH link");//click HH link
                    Thread.sleep(1000);
                    select("selctRegistredOwner","text","Insured","select registered owner for HH");//select registered owner for HH
                    click("saveBtn", "click save button");//click save button

                    //Electronic
                    click("lnkElect", "click electronic link");//click proceed button
                    setText("txtSerialNum","328329H34LD","set text serial number number");//serial number for electronic
                    click("saveElectBtn", "click electronic save button");//click electronic save button

//                  Building
                    click("addBldLink","Click Building link");//building link
                    select("drpDwnBldRegNumber","text","Insured","Select Building Registered owner");

                    if(sBuildingBond.equalsIgnoreCase("Yes - Closed Bond") || sBuildingBond.equalsIgnoreCase("Yes - Open Bond"))
                    {
                        setText("txtFncAgrmtNmb","328329","set text finance agreement number");
                    }

                    click("btnBldSave","click save button for building");

                    //Vehicle
                    click("lnkVA","click the VA link");
                    setText("regNo","34UTIGP","Enter Registration Number");
                    setText("VinNo","VIN899343949SKDS","Enter Registration Number");
                    select("empSector","text","Administration","select emp sector");
                    click("vaSaveBtn","click save button for vehicle");

                    //Caravan/Trailer
                    click("addCTLink","Click CT link");//Caravan Trailer link
                    setText("txtRegOwner","Insurer","set text registered owner");
                    setText("txtRegNumber","DFD23GP","set text registration number");
                    if(sCaravanTrailerFinanced.equalsIgnoreCase("Yes"))
                    {
                        setText("txtFinanceExpryDate","02/03/2023","Enter Caravan/Trailer Expiry date"); //Regular Driver License Date
                    }
                    click("CTbtnSave","Click save button");

                    //Motorcycle
                    click("addMCLink","Click Motorcycle link");//motorcycle link
                    setText("txtMCRegNumber","GSD434NW","set text registration number");
                    setText("txtMCEngNumber","283KJSADH934","set text engine number");

                    if(sMotorcycleFinanced.equalsIgnoreCase("Yes"))
                    {
                        click("iconDate","click the date icon");
                        Thread.sleep(2000);
                        click("upArrwDate","click the up date arrow");
                        click("dayDate","click the date day");
                    }
                    click("btnMCSave","click save button for motorcycle");

                    click("btnProceed", "click proceed button");//click proceed button
                    fn_Summary();
                    break;

                case "iDirect_REQ_idirect_008_SEC25":
                    //House Content
                    click("lnkHH","click HH link");//click HH link
                    Thread.sleep(1000);
                    select("selctRegistredOwner","text","Insured","select registered owner for HH");//select registered owner for HH
                    click("saveBtn", "click save button");//click save button

                    //Electronic
                    click("lnkElect", "click electronic link");//click proceed button
                    setText("txtSerialNum","328329H34LD","set text serial number number");//serial number for electronic
                    click("saveElectBtn", "click electronic save button");//click electronic save button

//                  Building
                    click("addBldLink","Click Building link");//building link
                    select("drpDwnBldRegNumber","text","Insured","Select Building Registered owner");

                    if(sBuildingBond.equalsIgnoreCase("Yes - Closed Bond") || sBuildingBond.equalsIgnoreCase("Yes - Open Bond"))
                    {
                        setText("txtFncAgrmtNmb","328329","set text finance agreement number");
                    }

                    click("btnBldSave","click save button for building");

                    //Vehicle
                    click("lnkVA","click the VA link");
                    setText("regNo","34UTIGP","Enter Registration Number");
                    setText("VinNo","VIN899343949SKDS","Enter Registration Number");
                    select("empSector","text","Administration","select emp sector");
                    click("vaSaveBtn","click save button for vehicle");

                    //Caravan/Trailer
                    click("addCTLink","Click CT link");//Caravan Trailer link
                    setText("txtRegOwner","Insurer","set text registered owner");
                    setText("txtRegNumber","DFD23GP","set text registration number");
                    if(sCaravanTrailerFinanced.equalsIgnoreCase("Yes"))
                    {
                        setText("txtFinanceExpryDate","02/03/2023","Enter Caravan/Trailer Expiry date"); //Regular Driver License Date
                    }
                    click("CTbtnSave","Click save button");

                    //Motorcycle
                    click("addMCLink","Click Motorcycle link");//motorcycle link
                    setText("txtMCRegNumber","GSD434NW","set text registration number");
                    setText("txtMCEngNumber","283KJSADH934","set text engine number");

                    if(sMotorcycleFinanced.equalsIgnoreCase("Yes"))
                    {
                        click("iconDate","click the date icon");
                        Thread.sleep(2000);
                        click("upArrwDate","click the up date arrow");
                        click("dayDate","click the date day");
                    }
                    click("btnMCSave","click save button for motorcycle");

                    click("btnProceed", "click proceed button");//click proceed button
                    fn_Summary();
                    break;
                case "PL_REQ_Premium_023_SEC56":

                    //House Content
                    click("lnkHH","click HH link");//click HH link
                    Thread.sleep(1000);
                    select("selctRegistredOwner","text","Insured","select registered owner for HH");//select registered owner for HH
                    click("saveBtn", "click save button");//click save button
                    click("btnProceed", "click proceed button");//click proceed button
                    fn_Summary();
                    break;

                case "iDirect_REQ_idirect_010_SEC29":

//                  Vehicle
                    click("lnkVA","click the VA link");//vehicle link
                    setText("regNo","34UTIGP","Enter Registration Number");
                    setText("VinNo","VIN899343949SKDS","Enter Registration Number");
                    select("empSector","text","Administration","select emp sector");
                    click("vaSaveBtn","click save button for vehicle");
                    Thread.sleep(2000);

//                  Caravan/Trailer
                    click("addCTLink","Click CT link");//Caravan Trailer link
                    setText("txtRegOwner","Insurer","set text registered owner");
                    setText("txtRegNumber","DFD23GP","set text registration number");
                    click("CTbtnSave","Click save button");
                    click("btnProceed", "click proceed button");//click proceed button
                    fn_Summary();

                    break;

                case "iDirect_REQ_idirect_007_SEC20":

                    //House Content
                    click("lnkHH","click HH link");//click HH link
                    Thread.sleep(1000);
                    select("selctRegistredOwner","text","Insured","select registered owner for HH");//select registered owner for HH
                    click("saveBtn", "click save button");//click save button

                    //Electronic
                    click("lnkElect", "click electronic link");//click proceed button
                    setText("txtSerialNum","328329H34LD","set text serial number number");//serial number for electronic
                    click("saveElectBtn", "click electronic save button");//click electronic save button

                    click("btnProceed", "click proceed button");//click proceed button

                    fn_Summary();
                    break;
            }


            underwriting = true;
        }catch (Exception e) {
            throw e;
        }

        return underwriting;
    }

    public boolean fn_Summary() throws Exception
    {
        boolean summaryScreen = false;
        AIC_Common_POM.SetPage_Common();

        try {
                String txtSumm = wdriver.findElement(By.xpath("//h1[@class='xue'][contains(.,'Summary')]")).getText();
                //String txtPolicynumber = wdriver.findElement(By.xpath("//span[contains(@id,'text::content')][@class='x25'][contains(.,'6528377828')]")).getText();
                validateString(txtSumm,"Summary","Validate the summary label");//Validate the summary screen
                Thread.sleep(2000);
                click("submtundrwrterBtn","click submit to underwriter button");//click submit to underwriter button
                Thread.sleep(50000);
                String sSuccessMessage = wdriver.findElement(By.xpath("//div[@class='x14s'][contains(.,'Generate Policy Schedule document successful')]")).getText();
                Thread.sleep(5000);
                validateString(sSuccessMessage,"Generate Policy Schedule document successful","verify successful message is displayed");
                Thread.sleep(5000);
                click("Okbutton","click Ok button");//click Ok button
                //isElementVisible(txtPolicynumber,true,"Policy number display");

            summaryScreen = true;
            endTestReport();

        }catch (Exception e) {
            throw e;
        }

        return summaryScreen;
    }

    public boolean fn_Status() throws Exception
    {
        boolean statusScreen = false;

        try {

            statusScreen = true;
        }catch (Exception e) {
            throw e;
        }

        return statusScreen;
    }

    public boolean fn_Documents() throws Exception
    {
        boolean documentsScreen = false;

        try {

            documentsScreen = true;
        }catch (Exception e) {
            throw e;
        }

        return documentsScreen;
    }

    public boolean fn_Referrals() throws Exception
    {
        boolean referralsScreen = false;

        try {

            referralsScreen = true;
        }catch (Exception e) {
            throw e;
        }

        return referralsScreen;
    }

    public boolean fn_Note() throws Exception
    {
        boolean notesScreen = false;

        try {

            notesScreen = true;
        }catch (Exception e) {
            throw e;
        }

        return notesScreen;
    }

    public boolean fn_needsSelectionAndFillUp(String testScenario) throws Exception {

        boolean productSelection = true;
        AIC_Common_POM.SetPage_Common();

        try
        {
            switch (testScenario)
            {
                case"PL_REQ_APLUS_001":
                case"iDirect_REQ_idirect_001_SEC01":
                    //Click Add button
                    click("addButton","Add button must be clicked");
                    Thread.sleep(2000);

                    //Select product(s)
                    click("chBoxHH", "Select HH checkbox");//HouseHold Content
                    click("chBoxAR", "Select AR checkbox");//All Risk
                    //click("chBoxBld", "Select HO checkbox");//Building
                    click("chBoxMO", "Select MO checkbox");//Vehicle
                    click("chBoxMC", "Select MC checkbox");//Motorcycle
                    click("chBoxCT", "Select CT checkbox");//Caravan/Trailer
                    click("chBoxWC", "Select WC checkbox");//Watercraft
                    click("chBoxEE", "Select EE checkbox");//Electronic

                    click("addChkButton", "Click add checked button");//Click add checked button

                    //Add for All Risk
                    click("addARButton", "click AR button");
                    Thread.sleep(3000);
                    click("chkUAR", "check the UAR product");
                    click("dneButton", "click done button");
                    Thread.sleep(2000);

                    //HouseHold Content
                    click("addHHLink", "Click HH link");//HouseHold Content link
                    Thread.sleep(2000);
                    new AIC_Home_Contents(wdriver, test).fn_HomeContentsDetails();

                    //link for All Risk
                    //click("lnkUAR", "click the UAR link");
                    wdriver.findElement(By.xpath("XPATH|//span[@class='x16v'][contains(.,'Unspecified All Risk')]")).click();
                    Thread.sleep(2000);
                    new AIC_All_Risk(wdriver, test).fn_AllRiskDetails();//Call All Risk Class and function//Vehicle

                    //Watercraft
                    //click("addWCLink", "Click Watercraft link");
                    wdriver.findElement(By.xpath("//a[contains(.,'Watercraft')]")).click();//Watercraft link
                    new AIC_Watercraft(wdriver, test).fn_WatercraftDetails();
                    Thread.sleep(2000);

                    //click("addVALink", "Click VA link");//Vehicle link
                    wdriver.findElement(By.xpath("//a[contains(.,'Vehicle')]")).click();
                    Thread.sleep(2000);
                    new AIC_Vehicle(wdriver, test).fn_VehicleDetails();
                    Thread.sleep(2000);

                    //Motorcycle
                    //click("addMCLink", "Click MC link");//Motorcycle link
                    wdriver.findElement(By.xpath("//a[contains(.,'Motorcycle')]")).click();
                    new AIC_Motorcycle(wdriver, test).fn_MotorcycleDetails();
                    Thread.sleep(2000);

                    //Caravan/Trailer
//                  click("addCTlink","click Caravan/Trailer link");//Click Caravan/Trailer link
                    wdriver.findElement(By.xpath("//a[contains(.,'Caravan')]")).click();
                    Thread.sleep(2000);
                    new AIC_Caravan_Trailer(wdriver, test).fn_CaravanTrailer();

                    //Building
                    //click("addBuildLink", "Click Building link");
                    /*
                    wdriver.findElement(By.xpath("//a[contains(.,'Building')]")).click();//Building link
                    new AIC_Building(wdriver, test).fn_BuildingDetails();
                    Thread.sleep(2000);

                     */

                    //Electronic
                    //click("addEELink", "Click Electronic link");
                    wdriver.findElement(By.xpath("//a[contains(.,'Electronic')]")).click();//Electronic link
                    new AIC_Electronic(wdriver, test).fn_ElectronicDetails();
                    Thread.sleep(2000);

                    //Checked buttons and Quote button
                    wdriver.findElement(By.xpath("(//a[@href='#'][contains(.,'Check All')])[2]")).click();//Check All button
                    Thread.sleep(2000);
//                  click("quoteCheckedButton","click quote checked button");//Click quote checked button
                    wdriver.findElement(By.xpath("//a[@href='#'][contains(.,'Quote Checked')]")).click();//Quote checked
                    Thread.sleep(2000);

                    fn_Quoting();
                    Thread.sleep(5000);
                    break;
                case "PL_REQ__Premium_002":
                case "iDirect_REQ_idirect_001_SEC02":

                    //Click Add button
                    click("addButton","Add button must be clicked");
                    Thread.sleep(2000);

                    //Select product(s)
                    click("chBoxHH", "Select HH checkbox");//HouseHold Content
                    click("chBoxAR", "Select AR checkbox");//All Risk
                    //click("chBoxBld", "Select HO checkbox");//Building
                    click("chBoxMO", "Select MO checkbox");//Vehicle
                    click("chBoxMC", "Select MC checkbox");//Motorcycle
                    click("chBoxCT", "Select CT checkbox");//Caravan/Trailer
                    click("chBoxWC", "Select WC checkbox");//Watercraft
                    click("chBoxEE", "Select EE checkbox");//Electronic
                    Thread.sleep(3000);
                    click("addChkButton", "Click add checked button");//Click add checked button

                    //Add for All Risk
                    click("addARButton", "click AR button");
                    Thread.sleep(3000);
                    click("chkUAR", "check the UAR product");
                    click("dneButton", "click done button");
                    Thread.sleep(2000);

                    //HouseHold Content
                    click("addHHLink", "Click HH link");//HouseHold Content link
                    Thread.sleep(2000);
                    new AIC_Home_Contents(wdriver, test).fn_HomeContentsDetails();

                    //link for All Risk
                    //click("lnkUAR", "click the UAR link");
                    wdriver.findElement(By.xpath("XPATH|//span[@class='x16v'][contains(.,'Unspecified All Risk')]")).click();
                    Thread.sleep(2000);
                    new AIC_All_Risk(wdriver, test).fn_AllRiskDetails();//Call All Risk Class and function

                    //Caravan/Trailer
//                  click("addCTlink","click Caravan/Trailer link");//Click Caravan/Trailer link
                    wdriver.findElement(By.xpath("//a[contains(.,'Caravan')]")).click();
                    Thread.sleep(2000);
                    new AIC_Caravan_Trailer(wdriver, test).fn_CaravanTrailer();

                    //Vehicle
                    //click("addVALink", "Click VA link");//Vehicle link
                    wdriver.findElement(By.xpath("//a[contains(.,'Vehicle')]")).click();
                    Thread.sleep(2000);
                    new AIC_Vehicle(wdriver, test).fn_VehicleDetails();
                    Thread.sleep(2000);

                    //Motorcycle
                    //click("addMCLink", "Click MC link");//Motorcycle link
                    wdriver.findElement(By.xpath("//a[contains(.,'Motorcycle')]")).click();
                    new AIC_Motorcycle(wdriver, test).fn_MotorcycleDetails();
                    Thread.sleep(2000);

                    //Watercraft
                    //click("addWCLink", "Click Watercraft link");
                    wdriver.findElement(By.xpath("//a[contains(.,'Watercraft')]")).click();//Watercraft link
                    new AIC_Watercraft(wdriver, test).fn_WatercraftDetails();
                    Thread.sleep(2000);

                    //Building

                    //click("addBuildLink", "Click Building link");
                    /*
                    wdriver.findElement(By.xpath("//a[contains(.,'Building')]")).click();//Building link
                    new AIC_Building(wdriver, test).fn_BuildingDetails();
                    Thread.sleep(2000);

                     */

                    //Electronic
                    //click("addEELink", "Click Electronic link");
                    wdriver.findElement(By.xpath("//a[contains(.,'Electronic')]")).click();//Electronic link
                    new AIC_Electronic(wdriver, test).fn_ElectronicDetails();
                    Thread.sleep(2000);

                    //Checked buttons and Quote button
                    wdriver.findElement(By.xpath("(//a[@href='#'][contains(.,'Check All')])[2]")).click();//Check All button
                    Thread.sleep(2000);
//                  click("quoteCheckedButton","click quote checked button");//Click quote checked button
                    wdriver.findElement(By.xpath("//a[@href='#'][contains(.,'Quote Checked')]")).click();//Quote checked
                    Thread.sleep(2000);

                    fn_Quoting();
                    break;

                case "PL_REQ_Private_003":
                case "iDirect_REQ_idirect_001_SEC03":
                    //Click Add button
                    click("addButton","Add button must be clicked");
                    Thread.sleep(2000);

                    //Select product(s)
                    click("chBoxHH", "Select HH checkbox");//HouseHold Content
                    click("chBoxAR", "Select AR checkbox");//All Risk
                    click("chBoxBld", "Select HO checkbox");//Building
                    click("chBoxMO", "Select MO checkbox");//Vehicle
                    click("chBoxMC", "Select MC checkbox");//Motorcycle
                    click("chBoxCT", "Select CT checkbox");//Caravan/Trailer
                    click("chBoxWC", "Select WC checkbox");//Watercraft
                    click("chBoxEE", "Select EE checkbox");//Electronic

                    click("addChkButton", "Click add checked button");//Click add checked button

                    //Add for All Risk
                    click("addARButton", "click AR button");
                    Thread.sleep(3000);
                    click("chkUAR", "check the UAR product");
                    click("dneButton", "click done button");
                    Thread.sleep(2000);

                    //HouseHold Content
                    click("addHHLink", "Click HH link");//HouseHold Content link
                    Thread.sleep(2000);
                    new AIC_Home_Contents(wdriver, test).fn_HomeContentsDetails();

                    //link for All Risk
                    //click("lnkUAR", "click the UAR link");
                    wdriver.findElement(By.xpath("XPATH|//span[@class='x16v'][contains(.,'Unspecified All Risk')]")).click();
                    Thread.sleep(2000);
                    new AIC_All_Risk(wdriver, test).fn_AllRiskDetails();//Call All Risk Class and function

                    //Caravan/Trailer
//                  click("addCTlink","click Caravan/Trailer link");//Click Caravan/Trailer link
                    wdriver.findElement(By.xpath("//a[contains(.,'Caravan')]")).click();
                    Thread.sleep(2000);
                    new AIC_Caravan_Trailer(wdriver, test).fn_CaravanTrailer();

                    //Vehicle
                    //click("addVALink", "Click VA link");//Vehicle link
                    wdriver.findElement(By.xpath("//a[contains(.,'Vehicle')]")).click();
                    Thread.sleep(2000);
                    new AIC_Vehicle(wdriver, test).fn_VehicleDetails();
                    Thread.sleep(2000);

                    //Motorcycle
                    //click("addMCLink", "Click MC link");//Motorcycle link
                    wdriver.findElement(By.xpath("//a[contains(.,'Motorcycle')]")).click();
                    new AIC_Motorcycle(wdriver, test).fn_MotorcycleDetails();
                    Thread.sleep(2000);

                    //Watercraft
                    //click("addWCLink", "Click Watercraft link");
                    wdriver.findElement(By.xpath("//a[contains(.,'Watercraft')]")).click();//Watercraft link
                    new AIC_Watercraft(wdriver, test).fn_WatercraftDetails();
                    Thread.sleep(2000);

                    //Building
                    //click("addBuildLink", "Click Building link");
                    wdriver.findElement(By.xpath("//a[contains(.,'Building')]")).click();//Building link
                    new AIC_Building(wdriver, test).fn_BuildingDetails();
                    Thread.sleep(2000);

                    //Electronic
                    //click("addEELink", "Click Electronic link");
                    wdriver.findElement(By.xpath("//a[contains(.,'Electronic')]")).click();//Electronic link
                    new AIC_Electronic(wdriver, test).fn_ElectronicDetails();
                    Thread.sleep(2000);

                    //Checked buttons and Quote button
                    wdriver.findElement(By.xpath("(//a[@href='#'][contains(.,'Check All')])[2]")).click();//Check All button
                    Thread.sleep(2000);
//                  click("quoteCheckedButton","click quote checked button");//Click quote checked button
                    wdriver.findElement(By.xpath("//a[@href='#'][contains(.,'Quote Checked')]")).click();//Quote checked
                    Thread.sleep(2000);

                    fn_Quoting();
                    break;

                case "PL_REQ_APLUS_004":
                case "iDirect_REQ_idirect_001_SEC04":
                    //Click Add button
                    click("addButton","Add button must be clicked");
                    Thread.sleep(2000);

                    //Select product(s)
                    click("chBoxHH", "Select HH checkbox");//HouseHold Content
                    click("chBoxAR", "Select AR checkbox");//All Risk
                    click("chBoxBld", "Select HO checkbox");//Building
                    click("chBoxMO", "Select MO checkbox");//Vehicle
                    click("chBoxMC", "Select MC checkbox");//Motorcycle
                    click("chBoxCT", "Select CT checkbox");//Caravan/Trailer
                    click("chBoxWC", "Select WC checkbox");//Watercraft
                    click("chBoxEE", "Select EE checkbox");//Electronic

                    click("addChkButton", "Click add checked button");//Click add checked button

                    //Add for All Risk
                    click("addARButton", "click AR button");
                    Thread.sleep(3000);
                    click("chkUAR", "check the UAR product");
                    click("dneButton", "click done button");
                    Thread.sleep(2000);

                    //HouseHold Content
                    click("addHHLink", "Click HH link");//HouseHold Content link
                    Thread.sleep(2000);
                    new AIC_Home_Contents(wdriver, test).fn_HomeContentsDetails();

                    //link for All Risk
                    wdriver.findElement(By.xpath("XPATH|//span[@class='x16v'][contains(.,'Unspecified All Risk')]")).click();
                    //click("lnkUAR", "click the UAR link");

                    wdriver.findElement(By.xpath("XPATH|//span[@class='x16v'][contains(.,'Unspecified All Risk')]")).click();
                    Thread.sleep(2000);
                    new AIC_All_Risk(wdriver, test).fn_AllRiskDetails();//Call All Risk Class and function

                    //Caravan/Trailer
//                  click("addCTlink","click Caravan/Trailer link");//Click Caravan/Trailer link
                    wdriver.findElement(By.xpath("//a[contains(.,'Caravan')]")).click();
                    Thread.sleep(2000);
                    new AIC_Caravan_Trailer(wdriver, test).fn_CaravanTrailer();

                    //Vehicle
                    //click("addVALink", "Click VA link");//Vehicle link
                    wdriver.findElement(By.xpath("//a[contains(.,'Vehicle')]")).click();
                    Thread.sleep(2000);
                    new AIC_Vehicle(wdriver, test).fn_VehicleDetails();

                    Thread.sleep(2000);

                    //Motorcycle
                    //click("addMCLink", "Click MC link");//Motorcycle link
                    wdriver.findElement(By.xpath("//a[contains(.,'Motorcycle')]")).click();
                    new AIC_Motorcycle(wdriver, test).fn_MotorcycleDetails();
                    Thread.sleep(2000);

                    //Watercraft
                    //click("addWCLink", "Click Watercraft link");
                    wdriver.findElement(By.xpath("//a[contains(.,'Watercraft')]")).click();//Watercraft link
                    new AIC_Watercraft(wdriver, test).fn_WatercraftDetails();
                    Thread.sleep(2000);

                    //Building
                    //click("addBuildLink", "Click Building link");
                    wdriver.findElement(By.xpath("//a[contains(.,'Building')]")).click();//Building link
                    new AIC_Building(wdriver, test).fn_BuildingDetails();
                    Thread.sleep(2000);

                    //Electronic
                    //click("addEELink", "Click Electronic link");

                    wdriver.findElement(By.xpath("//a[contains(.,'Electronic')]")).click();//Electronic link
                    new AIC_Electronic(wdriver, test).fn_ElectronicDetails();
                    Thread.sleep(2000);

                    //Checked buttons and Quote button
                    wdriver.findElement(By.xpath("(//a[@href='#'][contains(.,'Check All')])[2]")).click();//Check All button
                    Thread.sleep(2000);
//                  click("quoteCheckedButton","click quote checked button");//Click quote checked button
                    wdriver.findElement(By.xpath("//a[@href='#'][contains(.,'Quote Checked')]")).click();//Quote checked
                    Thread.sleep(2000);

                    fn_Quoting();
                    break;

                case "PL_REQ_Premium_005":
                case "iDirect_REQ_idirect_002_SEC05":
                    //Click Add button
                    click("addButton","Add button must be clicked");
                    Thread.sleep(2000);

                    //Select product(s)
                    click("chBoxHH", "Select HH checkbox");//HouseHold Content
                    click("chBoxAR", "Select AR checkbox");//All Risk
                    click("chBoxBld", "Select HO checkbox");//Building
                    click("chBoxMO", "Select MO checkbox");//Vehicle
                    click("chBoxMC", "Select MC checkbox");//Motorcycle
                    click("chBoxCT", "Select CT checkbox");//Caravan/Trailer
                    click("chBoxWC", "Select WC checkbox");//Watercraft
                    click("chBoxEE", "Select EE checkbox");//Electronic

                    click("addChkButton", "Click add checked button");//Click add checked button

                    //Add for All Risk
                    click("addARButton", "click AR button");
                    Thread.sleep(3000);
                    click("chkUAR", "check the UAR product");
                    click("dneButton", "click done button");
                    Thread.sleep(2000);

                    //HouseHold Content
                    click("addHHLink", "Click HH link");//HouseHold Content link
                    Thread.sleep(2000);
                    new AIC_Home_Contents(wdriver, test).fn_HomeContentsDetails();

                    //Vehicle
                    //click("addVALink", "Click VA link");//Vehicle link
                    wdriver.findElement(By.xpath("//a[contains(.,'Vehicle')]")).click();
                    Thread.sleep(2000);
                    new AIC_Vehicle(wdriver, test).fn_VehicleDetails();
                    Thread.sleep(2000);

                    //Building
                    //click("addBuildLink", "Click Building link");
                    wdriver.findElement(By.xpath("//a[contains(.,'Building')]")).click();//Building link
                    new AIC_Building(wdriver, test).fn_BuildingDetails();
                    Thread.sleep(2000);

                    //link for All Risk
                    //click("lnkUAR", "click the UAR link");
                    wdriver.findElement(By.xpath("XPATH|//span[@class='x16v'][contains(.,'Unspecified All Risk')]")).click();
                    Thread.sleep(2000);
                    new AIC_All_Risk(wdriver, test).fn_AllRiskDetails();//Call All Risk Class and function

                    //Caravan/Trailer
//                  click("addCTlink","click Caravan/Trailer link");//Click Caravan/Trailer link
                    wdriver.findElement(By.xpath("//a[contains(.,'Caravan')]")).click();
                    Thread.sleep(2000);
                    new AIC_Caravan_Trailer(wdriver, test).fn_CaravanTrailer();

                    //Motorcycle
                    //click("addMCLink", "Click MC link");//Motorcycle link
                    wdriver.findElement(By.xpath("//a[contains(.,'Motorcycle')]")).click();
                    new AIC_Motorcycle(wdriver, test).fn_MotorcycleDetails();
                    Thread.sleep(2000);

                    //Watercraft
                    //click("addWCLink", "Click Watercraft link");
                    wdriver.findElement(By.xpath("//a[contains(.,'Watercraft')]")).click();//Watercraft link
                    new AIC_Watercraft(wdriver, test).fn_WatercraftDetails();
                    Thread.sleep(2000);

                    //Electronic
                    //click("addEELink", "Click Electronic link");
                    wdriver.findElement(By.xpath("//a[contains(.,'Electronic')]")).click();//Electronic link
                    new AIC_Electronic(wdriver, test).fn_ElectronicDetails();
                    Thread.sleep(2000);

                    //Checked buttons and Quote button
                    wdriver.findElement(By.xpath("(//a[@href='#'][contains(.,'Check All')])[2]")).click();//Check All button
                    Thread.sleep(2000);
//                  click("quoteCheckedButton","click quote checked button");//Click quote checked button
                    wdriver.findElement(By.xpath("//a[@href='#'][contains(.,'Quote Checked')]")).click();//Quote checked
                    Thread.sleep(2000);

                    fn_Quoting();
                    break;

                case "PL_REQ_Private_006":
                case "iDirect_REQ_idirect_003_SEC08":

                    //Click Add button
                    click("addButton","Add button must be clicked");
                    Thread.sleep(2000);

                    //Select product(s)
                    click("chBoxHH", "Select HH checkbox");//HouseHold Content
                    click("chBoxAR", "Select AR checkbox");//All Risk
                    click("chBoxBld", "Select HO checkbox");//Building
                    click("chBoxMO", "Select MO checkbox");//Vehicle
                    click("chBoxMC", "Select MC checkbox");//Motorcycle
                    click("chBoxCT", "Select CT checkbox");//Caravan/Trailer
                    click("chBoxWC", "Select WC checkbox");//Watercraft
                    click("chBoxEE", "Select EE checkbox");//Electronic

                    click("addChkButton", "Click add checked button");//Click add checked button

                    //Add for All Risk
                    click("addARButton", "click AR button");
                    Thread.sleep(3000);
                    click("chkUAR", "check the UAR product");
                    click("dneButton", "click done button");
                    Thread.sleep(2000);

                    //HouseHold Content
                    click("addHHLink", "Click HH link");//HouseHold Content link
                    Thread.sleep(2000);
                    new AIC_Home_Contents(wdriver, test).fn_HomeContentsDetails();

                    //link for All Risk
                    //click("lnkUAR", "click the UAR link");
                    wdriver.findElement(By.xpath("XPATH|//span[@class='x16v'][contains(.,'Unspecified All Risk')]")).click();
                    Thread.sleep(2000);
                    new AIC_All_Risk(wdriver, test).fn_AllRiskDetails();//Call All Risk Class and function

                    //Caravan/Trailer
//                  click("addCTlink","click Caravan/Trailer link");//Click Caravan/Trailer link
                    wdriver.findElement(By.xpath("//a[contains(.,'Caravan')]")).click();
                    Thread.sleep(2000);
                    new AIC_Caravan_Trailer(wdriver, test).fn_CaravanTrailer();

                    //Vehicle

                    //click("addVALink", "Click VA link");//Vehicle link
                    wdriver.findElement(By.xpath("//a[contains(.,'Vehicle')]")).click();
                    Thread.sleep(2000);
                    new AIC_Vehicle(wdriver, test).fn_VehicleDetails();

                    Thread.sleep(2000);

                    //Motorcycle
                    //click("addMCLink", "Click MC link");//Motorcycle link
                    wdriver.findElement(By.xpath("//a[contains(.,'Motorcycle')]")).click();
                    new AIC_Motorcycle(wdriver, test).fn_MotorcycleDetails();
                    Thread.sleep(2000);

                    //Watercraft
                    //click("addWCLink", "Click Watercraft link");
                    wdriver.findElement(By.xpath("//a[contains(.,'Watercraft')]")).click();//Watercraft link
                    new AIC_Watercraft(wdriver, test).fn_WatercraftDetails();
                    Thread.sleep(2000);

                    //Building
                    //click("addBuildLink", "Click Building link");
                    wdriver.findElement(By.xpath("//a[contains(.,'Building')]")).click();//Building link
                    new AIC_Building(wdriver, test).fn_BuildingDetails();
                    Thread.sleep(2000);

                    //Electronic
                    //click("addEELink", "Click Electronic link");
                    wdriver.findElement(By.xpath("//a[contains(.,'Electronic')]")).click();//Electronic link
                    new AIC_Electronic(wdriver, test).fn_ElectronicDetails();
                    Thread.sleep(2000);

                    //Checked buttons and Quote button
                    wdriver.findElement(By.xpath("(//a[@href='#'][contains(.,'Check All')])[2]")).click();//Check All button
                    Thread.sleep(2000);
//                  click("quoteCheckedButton","click quote checked button");//Click quote checked button
                    wdriver.findElement(By.xpath("//a[@href='#'][contains(.,'Quote Checked')]")).click();//Quote checked
                    Thread.sleep(2000);

                    fn_Quoting();
                    break;

                case "PL_REQ_APLUS_009":
                case "iDirect_REQ_idirect_003_SEC09":
                    //Click Add button
                    click("addButton","Add button must be clicked");
                    Thread.sleep(2000);

                    //Select product(s)
                    click("chBoxHH", "Select HH checkbox");//HouseHold Content
                    click("chBoxAR", "Select AR checkbox");//All Risk
                    click("chBoxBld", "Select HO checkbox");//Building
                    //click("chBoxMO", "Select MO checkbox");//Vehicle
                    click("chBoxMC", "Select MC checkbox");//Motorcycle
                    click("chBoxCT", "Select CT checkbox");//Caravan/Trailer
                    click("chBoxWC", "Select WC checkbox");//Watercraft
                    click("chBoxEE", "Select EE checkbox");//Electronic

                    click("addChkButton", "Click add checked button");//Click add checked button

                    //Add for All Risk
                    click("addARButton", "click AR button");
                    Thread.sleep(3000);
                    click("chkUAR", "check the UAR product");
                    click("dneButton", "click done button");
                    Thread.sleep(2000);

                    //HouseHold Content
                    click("addHHLink", "Click HH link");//HouseHold Content link
                    Thread.sleep(2000);
                    new AIC_Home_Contents(wdriver, test).fn_HomeContentsDetails();

                    //link for All Risk
                    //click("lnkUAR", "click the UAR link");
                    wdriver.findElement(By.xpath("XPATH|//span[@class='x16v'][contains(.,'Unspecified All Risk')]")).click();
                    Thread.sleep(2000);
                    new AIC_All_Risk(wdriver, test).fn_AllRiskDetails();//Call All Risk Class and function

                    //Caravan/Trailer
//                  click("addCTlink","click Caravan/Trailer link");//Click Caravan/Trailer link
                    wdriver.findElement(By.xpath("//a[contains(.,'Caravan')]")).click();
                    Thread.sleep(2000);
                    new AIC_Caravan_Trailer(wdriver, test).fn_CaravanTrailer();

                    //Vehicle
                    /*
                    //click("addVALink", "Click VA link");//Vehicle link
                    wdriver.findElement(By.xpath("//a[contains(.,'Vehicle')]")).click();
                    Thread.sleep(2000);
                    new AIC_Vehicle(wdriver, test).fn_VehicleDetails();

                     */
                    Thread.sleep(2000);

                    //Motorcycle
                    //click("addMCLink", "Click MC link");//Motorcycle link
                    wdriver.findElement(By.xpath("//a[contains(.,'Motorcycle')]")).click();
                    new AIC_Motorcycle(wdriver, test).fn_MotorcycleDetails();
                    Thread.sleep(2000);

                    //Watercraft
                    //click("addWCLink", "Click Watercraft link");
                    wdriver.findElement(By.xpath("//a[contains(.,'Watercraft')]")).click();//Watercraft link
                    new AIC_Watercraft(wdriver, test).fn_WatercraftDetails();
                    Thread.sleep(2000);

                    //Building
                    //click("addBuildLink", "Click Building link");
                    wdriver.findElement(By.xpath("//a[contains(.,'Building')]")).click();//Building link
                    new AIC_Building(wdriver, test).fn_BuildingDetails();
                    Thread.sleep(2000);

                    //Electronic
                    //click("addEELink", "Click Electronic link");
                    wdriver.findElement(By.xpath("//a[contains(.,'Electronic')]")).click();//Electronic link
                    new AIC_Electronic(wdriver, test).fn_ElectronicDetails();
                    Thread.sleep(2000);

                    //Checked buttons and Quote button
                    wdriver.findElement(By.xpath("(//a[@href='#'][contains(.,'Check All')])[2]")).click();//Check All button
                    Thread.sleep(2000);
//                  click("quoteCheckedButton","click quote checked button");//Click quote checked button
                    wdriver.findElement(By.xpath("//a[@href='#'][contains(.,'Quote Checked')]")).click();//Quote checked
                    Thread.sleep(2000);

                    fn_Quoting();
                    break;

                case "PL_REQ_Private_005":
                case "iDirect_REQ_idirect_003_SEC10":
                    //Click Add button
                    click("addButton","Add button must be clicked");
                    Thread.sleep(2000);

                    //Select product(s)
                    click("chBoxHH", "Select HH checkbox");//HouseHold Content
                    click("chBoxAR", "Select AR checkbox");//All Risk
                    click("chBoxBld", "Select HO checkbox");//Building
                    click("chBoxMO", "Select MO checkbox");//Vehicle
                    click("chBoxMC", "Select MC checkbox");//Motorcycle
                    click("chBoxCT", "Select CT checkbox");//Caravan/Trailer
                    click("chBoxWC", "Select WC checkbox");//Watercraft
                    click("chBoxEE", "Select EE checkbox");//Electronic

                    click("addChkButton", "Click add checked button");//Click add checked button

                    //Add for All Risk
                    click("addARButton", "click AR button");
                    Thread.sleep(3000);
                    click("chkUAR", "check the UAR product");
                    click("dneButton", "click done button");
                    Thread.sleep(2000);

                    //HouseHold Content
                    click("addHHLink", "Click HH link");//HouseHold Content link
                    Thread.sleep(2000);
                    new AIC_Home_Contents(wdriver, test).fn_HomeContentsDetails();

                    //link for All Risk
                    //click("lnkUAR", "click the UAR link");
                    wdriver.findElement(By.xpath("XPATH|//span[@class='x16z'][contains(.,'Unspecified All Risk')]")).click();
                    Thread.sleep(2000);
                    new AIC_All_Risk(wdriver, test).fn_AllRiskDetails();//Call All Risk Class and function

                    //Caravan/Trailer
//                  click("addCTlink","click Caravan/Trailer link");//Click Caravan/Trailer link
                    wdriver.findElement(By.xpath("//a[contains(.,'Caravan')]")).click();
                    Thread.sleep(2000);
                    new AIC_Caravan_Trailer(wdriver, test).fn_CaravanTrailer();

                    //Vehicle
                    //click("addVALink", "Click VA link");//Vehicle link
                    wdriver.findElement(By.xpath("//a[contains(.,'Vehicle')]")).click();
                    Thread.sleep(2000);
                    new AIC_Vehicle(wdriver, test).fn_VehicleDetails();
                    Thread.sleep(2000);

                    //Motorcycle
                    //click("addMCLink", "Click MC link");//Motorcycle link
                    wdriver.findElement(By.xpath("//a[contains(.,'Motorcycle')]")).click();
                    new AIC_Motorcycle(wdriver, test).fn_MotorcycleDetails();
                    Thread.sleep(2000);

                    //Watercraft
                    //click("addWCLink", "Click Watercraft link");
                    wdriver.findElement(By.xpath("//a[contains(.,'Watercraft')]")).click();//Watercraft link
                    new AIC_Watercraft(wdriver, test).fn_WatercraftDetails();
                    Thread.sleep(2000);

                    //Building
                    //click("addBuildLink", "Click Building link");
                    wdriver.findElement(By.xpath("//a[contains(.,'Building')]")).click();//Building link
                    new AIC_Building(wdriver, test).fn_BuildingDetails();
                    Thread.sleep(2000);

                    //Electronic
                    //click("addEELink", "Click Electronic link");
                    wdriver.findElement(By.xpath("//a[contains(.,'Electronic')]")).click();//Electronic link
                    new AIC_Electronic(wdriver, test).fn_ElectronicDetails();
                    Thread.sleep(2000);

                    //Checked buttons and Quote button
                    wdriver.findElement(By.xpath("(//a[@href='#'][contains(.,'Check All')])[2]")).click();//Check All button
                    Thread.sleep(2000);
//                  click("quoteCheckedButton","click quote checked button");//Click quote checked button
                    wdriver.findElement(By.xpath("//a[@href='#'][contains(.,'Quote Checked')]")).click();//Quote checked
                    Thread.sleep(2000);

                    fn_Quoting();
                    break;

                case "PL_REQ_APLUS_011":
                case "iDirect_REQ_idirect_004_SEC11":
                    //Click Add button
                    click("addButton","Add button must be clicked");
                    Thread.sleep(2000);

                    //Select product(s)
                    click("chBoxHH", "Select HH checkbox");//HouseHold Content
                    click("chBoxAR", "Select AR checkbox");//All Risk
                    click("chBoxBld", "Select HO checkbox");//Building
                    click("chBoxMO", "Select MO checkbox");//Vehicle
                    click("chBoxMC", "Select MC checkbox");//Motorcycle
                    click("chBoxCT", "Select CT checkbox");//Caravan/Trailer
                    click("chBoxWC", "Select WC checkbox");//Watercraft
                    click("chBoxEE", "Select EE checkbox");//Electronic

                    click("addChkButton", "Click add checked button");//Click add checked button

                    //Add for All Risk
                    click("addARButton", "click AR button");
                    Thread.sleep(3000);
                    click("chkUAR", "check the UAR product");
                    click("dneButton", "click done button");
                    Thread.sleep(2000);

                    //HouseHold Content
                    click("addHHLink", "Click HH link");//HouseHold Content link
                    Thread.sleep(2000);
                    new AIC_Home_Contents(wdriver, test).fn_HomeContentsDetails();

                    //link for All Risk
                    //click("lnkUAR", "click the UAR link");
                    wdriver.findElement(By.xpath("XPATH|//span[@class='x16z'][contains(.,'Unspecified All Risk')]")).click();
                    Thread.sleep(2000);
                    new AIC_All_Risk(wdriver, test).fn_AllRiskDetails();//Call All Risk Class and function

                    //Caravan/Trailer
//                  click("addCTlink","click Caravan/Trailer link");//Click Caravan/Trailer link
                    wdriver.findElement(By.xpath("//a[contains(.,'Caravan')]")).click();
                    Thread.sleep(2000);
                    new AIC_Caravan_Trailer(wdriver, test).fn_CaravanTrailer();

                    //Vehicle
                    //click("addVALink", "Click VA link");//Vehicle link
                    wdriver.findElement(By.xpath("//a[contains(.,'Vehicle')]")).click();
                    Thread.sleep(2000);
                    new AIC_Vehicle(wdriver, test).fn_VehicleDetails();
                    Thread.sleep(2000);

                    //Motorcycle
                    //click("addMCLink", "Click MC link");//Motorcycle link
                    wdriver.findElement(By.xpath("//a[contains(.,'Motorcycle')]")).click();
                    new AIC_Motorcycle(wdriver, test).fn_MotorcycleDetails();
                    Thread.sleep(2000);

                    //Watercraft
                    //click("addWCLink", "Click Watercraft link");
                    wdriver.findElement(By.xpath("//a[contains(.,'Watercraft')]")).click();//Watercraft link
                    new AIC_Watercraft(wdriver, test).fn_WatercraftDetails();
                    Thread.sleep(2000);

                    //Building
                    //click("addBuildLink", "Click Building link");
                    wdriver.findElement(By.xpath("//a[contains(.,'Building')]")).click();//Building link
                    new AIC_Building(wdriver, test).fn_BuildingDetails();
                    Thread.sleep(2000);

                    //Electronic
                    //click("addEELink", "Click Electronic link");
                    wdriver.findElement(By.xpath("//a[contains(.,'Electronic')]")).click();//Electronic link
                    new AIC_Electronic(wdriver, test).fn_ElectronicDetails();
                    Thread.sleep(2000);

                    //Checked buttons and Quote button
                    wdriver.findElement(By.xpath("(//a[@href='#'][contains(.,'Check All')])[2]")).click();//Check All button
                    Thread.sleep(2000);
//                  click("quoteCheckedButton","click quote checked button");//Click quote checked button
                    wdriver.findElement(By.xpath("//a[@href='#'][contains(.,'Quote Checked')]")).click();//Quote checked
                    Thread.sleep(2000);

                    fn_Quoting();
                    break;

                case "PL_REQ_APLUS_012":
                case "iDirect_REQ_idirect_004_SEC12":
                    //Click Add button
                    click("addButton","Add button must be clicked");
                    Thread.sleep(2000);

                    //Select product(s)
                    click("chBoxHH", "Select HH checkbox");//HouseHold Content
                    click("chBoxAR", "Select AR checkbox");//All Risk
                    click("chBoxBld", "Select HO checkbox");//Building
                    click("chBoxMO", "Select MO checkbox");//Vehicle
                    click("chBoxMC", "Select MC checkbox");//Motorcycle
                    click("chBoxCT", "Select CT checkbox");//Caravan/Trailer
                    click("chBoxWC", "Select WC checkbox");//Watercraft
                    click("chBoxEE", "Select EE checkbox");//Electronic

                    click("addChkButton", "Click add checked button");//Click add checked button

                    //Add for All Risk
                    click("addARButton", "click AR button");
                    Thread.sleep(3000);
                    click("chkUAR", "check the UAR product");
                    click("dneButton", "click done button");
                    Thread.sleep(2000);

                    //HouseHold Content
                    click("addHHLink", "Click HH link");//HouseHold Content link
                    Thread.sleep(2000);
                    new AIC_Home_Contents(wdriver, test).fn_HomeContentsDetails();

                    //link for All Risk
                    //click("lnkUAR", "click the UAR link");
                    wdriver.findElement(By.xpath("XPATH|//span[@class='x16z'][contains(.,'Unspecified All Risk')]")).click();
                    Thread.sleep(2000);
                    new AIC_All_Risk(wdriver, test).fn_AllRiskDetails();//Call All Risk Class and function

                    //Caravan/Trailer
//                  click("addCTlink","click Caravan/Trailer link");//Click Caravan/Trailer link
                    wdriver.findElement(By.xpath("//a[contains(.,'Caravan')]")).click();
                    Thread.sleep(2000);
                    new AIC_Caravan_Trailer(wdriver, test).fn_CaravanTrailer();

                    //Vehicle
                    //click("addVALink", "Click VA link");//Vehicle link
                    wdriver.findElement(By.xpath("//a[contains(.,'Vehicle')]")).click();
                    Thread.sleep(2000);
                    new AIC_Vehicle(wdriver, test).fn_VehicleDetails();

                    Thread.sleep(2000);
                    //Motorcycle
                    //click("addMCLink", "Click MC link");//Motorcycle link
                    wdriver.findElement(By.xpath("//a[contains(.,'Motorcycle')]")).click();
                    new AIC_Motorcycle(wdriver, test).fn_MotorcycleDetails();
                    Thread.sleep(2000);

                    //Watercraft
                    //click("addWCLink", "Click Watercraft link");
                    wdriver.findElement(By.xpath("//a[contains(.,'Watercraft')]")).click();//Watercraft link
                    new AIC_Watercraft(wdriver, test).fn_WatercraftDetails();
                    Thread.sleep(2000);

                    //Building
                    //click("addBuildLink", "Click Building link");
                    wdriver.findElement(By.xpath("//a[contains(.,'Building')]")).click();//Building link
                    new AIC_Building(wdriver, test).fn_BuildingDetails();
                    Thread.sleep(2000);

                    //Electronic
                    //click("addEELink", "Click Electronic link");
                    wdriver.findElement(By.xpath("//a[contains(.,'Electronic')]")).click();//Electronic link
                    new AIC_Electronic(wdriver, test).fn_ElectronicDetails();
                    Thread.sleep(2000);

                    //Checked buttons and Quote button
                    wdriver.findElement(By.xpath("(//a[@href='#'][contains(.,'Check All')])[2]")).click();//Check All button
                    Thread.sleep(2000);
//                  click("quoteCheckedButton","click quote checked button");//Click quote checked button
                    wdriver.findElement(By.xpath("//a[@href='#'][contains(.,'Quote Checked')]")).click();//Quote checked
                    Thread.sleep(2000);

                    fn_Quoting();
                    break;

                case "PL_REQ_APLUS_014":
                case "iDirect_REQ_idirect_004_SEC13":

                    //Click Add button
                    click("addButton","Add button must be clicked");
                    Thread.sleep(2000);

                    //Select product(s)
                    click("chBoxHH", "Select HH checkbox");//HouseHold Content
                    click("chBoxAR", "Select AR checkbox");//All Risk
                    click("chBoxBld", "Select HO checkbox");//Building
                    click("chBoxMO", "Select MO checkbox");//Vehicle
                    click("chBoxMC", "Select MC checkbox");//Motorcycle
                    click("chBoxCT", "Select CT checkbox");//Caravan/Trailer
                    click("chBoxWC", "Select WC checkbox");//Watercraft
                    click("chBoxEE", "Select EE checkbox");//Electronic

                    click("addChkButton", "Click add checked button");//Click add checked button

                    //Add for All Risk
                    click("addARButton", "click AR button");
                    Thread.sleep(3000);
                    click("chkUAR", "check the UAR product");
                    click("dneButton", "click done button");
                    Thread.sleep(2000);

                    //HouseHold Content
                    click("addHHLink", "Click HH link");//HouseHold Content link
                    Thread.sleep(2000);
                    new AIC_Home_Contents(wdriver, test).fn_HomeContentsDetails();

                    //link for All Risk
                    //click("lnkUAR", "click the UAR link");
                    wdriver.findElement(By.xpath("XPATH|//span[@class='x16z'][contains(.,'Unspecified All Risk')]")).click();
                    Thread.sleep(2000);
                    new AIC_All_Risk(wdriver, test).fn_AllRiskDetails();//Call All Risk Class and function

                    //Caravan/Trailer
//                  click("addCTlink","click Caravan/Trailer link");//Click Caravan/Trailer link
                    wdriver.findElement(By.xpath("//a[contains(.,'Caravan')]")).click();
                    Thread.sleep(2000);
                    new AIC_Caravan_Trailer(wdriver, test).fn_CaravanTrailer();

                    //Vehicle
                    click("addVALink", "Click VA link");//Vehicle link
                    wdriver.findElement(By.xpath("//a[contains(.,'Vehicle')]")).click();
                    Thread.sleep(2000);
                    new AIC_Vehicle(wdriver, test).fn_VehicleDetails();

                    Thread.sleep(2000);
                    //Motorcycle
                    //click("addMCLink", "Click MC link");//Motorcycle link
                    wdriver.findElement(By.xpath("//a[contains(.,'Motorcycle')]")).click();
                    new AIC_Motorcycle(wdriver, test).fn_MotorcycleDetails();
                    Thread.sleep(2000);

                    //Watercraft
                    //click("addWCLink", "Click Watercraft link");
                    wdriver.findElement(By.xpath("//a[contains(.,'Watercraft')]")).click();//Watercraft link
                    new AIC_Watercraft(wdriver, test).fn_WatercraftDetails();
                    Thread.sleep(2000);

                    //Building
                    //click("addBuildLink", "Click Building link");
                    wdriver.findElement(By.xpath("//a[contains(.,'Building')]")).click();//Building link
                    new AIC_Building(wdriver, test).fn_BuildingDetails();
                    Thread.sleep(2000);

                    //Electronic
                    //click("addEELink", "Click Electronic link");
                    wdriver.findElement(By.xpath("//a[contains(.,'Electronic')]")).click();//Electronic link
                    new AIC_Electronic(wdriver, test).fn_ElectronicDetails();
                    Thread.sleep(2000);

                    //Checked buttons and Quote button
                    wdriver.findElement(By.xpath("(//a[@href='#'][contains(.,'Check All')])[2]")).click();//Check All button
                    Thread.sleep(2000);
//                  click("quoteCheckedButton","click quote checked button");//Click quote checked button
                    wdriver.findElement(By.xpath("//a[@href='#'][contains(.,'Quote Checked')]")).click();//Quote checked
                    Thread.sleep(2000);

                    fn_Quoting();
                    break;

                case "iDirect_REQ_idirect_005_SEC14":

                    //Select product(s)
                    //Click Add button
                    click("addButton","Add button must be clicked");

                    //Select product(s)
                    click("chBoxHH", "Select HH checkbox");//Household
                    click("chBoxEE", "Select EE checkbox");//Electronic
                    click("chBoxCT", "Select CT checkbox");//Caravan/Trailer
                    click("chBoxAR", "Select AR checkbox");//All Risk
                    Thread.sleep(3000);

                    //Click the add checked button
                    click("addChkButton", "Click add checked button");
                    Thread.sleep(3000);
                    //Click Add for All Risk
                    click("addARButton", "click AR button");
                    Thread.sleep(3000);
                    click("chkUAR", "check the UAR product");
                    click("dneButton", "click done button");

                    //Household
                    click("addHHLink", "Click HH link");
                    Thread.sleep(2000);
                    new AIC_Home_Contents(wdriver, test).fn_HomeContentsDetails();

                    //Electronic
                    //click("addEELink", "Click Electronic link");
                    wdriver.findElement(By.xpath("//a[contains(.,'Electronic')]")).click();
                    new AIC_Electronic(wdriver, test).fn_ElectronicDetails();
                    Thread.sleep(2000);

                    //Caravan/Trailer
//                  click("addCTlink","click Caravan/Trailer link");//Click Caravan/Trailer link
                    wdriver.findElement(By.xpath("//a[contains(.,'Caravan/Trailer')]")).click();
                    Thread.sleep(2000);
                    new AIC_Caravan_Trailer(wdriver, test).fn_CaravanTrailer();

                    //All Risk
                    //click("lnkUAR", "click the UAR link");
                    wdriver.findElement(By.xpath("XPATH|//span[@class='x16v'][contains(.,'Unspecified All Risk')]")).click();
                    Thread.sleep(2000);
                    new AIC_All_Risk(wdriver, test).fn_AllRiskDetails();//Call All Risk Class and function

                    wdriver.findElement(By.xpath("(//a[@href='#'][contains(.,'Check All')])[2]")).click();//Click Check All button
                    Thread.sleep(2000);

                    wdriver.findElement(By.xpath("//a[@href='#'][contains(.,'Quote Checked')]")).click();//Click quote checked
                    Thread.sleep(2000);
                    fn_Quoting();

                    break;
                case "iDirect_REQ_idirect_005_SEC15":

                    //Select product(s)
                    //Click Add button
                    click("addButton","Add button must be clicked");

                    //Select product(s)
                    click("chBoxHH", "Select HH checkbox");//Household
                    click("chBoxEE", "Select EE checkbox");//Electronic
                    click("chBoxCT", "Select CT checkbox");//Caravan/Trailer
                    click("chBoxAR", "Select AR checkbox");//All Risk
                    Thread.sleep(3000);

                    //Click the add checked button
                    click("addChkButton", "Click add checked button");
                    Thread.sleep(3000);
                    //Click Add for All Risk
                    click("addARButton", "click AR button");
                    Thread.sleep(3000);
                    click("chkUAR", "check the UAR product");
                    click("dneButton", "click done button");

                    //Household
                    click("addHHLink", "Click HH link");
                    Thread.sleep(2000);
                    new AIC_Home_Contents(wdriver, test).fn_HomeContentsDetails();

                    //Electronic
                    //click("addEELink", "Click Electronic link");
                    wdriver.findElement(By.xpath("//a[contains(.,'Electronic')]")).click();
                    new AIC_Electronic(wdriver, test).fn_ElectronicDetails();
                    Thread.sleep(2000);

                    //Caravan/Trailer
//                  click("addCTlink","click Caravan/Trailer link");//Click Caravan/Trailer link
                    wdriver.findElement(By.xpath("//a[contains(.,'Caravan/Trailer')]")).click();
                    Thread.sleep(2000);
                    new AIC_Caravan_Trailer(wdriver, test).fn_CaravanTrailer();

                    //All Risk
                    //click("lnkUAR", "click the UAR link");
                    wdriver.findElement(By.xpath("XPATH|//span[@class='x16z'][contains(.,'Unspecified All Risk')]")).click();
                    Thread.sleep(2000);
                    new AIC_All_Risk(wdriver, test).fn_AllRiskDetails();//Call All Risk Class and function

                    wdriver.findElement(By.xpath("(//a[@href='#'][contains(.,'Check All')])[2]")).click();//Click Check All button
                    Thread.sleep(2000);

                    wdriver.findElement(By.xpath("//a[@href='#'][contains(.,'Quote Checked')]")).click();//Click quote checked
                    Thread.sleep(2000);
                    fn_Quoting();

                    break;
                case "iDirect_REQ_idirect_005_SEC16":

                    //Select product(s)
                    //Click Add button
                    click("addButton","Add button must be clicked");

                    //Select product(s)
                    click("chBoxHH", "Select HH checkbox");//Household
                    click("chBoxEE", "Select EE checkbox");//Electronic
                    click("chBoxCT", "Select CT checkbox");//Caravan/Trailer
                    click("chBoxAR", "Select AR checkbox");//All Risk
                    Thread.sleep(3000);

                    //Click the add checked button
                    click("addChkButton", "Click add checked button");
                    Thread.sleep(3000);
                    //Click Add for All Risk
                    click("addARButton", "click AR button");
                    Thread.sleep(3000);
                    click("chkUAR", "check the UAR product");
                    click("dneButton", "click done button");
                    Thread.sleep(3000);
                    //Household
                    click("addHHLink", "Click HH link");
                    Thread.sleep(2000);
                    new AIC_Home_Contents(wdriver, test).fn_HomeContentsDetails();

                    //Electronic
                    //click("addEELink", "Click Electronic link");
                    wdriver.findElement(By.xpath("//a[contains(.,'Electronic')]")).click();
                    new AIC_Electronic(wdriver, test).fn_ElectronicDetails();
                    Thread.sleep(2000);

                    //Caravan/Trailer
//                  click("addCTlink","click Caravan/Trailer link");//Click Caravan/Trailer link
                    wdriver.findElement(By.xpath("//a[contains(.,'Caravan/Trailer')]")).click();
                    Thread.sleep(2000);
                    new AIC_Caravan_Trailer(wdriver, test).fn_CaravanTrailer();

                    //All Risk
                    //click("lnkUAR", "click the UAR link");
                    wdriver.findElement(By.xpath("XPATH|//span[@class='x16z'][contains(.,'Unspecified All Risk')]")).click();
                    Thread.sleep(2000);
                    new AIC_All_Risk(wdriver, test).fn_AllRiskDetails();//Call All Risk Class and function

                    wdriver.findElement(By.xpath("(//a[@href='#'][contains(.,'Check All')])[2]")).click();//Click Check All button
                    Thread.sleep(2000);

                    wdriver.findElement(By.xpath("//a[@href='#'][contains(.,'Quote Checked')]")).click();//Click quote checked
                    Thread.sleep(2000);
                    fn_Quoting();
                    break;

                case "iDirect_REQ_idirect_006_SEC17":
                    //Click Add button
                    click("addButton","Add button must be clicked");
                    Thread.sleep(2000);

                    //Select product(s)
                    click("chBoxHH", "Select HH checkbox");//HouseHold Content
                    click("chBoxAR", "Select AR checkbox");//All Risk
                    click("chBoxBld", "Select HO checkbox");//Building
                    click("chBoxMO", "Select MO checkbox");//Vehicle
                    click("chBoxMC", "Select MC checkbox");//Motorcycle
                    click("chBoxCT", "Select CT checkbox");//Caravan/Trailer
                    click("chBoxWC", "Select WC checkbox");//Watercraft
                    click("chBoxEE", "Select EE checkbox");//Electronic
                    click("addChkButton", "Click add checked button");//Click add checked button
                    //Add for All Risk
                    click("addARButton", "click AR button");
                    Thread.sleep(3000);
                    click("chkUAR", "check the UAR product");
                    click("dneButton", "click done button");

                    //HouseHold Content
                    click("addHHLink", "Click HH link");//HouseHold Content link
                    Thread.sleep(2000);
                    new AIC_Home_Contents(wdriver, test).fn_HomeContentsDetails();

                    //link for All Risk
                    //click("lnkUAR", "click the UAR link");
                    wdriver.findElement(By.xpath("XPATH|//span[@class='x16z'][contains(.,'Unspecified All Risk')]")).click();
                    Thread.sleep(2000);
                    new AIC_All_Risk(wdriver, test).fn_AllRiskDetails();//Call All Risk Class and function

                    //Vehicle
                    //click("addVALink", "Click VA link");//Vehicle link
                    wdriver.findElement(By.xpath("//a[contains(.,'Vehicle')]")).click();
                    Thread.sleep(2000);
                    new AIC_Vehicle(wdriver, test).fn_VehicleDetails();
                    Thread.sleep(2000);

                    //Motorcycle
                    //click("addMCLink", "Click MC link");//Motorcycle link
                    wdriver.findElement(By.xpath("//a[contains(.,'Motorcycle')]")).click();
                    new AIC_Motorcycle(wdriver, test).fn_MotorcycleDetails();
                    Thread.sleep(2000);

                    //Watercraft
                    //click("addWCLink", "Click Watercraft link");
                    wdriver.findElement(By.xpath("//a[contains(.,'Watercraft')]")).click();//Watercraft link
                    new AIC_Watercraft(wdriver, test).fn_WatercraftDetails();
                    Thread.sleep(2000);

                    //Building
                    //click("addBuildLink", "Click Building link");
                    wdriver.findElement(By.xpath("//a[contains(.,'Building')]")).click();//Building link
                    new AIC_Building(wdriver, test).fn_BuildingDetails();
                    Thread.sleep(2000);

                    //Caravan/Trailer
//                  click("addCTlink","click Caravan/Trailer link");//Click Caravan/Trailer link
                    wdriver.findElement(By.xpath("//a[contains(.,'Caravan')]")).click();
                    Thread.sleep(2000);
                    new AIC_Caravan_Trailer(wdriver, test).fn_CaravanTrailer();

                    //Electronic
                    //click("addEELink", "Click Electronic link");
                    wdriver.findElement(By.xpath("//a[contains(.,'Electronic')]")).click();//Electronic link
                    new AIC_Electronic(wdriver, test).fn_ElectronicDetails();
                    Thread.sleep(2000);

                    //Checked buttons and Quote button
                    wdriver.findElement(By.xpath("(//a[@href='#'][contains(.,'Check All')])[2]")).click();//Check All button
                    Thread.sleep(2000);
//                  click("quoteCheckedButton","click quote checked button");//Click quote checked button
                    wdriver.findElement(By.xpath("//a[@href='#'][contains(.,'Quote Checked')]")).click();//Quote checked
                    Thread.sleep(2000);
                    fn_Quoting();
                    break;

                case "iDirect_REQ_idirect_007_SEC21":
                    //Click Add button
                    click("addButton","Add button must be clicked");
                    Thread.sleep(2000);

                    //Select product(s)
                    click("chBoxHH", "Select HH checkbox");//HouseHold Content
                    click("chBoxAR", "Select AR checkbox");//All Risk
                    click("chBoxBld", "Select HO checkbox");//Building
                    click("chBoxMO", "Select MO checkbox");//Vehicle
                    click("chBoxMC", "Select MC checkbox");//Motorcycle
                    click("chBoxCT", "Select CT checkbox");//Caravan/Trailer
                    click("chBoxWC", "Select WC checkbox");//Watercraft
                    click("chBoxEE", "Select EE checkbox");//Electronic
                    click("addChkButton", "Click add checked button");//Click add checked button
                    //Add for All Risk
                    click("addARButton", "click AR button");
                    Thread.sleep(3000);
                    click("chkUAR", "check the UAR product");
                    click("dneButton", "click done button");

                    //HouseHold Content
                    click("addHHLink", "Click HH link");//HouseHold Content link
                    Thread.sleep(2000);
                    new AIC_Home_Contents(wdriver, test).fn_HomeContentsDetails();

                    //link for All Risk
                    //click("lnkUAR", "click the UAR link");
                    wdriver.findElement(By.xpath("XPATH|//span[@class='x16z'][contains(.,'Unspecified All Risk')]")).click();
                    Thread.sleep(2000);
                    new AIC_All_Risk(wdriver, test).fn_AllRiskDetails();//Call All Risk Class and function

                    //Vehicle
                    //click("addVALink", "Click VA link");//Vehicle link
                    wdriver.findElement(By.xpath("//a[contains(.,'Vehicle')]")).click();
                    Thread.sleep(2000);
                    new AIC_Vehicle(wdriver, test).fn_VehicleDetails();
                    Thread.sleep(2000);

                    //Motorcycle
                    //click("addMCLink", "Click MC link");//Motorcycle link
                    wdriver.findElement(By.xpath("//a[contains(.,'Motorcycle')]")).click();
                    new AIC_Motorcycle(wdriver, test).fn_MotorcycleDetails();
                    Thread.sleep(2000);

                    //Watercraft
                    //click("addWCLink", "Click Watercraft link");
                    wdriver.findElement(By.xpath("//a[contains(.,'Watercraft')]")).click();//Watercraft link
                    new AIC_Watercraft(wdriver, test).fn_WatercraftDetails();
                    Thread.sleep(2000);

                    //Building
                    //click("addBuildLink", "Click Building link");
                    wdriver.findElement(By.xpath("//a[contains(.,'Building')]")).click();//Building link
                    new AIC_Building(wdriver, test).fn_BuildingDetails();
                    Thread.sleep(2000);

                    //Caravan/Trailer
//                  click("addCTlink","click Caravan/Trailer link");//Click Caravan/Trailer link
                    wdriver.findElement(By.xpath("//a[contains(.,'Caravan')]")).click();
                    Thread.sleep(2000);
                    new AIC_Caravan_Trailer(wdriver, test).fn_CaravanTrailer();

                    //Electronic
                    //click("addEELink", "Click Electronic link");
                    wdriver.findElement(By.xpath("//a[contains(.,'Electronic')]")).click();//Electronic link
                    new AIC_Electronic(wdriver, test).fn_ElectronicDetails();
                    Thread.sleep(2000);

                    //Checked buttons and Quote button
                    wdriver.findElement(By.xpath("(//a[@href='#'][contains(.,'Check All')])[2]")).click();//Check All button
                    Thread.sleep(2000);
//                  click("quoteCheckedButton","click quote checked button");//Click quote checked button
                    wdriver.findElement(By.xpath("//a[@href='#'][contains(.,'Quote Checked')]")).click();//Quote checked
                    Thread.sleep(2000);
                    fn_Quoting();
                    break;
                case "iDirect_REQ_idirect_007_SEC22":
                    //Click Add button
                    click("addButton","Add button must be clicked");
                    Thread.sleep(2000);

                    //Select product(s)
                    click("chBoxHH", "Select HH checkbox");//HouseHold Content
                    click("chBoxAR", "Select AR checkbox");//All Risk
                    click("chBoxBld", "Select HO checkbox");//Building
                    //click("chBoxMO", "Select MO checkbox");//Vehicle
                    click("chBoxMC", "Select MC checkbox");//Motorcycle
                    click("chBoxCT", "Select CT checkbox");//Caravan/Trailer
                    click("chBoxWC", "Select WC checkbox");//Watercraft
                    click("chBoxEE", "Select EE checkbox");//Electronic
                    click("addChkButton", "Click add checked button");//Click add checked button
                    //Add for All Risk
                    click("addARButton", "click AR button");
                    Thread.sleep(3000);
                    click("chkUAR", "check the UAR product");
                    click("dneButton", "click done button");

                    //HouseHold Content
                    click("addHHLink", "Click HH link");//HouseHold Content link
                    Thread.sleep(2000);
                    new AIC_Home_Contents(wdriver, test).fn_HomeContentsDetails();

                    //link for All Risk
                    //click("lnkUAR", "click the UAR link");
                    wdriver.findElement(By.xpath("XPATH|//span[@class='x16z'][contains(.,'Unspecified All Risk')]")).click();
                    Thread.sleep(2000);
                    new AIC_All_Risk(wdriver, test).fn_AllRiskDetails();//Call All Risk Class and function

                    //Vehicle
                    /*
                    //click("addVALink", "Click VA link");//Vehicle link
                    wdriver.findElement(By.xpath("//a[contains(.,'Vehicle')]")).click();
                    Thread.sleep(2000);
                    new AIC_Vehicle(wdriver, test).fn_VehicleDetails();
                    Thread.sleep(2000);

                     */

                    //Motorcycle
                    //click("addMCLink", "Click MC link");//Motorcycle link
                    wdriver.findElement(By.xpath("//a[contains(.,'Motorcycle')]")).click();
                    new AIC_Motorcycle(wdriver, test).fn_MotorcycleDetails();
                    Thread.sleep(2000);

                    //Watercraft
                    //click("addWCLink", "Click Watercraft link");
                    wdriver.findElement(By.xpath("//a[contains(.,'Watercraft')]")).click();//Watercraft link
                    new AIC_Watercraft(wdriver, test).fn_WatercraftDetails();
                    Thread.sleep(2000);

                    //Building
                    //click("addBuildLink", "Click Building link");
                    wdriver.findElement(By.xpath("//a[contains(.,'Building')]")).click();//Building link
                    new AIC_Building(wdriver, test).fn_BuildingDetails();
                    Thread.sleep(2000);

                    //Caravan/Trailer
//                  click("addCTlink","click Caravan/Trailer link");//Click Caravan/Trailer link
                    wdriver.findElement(By.xpath("//a[contains(.,'Caravan')]")).click();
                    Thread.sleep(2000);
                    new AIC_Caravan_Trailer(wdriver, test).fn_CaravanTrailer();

                    //Electronic
                    //click("addEELink", "Click Electronic link");
                    wdriver.findElement(By.xpath("//a[contains(.,'Electronic')]")).click();//Electronic link
                    new AIC_Electronic(wdriver, test).fn_ElectronicDetails();
                    Thread.sleep(2000);

                    //Checked buttons and Quote button
                    wdriver.findElement(By.xpath("(//a[@href='#'][contains(.,'Check All')])[2]")).click();//Check All button
                    Thread.sleep(2000);
//                  click("quoteCheckedButton","click quote checked button");//Click quote checked button
                    wdriver.findElement(By.xpath("//a[@href='#'][contains(.,'Quote Checked')]")).click();//Quote checked
                    Thread.sleep(2000);
                    fn_Quoting();
                    break;
                case "PL_REQ_APLUS_007":
                case "iDirect_REQ_idirect_007_SEC20":

                    //Select product(s)
                    //Click Add button
                    click("addButton","Add button must be clicked");

                    //Select product(s)
                    click("chBoxHH", "Select HH checkbox");//Household
                    click("chBoxAR", "Select AR checkbox");//All Risk
                    click("chBoxEE", "Select EE checkbox");//Electronic

                    //Click the add checked button
                    click("addChkButton", "Click add checked button");

                    //Click Add for All Risk
                    click("addARButton", "click AR button");
                    click("chkUAR", "check the UAR product");
                    click("dneButton", "click done button");

                    //link for Home Content
                    click("addHHLink", "Click HH link");
                    Thread.sleep(2000);
                    new AIC_Home_Contents(wdriver, test).fn_HomeContentsDetails();

                    //Electronic
                    //click("addEELink", "Click Electronic link");
                    wdriver.findElement(By.xpath("//a[contains(.,'Electronic')]")).click();
                    new AIC_Electronic(wdriver, test).fn_ElectronicDetails();
                    Thread.sleep(2000);

                    //link for All Risk
                    //click("lnkUAR", "click the UAR link");
                    wdriver.findElement(By.xpath("XPATH|//span[@class='x16z'][contains(.,'Unspecified All Risk')]")).click();
                    Thread.sleep(2000);
                    new AIC_All_Risk(wdriver, test).fn_AllRiskDetails();//Call All Risk Class and function


                    wdriver.findElement(By.xpath("(//a[@href='#'][contains(.,'Check All')])[2]")).click();//Click Check All button
                    Thread.sleep(2000);
//                  click("quoteCheckedButton","click quote checked button");//Click quote checked button
                    wdriver.findElement(By.xpath("//a[@href='#'][contains(.,'Quote Checked')]")).click();//Click quote checked
                    Thread.sleep(2000);
                    fn_Quoting();

                    break;

                case "iDirect_REQ_idirect_008_SEC23":

                    //Click Add button
                    click("addButton","Add button must be clicked");
                    Thread.sleep(2000);

                    //Select product(s)
                    click("chBoxHH", "Select HH checkbox");//HouseHold Content
                    click("chBoxAR", "Select AR checkbox");//All Risk
                    click("chBoxBld", "Select HO checkbox");//Building
                    click("chBoxMO", "Select MO checkbox");//Vehicle
                    click("chBoxMC", "Select MC checkbox");//Motorcycle
                    click("chBoxCT", "Select CT checkbox");//Caravan/Trailer
                    click("chBoxWC", "Select WC checkbox");//Watercraft
                    click("chBoxEE", "Select EE checkbox");//Electronic

                    click("addChkButton", "Click add checked button");//Click add checked button


                    //Add for All Risk
                    click("addARButton", "click AR button");
                    Thread.sleep(3000);
                    click("chkUAR", "check the UAR product");
                    click("dneButton", "click done button");

                    //HouseHold Content
                    click("addHHLink", "Click HH link");//HouseHold Content link
                    Thread.sleep(2000);
                    new AIC_Home_Contents(wdriver, test).fn_HomeContentsDetails();

                    //link for All Risk
                    //click("lnkUAR", "click the UAR link");
                    wdriver.findElement(By.xpath("XPATH|//span[@class='x16z'][contains(.,'Unspecified All Risk')]")).click();
                    Thread.sleep(2000);
                    new AIC_All_Risk(wdriver, test).fn_AllRiskDetails();//Call All Risk Class and function

                    //Vehicle
                    //click("addVALink", "Click VA link");//Vehicle link
                    wdriver.findElement(By.xpath("//a[contains(.,'Vehicle')]")).click();
                    Thread.sleep(2000);
                    new AIC_Vehicle(wdriver, test).fn_VehicleDetails();
                    Thread.sleep(2000);

                    //Motorcycle
                    //click("addMCLink", "Click MC link");//Motorcycle link
                    wdriver.findElement(By.xpath("//a[contains(.,'Motorcycle')]")).click();
                    new AIC_Motorcycle(wdriver, test).fn_MotorcycleDetails();
                    Thread.sleep(2000);

                    //Watercraft
                    //click("addWCLink", "Click Watercraft link");
                    wdriver.findElement(By.xpath("//a[contains(.,'Watercraft')]")).click();//Watercraft link
                    new AIC_Watercraft(wdriver, test).fn_WatercraftDetails();
                    Thread.sleep(2000);

                    //Building
                    //click("addBuildLink", "Click Building link");
                    wdriver.findElement(By.xpath("//a[contains(.,'Building')]")).click();//Building link
                    new AIC_Building(wdriver, test).fn_BuildingDetails();
                    Thread.sleep(2000);

                    //Caravan/Trailer
//                  click("addCTlink","click Caravan/Trailer link");//Click Caravan/Trailer link
                    wdriver.findElement(By.xpath("//a[contains(.,'Caravan')]")).click();
                    Thread.sleep(2000);
                    new AIC_Caravan_Trailer(wdriver, test).fn_CaravanTrailer();

                    //Electronic
                    //click("addEELink", "Click Electronic link");
                    wdriver.findElement(By.xpath("//a[contains(.,'Electronic')]")).click();//Electronic link
                    new AIC_Electronic(wdriver, test).fn_ElectronicDetails();
                    Thread.sleep(2000);

                    //Checked buttons and Quote button
                    wdriver.findElement(By.xpath("(//a[@href='#'][contains(.,'Check All')])[2]")).click();//Check All button
                    Thread.sleep(2000);
//                  click("quoteCheckedButton","click quote checked button");//Click quote checked button
                    wdriver.findElement(By.xpath("//a[@href='#'][contains(.,'Quote Checked')]")).click();//Quote checked
                    Thread.sleep(2000);

                    fn_Quoting();
                    break;

                case "iDirect_REQ_idirect_008_SEC24":
                    //Click Add button
                    click("addButton","Add button must be clicked");
                    Thread.sleep(2000);

                    //Select product(s)
                    click("chBoxHH", "Select HH checkbox");//HouseHold Content
                    click("chBoxAR", "Select AR checkbox");//All Risk
                    click("chBoxBld", "Select HO checkbox");//Building
                    click("chBoxMO", "Select MO checkbox");//Vehicle
                    click("chBoxMC", "Select MC checkbox");//Motorcycle
                    click("chBoxCT", "Select CT checkbox");//Caravan/Trailer
                    click("chBoxWC", "Select WC checkbox");//Watercraft
                    click("chBoxEE", "Select EE checkbox");//Electronic

                    click("addChkButton", "Click add checked button");//Click add checked button

                    //Add for All Risk
                    click("addARButton", "click AR button");
                    Thread.sleep(3000);
                    click("chkUAR", "check the UAR product");
                    click("dneButton", "click done button");

                    //HouseHold Content
                    click("addHHLink", "Click HH link");//HouseHold Content link
                    Thread.sleep(2000);
                    new AIC_Home_Contents(wdriver, test).fn_HomeContentsDetails();

                    //link for All Risk
                    //click("lnkUAR", "click the UAR link");
                    wdriver.findElement(By.xpath("XPATH|//span[@class='x16z'][contains(.,'Unspecified All Risk')]")).click();
                    Thread.sleep(2000);
                    new AIC_All_Risk(wdriver, test).fn_AllRiskDetails();//Call All Risk Class and function

                    //Vehicle
                    //click("addVALink", "Click VA link");//Vehicle link
                    wdriver.findElement(By.xpath("//a[contains(.,'Vehicle')]")).click();
                    Thread.sleep(2000);
                    new AIC_Vehicle(wdriver, test).fn_VehicleDetails();
                    Thread.sleep(2000);

                    //Motorcycle
                    //click("addMCLink", "Click MC link");//Motorcycle link
                    wdriver.findElement(By.xpath("//a[contains(.,'Motorcycle')]")).click();
                    new AIC_Motorcycle(wdriver, test).fn_MotorcycleDetails();
                    Thread.sleep(2000);

                    //Watercraft
                    //click("addWCLink", "Click Watercraft link");
                    wdriver.findElement(By.xpath("//a[contains(.,'Watercraft')]")).click();//Watercraft link
                    new AIC_Watercraft(wdriver, test).fn_WatercraftDetails();
                    Thread.sleep(2000);

                    //Building
                    //click("addBuildLink", "Click Building link");
                    wdriver.findElement(By.xpath("//a[contains(.,'Building')]")).click();//Building link
                    new AIC_Building(wdriver, test).fn_BuildingDetails();
                    Thread.sleep(2000);

                    //Caravan/Trailer
//                  click("addCTlink","click Caravan/Trailer link");//Click Caravan/Trailer link
                    wdriver.findElement(By.xpath("//a[contains(.,'Caravan')]")).click();
                    Thread.sleep(2000);
                    new AIC_Caravan_Trailer(wdriver, test).fn_CaravanTrailer();

                    //Electronic
                    //click("addEELink", "Click Electronic link");
                    wdriver.findElement(By.xpath("//a[contains(.,'Electronic')]")).click();//Electronic link
                    new AIC_Electronic(wdriver, test).fn_ElectronicDetails();
                    Thread.sleep(2000);

                    //Checked buttons and Quote button
                    wdriver.findElement(By.xpath("(//a[@href='#'][contains(.,'Check All')])[2]")).click();//Check All button
                    Thread.sleep(2000);
//                  click("quoteCheckedButton","click quote checked button");//Click quote checked button
                    wdriver.findElement(By.xpath("//a[@href='#'][contains(.,'Quote Checked')]")).click();//Quote checked
                    Thread.sleep(2000);

                    fn_Quoting();
                    break;

                case "iDirect_REQ_idirect_008_SEC25":
                    //Click Add button
                    click("addButton","Add button must be clicked");
                    Thread.sleep(2000);

                    //Select product(s)
                    click("chBoxHH", "Select HH checkbox");//HouseHold Content
                    click("chBoxAR", "Select AR checkbox");//All Risk
                    click("chBoxBld", "Select HO checkbox");//Building
                    click("chBoxMO", "Select MO checkbox");//Vehicle
                    click("chBoxMC", "Select MC checkbox");//Motorcycle
                    click("chBoxCT", "Select CT checkbox");//Caravan/Trailer
                    click("chBoxWC", "Select WC checkbox");//Watercraft
                    click("chBoxEE", "Select EE checkbox");//Electronic

                    click("addChkButton", "Click add checked button");//Click add checked button

                    //Add for All Risk
                    click("addARButton", "click AR button");
                    Thread.sleep(3000);
                    click("chkUAR", "check the UAR product");
                    click("dneButton", "click done button");

                    //HouseHold Content
                    click("addHHLink", "Click HH link");//HouseHold Content link
                    Thread.sleep(2000);
                    new AIC_Home_Contents(wdriver, test).fn_HomeContentsDetails();

                    //link for All Risk
                    //click("lnkUAR", "click the UAR link");
                    wdriver.findElement(By.xpath("XPATH|//span[@class='x16z'][contains(.,'Unspecified All Risk')]")).click();
                    Thread.sleep(2000);
                    new AIC_All_Risk(wdriver, test).fn_AllRiskDetails();//Call All Risk Class and function

                    //Vehicle
                    //click("addVALink", "Click VA link");//Vehicle link
                    wdriver.findElement(By.xpath("//a[contains(.,'Vehicle')]")).click();
                    Thread.sleep(2000);
                    new AIC_Vehicle(wdriver, test).fn_VehicleDetails();
                    Thread.sleep(2000);

                    //Motorcycle
                    //click("addMCLink", "Click MC link");//Motorcycle link
                    wdriver.findElement(By.xpath("//a[contains(.,'Motorcycle')]")).click();
                    new AIC_Motorcycle(wdriver, test).fn_MotorcycleDetails();
                    Thread.sleep(2000);

                    //Watercraft
                    //click("addWCLink", "Click Watercraft link");
                    wdriver.findElement(By.xpath("//a[contains(.,'Watercraft')]")).click();//Watercraft link
                    new AIC_Watercraft(wdriver, test).fn_WatercraftDetails();
                    Thread.sleep(2000);

                    //Building
                    //click("addBuildLink", "Click Building link");
                    wdriver.findElement(By.xpath("//a[contains(.,'Building')]")).click();//Building link
                    new AIC_Building(wdriver, test).fn_BuildingDetails();
                    Thread.sleep(2000);

                    //Caravan/Trailer
//                  click("addCTlink","click Caravan/Trailer link");//Click Caravan/Trailer link
                    wdriver.findElement(By.xpath("//a[contains(.,'Caravan')]")).click();
                    Thread.sleep(2000);
                    new AIC_Caravan_Trailer(wdriver, test).fn_CaravanTrailer();

                    //Electronic
                    //click("addEELink", "Click Electronic link");
                    wdriver.findElement(By.xpath("//a[contains(.,'Electronic')]")).click();//Electronic link
                    new AIC_Electronic(wdriver, test).fn_ElectronicDetails();
                    Thread.sleep(2000);

                    //Checked buttons and Quote button
                    wdriver.findElement(By.xpath("(//a[@href='#'][contains(.,'Check All')])[2]")).click();//Check All button
                    Thread.sleep(2000);
//                  click("quoteCheckedButton","click quote checked button");//Click quote checked button
                    wdriver.findElement(By.xpath("//a[@href='#'][contains(.,'Quote Checked')]")).click();//Quote checked
                    Thread.sleep(2000);

                    fn_Quoting();
                    break;

                case "PL_REQ_APLUS_010":
                case "iDirect_REQ_idirect_010_SEC29":
                    //Click Add button
                    click("addButton","Add button must be clicked");

                    click("chBoxCT", "Select CT checkbox");//Caravan/Trailer
                    click("chBoxMO", "Select MO checkbox");//Vehicle

                    //Click the add checked button
                    click("addChkButton", "Click add checked button");
                    //click("addVALink", "Click VA link");//Click the link for Vehicle
                    wdriver.findElement(By.xpath("//a[contains(@id,'1')][@title='Edit'][contains(.,'Vehicle')]")).click();
                    Thread.sleep(2000);
                    new AIC_Vehicle(wdriver, test).fn_VehicleDetails();

                    //Caravan/Trailer
//                  click("addCTlink","click Caravan/Trailer link");//Click Caravan/Trailer link
                    wdriver.findElement(By.xpath("//a[contains(@id,'2')][@title='Edit'][contains(.,'Caravan/Trailer')]")).click();
                    Thread.sleep(2000);
                    new AIC_Caravan_Trailer(wdriver, test).fn_CaravanTrailer();

                    wdriver.findElement(By.xpath("(//a[@href='#'][contains(.,'Check All')])[2]")).click();//Click Check All button
                    Thread.sleep(2000);

                    wdriver.findElement(By.xpath("//a[@href='#'][contains(.,'Quote Checked')]")).click();//Click quote checked
                    Thread.sleep(2000);
                    fn_Quoting();

                    break;

                case"PL_REQ_Premium_011":
                case"iDirect_REQ_idirect_011":

                    //Select product(s)
                    click("chBoxHH", "Select HH checkbox");
                    click("chBoxMC", "Select MC checkbox");
                    click("chBoxEE", "Select EE checkbox");
                    click("chBoxWC", "Select WC checkbox");
                    click("chBoxCT", "Select CT checkbox");
                    click("chBoxPA", "Select PA checkbox");
                    click("chBoxAR", "Select AR checkbox");

                    new AIC_Home_Contents(wdriver, test).fn_HomeContentsDetails();
                    new AIC_Motorcycle(wdriver, test).fn_MotorcycleDetails();
//                  new AIC_Electronic(wdriver, test);
                    new AIC_Watercraft(wdriver, test).fn_WatercraftDetails();
                    new AIC_Caravan_Trailer(wdriver, test).fn_CaravanTrailer();
//                  new AIC_Personal_Accident(wdriver, test);
                    new AIC_All_Risk(wdriver, test).fn_AllRiskDetails();

                    break;

                case "PL_REQ_Private_012":
                case "iDirect_REQ_idirect_012":

                    //Select product(s)
                    click("chBoxHH", "Select HH checkbox");
                    click("chBoxEE", "Select EE checkbox");
                    click("chBoxWC", "Select WC checkbox");
                    click("chBoxCT", "Select CT checkbox");
                    click("chBoxPA", "Select PA checkbox");
                    click("chBoxAR", "Select AR checkbox");

                    new AIC_Home_Contents(wdriver, test).fn_HomeContentsDetails();
//                  new AIC_Electronic(wdriver, test);
                    new AIC_Watercraft(wdriver, test).fn_WatercraftDetails();
                    new AIC_Caravan_Trailer(wdriver, test).fn_CaravanTrailer();
//                  new AIC_Personal_Accident(wdriver, test);
                    new AIC_All_Risk(wdriver, test).fn_AllRiskDetails();

                    break;

                case "PL_REQ_APLUS_013":
                case "iDirect_REQ_idirect_013":

                    //Select product(s)
                    click("chBoxHH", "Select HH checkbox");
                    click("chBoxEE", "Select EE checkbox");
                    click("chBoxWC", "Select WC checkbox");
                    click("chBoxPA", "Select PA checkbox");
                    click("chBoxAR", "Select AR checkbox");

                    new AIC_Home_Contents(wdriver, test).fn_HomeContentsDetails();
//                    new AIC_Electronic(wdriver, test);
                    new AIC_Watercraft(wdriver, test).fn_WatercraftDetails();
//                    new AIC_Personal_Accident(wdriver, test);
                    new AIC_All_Risk(wdriver, test).fn_AllRiskDetails();

                    break;

                case "PL_REQ_Premium_014":
                case "iDirect_REQ_idirect_014":

                    //Select product(s)
                    click("chBoxHH", "Select HH checkbox");
                    click("chBoxEE", "Select EE checkbox");
                    click("chBoxPA", "Select PA checkbox");
                    click("chBoxAR", "Select AR checkbox");

                    new AIC_Home_Contents(wdriver, test).fn_HomeContentsDetails();
//                  new AIC_Electronic(wdriver, test);
//                  new AIC_Personal_Accident(wdriver, test);
                    new AIC_All_Risk(wdriver, test).fn_AllRiskDetails();

                    break;

                case "PL_REQ_Private_015":
                case "iDirect_REQ_idirect_015":

                    //Select product(s)
                    click("chBoxHH", "Select HH checkbox");
                    click("chBoxPA", "Select PA checkbox");
                    click("chBoxAR", "Select AR checkbox");

                    new AIC_Home_Contents(wdriver, test).fn_HomeContentsDetails();
//                    new AIC_Personal_Accident(wdriver, test);
                    new AIC_All_Risk(wdriver, test).fn_AllRiskDetails();

                    break;

                case "PL_REQ_APLUS_016":
                case "iDirect_REQ_idirect_016":

                    //Select product(s)
                    click("chBoxHH", "Select HH checkbox");
                    click("chBoxPA", "Select PA checkbox");

                    new AIC_Home_Contents(wdriver, test).fn_HomeContentsDetails();
//                  new AIC_Personal_Accident(wdriver, test);

                    break;

                case "PL_REQ_Premium_017":
                case "iDirect_REQ_idirect_017":

                    //Select product(s)
                    click("chBoxHH", "Select HH checkbox");
                    click("chBoxMC", "Select MC checkbox");
                    click("chBoxHO", "Select HO checkbox");
                    click("chBoxWC", "Select WC checkbox");
                    click("chBoxAR", "Select AR checkbox");

                    new AIC_Home_Contents(wdriver, test).fn_HomeContentsDetails();
                    new AIC_Motorcycle(wdriver, test).fn_MotorcycleDetails();
                    new AIC_Building(wdriver, test).fn_BuildingDetails();
                    new AIC_Watercraft(wdriver, test).fn_WatercraftDetails();
                    new AIC_All_Risk(wdriver, test).fn_AllRiskDetails();

                    break;

                case "PL_REQ_Private_018":
                case "iDirect_REQ_idirect_018":

                    //Select product(s)
                    click("chBoxHH", "Select HH checkbox");
                    click("chBoxMO", "Select MO checkbox");
                    click("chBoxEE", "Select EE checkbox");
                    click("chBoxCT", "Select CT checkbox");
                    click("chBoxPA", "Select PA checkbox");

                    new AIC_Home_Contents(wdriver, test).fn_HomeContentsDetails();
                    new AIC_Motorcycle(wdriver, test).fn_MotorcycleDetails();
//                  new AIC_Electronic(wdriver, test);
                    new AIC_Caravan_Trailer(wdriver, test).fn_CaravanTrailer();
//                  new AIC_Personal_Accident(wdriver, test);

                    break;

                case "PL_REQ_APLUS_019":
                case "iDirect_REQ_idirect_019":

                    //Select product(s)
                    click("chBoxHH", "Select HH checkbox");
                    click("chBoxMC", "Select MC checkbox");
                    click("chBoxWC", "Select WC checkbox");
                    click("chBoxAR", "Select AR checkbox");

                    new AIC_Home_Contents(wdriver, test).fn_HomeContentsDetails();
                    new AIC_Motorcycle(wdriver, test).fn_MotorcycleDetails();
                    new AIC_Watercraft(wdriver, test).fn_WatercraftDetails();
                    new AIC_All_Risk(wdriver, test).fn_AllRiskDetails();

                    break;

                case "PL_REQ_Premium_020":
                case "iDirect_REQ_idirect_020":

                    //Select product(s)
                    click("chBoxHH", "Select HH checkbox");
                    click("chBoxEE", "Select EE checkbox");
                    click("chBoxCT", "Select CT checkbox");
                    click("chBoxPA", "Select PA checkbox");

                    new AIC_Home_Contents(wdriver, test).fn_HomeContentsDetails();
//                  new AIC_Electronic(wdriver, test);
                    new AIC_Caravan_Trailer(wdriver, test);
//                  new AIC_Personal_Accident(wdriver, test);


                    break;

                case "PL_REQ_Private_021":
                case "iDirect_REQ_idirect_021":

                    //Select product(s)
                    click("chBoxHH", "Select HH checkbox");
                    click("chBoxWC", "Select WC checkbox");
                    click("chBoxAR", "Select AR checkbox");

                    new AIC_Home_Contents(wdriver, test).fn_HomeContentsDetails();
                    new AIC_Watercraft(wdriver, test).fn_WatercraftDetails();
                    new AIC_All_Risk(wdriver, test).fn_AllRiskDetails();

                    break;

                case "PL_REQ_APLUS_022":

                    //Select product(s)
                    click("chBoxHH", "Select HH checkbox");
                    click("chBoxEE", "Select EE checkbox");
                    click("chBoxPA", "Select PA checkbox");

                    new AIC_Home_Contents(wdriver, test).fn_HomeContentsDetails();
//                  new AIC_Electronic(wdriver, test);
//                  new AIC_Personal_Accident(wdriver, test);

                    break;

                case "PL_REQ_Premium_023_SEC56":

                    //Click Add button
                    click("addButton","Add button must be clicked");

                    //Select product(s)
                    click("chBoxHH", "Select HH checkbox");//Household Content
                    click("chBoxAR", "Select AR checkbox");//All Risk

                    //Click the add checked button
                    click("addChkButton", "Click add checked button");

                    //Click Add for All Risk
                    click("addARButton", "click AR button");
                    click("chkUAR", "check the UAR product");
                    click("dneButton", "click done button");

                    //link for Home Content
                    click("addHHLink", "Click HH link");
                    Thread.sleep(2000);
                    new AIC_Home_Contents(wdriver, test).fn_HomeContentsDetails();

                    //link for All Risk
                    //click("lnkUAR", "click the UAR link");
                    wdriver.findElement(By.xpath("XPATH|//span[@class='x16z'][contains(.,'Unspecified All Risk')]")).click();
                    Thread.sleep(2000);
                    new AIC_All_Risk(wdriver, test).fn_AllRiskDetails();//Call All Risk Class and function

                    wdriver.findElement(By.xpath("(//a[@href='#'][contains(.,'Check All')])[2]")).click();//Click Check All button
                    Thread.sleep(2000);
//                  click("quoteCheckedButton","click quote checked button");//Click quote checked button
                    wdriver.findElement(By.xpath("//a[@href='#'][contains(.,'Quote Checked')]")).click();//Click quote checked
                    Thread.sleep(2000);
                    fn_Quoting();

                    break;

            }

            productSelection = true;


        }
        catch (Exception e)
        {
            throw e;
        }

        return productSelection;

    }
}
