package ExcelReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtilities {
	
	// Selenium - download selenium jar file
	//   read excel data--  We need Apache POI .jar file
	
//	<!-- https://mvnrepository.com/artifact/org.apache.poi/poi -->
//<dependency>
//<groupId>org.apache.poi</groupId>
//<artifactId>poi</artifactId>
//<version>5.0.0</version>
//</dependency>
//	
//	<!-- https://mvnrepository.com/artifact/org.apache.poi/poi-ooxml -->
//		<dependency>
//			<groupId>org.apache.poi</groupId>
//			<artifactId>poi-ooxml</artifactId>
//			<version>4.1.1</version>
//		</dependency>
//
//	</dependencies>
	
	public static void main(String s[]) throws EncryptedDocumentException, IOException
	{
		
		System.out.println("strats ");
		String filePath ="D:\\Practise\\TestData.xlsx";
		FileInputStream fis = new FileInputStream(filePath);
		Workbook wb= WorkbookFactory.create(fis);
		
		Sheet sh= wb.getSheet("Login");
	//  get all rows cnt
		int getLastRowNum= sh.getLastRowNum();
		System.out.println("getLastRowNum="+getLastRowNum);
		// 3 ,act rows =4 ****Note :
		
		// get col cnt
//		sh.getlas
		int Colcnt= sh.getRow(0).getLastCellNum();
		System.out.println("Colcnt="+Colcnt);
		// 2  , actual also =2 
		
		// 1,1 cell data
	String data00= 	sh.getRow(0).getCell(0).getStringCellValue().toString();
		System.out.println("data00="+data00);
		
		// read 1,2 cell data
		data00= 	sh.getRow(0).getCell(1).getStringCellValue().toString();
		System.out.println("data01="+data00);
		//read 2,1 cell data
		data00= 	sh.getRow(1).getCell(0).getStringCellValue().toString();
		System.out.println("data10="+data00);
		
		
		data00= 	sh.getRow(1).getCell(1).getStringCellValue().toString();
		System.out.println("data11="+data00);
		
		// read  3,1 cell ==  2,0
		//       3,2 --     2,1 
		
		//HW  get all sheeets cnt 
		
		// HW :check  sheet  is exist or not 
		
		
	}
	

}
