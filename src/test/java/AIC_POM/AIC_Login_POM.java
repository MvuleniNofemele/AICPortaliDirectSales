package AIC_POM;

import utility.WebDr;

import java.util.HashMap;
import java.util.Map;

public class AIC_Login_POM {
	
	public static void SetPage_AOL_LOGIN()
	{
		Map<String, String> My_Page_Obejcts = new HashMap<String, String>();		
		My_Page_Obejcts.put("txtUsername", "XPATH|(//input[@id='username'])[1]");
		My_Page_Obejcts.put("txtPassword", "XPATH|(//input[@id='password'])[1]");
		My_Page_Obejcts.put("btnSignIn", "XPATH|(//input[@id='kc-login'])[1]");
		My_Page_Obejcts.put("tabCampaigns", "XPATH|//a[@id='templ:Campains::disAcr']");

		WebDr.page_Objects=My_Page_Obejcts;
	}
}

