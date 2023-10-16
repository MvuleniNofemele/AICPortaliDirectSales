package AIC;

import AIC_POM.AIC_Building_POM;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utility.WebDr;

import java.util.concurrent.ThreadLocalRandom;

public class AIC_Building extends WebDr
{
    /*
    public int age = ThreadLocalRandom.current().nextInt(25, 100);
    public String gender = (ThreadLocalRandom.current().nextInt(1000, 9999)>=5000 ? "Male" : "Female");
    public String sSuburb = getValue("Suburb");
    public String sArea_Type = getValue("Area_Type");
    public String sStreetAddress = getValue("StreetAddress");
    //public String sCallBack = getValue("isCallBack");

     */

    public AIC_Building(WebDriver wdriver, ExtentTest test)
    {
        this.wdriver = wdriver;
        this.test = test;
    }

    public boolean fn_BuildingDetails() throws Exception
    {
        AIC_Building_POM.SetPage_BuildingDetails();
        boolean buildingDetails = false;

        //General Variables
        /*
        String sBuildingRiskAddress = getValue("BuildingRiskAddress");
        String sBuildingAddressLine2 = getValue("BuildingAddressLine2");
        String sBuildingSuburb = getValue("BuildingSuburb");
        String sBuildingCity = getValue("BuildingCity");
        String sBuildingPostalCode = getValue("BuildingPostalCode");

         */

        String sBuildingUsage = getValue("BuildingUsage");
        String sTypeOfBuilding = getValue("TypeOfBuilding");
        String sBuildingLocation = getValue("BuildingLocation");
        String sIsBuildingOccupied = getValue("IsBuildingOccupied");
        String sDateSinceOccupied = getValue("DateSinceOccupied");
        String sConsecutiveUnoccupiedDays	 = getValue("ConsecutiveUnoccupiedDays");
         String sNumOfGeysers = getValue("NumOfGeysers");
        //String sGASAppliances = getValue("GASAppliances");

        //General
       //setText("txtAddressLine2", sBuildingAddressLine2, "Enter Address Line 2");

        select("drDwnBuildingUsage","text",sBuildingUsage,"Select building usage");
        select("drDwnTypeOfBuilding","text",sTypeOfBuilding,"Select type building");
        select("drDwnTypeOfArea","text",sBuildingLocation,"Select building type of location");

        if(sIsBuildingOccupied.equalsIgnoreCase("Yes"))
        {
            click("chBxBuildingOccupied","Is the Building Occupied?"); //Is the Building Occupied?
            //setText("txtOccupiedSinceDate",sDateSinceOccupied,"Enter date since occupied for building");//Occupied Since Date PL
        }
        setText("txtUnoccupiedDays",sConsecutiveUnoccupiedDays,"Enter number of Consecutive Unoccupied Days"); //Number of Consecutive Unoccupied Days
        setText("txtNumberOfGeysers",sNumOfGeysers,"Enter number of Consecutive Unoccupied Days"); //Number of Geysers in Building and Outbuilding

        /*
        if(sIsBuildingOccupied.equalsIgnoreCase("Yes"))
        {
            click("chBxGASappliances","Check box of Is building occupied"); //Is Building occupied
        }
         */

        //Building Construction Details
        String sBuildingWallConstruction = getValue("BuildingWallConstruction");
        String sBuildingRoofConstruction = getValue("BuildingRoofConstruction");
        String sBuildingThatchedLapa = getValue("BuildingThatchedLapa");
        String sBuildingLapaHutFloor = getValue("BuildingThatchedLapaHutFloor");
        String sLightningRod = getValue("BuildingSABSApprovedLightning");

        //Cover
        //String sBuildingCoverType = getValue("BuildingCoverType");
        String sBuildingBond = getValue("BuildingBond");
        String sBuildingFinanceCompany = getValue("BuildingFinanceCompany");
        String sBuildingSumInsured = getValue("BuildingSumInsured");

        //Excess
        String sBuildingCompulsory = getValue("BuildingFlatExcess");

        //Building history
        String sUninterruptedBuildingInsurance = getValue("UninterruptedBuildingInsurance");
        String sBuildingClaimTwelveMonth = getValue("BuildingClaimTwelveMonth");
        String sBuildingClaimTwentyFourMonth = getValue("BuildingClaimTwentyFourMonth");
        String sBuildingClaimThirtySixMonth = getValue("BuildingClaimThirtySixMonth");

        try
        {
            //Building Construction Details
            select("drDwnWallConstruction","text",sBuildingWallConstruction,"Select wall construction type"); //Wall construction
            select("drDwnRoofConstruction","text",sBuildingRoofConstruction,"Select roof construction type"); //Roof construction

            if(sBuildingThatchedLapa.equalsIgnoreCase("Yes"))
            {
                click("chBxThatch3meters", "Check box for Lapa within 3 meters"); //Is there a Thatched Lapa within 3 meters of the Main Dwelling?
            }

            Thread.sleep(2000);
            select("drDwnThatchLapa","text",sBuildingLapaHutFloor,"Select Lapa Hut Floor"); //Thatched Lapa Hut Floor Area
            Thread.sleep(2000);
      //    wdriver.findElement(By.xpath("//select[@title='Please Select']/ancestor::td/preceding-sibling::td/label[contains(text(),'Floor Area')]/ancestor::td/following-sibling::td/select")).sendKeys("Lapa more than 25% of the Main Dwelling");

            if(sLightningRod.equalsIgnoreCase("Yes"))
            {
                wdriver.findElement(By.xpath("XPATH|//input[(@type='checkbox')]/ancestor::td/preceding-sibling::td/label[contains(text(),'lightning conductor?')]/ancestor::td/following-sibling::td/span/span/input")).click();
                //click("chBxSABSLightningConductor", "Do you have a SABS approved lightning conductor?"); //Do you have a SABS approved lightning conductor?
            }

            //Cover
            //select("drDwnCoverType","text",sBuildingCoverType,"Select Cover Type"); // Building Cover type
            select("drDwnBondApplicable","text",sBuildingBond,"Select Building bond Type"); // Is or was there a bond applicable to this house?
            Thread.sleep(2000);
            if(sBuildingBond.equalsIgnoreCase("Yes - Closed Bond") || sBuildingBond.equalsIgnoreCase("Yes - Open Bond"))
            {
                Thread.sleep(3000);
                select("drDwnFinanceCompany","text",sBuildingFinanceCompany,"Select Building Finance Company"); //Finance Company
            }

            Thread.sleep(2000);
            setText("txtBuildingSumInsured",sBuildingSumInsured,"Enter building sum insured"); //Sum Insured of Building

            //Excess
            select("drDwnFlatExcess","value",sBuildingCompulsory, "Enter Building Excess");

            //History
            if(sUninterruptedBuildingInsurance.equalsIgnoreCase("Yes"))
            {
                click("chBxUninterruptedVehicleInsurance", "Check box for Uninterrupted Building Insurance"); //Have you had Uninterrupted Building Insurance for the Past 36 months?
            }

            setText("txtNumberClaims12Months",sBuildingClaimTwelveMonth, "Enter claims in the past 12 months"); //Number of Claims/Losses/Damages in the Past 12 Months
            setText("txtNumberClaims24Months",sBuildingClaimTwentyFourMonth, "Enter claims in the past 24 months"); //Number of Claims/Losses/Damages in the Past 13 to 24 Months
            setText("txtNumberClaims36Months",sBuildingClaimThirtySixMonth, "Enter claims in the past 36 months"); //Number of Claims/Losses/Damages in the Past 25 to 36 Months
            Thread.sleep(2000);
            click("btnBSave","click building save button");
            Thread.sleep(4000);

        }
        catch (Exception e)
        {
            throw e;
        }

        return buildingDetails;
    }

}

