package com.base;

import org.openqa.selenium.WebDriver;

import com.utilities.Helper;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseClass {
	
	//Utilities object references
	protected static Helper helper = new Helper();
	
	//webdriver
	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<>();
	
	//reporting
	public Logger logger = LogManager.getLogger("Log");
	public String[] data = new String[1000];
	public static String mainExtentReportFolder = System.getProperty("user.dir")+"./Test-Output/ExtentHtmlReports/";
	public static String downloadFilepath = System.getProperty("user.home") + "\\Downloads";
	public static String DriverScreenCapturefolder = "./Test-Output/ScreenShots/DriverScreenshots/DriverScreenshot";
	public static String DriverScreenCapturepath;
	public static String FullScreenCapturefolder = "./Test-Output/ScreenShots/FullScreenshot";
	public static String FullScreenShotspath;
	public static String extentReportPath;
	
	//Object reference for excel sheets
	
	/********Wait Time****/
	public static final int pageLoadTime = 10;
	public final long explicitwait = 6;
	
	//get driver for threadlocal
	public synchronized static WebDriver getDriver() {
		return tldriver.get();
	}

	public static void preSetup() {
		FullScreenShotspath = FullScreenCapturefolder + helper.getCurrentDateTime().replace("/", "-") + "/";
		new File(FullScreenShotspath).mkdirs();
		System.out.println("FullScreenShotPath Created: " + FullScreenShotspath);
		
		DriverScreenCapturepath = DriverScreenCapturefolder + helper.getCurrentDateTime().replace("/", "-") + "/";
		new File(DriverScreenCapturepath).mkdirs();
		System.out.println("DriverScreenShotPath created: " + DriverScreenCapturepath);
		
		extentReportPath = mainExtentReportFolder + helper.getCurrentDateTime().replace("/", "-")
				+ "ExtentReportResults.html";
		System.out.println("ExtentReportPath Created: " + extentReportPath);
		
	}
}
