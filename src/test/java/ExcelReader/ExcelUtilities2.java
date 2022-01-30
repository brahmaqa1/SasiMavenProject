package ExcelReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtilities2 {
	
	// get rows cnt
	public static int getRowsCnt(String filePath,String sheetName) throws EncryptedDocumentException, IOException
	{
		//String filePath ="D:\\Practise\\TestData.xlsx";
		FileInputStream fis = new FileInputStream(filePath);
		Workbook wb= WorkbookFactory.create(fis);
		
		Sheet sh= wb.getSheet(sheetName);
	//  get all rows cnt
		int getLastRowNum= sh.getLastRowNum();
		System.out.println("getLastRowNum="+getLastRowNum);
		// 3 ,act rows =4 ****Note :
		return getLastRowNum;
	}
	
	// get clumns cnt
	public static int getColsCnt(String filePath, String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(filePath);
		Workbook wb= WorkbookFactory.create(fis);
		Sheet sh= wb.getSheet(sheetName);
		int colcnt= sh.getRow(0).getLastCellNum();
		return	colcnt;	
	}
	
	// Read Data from xl based Rowno, Cell no
	public static String readDataFromExcel(String filePath, String sheetName, int rowno, int cellno) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(filePath);
		Workbook wb= WorkbookFactory.create(fis);
		Sheet sh= wb.getSheet(sheetName);
		String data= sh.getRow(rowno).getCell(cellno).getStringCellValue().toString();
		return data;		
	}
	
	
	public static void main(String s[]) throws EncryptedDocumentException, IOException
	{
		
		System.out.println("strats ");
		String filePath ="D:\\Practise\\TestData.xlsx";
		String SheetName= "Login";
		
		int getLastRowNum = getRowsCnt(filePath, SheetName);
		System.out.println("getLastRowNum="+getLastRowNum);//3 
		
		int colcnt= getColsCnt(filePath, SheetName);
		System.out.println("colcnt="+colcnt);
		
		// Read dara 
		String data= readDataFromExcel(filePath, SheetName, 0, 0);
		System.out.println("data 00="+data);
		
		data= readDataFromExcel(filePath, SheetName, 0, 1);
		System.out.println("data 01="+data);
		
		data= readDataFromExcel(filePath, SheetName, 1, 0);
		System.out.println("data 10="+data);
		
		// HW  Read all data from all rows and all cells..
		
		
	}
	

}
