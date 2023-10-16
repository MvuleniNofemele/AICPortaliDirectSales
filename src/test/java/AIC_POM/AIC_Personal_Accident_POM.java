package AIC_POM;

import utility.WebDr;

import java.util.HashMap;
import java.util.Map;

public class AIC_Personal_Accident_POM
{
    public static void SetPage_PersonalAccident()
    {
        Map<String, String> My_Page_Objects = new HashMap<String, String>();
        My_Page_Objects.put ("", "XPATH|");

        //Insured Cover Details
        My_Page_Objects.put ("txtName", "XPATH|//span[@id='templ:t_r_con:3:it1::content']");
        My_Page_Objects.put ("txtSurname", "XPATH|//span[@id='templ:t_r_con:3:it2::content']");
        My_Page_Objects.put ("txtDOB", "XPATH|//span[@id='templ:t_r_con:3:id1::content']");
        My_Page_Objects.put ("drDwnOccupationType", "XPATH|//select[@id='templ:t_r_con:3:insured_occupation::content']");
        My_Page_Objects.put ("drDwnOccupationCode", "XPATH|//select[@id='templ:t_r_con:3:soc2::content']");
        My_Page_Objects.put ("drDwnDeathValue", "XPATH|//select[@id='templ:t_r_con:3:soc1::content']");
        My_Page_Objects.put ("drDwnPermanentDisablementValue", "XPATH|//select[@id='templ:t_r_con:3:soc4::content']");
        My_Page_Objects.put ("chkBxTemporaryDisablement", "XPATH|//input[@id='templ:t_r_con:3:sbc1::content']");


        //Spouse Cover Details
        My_Page_Objects.put ("chkBxSpouse", "XPATH|//input[@id='templ:t_r_con:3:is_spouse_cover::content']");

        //Child
        My_Page_Objects.put ("", "XPATH|");
        My_Page_Objects.put ("", "XPATH|");
        My_Page_Objects.put ("", "XPATH|");
        My_Page_Objects.put ("", "XPATH|");
        My_Page_Objects.put ("", "XPATH|");
        My_Page_Objects.put ("", "XPATH|");
        My_Page_Objects.put ("", "XPATH|");
        My_Page_Objects.put ("", "XPATH|");
        My_Page_Objects.put ("", "XPATH|");
        My_Page_Objects.put ("", "XPATH|");
        My_Page_Objects.put ("", "XPATH|");
        My_Page_Objects.put ("", "XPATH|");
        My_Page_Objects.put ("", "XPATH|");
        My_Page_Objects.put ("", "XPATH|");
        My_Page_Objects.put ("", "XPATH|");
        My_Page_Objects.put ("", "XPATH|");
        My_Page_Objects.put ("", "XPATH|");
        My_Page_Objects.put ("", "XPATH|");
        My_Page_Objects.put ("", "XPATH|");
        My_Page_Objects.put ("", "XPATH|");
        My_Page_Objects.put ("", "XPATH|");
        My_Page_Objects.put ("", "XPATH|");
        My_Page_Objects.put ("", "XPATH|");

        //Conditions

        //Notes

        WebDr.page_Objects = My_Page_Objects;
    }

}
