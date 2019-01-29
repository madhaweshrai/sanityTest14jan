package utils;

import java.util.Date;

public class Utils {

	private static long logsTime = 0, loglTime = 0, logStep = 0;

	public static void startTime() {
		logsTime = System.currentTimeMillis();
		loglTime = logsTime;
		logStep = 0;

		Date currentDate = new Date(logsTime);
		String fullClassName = Thread.currentThread().getStackTrace()[2].getClassName();
		String className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
		String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		int lineNumber = Thread.currentThread().getStackTrace()[2].getLineNumber();

		System.out.println("Start Time => " + className + " - " + methodName + " - " + lineNumber + " : "
				+ currentDate.toString() + " : Step" + logStep + " -> " + (logsTime - loglTime));
		logStep++;
	}

	public static void stepTime() {
		loglTime = System.currentTimeMillis();

		Date currentDate = new Date(loglTime);
		String fullClassName = Thread.currentThread().getStackTrace()[2].getClassName();
		String className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
		String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		int lineNumber = Thread.currentThread().getStackTrace()[2].getLineNumber();

		System.out.println("Step Time => " + className + " - " + methodName + " - " + lineNumber + " : "
				+ currentDate.toString() + " : Step" + logStep + " -> " + ((loglTime - logsTime)/1000) + " sec");
		logStep++;
	}
}
