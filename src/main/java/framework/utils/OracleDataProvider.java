/*
 * @author vysyaki (Kiranraju Vysyaraju)
 * @email kiranraju.vysyaraju@tecnotree.com
*/

package framework.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

@SuppressWarnings("rawtypes")
public class OracleDataProvider {
	private static Connection connection = null;
	private ResultSet resultSet = null;
	private String returnParams[];
	private HashMap<String, String> dataSet = new HashMap<String, String>();
	private Set<Entry<String, String>> set;
	private Iterator<Entry<String, String>> iterator;

	private String serviceCode, serviceStatus, provisioningStatus, orderStatus, schedulesStatus, scheduleLinkCode;

	public OracleDataProvider() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection(
					FileReaderUtils.getInstance().getConfigReader().getCBSConnectionString(),
					FileReaderUtils.getInstance().getConfigReader().getCBSUserName(),
					FileReaderUtils.getInstance().getConfigReader().getCBSPassword());
			System.out.println("Connected to oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return connection;
	}

	public static void closeConnection() {
		try {
			if (connection != null)
				connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Disconnected to oracle");
	}

	public HashMap<String, String> executeSelectQuery(String columns, String tableName, String whereCondition,
			String sortParams) {
		try {
			String query = "SELECT * FROM (" + "SELECT " + columns + " FROM " + tableName + whereCondition + sortParams
					+ ") WHERE ROWNUM = 1";
			System.out.println("Query is:\n" + query);
			resultSet = getConnection().createStatement().executeQuery(query);
			String columnNames[] = columns.split(",");
			returnParams = new String[columnNames.length];
			while (resultSet.next())
				for (int i = 0; i < columnNames.length; i++) {
					returnParams[i] = resultSet.getString(columnNames[i]);
					dataSet.put(columnNames[i], returnParams[i]);
				}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dataSet;
	}

	public String[] getServiceInfo(String msisdn) {
		dataSet = executeSelectQuery("ACCOUNT_LINK_CODE_N,STATUS_CODE_V", "CB_ACCOUNT_SERVICE_LIST",
				" WHERE SERVICE_INFO_V = '" + msisdn + "'", " ORDER BY FROM_DATE_D DESC");
		String[] serviceInfo = new String[2];
		set = dataSet.entrySet();
		iterator = set.iterator();
		while (iterator.hasNext()) {
			Map.Entry entry = (Map.Entry) iterator.next();
			if (entry.getKey().equals("STATUS_CODE_V"))
				serviceStatus = (String) entry.getValue();
			else if (entry.getKey().equals("ACCOUNT_LINK_CODE_N"))
				serviceCode = (String) entry.getValue();
		}
		serviceInfo[0] = serviceStatus;
		serviceInfo[1] = serviceCode;
		return serviceInfo;
	}

	public String validateServiceStatus(String msisdn, String expectedStatus) {
		int i = 0;
		String[] serviceInfo = null;
		while (i < 24) {
			System.out.println("Service status check iteration - " + i);
			serviceInfo = getServiceInfo(msisdn);
			System.out.println("Service status: " + serviceInfo[0]);
			if (serviceInfo[0].equals(expectedStatus)) {
				ExtentCucumberAdapter.addTestStepLog("Final Service status is: " + expectedStatus);
				return serviceInfo[0];
			}
			i++;
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		ExtentCucumberAdapter.addTestStepLog("Final Service status is " + serviceInfo[0]);
		return serviceInfo[0];
	}

	public String getProvisioningInfo(String serviceCode) {
		dataSet = executeSelectQuery("STATUS_V", "CB_SUBS_PROVISIONING", " WHERE ACCOUNT_LINK_CODE_N = " + serviceCode,
				" ORDER BY ACTION_DATE_DT DESC");
		set = dataSet.entrySet();
		iterator = set.iterator();
		while (iterator.hasNext()) {
			Map.Entry entry = (Map.Entry) iterator.next();
			if (entry.getKey().equals("STATUS_V"))
				provisioningStatus = (String) entry.getValue();
		}
		return provisioningStatus;
	}

	public String validateProvisioningStatus() {
		int i = 0;
		String provStatus = null;
		while (i < 24) {
			System.out.println("Provisioning status check iteration - " + i);
			provStatus = getProvisioningInfo(serviceCode);
			System.out.println("Provisioning status: " + provStatus);
			if (provStatus.equals("E")) {
				ExtentCucumberAdapter.addTestStepLog("Final Provisioning status is E");
				return provStatus;
			}
			i++;
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		ExtentCucumberAdapter.addTestStepLog("Final Provisioning status is: " + provStatus);
		return provStatus;
	}

	public String[] getSchedulesInfo(String serviceCode, String keyCode) {
		dataSet = executeSelectQuery("STATUS_OPTN_V,SCHDL_LINK_CODE_N", "CB_SCHEDULES",
				" WHERE SERV_ACC_LINK_CODE_N = " + serviceCode + " AND SERVICE_KEY_CODE_V = '" + keyCode + "'",
				" ORDER BY SCHDL_LINK_CODE_N DESC");
		String[] schedulesInfo = new String[2];
		set = dataSet.entrySet();
		iterator = set.iterator();
		while (iterator.hasNext()) {
			Map.Entry entry = (Map.Entry) iterator.next();
			if (entry.getKey().equals("STATUS_OPTN_V"))
				schedulesStatus = (String) entry.getValue();
			if (entry.getKey().equals("SCHDL_LINK_CODE_N"))
				scheduleLinkCode = (String) entry.getValue();
		}
		schedulesInfo[0] = schedulesStatus;
		schedulesInfo[1] = scheduleLinkCode;
		return schedulesInfo;
	}

	public String validateSchedulesStatus(String keyCode) {
		int i = 0;
		String[] schedulesInfo = null;
		while (i < 24) {
			System.out.println("Schedules status check iteration - " + i);
			schedulesInfo = getSchedulesInfo(serviceCode, keyCode);
			System.out.println("Schedules status: " + schedulesInfo[0]);
			if (schedulesInfo[0].equals("A")) {
				ExtentCucumberAdapter.addTestStepLog("Final Schedules status is A");
				return schedulesInfo[0];
			}
			i++;
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		ExtentCucumberAdapter.addTestStepLog("Final Schedules status is: " + schedulesInfo[0]);
		return schedulesInfo[0];
	}

	public String getOrderStatus(String scheduleLinkCode) {
		dataSet = executeSelectQuery("STATUS_CODE_V", "CB_ORCH_REQUEST_DTLS",
				" WHERE SCHDL_LINK_CODE_N = '" + scheduleLinkCode + "'", " ORDER BY SEQ_NUM_N DESC");
		set = dataSet.entrySet();
		iterator = set.iterator();
		while (iterator.hasNext()) {
			Map.Entry entry = (Map.Entry) iterator.next();
			if (entry.getKey().equals("STATUS_CODE_V"))
				orderStatus = (String) entry.getValue();
		}
		return orderStatus;
	}

	public String validateOrderStatus() {
		int i = 0;
		while (i < 24) {
			System.out.println("Order status check iteration - " + i);
			orderStatus = getOrderStatus(scheduleLinkCode);
			System.out.println("Order status: " + orderStatus);
			if (orderStatus.equals("E")) {
				ExtentCucumberAdapter.addTestStepLog("Final Order status is E");
				return orderStatus;
			}
			i++;
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		ExtentCucumberAdapter.addTestStepLog("Final Order status is: " + orderStatus);
		return orderStatus;
	}

	public String[] getProfileInfo(String customerCode, String... columns) {
		String columnData = "";
		for (String column : columns)
			columnData = columnData + column + ",";
		columnData = columnData.substring(0, columnData.length() - 1);
		dataSet = executeSelectQuery(columnData, "CB_SUBSCRIBER_MASTER",
				" WHERE EXT_SUBSCRIBER_CODE_V = '" + customerCode + "'", "");
		String[] profileInfo = new String[columns.length];
		set = dataSet.entrySet();
		iterator = set.iterator();
		int i = 0;
		while (iterator.hasNext()) {
			Map.Entry entry = (Map.Entry) iterator.next();
			profileInfo[i++] = (String) entry.getValue();
		}
		return profileInfo;
	}
}