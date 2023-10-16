package AIC;

import AIC_POM.AIC_Home_Contents_POM;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utility.WebDr;

import static org.openqa.selenium.By.xpath;

public class AIC_Home_Contents extends WebDr {

    public AIC_Home_Contents(WebDriver wdriver, ExtentTest test) {
        this.wdriver = wdriver;
        this.test = test;
    }

    public boolean fn_HomeContentsDetails() throws Exception {
        AIC_Home_Contents_POM.SetPage_HomeContentsDetails();
        boolean homeContentsDetails = false;

        //Dwelling
        String sContentsDwellingUsage = getValue("ContentsDwellingUsage");
        String sBuildingContentsLocatedIn = getValue("BuildingContentsLocatedIn");
        String sContentsTypeOfArea = getValue("ContentsTypeOfArea");
        String sContentsHouseOccupied = getValue("ContentsHouseOccupied");
        //String sContentsOccupiedSinceDate = getValue("ContentsOccupiedSinceDate");
        String sContentsOccupiedDuringTheDay = getValue("ContentsOccupiedDuringTheDay");
        //String sContentsConsecutiveUnoccupiedDays = getValue("ContentsConsecutiveUnoccupiedDays");//The value cannot be rad from data sheet
        String sContentsConsecutiveUnoccupiedDays = "10";
        String sContentsGASAppliances = getValue("ContentsGASAppliances");
        String sContentsNonResidentialProperty = getValue("ContentsNonResidentialProperty");
        String sContentsSpecifyNonResidentialProperty = getValue("ContentsSpecifyNonResidentialProperty"); //The value cannot be rad from data sheet
        //String sContentsSpecifyNonResidentialProperty = "Park";

        //Building Construction Details Variable
        String sContentsWallConstruction = getValue("ContentsWallConstruction");
        String sContentsRoofConstruction = getValue("ContentsRoofConstruction");
        String sThatchedStructure = getValue("ContentsThatchedStructure");
        String sLapaHutFloor = getValue("ContentsLapaHutFloor");
        String sLightningRod = getValue("ContentsLightningRod");

        //Home Contents Security Variables
        String sBurglariesAtTheProperty = getValue("BurglariesAtTheProperty");
        String sAlarmInstalled = getValue("AlarmInstalled");
        String sAlarmProfessionallyInstalled = getValue("AlarmProfessionallyInstalled");
        String sInfraRedDetectors = getValue("InfraRedDetectors");
        String sAlarmInWorkingOrder = getValue("AlarmInWorkingOrder");
        String sHighSecurityComplex = getValue("HighSecurityComplex");
        String s1_8MeterWalls = getValue("1_8MeterWalls");
        //String sPerimeterWall = getValue("PerimeterWall");
        String sPerimeterWall = "No";
        String sOpenFieldsAroundTheProperty = getValue("OpenFieldsAroundTheProperty");
        //String sBurglarProofingWindows = getValue("BurglarProofingWindows");
        String sBurglarProofingWindows = "Yes - Opening Windows Only";
        String sExternalDoorSecurityGates = getValue("ExternalDoorSecurityGates");
        String sElectricFencing = getValue("ElectricFencing");
        String sElectronicGate = getValue("ElectronicGate");
        String s24_hourSecurityGuard = getValue("24_hourSecurityGuard");

        String sHouseCFlatExcess = getValue("HouseCFlatExcess");

        //Cover
        String sBusinessContentsHouse = getValue("BusinessContentsHouse");
        String sBusinessContentsType = getValue("BusinessContentsType");

        String sContentsSumInsured = getValue("ContentsSumInsured");

        //Additional
        String sAccidentalAccidentalCov = getValue("AccidentalAccidentalCover");

        //Home contents history variable
        String sUninterruptedContentsInsurance = getValue("UninterruptedContentsInsurance");
//      String sCurrentlyInsured = getValue("CurrentlyInsured");
//      String sInsuranceDuration = getValue("InsuranceDuration");
        String sContentsClaimTwelveMonth = getValue("ContentsClaimTwelveMonth");
        String sContentsClaimTwentyFourMonth = getValue("ContentsClaimTwentyFourMonth");
        String sContentsClaimThirtySixMonth = getValue("ContentsClaimThirtySixMonth");
        String sContentsNoClaimBonus = getValue("ContentsNoClaimBonus");
        String sContentsNoClaimBonusRating = getValue("ContentsNoClaimBonusRating");
        String sContentsNoClaimBonusProof = getValue("ContentsNoClaimBonusProof");
        String sTestScenario = getValue("TestCase_Name");

        try {
            //Scroll to the downside
            //jsScroll("drDwnBuildingUsage", "Scroll to the last element");

            //Dwelling
            select("drDwnBuildingUsage", "text", sContentsDwellingUsage, "Select building usage"); //What will the building be used for?
            select("drDwnTypeOfBuildingWithContent","text",sBuildingContentsLocatedIn,"Select type of area contents is located in"); //What Type of Building is the Contents Located in?
            select("drDwnDwellingLocation","text",sContentsTypeOfArea,"Select Type of Area is the Dwelling Located in"); //What Type of Area is the Dwelling Located in?
//            Thread.sleep(2000);
//            click("chBxHouseOccupied","Check box for house occupied"); //Is the House Occupied?

            if(sContentsHouseOccupied.equalsIgnoreCase("Yes"))
            {
                wdriver.findElement(By.xpath("//input[@id='templ:t_r_con:1:premises_occupied24hours::content']")).click();
                Thread.sleep(2000);
            }

            if(sContentsOccupiedDuringTheDay.equalsIgnoreCase("Yes"))
            {
                click("chBxPropertyOccupiedDuringDay","Check box for Occupied During the Day"); //Is the Property Occupied During the Day?
            }
            Thread.sleep(1000);

            setText("txtConsecutiveUnoccupiedDays",sContentsConsecutiveUnoccupiedDays,"Enter Consecutive Unoccupied Days"); //Number of Consecutive Unoccupied Days

            if(sContentsGASAppliances.equalsIgnoreCase("Yes"))
            {
                click("chBxGASAppliances","Check box for GAS appliances on the property"); //Is there any GAS appliances on the property?
            }

            if(sContentsNonResidentialProperty.equalsIgnoreCase("Yes"))
            {
                click("chBxNonResidentialProperty","Check box for Non Residential on the property");
                Thread.sleep(5000);
                select("drDwnSpecifyNonResidentialProperty","text",sContentsSpecifyNonResidentialProperty,"Select Non Residential Property"); //Specify Non Residential Property
            }

            //Building Construction Details
           select("drDwnWallConstruction","text",sContentsWallConstruction,"Select wall construction type"); //Wall construction
            Thread.sleep(2000);
           select("drDwnRoofConstruction","text",sContentsRoofConstruction,"Select roof construction type"); //Roof construction

            if(sThatchedStructure.equalsIgnoreCase("Yes"))
            {
                click("chBxThatch3meters", "Check box for Lapa within 3 meters"); //Is there a Thatched Lapa within 3 meters of the Main Dwelling?
            }
            Thread.sleep(3000);
            select("drDwnThatchLapa","text",sLapaHutFloor,"Select Lapa Hut Floor"); //Thatched Lapa Hut Floor Area

            if(sLightningRod.equalsIgnoreCase("Yes"))
            {
                click("chBxSABSLightningConductor", "Check box lightning rod"); //Do you have a SABS approved lightning conductor?
            }

            //Security
            //TODO:contents security logic
            //click("chBxPropertyBurglaries","check any Burglaries at the Property");//Have you had any Burglaries at the Property?
            select("drDwnAlarmInstalled", "text", sAlarmInstalled, "Enter claims in the past 12 months");//Do you have an Alarm Installed?
            click("chBxHighSecurityComplex","check Is the Property in a High Security Complex?");//Is the Property in a High Security Complex?
            click("chBx1_8MeterWalls","check Do you have 1.8 Meter Walls?");//Do you have 1.8 Meter Walls?
            click("chBxPerimeterWall","check Razor Wire Along the Perimeter Wall");//Razor Wire Along the Perimeter Wall
            click("chBxOpenFieldsAroundTheProperty","check Are there any Open Fields Around the Property?");//Are there any Open Fields Around the Property?

            select("drDwnBurglarProofingWindows", "text", sBurglarProofingWindows, "Select Are there Burglar Proofing Windows?");//Are there Burglar Proofing Windows?
            select("drDwnExternalDoorSecurityGates", "text", sExternalDoorSecurityGates, "Select Are there External Door Security Gates?");//Are there External Door Security Gates?

            click("chBxElectricFencing"," check Is there Electric Fencing?");//Is there Electric Fencing?
            click("chBxSecurityAccess24hrs"," check 24 hour security access gates");//24 hour security access gates
            click("chBxElectronicGate"," check there an Electronic Gate?");//Is there an Electronic Gate?
            click("chBx24_hourSecurityGuard"," check Is there a 24-hour Security guard?");//Is there a 24-hour Security guard?

            //Cover
            Thread.sleep(2000);
            //select("drDwnCoverType", "text", "Replacement Value", "Select Cover Type");
            if(sBusinessContentsHouse.equalsIgnoreCase("Yes")){
                click("chBxBusinessContents"," checkbox Business content");
                Thread.sleep(4000);
                select("drDwnBusinessContentsType","text",sBusinessContentsType,"Select business content type");
            }

            setText("txtContentsSumInsured",sContentsSumInsured,"Enter sum insured");
            Thread.sleep(3000);

            //Additional
            if(sAccidentalAccidentalCov.equalsIgnoreCase("Yes")){
                click("chBxAccidentalDamageCover"," check Accidental Damage Cover");//Do you want Accidental Damage Cover?
            }

            setText("txtContentsSumInsured",sContentsSumInsured,"Enter sum insured");
            Thread.sleep(2000);
            //jsScroll("lblAccidentalDamageSumInsured", "Scroll to the last element");
            //click("chBxAdditionalHouseholdersAllRiskCover"," check Accidental House All Risk Cover");
            //select("drDwnAdditionalAmnt","text","R50,000","Select Additional Amount");

            //Excess
            select("drDwnFlatExcess","value",sHouseCFlatExcess,"Select Flat Excess Amount");//Flat

            //History
            if(sUninterruptedContentsInsurance.equalsIgnoreCase("Yes"))
            {
                click("chBxUninterruptedHouseInsurance","Select dropdown for uninterrupted vehicle insurance"); //Have you had Uninterrupted Vehicle Insurance for the Past 36 Months?
                Thread.sleep(2000);
            }
            setText("txtNumberClaims12Months",sContentsClaimTwelveMonth,"Enter claims in the past 12 months");//Number of Claims/Losses/Damages in the Past 12 Months
            Thread.sleep(2000);
            setText("txtNumberClaims24Months",sContentsClaimTwentyFourMonth,"Enter claims in the past 24 months"); //Number of Claims/Losses/Damages in the Past 13 to 24 Months
            Thread.sleep(2000);
            setText("txtNumberClaims36Months",sContentsClaimThirtySixMonth,"Enter claims in the past 36 months"); //Number of Claims/Losses/Damages in the Past 25 to 36 Months

            if(sContentsNoClaimBonus.equalsIgnoreCase("Yes"))
            {
                //wdriver.findElement(By.xpath("//table/tbody/tr[@class='x1v']/td/span[@class='x2e']/span[@class='x13d']/input[@id='templ:t_r_con:1:no_claim_bonus::content']")).click();
                click("chBxNoClaimBonus","Check box for No claim bonus"); //No claim bonus
                select("drDwnNoClaimBonusRating","text",sContentsNoClaimBonusRating,"Select No claim bonus rating");//No claim bonus rating
            }


            if(sContentsNoClaimBonusProof.equalsIgnoreCase("Yes"))
            {
                click("chBxNoClaimBonusProof","Check box for No claim bonus proof"); //No claim bonus proof
            }

            //Click save button
            click("sveBtn","click save button for HH"); //No claim bonus proof
            Thread.sleep(3000);


        }
        catch(Exception e)
            {
                throw e;
            }

            return homeContentsDetails;
        }
    }

