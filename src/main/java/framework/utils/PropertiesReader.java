/*
 * @author vysyaki (Kiranraju Vysyaraju)
 * @email kiranraju.vysyaraju@tecnotree.com
*/

package framework.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
	private Properties properties;
	private final String propertyFilePath = "configs//";
	private String opcoValue, envValue;

	public PropertiesReader() {
		BufferedReader reader = null, envReader = null;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath + "config.properties"));
			properties = new Properties();
			try {
				properties.load(reader);
				opcoValue = properties.getProperty("opco");
				envValue = properties.getProperty("env");
				envReader = new BufferedReader(new FileReader(propertyFilePath + opcoValue + "//" + envValue + ".properties"));
				properties.load(envReader);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Properties file not found at path : " + propertyFilePath);
		} finally {
			try {
				if (reader != null)
					reader.close();
				if (envReader != null)
					envReader.close();
			} catch (IOException ignore) {
			}
		}
	}

	public long getImplicitlyWait() {
		String implicitlyWait = properties.getProperty("implicitlyWait");
		if (implicitlyWait != null) {
			try {
				return Long.parseLong(implicitlyWait);
			} catch (NumberFormatException e) {
				throw new RuntimeException("Not able to parse value : " + implicitlyWait + " in to Long");
			}
		}
		else
			return 30;
	}

	public String getApplicationUrl() {
		String url = properties.getProperty("clm_url");
		if (url != null)
			return url;
		else
			throw new RuntimeException(
					"Application Url not specified in the config.properties file for the Key: clm_url");
	}

	public String getOpco() {
		if (opcoValue != null)
			return opcoValue;
		else
			throw new RuntimeException(
					"OPCO not specified in the config.properties file for the Key: opco");
	}

	public String getEnv() {
		if (envValue != null)
			return envValue;
		else
			throw new RuntimeException(
					"ENV not specified in the config.properties file for the Key: env");
	}

	public String getCLMUserName() {
		String username = properties.getProperty("clm_username");
		if (username != null)
			return username;
		else
			throw new RuntimeException(
					"username not specified in the config.properties file for the Key: clm_username");
	}

	public String getCLMPassword() {
		String password = properties.getProperty("clm_password");
		if (password != null)
			return password;
		else
			throw new RuntimeException(
					"password not specified in the config.properties file for the Key: clm_password");
	}

	public String getCBSConnectionString() {
		String connectionString = properties.getProperty("cbs_connection_string");
		if (connectionString != null)
			return connectionString;
		else
			throw new RuntimeException(
					"CBS connectionString not specified in the config.properties file for the Key: cbs_connection_string");
	}

	public String getCBSUserName() {
		String username = properties.getProperty("cbs_username");
		if (username != null)
			return username;
		else
			throw new RuntimeException(
					"username not specified in the config.properties file for the Key: cbs_username");
	}

	public String getCBSPassword() {
		String password = properties.getProperty("cbs_password");
		if (password != null)
			return password;
		else
			throw new RuntimeException(
					"password not specified in the config.properties file for the Key: cbs_password");
	}

	public Boolean screenshotRequiredForPassedAlso() {
		String screenshotRequiredForPassedAlso = properties.getProperty("screenshotRequiredForPassedAlso");
		if (screenshotRequiredForPassedAlso != null)
			return Boolean.valueOf(screenshotRequiredForPassedAlso);
		else
			return false;
	}

	public String getBrowser() {
		String browserName = properties.getProperty("browser");
		if (browserName == null || browserName.equals("chrome") || browserName.equals(""))
			return "chrome";
		else
			return browserName;
	}

	public Boolean getBrowserWindowSize() {
		String windowSize = properties.getProperty("windowMaximize");
		if (windowSize != null)
			return Boolean.valueOf(windowSize);
		else
			return false;
	}

	public Boolean getBrowserWindowFullScreen() {
		String windowFullScreen = properties.getProperty("windowFullScreen");
		if (windowFullScreen != null)
			return Boolean.valueOf(windowFullScreen);
		else
			return false;
	}
	
	public Boolean clickViaJs() {
		String clickViaJs = properties.getProperty("clickViaJs");
		if (clickViaJs != null)
			return Boolean.valueOf(clickViaJs);
		else
			return false;
	}
	
	public Boolean holdBrowserOpen() {
		String holdBrowserOpen = properties.getProperty("holdBrowserOpen");
		if (holdBrowserOpen != null)
			return Boolean.valueOf(holdBrowserOpen);
		else
			return false;
	}

	public Boolean isHeadless() {
		String headless = properties.getProperty("headless");
		if (headless != null)
			return Boolean.valueOf(headless);
		else
			return false;
	}

	public String getTestDataResourcePath() {
		String testDataResourcePath = properties.getProperty("testDataResourcePath");
		if (testDataResourcePath != null)
			return testDataResourcePath;
		else
			throw new RuntimeException(
					"Test Data Resource Path not specified in the config.properties file for the Key:testDataResourcePath");
	}

	public String getReportConfigPath() {
		String reportConfigPath = properties.getProperty("reportConfigPath");
		if (reportConfigPath != null)
			return reportConfigPath;
		else
			throw new RuntimeException(
					"Report Config Path not specified in the config.properties file for the Key:reportConfigPath");
	}

	public boolean fullPageScreenshotRequired() {
		String fullPageScreenshotRequired = properties.getProperty("fullPageScreenshotRequired");
		if (fullPageScreenshotRequired != null)
			return Boolean.valueOf(fullPageScreenshotRequired);
		else
			return false;
	}

	public String getBuildVersion() {
		String buildVersion = properties.getProperty("buildVersion");
		if (buildVersion != null)
			return buildVersion;
		else
			throw new RuntimeException(
					"Report Config Path not specified in the config.properties file for the Key:buildVersion");
	}
}