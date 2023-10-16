package AIC_POM;

import utility.WebDr;

import java.util.HashMap;
import java.util.Map;

public class AIC_Watercraft_POM {

    public static void SetPage_WatercraftDetails()
    {
        Map<String, String> My_Page_Objects = new HashMap<String, String>();
        My_Page_Objects.put ("lblConsent", "XPATH|//div[contains(text(), 'We need your consent')]");

        //General
        My_Page_Objects.put ("txtNormallyParkedAddress", "XPATH|//input[@id='templ:t_r_con:1:parked_address::content']");
        My_Page_Objects.put ("txtAddressLine2", "XPATH|//input[@id='templ:t_r_con:1:address_line_2::content']");
        My_Page_Objects.put ("txtSuburb", "XPATH|//input[@id='templ:t_r_con:1:suburb::content']");
        My_Page_Objects.put ("txtCity", "XPATH|//input[@id='templ:t_r_con:1:city::content']");
        My_Page_Objects.put ("txtPostalCode", "XPATH|//input[@id='templ:t_r_con:1:postal_code::content']");
        My_Page_Objects.put ("btnLookUp", "XPATH|//button[@id='templ:t_r_con:3:lookup_button']");
        My_Page_Objects.put ("btnClear", "XPATH|//button[@id='templ:t_r_con:3:clear_button']");

        My_Page_Objects.put ("drDwnItemType", "XPATH|//select[@title='Please Select']/ancestor::td/preceding-sibling::td/label[contains(text(),'Item')]/ancestor::td/following-sibling::td/select"); //Item Type
        My_Page_Objects.put ("drDwnWatercraftStorage", "XPATH|//select[@title='Please Select']/ancestor::td/preceding-sibling::td/label[contains(text(),'not in use?')]/ancestor::td/following-sibling::td/select"); //Where is the Watercraft stored when not in use?
        My_Page_Objects.put ("drDwnWatercraftUsage", "XPATH|//select[@title='Please Select']/ancestor::td/preceding-sibling::td/label[contains(text(),'Used For?')]/ancestor::td/following-sibling::td/select"); //What will the Watercraft be Used For?
        My_Page_Objects.put ("chBxRacingOrRagata", "XPATH|//input[(@type='checkbox')]/ancestor::td/preceding-sibling::td/label[contains(text(),'Racing or Regata?')]/ancestor::td/following-sibling::td/span/span/input"); //will the Craft be used for Racing or Regata?


        //Watercraft
        My_Page_Objects.put ("drDwnYeaOfManufacture", "XPATH|//select[@title='Please Select']/ancestor::td/preceding-sibling::td/label[contains(text(),'manufacture')]/ancestor::td/following-sibling::td/select"); //Year of manufacture
        My_Page_Objects.put ("txtModelMake", "XPATH|//input[@type='text']/ancestor::td/preceding-sibling::td/label[contains(text(),'Make')]/ancestor::td/following-sibling::td/input"); //Make/Model
        My_Page_Objects.put ("drDescription", "XPATH|//select[@title='Please Select']/ancestor::td/preceding-sibling::td/label[contains(text(),'Description')]/ancestor::td/following-sibling::td/select"); //Description
        My_Page_Objects.put ("drDwnHullLength", "XPATH|//select[@title='Please Select']/ancestor::td/preceding-sibling::td/label[contains(text(),'Hull length')]/ancestor::td/following-sibling::td/select"); //Hull length
        My_Page_Objects.put ("txtWatercraftMaxSpeed", "XPATH|//input[@type='text']/ancestor::td/preceding-sibling::td/label[contains(text(),'speed of watercraft')]/ancestor::td/following-sibling::td/input"); //Maximum speed of watercraft

        //Accessories
        My_Page_Objects.put ("btnAddAccss", "XPATH|//a[contains(.,'Add')]");

        My_Page_Objects.put("chkBxGlitterFinish","XPATH|/html[1]/body[1]/div[1]/form[1]/div[2]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/span[1]/span[1]/span[1]/input[1]");
        My_Page_Objects.put ("chkBxDrivingEquipmnt", "XPATH|//html[1]/body[1]/div[1]/form[1]/div[2]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/div[1]/div[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[1]/span[1]/span[1]/span[1]/input[1]");
        My_Page_Objects.put("chkbxFishEquipment","XPATH|/html[1]/body[1]/div[1]/form[1]/div[2]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/div[1]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[1]/span[1]/span[1]/span[1]/input[1]");
        My_Page_Objects.put("chkbxOtherEquiment","XPATH|/html[1]/body[1]/div[1]/form[1]/div[2]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/div[1]/div[1]/div[1]/div[1]/div[4]/table[1]/tbody[1]/tr[1]/td[1]/span[1]/span[1]/span[1]/input[1]");
        My_Page_Objects.put("chkbxGuidenceEquiment","XPATH|/html[1]/body[1]/div[1]/form[1]/div[2]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/div[1]/div[1]/div[1]/div[1]/div[4]/table[1]/tbody[1]/tr[1]/td[1]/span[1]/span[1]/span[1]/input[1]");
        My_Page_Objects.put("chkbxRadioEquiment","XPATH|/html[1]/body[1]/div[1]/form[1]/div[2]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/div[1]/div[1]/div[1]/div[1]/div[6]/table[1]/tbody[1]/tr[1]/td[1]/span[1]/span[1]/span[1]/input[1]");
        My_Page_Objects.put("chkbxFirstAidEquip","XPATH|/html[1]/body[1]/div[1]/form[1]/div[2]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/div[1]/div[1]/div[1]/div[1]/div[7]/table[1]/tbody[1]/tr[1]/td[1]/span[1]/span[1]/span[1]/input[1]");
        My_Page_Objects.put("chkbxLifeJacketEquip","XPATH|/html[1]/body[1]/div[1]/form[1]/div[2]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/div[1]/div[1]/div[1]/div[1]/div[8]/table[1]/tbody[1]/tr[1]/td[1]/span[1]/span[1]/span[1]/input[1]");

        My_Page_Objects.put ("btnSelectAccessory","XPATH|//a[contains(.,'Select')]");
        My_Page_Objects.put ("txtAreaDescription", "XPATH|/html[1]/body[1]/div[1]/form[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[3]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[3]/td[2]/textarea[1]");
        My_Page_Objects.put ("txtSumInsured", "XPATH|//input[@type='text']/ancestor::td/preceding-sibling::td/label[contains(text(),'Accessory Sum Insured')]/ancestor::td/following-sibling::td/input");


        //Cover

        My_Page_Objects.put ("txtWatercraftSumInsured", "XPATH|//input[@type='text']/ancestor::td/preceding-sibling::td/label[contains(text(),'Watercraft Sum Insured')]/ancestor::td/following-sibling::td/input"); //Watercraft Sum Insured
        My_Page_Objects.put ("chBxWaterCraftFinanced", "XPATH|//input[(@type='checkbox')]/ancestor::td/preceding-sibling::td/label[contains(text(),'Financed?')]/ancestor::td/following-sibling::td/span/span/input"); //Is the Watercraft Financed?
        My_Page_Objects.put ("drDwnFinanceCompany", "XPATH|//select[@title='Please Select']/ancestor::td/preceding-sibling::td/label[contains(text(),'Finance Company')]/ancestor::td/following-sibling::td/select"); //Finance Company
        My_Page_Objects.put ("lblInsuranceValue", "XPATH|//span[@id='templ:t_r_con:5:total_sum_insured::content']"); //Total sum insured
        My_Page_Objects.put ("chkBxWaterSkiersLiabilityCover", "XPATH|//input[(@type='checkbox')]/ancestor::td/preceding-sibling::td/label[contains(text(),'Liability Cover?')]/ancestor::td/following-sibling::td/span/span/input");
        My_Page_Objects.put ("chBxWatercraftContentsCover", "XPATH|//input[(@type='checkbox')]/ancestor::td/preceding-sibling::td/label[contains(text(),'Contents Cover?')]/ancestor::td/following-sibling::td/span/span/input");//Do you Require Watercraft Contents Cover?
        My_Page_Objects.put ("txtContentSumInsured", "XPATH|//input[@type='text']/ancestor::td/preceding-sibling::td/label[contains(text(),'Contents Sum Insured')]/ancestor::td/following-sibling::td/input");



        //Excess
        My_Page_Objects.put ("drDwnFlatExcess", "XPATH|//select[@title='Please Select']/ancestor::td/preceding-sibling::td/label[contains(text(),'Flat')]/ancestor::td/following-sibling::td/select");

        //History
        My_Page_Objects.put ("chBxUninterruptedVehicleInsurance", "XPATH|//input[(@type='checkbox')]/ancestor::td/preceding-sibling::td/label[contains(text(),'36 Months')]/ancestor::td/following-sibling::td/span/span/input"); //Have you had Uninterrupted Vehicle Insurance for the Past 36 Months?
        My_Page_Objects.put ("drDwnInsuranceDuration", "XPATH|//select[@id='templ:t_r_con:1:current_insurance_duration::content']"); //What is the Duration of your Current Insurance?
        My_Page_Objects.put ("txtNumberClaims12Months", "XPATH|//input[@type='text']/ancestor::td/preceding-sibling::td/label[contains(text(),'Past 12')]/ancestor::td/following-sibling::td/input"); //Number of Claims/Losses/Damages in the Past 12 Months
        My_Page_Objects.put ("txtNumberClaims24Months", "XPATH|//input[@type='text']/ancestor::td/preceding-sibling::td/label[contains(text(),'Past 13')]/ancestor::td/following-sibling::td/input"); //Number of Claims/Losses/Damages in the Past 13 to 24 Months
        My_Page_Objects.put ("txtNumberClaims36Months", "XPATH|//input[@type='text']/ancestor::td/preceding-sibling::td/label[contains(text(),'Past 25')]/ancestor::td/following-sibling::td/input"); //Number of Claims/Losses/Damages in the Past 25 to 36 Months

        //Notes
        My_Page_Objects.put ("txtAreaNote", "XPATH|//textarea[@id='templ:t_r_con:5:it2::content']");

        My_Page_Objects.put ("btnWCSave", "XPATH|//a[contains(.,'Save')]");


        WebDr.page_Objects = My_Page_Objects;
    }
}
