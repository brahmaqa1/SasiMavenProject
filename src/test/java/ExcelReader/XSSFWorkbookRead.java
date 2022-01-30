package ExcelReader;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XSSFWorkbookRead {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		String filePath ="D:\\Practise\\TestData.xlsx";
		String SheetName= "CreateCustomer";
		
		// HSSF
//		HSSFWorkbook
//		xssWorkbook
		FileInputStream  fis=  new FileInputStream(filePath);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet  sh=wb.getSheet(SheetName);
		//HW: get rows cnt
		
		// HW: get col cnt
		
		// read data
		String data00=sh.getRow(0).getCell(0).getStringCellValue();
		System.out.println("data 00="+data00);
		
		data00=sh.getRow(0).getCell(1).getStringCellValue();
		System.out.println("data 01="+data00);
		
		
//		data00=sh.getRow(1).getCell(2).getStringCellValue();
		//IllegalStateException: Cannot get a STRING value from a NUMERIC cell
		double d=sh.getRow(1).getCell(2).getNumericCellValue();
		System.out.println("data 23="+d);
		// data 23=10.0
		
		//
//		data00=sh.getRow(1).getCell(2).getStringCellValue().toString();
		//IllegalStateException: Cannot get a STRING value from a NUMERIC cell 
//		System.out.println("data 01="+data00);
		
		CellType  ctype= sh.getRow(1).getCell(2).getCellType();
		System.out.println("tyep="+ctype.NUMERIC);
		if(ctype.NUMERIC.equals("NUMERIC"))
		{
			double d2=sh.getRow(1).getCell(2).getNumericCellValue();
			System.out.println("data 23="+d2);
		}
		
		// 1,2   ..
		
		//  excel data -Date = getDateCellValue()
		  //evaluating cell type   
	    FormulaEvaluator formulaEvaluator = wb.getCreationHelper().createFormulaEvaluator();
		for (Row row: sh)
		    //iteration over row using for each loop  
		    {
		      for (Cell cell: row) //iteration over cell using for each loop  
		      {
//		        switch (formulaEvaluator.evaluateInCell(cell).getCellType()) {
//		        case Cell.CELL_TYPE_NUMERIC:
//		          //field that represents numeric cell type  
//		          //getting the value of the cell as a number  
//		          System.out.print(cell.getNumericCellValue() + "\t\t");
//		          break;
//		        case Cell.CELL_TYPE_STRING:
//		          //field that represents string cell type  
//		          //getting the value of the cell as a string  
//		          System.out.print(cell.getStringCellValue() + "\t\t");
//		          break;
		        }
		      }
		
		
				
	}

}
