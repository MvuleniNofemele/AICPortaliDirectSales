package AIC;

import AIC_POM.AIC_Caravan_Trailer_POM;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import utility.WebDr;

public class AIC_Caravan_Trailer extends WebDr {

    public AIC_Caravan_Trailer(WebDriver wdriver, ExtentTest test)
    {
        this.wdriver = wdriver;
        this.test = test;
    }

    public boolean fn_CaravanTrailer() throws Exception
    {
        AIC_Caravan_Trailer_POM.SetPage_CaravanTrailerDetails();
        boolean caravanTrailerDetails = false;

        //General variables
//        String sBuildingRiskAddress = getValue("BuildingRiskAddress");
//        String sBuildingAddressLine2 = getValue("BuildingAddressLine2");
//        String sBuildingSuburb = getValue("BuildingSuburb");
//        String sBuildingCity = getValue("BuildingCity");
//        String sBuildingPostalCode = getValue("BuildingPostalCode");

        String sCaravanTrailerItemType = getValue("CaravanTrailerItemType");
        String sCaravanTrailerParkedAtNight = getValue("CaravanTrailerParkedAtNight");
        String sCaravanTrailerParkedUnderWhenNotInUse = getValue("CaravanTrailerParkedUnderWhenNotInUse");
        String sCaravanTrailerParkedOvernightPlotFarm = getValue("CaravanTrailerParkedOvernightPlotFarm");
        String sCaravanTrailerUsedFor = getValue("CaravanTrailerUsedFor");
        String sCaravanTrailerGoodsCarried = getValue("CaravanTrailerGoodsCarried");

        //Caravan/Trailer variables
        String sCaravanTrailerYearManufacture = getValue("CaravanTrailerYearManufacture");
        String sCaravanTrailerMakeModel = getValue("CaravanTrailerMakeMkodel");

        //Cover variables
        String sCaravanTrailerFinanced = getValue("CaravanTrailerFinanced");
        String sCaravanTrailerFinanceCompany = getValue("CaravanTrailerFinanceCompany");
        String sCaravanTrailerCreditShortfallExtension = getValue("CaravanTrailerCreditShortfallExtension");
        String sCaravanTrailerCaravanContents = getValue("CaravanTrailerCaravanContents");
        String sCaravanTrailerContentsSumInsured = getValue("CaravanTrailerContentsSumInsured");
        String sCaravanTrailerInsuranceValue = getValue("CaravanTrailerInsuranceValue");
        String sCaravanTrailerTotalSumInsured = getValue("CaravanTrailerTotalSumInsured"); //TODO: Verify label amount to against this amount

        //Excess variables
        String sCaravanTrailerCompulsoryExcess = getValue("CaravanTrailerCompulsoryExcess");

        //History variables
        String sUninterruptedCaravanTrailerInsurance = getValue("UninterruptedCaravanTrailerInsurance");
        String sCaravanTrailerClaimTwelveMonth = getValue("CaravanTrailerClaimTwelveMonth");
        String sCaravanTrailerClaimTwentyFourMonth = getValue("CaravanTrailerClaimTwentyFourMonth");
        String sCaravanTrailerClaimThirtySixMonth = getValue("CaravanTrailerClaimThirtySixMonth");

        try
        {
            //General
            select("drDwnItemType","text",sCaravanTrailerItemType,"Select item type"); //Item type
            select("drDwnParkingDuringNight","text",sCaravanTrailerParkedAtNight,""); //Where is the Caravan/Trailer Parked at Night

            if(sCaravanTrailerParkedUnderWhenNotInUse.equalsIgnoreCase("Yes"))
            {
                click("chBxCaravanParkingCondition","Click check box"); //Is the Caravan/Trailer Parked Under a Hail Net or Roof when not in Use
            }

            if(sCaravanTrailerParkedOvernightPlotFarm.equalsIgnoreCase("Yes"))
            {
                click("chBxCaravanParkingDuringNight",""); //Is the Caravan/Trailer Usually Parked Overnight on a Small Holding/ Plot/Farm?
            }

            select("drDwnCaravanUsage","text",sCaravanTrailerUsedFor,"Select caravan trailer usage"); //What will the Caravan/Trailer be Used For?

            if(sCaravanTrailerGoodsCarried.equalsIgnoreCase("Yes"))
            {
                click("chkBxGoodsCarried", "Check box for Goods Carried"); //Are Goods Carried?
            }

            //Caravan/Trailer
            Thread.sleep(2000);
            select("drDwnYeaOfManufacture","text",sCaravanTrailerYearManufacture,"Select caravan trailer year of manufacture"); //Year of manufacture
            setText("txtDwnMake",sCaravanTrailerMakeModel,"Enter make/model "); //Make/Model

            //Cover
            if(sCaravanTrailerFinanced.equalsIgnoreCase("Yes"))
            {
                click("chBxIsCaravanFinanced", "Check box for Caravan/Trailer Financed"); //Is the Caravan/Trailer Financed?
                Thread.sleep(5000);
                select("drDwnFinanceCompany", "text", sCaravanTrailerFinanceCompany,"Select caravan trailer finance company"); //Finance Company
            }

            if(sCaravanTrailerCreditShortfallExtension.equalsIgnoreCase("Yes"))
            {
                click("chBxCreditShortfallExtension","Check box for Credit Shortfall Extension"); //Credit Shortfall Extension
            }

            if(sCaravanTrailerCaravanContents.equalsIgnoreCase("Yes"))
            {
                click("chBxCaravanContents", "Check box caravan contents"); //Caravan Contents
                Thread.sleep(4000);
                setText("txtContentsSumInsured",sCaravanTrailerContentsSumInsured,"Enter Contents Sum Insured"); //Contents Sum Insured
            }

            setText("txtInsuranceValue",sCaravanTrailerInsuranceValue,"Enter Insurance value"); //Insurance value
            //label total sum insured

            //Excess
            select("drDwnFlatExcess","value",sCaravanTrailerCompulsoryExcess,"select Vehicle Compulsory Excess");
            Thread.sleep(3000);

            //History
            if(sUninterruptedCaravanTrailerInsurance.equalsIgnoreCase("Yes"))
            {
                click("chBxUninterruptedCaravanContentsInsurance", "Check box for Uninterrupted Building Insurance"); //Have you had Uninterrupted Building Insurance for the Past 36 months?
            }
            setText("txtNumberClaims12Months", sCaravanTrailerClaimTwelveMonth, "Enter claims in the past 12 months"); //Number of Claims/Losses/Damages in the Past 12 Months
            setText("txtNumberClaims24Months", sCaravanTrailerClaimTwentyFourMonth, "Enter claims in the past 24 months"); //Number of Claims/Losses/Damages in the Past 13 to 24 Months
            setText("txtNumberClaims36Months", sCaravanTrailerClaimThirtySixMonth, "Enter claims in the past 36 months"); //Number of Claims/Losses/Damages in the Past 25 to 36 Months

            Thread.sleep(2000);
            click("ctSaveBtn","click save button for caravan/trailer");

        }
        catch (Exception e)
        {
            throw e;
        }

        return caravanTrailerDetails;
    }
}
