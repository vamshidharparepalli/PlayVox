package MavenProject.UtilityFunction;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Color;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.monitorjbl.xlsx.StreamingReader;
import com.monitorjbl.xlsx.impl.StreamingSheetReader;

public class ExcelUtilsExperiment {

	private static org.apache.poi.ss.usermodel.Sheet wSheet;
	private static Row rowNumber;
	private static FileInputStream fis;
	private static Workbook wb;
	private static Sheet sheet;
	private static FileOutputStream fos;
	private static Cell cellNumber;

	private static int numberOfRecordsPresent(String excelPath, String sheetName)
			throws IOException, Exception, InvalidFormatException {

		fis = new FileInputStream(new File(excelPath));

		if (excelPath.split("\\.")[1].equalsIgnoreCase("xlsx")) {

			wb = StreamingReader.builder().rowCacheSize(100) // number of rows to keep in memory (defaults to 10)
					.bufferSize(4096) // buffer size to use when reading InputStream to file (defaults to 1024)
					.open(fis);

		}

		// }else {
		// wb=new HSSFWorkbook(fis);
		// }
		sheet = wb.getSheetAt(0);

		int count = 0;
		for (Row row : sheet) {
			count++;
		}

		// int lastRow = sheet.getLastRowNum();

		wb.close();
		fis.close();

		return count - 1;

	}

	// public static int findRow(Sheet sheet, String cellContent) {
	// for (Row row : sheet) {
	// for (Cell cell : row) {
	// if (cell.getCellTypeEnum().equals(CellType.STRING)) {
	// if(cell.getRichStringCellValue().getString().trim().contains(cellContent)) {
	// return row.getRowNum();
	//
	// }
	// }
	//
	// }
	// }
	// return 0;
	// }
	// public static void compareTwoColum(String excelPath,String sheetName,String
	// colName,List<Object> srcList, List<Object> destList) throws IOException {
	// List <String> result=new ArrayList<String>();
	//
	// for(int j=0;j<srcList.size();j++) {
	// if(srcList.get(j).toString().trim().equals(destList.get(j).toString().trim()))
	// result.add("Pass");
	//
	// else
	// result.add("Fail");
	//
	// }
	// fis=new FileInputStream(new File(excelPath));
	// if(excelPath.split("\\.")[1].equalsIgnoreCase("xlsx")) {
	// wb=new XSSFWorkbook(fis);
	//
	//
	// }else {
	// wb=new HSSFWorkbook(fis);
	// }
	// sheet=wb.getSheet(sheetName);
	// Map<String, Integer> map = new HashMap<String, Integer>(); // Create map
	// Row row1 = sheet.getRow(findRow(sheet, colName)); // Get first row
	// int firstRow = findRow(sheet, colName);
	// int lastRow = sheet.getLastRowNum();
	// int minColIx = row1.getFirstCellNum(); // get the first column index for a
	// row
	// int maxColIx = row1.getLastCellNum(); // get the last column index for a row
	// System.out.println(minColIx);
	// System.out.println(maxColIx);
	// for (int colIx = minColIx; colIx < maxColIx; colIx++) {
	// Cell cell = row1.getCell(colIx);
	// map.put(cell.getStringCellValue(), cell.getColumnIndex());
	// }
	// int ColIndex = map.get(colName);
	// int resultIndex=0;
	// for(int i=firstRow+1;i<=lastRow;i++) {
	// Row row = sheet.getRow(i);
	// Cell cell = row.createCell(row.getLastCellNum()+1);
	// cell.setCellValue(result.get(resultIndex));
	// resultIndex++;
	//
	// }
	// FileOutputStream out = new FileOutputStream(new File(excelPath));
	// wb.write(out);
	// out.close();
	//

