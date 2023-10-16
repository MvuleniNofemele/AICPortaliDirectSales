package AIC_POM;

import utility.WebDr;

import java.util.HashMap;
import java.util.Map;

public class AIC_Building_POM
{
    public static void SetPage_BuildingDetails()
    {
        Map<String, String> My_Page_Objects = new HashMap<String, String>();
        My_Page_Objects.put ("lblConsent", "XPATH|//div[contains(text(), 'We need your consent')]");

        //General
        My_Page_Objects.put ("txtNormallyParkedAddress", "XPATH|//input[@id='templ:t_r_con:1:parked_address::content']");
        My_Page_Objects.put ("txtAddressLine2", "XPATH|//input[@id='templ:t_r_con:1:address_line_2::content']");
        My_Page_Objects.put ("txtSuburb", "XPATH|//input[@id='templ:t_r_con:1:suburb::content']");
        My_Page_Objects.put ("txtCity", "XPATH|//input[@id='templ:t_r_con:1:city::content']");
        My_Page_Objects.put ("txtPostalCode", "XPATH|//input[@id='templ:t_r_con:1:postal_code::content']");
//        My_Page_Objects.put ("btnLookUp", "XPATH|//button[@class='btn btn-tertiary btn-lg']");
//        My_Page_Objects.put ("btnClear", "XPATH|//button[@class='btn btn-tertiary btn-lg']");
        My_Page_Objects.put ("drDwnBuildingUsage", "XPATH|//select[@title='Please Select']/ancestor::td/preceding-sibling::td/label[contains(text(),'Building Used For?')]/ancestor::td/following-sibling::td/select"); //What will the Building Used For?
        My_Page_Objects.put ("drDwnTypeOfBuilding", "XPATH|//select[@title='Please Select']/ancestor::td/preceding-sibling::td/label[contains(text(),'building is it?')]/ancestor::td/following-sibling::td/select"); //What type of building is it?
        My_Page_Objects.put ("drDwnTypeOfArea", "XPATH|//select[@title='Please Select']/ancestor::td/preceding-sibling::td/label[contains(text(),'Building Located in?')]/ancestor::td/following-sibling::td/select"); //What Type of Area is the Building Located in?
        My_Page_Objects.put ("chBxBuildingOccupied", "XPATH|//input[(@type='checkbox')]/ancestor::td/preceding-sibling::td/label[contains(text(),'Building Occupied?')]/ancestor::td/following-sibling::td/span/span/input"); //Is the Building Occupied?
        My_Page_Objects.put ("txtOccupiedSinceDate", "XPATH|//input[@id='templ:t_r_con:1:id1::content']"); //Occupied Since Date
        My_Page_Objects.put ("txtUnoccupiedDays", "XPATH|//input[@type='text']/ancestor::td/preceding-sibling::td/label[contains(text(),'Unoccupied Days')]/ancestor::td/following-sibling::td/input"); //Number of Consecutive Unoccupied Days
        My_Page_Objects.put ("txtNumberOfGeysers", "XPATH|//input[@type='text']/ancestor::td/preceding-sibling::td/label[contains(text(),'Building and Outbuilding')]/ancestor::td/following-sibling::td/input"); //Number of Geysers in Building and Outbuilding
        My_Page_Objects.put ("chBxGASappliances", "XPATH|//input[@id='templ:t_r_con:1:sbc423::content']"); //Is there any GAS appliances on the property?

        //Building Construction Details
        My_Page_Objects.put ("drDwnWallConstruction", "XPATH|//select[@title='Please Select']/ancestor::td/preceding-sibling::td/label[contains(text(),'Wall construction')]/ancestor::td/following-sibling::td/select"); //Wall construction
        My_Page_Objects.put ("drDwnRoofConstruction", "XPATH|//select[@title='Please Select']/ancestor::td/preceding-sibling::td/label[contains(text(),'Roof construction')]/ancestor::td/following-sibling::td/select"); //Roof construction
        My_Page_Objects.put ("chBxThatch3meters", "XPATH|//input[(@type='checkbox')]/ancestor::td/preceding-sibling::td/label[contains(text(),'3 meters of the Main Dwelling?')]/ancestor::td/following-sibling::td/span/span/input"); //Is there a Thatched Lapa within 3 meters of the Main Dwelling?
        My_Page_Objects.put ("drDwnThatchLapa", "XPATH|//select[@title='Please Select']/ancestor::td/preceding-sibling::td/label[contains(text(),'Floor Area')]/ancestor::td/following-sibling::td/select"); //Thatched Lapa Hut Floor Area
        My_Page_Objects.put ("chBxSABSLightningConductor", "XPATH|//input[(@type='checkbox')]/ancestor::td/preceding-sibling::td/label[contains(text(),'lightning conductor?')]/ancestor::td/following-sibling::td/span/span/input"); //Do you have a SABS approved lightning conductor?

        //Cover
        My_Page_Objects.put ("drDwnCoverType", "XPATH|//select[@id='templ:t_r_con:1:cover_type::content']");
        My_Page_Objects.put ("drDwnBondApplicable", "XPATH|//select[@class='x2h']/ancestor::td/preceding-sibling::td/label[contains(text(),'applicable to this house?')]/ancestor::td/following-sibling::td/select");
        My_Page_Objects.put ("drDwnFinanceCompany", "XPATH|//select[@title='Please Select']/ancestor::td/preceding-sibling::td/label[contains(text(),'Finance Company')]/ancestor::td/following-sibling::td/select");
        My_Page_Objects.put ("txtBuildingSumInsured", "XPATH|//input[@type='text']/ancestor::td/preceding-sibling::td/label[contains(text(),'Sum Insured of Building')]/ancestor::td/following-sibling::td/input");

        //Excess
        My_Page_Objects.put ("drDwnFlatExcess", "XPATH|//select[@title='Please Select']/ancestor::td/preceding-sibling::td/label[contains(text(),'Flat')]/ancestor::td/following-sibling::td/select");

        //History
        My_Page_Objects.put ("chBxUninterruptedVehicleInsurance", "XPATH|//input[(@type='checkbox')]/ancestor::td/preceding-sibling::td/label[contains(text(),'Insurance for the Past 36 months?')]/ancestor::td/following-sibling::td/span/span/input"); //Have you had Uninterrupted Building Insurance for the Past 36 months?
        My_Page_Objects.put ("txtNumberClaims12Months", "XPATH|//input[@type='text']/ancestor::td/preceding-sibling::td/label[contains(text(),'Past 12')]/ancestor::td/following-sibling::td/input"); //Number of Claims/Losses/Damages in the Past 12 Months
        My_Page_Objects.put ("txtNumberClaims24Months", "XPATH|//input[@type='text']/ancestor::td/preceding-sibling::td/label[contains(text(),'Past 13')]/ancestor::td/following-sibling::td/input"); //Number of Claims/Losses/Damages in the Past 13 to 24 Months
        My_Page_Objects.put ("txtNumberClaims36Months", "XPATH|//input[@type='text']/ancestor::td/preceding-sibling::td/label[contains(text(),'Past 25')]/ancestor::td/following-sibling::td/input"); //Number of Claims/Losses/Damages in the Past 25 to 36 Months

        My_Page_Objects.put ("btnBSave", "XPATH|//a[@href='#'][contains(.,'Save')]");

        //Notes
        My_Page_Objects.put ("txtAreaNote", "XPATH|//textarea[@id='templ:t_r_con:1:it9::content']");

        WebDr.page_Objects = My_Page_Objects;
    }

}
