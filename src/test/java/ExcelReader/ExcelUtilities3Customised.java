package ExcelReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtilities3Customised {
	
	// get rows cnt
	public static int getRowsCnt(String filePath,String sheetName) throws EncryptedDocumentException, IOException
	{
		//String filePath ="D:\\Practise\\TestData.xlsx";
		FileInputStream fis = new FileInputStream(filePath);
		Workbook wb= WorkbookFactory.create(fis);
		
		Sheet sh= wb.getSheet(sheetName);
	//  get all rows cnt
		int getLastRowNum= sh.getLastRowNum();
		// 3 ,act rows =4 ****Note :
		return getLastRowNum+1;
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
	// 1,1-username  --  row
	// 2,1    -1,0  
	public static String readDataFromExcel(String filePath, String sheetName, int rowno, int cellno) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(filePath);
		Workbook wb= WorkbookFactory.create(fis);
		Sheet sh= wb.getSheet(sheetName);
		String data= sh.getRow(rowno-1).getCell(cellno-1).getStringCellValue().toString();
		return data;		
	}
	
	public static Hashtable<String, String> readDatafromExcelStoreIntoHashTable(String filePath, String sheetName) throws EncryptedDocumentException, IOException
	{
		System.out.println("readDatafromExcelStoreIntoHashTable");
		int RowsCnt= getRowsCnt(filePath, sheetName);
		Hashtable<String, String>  htable = new Hashtable<String, String>();
		
		
		for(int i=1;i<= RowsCnt;i++)//  1 to 4 
		{
			String Col1Data= readDataFromExcel(filePath, sheetName, i, 1);// 1,1   2,1  ,,3,1
			String Col2Data= readDataFromExcel(filePath, sheetName, i, 2);// 1.2 , 2,2,  ,3,2
			System.out.println("Col1Data="+Col1Data  + ", Col2Data="+Col2Data);
			htable.put(Col1Data, Col2Data);			
		}
		
		System.out.println("htable="+ htable);
		return htable;
	}
	
	
	// 
	public  static boolean  isSheetExist(String filePath, String sheetName) throws EncryptedDocumentException, IOException
	{
		
		FileInputStream fis= new FileInputStream(filePath);
		Workbook  wb= WorkbookFactory.create(fis);
		int index= wb.getSheetIndex(sheetName);
		
		System.out.println("index no=" + index+  " of sheet name= "+sheetName );
		if(index >=0)
		{
			System.out.println("Given sheet name=" +sheetName +  " exist in excel file");
			return true;
		}
		else
		{
			System.out.println("Given sheet name=" +sheetName+ " is not exist in excel file");
			return false;
		}	
		
	}
	
	
	public static int getColnoBasedOnColumnName(String filePath, String sheetName,String ExpectedColName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis= new FileInputStream(filePath);
		Workbook  wb= WorkbookFactory.create(fis);
		String ActualColName;
		Sheet sh= wb.getSheet(sheetName);
		// read all col names
		int colCnt= getColsCnt(filePath, sheetName);//2
		boolean ColFound =false;
		int i;
		for( i=1;i<=colCnt;i++) // 1 to 2
		{
			//
			ActualColName= readDataFromExcel(filePath, sheetName,1 , i);// 1,1
			if(ExpectedColName.equalsIgnoreCase(ActualColName))
			{
				System.out.println("Col name="+ExpectedColName  + " found at Col  no="+ i );
				ColFound = true;
//				break;
				return i;
				
			}
//			else  // Dont write 
//			{
//				System.out.println("Col name="+ExpectedColName  + " is not found at Col  no="+ i );
//			}
		}
		
		//  
		if(ColFound == true) 
		{
			System.out.println("Col name="+ExpectedColName  + " found at Col  no" +i);	
		}
		else
		{
			System.out.println("Col name="+ExpectedColName  + " is not found at any Col  no");
			return -1;
		}
		return i;		
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
		String data= readDataFromExcel(filePath, SheetName, 1, 1);
		System.out.println("data 11="+data);
		
		data= readDataFromExcel(filePath, SheetName, 1, 2);
		System.out.println("data 12="+data);
		
		//data= readDataFromExcel(filePath, SheetName, 2,0 );
		// error  0-1= -1 cell is not there
		data= readDataFromExcel(filePath, SheetName, 2, 1);
		System.out.println("data 21="+data);
		data= readDataFromExcel(filePath, SheetName, 2, 2);
		System.out.println("data 21="+data);
		
		// HW  Read all data from all rows and all cells..
		
		
		// is shee
		boolean isSheetExist= isSheetExist(filePath, "Login");
		System.out.println("isSheetExist -Login =" +isSheetExist);
		
		isSheetExist= isSheetExist(filePath, "CreateCustomer");
		System.out.println("isSheetExist -CreateCustomer =" +isSheetExist);
		
		isSheetExist= isSheetExist(filePath, "InvlaidLogin");
		System.out.println("isSheetExist -InvlaidLogin =" +isSheetExist);
//		index no=0 of sheet name= Login
//				Given sheet name=Login exist in excel file
//				isSheetExist -Login =true
//				index no=1 of sheet name= CreateCustomer
//				Given sheet name=CreateCustomer exist in excel file
//				isSheetExist -CreateCustomer =true
//				index no=-1 of sheet name= InvlaidLogin
//				Given sheet name=InvlaidLogin is not exist in excel file
//				isSheetExist -InvlaidLogin =false
//		
		// GetColno if we pass col name
		getColnoBasedOnColumnName(filePath, SheetName, "UserName");
		
		getColnoBasedOnColumnName(filePath, SheetName, "Password");
		
		// -ve 
//		getColnoBasedOnColumnName(filePath, SheetName, "InvlaiPassword");
		
		// HW read all rows  and and cells data 
		
		Hashtable<String, String>  empDataTable= readDatafromExcelStoreIntoHashTable(filePath, "CreateEmp");
		// htable={employee=Ram, password=manager, empid=101, username=admin}
		
		System.out.println("empDataTable="+empDataTable);
		// get 
		System.out.println("get user="+empDataTable.get("username"));
		System.out.println("get employee="+empDataTable.get("employee"));
		System.out.println("get empid="+empDataTable.get("empid"));
		
//		get user=admin
//				get employee=Ram
//				get empid=101
		
	}
	

}
