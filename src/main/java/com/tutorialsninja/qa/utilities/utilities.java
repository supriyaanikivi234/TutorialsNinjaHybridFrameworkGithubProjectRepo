package com.tutorialsninja.qa.utilities;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import java.util.Date;
import java.io.*;

public class utilities 
{

	public static final int implicitly_Wait= 10;
	public static final int pageLoadTime= 8;
	
	public static String generateEmailWithTimeStamp()
	{
		 Date date= new Date();
		 //method chaining concept
		 String timeStamp= date.toString().replace(" ", "-").replace(":", "-");
		 return "anushka123"+timeStamp+"@gmail.com";
	}
	
	public static Object[][] getTestdataFromExecel(String sheetName) throws IOException
	{
		File excelFile= new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\qa\\testdata\\TutorialsNinjaTestData.xlsx");
		FileInputStream fisExcel= new FileInputStream(excelFile);
		XSSFWorkbook workbook= new XSSFWorkbook(fisExcel);
		XSSFSheet sheet= workbook.getSheet(sheetName);
		
		int rows= sheet.getLastRowNum();
		int columns=sheet.getRow(0).getLastCellNum();
		
		Object[][] data=new Object[rows][columns];
		
		for (int i=0;i<rows;i++)
		{
			XSSFRow row= sheet.getRow(i+1);
			
			for(int j=0;j<columns;j++)
			{
				XSSFCell cell=row.getCell(j);
				CellType celltype=cell.getCellType();
				
				switch(celltype)
				{
				case STRING:
					data[i][j]=cell.getStringCellValue();
					break;
				case NUMERIC:
					data[i][j]=Integer.toString((int)cell.getNumericCellValue());
					break;
				case BOOLEAN:
					data[i][j]=cell.getBooleanCellValue();
					break;
				}
				
			}
		}
		
		return data;
	}
	


	public static String captureScreenshot(WebDriver driver,String testName) {
		Date currentDate= new Date();
		String screenshotFile= currentDate.toString().replace(" ", "-").replace(":", "-");
        File destinationPath1= new File(System.getProperty("user.dir")+"\\Screenshot\\"+testName+screenshotFile+".png");		
       File scrShot =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
       try {
			FileUtils.copyFile(scrShot, destinationPath1);
		} catch (IOException e) {
			e.printStackTrace();
		}
       String path=destinationPath1.getAbsolutePath();
       return path;
	}
	}
