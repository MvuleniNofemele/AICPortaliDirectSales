package AIC_POM;

import utility.WebDr;

import java.util.HashMap;
import java.util.Map;

public class AIC_Motorcycle_POM {

    public static void SetPage_MotorCycleDetails()
    {
        Map<String, String> My_Page_Objects = new HashMap<String, String>();
        My_Page_Objects.put ("lblConsent", "XPATH|//div[contains(text(), 'We need your consent')]");

        //General
        My_Page_Objects.put ("btnClear", "XPATH|//button[contains(@title,'Clear Suburb, City, Postal Code')]");
        My_Page_Objects.put ("btnLookup", "XPATH|//button[contains(@title,'Lookup Suburb, City, Postal Code')]");
        My_Page_Objects.put ("lnkAddress", "XPATH|//td[@align='center'][contains(.,'45TH CUTTING')]");

        My_Page_Objects.put ("txtNormallyParkedAddress", "XPATH|//input[@id='templ:t_r_con:1:parked_address::content']");
        My_Page_Objects.put ("txtAddressLine2", "XPATH|//input[@id='templ:t_r_con:1:address_line_2::content']");
        My_Page_Objects.put ("txtSuburb", "XPATH|//input[@type='text']/ancestor::td/preceding-sibling::td/label[contains(text(),'Suburb')]/ancestor::td/following-sibling::td/input");
        My_Page_Objects.put ("txtCity", "XPATH|//input[@type='text']/ancestor::td/preceding-sibling::td/label[contains(text(),'City')]/ancestor::td/following-sibling::td/input");
        My_Page_Objects.put ("txtPostalCode", "XPATH|//input[@type='text']/ancestor::td/preceding-sibling::td/label[contains(text(),'Postal')]/ancestor::td/following-sibling::td/input");
        My_Page_Objects.put ("btnLookUp", "XPATH|//button[@id='templ:t_r_con:4:lookup_button']");
        My_Page_Objects.put ("btnClear", "XPATH|//button[@id='templ:t_r_con:4:clear_button']");

        My_Page_Objects.put ("drDwnParkingDuringDay", "XPATH|//select[@title='Please Select']/ancestor::td/preceding-sibling::td/label[contains(text(),'Motorcycle Parked')]/ancestor::td/following-sibling::td/select"); //Where is the Motorcycle Parked During the Day?
        My_Page_Objects.put ("drDwnDaytimeParkingCovered", "XPATH|//select[@title='Please Select']/ancestor::td/preceding-sibling::td/label[contains(text(),'Daytime Parking Covered?')]/ancestor::td/following-sibling::td/select"); //Is the Daytime Parking Covered?
        My_Page_Objects.put ("drDwnParkingDuringNight", "XPATH|//select[@title='Please Select']/ancestor::td/preceding-sibling::td/label[contains(text(),'During the Night?')]/ancestor::td/following-sibling::td/select"); //Where is the Motorcycle Parked During the Night?
        My_Page_Objects.put ("chBxMotorCycleOvernightParkingLocation", "XPATH|//input[(@type='checkbox')]/ancestor::td/preceding-sibling::td/label[contains(text(),'Usually Parked')]/ancestor::td/following-sibling::td/span/span/input"); //Is the Motorcycle Usually Parked Overnight on a Small Holding/ Plot/Farm
        My_Page_Objects.put ("drDwnNightTimeParkingCovered", "XPATH|//select[@title='Please Select']/ancestor::td/preceding-sibling::td/label[contains(text(),'Is the Nighttime Parking Covered?')]/ancestor::td/following-sibling::td/select"); //Is the Nighttime Parking Covered?
        My_Page_Objects.put ("drDwnMotorCycleUsage", "XPATH|//select[@title='Please Select']/ancestor::td/preceding-sibling::td/label[contains(text(),' be Used For?')]/ancestor::td/following-sibling::td/select"); //What will the Motorcycle be Used For?

        //Motorcycle
        My_Page_Objects.put ("chBxNewMotorCycle", "XPATH|//input[(@type='checkbox')]/ancestor::td/preceding-sibling::td/label[contains(text(),'New Motorcycle?')]/ancestor::td/following-sibling::td/span/span/input");//Is this a new vehicle?
        My_Page_Objects.put ("drDwnYeaOfManufacture", "XPATH|//select[@title='Please Select']/ancestor::td/preceding-sibling::td/label[contains(text(),'Year of manufacture')]/ancestor::td/following-sibling::td/select");//Year of manufacture
        My_Page_Objects.put ("drDwnMake", "XPATH|//select[@title='Please Select']/ancestor::td/preceding-sibling::td/label[contains(text(),'Make')]/ancestor::td/following-sibling::td/select");//Make
        My_Page_Objects.put ("drDwnModelVariant", "XPATH|//select[@title='Please Select']/ancestor::td/preceding-sibling::td/label[contains(text(),'Model variant')]/ancestor::td/following-sibling::td/select");//Model Variant
        My_Page_Objects.put ("lblMnM", "XPATH|//select[@id='//span[@id='templ:t_r_con:1:mead_mcgrouther_code::content']"); //Mead & McGrouther code
        My_Page_Objects.put ("lblModel", "XPATH|//span[@id='templ:t_r_con:1:model::content']"); //Model
        My_Page_Objects.put ("lblEngineCapacity", "XPATH|//span[@id='templ:t_r_con:1:true::content']"); //Engine capacity
        My_Page_Objects.put ("lblBodyType", "XPATH|//span[@id='templ:t_r_con:4:body_type::content']"); //Body type
        My_Page_Objects.put ("lblAxle", "XPATH|//span[@id='templ:t_r_con:4:axle::content']"); //Axle
        My_Page_Objects.put ("lblType", "XPATH|//span[@id='templ:t_r_con:4:details_type::content']"); //Type
        My_Page_Objects.put ("lblRetailValue", "XPATH|//span[@id='templ:t_r_con:4:retail_value::content']"); //Retail value
        My_Page_Objects.put ("drDwnType", "XPATH|//select[@title='Please Select']/ancestor::td/preceding-sibling::td/label[contains(text(),'Type')]/ancestor::td/following-sibling::td/select"); //Type

        My_Page_Objects.put ("chBxMotorCycleEngineModified", "XPATH|//input[@id='templ:t_r_con:1:modified::content']");//Has this Vehicle’s Engine been Modified to Enhance it's Performance?
        My_Page_Objects.put ("chBxMotorCycleRebuilt", "XPATH|//input[@id='templ:t_r_con:1:code3::content']");//Is this Vehicle Rebuilt (Code 3)?

        //Cover
        My_Page_Objects.put ("drDwnCoverType", "XPATH|//select[@class='x2h']/ancestor::td/preceding-sibling::td/label[contains(text(),'Cover type')]/ancestor::td/following-sibling::td/select");
        My_Page_Objects.put ("drDwnRetailOrCustomValue", "XPATH|//select[@class='x2h']/ancestor::td/preceding-sibling::td/label[contains(text(),'value of the motorcycle?')]/ancestor::td/following-sibling::td/select");
        My_Page_Objects.put ("lblInsuranceValue", "XPATH|//span[@id='templ:t_r_con:1:insurance_value::content']");
        My_Page_Objects.put ("txtInsuranceValue", "XPATH|//input[@id='templ:t_r_con:1:insurance_value::content']");
        My_Page_Objects.put ("lblTotalValueOfAccessories", "XPATH|//span[@id='templ:t_r_con:1:it10::content']");
        My_Page_Objects.put ("lblVehicleSumInsured", "XPATH|//span[@id='templ:t_r_con:1:SumInsuredMotor::content']");
        My_Page_Objects.put ("chBxIsMotorCycleFinanced", "XPATH|//input[(@type='checkbox')]/ancestor::td/preceding-sibling::td/label[contains(text(),'Motorcycle Financed')]/ancestor::td/following-sibling::td/span/span/input");
        My_Page_Objects.put ("drDwnFinanceCompany", "XPATH|//select[@title='Please Select']/ancestor::td/preceding-sibling::td/label[contains(text(),'Finance Company Name')]/ancestor::td/following-sibling::td/select");
//        My_Page_Objects.put ("chBxCreditShortfallExtension", "XPATH|//input[@id='templ:t_r_con:1:credit_shortfall_extension::content']");
//        My_Page_Objects.put ("chBxCarHire", "XPATH|//input[@id='templ:t_r_con:1:hire::content']");

        //security
        My_Page_Objects.put ("chBxTrackingDevice", "XPATH|//input[(@type='checkbox')]/ancestor::td/preceding-sibling::td/label[contains(text(),'Tracking device')]/ancestor::td/following-sibling::td/span/span/input");
        My_Page_Objects.put ("drDwnTrackingDeviceMake", "XPATH|//select[@title='Please Select']/ancestor::td/preceding-sibling::td/label[contains(text(),'Tracking device make')]/ancestor::td/following-sibling::td/select");

        //Excess
        My_Page_Objects.put ("drDwnFlatExcess", "XPATH|//select[@class='x2h']/ancestor::td/preceding-sibling::td/label[contains(text(),'Flat')]/ancestor::td/following-sibling::td/select");

        //History
        My_Page_Objects.put ("chBxUninterruptedMotorcycleInsurance", "XPATH|//input[(@type='checkbox')]/ancestor::td/preceding-sibling::td/label[contains(text(),'36 months')]/ancestor::td/following-sibling::td/span/span/input"); //Have you had Uninterrupted Vehicle Insurance for the Past 36 Months?
        My_Page_Objects.put ("chBxCurrentlyInsured", "XPATH|//input[(@type='checkbox')]/ancestor::td/preceding-sibling::td/label[contains(text(),'Currently Insured')]/ancestor::td/following-sibling::td/span/span/input"); //Are you Currently Insured?
        My_Page_Objects.put ("drDwnInsuranceDuration", "XPATH|//select[@title='Please Select']/ancestor::td/preceding-sibling::td/label[contains(text(),'Current Insurance?')]/ancestor::td/following-sibling::td/select"); //What is the Duration of your Current Insurance?
        My_Page_Objects.put ("txtNumberClaims12Months", "XPATH|//input[@type='text']/ancestor::td/preceding-sibling::td/label[contains(text(),'Past 12')]/ancestor::td/following-sibling::td/input"); //Number of Claims/Losses/Damages in the Past 12 Months
        My_Page_Objects.put ("txtNumberClaims24Months", "XPATH|//input[@type='text']/ancestor::td/preceding-sibling::td/label[contains(text(),'Past 13')]/ancestor::td/following-sibling::td/input"); //Number of Claims/Losses/Damages in the Past 13 to 24 Months
        My_Page_Objects.put ("txtNumberClaims36Months", "XPATH|//input[@type='text']/ancestor::td/preceding-sibling::td/label[contains(text(),'Past 25')]/ancestor::td/following-sibling::td/input"); //Number of Claims/Losses/Damages in the Past 25 to 36 Months

        //Registered Owner
        My_Page_Objects.put ("drDwnRegisteredOwner", "XPATH|//select[@class='x2h']/ancestor::td/preceding-sibling::td/label[contains(text(),'Registered owner')]/ancestor::td/following-sibling::td/select");
        My_Page_Objects.put ("txtRegisteredOwnerName", "XPATH|//input[@id='templ:t_r_con:1:it6::content']");
        My_Page_Objects.put ("txtRegisteredOwnerIDNumberPassport", "XPATH|//input[@id='templ:t_r_con:1:it7::content']");
        My_Page_Objects.put ("txtRegisteredOwnerDateOfBirth", "XPATH|//input[@id='templ:t_r_con:1:date_of_birth::content']");
        My_Page_Objects.put ("drDwnRegisteredOwnerMaritalStatus", "XPATH|//select[@title='Please Select']/ancestor::td/preceding-sibling::td/label[contains(text(),'Marital Status')]/ancestor::td/following-sibling::td/select");

        //Driver
        My_Page_Objects.put ("drDwnRegularDriver", "XPATH|//select[@title='Please Select']/ancestor::td/preceding-sibling::td/label[contains(text(),'the regular driver?')]/ancestor::td/following-sibling::td/select");
        My_Page_Objects.put ("txtRegularDriverName", "XPATH|//input[@id='templ:t_r_con:1:driver_first_name::content']");
        My_Page_Objects.put ("lblRegularDriverName", "XPATH|//span[@id='templ:t_r_con:1:driver_first_name::content']");
        My_Page_Objects.put ("txtRegularDriverId", "XPATH|//input[@id='templ:t_r_con:1:it8::content']");
        My_Page_Objects.put ("lblRegularDriverId", "XPATH|//span[@id='templ:t_r_con:1:it8::content']");
        My_Page_Objects.put ("txtRegularDriverDOB", "XPATH|//input[@id='templ:t_r_con:1:driver_date_of_birth::content']");
        My_Page_Objects.put ("lblRegularDriverDOB", "XPATH|//span[@id='templ:t_r_con:1:driver_date_of_birth::content']");
        My_Page_Objects.put ("drDwnRegularDriverGender", "XPATH|//select[@title='Please Select']/ancestor::td/preceding-sibling::td/label[contains(text(),'Driver Gende')]/ancestor::td/following-sibling::td/select");
        My_Page_Objects.put ("lblRegularDriverGender", "XPATH|//span[@id='templ:t_r_con:1:driver_gender::content']");
        My_Page_Objects.put ("drDwnRegularDriverMaritalStatus", "XPATH|//select[@title='Please Select']/ancestor::td/preceding-sibling::td/label[contains(text(),'Driver Marital Status')]/ancestor::td/following-sibling::td/select");
        My_Page_Objects.put ("lblRegularDriverMaritalStatus", "XPATH|//span[@id='templ:t_r_con:1:driver_marital_status::content']");
        My_Page_Objects.put ("drDwnRegularDriverLicenseType", "XPATH|//select[@title='Please Select']/ancestor::td/preceding-sibling::td/label[contains(text(),'Regular Driver License Type')]/ancestor::td/following-sibling::td/select");
        My_Page_Objects.put ("txtRegularDriverLicenseDate", "XPATH|/html[1]/body[1]/div[1]/form[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[3]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[9]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[9]/td[2]/input[1]");
        My_Page_Objects.put ("txtAreaNote", "XPATH|//textarea[@id='templ:t_r_con:1:it9::content']");

        My_Page_Objects.put ("mcSaveBtn", "XPATH|//button[contains(.,'Save')]");

        WebDr.page_Objects = My_Page_Objects;
    }
}
