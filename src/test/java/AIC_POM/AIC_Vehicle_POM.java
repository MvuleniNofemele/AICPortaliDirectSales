package AIC_POM;

import utility.WebDr;

import java.util.HashMap;
import java.util.Map;

public class AIC_Vehicle_POM {

    public static void SetPage_VehicleDetails()
    {
        Map<String, String> My_Page_Objects = new HashMap<String, String>();
        My_Page_Objects.put ("btnContinue", "XPATH|//button[@class='btn btn-tertiary btn-lg']");

        //Needs
        My_Page_Objects.put ("btnAdd", "XPATH|//span[normalize-space()='Add']");

        //General
        My_Page_Objects.put ("txtNormallyParkedAddress", "XPATH|//input[@id='templ:t_r_con:1:parked_address::content']");
        My_Page_Objects.put ("txtAddressLine2", "XPATH|//input[@id='templ:t_r_con:1:address_line_2::content']");
        My_Page_Objects.put ("txtSuburb", "XPATH|//input[@id='templ:t_r_con:1:suburb::content']");
        My_Page_Objects.put ("txtCity", "XPATH|//input[@id='templ:t_r_con:1:city::content']");
        My_Page_Objects.put ("txtPostalCode", "XPATH|//input[@id='templ:t_r_con:1:postal_code::content']");
        My_Page_Objects.put ("btnLookUp", "XPATH|//button[@id='templ:t_r_con:3:lookup_button']");
        My_Page_Objects.put ("btnClear", "XPATH|//button[@id='templ:t_r_con:3:clear_button']");

        My_Page_Objects.put ("drDwnParkingDuringDay", "XPATH|//select[@title='Please Select']/ancestor::td/preceding-sibling::td/label[text()='Where is the Vehicle Parked During the Day?']/ancestor::td/following-sibling::td/select");
        My_Page_Objects.put ("drDwnDaytimeParkingCovered", "XPATH|//select[@title='Please Select']/ancestor::td/preceding-sibling::td/label[text()='Is the Daytime Parking Covered?']/ancestor::td/following-sibling::td/select");
        My_Page_Objects.put ("drDwnParkingDuringNight", "XPATH|//select[@title='Please Select']/ancestor::td/preceding-sibling::td/label[text()='Where is the Vehicle Parked During the Night?']/ancestor::td/following-sibling::td/select");
        My_Page_Objects.put ("drDwnNightTimeParkingCovered", "XPATH|//select[@title='Please Select']/ancestor::td/preceding-sibling::td/label[text()='Is the Nighttime Parking Covered?']/ancestor::td/following-sibling::td/select");
        //My_Page_Objects.put ("chBxParkOverNight", "XPATH|//input[@id='templ:t_r_con:1:small_holding_plot_or_farm::content']"); //Is the Vehicle Usually Parked Overnight on a Small Holding/ Plot/Farm
        My_Page_Objects.put ("drDwnVehicleUsage", "XPATH|//select[@title='Please Select']/ancestor::td/preceding-sibling::td/label[text()='What will be the Vehicle be Used for?']/ancestor::td/following-sibling::td/select"); //What will the Vehicle be Used for?
        My_Page_Objects.put ("chBxParkingAtFarmOrPlot", "XPATH|//input[(@type='checkbox')]/ancestor::td/preceding-sibling::td/label[contains(text(),'Overnight on a Small')]/ancestor::td/following-sibling::td/span/span/input"); //Is the Vehicle Usually Parked Overnight on a Small Holding/ Plot/Farm
        My_Page_Objects.put ("chBxGoodsCarried", "XPATH|//select[@id='templ:t_r_con:1:select_used_for::content']"); //Are Goods Carried?

        //Vehicle
        My_Page_Objects.put ("chBxNewVehicle", "XPATH|//input[(@type='checkbox')]/ancestor::td/preceding-sibling::td/label[contains(text(),'Is this a new vehicle?')]/ancestor::td/following-sibling::td/span/span/input");//Is this a new vehicle?
        My_Page_Objects.put ("drDwnYeaOfManufacture", "XPATH|//select[@title='Please Select']/ancestor::td/preceding-sibling::td/label[text()='Year of manufacture']/ancestor::td/following-sibling::td/select");//Year of manufacture
        My_Page_Objects.put ("drDwnMake", "XPATH|//select[@title='Please Select']/ancestor::td/preceding-sibling::td/label[text()='Make']/ancestor::td/following-sibling::td/select");//Make
        My_Page_Objects.put ("drDwnModelVariant", "XPATH|//select[@title='Please Select']/ancestor::td/preceding-sibling::td/label[text()='Model variant']/ancestor::td/following-sibling::td/select"); //Model variant
        My_Page_Objects.put ("chBxVehicleModified", "XPATH|//input[(@type='checkbox')]/ancestor::td/preceding-sibling::td/label[contains(text(),'Modified to Enhance')]/ancestor::td/following-sibling::td/span/span/input"); //Has this Vehicle’s Engine been Modified to Enhance it's Performance?
        My_Page_Objects.put ("chBxVehicleRebuilt", "XPATH|//input[(@type='checkbox')]/ancestor::td/preceding-sibling::td/label[contains(text(),'Vehicle Rebuilt')]/ancestor::td/following-sibling::td/span/span/input"); //Is this Vehicle Rebuilt (Code 3)?
        My_Page_Objects.put ("chExistingWindscreenDamage", "XPATH|//input[@id='templ:t_r_con:1:windscreen::content']"); //Are there Pre-existing Windscreen Damages?
        My_Page_Objects.put ("chBxOtherExistingDamages", "XPATH|//input[@id='templ:t_r_con:1:sbc4::content']"); //Are there Pre-existing Other Damages?

        //Accessory
        My_Page_Objects.put ("drDwnSound", "XPATH|//select[@title='Please Select']/ancestor::td/preceding-sibling::td/label[text()='Sound']/ancestor::td/following-sibling::td/select"); //Sound
        My_Page_Objects.put("btnAddAccss","XPATH|//a[@href='#'][contains(.,'Add')]");
        My_Page_Objects.put("chbxSoundSystem","XPATH|/html[1]/body[1]/div[1]/form[1]/div[2]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/span[1]/span[1]/span[1]/input[1]");
        My_Page_Objects.put("chbxBluetooth","XPATH|/html[1]/body[1]/div[1]/form[1]/div[2]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/div[1]/div[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[1]/span[1]/span[1]/span[1]/input[1]");
        My_Page_Objects.put("chbxSunroof","XPATH|/html[1]/body[1]/div[1]/form[1]/div[2]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/div[1]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[1]/span[1]/span[1]/span[1]/input[1]");
        My_Page_Objects.put("chbxBullbar","XPATH|/html[1]/body[1]/div[1]/form[1]/div[2]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/div[1]/div[1]/div[1]/div[1]/div[4]/table[1]/tbody[1]/tr[1]/td[1]/span[1]/span[1]/span[1]/input[1]");
        My_Page_Objects.put("chbxElectricWindow","XPATH|/html[1]/body[1]/div[1]/form[1]/div[2]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/div[1]/div[1]/div[1]/div[1]/div[5]/table[1]/tbody[1]/tr[1]/td[1]/span[1]/span[1]/span[1]/input[1]");
        My_Page_Objects.put("chbxSideSkirting","XPATH|/html[1]/body[1]/div[1]/form[1]/div[2]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/div[1]/div[1]/div[1]/div[1]/div[6]/table[1]/tbody[1]/tr[1]/td[1]/span[1]/span[1]/span[1]/input[1]");
        My_Page_Objects.put("chbxNudgeBar","XPATH|/html[1]/body[1]/div[1]/form[1]/div[2]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/div[1]/div[1]/div[1]/div[1]/div[7]/table[1]/tbody[1]/tr[1]/td[1]/span[1]/span[1]/span[1]/input[1]");
        My_Page_Objects.put("chbxSmashGrab","XPATH|/html[1]/body[1]/div[1]/form[1]/div[2]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/div[1]/div[1]/div[1]/div[1]/div[8]/table[1]/tbody[1]/tr[1]/td[1]/span[1]/span[1]/span[1]/input[1]");
        My_Page_Objects.put("chbxPDC","XPATH|/html[1]/body[1]/div[1]/form[1]/div[2]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/div[1]/div[1]/div[1]/div[1]/div[9]/table[1]/tbody[1]/tr[1]/td[1]/span[1]/span[1]/span[1]/input[1]");
        My_Page_Objects.put("chbxLockDiff","XPATH|/html[1]/body[1]/div[1]/form[1]/div[2]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/div[1]/div[1]/div[1]/div[1]/div[10]/table[1]/tbody[1]/tr[1]/td[1]/span[1]/span[1]/span[1]/input[1]");
        My_Page_Objects.put("chbxSportSuspension","XPATH|/html[1]/body[1]/div[1]/form[1]/div[2]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/div[1]/div[1]/div[1]/div[1]/div[11]/table[1]/tbody[1]/tr[1]/td[1]/span[1]/span[1]/span[1]/input[1]");
        My_Page_Objects.put("chbxLEDHeadlamps","XPATH|/html[1]/body[1]/div[1]/form[1]/div[2]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/div[1]/div[1]/div[1]/div[1]/div[12]/table[1]/tbody[1]/tr[1]/td[1]/span[1]/span[1]/span[1]/input[1]");
        My_Page_Objects.put("chbxGPSNavigation","XPATH|/html[1]/body[1]/div[1]/form[1]/div[2]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/div[1]/div[1]/div[1]/div[1]/div[13]/table[1]/tbody[1]/tr[1]/td[1]/span[1]/span[1]/span[1]/input[1]");
        My_Page_Objects.put("chbxTowbar","XPATH|/html[1]/body[1]/div[1]/form[1]/div[2]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/div[1]/div[1]/div[1]/div[1]/div[13]/table[1]/tbody[1]/tr[1]/td[1]/span[1]/span[1]/span[1]/input[1]");
        My_Page_Objects.put("chbxOther","XPATH|/html[1]/body[1]/div[1]/form[1]/div[2]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/div[1]/div[1]/div[1]/div[1]/div[15]/table[1]/tbody[1]/tr[1]/td[1]/span[1]/span[1]/span[1]/input[1]");
        My_Page_Objects.put("btnSelectAccessory","XPATH|//a[@href='#'][contains(.,'Select')]");

        //My_Page_Objects.put ("txtAreaDescription", "XPATH|/html[1]/body[1]/div[1]/form[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[3]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[3]/td[2]/textarea[1]");
        My_Page_Objects.put("txtAreaDescription","XPATH|(//textarea[@class='x25'])[1]");
        My_Page_Objects.put ("txtSumInsured", "XPATH|//input[@type='text']/ancestor::td/preceding-sibling::td/label[contains(text(),'Accessory Sum Insured')]/ancestor::td/following-sibling::td/input");
        //Cover
        My_Page_Objects.put ("drDwnCoverType", "XPATH|//select[@title='Please Select']/ancestor::td/preceding-sibling::td/label[text()='Cover type']/ancestor::td/following-sibling::td/select");
        My_Page_Objects.put ("drDwnRetailOrCustomValue", "XPATH|//select[@title='Retail Value']/ancestor::td/preceding-sibling::td/label[text()='Do you want to be insured for the retail or custom value of the vehicle?']/ancestor::td/following-sibling::td/select");
        My_Page_Objects.put ("lblInsuranceValue", "XPATH|//span[@id='templ:t_r_con:2:insurance_value::content']");
        My_Page_Objects.put ("txtInsuranceValue", "XPATH|//input[@id='templ:t_r_con:1:insurance_value::content']");
        My_Page_Objects.put ("lblTotalValueOfAccessories", "XPATH|//span[@id='templ:t_r_con:1:it10::content']");
        My_Page_Objects.put ("lblVehicleSumInsured", "XPATH|//span[@id='templ:t_r_con:1:it12::content']");
        My_Page_Objects.put ("chBxIsVehicleFinanced", "XPATH|//input[(@type='checkbox')]/ancestor::td/preceding-sibling::td/label[contains(text(),'Vehicle Financed')]/ancestor::td/following-sibling::td/span/span/input");
        My_Page_Objects.put ("drDwnFinanceCompany", "XPATH|//select[@title='Please Select']/ancestor::td/preceding-sibling::td/label[contains(text(),'Finance Company Name')]/ancestor::td/following-sibling::td/select");
        My_Page_Objects.put ("chBxAfricanTraveller", "XPATH|//input[@id='templ:t_r_con:1:sbc5::content']");
        My_Page_Objects.put ("lblAfricanTravellerSumInsured", "XPATH|//span[@id='templ:t_r_con:1:it14::content']");
        My_Page_Objects.put ("chBxExcludeOffRoad", "XPATH|//input[@id='templ:t_r_con:2:off_road::content']");
        My_Page_Objects.put ("chBxCreditShortfallExtension", "XPATH|//input[@id='templ:t_r_con:1:credit_shortfall_extension::content']");
        My_Page_Objects.put ("chBxCarHire", "XPATH|//input[(@type='checkbox')]/ancestor::td/preceding-sibling::td/label[contains(text(),'Car Hire')]/ancestor::td/following-sibling::td/span/span/input");
        My_Page_Objects.put ("drDwnCarHireType", "XPATH|//select[@title='Please Select']/ancestor::td/preceding-sibling::td/label[text()='Car Hire Type']/ancestor::td/following-sibling::td/select");

        //security
        My_Page_Objects.put ("chBxImmobiliser", "XPATH|//input[(@type='checkbox')]/ancestor::td/preceding-sibling::td/label[contains(text(),'Immobiliser')]/ancestor::td/following-sibling::td/span/span/input");
        My_Page_Objects.put ("drDwnImmobiliserMake", "XPATH|//select[@title='Please Select']/ancestor::td/preceding-sibling::td/label[text()='Immobiliser make']/ancestor::td/following-sibling::td/select");
        My_Page_Objects.put ("chBxTrackingDevice", "XPATH|//input[(@type='checkbox')]/ancestor::td/preceding-sibling::td/label[contains(text(),'Tracking device')]/ancestor::td/following-sibling::td/span/span/input");
        My_Page_Objects.put ("drDwnTrackingDeviceMake", "XPATH|//select[@title='Please Select']/ancestor::td/preceding-sibling::td/label[text()='Tracking device make']/ancestor::td/following-sibling::td/select");

        //Excess
        My_Page_Objects.put ("drDwnFlatExcess", "XPATH|//select[@class='x2h']/ancestor::td/preceding-sibling::td/label[text()='Flat']/ancestor::td/following-sibling::td/select");
        My_Page_Objects.put ("txtCompulsoryExcess", "XPATH|//input[@id='templ:t_r_con:1:it5::content']");

        //History
        My_Page_Objects.put ("chBxUninterruptedVehicleInsurance", "XPATH|//input[(@type='checkbox')]/ancestor::td/preceding-sibling::td/label[contains(text(),'36 Months')]/ancestor::td/following-sibling::td/span/span/input"); //Have you had Uninterrupted Vehicle Insurance for the Past 36 Months?
        My_Page_Objects.put ("chBxCurrentlyInsured", "XPATH|//input[(@type='checkbox')]/ancestor::td/preceding-sibling::td/label[contains(text(),'Currently Insured')]/ancestor::td/following-sibling::td/span/span/input"); //Are you Currently Insured?
        My_Page_Objects.put ("drDwnInsuranceDuration", "XPATH|//select[@title='Please Select']/ancestor::td/preceding-sibling::td/label[contains(text(),'Current Insurance?')]/ancestor::td/following-sibling::td/select"); //What is the Duration of your Current Insurance?
        My_Page_Objects.put ("txtNumberClaims12Months", "XPATH|//input[@type='text']/ancestor::td/preceding-sibling::td/label[contains(text(),'Past 12')]/ancestor::td/following-sibling::td/input"); //Number of Claims/Losses/Damages in the Past 12 Months
        My_Page_Objects.put ("txtNumberClaims24Months", "XPATH|//input[@type='text']/ancestor::td/preceding-sibling::td/label[contains(text(),'Past 13')]/ancestor::td/following-sibling::td/input"); //Number of Claims/Losses/Damages in the Past 13 to 24 Months
        My_Page_Objects.put ("txtNumberClaims36Months", "XPATH|//input[@type='text']/ancestor::td/preceding-sibling::td/label[contains(text(),'Past 25')]/ancestor::td/following-sibling::td/input"); //Number of Claims/Losses/Damages in the Past 25 to 36 Months

        //Registered Owner
        My_Page_Objects.put ("drDwnRegisteredOwner", "XPATH|//select[@title='Please Select']/ancestor::td/preceding-sibling::td/label[text()='Registered Owner']/ancestor::td/following-sibling::td/select");
        My_Page_Objects.put ("txtRegisteredOwnerName", "XPATH|//input[@id='templ:t_r_con:2:it6::content']");
        My_Page_Objects.put ("txtRegisteredOwnerIDNumberPassport", "XPATH|//input[@id='templ:t_r_con:2:it7::content']");
        My_Page_Objects.put ("txtRegisteredOwnerDateOfBirth", "XPATH|//input[@id='templ:t_r_con:2:date_of_birth::content']");
        My_Page_Objects.put ("drDwnRegisteredOwnerMaritalStatus", "XPATH|//select[@title='Please Select']/ancestor::td/preceding-sibling::td/label[text()='Tracking device make']/ancestor::td/following-sibling::td/select");

        //Driver
        My_Page_Objects.put ("drDwnRegularDriver", "XPATH|//select[@title='Please Select']/ancestor::td/preceding-sibling::td/label[text()='Who is the regular driver?']/ancestor::td/following-sibling::td/select");
        My_Page_Objects.put ("txtRegularDriverName", "XPATH|//input[@id='templ:t_r_con:1:driver_first_name::content']");
        My_Page_Objects.put ("lblRegularDriverName", "XPATH|//button[@class='btn btn-tertiary btn-lg']");
        My_Page_Objects.put ("txtRegularDriverId", "XPATH|//input[@id='templ:t_r_con:1:it8::content']");
        My_Page_Objects.put ("lblRegularDriverId", "XPATH|//button[@class='btn btn-tertiary btn-lg']");
        My_Page_Objects.put ("txtRegularDriverDOB", "XPATH|//input[@id='templ:t_r_con:1:driver_date_of_birth::content']");
        My_Page_Objects.put ("lblRegularDriverDOB", "XPATH|//button[@class='btn btn-tertiary btn-lg']");
        My_Page_Objects.put ("drDwnRegularDriverGender", "XPATH|//select[@title='Please Select']/ancestor::td/preceding-sibling::td/label[text()='Tracking device make']/ancestor::td/following-sibling::td/select");
        My_Page_Objects.put ("lblRegularDriverGender", "XPATH|//button[@class='btn btn-tertiary btn-lg']");
        My_Page_Objects.put ("drDwnRegularDriverMaritalStatus", "XPATH|//select[@title='Please Select']/ancestor::td/preceding-sibling::td/label[text()='Tracking device make']/ancestor::td/following-sibling::td/select");
        My_Page_Objects.put ("drDwnRegularDriverLicenseType", "XPATH|//select[@title='Please Select']/ancestor::td/preceding-sibling::td/label[text()='Regular Driver License Type']/ancestor::td/following-sibling::td/select");
//      My_Page_Objects.put ("txtRegularDriverLicenseDate", "XPATH|//input[@id='templ:t_r_con:2:driver_licence_date::content']");

//      Regular Driver License Date
        My_Page_Objects.put ("txtRegularDriverLicenseDate", "XPATH|/html[1]/body[1]/div[1]/form[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[3]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[9]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[9]/td[2]/input[1]");
        My_Page_Objects.put ("iconDate", "XPATH|//a[@href='#'][contains(@id,'date::glyph')]");
        My_Page_Objects.put ("upArrwDate", "XPATH|//a[@tabindex='-1'][contains(@id,'date::pop::cd::ys::decrement')]");
        My_Page_Objects.put ("dayDate", "XPATH|//td[@tabindex='-1'][contains(.,'17')]");

        My_Page_Objects.put ("drDwnDefensiveDriving", "XPATH|//select[@title='Please Select']/ancestor::td/preceding-sibling::td/label[text()='Defensive driving certificate']/ancestor::td/following-sibling::td/select");
        My_Page_Objects.put ("chBxNoClaimsBonus", "XPATH|//input[@id='templ:t_r_con:1:no_claim_bonus::content']");

        My_Page_Objects.put ("vecleSaveBtn", "XPATH|//a[contains(.,'Save')]");

        //Notes
        My_Page_Objects.put ("txtAreaNote", "XPATH|//textarea[@id='templ:t_r_con:1:it9::content']");

        WebDr.page_Objects = My_Page_Objects;
    }


}
