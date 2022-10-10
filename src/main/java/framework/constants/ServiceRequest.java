/*
 * @author vysyaki (Kiranraju Vysyaraju)
 * @email kiranraju.vysyaraju@tecnotree.com
*/

package framework.constants;

public class ServiceRequest {
	// Request Level
	public static final String REQ_LEVEL_SERVICE = "service";
	public static final String REQ_LEVEL_ACCOUNT = "account";
	public static final String REQ_LEVEL_PROFILE = "profile";

	// Service //
	// Change of Service
	public static final String REQ_COS = "ChangeofService";
		public static final String REQ_COS_SIMC = "SIM Swap";
		public static final String REQ_COS_MOBC = "Mobile Swap";
		public static final String REQ_COS_BARUBAR = "Bar Unbar Technical Services";
		public static final String REQ_COS_PACK = "Change Plan";
		public static final String REQ_COS_VAS = "Add VAS";
		public static final String REQ_COS_RVAS = "Remove VAS";
		public static final String REQ_COS_ACUG = "Add CUG";
		public static final String REQ_COS_DCUG = "Remove CUG VAS";
		public static final String REQ_COS_PRPO = "Prepaid To Postpaid";
		public static final String REQ_COS_HRPO = "Prepaid To Hybrid";
		public static final String REQ_COS_PPRT = "Postpaid To Prepaid";
		public static final String REQ_COS_NTOH = "Postpaid To Hybrid";
		public static final String REQ_COS_HTON = "Hybrid To Postpaid";
		public static final String REQ_COS_HPRT = "Hybrid To Prepaid";
		public static final String REQ_COS_TROW = "Transfer Of Service";

	// Life Cycle Status Change
	public static final String REQ_LCS = "Life Cycle Status Change";
		public static final String REQ_LCS_SUSP = "Suspension Of Service";
		public static final String REQ_LCS_RESP = "Revoke Suspension Of Service";
		public static final String REQ_LCS_ERAS = "Service Termination";

	// Service Information Request
	public static final String REQ_SERINF = "Service Information Request";
		public static final String REQ_SERINF_PINPUKREQ = "PIN/PUK Request";	

	// Update Service Information
	public static final String REQ_SERUPD = "Update Service Information";
		public static final String REQ_SERUPD_CHLG = "Modify Preferred Language";
		public static final String REQ_SERUPD_RPWD = "Me2U Reset Password";
		public static final String REQ_SERUPD_SERGEN = "Modify Service Details";

	// Manage Deposits And Service Limit
	public static final String REQ_DSTCL = "Manage Deposits And Service Limit";
		public static final String REQ_DSTCL_ADST = "Add Deposits";
		public static final String REQ_DSTCL_RDST = "Refund Deposits";
		public static final String REQ_DSTCL_MSL = "Modify Service Limit";

	// Account //
	// Update Account Information
	public static final String REQ_ACCUPD = "Update Account Information";
		public static final String REQ_ACCUPD_ACCBLPRE = "Modify Billing Preferences";
		public static final String REQ_ACCUPD_ACCADDR = "Modify Account Address";
		public static final String REQ_ACCUPD_PTP = "Promise to Pay";
	// Payments
	public static final String REQ_PAYMENT = "Payments";
		public static final String REQ_PAYMENT_PAYINV = "Payment Against Invoice";

	// Profile //
	public static final String REQ_PFLUPD = "Modify Profile";
		public static final String REQ_PFLUPD_PFLGEN = "Modify Basic Details";
		public static final String REQ_PFLUPD_PFLNOT = "Modify Contact And Notification";
		public static final String REQ_PFLUPD_PFLID = "Modify Identification Details";
		public static final String REQ_PFLUPD_PFLADD = "Modify Profile Address";
		public static final String REQ_PFLUPD_MXDIR = "Modify XDirectory Level";
}