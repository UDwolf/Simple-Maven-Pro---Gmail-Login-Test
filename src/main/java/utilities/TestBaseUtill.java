package utilities;

public class TestBaseUtill {

	public static long PAGE_LOAD_TIME_OUT = 20;
	public static long IMPLICIT_WAIT = 20;
	
	public static String GMAIL_MAIN_PAGE_TITLE = "Gmail: Free, Private & Secure Email | Google Workspace";
	public static String GMAIL_SIGNIN_PAGE_TITLE = "Gmail";
	
	Xls_Reader d = new Xls_Reader("C:\\Users\\umesh\\Desktop\\ManualTesting-Umesh.xlsx");
	//public String rightEmail = "udwolf.qa.1";
	//public String rightPassword = "Wolf@12345$";
	
	
	public String EMAIL_RIGHT = d.getCellData("Data1", 5, 13);
	public String EMAIL_NON_EXISTING = d.getCellData("Data1", 5, 19);
	public String EMAIL_SPECIAL_CHAR = d.getCellData("Data1", 5, 29);
	public String EMAIL_YAHOO = d.getCellData("Data1", 5, 33);
	public String EMAIL_GOOGLE_CONNECTED = d.getCellData("Data1", 5, 37);
	
	public String PASSWORD_RIGHT = d.getCellData("Data1", 5, 15);
	public String PASSWORD_RIGHT_GOOGLE_CONNECTED = d.getCellData("Data1", 5, 39);
	public String PASSWORD_WRONG = d.getCellData("Data1", 5, 25);
	
	public String ERROR_NOT_FIND_ACCOUNT = d.getCellData("Data1", 7, 20);
	public String ERROR_WRONG_PASSWORD = d.getCellData("Data1", 7, 26);
	public String ERROR_INVELID_EMAIL = d.getCellData("Data1", 7, 30);	
}
