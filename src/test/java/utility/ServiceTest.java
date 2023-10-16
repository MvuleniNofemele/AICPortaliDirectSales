package utility;

import org.apache.jmeter.engine.StandardJMeterEngine;
import org.apache.jmeter.save.SaveService;
import org.apache.jmeter.util.JMeterUtils;
import org.apache.jorphan.collections.HashTree;
import java.io.File;
import java.io.FileInputStream;


public class ServiceTest
{

    public static void main(String[] arg) throws Exception {
        // JMeter Engine
        StandardJMeterEngine jmeter = new StandardJMeterEngine();

        // Initialize Properties, logging, locale, etc.
        JMeterUtils.loadJMeterProperties("C:\\apache-jmeter-4.0\\bin\\jmeter.properties");
        JMeterUtils.setJMeterHome("C:\\apache-jmeter-4.0");
        JMeterUtils.initLogging();// you can comment this line out to see extra log messages of i.e. DEBUG level
        JMeterUtils.initLocale();

        // Initialize JMeter SaveService
        SaveService.loadProperties();

        // Load existing .jmx Test Plan
        File in = new File("C:\\apache-jmeter-4.0\\AOQ_Test_Plan.jmx");
        HashTree testPlanTree = SaveService.loadTree(in);
//        FileInputStream in = new FileInputStream("C:\\Users\\ABASABN\\Desktop\\Selenium_WorkSpace\\Parallel\\Digital_MorningChecks\\JMeterFiles\\JMeter_Framework.jmx");
//        HashTree testPlanTree = SaveService.loadTree(in);

//        in.close();

        // Run JMeter Test
        jmeter.configure(testPlanTree);
        jmeter.run();
    }

}
