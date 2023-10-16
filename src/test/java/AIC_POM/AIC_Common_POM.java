package AIC_POM;

import utility.WebDr;

import java.util.HashMap;
import java.util.Map;

public class AIC_Common_POM {

    public static void SetPage_Common()
    {
        Map<String, String> My_Page_Objects = new HashMap<String, String>();

        //Campaign screen

        //'Current' screen Page Objects
        My_Page_Objects.put ("btnRefresh", "XPATH|//div[@id='templ:cam_reg:0:refresh_button']//span[@class='xzv']");
        My_Page_Objects.put ("lblCurrent", "XPATH|//h1[normalize-space()='Current']");
        //My_Page_Objects.put ("btnNext", "XPATH|//span[normalize-space()='Next']");
        My_Page_Objects.put ("btnNext", "XPATH|//a[contains(.,'Next')]");

        //'Insured' screen Page Objects
        My_Page_Objects.put ("lblGeneral", "XPATH|(//span[contains(.,'General')])[2]");
        My_Page_Objects.put ("drpLeadIndicator", "XPATH|//select[contains(@name,'templ:t_r_con:0:lead_indicator')]");
        My_Page_Objects.put ("drpITC", "XPATH|//select[contains(@name,'templ:t_r_con:0:insured_itc_consent_provided')]");
        My_Page_Objects.put ("drpPolicycancelledbycompany", "XPATH|//select[contains(@name,'templ:t_r_con:0:policycancelledbycompany')]");
        My_Page_Objects.put ("drpHouseholdclaims_past3years", "XPATH|//select[contains(@name,'templ:t_r_con:0:householdclaims_past3years')]");
        My_Page_Objects.put ("drpLossLast3yrs", "XPATH|//select[contains(@name,'templ:t_r_con:0:shorttermInsuranceRefused')]");
        My_Page_Objects.put ("btnSave", "XPATH|//a[contains(.,'Save')]");

        //Needs selection Page Objects
        My_Page_Objects.put ("chBoxMO", "XPATH|(((//h1[contains(text(),'Available Items')]/ancestor::div)[9]/following-sibling::div)/div/div/div/div/div/table)[1]/tbody/tr/td[1]");
        My_Page_Objects.put ("chBoxHH", "XPATH|(((//h1[contains(text(),'Available Items')]/ancestor::div)[9]/following-sibling::div)/div/div/div/div/div/table)[2]/tbody/tr/td[1]");
        My_Page_Objects.put ("chBoxMC", "XPATH|(((//h1[contains(text(),'Available Items')]/ancestor::div)[9]/following-sibling::div)/div/div/div/div/div/table)[3]/tbody/tr/td[1]");
        My_Page_Objects.put ("chBoxBld", "XPATH|(((//h1[contains(text(),'Available Items')]/ancestor::div)[9]/following-sibling::div)/div/div/div/div/div/table)[4]/tbody/tr/td[1]");
        My_Page_Objects.put ("chBoxEE", "XPATH|(((//h1[contains(text(),'Available Items')]/ancestor::div)[9]/following-sibling::div)/div/div/div/div/div/table)[5]/tbody/tr/td[1]");
        My_Page_Objects.put ("chBoxWC", "XPATH|(((//h1[contains(text(),'Available Items')]/ancestor::div)[9]/following-sibling::div)/div/div/div/div/div/table)[7]/tbody/tr/td[1]");
        My_Page_Objects.put ("chBoxCT", "XPATH|(((//h1[contains(text(),'Available Items')]/ancestor::div)[9]/following-sibling::div)/div/div/div/div/div/table)[6]/tbody/tr/td[1]");
        My_Page_Objects.put ("chBoxAR", "XPATH|(((//h1[contains(text(),'Available Items')]/ancestor::div)[9]/following-sibling::div)/div/div/div/div/div/table)[8]/tbody/tr/td[1]");
        My_Page_Objects.put ("addButton", "XPATH|(//span[@class='xgi'][contains(.,'Add')])[3]");

        //All Risk buttons
        My_Page_Objects.put ("addARButton", "XPATH|//span[@class='xgh'][contains(.,'Add')]");
        My_Page_Objects.put ("chkUAR", "XPATH|//input[contains(@id,'36::content')][@name='templ:t_r_con:0:all_risk_item_choice_36']");
        My_Page_Objects.put ("dneButton", "XPATH|//a[@href='#'][contains(.,'Done')]");
        My_Page_Objects.put ("lnkUAR", "XPATH|//span[@class='x1pp'][contains(.,'Unspecified All Risk')]");

        My_Page_Objects.put ("drpDwnNumOfMO", "XPATH|/html[1]/body[1]/div[1]/form[1]/div[2]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[3]/span[1]/select[1]");
        //Add checked button
        My_Page_Objects.put ("addChkButton", "XPATH|(//span[@class='xgi'][contains(.,'Add')])[2]");//Add checked button
        My_Page_Objects.put ("addHHLink", "XPATH|(//a[normalize-space()='House Content'])[1]");//HH Link
        My_Page_Objects.put ("addCTlink", "XPATH|//a[contains(.,'Caravan/Trailer')]");//Caravan/Trailer Link
        My_Page_Objects.put ("addBuildLink", "XPATH|//a[contains(.,'Building')]");//Building Link
        My_Page_Objects.put ("addWCLink", "XPATH|//a[contains(.,'Watercraft')]");//Watercraft Link
        My_Page_Objects.put ("addEELink", "XPATH|//a[contains(.,'Electronic')]");//Electronic Link

        //MC
        My_Page_Objects.put ("addMCLink", "XPATH|//a[contains(@id,'')][@title='Edit'][contains(.,'Motorcycle')]");//Water Craft Link

        //Check all button
        //My_Page_Objects.put ("checkAllButton", "XPATH|(//a[@href='#'][contains(.,'Check All')])[2]");
        My_Page_Objects.put ("checkHH", "XPATH|//input[contains(@name,'templ:t_r_con:0:selected_item_choice_15369_1')]");
        My_Page_Objects.put ("checkAR", "XPATH|//input[contains(@name,'templ:t_r_con:0:selected_item_child_choice_1_2_16235_0')]");

        //Quote checked button
        My_Page_Objects.put ("quoteCheckedButton", "XPATH|//a[@href='#'][contains(.,'Quote Checked')]");

        My_Page_Objects.put ("drDwnNumMO", "XPATH|//select[@id='templ:t_r_con:0:available_item_amount_0::content']");
        My_Page_Objects.put ("drDwnNumHH", "XPATH|//select[@id='templ:t_r_con:0:available_item_amount_1::content']");
        My_Page_Objects.put ("drDwnNumMC", "XPATH|//select[@id='templ:t_r_con:0:available_item_amount_2::content']");
        My_Page_Objects.put ("drDwnNumHO", "XPATH|//select[@id='templ:t_r_con:0:available_item_amount_3::content']");
        My_Page_Objects.put ("drDwnNumEE", "XPATH|//select[@id='templ:t_r_con:0:available_item_amount_4::content']");
        My_Page_Objects.put ("drDwnNumWC", "XPATH|//select[@id='templ:t_r_con:0:available_item_amount_5::content']");
        My_Page_Objects.put ("drDwnNumCT", "XPATH|//select[@id='templ:t_r_con:0:available_item_amount_6::content']");
        My_Page_Objects.put ("drDwnNumPA", "XPATH|//select[@id='templ:t_r_con:0:available_item_amount_7::content']");
        My_Page_Objects.put ("drDwnNumAR", "XPATH|//select[@id='templ:t_r_con:0:available_item_amount_8::content']");

        //Quoting screen
        My_Page_Objects.put ("txtEffctveDate", "XPATH|//label[@for='templ:t_r_con:0:effective_date::content'][contains(.,'Effective date')]");
        My_Page_Objects.put ("refreshButton", "XPATH|//button[contains(@id,'button')][@class='x7j p_AFTextOnly'][contains(.,'Refresh')]");
        My_Page_Objects.put ("effctveDate", "XPATH|//input[@name='templ:t_r_con:0:effective_date']");
        My_Page_Objects.put ("effectveDateDay", "XPATH|(//td[@tabindex='-1'][contains(.,'31')])[2]");
        My_Page_Objects.put ("genQSDButtton", "XPATH|//button[contains(@id,'summary')][@class='x7j p_AFTextOnly'][contains(.,'Generate Quote Summary')]");

        //Flat excess
        My_Page_Objects.put("verifyVehicle","XPATH|(//span[contains(.,'Vehicle')])[1]");
        My_Page_Objects.put("verifyBuilding","XPATH|(//span[contains(.,'Building')])[1]");
        My_Page_Objects.put("verifyHouse","XPATH|(//span[contains(.,'House')])[1]");
        My_Page_Objects.put("verifyMotorcycle","XPATH|(//span[contains(.,'Motorcycle')])[1]");

        /*
        My_Page_Objects.put("loadDiscVehicle","XPATH|(//table[@class='x13s']/tbody/tr[5]/td/following-sibling::td/following-sibling::td/following-sibling::td/following-sibling::td/following-sibling::td/following-sibling::td/span)[1]");
        My_Page_Objects.put("loadDiscMotorcyle","XPATH|(//table[@class='x13s']/tbody/tr[6]/td/following-sibling::td/following-sibling::td/following-sibling::td/following-sibling::td/following-sibling::td/following-sibling::td/span)[1]");
        My_Page_Objects.put("loadDiscBuilding","XPATH|(//table[@class='x13s']/tbody/tr[7]/td/following-sibling::td/following-sibling::td/following-sibling::td/following-sibling::td/following-sibling::td/following-sibling::td/span)[1]");
        My_Page_Objects.put("loadDiscHouse","XPATH|(//table[@class='x13s']/tbody/tr[10]/td/following-sibling::td/following-sibling::td/following-sibling::td/following-sibling::td/following-sibling::td/following-sibling::td/span)[1]");

         */

        My_Page_Objects.put("loadDiscVehicle","XPATH|(//input[contains(@id,'percentage::content')])[1]");
        My_Page_Objects.put("loadDiscMotorcyle","XPATH|(//input[contains(@id,'percentage::content')])[2]");
        My_Page_Objects.put("loadDiscBuilding","XPATH|(//input[contains(@id,'percentage::content')])[3]");
        My_Page_Objects.put("loadDiscHouse","XPATH|(//input[contains(@id,'percentage::content')])[4]");
        My_Page_Objects.put ("btnOk", "XPATH|(//a[@href='#'][contains(.,'OK')])[1]");

        My_Page_Objects.put ("btnDetails", "XPATH|//a[contains(.,'Details')]");
        My_Page_Objects.put ("lblTotalPremium", "XPATH|(//label[contains(.,'Total Premium')])[1]");
        My_Page_Objects.put ("saveButton", "XPATH|//button[contains(@id,'button')][@class='x7j p_AFTextOnly'][contains(.,'Save')]");
        My_Page_Objects.put ("bckButton", "XPATH|//button[contains(@id,'button')][@class='x7j p_AFTextOnly'][contains(.,'Back')]");
        My_Page_Objects.put ("referButton", "XPATH|//button[contains(@id,'con:0:cb1')][@class='x7j p_AFTextOnly'][contains(.,'Refer')]");
        My_Page_Objects.put ("acceptButton", "XPATH|//button[contains(@id,'button')][@class='x7j p_AFTextOnly'][contains(.,'Accept')]");

        //Underwriter screen

        My_Page_Objects.put ("checkAvailable", "XPATH|/html[1]/body[1]/div[1]/form[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[5]/a[1]/img[1]");
        My_Page_Objects.put ("lnkBankingDetails", "XPATH|//a[contains(.,'Banking Details')]");
        My_Page_Objects.put ("chkBusinessAccount", "XPATH|//input[contains(@name,'templ:t_r_con:1:sbc6')]");
        My_Page_Objects.put ("txtAccntHolderNam", "XPATH|//input[contains(@name,'templ:t_r_con:1:account_holder_name')]");
        My_Page_Objects.put ("txtAccntHolderID", "XPATH|//input[contains(@name,'templ:t_r_con:1:it8')]");
        My_Page_Objects.put ("txtAccntNumb", "XPATH|//input[contains(@name,'templ:t_r_con:1:account_number')]");
        My_Page_Objects.put ("selctAccntType", "XPATH|//select[contains(@id,'types::content')][@name='templ:t_r_con:1:account_types']");
        My_Page_Objects.put ("selctBankName", "XPATH|//select[contains(@name,'templ:t_r_con:1:soc1')]");
        My_Page_Objects.put ("btnValidate", "XPATH|//a[@href='#'][contains(.,'Validate')]");
        My_Page_Objects.put ("chkMonthDebit", "XPATH|//input[(@type='checkbox')]/ancestor::td/preceding-sibling::td/label[contains(text(),'Month')]/ancestor::td/following-sibling::td/span/span/input");
        My_Page_Objects.put("chkboxProRata","XPATH|//input[contains(@id,'start::content')][@name='templ:t_r_con:1:prorata_debit_order_start']");
        My_Page_Objects.put ("chkAccntHolderConfrm", "XPATH|//input[contains(@id,'con:1:sbc2::content')][@name='templ:t_r_con:1:sbc2']");
        My_Page_Objects.put ("btnSave", "XPATH|//button[contains(@id,'button')][@class='x7j p_AFTextOnly'][contains(.,'Save')]");

        //House Content
        My_Page_Objects.put ("lnkHH", "XPATH|//a[@title='Edit'][contains(.,'House')]");
        My_Page_Objects.put ("selctRegistredOwner", "XPATH|//select[@title='Please Select']/ancestor::td/preceding-sibling::td/label[contains(text(),'Registered Owne')]/ancestor::td/following-sibling::td/select");
        My_Page_Objects.put ("saveBtn", "XPATH|//button[contains(@id,'button')][@class='x7j p_AFTextOnly'][contains(.,'Save')]");
        My_Page_Objects.put ("btnProceed", "XPATH|//a[@href='#'][contains(.,'Proceed')]");

        //Vehicle
        My_Page_Objects.put ("lnkVA", "XPATH|//a[@title='Edit'][contains(.,'Vehicle')]");
        My_Page_Objects.put ("regNo", "XPATH|//input[@type='text']/ancestor::td/preceding-sibling::td/label[contains(text(),'Registration number')]/ancestor::td/following-sibling::td/input");
        My_Page_Objects.put ("VinNo", "XPATH|//input[@type='text']/ancestor::td/preceding-sibling::td/label[contains(text(),'Vin')]/ancestor::td/following-sibling::td/input");
        My_Page_Objects.put ("empSector", "XPATH|//select[@title='Please Select']/ancestor::td/preceding-sibling::td/label[contains(text(),'employment sector')]/ancestor::td/following-sibling::td/select");
        My_Page_Objects.put ("vaSaveBtn", "XPATH|//button[contains(@id,'button')][@class='x7j p_AFTextOnly'][contains(.,'Save')]");

        //Vehicle link
        My_Page_Objects.put ("addVALink", "XPATH|//a[contains(@id,'1')][@title='Edit'][contains(.,'Vehicle')]");

        //Caravan/Trailer
        My_Page_Objects.put ("addCTLink", "XPATH|//a[contains(.,'Caravan/Trailer')]");
        My_Page_Objects.put ("txtRegOwner", "XPATH|//input[@type='text']/ancestor::td/preceding-sibling::td/label[contains(text(),'Registered owner')]/ancestor::td/following-sibling::td/input");
        My_Page_Objects.put ("txtRegNumber", "XPATH|//input[@type='text']/ancestor::td/preceding-sibling::td/label[contains(text(),'Registration Number')]/ancestor::td/following-sibling::td/input");
        My_Page_Objects.put ("txtFinanceExpryDate", "XPATH|//input[@class='x2b']/ancestor::td/preceding-sibling::td/label[contains(text(),'Finance expiry date')]/ancestor::td/following-sibling::td/input");
        My_Page_Objects.put ("CTbtnSave", "XPATH|//button[contains(@id,'button')][@class='x7j p_AFTextOnly'][contains(.,'Save')]");

        //Motorcycle
        My_Page_Objects.put ("addMCLink", "XPATH|//a[contains(@id,'1')][@title='Edit'][contains(.,'Motorcycle')]");
        My_Page_Objects.put ("txtMCRegNumber", "XPATH|//input[@type='text']/ancestor::td/preceding-sibling::td/label[contains(text(),'Registration number')]/ancestor::td/following-sibling::td/input");
        My_Page_Objects.put ("txtMCEngNumber", "XPATH|//input[@type='text']/ancestor::td/preceding-sibling::td/label[contains(text(),'Engine number')]/ancestor::td/following-sibling::td/input");
        My_Page_Objects.put ("txtFinExpDate", "XPATH|/html[1]/body[1]/div[1]/form[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[3]/td[2]/input[1]");

        My_Page_Objects.put ("iconDate", "XPATH|//a[contains(@class,'xij')]");
        My_Page_Objects.put ("upArrwDate", "XPATH|//a[@tabindex='-1'][contains(@id,'date::pop::cd::ys::increment')]");
        My_Page_Objects.put ("dayDate", "XPATH|//td[@tabindex='-1'][contains(.,'17')]");

        My_Page_Objects.put ("btnMCSave", "XPATH|//button[contains(.,'Save')]");

        //Building
        My_Page_Objects.put ("addBldLink", "XPATH|//a[contains(@id,'1')][@title='Edit'][contains(.,'Building')]");
        My_Page_Objects.put ("drpDwnBldRegNumber", "XPATH|//select[@title='Please Select']/ancestor::td/preceding-sibling::td/label[text()='Registered Owner']/ancestor::td/following-sibling::td/select");
        My_Page_Objects.put ("txtFncAgrmtNmb", "XPATH|//input[@type='text']/ancestor::td/preceding-sibling::td/label[contains(text(),'Agreement Number')]/ancestor::td/following-sibling::td/input");
        My_Page_Objects.put ("btnBldSave", "XPATH|//button[contains(.,'Save')]");

        //Electronic
        My_Page_Objects.put ("lnkElect", "XPATH|//a[contains(.,'Electronic')]");
        My_Page_Objects.put ("txtSerialNum", "XPATH|//input[@type='text']/ancestor::td/preceding-sibling::td/label[contains(text(),'Serial Number')]/ancestor::td/following-sibling::td/input");
        My_Page_Objects.put ("saveElectBtn", "XPATH|//button[contains(.,'Save')]");

        //Summary screen
        My_Page_Objects.put ("lblSummary", "XPATH|//h1[@class='x1dc'][contains(.,'Summary')]");
        My_Page_Objects.put ("submtundrwrterBtn", "XPATH|//a[@href='#'][contains(.,'Submit to underwriter')]");
        My_Page_Objects.put ("sucssMsg", "XPATH|//div[@class='x14s'][contains(.,'Generate Policy Schedule document successful')]");
        My_Page_Objects.put ("Okbutton", "XPATH|(//a[@href='#'][contains(.,'OK')])[1]");

        WebDr.page_Objects = My_Page_Objects;
    }

}
