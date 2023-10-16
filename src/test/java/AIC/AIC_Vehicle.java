package AIC;

import AIC_POM.AIC_Vehicle_POM;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utility.WebDr;

import java.util.concurrent.ThreadLocalRandom;

public class AIC_Vehicle extends WebDr {

    public String sSAID_Passport = "";
    public String sBirthDate = "";
    public String sGender = "";


    public int age = ThreadLocalRandom.current().nextInt(25, 100);
    public String gender = (ThreadLocalRandom.current().nextInt(1000, 9999)>=5000 ? "Male" : "Female");

    public AIC_Vehicle(WebDriver wdriver, ExtentTest test) {
        this.wdriver = wdriver;
        this.test = test;
    }

    public boolean fn_VehicleDetails() throws Exception
    {
        AIC_Vehicle_POM.SetPage_VehicleDetails();
        boolean vehicleDetails = false;

        String sFirstName = getValue("FirstName");

        String sNormallyParkedAddress ="";//= getValue("");
        String sAddressLine2 = "";//getValue("");
        String sSuburb ="10TH AVENUE";// getValue("");
        String sCity = "KWANOBUHLE";//getValue("");
        String sPostalCode = "6242";// getValue("");

        String sParkingDuringDay = getValue("ParkingDuringDay");
        String sDaytimeParkingCovered = getValue("DaytimeParkingCovered");
        String sNightTimeParkingLike = getValue("NightTimeParkingLike");
        String sNightTimeParkingCovered = getValue("NightTimeParkingCovered");
        String sVehicleUsedFor = getValue("VehicleUsedFor");
        String sNightParkingAtFarmOrPlot = getValue("NightParkingAtFarmOrPlot");

        //Accessories
        String sVehicleAddAccessory = getValue("VehicleAddAccessory");
        String sVehicleAccessoryName = getValue("VehicleAccessoryName");
        String sVehicleAccessoryDescription = getValue("VehicleAccessoryDescription");
        String sVehicleAccessorySumIsured = getValue("VehicleAccessorySumIsured");

        String sIsVehicleCarryingGoods = getValue("VehicleCarryGoods");
        String sVehicleYeaOfManufacture = getValue("VehicleYeaOfManufacture");
        String sVehicleMake = getValue("VehicleMake");
        String sVehicleModel = getValue("VehicleModel");
        String sVehicleModified = getValue("VehicleModified");
        String sVehicleRebuilt = getValue("VehicleRebuilt");
        String sWindscreenDamage = getValue("WindscreenDamage");
        String sExistingDamages = "No";
//      String sIsVehicleNew = getValue("Vehicle_New_Or_Used");
        String sCoverType = getValue("CoverType");
        String sRetailOrCustomValue = getValue("VehicleValue");
        String sVehicleCustomValue = getValue("VehicleCustomValue");
        String sVehicleFinanced = getValue("isVehicleFinanced");
        String sVehicleFinancedHouse = getValue("VehicleFinancedHouse");
        String sRequireAfricanTraveller = "No";
        String sExcludeOffRoad = "No";
        String sCreditShortFallExtension = getValue("CreditShortFallExtension");
        String sCarHire = getValue("addCarHire");
        String sCarHireType = getValue("CarHireType");

        String sImmobiliser = getValue("Immobiliser");
        String sImmobiliserMake = getValue("ImmobiliserMake");
        String sTrackingDevice = getValue("TrackingDevice");
        String sTrackingDeviceMake = getValue("TrackingDeviceMake");

        String sVehicleFlatExcess = getValue("VehicleFlatExcess");
//      String sVehicleCompulsory = getValue("VehicleCompulsoryExcess");

        String sUninterruptedVehicleInsurance = getValue("UninterruptedVehicleInsurance");
        String sCurrentlyInsured = getValue("CurrentlyInsured");
        String sInsuranceDuration = getValue("InsuranceDuration");
        String sVehicleClaimTwelveMonth = getValue("VehicleClaimTwelveMonth");
        String sVehicleClaimTwentyFourMonth = getValue("VehicleClaimTwentyFourMonth");
        String sVehicleClaimThirtySixMonth = getValue("VehicleClaimThirtySixMonth");
        String sNoClaimsBonus = getValue("SelectNoClaimsBonus");

       String sRegisteredOwner = getValue("RegisteredOwner");
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

        String sRegularDriverLicenseType = getValue("RegularDriverLicenseType");
        String sRegularDriverLicenseDate = getValue("RegularDriverLicenseDate");
        String sRegularDriverDefensiveDriving = getValue("RegularDriverDefensiveDriving");

        try
        {
            //General

//            setText("txtNormallyParkedAddress",sNormallyParkedAddress,"Enter Vehicle Parking Address");
//            setText("txtAddressLine2",sAddressLine2,"Enter Address Line 2");
//            setText("txtSuburb",sSuburb,"Enter Suburb");
//            setText("txtCity",sCity,"Enter City");
//            setText("txtPostalCode",sPostalCode,"Enter Postal Code");


            select("drDwnParkingDuringDay", "text", sParkingDuringDay,"Select parking during day");
            select("drDwnDaytimeParkingCovered", "text", sDaytimeParkingCovered,"Select for daytime parking covering");
            select("drDwnParkingDuringNight", "text", sNightTimeParkingLike,"Select parking during night");
            select("drDwnNightTimeParkingCovered", "text", sNightTimeParkingCovered,"Select for night time parking covering");
            //click("chBxParkOverNight","Click checkbox for vehicle parking at night");
            select("drDwnVehicleUsage", "text", sVehicleUsedFor,"Select vehicle usage");

            if(sNightParkingAtFarmOrPlot.equalsIgnoreCase("Yes"))
            {
                click("chBxParkingAtFarmOrPlot", "Check box for night time parking at plot or farm");
            }


            if(sIsVehicleCarryingGoods.equalsIgnoreCase("Yes"))
            {
                click("chBxGoodsCarried","Click checkbox for vehicle parking at night");
            }

            //Vehicle
            click("chBxNewVehicle","click is the new vehicle checkbox"); //Is this a new vehicle?
            Thread.sleep(3000);
            /*
            if(sIsVehicleNew.equalsIgnoreCase("New"))
            {
                click("chBxNewVehicle","click is the new vehicle checkbox"); //Is this a new vehicle?
            }
            */

            select("drDwnYeaOfManufacture", "text", sVehicleYeaOfManufacture, "Select vehicle year of manufacture"); //Year of manufacture
            Thread.sleep(3000);
            select("drDwnMake", "text", sVehicleMake, "Select vehicle make"); //Make
            Thread.sleep(3000);
            select("drDwnModelVariant", "text", sVehicleModel, "Select vehicle model"); //Model variant PL
            //wdriver.findElement(By.xpath("//select[contains(@name,'templ:t_r_con:1:model_variant')]")).sendKeys("A1 1.0T FSI SE 3DR");

            if(sVehicleModified.equalsIgnoreCase("Yes"))
            {
                click("chBxVehicleModified","Check box for modified vehicle"); //Has this Vehicle’s Engine been Modified to Enhance its Performance?
            }

            if(sVehicleRebuilt.equalsIgnoreCase("Yes"))
            {
                click("chBxVehicleRebuilt","Check box for rebuilt vehicle"); //s this Vehicle Rebuilt (Code 3)?
            }

            if(sWindscreenDamage.equalsIgnoreCase("Yes"))
            {
                click("chExistingWindscreenDamage","Check box for windscreen damage"); //Are there Pre-existing Windscreen Damages?
            }

            if(sExistingDamages.equalsIgnoreCase("Yes"))
            {
                click("chBxOtherExistingDamages","Check box for other existing damages"); //Are there Pre-existing Other Damages?
            }

            //Accessories
            select("drDwnSound", "text", "Not Required", "Select sound option"); //Sound

            if(sVehicleAddAccessory.equalsIgnoreCase("Yes"))
            {
                click("btnAddAccss","Click button to Add Accessory");
                Thread.sleep(4000);

                if(sVehicleAccessoryName.equalsIgnoreCase("Sound System"))
                {
                    click("chbxSoundSystem","Click Sound System checkbox");//Sound System
                    Thread.sleep(3000);
                    click("btnSelectAccessory","Click button Select accessory");
                }

                if(sVehicleAccessoryName.equalsIgnoreCase("Bluetooth"))
                {
                    click("chbxBluetooth","Click Bluetooth checkbox");//Bluetooth checkbox
                    Thread.sleep(3000);
                    click("btnSelectAccessory","Click button Select accessory");
                }

                if(sVehicleAccessoryName.equalsIgnoreCase("Sunroof"))
                {
                    click("chbxSunroof","Click Sunroof checkbox");//Sunroof checkbox
                    Thread.sleep(3000);
                    click("btnSelectAccessory","Click button Select accessory");
                }
                if(sVehicleAccessoryName.equalsIgnoreCase("Bullbar"))
                {
                    click("chbxBullbar","Click Bullbar checkbox");//Bullbar checkbox
                    Thread.sleep(3000);
                    click("btnSelectAccessory","Click button Select accessory");
                }
                if(sVehicleAccessoryName.equalsIgnoreCase("Electric Windows"))
                {
                    click("chbxElectricWindow","Click Electric Windows checkbox");//Electric Windows checkbox
                    Thread.sleep(3000);
                    click("btnSelectAccessory","Click button Select accessory");
                }
                if(sVehicleAccessoryName.equalsIgnoreCase("Side Skirting"))
                {
                    click("chbxSideSkirting","Click Side Skirting checkbox");//Side Skirting checkbox
                    Thread.sleep(3000);
                    click("btnSelectAccessory","Click button Select accessory");
                }

                if(sVehicleAccessoryName.equalsIgnoreCase("Nudge Bar"))
                    {
                        click("chbxNudgeBar","Click Nudge Bar checkbox");//Nudge Bar checkbox
                        Thread.sleep(3000);
                        click("btnSelectAccessory","Click button Select accessory");
                    }
                if(sVehicleAccessoryName.equalsIgnoreCase("Smash and Grab"))
                    {
                        click("chbxSmashGrab","Click Smash and Grab checkbox");//Smash and Grab checkbox
                        Thread.sleep(3000);
                        click("btnSelectAccessory","Click button Select accessory");
                    }

                if(sVehicleAccessoryName.equalsIgnoreCase("Park Distance Control (PDC)"))
                {
                    click("chbxPDC","Click Park Distance Control (PDC) checkbox");//Park Distance Control (PDC) checkbox
                    Thread.sleep(3000);
                    click("btnSelectAccessory","Click button Select accessory");
                }
                if(sVehicleAccessoryName.equalsIgnoreCase("Lock DIFF (Double Cab)"))
                    {
                        click("chbxLockDiff","Click Lock DIFF (Double Cab) checkbox");//Lock DIFF (Double Cab) checkbox
                        Thread.sleep(3000);
                        click("btnSelectAccessory","Click button Select accessory");
                    }
                if(sVehicleAccessoryName.equalsIgnoreCase("Sports Suspension"))
                    {
                        click("chbxSportSuspension","Click Sports Suspension checkbox");//Sports Suspension checkbox
                        Thread.sleep(3000);
                        click("btnSelectAccessory","Click button Select accessory");
                    }
                if(sVehicleAccessoryName.equalsIgnoreCase("LED Headlamps"))
                    {
                        click("chbxLEDHeadlamps","Click LED Headlamps checkbox");//LED Headlamps checkbox
                        Thread.sleep(3000);
                        click("btnSelectAccessory","Click button Select accessory");
                    }
                if(sVehicleAccessoryName.equalsIgnoreCase("GPS Navigation"))
                    {
                        click("chbxGPSNavigation","Click GPS Navigation checkbox");//GPS Navigation checkbox
                        Thread.sleep(3000);
                        click("btnSelectAccessory","Click button Select accessory");
                    }
                if(sVehicleAccessoryName.equalsIgnoreCase("Tow Bar"))
                    {
                        click("chbxTowbar","Click Tow Bar checkbox");//Tow Bar checkbox
                        Thread.sleep(3000);
                        click("btnSelectAccessory","Click button Select accessory");
                    }
                if(sVehicleAccessoryName.equalsIgnoreCase("Other"))
                    {
                        click("chbxOther","Click Other checkbox");//Other checkbox
                        Thread.sleep(3000);
                        click("btnSelectAccessory","Click button Select accessory");
                    }
                //TODO: write logic to select accessory
                setText("txtAreaDescription", sVehicleAccessoryDescription,"Enter accessory description");
                Thread.sleep(3000);
                setText("txtSumInsured", sVehicleAccessorySumIsured,"Enter accessory sum insured");
                Thread.sleep(3000);
            }

            //Cover
            select("drDwnCoverType","text",sCoverType,"Select Cover Type"); //Cover type
            Thread.sleep(2000);
            select("drDwnRetailOrCustomValue","text",sRetailOrCustomValue,"Select retail or custom value of the vehicle?"); //Do you want to be insured for the retail or custom value of the vehicle?
            Thread.sleep(3000);

            if(sRetailOrCustomValue.equalsIgnoreCase("Custom Value"))
            {
//              sVehicleCustomValue.replace("","");
                setText("txtInsuranceValue", sVehicleCustomValue,"Enter Vehicle Custom Value");
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

            if(sVehicleFinanced.equalsIgnoreCase("Yes"))
            {
                click("chBxIsVehicleFinanced", "Click Vehicle Finance");
                Thread.sleep(2000);
                select("drDwnFinanceCompany","text", sVehicleFinancedHouse, "Select Vehicle Finance House");

                if(sCreditShortFallExtension.equalsIgnoreCase("Yes"))
                {
                    click("chBxCreditShortfallExtension", "Select Credit Shortfall"); //Credit shortfall extension
                }
            }

            /*
            else
            {
                click("chBxIsVehicleFinanced", "Click Vehicle Finance"); //Click the checkbox to deselect it
            }
             */
            if(sRequireAfricanTraveller.equalsIgnoreCase("Yes"))
            {
                click("chBxAfricanTraveller","Select African Traveller Option"); //select African Traveller
                String sAfricanTravellerSumIsured = wdriver.findElement(By.tagName("lblAfricanTravellerSumInsured")).getText();
                validateString("R250,000",sAfricanTravellerSumIsured,"Verify the African Traveller Sum Insured");
            }

            if(sExcludeOffRoad.equalsIgnoreCase("Yes"))
            {
                click("chBxExcludeOffRoad","Select Exclude off Road Option"); //Exclude Off road
            }

            if(sCarHire.equalsIgnoreCase("Yes"))
            {
                click("chBxCarHire", "Select Car Hire Option");
                Thread.sleep(2000);
                select("drDwnCarHireType", "text", sCarHireType, "Select Car Hire Type");

            }
            Thread.sleep(3000);
            //Security
            if(sImmobiliser.equalsIgnoreCase("Yes"))
            {
                click("chBxImmobiliser","click immobiliser checkbox Option"); //Immobiliser
                select("drDwnImmobiliserMake", "text", sImmobiliserMake, "Select Immobiliser make"); //Immobiliser make
            }
            if(sTrackingDevice.equalsIgnoreCase("Yes"))
            {
                click("chBxTrackingDevice","Check box for tracking device"); //Tracking device
                Thread.sleep(2000);
                select("drDwnTrackingDeviceMake", "text", sTrackingDeviceMake, "Select Tracking device"); //Tracking device make

            }
            Thread.sleep(5000);

            //Excess
            select("drDwnFlatExcess", "value", sVehicleFlatExcess, "Select flat excess"); //Flat
            Thread.sleep(3000);
            //setText("txtCompulsoryExcess", sVehicleCompulsory, "Enter Vehicle Compulsory Excess");

            //History
            if(sUninterruptedVehicleInsurance.equalsIgnoreCase("Yes"))
            {
                click("chBxUninterruptedVehicleInsurance","Select dropdown for uninterrupted vehicle insurance"); //Have you had Uninterrupted Vehicle Insurance for the Past 36 Months?
            }

            if(sCurrentlyInsured.equalsIgnoreCase("Yes"))
            {
                click("chBxCurrentlyInsured","Select dropdown for currently insured "); //Are you Currently Insured?
                Thread.sleep(4000);
                select("drDwnInsuranceDuration", "text", sInsuranceDuration, "Select insurance duration"); //What is the Duration of your Current Insurance?
            }

            setText("txtNumberClaims12Months",sVehicleClaimTwelveMonth,"Enter claims in the past 12 months");//Number of Claims/Losses/Damages in the Past 12 Months
            setText("txtNumberClaims24Months",sVehicleClaimTwentyFourMonth,"Enter claims in the past 24 months");//Number of Claims/Losses/Damages in the Past 13 to 24 Months
            setText("txtNumberClaims36Months",sVehicleClaimThirtySixMonth,"Enter claims in the past 36 months");//Number of Claims/Losses/Damages in the Past 25 to 36 Months

            if(sNoClaimsBonus.equalsIgnoreCase("Yes"))
            {
                click("chBxNoClaimsBonus","Select African Traveller Option"); //No claim bonus
            }


            //Registered Owner
            select("drDwnRegisteredOwner","text",sRegisteredOwner,"Select Registered Owner");

            /*
            if(sRegisteredOwner.equalsIgnoreCase("Insured"))
            {
                select("drDwnRegisteredOwner","text",sRegisteredOwner,"Select Registered Owner"); //Registered Owner
                String sOwnerName = wdriver.findElement(By.tagName("txtRegisteredOwnerName")).getText();
                String sOwnerIDorPassport = wdriver.findElement(By.tagName("txtRegisteredOwnerIDNumberPassport")).getText();
                String sOwnerDOB = wdriver.findElement(By.tagName("txtRegisteredOwnerDateOfBirth")).getText();
                String sOwnerMaritalStatus = wdriver.findElement(By.tagName("drDwnRegisteredOwnerMaritalStatus")).getText();

                validateString(sRegisteredOwnerName,sOwnerName,"Verify Registered Owner Name");
                validateString(sRegisteredOwnerIDorPP,sOwnerIDorPassport,"Verify Registered Owner ID/Passport");
                validateString(sRegisteredOwnerDOB,sOwnerDOB,"Verify Registered Owner DOB");
                validateString(sRegisteredOwnerMaritalStatus,sOwnerMaritalStatus,"Verify Registered Owner Marital Status");
            }
            else
            {
                select("drDwnRegisteredOwner","text",sRegisteredOwner,"Select Registered Owner"); //Registered Owner
                setText("txtRegisteredOwnerName",sRegisteredOwnerName,"Enter Registered Owner Name");
                setText("txtRegisteredOwnerIDNumberPassport",sRegisteredOwnerIDorPP,"Enter Registered Owner ID or Passport");
                setText("txtRegisteredOwnerDateOfBirth",sRegisteredOwnerDOB,"Enter Registered Owner Date of Birth");
                select("drDwnRegisteredOwnerMaritalStatus", "text", sRegisteredOwnerMaritalStatus,"Enter Registered Owner Marital Status");
            }
             */

            //Driver
            select("drDwnRegularDriver","text",sRegularDriver,"Select regular driver"); //Who is the regular driver
            Thread.sleep(3000);
            select("drDwnRegularDriverLicenseType","text",sRegularDriverLicenseType,"Select regular driver license type"); //Regular Driver License Type
            Thread.sleep(2000);

            setText("txtRegularDriverLicenseDate","02/03/2017","Enter regular driver license date"); //Regular Driver License Date
            select("drDwnDefensiveDriving","text",sRegularDriverDefensiveDriving,"Select regular driver defensive driving"); //Defensive driving certificate
            Thread.sleep(2000);
            click("vecleSaveBtn","click save button for vehicle");

            /*
            if(sRegularDriver.equalsIgnoreCase("Insured"))
            {
                select("drDwnRegularDriver","text",sRegularDriver,"Select regular driver"); //Who is the regular driver?

            }
            else if(sRegularDriver.equalsIgnoreCase("Register Owner"))
            {
                select("drDwnRegularDriver","text",sRegularDriver,"Select regular driver"); //Who is the regular driver?
                String sRegularName = wdriver.findElement(By.tagName("lblRegularDriverName")).getText();
                String sRegularIDorPassport = wdriver.findElement(By.tagName("lblRegularDriverId")).getText();
                String sRegularDOB = wdriver.findElement(By.tagName("lblRegularDriverDOB")).getText();

                //Verify the Regular driver details are same as Registered owner
                validateString(sRegisteredOwnerName,sRegularName,"Verify Registered Owner Name");
                validateString(sRegisteredOwnerIDorPP,sRegularIDorPassport,"Verify Registered Owner ID/Passport");
                validateString(sRegisteredOwnerDOB,sRegularDOB,"Verify Registered Owner DOB");
            }
            else
            {
                select("drDwnRegularDriver","text",sRegularDriver,"Select regular driver"); //Who is the regular driver?
                setText("txtRegularDriverName",sRegularFirstName,"Enter regular driver name"); //Regular Driver Name
                setText("txtRegularDriverId",sRegularDriverLastName,"Enter regular driver last name"); //Regular Driver ID/Passport Number
                setText("txtRegularDriverDOB",sRegularDriverDOB,"Enter regular driver DOB"); //Regular Driver Date of Birth
                select("drDwnRegularDriverGender","text",sRegularDriverGender,"Select regular driver gender"); //Regular Driver Gender
                select("drDwnRegularDriverMaritalStatus","text",sRegularDriverMaritalStatus,"Select regular driver marital status"); //Regular Driver Marital Status
                select("drDwnRegularDriverLicenseType","text",sRegularDriverLicenseType,"Select regular driver license type"); //Regular Driver License Type
                setText("txtRegularDriverLicenseDate",sRegularDriverLicenseDate,"Enter regular driver license date"); //Regular Driver License Date
                select("drDwnDefensiveDriving","text",sRegularDriverDefensiveDriving,"Select regular driver defensive driving"); //Defensive driving certificate
            }

             */
        }
        catch (Exception e)
        {
            throw e;
        }

        return vehicleDetails;
    }



}