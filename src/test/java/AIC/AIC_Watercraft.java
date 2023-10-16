package AIC;

import AIC_POM.*;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import utility.WebDr;

public class AIC_Watercraft extends WebDr {

    public AIC_Watercraft(WebDriver wdriver, ExtentTest test)
    {
        this.wdriver = wdriver;
        this.test = test;
    }

    public boolean fn_WatercraftDetails() throws Exception
    {
        AIC_Watercraft_POM.SetPage_WatercraftDetails();
        boolean watercraftDetails = false;

        //General Variables
        /*
        String sBuildingRiskAddress = getValue("BuildingRiskAddress");
        String sBuildingAddressLine2 = getValue("BuildingAddressLine2");
        String sBuildingSuburb = getValue("BuildingSuburb");
        String sBuildingCity = getValue("BuildingCity");
        String sBuildingPostalCode = getValue("BuildingPostalCode");

         */
        String sNormallyParkedAddress ="";//= getValue("");
        String sAddressLine2 = "";//getValue("");
        String sSuburb ="10TH AVENUE";// getValue("");
        String sCity = "KWANOBUHLE";//getValue("");
        String sPostalCode = "6242";// getValue("");

        String sWatercraftItemType = getValue("WatercraftItemType");
        String sWatercraftStorageWhenNotUsed = getValue("WatercraftStorageWhenNotUsed");
        String sWatercraftUsage = getValue("WatercraftUsage");
        String sWatercraftUsedForRacingOrRegata = getValue("WatercraftUsedForRacingOrRegata");

        String sWatercraftYearOfManufacture = getValue("WatercraftYearOfManufacture");
        String sWatercraftMakeModel = getValue("WatercraftMakeModel");
        String sWatercraftDescription = getValue("WatercraftDescription");
        String sWatercraftHullLength = getValue("WatercraftHullLength");
        String sWatercraftMaxSpeed = getValue("WatercraftMaxSpeed");
        //Accessories
        String sWatercraftAddAccessory = getValue("WatercraftAddAccessory");
        String sAccessoryName = getValue("AccessoryName");
        String sAccessoryDescription = getValue("AccessoryDescription");
        String sAccessorySumIsured = getValue("AccessorySumIsured");

        String sWatercraftSumInsured = getValue("WatercraftSumInsured");

        String sWatercraftFinanced = getValue("WatercraftFinanced");
        String sWatercraftFinanceCompany = getValue("WatercraftFinanceCompany");
        String sWaterSkiersLiabilityCover = getValue("WaterSkiersLiabilityCover");
        String sWatercraftContentsCover = getValue("WatercraftContentsCover");
        String sWatercraftTotalSumInsure = getValue("WatercraftTotalSumInsure");
        String sContentTotalSumInsure = getValue("ContentTotalSumInsure");
        String sWatercraftCompulsoryExcess = getValue("WatercraftCompulsoryExcess");
        String sUninterruptedWatercraftInsurance = getValue("UninterruptedWatercraftInsurance");
        String sWatercraftClaimPast12Months = getValue("WatercraftClaimPast12Months");
        String sWatercraftClaimPast24Months = getValue("WatercraftClaimPast24Months");
        String sWatercraftClaimPast36Months = getValue("WatercraftClaimPast36Months");

        try
        {
            //General
            select("drDwnItemType","text",sWatercraftItemType,"Select watercraft item type");
            Thread.sleep(2000);
            select("drDwnWatercraftStorage","text",sWatercraftStorageWhenNotUsed,"Select where watercraft is stored when not used");
            Thread.sleep(2000);
            select("drDwnWatercraftUsage","text",sWatercraftUsage,"Select what watercraft is used for");

            if(sWatercraftUsedForRacingOrRegata.equalsIgnoreCase("Yes"))
            {
                click("chBxRacingOrRagata", "Check box Craft be used for Racing or Regata"); //Will the Craft be used for Racing or Regata?
            }

            //Watercraft
            select("drDwnYeaOfManufacture","text",sWatercraftYearOfManufacture,"Select Watercraft year of manufacture");
            setText("txtModelMake",sWatercraftMakeModel,"Enter Watercraft Make/Model");
            select("drDescription","text",sWatercraftDescription,"Select Watercraft description");
            select("drDwnHullLength","text",sWatercraftHullLength,"Select Watercraft hull length");
//            Thread.sleep(1000);
//            setText("txtWatercraftMaxSpeed", sWatercraftMaxSpeed,"Enter Watercraft maximum speed");

            //Add Accessory
            if(sWatercraftAddAccessory.equalsIgnoreCase("Yes"))
            {
                click("btnAddAccss","Click button to Add Accessory");

                    if(sAccessoryName.equalsIgnoreCase("Glitter Finish"))
                    {
                        click("chkBxGlitterFinish","Click Glitter Finish checkbox");//Glitter finish checkbox
                        Thread.sleep(3000);
                        click("btnSelectAccessory","Click button Select accessory");
                    }

                    if(sAccessoryName.equalsIgnoreCase("Diving Equipment"))
                    {
                        click("chkbxFishEquipment","Click Diving Equipment checkbox");//Diving Equipment checkbox
                        Thread.sleep(3000);
                        click("btnSelectAccessory","Click button Select accessory");
                    }

                    if(sAccessoryName.equalsIgnoreCase("Fishing Equipment"))
                    {
                        click("chkbxOtherEquiment","Click Fishing Equipment checkbox");//Fishing Equipment checkbox
                        Thread.sleep(3000);
                        click("btnSelectAccessory","Click button Select accessory");
                    }
                    if(sAccessoryName.equalsIgnoreCase("Guidance Equipment"))
                    {
                        click("chkbxGuidenceEquiment","Click Guidance Equipment checkbox");//Guidance Equipment checkbox
                        Thread.sleep(3000);
                        click("btnSelectAccessory","Click button Select accessory");
                    }
                    if(sAccessoryName.equalsIgnoreCase("Radio Equipment"))
                    {
                        click("chkbxRadioEquiment","Click Radio Equipment checkbox");//Radio Equipment checkbox
                        Thread.sleep(3000);
                        click("btnSelectAccessory","Click button Select accessory");
                    }
                    if(sAccessoryName.equalsIgnoreCase("First Aid Equipment"))
                    {
                        click("chkbxFirstAidEquip","Click First Aid Equipment checkbox");//First Aid Equipment checkbox
                        Thread.sleep(3000);
                        click("btnSelectAccessory","Click button Select accessory");
                    }

                    if(sAccessoryName.equalsIgnoreCase("Life Jacket and Life Saving Equipment"))
                    {
                        click("chkbxLifeJacketEquip","Click First Aid Equipment checkbox");//Life Jacket and Life Saving Equipment checkbox
                        Thread.sleep(3000);
                        click("btnSelectAccessory","Click button Select accessory");
                    }

                //TODO: write logic to select accessory
                setText("txtAreaDescription", sAccessoryDescription,"Enter accessory description");
                setText("txtSumInsured", sAccessorySumIsured,"Enter accessory sum insured");
                Thread.sleep(3000);
            }

            //Cover
            setText("txtWatercraftSumInsured",sWatercraftSumInsured,"Enter Watercraft sum insured");
            Thread.sleep(2000);
            if(sWatercraftFinanced.equalsIgnoreCase("Yes"))
            {
                click("chBxWaterCraftFinanced","Check box for Watercraft Financed"); //Watercraft Sum Insured
                Thread.sleep(3000);
                select("drDwnFinanceCompany","text",sWatercraftFinanceCompany,"Select watercraft finance company"); //Finance Company
                Thread.sleep(2000);
            }

            if(sWaterSkiersLiabilityCover.equalsIgnoreCase("Yes"))
            {
                click("chkBxWaterSkiersLiabilityCover", "Check box for WaterSkiers Liability cover"); //Do you Require Waterskiers Liability Cover?
            }

            if(sWatercraftContentsCover.equalsIgnoreCase("Yes"))
            {
                click("chBxWatercraftContentsCover", "Check box for Watercraft contents cover"); //Do you Require Watercraft Contents Cover?
                Thread.sleep(2000);
                setText("txtContentSumInsured",sContentTotalSumInsure,"set Text Watercraft Contents Sum Insured");
            }

            //Excess
            select("drDwnFlatExcess","value",sWatercraftCompulsoryExcess,"Enter Watercraft Compulsory Excess");

            //History
            if(sUninterruptedWatercraftInsurance.equalsIgnoreCase("Yes"))
            {
                click("chBxUninterruptedVehicleInsurance", "Check box for Uninterrupted Building Insurance"); //Have you had Uninterrupted Building Insurance for the Past 36 months?
            }
            setText("txtNumberClaims12Months", sWatercraftClaimPast12Months, "Enter claims in the past 12 months"); //Number of Claims/Losses/Damages in the Past 12 Months
            setText("txtNumberClaims24Months", sWatercraftClaimPast24Months, "Enter claims in the past 24 months"); //Number of Claims/Losses/Damages in the Past 13 to 24 Months
            setText("txtNumberClaims36Months", sWatercraftClaimPast36Months, "Enter claims in the past 36 months");//Number of Claims/Losses/Damages in the Past 25 to 36 Months
            Thread.sleep(2000);
            click("btnWCSave","click watercraft save button");

        }
        catch (Exception e)
            {
                throw e;
            }

        return watercraftDetails;
    }
}
