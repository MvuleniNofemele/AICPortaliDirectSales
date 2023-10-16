package AIC_POM;

import utility.WebDr;

import java.util.HashMap;
import java.util.Map;

public class AIC_Electronic_POM {

    public static void SetPage_ElectronicDetails()
    {
        Map<String, String> My_Page_Objects = new HashMap<String, String>();

        My_Page_Objects.put ("drDwnAddress", "XPATH|//select[@title='Please Select']/ancestor::td/preceding-sibling::td/label[contains(text(),'Address')]/ancestor::td/following-sibling::td/select");
        My_Page_Objects.put ("txtPostalCode", "XPATH|//tr[@id='templ:t_r_con:1:code']//td[@class='xuz']");
        My_Page_Objects.put ("chkBxBusinessPurpose", "XPATH|//input[(@type='checkbox')]/ancestor::td/preceding-sibling::td/label[contains(text(),'Business Purposes')]/ancestor::td/following-sibling::td/span/span/input");
        My_Page_Objects.put ("drDwnType", "XPATH|//select[@title='Please Select']/ancestor::td/preceding-sibling::td/label[contains(text(),'Type')]/ancestor::td/following-sibling::td/select");
        My_Page_Objects.put ("txtMake", "XPATH|//input[@type='text']/ancestor::td/preceding-sibling::td/label[contains(text(),'Make')]/ancestor::td/following-sibling::td/input"); //input[@id='templ:t_r_con:1:make::content']
        My_Page_Objects.put ("txtModel", "XPATH|//input[@type='text']/ancestor::td/preceding-sibling::td/label[contains(text(),'Model')]/ancestor::td/following-sibling::td/input");
        My_Page_Objects.put ("txtReplacementValue", "XPATH|//input[@type='text']/ancestor::td/preceding-sibling::td/label[contains(text(),'Replace')]/ancestor::td/following-sibling::td/input");
        My_Page_Objects.put ("txtTotalSumInsured", "XPATH|//tr[@id='templ:t_r_con:1:it5']//td[@class='xuz']");
        My_Page_Objects.put ("drDwnFlatExcess", "XPATH|//select[@title='Please Select']/ancestor::td/preceding-sibling::td/label[contains(text(),'Flat')]/ancestor::td/following-sibling::td/select");
        My_Page_Objects.put ("txtNotes", "XPATH|//textarea[@class='x25']");

        My_Page_Objects.put ("EleSaveBtn", "XPATH|//button[contains(.,'Save')]");

        WebDr.page_Objects = My_Page_Objects;
    }
}
