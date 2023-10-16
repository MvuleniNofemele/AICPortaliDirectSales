package AIC_POM;

import utility.WebDr;

import java.util.HashMap;
import java.util.Map;

public class AIC_Caravan_Trailer_POM {

    public static void SetPage_CaravanTrailerDetails()
    {
        Map<String, String> My_Page_Objects = new HashMap<String, String>();
        My_Page_Objects.put ("lblConsent", "XPATH|//div[contains(text(), 'We need your consent')]");

        //General
        My_Page_Objects.put ("txtNormallyParkedAddress", "XPATH|//input[@id='templ:t_r_con:1:parked_address::content']");
        My_Page_Objects.put ("txtAddressLine2", "XPATH|//input[@id='templ:t_r_con:1:address_line_2::content']");
        My_Page_Objects.put ("txtSuburb", "XPATH|//input[@id='templ:t_r_con:1:suburb::content']");
        My_Page_Objects.put ("txtCity", "XPATH|//input[@id='templ:t_r_con:1:city::content']");
        My_Page_Objects.put ("txtPostalCode", "XPATH|//input[@id='templ:t_r_con:1:postal_code::content']");
//        My_Page_Objects.put ("btnLookUp", "XPATH|//button[@id='templ:t_r_con:2:lookup_button']");
//        My_Page_Objects.put ("btnClear", "XPATH|//button[@id='templ:t_r_con:2:clear_button']");
        My_Page_Objects.put ("drDwnItemType", "XPATH|//select[@title='Please Select']/ancestor::td/preceding-sibling::td/label[text()='Item type']/ancestor::td/following-sibling::td/select"); //Item type
        My_Page_Objects.put ("drDwnParkingDuringNight", "XPATH|//select[@title='Please Select']/ancestor::td/preceding-sibling::td/label[text()='Where is the Caravan/Trailer Parked at Night']/ancestor::td/following-sibling::td/select"); //Where is the Caravan/Trailer Parked at Night
        My_Page_Objects.put ("chBxCaravanParkingCondition", "XPATH|//input[(@type='checkbox')]/ancestor::td/preceding-sibling::td/label[contains(text(),'Hail Net or Roof')]/ancestor::td/following-sibling::td/span/span/input"); //Is the Caravan/Trailer Parked Under a Hail Net or Roof when not in Use
        My_Page_Objects.put ("chBxCaravanParkingDuringNight", "XPATH|//input[(@type='checkbox')]/ancestor::td/preceding-sibling::td/label[contains(text(),'Parked Overnight')]/ancestor::td/following-sibling::td/span/span/input"); //Is the Caravan/Trailer Usually Parked Overnight on a Small Holding/ Plot/Farm ?
        My_Page_Objects.put ("drDwnCaravanUsage", "XPATH|//select[@title='Please Select']/ancestor::td/preceding-sibling::td/label[text()='What will the Caravan/Trailer be Used For?']/ancestor::td/following-sibling::td/select"); //What will the Caravan/Trailer be Used For?
        My_Page_Objects.put ("chkBxGoodsCarried", "XPATH|//input[@id='templ:t_r_con:1:sbc2::content']"); //Are Goods Carried?

        //Caravan/Trailer
        My_Page_Objects.put ("drDwnYeaOfManufacture", "XPATH|//select[@title='Please Select']/ancestor::td/preceding-sibling::td/label[text()='Year of manufacture']/ancestor::td/following-sibling::td/select");//Year of manufacture
        My_Page_Objects.put ("txtDwnMake", "XPATH|//input[@type='text']/ancestor::td/preceding-sibling::td/label[contains(text(),'Make/Model')]/ancestor::td/following-sibling::td/input");//Make/Model

        //Cover
        My_Page_Objects.put ("chBxIsCaravanFinanced", "XPATH|//input[(@type='checkbox')]/ancestor::td/preceding-sibling::td/label[contains(text(),'Trailer Financed?')]/ancestor::td/following-sibling::td/span/span/input"); //Is the Caravan/Trailer Financed?
        My_Page_Objects.put ("drDwnFinanceCompany", "XPATH|//select[@title='Please Select']/ancestor::td/preceding-sibling::td/label[text()='Finance Company']/ancestor::td/following-sibling::td/select"); //Finance Company
        My_Page_Objects.put ("chBxCreditShortfallExtension", "XPATH|//select[@id='templ:t_r_con:1:soc4::content']"); //Credit Shortfall Extension
        My_Page_Objects.put ("chBxCaravanContents", "XPATH|//input[(@type='checkbox')]/ancestor::td/preceding-sibling::td/label[contains(text(),'Caravan Contents')]/ancestor::td/following-sibling::td/span/span/input"); //Caravan Contents
        My_Page_Objects.put ("txtContentsSumInsured", "XPATH|//input[@type='text']/ancestor::td/preceding-sibling::td/label[contains(text(),'Contents Sum Insured')]/ancestor::td/following-sibling::td/input"); //Contents Sum Insured
        My_Page_Objects.put ("lblTotalSumInsured", "XPATH|//span[@id='templ:t_r_con:1:sum_insured::content']"); //Total Sum Insured
        My_Page_Objects.put ("txtInsuranceValue", "XPATH|//input[@type='text']/ancestor::td/preceding-sibling::td/label[contains(text(),'Insurance value')]/ancestor::td/following-sibling::td/input"); //Insurance value

        //Excess
        My_Page_Objects.put ("drDwnFlatExcess", "XPATH|//select[@title='Please Select']/ancestor::td/preceding-sibling::td/label[text()='Flat']/ancestor::td/following-sibling::td/select");
        //My_Page_Objects.put ("txtCompulsoryExcess", "XPATH|//input[@id='templ:t_r_con:1:it5::content']");

        //History
        My_Page_Objects.put ("chBxUninterruptedCaravanContentsInsurance", "XPATH|//input[(@type='checkbox')]/ancestor::td/preceding-sibling::td/label[contains(text(),'36 months')]/ancestor::td/following-sibling::td/span/span/input"); //Have you had Uninterrupted Vehicle Insurance for the Past 36 Months?
        My_Page_Objects.put ("txtNumberClaims12Months", "XPATH|//input[@type='text']/ancestor::td/preceding-sibling::td/label[contains(text(),'Past 12')]/ancestor::td/following-sibling::td/input"); //Number of Claims/Losses/Damages in the Past 12 Months
        My_Page_Objects.put ("txtNumberClaims24Months", "XPATH|//input[@type='text']/ancestor::td/preceding-sibling::td/label[contains(text(),'Past 13')]/ancestor::td/following-sibling::td/input"); //Number of Claims/Losses/Damages in the Past 13 to 24 Months
        My_Page_Objects.put ("txtNumberClaims36Months", "XPATH|//input[@type='text']/ancestor::td/preceding-sibling::td/label[contains(text(),'Past 25')]/ancestor::td/following-sibling::td/input"); //Number of Claims/Losses/Damages in the Past 25 to 36 Months
        My_Page_Objects.put("ctSaveBtn","XPATH|//a[contains(.,'Save')]");//save button on Caravan/Trailer

        WebDr.page_Objects = My_Page_Objects;
    }
}
