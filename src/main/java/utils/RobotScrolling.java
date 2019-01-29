package utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class RobotScrolling {
	static Robot robot;

	public static void scrollDown() {
		try {
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_PAGE_DOWN);
			robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
			System.out.println("Scrolled to end of the page");
		} catch (AWTException e) {
			System.out.println("AWTException is caught");
		}
	}

	public static void scrollUp(){
		try {
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_PAGE_UP);
			robot.keyRelease(KeyEvent.VK_PAGE_UP);
			System.out.println("Scrolled to top of the page");
		}catch(AWTException e){
			System.out.println("AWTException is caught");
		}
		}
}
