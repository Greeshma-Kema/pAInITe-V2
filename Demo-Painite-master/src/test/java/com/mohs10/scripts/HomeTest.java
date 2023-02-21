package com.mohs10.scripts;

import org.testng.annotations.Test;

import com.mohs10.ActionDriver.SSreuseclass;
import com.mohs10.ActionDriver.XLUtils;
import com.mohs10.base.StartBrowser;
import com.mohs10.reuse.CommonFuns;

	public class HomeTest extends StartBrowser{
		
		String excelfile = "C:\\Users\\Tharun\\Downloads\\Demo-Painite-master\\Demo-Painite-master\\TestData\\Data.xlsx";
	    String excelsheet = "Login";
	    
	@Test
	 public void LoginTestCase() throws Exception {
		
				CommonFuns hm2 = new CommonFuns();
				
				int rowcount = XLUtils.getRowCount(excelfile, excelsheet);	
				for(int i=1;i<rowcount;i++) {
			            String Email = XLUtils.getStringCellData(excelfile, excelsheet, i, 0);
			            String Pwd = XLUtils.getStringCellData(excelfile, excelsheet, i, 1);
			            
			            hm2.logIn(Email, Pwd);
			            
			            SSreuseclass.SSReusablemethod(driver, "Login"+ i);
			            Thread.sleep(5000);
			            
			            hm2.logout();
			        }
		}
	}
