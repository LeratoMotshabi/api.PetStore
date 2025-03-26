package api.Utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class XLDataProvider {
	
	XLUtility excel;
	String path = "/src/main/resources/testData/testData.xlsx";
	 @DataProvider(name = "UserData")
	    public Object[][] getUserData() throws IOException  {
		 excel = new XLUtility(System.getProperty("user.dir")+path);
	        String sheetName = "Users"; // Ensure this sheet exists in your Excel file
	        int rowCount = excel.getRowCount(sheetName);
	        int colCount = excel.getCellCount(sheetName, 0);

	        Object[][] data = new Object[rowCount][colCount];

	        for (int i = 0; i < rowCount; i++) {
	            for (int j = 0; j < colCount; j++) {
	                data[i][j] = excel.getCellData(sheetName, i + 1, j);
	            }
	        }
	        return data;
	    }
	 
	 @DataProvider(name = "Usernames")
	 public Object[][] getUsernames() throws IOException {
	     excel = new XLUtility(System.getProperty("user.dir") + path);
	     String sheetName = "Users"; // Ensure this sheet exists in your Excel file
	     int rowCount = excel.getRowCount(sheetName);

	     Object[][] data = new Object[rowCount][1]; // Only one column (username)

	     for (int i = 0; i < rowCount; i++) {
	         data[i][0] = excel.getCellData(sheetName, i + 1, 1); // Column index 1 (Username)
	     }
	     return data;
	 }


}
