package AIC_POM;

import utility.WebDr;

import java.util.HashMap;
import java.util.Map;

public class AIC_All_Risk_POM {

    public static void SetPage_AllRiskDetails()
    {
        Map<String, String> My_Page_Objects = new HashMap<String, String>();
        My_Page_Objects.put ("drDwnAddress", "XPATH|//select[@title='Please Select']/ancestor::td/preceding-sibling::td/label[contains(text(),'Address')]/ancestor::td/following-sibling::td/select");
        My_Page_Objects.put ("lblPostalCode", "XPATH|//span[@id='templ:t_r_con:2:code::content']");
        My_Page_Objects.put ("txtDescription", "XPATH|//input[@type='text']/ancestor::td/preceding-sibling::td/label[contains(text(),'Description')]/ancestor::td/following-sibling::td/input");
        My_Page_Objects.put ("txtSumInsured", "XPATH|//input[@type='text']/ancestor::td/preceding-sibling::td/label[contains(text(),'Sum Insured')]/ancestor::td/following-sibling::td/input");
        //My_Page_Objects.put ("txtSumInsured ", "XPATH|//input[@id='templ:t_r_con:2:sum_insured::content']");
        My_Page_Objects.put ("drDwnFlatExcess", "XPATH|//select[@title='Please Select']/ancestor::td/preceding-sibling::td/label[contains(text(),'Fla')]/ancestor::td/following-sibling::td/select");
        My_Page_Objects.put ("txtAreaNotes", "XPATH|//textarea[contains(@id,'con:1:it2::content')][@name='templ:t_r_con:1:it2']");
        My_Page_Objects.put ("btnBack", "XPATH|//div[@id='templ:t_r_con:1:back_button']");
        My_Page_Objects.put ("btnSave", "XPATH|//a[@href='#'][contains(.,'Save')]");
        My_Page_Objects.put ("chBxBackOnSave", "XPATH|//input[@id='templ:t_r_con:1:back_on_save::content']");
        My_Page_Objects.put ("ckBxPersistOnError", "XPATH|//input[@id='templ:t_r_con:1:persist_on_error::content']");

        WebDr.page_Objects = My_Page_Objects;
    }
}
