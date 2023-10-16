package AIC;

import AIC_POM.AIC_Electronic_POM;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import utility.WebDr;

public class AIC_Electronic extends WebDr
{

    public AIC_Electronic(WebDriver wdriver, ExtentTest test)
    {
        this.wdriver = wdriver;
        this.test = test;
    }

    public boolean fn_ElectronicDetails() throws Exception
    {
        AIC_Electronic_POM.SetPage_ElectronicDetails();
        boolean electronicDetail = false;

        String sElectronicAddress =getValue("ElectronicAddress");
//        String sElectronicPostalCode =getValue("ElectronicPostalCode");
        String sElectronicBusinessPurpose =getValue("ElectronicBusinessPurpose");
        String sElectronicType =getValue("ElectronicType");
        String sElectronicMake =getValue("ElectronicMake");
        String sElectronicModel =getValue("ElectronicModel");

        String sElectronicReplacementValue	=getValue("ElectronicReplacementValue");
//        String sElectronicTotalSumInsured	 =getValue("ElectronicTotalSumInsured");
        String sElectronicFlatExcess =getValue("ElectronicFlatExcess");
        String sElectronicNotes =getValue("ElectronicNotes");

        try
        {
            //General
            select("drDwnAddress","text",sElectronicAddress,"Select electronic Address");

            if(sElectronicBusinessPurpose.equalsIgnoreCase("Yes")){
                click("chkBxBusinessPurpose","click Electronic Business Purpose");
            }
            Thread.sleep(2000);
            select("drDwnType","text",sElectronicType,"Select Electronic Type");
            setText("txtMake",sElectronicMake,"Set text Electronic Make");
            setText("txtModel",sElectronicModel,"Set text Electronic Model");
            Thread.sleep(3000);

            //Cover
            setText("txtReplacementValue",sElectronicReplacementValue,"Set text Electronic Replacement Value");

            //Excess
            select("drDwnFlatExcess","value",sElectronicFlatExcess,"Select Electronic Flat Excess");

            //Notes
            setText("txtNotes",sElectronicNotes,"Text area for Electronic");

            click("EleSaveBtn","click Electronic save button");

            electronicDetail = true;
        }catch (Exception e) {
            throw e;
        }

        return electronicDetail;
    }
}