	public static List<String> getColumnValue(String excelPath, int col, String Sheet, String startWith)
			throws Exception {
		List<String> weeks = new ArrayList<>();

		try {
			fis = new FileInputStream(new File(excelPath));

			if (excelPath.split("\\.")[1].equalsIgnoreCase("xlsx")) {

				wb = StreamingReader.builder().rowCacheSize(100) // number of rows to keep in memory (defaults to 10)
						.bufferSize(4096) // buffer size to use when reading InputStream to file (defaults to 1024)
						.open(fis);

			}

			// }else {
			// wb=new HSSFWorkbook(fis);
			// }
			sheet = wb.getSheetAt(0);

			// int count=0;
			for (Row row : sheet) {
				row.getCell(col, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
				if (row.getCell(col) != null && row.getCell(col).getStringCellValue().startsWith(startWith))

					weeks.add(row.getCell(col).getStringCellValue());

			}

			// int lastRow = sheet.getLastRowNum();

			wb.close();
			fis.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		return weeks;

	}

	public static List<String> getColumnValueWholeCol(String excelPath, String colName, String Sheet) throws Exception {
		List<String> weeks = new ArrayList<>();
		int col = getColNumber(excelPath, Sheet, colName);
		col = col - 1;
		try {
			fis = new FileInputStream(new File(excelPath));

			if (excelPath.split("\\.")[1].equalsIgnoreCase("xlsx")) {

				wb = StreamingReader.builder().rowCacheSize(100) // number of rows to keep in memory (defaults to 10)
						.bufferSize(4096) // buffer size to use when reading InputStream to file (defaults to 1024)
						.open(fis);

			} else {
				wb = WorkbookFactory.create(fis);
			}

			sheet = wb.getSheet(Sheet);

			// int count=0;
			for (Row row : sheet) {
				row.getCell(col, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
				if (row.getCell(col) != null)

					weeks.add(row.getCell(col).getStringCellValue());
				else
					weeks.add("");

			}

			

			wb.close();
			fis.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		return weeks;

	}
	
	

	public static int getColNumber(String excelPath, String sheet, String colName) throws Exception {
		FileInputStream inputStream = new FileInputStream(new File(excelPath));

		Workbook wb = StreamingReader.builder().rowCacheSize(100) // number of rows to keep in memory (defaults to 10)
				.bufferSize(4096) // buffer size to use when reading InputStream to file (defaults to 1024)
				.open(inputStream);
		Sheet sh = wb.getSheet(sheet);

		// Find the Column number Which has column name and row number 0

		// Row row1 = sh.getRow(0);
		int colNum = 0;
		// for (int i = 0 ;i<=row1.getLastCellNum();i++){
		// Cell cell1 = row1.getCell(i,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
		// String cellValue1 = cell1.getStringCellValue();
		// if (colName.equals(cellValue1)){
		// colNum = i ;
		// break;}
		// }
		int count = 0;
		for (Row row : sh) {
			if (count > 0) {
				break;
			} else {
				for (Cell cell : row) {
					if (cell.getStringCellValue().equalsIgnoreCase(colName)) {
						colNum++;
						break;
					} else {
						colNum++;
					}
				}
			}
			count++;
		}

		return colNum;
	}

	public static List<Row> fileContent(String inputfile) throws Exception {

		FileInputStream inputStream = new FileInputStream(new File(inputfile));

		Workbook wb = StreamingReader.builder().rowCacheSize(100) // number of rows to keep in memory (defaults to 10)
				.bufferSize(4096) // buffer size to use when reading InputStream to file (defaults to 1024)
				.open(inputStream);
		Sheet sh = wb.getSheetAt(0);

		// Find the Column number Which has column name and row number 0

		// Row row1 = sh.getRow(0);
		int colNum = 0;
		// for (int i = 0 ;i<=row1.getLastCellNum();i++){
		// Cell cell1 = row1.getCell(i,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
		// String cellValue1 = cell1.getStringCellValue();
		// if (colName.equals(cellValue1)){
		// colNum = i ;
		// break;}
		// }
		List<Row> sheetcontent = new ArrayList<>();
		for (Row row : sh) {
			sheetcontent.add(row);
		}

		return sheetcontent;
	}

	public static int getRowCount(String excelPath, String xlSheet) throws IOException {
		// System.out.println("1");
		System.out.println(excelPath);
		fis = new FileInputStream(excelPath);
		if (excelPath.split("\\.")[1].equalsIgnoreCase("xls")) {
			wb = new HSSFWorkbook(fis);
		} else {
			wb = new XSSFWorkbook(fis);
		}
		wSheet = wb.getSheet(xlSheet);
		int rowCount = wSheet.getLastRowNum();
		wb.close();
		fis.close();
		return rowCount;
	}

	public static int getCellCount(String excelPath, String xlSheet, int rownum) throws IOException {
		fis = new FileInputStream(excelPath);
		if (excelPath.split("\\.")[1].equalsIgnoreCase("xls")) {
			wb = new HSSFWorkbook(fis);
		} else {
			wb = new XSSFWorkbook(fis);
		}
		wSheet = wb.getSheet(xlSheet);
		rowNumber = wSheet.getRow(rownum);
		int cellCount = rowNumber.getLastCellNum();
		wb.close();
		fis.close();
		return cellCount;

	}
	public static List<String> getWholeColumnValue(String excelPath, String xlSheet,int rowCount,int cellNum) throws Exception
	{
		List<String> columnValues=new ArrayList();
		fis = new FileInputStream(excelPath);
		if (excelPath.split("\\.")[1].equalsIgnoreCase("xls")) {
			wb = new HSSFWorkbook(fis);
		} else {
			wb = new XSSFWorkbook(fis);
		}
		wSheet = wb.getSheet(xlSheet);
		for(int i=0;i<rowCount;i++)
		{
			rowNumber = wSheet.getRow(i);
			cellNumber = rowNumber.getCell(cellNum);
			String data = null;
			try {
				DataFormatter df = new DataFormatter();
				data = df.formatCellValue(cellNumber);
				// System.out.println(data);
				// return data;
				columnValues.add(data);
			} catch (Exception e) {
				// TODO: handle exception
				// data="";
				e.getMessage();
			}
		}
		wb.close();
		fis.close();
		return columnValues;
	}

	public static String getCellValue(String excelPath, String xlSheet, int rownum, int cellnum) throws IOException {
		// System.out.println("getting value");
		fis = new FileInputStream(excelPath);
		if (excelPath.split("\\.")[1].equalsIgnoreCase("xls")) {
			wb = new HSSFWorkbook(fis);
		} else {
			wb = new XSSFWorkbook(fis);
		}
		wSheet = wb.getSheet(xlSheet);
		rowNumber = wSheet.getRow(rownum);
		cellNumber = rowNumber.getCell(cellnum);
		// System.out.println(cell);
		String data = null;
		try {
			DataFormatter df = new DataFormatter();
			data = df.formatCellValue(cellNumber);
			// System.out.println(data);
			// return data;
		} catch (Exception e) {
			// TODO: handle exception
			// data="";
			e.getMessage();
		}
		wb.close();
		fis.close();
		return data;
	}

	public static void setCellValue(String excelPath, String xlSheet, int cellnum, List<String> attr, String ColName)
			throws IOException {

		// System.out.println(cellnum);
		fis = new FileInputStream(excelPath);
		if (excelPath.split("\\.")[1].equalsIgnoreCase("xls")) {
			wb = new HSSFWorkbook(fis);
		} else {
			wb = new XSSFWorkbook(fis);
		}
		wSheet = wb.getSheet(xlSheet);

		int rownum = 0;
		Row row = wSheet.createRow(rownum);
		cellNumber = row.createCell(cellnum);
		cellNumber.setCellValue("The Column Name");
		for (int i = 1; i <= attr.size(); i++) {
			rownum = i;

			cellNumber = row.createCell(cellnum);
			// System.out.println(attr.get(rownum-1));

			cellNumber.setCellValue(attr.get(rownum - 1));
		}

		// String data;
		fos = new FileOutputStream(excelPath);
		wb.write(fos);
		wb.close();
		fis.close();
		fos.close();

	}
	public static void markingExcelSheetCell(String excelPath, String xlSheet,int rowNum,int colNum) throws Exception
	{
		
		fis = new FileInputStream(excelPath);
		
		if (excelPath.split("\\.")[1].equalsIgnoreCase("xls")) {
			wb = new HSSFWorkbook(fis);
		} else {
			wb = new XSSFWorkbook(fis);
		}
	//	String getCellValue=ExcelUtilsExperiment.getCellValue(excelPath, xlSheet, rowNum+1, colNum);
		
		wSheet = wb.getSheet(xlSheet);
		Row row=wSheet.getRow(rowNum+1);
		Cell cell=row.getCell(colNum);

		CellStyle style=wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);  
	    cell.setCellStyle(style);
	    
	    fos = new FileOutputStream(excelPath);
		
		wb.write(fos);
		wb.close();
		fis.close();
		fos.close();
		
	}

}
