package com.Scenario1;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
public class ExcelUtility {
	
	public XSSFWorkbook wb;
    public File f1;
    public  FileInputStream fs;
    
    @DataProvider(name="excelLoginData")
    public Object[][] excelData()
    {
    	
    	 //f1=new File(System.getProperty("user.dir")+"//TestData\\Data.xlsx");
    	 f1=new File(System.getProperty("user.dir")+"//ExcelFiles\\LoginData.xlsx");
		Object arr[][]=null;
		
		try {
			fs = new FileInputStream(f1);
			
			//Workbook
			wb=new XSSFWorkbook(fs);
			
			String Uname=wb.getSheet("userdata").getRow(1).getCell(0).getStringCellValue();
		    System.out.println("User Name :"+Uname);
		    int rows=wb.getSheet("userdata").getPhysicalNumberOfRows();
		    System.out.println("No of rows :"+rows);
		    int cells=wb.getSheet("userdata").getRow(0).getPhysicalNumberOfCells();
		    System.out.println("Number of columns: "+cells);
		    arr=new Object[rows-1][cells];//reading only 5 rows
		    //iterate array read data from file and save it in array
		    
		    for(int i=1;i<rows;i++)
			  {
				  
				  for(int j=0;j<cells;j++)
				  {
					  //array always start with 0 index
					  arr[i-1][j]=wb.getSheet("userdata").getRow(i).getCell(j).getStringCellValue();
					  System.out.print(arr[i-1][j]+"  ");
				  }
				  System.out.println();
			  }
		
		} 
		
		    catch (FileNotFoundException e){
		     	// TODO Auto-generated catch block
			    e.printStackTrace();
		     }
		    catch (IOException e) {
			   // TODO Auto-generated catch block
			   e.printStackTrace();
		     }
		
		return arr;
    	
    }
    
    
    public void closeWorkbook()
    {
    	if(wb!=null)
    	{
    		try {
				wb.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	
    	else {
    		System.out.println("Workbook is empty or never initialised it");
    	}
    }
    
}
