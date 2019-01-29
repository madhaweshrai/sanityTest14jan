package listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlTest;

public class ISuiteListener_TNGL implements ISuiteListener
{

	@Override
    public void onFinish(ISuite suite) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onStart(ISuite suite) {
        System.out.println("*******Suite Listener Start");
        System.out.println(":::::::suite detected: " + suite.getName());
        for(XmlTest xmlTest : suite.getXmlSuite().getTests()) {
            System.out.println(":::::::test  detected: " + xmlTest.getName());
            for(XmlClass xmlClass : xmlTest.getClasses()) {
                System.out.println(":::::::class detected: " + xmlClass.getName());
            }
        }
        System.out.println("*******Suite Listener End\n");
    }
	

}
