/*
 * @author vysyaki (Kiranraju Vysyaraju)
 * @email kiranraju.vysyaraju@tecnotree.com
*/

package framework.utils;

public class FileReaderUtils {

	private static FileReaderUtils fileReaderManager = new FileReaderUtils();
	private static PropertiesReader configFileReader;
	private static JsonDataReader jsonDataReader;

	private FileReaderUtils() {
	}

	public static FileReaderUtils getInstance() {
		return fileReaderManager;
	}

	public PropertiesReader getConfigReader() {
		return (configFileReader == null) ? new PropertiesReader() : configFileReader;
	}

	public JsonDataReader getRetailRegistrationJsonReader() {
		return (jsonDataReader == null) ? new JsonDataReader("RetailRegistration") : jsonDataReader;
	}

	public JsonDataReader getCorporateRegistrationJsonReader() {
		return (jsonDataReader == null) ? new JsonDataReader("CorporateRegistration") : jsonDataReader;
	}
}