package AIC_POM;

import utility.WebDr;

import java.util.HashMap;
import java.util.Map;

public class CIF_Client_POM {

    public static void SetPage_CIF_Client()
    {
        Map<String, String> My_Page_Objects = new HashMap<String, String>();
        My_Page_Objects.put("tabCampaigns", "XPATH|//a[@id='templ:Campains::disAcr']");
        My_Page_Objects.put("tabSiebel", "XPATH|//a[@id='templ:Siebel::disAcr']");
        My_Page_Objects.put("lnkDummyCampaign", "XPATH|//a[contains(text(),'Dummy Campaign')]");
        My_Page_Objects.put("lnkDummyVirtualAdvisersCampaign", "XPATH|//a[contains(text(),'Dummy Virtual Advisers Campaign')]");
//        My_Page_Objects.put("lnkIDirect", "XPATH|//a[contains(text(),'ID idirect')]");
//        My_Page_Objects.put("lnkIDirect", "XPATH|//table[@id='s_1_l']/tbody/tr/td/a[contains(text(),'ID idirect')]");
        My_Page_Objects.put("lnkIDirect", "XPATH|//tr[@class='ui-widget-content jqgrow ui-row-ltr']//td[@title='ID idirect']//a[contains(text(),'ID idirect')]");
//        My_Page_Objects.put("lnkIDirect", "XPATH|//a[contains(text(),'Dummy Campaign')]");
//        My_Page_Objects.put("btnContactProspectNew", "XPATH|//button[@id='s_3_1_26_0_Ctrl']");
        My_Page_Objects.put("btnContactProspectNew", "XPATH|//button[@class='siebui-ctrl-btn siebui-icon-newrecord s_3_1_26_0 appletButton']");
        My_Page_Objects.put("btnContactProspectQuery", "XPATH|//button[@id='s_3_1_25_0_Ctrl']");
        My_Page_Objects.put("btnContactProspectMenu", "XPATH|//button[@id='s_at_m_3']");
        My_Page_Objects.put("txtContactProspectListApplet", "XPATH|//td[@id='1_s_3_l_Contact_Last_Name']");
        My_Page_Objects.put("bntContactProspectListApplet", "XPATH|//span[@id='s_3_2_156_0_icon']");
        My_Page_Objects.put("bntPickContactNew", "XPATH|//button[@id='s_4_1_26_0_Ctrl']");


        //Pick Contact
        My_Page_Objects.put("txtPickContactLastName", "XPATH|//input[@id='1_Last_Name']");
        My_Page_Objects.put("txtPickContactFirstName", "XPATH|//input[@id='1_First_Name']");
        My_Page_Objects.put("txtPickContactIdType", "XPATH|//input[@name='Iden_Type']");
        My_Page_Objects.put("txtPickContactIdNumber", "XPATH|//input[@id='1_Iden_Information']");
        My_Page_Objects.put("txtPickContactBirthDate", "XPATH|//input[@id='1_Birth_Date']");
        My_Page_Objects.put("txtPickContactCellPhone", "XPATH|//input[@id='1_Cellular_Phone__']");
        My_Page_Objects.put("btnPickContactOk", "XPATH|//button[@title='Pick Contact:OK']");
        My_Page_Objects.put("btnPickContactCancel", "XPATH|(//button[@title='Pick Contact:Cancel'])[2]");


        //My_Page_Objects.put ("bntInitQuote", "XPATH|//input[@name='s_2_1_29_0']");
        My_Page_Objects.put ("btnQueryCIF", "XPATH|//button[@name='s_2_1_76_0']");
        //My_Page_Objects.put ("btnCreateUpdateCIF", "XPATH|//input[@name='s_2_1_30_0']");
        My_Page_Objects.put ("txtLastName", "XPATH|//input[@name='s_2_1_29_0']");
        My_Page_Objects.put ("txtFirstName", "XPATH|//input[@name='s_2_1_30_0']");
        My_Page_Objects.put ("txtClientType", "XPATH|//input[@name='s_2_1_32_0']");
        My_Page_Objects.put ("txtIdType", "XPATH|//input[@name='s_2_1_54_0']");
        My_Page_Objects.put ("txtIdNumber", "XPATH|//input[@name='s_2_1_49_0']");
        My_Page_Objects.put ("txtPassportIssued", "XPATH|//input[@name='s_2_1_52_0']");
        My_Page_Objects.put ("txtDOB", "XPATH|//input[@name='s_2_1_51_0']");
        My_Page_Objects.put ("txtPermitNo", "XPATH|//input[@name='s_2_1_51_0']");
        My_Page_Objects.put ("drDwnCountryOfRes", "XPATH|//input[@name='s_2_1_53_0']");
        My_Page_Objects.put ("drDwnCountryOfBirth", "XPATH|//input[@name='s_2_1_50_0']");
        My_Page_Objects.put ("drDwnNationality", "XPATH|//input[@name='s_2_1_80_0']");
        My_Page_Objects.put ("txtCIF_Code", "XPATH|//input[@name='s_2_1_2_0");
        My_Page_Objects.put ("txtOccupationStatus", "XPATH|//input[@name='s_2_1_1_0");
        My_Page_Objects.put ("txtOccupation", "XPATH|//input[@name='s_2_1_0_0']");
        My_Page_Objects.put ("txtInitials", "XPATH|//input[@name='s_2_1_31_0']");
        My_Page_Objects.put ("drDwnTitle", "XPATH|//input[@name='s_2_1_47_0']");
        My_Page_Objects.put ("drDwnGender", "XPATH|//input[@name='s_2_1_48_0']");
        My_Page_Objects.put ("txtWorkPhone", "XPATH|//input[@name='s_2_1_34_0']");
        My_Page_Objects.put ("txtFaxNo", "XPATH|//input[@name='s_2_1_35_0']");
        My_Page_Objects.put ("txtHomePhone", "XPATH|//input[@name='s_2_1_36_0']");
        My_Page_Objects.put ("txtCellNo", "XPATH|//input[@name='s_2_1_18_0");
        My_Page_Objects.put ("txtContactMade", "XPATH|//input[@name='s_2_1_19_0']");
        My_Page_Objects.put ("drDwnMaritalStatus", "XPATH|//input[@name='s_2_1_22_0']");
        My_Page_Objects.put ("drDwnContractType", "XPATH|//input[@name='s_2_1_79_0");
        My_Page_Objects.put ("txtEmail", "XPATH|//input[@name='s_2_1_44_0']");
        My_Page_Objects.put ("drDwnCorrespLanguage", "XPATH|//input[@name='s_2_1_21_0']");
        My_Page_Objects.put ("drDwnSourceOfFunds", "XPATH|//input[@name='s_2_1_5_0']");
        My_Page_Objects.put ("chBxStuffFlag", "XPATH|//input[@name='s_2_1_4_0']");
        My_Page_Objects.put ("chBxDuplicatePolicy", "XPATH|//input[@name='s_2_1_7_0']");
        My_Page_Objects.put ("chBxDuplicateQuote", "XPATH|//input[@name='s_2_1_6_0']");
        My_Page_Objects.put ("chBxMarketingConsent", "XPATH|//input[@name='s_2_1_86_0']");
        My_Page_Objects.put ("chBxPrefCall", "XPATH|//input[@name='s_2_1_87_0']");
        My_Page_Objects.put ("chBxPreSMS", "XPATH|//input[@name='s_2_1_92_0']");
        My_Page_Objects.put ("chBxPreEmail", "XPATH|//input[@name='s_2_1_90_0']");
        My_Page_Objects.put ("chBxPreMail", "XPATH|//input[@name='s_2_1_91_0']");
        My_Page_Objects.put ("chBxPreVR", "XPATH|//input[@name='s_2_1_88_0']");
        My_Page_Objects.put ("chBxIsolation", "XPATH|//input[@name='s_2_1_95_0']");
        My_Page_Objects.put ("btnSearchIsolationContact", "XPATH|//input[@name='s_2_1_94_0']");
        My_Page_Objects.put ("drDwnPreCommMethod", "XPATH|//input[@name='s_2_1_24_0']");
        My_Page_Objects.put ("txtAddressLineOne", "XPATH|//input[@name='s_2_1_10_0']");
        My_Page_Objects.put ("btnAddressSearch", "XPATH|//span[@id='s_2_1_10_0_icon']");
        My_Page_Objects.put ("txtAddressLineTwo", "XPATH|//input[@name='s_2_1_11_0']");
        My_Page_Objects.put ("txtCity", "XPATH|//input[@name='s_2_1_8_0']");
        My_Page_Objects.put ("txtSuburb", "XPATH|//input[@name='s_2_1_46_0']");
        My_Page_Objects.put ("txtPostalCode", "XPATH|//input[@name='s_2_1_9_0']");
        My_Page_Objects.put ("txtReference", "XPATH|//input[@name='s_2_1_81_0']");
        My_Page_Objects.put ("txtScreeningDate", "XPATH|//input[@name='s_2_1_82_0']");
        My_Page_Objects.put ("drDwnScreeningStatus", "XPATH|//input[@name='s_2_1_61_0']");
        My_Page_Objects.put ("txtRiskProfilingStatus", "XPATH|//input[@name='s_2_1_59_0']");
        My_Page_Objects.put ("txtAnalysisComments", "XPATH|//textarea[@name='s_2_1_65_0']");

        My_Page_Objects.put ("tabAuditTrial", "XPATH|//a[@id='ui-id-675']");
        My_Page_Objects.put ("tabLeads", "XPATH|//a[@id='ui-id-676']");
        My_Page_Objects.put ("tabActivities", "XPATH|//a[@id='ui-id-677']");
        My_Page_Objects.put ("tabCampaignManager", "XPATH|//a[@id='ui-id-678']");
        My_Page_Objects.put ("tabFinancialAccounts", "XPATH|//a[@id='ui-id-679']");
        My_Page_Objects.put ("tabFA_Acc_No", "XPATH|//a[@id='ui-id-680']");
        My_Page_Objects.put ("tabAVAF_Financial_Accounts", "XPATH|//a[@id='ui-id-681']");
        My_Page_Objects.put ("tabPolicies", "XPATH|//a[@id='ui-id-682']");

        WebDr.page_Objects = My_Page_Objects;
    }
}
