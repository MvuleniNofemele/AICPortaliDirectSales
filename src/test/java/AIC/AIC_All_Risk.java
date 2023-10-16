package AIC;

import AIC_POM.AIC_All_Risk_POM;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utility.WebDr;

public class AIC_All_Risk extends WebDr {

    public AIC_All_Risk(WebDriver wdriver, ExtentTest test)
    {
        this.wdriver = wdriver;
        this.test = test;
    }

    public boolean fn_AllRiskDetails() throws Exception
    {
        AIC_All_Risk_POM.SetPage_AllRiskDetails();
        boolean AllRiskDetails = false;
        String sAddress = "Insured";
        //String sPostalCode = getValue("");
        String sDescription = getValue("AllRiskDescription");
        String sSumInsured = getValue("AllRiskSumInsured");
        String sAllRiskExcess = getValue("AllRiskExcess");
        String sNotes = "Test Notes";

        try
        {
            select("drDwnAddress","text",sAddress,"Select Address from Dropdown");

//           exists("lblPostalCode",true,"Verify postal code label");
//           String sPCode = getText("lblPostalCode","Get postal code value from the screen");
//           validateString(sPostalCode,sPCode,"Verify Postal Code Value");
            setText("txtDescription",sDescription,"Enter All Risk Description");
            Thread.sleep(2000);
            //wdriver.findElement(By.xpath("//label[contains(text(),'Sum Insured')]/ancestor::td/following-sibling::td//input")).sendKeys("5000");
            setText("txtSumInsured",sSumInsured,"Enter All Risk Sum Insured");
            select("drDwnFlatExcess","value",sAllRiskExcess,"Select All Risk Compulsory Excess");
            //setText("txtAreaNotes",sNotes,"Enter notes");

            //Click Save button
            click("btnSave", "Click Save button");

            AllRiskDetails = true;

        }
        catch (Exception e)
        {
            throw e;
        }

        return AllRiskDetails;
    }
}
