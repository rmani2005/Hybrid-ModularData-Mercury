package Practice.NewProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelConfig {
	
	XSSFWorkbook wb;
	XSSFSheet sheet;
	
	public ExcelConfig(String excelpath){
		
		File src = new File(excelpath);
		try {
			FileInputStream File = new FileInputStream(src);
		    wb = new XSSFWorkbook(File);
					
		} catch (Exception e) {
			
		System.out.println(e.getMessage());
		}
		
	}

	public String getexceldata(int sheetnumber, int row,int cell){
		
		sheet=wb.getSheetAt(sheetnumber);
	   String values =sheet.getRow(row).getCell(cell).toString();
      
       return values;
   	
	}
	
public int getRowCount(int sheetindex){
	
	int row = wb.getSheetAt(sheetindex).getLastRowNum();
	
	row=row+1;
	return row;
}

	
}
