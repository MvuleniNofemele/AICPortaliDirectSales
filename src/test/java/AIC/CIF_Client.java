package AIC;

import AIC_POM.*;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utility.WebDr;

import java.util.concurrent.ThreadLocalRandom;

public class CIF_Client extends WebDr {

    public CIF_Client(WebDriver wdriver, ExtentTest test)
    {
        this.wdriver = wdriver;
        this.test = test;
    }

    public boolean fn_CreateCampaign() throws Exception
    {
        CIF_Client_POM.SetPage_CIF_Client();
        boolean createCampaign = false;
        String sContactLastName = getValue("Surname");
        String sContactFirstName = getValue("FirstName");
        String sContactIdType = getValue("ID_Type");
        int age = ThreadLocalRandom.current().nextInt(25, 100);
        String gender = (ThreadLocalRandom.current().nextInt(1000, 9999)>=5000 ? "Male" : "Female");
        String sContactIdNumber = GenRSAID(age, gender);
        String sContactBirthDate = GetdiffDate(-19);
        String sContactCellphone = getValue("CellNumber");

        String sCountryOfResidence = getValue("CountryOfResidence");
        String sCountryOfBirth = getValue("CountryOfBirth");
        String sNationality = getValue("Nationality");
        String sOccupation = getValue("Occupation");
        String sSourceOfFunds = getValue("SourceOfFunds");
        String sOccupationStatus = getValue("OccupationStatus");
//        String s = getValue("");
//        String s = getValue("");
//        String s = getValue("");
//        String s = getValue("");



        try
        {
//            click("tabSiebel", "Click Seibel Tab");
            //Navigate to Siebel using URL instead of clicking tab
            String sSiebelTabURL = "http://wimiportalsit.corp.dsarena.com:7777/absaidirectnewbusinessweb/faces/pages/campaigns/siebelFrame.jspx";
            String sNavBackToCampaigns = "http://wimiportalsit.corp.dsarena.com:7777/absaidirectnewbusinessweb/faces/pages/campaigns/campaigns.jspx";
            wdriver.navigate().to(sSiebelTabURL);

            Thread.sleep(10000); // Wait 10 seconds for Siebel page to be ready

            CIF_Client_POM.SetPage_CIF_Client();
            //jsClick("lnkIDirect", "Siebel - Click IDirect Campaign");

//           String text =  wdriver.findElement(By.xpath("//table[@id='s_1_l']/tbody/tr/td/a[contains(text(),'ID idirect')]")).getText();

            //wdriver.findElement(By.xpath("//*[contains(@title,'ID idirect')]//a")).click();

//            jsClick("lnkIDirect", "Click iDirect link");
            //table[@id='s_1_l']//tbody//tr[@class='ui-widget-content jqgrow ui-row-ltr']//td[@title='ID idirect']
            wdriver.findElement(By.xpath("//*[contains(@title,'Dummy Campaign')]//a")).click(); //Click Dummy Campaign link
            click("btnContactProspectNew", "Siebel - Click button to add new contact");
            click("txtContactProspectListApplet", "Siebel - Click Last Name text field");
            click("bntContactProspectListApplet", "Siebel - Click Last Name search button");
            click("bntPickContactNew", "Siebel - Click pick new contact button");

            //fill up pick contact details
            setText("txtPickContactLastName" ,sContactLastName,"Enter Last Name");

            //TODO: Click Contact First Name field to give it focus
            wdriver.findElement(By.xpath("//td[@id='1_s_4_l_First_Name']")).click();
            setText("txtPickContactFirstName" ,sContactFirstName,"Enter First Name");

            //TODO: Click Contact ID Type field to give it focus
            wdriver.findElement(By.xpath("//td[@id='1_s_4_l_Iden_Type']")).click();
            setText("txtPickContactIdType" ,sContactIdType,"Enter ID Type");

            //TODO: Click Contact ID Number field to give it focus
            wdriver.findElement(By.xpath("//td[@id='1_s_4_l_Iden_Information']")).click();
            setText("txtPickContactIdNumber" ,sContactIdNumber,"Enter ID Number");

            if(sContactIdType.equalsIgnoreCase("Passport"))
            {
                //TODO: Click Contact Birth Date field to give it focus
                wdriver.findElement(By.xpath("//td[@id='1_s_4_l_Birth_Date']")).click();
                setText("txtPickContactBirthDate" ,sContactBirthDate,"Enter DOB");
            }

            //TODO: Click Contact Cell Phone field to give it focus
            wdriver.findElement(By.xpath("//td[@id='1_s_4_l_Cellular_Phone__']")).click();
            setText("txtPickContactCellPhone" ,sContactCellphone,"Enter Cellphone Number");
            exists("btnPickContactCancel", true, "Check if Cancel button exist");
            click("btnPickContactOk","Click OK button");

            //Fill details for creating CIF record
            setTextFromList("drDwnCountryOfRes",sCountryOfResidence,"Select Country of Residence"); //Country of Residence:
            setTextFromList("drDwnCountryOfBirth",sCountryOfBirth,"Select Country of Birth"); // Country of Birth:
            setTextFromList("drDwnNationality",sNationality,"Select Nationality"); //Nationality
            setTextFromList("txtOccupationStatus",sOccupationStatus,"Select Occupational Status"); //Occupational Status
            setTextFromList("txtOccupation",sOccupation,"Select Occupation "); // Occupation:

            setText("txtInitials", "", "Enter initials");

            select("drDwnTitle","","","Select title");
            select("drDwnGender","","","Select gender");

            select("drDwnMaritalStatus","","","Select marital status");
            setText("txtEmail","","Enter email");

            select("drDwnSourceOfFunds","","","Select source of funds");

            click("chBxPreEmail", "Check emails box"); //Marketing Preferences

            select("drDwnPreCommMethod","","","Select Preferred Communication Method");

            //TODO: Capture address

        }
        catch (Exception e)
        {
            throw e;
        }

        return createCampaign;
    }

    public void captureAddress()
    {

    }
}
