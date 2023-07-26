package utility;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import pages.CommonPage;

public class ExcelHelper extends CommonPage {

	public ExcelHelper(WebDriver dr) {
		super(dr);
	}
	
	public static XSSFSheet ExcelWSheet;
	public static XSSFWorkbook ExcelWBook;
	public static XSSFCell Cell;

	public String getCellvalue(String excelPath, String sheetName, int row, int column) throws IOException {
		File file = new File(excelPath);
		FileInputStream inputStream = new FileInputStream(file);
		HSSFWorkbook wb = new HSSFWorkbook(inputStream);
		HSSFSheet sheet = wb.getSheet(sheetName);
		HSSFRow row2 = sheet.getRow(row);
		HSSFCell cell = row2.getCell(column);
		return cell.getStringCellValue();
	}
	public String getIntegerCellvalue(String excelPath, String sheetName, int row, int column) throws EncryptedDocumentException, InvalidFormatException, IOException {
		FileInputStream fis = new FileInputStream(excelPath);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		DataFormatter formatter = new DataFormatter();
		String val = formatter.formatCellValue(sheet.getRow(row).getCell(column));
		return val; 
	}
	
	public void setCellValue(String excelPath, String sheetName, int row, int column, int value) throws IOException {
		File file = new File(excelPath);
		FileInputStream inputStream = new FileInputStream(file);
		HSSFWorkbook wb = new HSSFWorkbook(inputStream);
		HSSFSheet sheet = wb.getSheet(sheetName);
		HSSFRow row2 = sheet.getRow(row);
		HSSFCell cell = row2.createCell(column);
		cell.setCellValue(value);
		
		FileOutputStream outputStream = new FileOutputStream(excelPath);
		wb.write(outputStream);
		wb.close();
	}
	
	
	
	
	
	
	/* these methods used for userdata excel read */
	
	public static String getCellValue(String datafile, String sheet, int i, int j) {
		String ser = null;
		try {
			FileInputStream ExcelFile = new FileInputStream(datafile);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(sheet);
			ser = getCellData(i, j);
		} catch (FileNotFoundException e) {
			System.out.println("Could not read the Excel sheet");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Could not read the Excel sheet");
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ser;
	}
	
	public String dataLookup(String datafile, String sheet, int col_index, String data) {

		try {
			FileInputStream ExcelFile = new FileInputStream(datafile);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(sheet);
		} catch (FileNotFoundException e) {
			System.out.println("Could not read the Excel sheet");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Could not read the Excel sheet");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		int totalRow = ExcelWSheet.getLastRowNum();
		int rowCount = 0;
		for (rowCount = 1; rowCount < totalRow; rowCount++) {
			if (getCellValue(datafile, sheet, rowCount, 0).equalsIgnoreCase(data))
				break;
		}
		return getCellValue(datafile, sheet, rowCount, col_index);
	}
	
	public static <UnicodeString> UnicodeString getCellData(int RowNum, int ColNum) throws Exception {
		try {
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			int dataType = Cell.getCellType();
			if (dataType == 3) {
				return (UnicodeString) "";
			} else {
				DataFormatter formatter = new DataFormatter();
				UnicodeString Data = (UnicodeString) formatter.formatCellValue(Cell);
				return Data;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw (e);
		}
	}
	
	
	
	
}
