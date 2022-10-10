/*
 * @author vysyaki (Kiranraju Vysyaraju)
 * @email kiranraju.vysyaraju@tecnotree.com
*/

package framework.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.google.gson.Gson;

import framework.testDataTypes.retail.Customer;
import framework.testDataTypes.corporate.CorpCustomer;

public class JsonDataReader {
	private final String retailCustomerFilePath = FileReaderUtils.getInstance().getConfigReader().getTestDataResourcePath()
			+ FileReaderUtils.getInstance().getConfigReader().getOpco() + "/Retail_Customer.json";
	private final String corporateCustomerFilePath = FileReaderUtils.getInstance().getConfigReader().getTestDataResourcePath()
			+ FileReaderUtils.getInstance().getConfigReader().getOpco() + "/Corporate_Customer.json";
	private Customer retailCustomer;
	private CorpCustomer corporateCustomer;

	public JsonDataReader(String useCaseType) {
		if (useCaseType.equalsIgnoreCase("RetailRegistration"))
			retailCustomer = getRetailCustomerData();
		else if (useCaseType.equalsIgnoreCase("CorporateRegistration"))
			corporateCustomer = getCorporateCustomerData();
	}

	private Customer getRetailCustomerData() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(retailCustomerFilePath));
			Customer customer = gson.fromJson(bufferReader, Customer.class);
			return customer;
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + retailCustomerFilePath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}
	}

	private CorpCustomer getCorporateCustomerData() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(corporateCustomerFilePath));
			CorpCustomer corpCustomer = gson.fromJson(bufferReader, CorpCustomer.class);
			return corpCustomer;
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + corporateCustomerFilePath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}
	}

	public final Customer getRetailCustomer() {
		return retailCustomer;
	}

	public final CorpCustomer getCorpCustomer() {
		return corporateCustomer;
	}
}