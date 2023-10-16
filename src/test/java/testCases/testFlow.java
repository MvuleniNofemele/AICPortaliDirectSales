package testCases;

import AIC.*;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import utility.WebDr;

public class testFlow extends WebDr {

    public testFlow(ExtentTest test, ExtentReports extent) {
        this.test = test;
        this.extent = extent;
    }

    public void executeTC(String fn_name,String preferBrowser) {
        try {

            fn_AIC_Entry_Flow(preferBrowser);
//            switch (fn_name)
//            {
//                case "fn_AIC_Entry_Flow": fn_AIC_Entry_Flow(preferBrowser);
//                //default:System.out.println("Please enter valid function Name");
//            }

            wdriver.quit();

        } catch (Exception exception) {
            wdriver.quit();
        }
    }

    public void fn_AIC_Entry_Flow(String preferBrowser) throws Exception {
        String sURL=getCellData(5,1);
        openApplication(sURL, preferBrowser);
        String sCampaignType = getValue("CampaignType");
        String sTestScenario = getValue("TestCase_Name");
        //String sTestScenario = "PL_REQ_Premium_023";

        AIC_Common aic_common = new AIC_Common(wdriver, test);

        if(new AIC_Login(wdriver,test).fn_Portal_Login())
        {
            if(sCampaignType.equalsIgnoreCase("NewCampaign"))
            {
                if(new CIF_Client(wdriver, test).fn_CreateCampaign())//This code needs to be removed since we no longer creating campaigns using Siebel
                {
                    if(new AIC_Vehicle(wdriver, test).fn_VehicleDetails())
                    {

                    }
                }
            }
            else
            {
                if(aic_common.fn_selectCampaign()) {
                   // if(aic_common.fn_Current()) {
                        if (aic_common.fn_Insured()) {
                            if(aic_common.fn_needsSelectionAndFillUp(sTestScenario)) {
                                if(aic_common.fn_Quoting()){
                                    if (aic_common.fn_Underwriting()) {
                                        if(aic_common.fn_Summary()){
                                            /*if(aic_common.fn_Status()){
                                                if(aic_common.fn_Documents()){

                                                }
                                            }*/
                                        }
                                    }
                                }

                            }
                        }
                    //}

                }
            }

        }
    }
}
