package AIC;

import AIC_POM.AIC_Login_POM;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import utility.WebDr;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class AIC_Login extends WebDr {

	public AIC_Login(WebDriver wdriver, ExtentTest test) {
		this.wdriver = wdriver;
		this.test = test;
	}
	
	public boolean fn_Portal_Login() throws Exception  //String URL,String sAcntNum,String sLandingPage
	{
		AIC_Login_POM.SetPage_AOL_LOGIN();
		String sUserName = "ABMNAET"; //getValue("User_Name");
    	String sPassWord = "0738576880@Blue"; //getValue("Password");
    	boolean boolPortalLogin = false;

		try
		{


			setText("txtUsername", sUserName, "Login Page - Enter Username");
			setText("txtPassword", sPassWord, "Login Page - Enter Password");

			click("btnSignIn", "Login Page - Click Login Button");
			Thread.sleep(5000);

			if (!exists("tabCampaigns", true, "Campaigns Tab")){
				WriteStep(wdriver, "Login Failed","Login Pass", "Login Failed", "Fail");
				return boolPortalLogin;
			}

			//WriteStep(wdriver, "Login Successful","Login Pass", "Login Pass", "Pass");
			boolPortalLogin = true;

		}
		catch (Exception e)
		{
			throw e;
		}

		return boolPortalLogin;
	}

	/*
	public boolean fn_Salesforce_Login() throws Exception  //String URL,String sAcntNum,String sLandingPage
	{
		AIC_Login_POM.SetPage_AOL_LOGIN();
		String sUserName = "lamlile.londa@absa.africa.a2aic"; //getValue("User_Name");
		String sPassWord = "isTumel0*2021"; //getValue("Password");
		boolean boolPortalLogin = false;

		try
		{
			setText("txtUsername", sUserName, "Login Page - Enter Username");
			setText("txtPassword", sPassWord, "Login Page - Enter Password");
			click("btnSignIn", "Login Page - Click Login Button");
			Thread.sleep(5000);

			if (!exists("tabCampaigns", true, "Campaigns Tab")){
				WriteStep(wdriver, "Login Failed","Login Pass", "Login Failed", "Fail");
				return boolPortalLogin;
			}

			//WriteStep(wdriver, "Login Successful","Login Pass", "Login Pass", "Pass");
			boolPortalLogin = true;

		}
		catch (Exception e)
		{
			throw e;
		}

		return boolPortalLogin;
	}*/
}
