package utilities;

import java.io.File;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
static ExtentReports reports;
	
	public static ExtentReports getReports() {
		
		if(reports == null) {
			reports = new ExtentReports();
			//init the Report folder
			Date d = new Date();
			System.out.println(d.toString().replaceAll(":", "-"));//over here, d.toString will provide current date and time with ":" in it which will replace here with "-"
			String ReportsFolder = d.toString().replaceAll(":", "-");
			String ScreenShotFolderPath = System.getProperty("user.dir")+"//reports//"+ ReportsFolder+ "//screenshots//";
			String ReportFolderPAth = System.getProperty("user.dir")+"//reports//"+ ReportsFolder;
			File F = new File(ScreenShotFolderPath);
			F.mkdirs();		//create dynamic report folder name + screenshots
			ExtentSparkReporter sparkReporter = new ExtentSparkReporter(ReportFolderPAth);
			sparkReporter.config().setReportName("Production Regression Testing");
			sparkReporter.config().setDocumentTitle("Automation Reports");
			sparkReporter.config().setTheme(Theme.DARK);
			sparkReporter.config().setEncoding("utf-8");

			reports.attachReporter(sparkReporter);
		}
		
		return reports;
		
	}

}