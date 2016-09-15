package org.tour.mercury.com.xlsfiles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.tour.mercury.com.logs.Log;

public class xlsx_Reader 
{
	//Declare the Variables and Objects
	public static String suiteFilename="../Hybrid-ModularData-Mercury/src/Suite.xlsx";
	public String path;
	public FileInputStream fis = null;
	public FileOutputStream fos = null;
	public XSSFWorkbook workbook = null;
	public XSSFSheet sheet = null;
	public XSSFRow row = null;
	public XSSFCell cell = null;
	public int colNum;
	
	public xlsx_Reader(String path)
	{
		Log.info("xlsx_Reader constructor is initialised");
		this.path=path;	
		
		try {
			Log.info("Initialzing the XSSF usermodel models like XSSFWorkbook, XSSFSheet, XSSFRow, XSSFCell ");
			fis=new FileInputStream(path);
			workbook=new XSSFWorkbook(fis);
			
			sheet=workbook.getSheetAt(0);
			Log.info("Getting the 0th index sheet..!");
			
			fis.close();
			Log.debug("fis is closed");
		} catch (FileNotFoundException e) {
			Log.error("File not found exception" + e.toString());
			e.printStackTrace();
		}catch (IOException e) {
			Log.error("File not found exception" + e.toString());
			e.printStackTrace();
		}
		
		
	}
	
	public int getRowCount(String sheetname)
	{
		int index=workbook.getSheetIndex(sheetname);
		if(index==-1)
		{
			return 0;
		}
		sheet=workbook.getSheet(sheetname);
		int rowcount=sheet.getLastRowNum()+1;
		return rowcount;
		
	}
	
	public String getCellData(String sheetName, String colName,int rowNum)
	{
		
		if(rowNum<=0)
			return "";
		
		int index=workbook.getSheetIndex(sheetName);
		if(index==-1)
			return "";
		
		sheet=workbook.getSheetAt(index);
		row=sheet.getRow(0);
		for(int i=0;i<row.getLastCellNum();i++)
		{
			if(row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
				colNum = i;
		}
		if(colNum==-1)
			return "";
		
		sheet=workbook.getSheetAt(index);
		row =sheet.getRow(rowNum-1);
		if(row==null)
		return "";
		cell=row.getCell(colNum);		
		
		if(cell==null)
		return "";
		if(cell.getCellType()==Cell.CELL_TYPE_STRING)
			return cell.getStringCellValue();	
		
		if(DateUtil.isCellDateFormatted(cell))
		{
			SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
			System.out.println(sdf.format(cell.getDateCellValue()));
			return cell.getStringCellValue();
		}
		else if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC || cell.getCellType()==Cell.CELL_TYPE_FORMULA)
		{
		
			
			String cellText=String.valueOf(cell.getNumericCellValue());
			
			if(HSSFDateUtil.isCellDateFormatted(cell)){
				
				double d=cell.getNumericCellValue();
						
				Calendar cal=Calendar.getInstance();
				cal.setTime(HSSFDateUtil.getJavaDate(d));
				cellText = (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
				cellText = cal.get(Calendar.DAY_OF_MONTH) + "/" +
				cal.get(Calendar.MONTH)+1 + "/" +
				cellText;
			}
			return cellText;
		}else if(cell.getCellType()==Cell.CELL_TYPE_BLANK)
			return "";
		else 
			return String.valueOf(cell.getBooleanCellValue());

		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
