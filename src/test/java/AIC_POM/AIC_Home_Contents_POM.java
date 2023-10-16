package AIC_POM;

import utility.WebDr;

import java.util.HashMap;
import java.util.Map;

public class AIC_Home_Contents_POM {

    public static void SetPage_HomeContentsDetails()
    {
        Map<String, String> My_Page_Objects = new HashMap<String, String>();
        My_Page_Objects.put ("lblConsent", "XPATH|//div[contains(text(), 'We need your consent')]");

        //General
        My_Page_Objects.put ("txtNormallyParkedAddress", "XPATH|//input[@id='templ:t_r_con:1:parked_address::content']");
        My_Page_Objects.put ("txtAddressLine2", "XPATH|//input[@id='templ:t_r_con:2:address_line_2::content']");
        My_Page_Objects.put ("txtSuburb", "XPATH|//input[@id='templ:t_r_con:2:suburb::content']");
        My_Page_Objects.put ("txtCity", "XPATH|//input[@id='templ:t_r_con:2:city::content']");
        My_Page_Objects.put ("txtPostalCode", "XPATH|//input[@id='templ:t_r_con:2:postal_code::content']");
        My_Page_Objects.put ("btnLookUp", "XPATH|//button[@id='templ:t_r_con:2:lookup_button']");
        My_Page_Objects.put ("btnClear", "XPATH|//button[@id='templ:t_r_con:2:clear_button']");

        //Dwelling
        My_Page_Objects.put ("drDwnBuildingUsage", "XPATH|//select[@title='Please Select']/ancestor::td/preceding-sibling::td/label[contains(text(),'building be used for?')]/ancestor::td/following-sibling::td/select"); //What will the Building Used For?
        My_Page_Objects.put ("drDwnTypeOfBuildingWithContent", "XPATH|//select[@title='Please Select']/ancestor::td/preceding-sibling::td/label[contains(text(),'Contents Located in?')]/ancestor::td/following-sibling::td/select"); //What Type of Building is the Contents Located in?
        My_Page_Objects.put ("drDwnDwellingLocation", "XPATH|//select[@title='Please Select']/ancestor::td/preceding-sibling::td/label[contains(text(),'Dwelling Located in')]/ancestor::td/following-sibling::td/select"); //What Type of Area is the Dwelling Located in?
        My_Page_Objects.put ("chBxHouseOccupied", "XPATH|//input[(@type='checkbox')]/ancestor::td/preceding-sibling::td/label[contains(text(),'House Occupied?')]/ancestor::td/following-sibling::td/span/span/input"); //Is the House Occupied?
        //My_Page_Objects.put ("txtOccupiedSinceDate", "XPATH|//input[@id='templ:t_r_con:1:premises_occupied24hours::content']"); //Occupied Since Date
        My_Page_Objects.put ("chBxPropertyOccupiedDuringDay", "XPATH|//input[(@type='checkbox')]/ancestor::td/preceding-sibling::td/label[contains(text(),'Occupied During the Day?')]/ancestor::td/following-sibling::td/span/span/input"); //Is the Property Occupied During the Day?
        My_Page_Objects.put ("chBxNonResProperty", "XPATH|//input[(@type='checkbox')]/ancestor::td/preceding-sibling::td/label[contains(text(),'Residential property?')]/ancestor::td/following-sibling::td/span/span/input");
        //Date
        My_Page_Objects.put ("txtConsecutiveUnoccupiedDays", "XPATH|//input[@type='text']/ancestor::td/preceding-sibling::td/label[contains(text(),'Unoccupied Days')]/ancestor::td/following-sibling::td/input");//Number of Consecutive Unoccupied Days
        My_Page_Objects.put ("iconConsecutiveUnoccupiedDays", "XPATH|//a[@id='templ:t_r_con:1:occupied_date::glyph']");
        My_Page_Objects.put ("iconBackDateArrow", "XPATH|//a[@id='templ:t_r_con:1:occupied_date::pop::cd::pm']");
        My_Page_Objects.put ("dayDateSelect", "XPATH|//td[normalize-space()='13']");

        My_Page_Objects.put ("chBxGASAppliances", "XPATH|//input[@id='templ:t_r_con:1:sbc4::content']"); //Is there any GAS appliances on the property?
        My_Page_Objects.put ("chBxNonResidentialProperty", "XPATH|//input[(@type='checkbox')]/ancestor::td/preceding-sibling::td/label[contains(text(),'Non Residential property?')]/ancestor::td/following-sibling::td/span/span/input"); //Does the Property Border a Non Residential property?
        My_Page_Objects.put ("drDwnSpecifyNonResidentialProperty", "XPATH|//select[@title='Please Select']/ancestor::td/preceding-sibling::td/label[contains(text(),'Specify Non Reside')]/ancestor::td/following-sibling::td/select"); //Specify Non Residential Property

        //Building Construction Details
        My_Page_Objects.put ("drDwnWallConstruction", "XPATH|//select[@title='Please Select']/ancestor::td/preceding-sibling::td/label[contains(text(),'Wall construction')]/ancestor::td/following-sibling::td/select"); //Wall construction
        My_Page_Objects.put ("drDwnRoofConstruction", "XPATH|//select[@title='Please Select']/ancestor::td/preceding-sibling::td/label[contains(text(),'Roof construction')]/ancestor::td/following-sibling::td/select"); //Roof construction
        My_Page_Objects.put ("chBxThatch3meters", "XPATH|//input[(@type='checkbox')]/ancestor::td/preceding-sibling::td/label[contains(text(),'Main Dwelling')]/ancestor::td/following-sibling::td/span/span/input"); //Is there a Thatched Lapa within 3 meters of the Main Dwelling?
        My_Page_Objects.put ("drDwnThatchLapa", "XPATH|//select[@title='Please Select']/ancestor::td/preceding-sibling::td/label[contains(text(),'Floor Area')]/ancestor::td/following-sibling::td/select"); //Thatched Lapa Hut Floor Area
        My_Page_Objects.put ("chBxSABSLightningConductor", "XPATH|//input[(@type='checkbox')]/ancestor::td/preceding-sibling::td/label[contains(text(),'lightning conductor?')]/ancestor::td/following-sibling::td/span/span/input"); //Do you have a SABS approved lightning conductor?
        My_Page_Objects.put ("chBxBuildingCompleted", "//input[contains(@id,'con:1:sbc5::content')][@name='templ:t_r_con:1:sbc5']"); //Is the Building Completed

        //security
        My_Page_Objects.put ("chBxPropertyBurglaries", "XPATH|//input[contains(@id,'con:1:sbc6::content')][@name='templ:t_r_con:1:sbc6']"); //Have you had any Burglaries at the Property?
        My_Page_Objects.put ("drDwnAlarmInstalled", "XPATH|//select[@title='Please Select']/ancestor::td/preceding-sibling::td/label[contains(text(),'Alarm Installed?')]/ancestor::td/following-sibling::td/select"); //Do you have an Alarm Installed?

        My_Page_Objects.put ("chBxAlarmProfessionallyInstalled", "XPATH|//input[@id='templ:t_r_con:2:sbc7::content']"); //Was the Alarm Professionally Installed?
        My_Page_Objects.put ("chBxInfraRedDetectors", "XPATH|//input[@id='templ:t_r_con:2:sbc8::content']"); //Does the Alarm have Infra-red Detectors?
        My_Page_Objects.put ("chBxAlarmInWorkingOrder", "XPATH|//input[@id='templ:t_r_con:2:sbc9::content']"); //Is the Alarm in Working Order?
        My_Page_Objects.put ("chBxHighSecurityComplex", "XPATH|//input[contains(@id,'complex::content')][@name='templ:t_r_con:1:high_security_complex']"); //Is the Property in a High Security Complex?
        My_Page_Objects.put ("chBx1_8MeterWalls", "XPATH|//input[contains(@id,'walls::content')][@name='templ:t_r_con:1:m18_walls']"); //Do you have 1.8 Meter Walls?
        My_Page_Objects.put ("chBxPerimeterWall", "XPATH|//input[contains(@id,'con:1:sbc11::content')][@name='templ:t_r_con:1:sbc11']"); //Razor Wire Along the Perimeter Wall
        My_Page_Objects.put ("chBxOpenFieldsAroundTheProperty", "XPATH|//input[contains(@id,'con:1:sbc11::content')][@name='templ:t_r_con:1:sbc11']"); //Are there any Open Fields Around the Property?

        My_Page_Objects.put ("drDwnBurglarProofingWindows", "XPATH|//select[@title='Please Select']/ancestor::td/preceding-sibling::td/label[contains(text(),'Proofing Windows?')]/ancestor::td/following-sibling::td/select"); //Are there Burglar Proofing Windows?
        My_Page_Objects.put ("drDwnExternalDoorSecurityGates", "XPATH|//select[@title='Please Select']/ancestor::td/preceding-sibling::td/label[contains(text(),'Security Gates?')]/ancestor::td/following-sibling::td/select"); //Are there External Door Security Gates?

        My_Page_Objects.put ("chBxElectricFencing", "XPATH|//input[contains(@id,'fence::content')][@name='templ:t_r_con:1:electric_fence']"); //Is there Electric Fencing?
        My_Page_Objects.put ("chBxSecurityAccess24hrs", "XPATH|//input[contains(@id,'gates::content')][@name='templ:t_r_con:1:hour24_security_access_gates']"); //24 hour security access gates
        My_Page_Objects.put ("chBxElectronicGate", "XPATH|//input[contains(@id,'gates::content')][@name='templ:t_r_con:1:electronic_gates']"); //Is there an Electronic Gate?
        My_Page_Objects.put ("chBx24_hourSecurityGuard", "XPATH|//input[contains(@id,'guard::content')][@name='templ:t_r_con:1:hour24_security_guard']"); //Is there a 24-hour Security guard?


        //Cover
        My_Page_Objects.put ("drDwnCoverType", "XPATH|//select[@title='Replacement Value']/ancestor::td/preceding-sibling::td/label[contains(text(),'Cover type')]/ancestor::td/following-sibling::td/select"); //Cover type
        My_Page_Objects.put ("lblSumInsure", "XPATH|//span[contains(@id,'con:1:it9::content')][@class='x25'][contains(.,'0.00')]"); //Total Specific Valuable Items Sum Insured
        My_Page_Objects.put ("chBxBusinessContents", "XPATH|//input[contains(@id,'stored::content')][@name='templ:t_r_con:1:industry_stock_stored']"); //Business Contents
        My_Page_Objects.put ("drDwnBusinessContentsType", "XPATH|//select[@title='Please Select']/ancestor::td/preceding-sibling::td/label[contains(text(),'Business contents type')]/ancestor::td/following-sibling::td/select"); //Business Contents type
        My_Page_Objects.put ("txtContentsSumInsured", "XPATH|//input[@type='text']/ancestor::td/preceding-sibling::td/label[contains(text(),'Sum Insured')]/ancestor::td/following-sibling::td/input"); //Contents Sum Insured
        My_Page_Objects.put ("lblTotalSumInsured", "XPATH|//span[contains(@id,'con:1:it10::content')][@class='x25'][contains(.,'25,000.00')]"); //Total Sum Insured


        //Additional
        My_Page_Objects.put ("chBxAccidentalDamageCover", "XPATH|//input[contains(@id,'cover::content')][@name='templ:t_r_con:1:damage_cover']"); //Do you want Accidental Damage Cover?
        My_Page_Objects.put ("lblAccidentalDamageSumInsured", "XPATH|//span[contains(@id,'con:1:it2::content')][@class='x25'][contains(.,'R25,000')]"); //Accidental Damage Sum Insured
        My_Page_Objects.put ("chBxAdditionalHouseholdersAllRiskCover", "XPATH|//input[@id='templ:t_r_con:2:allrisk_cover::content']"); //Do you require additional Householders All Risk cover?
        My_Page_Objects.put ("drDwnAdditionalAmnt", "XPATH|//select[contains(@id,'con:2:allRiskSumInsured::content')][@name='templ:t_r_con:2:allRiskSumInsured']");

        //Excess
        My_Page_Objects.put ("drDwnFlatExcess", "XPATH|//select[@title='Please Select']/ancestor::td/preceding-sibling::td/label[contains(text(),'Flat')]/ancestor::td/following-sibling::td/select");
        My_Page_Objects.put ("txtCompulsoryExcess", "XPATH|//input[contains(@id,'con:1:it4::content')][@name='templ:t_r_con:1:it4']");

        //History
        My_Page_Objects.put ("chBxUninterruptedHouseInsurance", "XPATH|//input[(@type='checkbox')]/ancestor::td/preceding-sibling::td/label[contains(text(),'Household Insur')]/ancestor::td/following-sibling::td/span/span/input"); //Have you had Uninterrupted Household Insurance for the Past 36 Months?
        My_Page_Objects.put ("txtNumberClaims12Months", "XPATH|//input[@type='text']/ancestor::td/preceding-sibling::td/label[contains(text(),'Past 12')]/ancestor::td/following-sibling::td/input"); //Number of Claims/Losses/Damages in the Past 12 Months
        My_Page_Objects.put ("txtNumberClaims24Months", "XPATH|//input[@type='text']/ancestor::td/preceding-sibling::td/label[contains(text(),'Past 13')]/ancestor::td/following-sibling::td/input"); //Number of Claims/Losses/Damages in the Past 13 to 24 Months
        My_Page_Objects.put ("txtNumberClaims36Months", "XPATH|//input[@type='text']/ancestor::td/preceding-sibling::td/label[contains(text(),'Past 25')]/ancestor::td/following-sibling::td/input"); //Number of Claims/Losses/Damages in the Past 25 to 36 Months
        My_Page_Objects.put ("chBxNoClaimBonus", "XPATH|//input[(@type='checkbox')]/ancestor::td/preceding-sibling::td/label[contains(text(),'claim bonus')]/ancestor::td/following-sibling::td/span/span/input"); //No claim bonus
        My_Page_Objects.put ("drDwnNoClaimBonusRating", "XPATH|//select[@title='Please Select']/ancestor::td/preceding-sibling::td/label[contains(text(),'bonus rating')]/ancestor::td/following-sibling::td/select"); //No claim bonus rating
        My_Page_Objects.put ("chBxNoClaimBonusProof", "XPATH|//input[(@type='checkbox')]/ancestor::td/preceding-sibling::td/label[contains(text(),'bonus proof')]/ancestor::td/following-sibling::td/span/span/input"); //No claim bonus proof

        //Notes
        My_Page_Objects.put ("txtAreaNote", "XPATH|//textarea[contains(@id,'con:1:it3::content')][@name='templ:t_r_con:1:it3']");

        //Save, Back and Delete button

        My_Page_Objects.put ("sveBtn", "XPATH|//a[@href='#'][contains(.,'Save')]");
        My_Page_Objects.put ("bckBtn", "XPATH|//a[@href='#'][contains(.,'Back')]");
        My_Page_Objects.put ("delBtn", "XPATH|//a[@href='#'][contains(.,'Back')]");


        WebDr.page_Objects = My_Page_Objects;
    }



}
