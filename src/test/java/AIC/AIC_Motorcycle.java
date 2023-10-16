package AIC;

import AIC_POM.*;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utility.WebDr;

public class AIC_Motorcycle extends WebDr {

    public AIC_Motorcycle(WebDriver wdriver, ExtentTest test)
    {
        this.wdriver = wdriver;
        this.test = test;
    }

    public boolean fn_MotorcycleDetails() throws Exception
    {
        AIC_Motorcycle_POM.SetPage_MotorCycleDetails();
        boolean motorcycleDetails = false;
/*
        String sNormallyParkedAddress = getValue("");
        String sAddressLine2 = getValue("");
        String sSuburb = getValue("");
        String sCity = getValue("");
        String sPostalCode = getValue("");

 */
        String sNormallyParkedAddress ="";//= getValue("");
        String sAddressLine2 = "";//getValue("");
        String sSuburb ="10TH AVENUE";// getValue("");
        String sCity = "KWANOBUHLE";//getValue("");
        String sPostalCode = "6242";// getValue("");

        String sParkingDuringDay = getValue("MCParkingDuringDay");
        String sDaytimeParkingCovered = getValue("DaytimeParkingCovered");
        String sNightTimeParkingLike = getValue("NightTimeParkingLike");
        String sNightTimeParkingCovered = getValue("NightTimeParkingCovered");
        String sMotorcycleUsedFor = getValue("VehicleUsedFor");
        String sNightParkingAtFarmOrPlot = getValue("MCNightParkingAtFarmOrPlot");
        String sIsMotorcycleCarryingGoods = getValue("IsMotorcycleCarryingGoods");

        String sTrackingDevice = getValue("MCTrackingDevice");
        String sTrackingDeviceMake = getValue("MCTrackingDeviceMake");
        //Flat
        String sMotorcycleCompulsory = getValue("MotorcycleFlatExcess");

        String sIsMotorcycleNew = getValue("IsMotorcycleNew");
        String sMotorcycleYeaOfManufacture = getValue("MotorcycleYeaOfManufacture");
        String sMotorcycleMake = getValue("MotorcycleMake");
        String sMotorcycModel = getValue("MotorcycleModel");
        String sMotorcycType = getValue("MotorcycType");
        String sMotorCycleUsage = getValue("MotorCycleUsage");

        String sCoverType = getValue("MCCoverType");
        String sRetailOrCustomValue = getValue("MCRetailOrCustomValue");
        String sMotorcycleCustomValue = getValue("MCVehicleCustomValue");
        String sMotorcycleFinanced = getValue("MotorcycleFinanced");
        String sMotorcycleFinancedHouse = getValue("MotorcycleFinancedHouse");
        String sCreditShortFallExtension = getValue("CreditShortFallExtension");

        String sUninterruptedMotorcyclensurance = getValue("UninterruptedMotorcyclensurance");
        String sCurrentlyInsured = getValue("CurrentlyInsured");
        String sInsuranceDuration = getValue("MCInsuranceDuration");
        String sMotorcycleClaimTwelveMonth = getValue("MotorcycleClaimTwelveMonth");
        String sMotorcycleClaimTwentyFourMonth = getValue("MotorcycleClaimTwentyFourMonth");
        String sMotorcycleClaimThirtySixMonth = getValue("MotorcycleClaimThirtySixMonth");
        String sNoClaimsBonus = getValue("SelectNoClaimsBonus");

        String sRegisteredOwner = getValue("MCRegisteredOwner");
//        String sRegOwnerName = getValue("RegOwnerName");
//        String sRegOwnerSurname = getValue("RegOwnerSurname");
//        String sRegisteredOwnerName = sRegOwnerName.concat(sRegOwnerSurname);
//        String sRegisteredOwnerIDorPP = getValue("RegOwnerIDorPP");
//        String sRegisteredOwnerDOB = getValue("RegOwnerDateOfBirth");
//        String sRegisteredOwnerMaritalStatus = getValue("RegOwnerMaritalStatus");

        String sRegularDriver = getValue("RegularDriver");
//        String sRegularFirstName = getValue("driverFirstName");
//        String sRegularDriverLastName = getValue("driverLastName");
//        String sRegularDriverDOB = getValue("RegularDriverDOB");
//        String sRegularDriverGender = getValue("RegularDriverGender");
//        String sRegularDriverMaritalStatus = getValue("RegularDriverMaritalStatus");
        String sRegularDriverLicenseType = getValue("MCRegularDriverLicenseType");
        String sRegularDriverLicenseDate = getValue("RegularDriverLicenseDate");
//       String sRegularDriverDefensiveDriving = getValue("RegularDriverDefensiveDriving");

        try
        {

            //General
//            setText("txtNormallyParkedAddress",sNormallyParkedAddress,"Enter Vehicle Parking Address");
//            setText("txtAddressLine2",sAddressLine2,"Enter Address Line 2");
//            setText("txtSuburb",sSuburb,"Enter Suburb");
//            setText("txtCity",sCity,"Enter City");
//            setText("txtPostalCode",sPostalCode,"Enter Postal Code");

            //click("btnClear","click clear button");
//            wdriver.findElement(By.xpath("XPATH|//button[contains(@title,'Clear Suburb, City, Postal Code')]")).click();//clear button
//            Thread.sleep(2000);
//            wdriver.findElement(By.xpath("XPATH|//button[contains(@title,'Lookup Suburb, City, Postal Code')]")).click();//button lookup
//            //click("btnLookup","click lookup button");
//            Thread.sleep(2000);
//            wdriver.findElement(By.xpath("XPATH|//td[@align='center'][contains(.,'45TH CUTTING')]")).click();//address link
//            //click("lnkAddress","click address link");
//            Thread.sleep(2000);

            select("drDwnParkingDuringDay", "text", sParkingDuringDay,"Select parking during day");
            select("drDwnDaytimeParkingCovered", "text", sDaytimeParkingCovered,"Select for daytime parking covering");
            select("drDwnParkingDuringNight", "text", sNightTimeParkingLike,"Select parking during night");
            select("drDwnNightTimeParkingCovered", "text", sNightTimeParkingCovered,"Select for night time parking covering");
            //click("chBxParkOverNight","Click checkbox for vehicle parking at night");
            //select("drDwnVehicleUsage", "text", sMotorcycleUsedFor,"Select Motorcycle usage");

            if(sNightParkingAtFarmOrPlot.equalsIgnoreCase("Yes"))
            {
                click("chBxParkingAtFarmOrPlot", "Check box for night time parking at plot or farm");
            }

            if(sIsMotorcycleCarryingGoods.equalsIgnoreCase("Yes"))
            {
                click("chBxGoodsCarried","Click checkbox for vehicle parking at night");
            }

            select("drDwnMotorCycleUsage","text",sMotorCycleUsage,"Select What will the Motorcycle be Used For?");//Select What will the Motorcycle be Used For?

            //Motorcycle
            if(sIsMotorcycleNew.equalsIgnoreCase("New"))
            {
                click("chBxNewMotorCycle","Is this a new Motorcycle");//Is this a new Motorcycle?
            }

            select("drDwnYeaOfManufacture", "text", sMotorcycleYeaOfManufacture, "Select vehicle year of manufacture"); //Year of manufacture
            Thread.sleep(5000);
            select("drDwnMake", "text", sMotorcycleMake, "Select motorcycle make");//Make
            Thread.sleep(2000);
            select("drDwnModelVariant", "text", sMotorcycModel, "Select motorcycle model");//Model variant
            Thread.sleep(3000);
            select("drDwnType", "text", sMotorcycType, "Select motorcycle type");//motorcycle type
            Thread.sleep(3000);

            //Cover
            select("drDwnCoverType","text",sCoverType,"Select Cover Type"); //Cover type
            Thread.sleep(2000);
            select("drDwnRetailOrCustomValue","text",sRetailOrCustomValue,"Select "); //Do you want to be insured for the retail or custom value of the vehicle?

            if(sRetailOrCustomValue.equalsIgnoreCase("Custom Value"))
            {
                setText("txtInsuranceValue", sMotorcycleCustomValue,"Enter Vehicle Custom Value");
            }
/*
            else{
                String sRetailValue = wdriver.findElement(By.tagName("lblInsuranceValue")).getText();
                validateString("NOT BLANK", sRetailValue,"Verify Vehicle Retail Value");
            }

            String sValueOfAccessories = getElement("lblTotalValueOfAccessories").getText();
            validateString("NOT BLANK", sValueOfAccessories,"Verify Vehicle Retail Value");

            String sSumInsured = getElement("lblVehicleSumInsured").getText();
            validateString("NOT BLANK", sSumInsured,"Verify Vehicle Retail Value");

 */

            if(sMotorcycleFinanced.equalsIgnoreCase("Yes"))
            {
                click("chBxIsMotorCycleFinanced", "Click motorcycle Finance");
                //click("chBxIsVehicleFinanced", "Click Vehicle Finance");
                Thread.sleep(3000);
                select("drDwnFinanceCompany","text", sMotorcycleFinancedHouse, "Select Vehicle Finance House");

                if(sCreditShortFallExtension.equalsIgnoreCase("Yes"))
                {
                    click("chBxCreditShortfallExtension", "Select Credit Shortfall"); //Credit shortfall extension
                }
            }
            /*else
            {
                click("chBxIsVehicleFinanced", "Click Vehicle Finance"); //Click the checkbox to deselect it
            }
             */

            //Security
            if(sTrackingDevice.equalsIgnoreCase("Yes"))
            {
                click("chBxTrackingDevice","Select Tracking device Option"); //Tracking device
                Thread.sleep(1000);
                select("drDwnTrackingDeviceMake", "text", sTrackingDeviceMake, "Check box for tracking device"); //Tracking device make
            }

            //Excess
            select("drDwnFlatExcess", "value", sMotorcycleCompulsory, "select Flat Excess");
           //setText("txtCompulsoryExcess", sMotorcycleCompulsory, "Enter Vehicle Compulsory Excess");

            //History
            if(sUninterruptedMotorcyclensurance.equalsIgnoreCase("Yes"))
            {
                click("chBxUninterruptedMotorcycleInsurance","Select dropdown for uninterrupted motorcycle insurance"); //Have you had Uninterrupted Vehicle Insurance for the Past 36 Months?
            }

            if(sCurrentlyInsured.equalsIgnoreCase("Yes"))
            {
                click("chBxCurrentlyInsured","Select dropdown for currently insured "); //Are you Currently Insured?
                select("drDwnInsuranceDuration", "text", sInsuranceDuration, "Select insurance duration"); //What is the Duration of your Current Insurance?
            }


            setText("txtNumberClaims12Months", sMotorcycleClaimTwelveMonth, "Enter claims in the past 12 months"); //Number of Claims/Losses/Damages in the Past 12 Months
            setText("txtNumberClaims24Months", sMotorcycleClaimTwentyFourMonth, "Enter claims in the past 24 months"); //Number of Claims/Losses/Damages in the Past 13 to 24 Months
            setText("txtNumberClaims36Months", sMotorcycleClaimThirtySixMonth, "Enter claims in the past 36 months"); //Number of Claims/Losses/Damages in the Past 25 to 36 Months

           /* if(sNoClaimsBonus.equalsIgnoreCase("Yes"))
            {
                click("chBxNoClaimsBonus","Select African Traveller Option"); //No claim bonus
            }
            */


            //Registered Owner
            if(sRegisteredOwner.equalsIgnoreCase("Insured"))
            {
                select("drDwnRegisteredOwner","text",sRegisteredOwner,"Select Registered Owner"); //Registered Owner
//                String sOwnerName = wdriver.findElement(By.tagName("txtRegisteredOwnerName")).getText();
//                String sOwnerIDorPassport = wdriver.findElement(By.tagName("txtRegisteredOwnerIDNumberPassport")).getText();
//                String sOwnerDOB = wdriver.findElement(By.tagName("txtRegisteredOwnerDateOfBirth")).getText();
//                String sOwnerMaritalStatus = wdriver.findElement(By.tagName("drDwnRegisteredOwnerMaritalStatus")).getText();
//
//                validateString(sRegisteredOwnerName,sOwnerName,"Verify Registered Owner Name");
//                validateString(sRegisteredOwnerIDorPP,sOwnerIDorPassport,"Verify Registered Owner ID/Passport");
//                validateString(sRegisteredOwnerDOB,sOwnerDOB,"Verify Registered Owner DOB");
//                validateString(sRegisteredOwnerMaritalStatus,sOwnerMaritalStatus,"Verify Registered Owner Marital Status");
            }

          /*  else
            {
                select("drDwnRegisteredOwner","text",sRegisteredOwner,"Select Registered Owner"); //Registered Owner
                setText("txtRegisteredOwnerName",sRegisteredOwnerName,"Enter Registered Owner Name");
                setText("txtRegisteredOwnerIDNumberPassport",sRegisteredOwnerIDorPP,"Enter Registered Owner ID or Passport");
                setText("txtRegisteredOwnerDateOfBirth",sRegisteredOwnerDOB,"Enter Registered Owner Date of Birth");
                select("drDwnRegisteredOwnerMaritalStatus", "text", sRegisteredOwnerMaritalStatus,"Enter Registered Owner Marital Status");
            }
           */

            //Driver

            if(sRegularDriver.equalsIgnoreCase("Insured")) {
                Thread.sleep(2000);
                select("drDwnRegularDriver", "text", sRegularDriver, "Select regular driver"); //Who is the regular driver?
                Thread.sleep(3000);
                select("drDwnRegularDriverLicenseType","text",sRegularDriverLicenseType,"Select regular driver license type"); //Regular Driver License Type
                setText("txtRegularDriverLicenseDate",sRegularDriverLicenseDate,"Enter regular driver license date"); //Regular Driver License Date
//                wdriver.findElement(By.xpath("/html[1]/body[1]/div[1]/form[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[3]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[9]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[9]/td[2]/input[1]")).sendKeys(sRegularDriverLicenseDate);
                Thread.sleep(2000);
                click("mcSaveBtn","click save button for vehicle");
            }
//                String sRegularName = wdriver.findElement(By.tagName("lblRegularDriverName")).getText();
//                String sRegularIDorPassport = wdriver.findElement(By.tagName("lblRegularDriverId")).getText();
//                String sRegularDOB = wdriver.findElement(By.tagName("lblRegularDriverDOB")).getText();
//
//                //Verify the Regular driver details are same as Registered owner
////                validateString(sRegisteredOwnerName,sRegularName,"Verify Registered Owner Name");
////                validateString(sRegisteredOwnerIDorPP,sRegularIDorPassport,"Verify Registered Owner ID/Passport");
////                validateString(sRegisteredOwnerDOB,sRegularDOB,"Verify Registered Owner DOB");
//            }
//            else
//            {
//                select("drDwnRegularDriver","text",sRegularDriver,"Select regular driver"); //Who is the regular driver?
//                setText("txtRegularDriverName",sRegularFirstName,"Enter regular driver name"); //Regular Driver Name
//                setText("txtRegularDriverId",sRegularDriverLastName,"Enter regular driver last name"); //Regular Driver ID/Passport Number
//                setText("txtRegularDriverDOB",sRegularDriverDOB,"Enter regular driver DOB"); //Regular Driver Date of Birth
//                select("drDwnRegularDriverGender","text",sRegularDriverGender,"Select regular driver gender"); //Regular Driver Gender
//                select("drDwnRegularDriverMaritalStatus","text",sRegularDriverMaritalStatus,"Select regular driver marital status"); //Regular Driver Marital Status
//                select("drDwnRegularDriverLicenseType","text",sRegularDriverLicenseType,"Select regular driver license type"); //Regular Driver License Type
//                setText("txtRegularDriverLicenseDate",sRegularDriverLicenseDate,"Enter regular driver license date"); //Regular Driver License Date
//                select("drDwnDefensiveDriving","text",sRegularDriverDefensiveDriving,"Select regular driver defensive driving"); //Defensive driving certificate
//            }

        }
        catch (Exception e)
        {
            throw e;
        }

        return motorcycleDetails;
    }
}
