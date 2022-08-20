package MavenProject.UtilityFunction;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.collections.map.HashedMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class formDetailsExcelReading {
	
	public static LinkedHashMap<String, List<String>> hs=new LinkedHashMap<String ,List<String>>();
	public static int rowCount;
	static List<String> labelName;
	public static String excelPath=System.getProperty("user.dir")+File.separator+"SmartHQ_PlaceOrder.xlsx";
	public static void formReading(String dataSheet ,String LabelDetails)
	{
		
		try {
			
			System.out.println(excelPath);
			labelName=ExcelUtilsExperiment.getColumnValueWholeCol(excelPath, "LabelName",LabelDetails);
		    labelName.remove(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(String label:labelName)
		{
			List<String> labelCurrentValues = null;
			System.out.println(label);
			try {
				 rowCount=ExcelUtilsExperiment.getRowCount(excelPath, dataSheet);
				int colNumber=ExcelUtilsExperiment.getColNumber(excelPath, dataSheet, label);
				labelCurrentValues=ExcelUtilsExperiment.getColumnValueWholeCol(excelPath, label,dataSheet);
			    labelCurrentValues.remove(0);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			hs.put(label, labelCurrentValues);
		}
		
	}
	public static int hasMapSize()
	{
		return hs.size();
	}

	
	
	
	

}
