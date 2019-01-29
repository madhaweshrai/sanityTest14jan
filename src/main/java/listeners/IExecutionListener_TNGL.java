package listeners;

import org.testng.IExecutionListener;

public class IExecutionListener_TNGL implements IExecutionListener
{
	private long startTime;
	public void onExecutionStart() {
		// TODO Auto-generated method stub
		startTime = System.currentTimeMillis();
	    System.out.println("TestNG is going to start"); 
	}

	public void onExecutionFinish() {
		// TODO Auto-generated method stub
		System.out.println("TestNG has finished, took around " 
		+ (System.currentTimeMillis() - startTime) + "ms");
	}

}
