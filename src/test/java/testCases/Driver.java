package testCases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utility.Launcher;

import java.util.HashMap;
import java.util.Map;

public class Driver extends Launcher /*implements Runnable*/{
    public static String userDir, file_TestData;
    public static Map<String, String> dictionary = new HashMap<String, String>();
    public static int i = 0;

    public static void main (String args[]) throws Exception {
        Driver ob = new Driver();
        ob.mainDriver("Chrome");
        //ob.mainDriver("Firefox");
        //ob.mainDriver("IE");
    }

    @Test
    @Parameters("Browser")
    public void mainDriver(String testngBrowser) {
        try{
            userDir = System.getProperty("user.dir");
            file_TestData= "AIC_MasterData_TP Updated Idirect_v1.xlsx";
            InvokeLauncher(testngBrowser);
        }
        catch (Exception e){
            System.out.println ("Exception in Driver.mainDriver" + e.toString ());

        }
    }
}
