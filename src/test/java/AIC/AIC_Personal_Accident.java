package AIC;

import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import utility.WebDr;

public class AIC_Personal_Accident extends WebDr
{
    public AIC_Personal_Accident(WebDriver wdriver, ExtentTest test)
    {
        this.wdriver = wdriver;
        this.test = test;
    }

    public boolean fn_PersonalAccidentDetail() throws Exception
    {
        boolean electronicDetail = false;

        try
        {

            //Insured Cover Details

            //Spouse Cover Details

            //Child

            //Conditions

            //Notes

            electronicDetail = true;
        }catch (Exception e) {
            throw e;
        }

        return electronicDetail;
    }
}
