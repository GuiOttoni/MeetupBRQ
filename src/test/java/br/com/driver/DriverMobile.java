package br.com.driver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;

public class DriverMobile {

	private static AndroidDriver driverAndroid;
	public static String appiumServer = "";
	private static String platformName = "";
	private static String deviceName = "";
	private static boolean noReset = true;
	private static String platformVersion = "";
	private static String appPackage = "";
	private static String appActivity = "";
	private static boolean autoGrantPermissions = true;
	private static boolean gpsEnabled = true;
	private static boolean dontStopAppOnReset = true;

	/**
	 * @return retorna o driver
	 */
	public static AndroidDriver getDriverMob() {
		if (driverAndroid == null) {
			setarConfiguracoesDoDriver();
		}
		return driverAndroid;
	}

	private static void setarConfiguracoesDoDriver() {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", platformName);
		cap.setCapability("deviceName", deviceName);
		cap.setCapability("platformVersion", platformVersion);
		cap.setCapability("appPackage", appPackage);
		cap.setCapability("appActivity", appActivity);
		cap.setCapability("noReset", noReset);
		cap.setCapability("autoGrantPermissions", autoGrantPermissions);
		cap.setCapability("gpsEnabled", gpsEnabled);
		cap.setCapability("dontStopAppOnReset", dontStopAppOnReset);

		try {
			driverAndroid = new AndroidDriver(new URL(appiumServer), cap);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		driverAndroid.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	/**
	 * Mata o processo do driver instanciado.
	 */
	public static void killDriver() {
		if (driverAndroid != null) {
			driverAndroid.quit();
			driverAndroid = null;
		}
	}

}
