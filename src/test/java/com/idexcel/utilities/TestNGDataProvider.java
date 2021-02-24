package com.idexcel.utilities;

import java.io.File;
import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import com.idexcel.token.MSExcelMethods;

public class TestNGDataProvider {

	/**
	 * @author Shivaraj.Budeppa
	 *
	 */

	static String environment;
    static String url;
    static String FilePath;

	@DataProvider(name = "datafromexcel")
	public static Object[][] login(Method methodName) throws Exception {
		environment = System.getProperty("environment");
		 url = System.getProperty("url");
		 
		 if(environment.equalsIgnoreCase("STAGING")) {
				
			 FilePath="src/test/resources/TestData/Staging/datafromexcel.xlsx";
		}
		
		else if(environment.equalsIgnoreCase("UAT")){
			
			FilePath="src/test/resources/TestData/Uat/datafromexcel.xlsx";
		}
		 
        else if(environment.equalsIgnoreCase("PRODUCTION")){
			
			FilePath="src/test/resources/TestData/Production/datafromexcel.xlsx";
		}
      else if(environment.equalsIgnoreCase("DEV")){
			
			FilePath="src/test/resources/TestData/Dev/datafromexcel.xlsx";
		}

	
		MSExcelMethods msExcelMethods = new MSExcelMethods();
		File file = new File(FilePath);
		Object[][] testdata=msExcelMethods.readDataFromExcel(file.getAbsolutePath(), methodName.getName());
		
		
		
		
		return testdata;
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@DataProvider(name = "ReadDataFromExcel")
	public static Object[][] readDataFromExcel(Method methodName) throws Exception {
		MSExcelMethods msExcelMethods = new MSExcelMethods();
		File file = new File("src/test/resources/TestData/TestData.xlsx");
		Object[][] testdata = msExcelMethods.readDataFromExcel(file.getAbsolutePath(), methodName.getName());
		return testdata;
	}
	@DataProvider(name = "Registration")
	public static Object[][] registration(Method methodName) throws Exception {
		MSExcelMethods msExcelMethods = new MSExcelMethods();
		File file = new File("src/test/resources/TestData/Registration.xlsx");
		Object[][] testdata = msExcelMethods.readDataFromExcel(file.getAbsolutePath(), methodName.getName());
		return testdata;
	}

	@DataProvider(name = "PDPAndPLP")
	public static Object[][] pdpAndPLP(Method methodName) throws Exception {
		MSExcelMethods msExcelMethods = new MSExcelMethods();
		File file = new File("src/test/resources/TestData/PDPAndPLP.xlsx");
		Object[][] testdata = msExcelMethods.readDataFromExcel(file.getAbsolutePath(), methodName.getName());
		return testdata;
	}

	@DataProvider(name = "ForgotPassword")
	public static Object[][] forgotPassword(Method methodName) throws Exception {
		MSExcelMethods msExcelMethods = new MSExcelMethods();
		File file = new File("src/test/resources/TestData/ForgotPassword.xlsx");
		Object[][] testdata = msExcelMethods.readDataFromExcel(file.getAbsolutePath(), methodName.getName());
		return testdata;
	}

	@DataProvider(name = "POCheckout")
	public static Object[][] poCheckout(Method methodName) throws Exception {
		MSExcelMethods msExcelMethods = new MSExcelMethods();
		File file = new File("src/test/resources/TestData/POCheckout.xlsx");
		Object[][] testdata = msExcelMethods.readDataFromExcel(file.getAbsolutePath(), methodName.getName());
		return testdata;
	}

	@DataProvider(name = "Shopping Cart")
	public static Object[][] shoppingCart(Method methodName) throws Exception {
		MSExcelMethods msExcelMethods = new MSExcelMethods();
		File file = new File("src/test/resources/TestData/ShoppingCart.xlsx");
		Object[][] testdata = msExcelMethods.readDataFromExcel(file.getAbsolutePath(), methodName.getName());
		return testdata;
	}

	@DataProvider(name = "Share Cart")
	public static Object[][] shareCart(Method methodName) throws Exception {
		MSExcelMethods msExcelMethods = new MSExcelMethods();
		File file = new File("src/test/resources/TestData/ShareCart.xlsx");
		Object[][] testdata = msExcelMethods.readDataFromExcel(file.getAbsolutePath(), methodName.getName());
		return testdata;
	}

	@DataProvider(name = "Saved Cart")
	public static Object[][] savedCart(Method methodName) throws Exception {
		MSExcelMethods msExcelMethods = new MSExcelMethods();
		File file = new File("src/test/resources/TestData/SavedCart.xlsx");
		Object[][] testdata = msExcelMethods.readDataFromExcel(file.getAbsolutePath(), methodName.getName());
		return testdata;

	}

	@DataProvider(name = "ProductGroup")
	public static Object[][] productGroup(Method methodName) throws Exception {
		MSExcelMethods msExcelMethods = new MSExcelMethods();
		File file = new File("src/test/resources/TestData/ProductGroup.xlsx");
		Object data[][] = msExcelMethods.readDataFromExcel(file.getAbsolutePath(), methodName.getName());
		return data;
	}

	@DataProvider(name = "ProductDetail_V1")
	public static Object[][] productDetailVersion1(Method methodName) throws Exception {
		MSExcelMethods msExcelMethods = new MSExcelMethods();
		File file = new File("src/test/resources/TestData/ProductDetailVersion1.xlsx");
		Object data[][] = msExcelMethods.readDataFromExcel(file.getAbsolutePath(), methodName.getName());
		return data;
	}

	@DataProvider(name = "ProductDetail_V2")
	public static Object[][] productDetailVersion2(Method methodName) throws Exception {
		MSExcelMethods msExcelMethods = new MSExcelMethods();
		File file = new File("src/test/resources/TestData/ProductDetailVersion2.xlsx");
		Object data[][] = msExcelMethods.readDataFromExcel(file.getAbsolutePath(), methodName.getName());
		return data;
	}

	@DataProvider(name = "ProductDetail_V3")
	public static Object[][] productDetailVersion3(Method methodName) throws Exception {
		MSExcelMethods msExcelMethods = new MSExcelMethods();
		File file = new File("src/test/resources/TestData/ProductDetailVersion3.xlsx");
		Object data[][] = msExcelMethods.readDataFromExcel(file.getAbsolutePath(), methodName.getName());
		return data;
	}

	@DataProvider(name = "ProductDetail_V4")
	public static Object[][] productDetailVersion4(Method methodName) throws Exception {
		MSExcelMethods msExcelMethods = new MSExcelMethods();
		File file = new File("src/test/resources/TestData/ProductDetailVersion4.xlsx");
		Object data[][] = msExcelMethods.readDataFromExcel(file.getAbsolutePath(), methodName.getName());
		return data;
	}

	@DataProvider(name = "ProductDetail_V5")
	public static Object[][] productDetailVersion5(Method methodName) throws Exception {
		MSExcelMethods msExcelMethods = new MSExcelMethods();
		File file = new File("src/test/resources/TestData/ProductDetailVersion5.xlsx");
		Object data[][] = msExcelMethods.readDataFromExcel(file.getAbsolutePath(), methodName.getName());
		return data;
	}

	@DataProvider(name = "UserManagement")
	public static Object[][] userManagementModuleTest(Method methodName) throws Exception {
		MSExcelMethods msExcelMethods = new MSExcelMethods();
		File file = new File("src/test/resources/TestData/UserManagement.xlsx");
		Object data[][] = msExcelMethods.readDataFromExcel(file.getAbsolutePath(), methodName.getName());
		return data;
	}

	@DataProvider(name = "AccountDashboard")
	public static Object[][] accountDashboardModuleTest(Method methodName) throws Exception {
		MSExcelMethods msExcelMethods = new MSExcelMethods();
		File file = new File("src/test/resources/TestData/AccountDashboard.xlsx");
		Object data[][] = msExcelMethods.readDataFromExcel(file.getAbsolutePath(), methodName.getName());
		return data;
	}

	@DataProvider(name = "MultipleTestData")
	public static Object[][] multipleTestData(Method methodName) throws Exception {
		MSExcelMethods msExcelMethods = new MSExcelMethods();
		File file = new File("src/test/resources/TestData/MultipleTestData.xlsx");
		Object data[][] = msExcelMethods.readDataFromExcel(file.getAbsolutePath(), methodName.getName());
		return data;
	}

	@DataProvider(name = "ShopByManufacturers")
	public static Object[][] shopByManufacturers(Method methodName) throws Exception {
		MSExcelMethods msExcelMethods = new MSExcelMethods();
		File file = new File("src/test/resources/TestData/ShopByManufacturers.xlsx");

		Object data[][] = msExcelMethods.readDataFromExcel(file.getAbsolutePath(), methodName.getName());
		return data;

	}

	@DataProvider(name = "SendThisPage")
	public static Object[][] sendThisPageModuleTest(Method methodName) throws Exception {
		MSExcelMethods msExcelMethods = new MSExcelMethods();
		File file = new File("src/test/resources/TestData/SendThisPage.xlsx");
		Object data[][] = msExcelMethods.readDataFromExcel(file.getAbsolutePath(), methodName.getName());
		return data;
	}

	@DataProvider(name = "OpenOrder")
	public static Object[][] openOrderModuleTest(Method methodName) throws Exception {
		MSExcelMethods msExcelMethods = new MSExcelMethods();
		File file = new File("src/test/resources/TestData/OpenOrder.xlsx");
		Object data[][] = msExcelMethods.readDataFromExcel(file.getAbsolutePath(), methodName.getName());
		return data;
	}

	@DataProvider(name = "OrderDetail")
	public static Object[][] orderDetailModuleTest(Method methodName) throws Exception {
		MSExcelMethods msExcelMethods = new MSExcelMethods();
		File file = new File("src/test/resources/TestData/OrderDetail.xlsx");
		Object data[][] = msExcelMethods.readDataFromExcel(file.getAbsolutePath(), methodName.getName());
		return data;
	}

	@DataProvider(name = "ReOrderCart")
	public static Object[][] reOrderCartModuleTest(Method methodName) throws Exception {
		MSExcelMethods msExcelMethods = new MSExcelMethods();
		File file = new File("src/test/resources/TestData/ReOrderCart.xlsx");
		Object data[][] = msExcelMethods.readDataFromExcel(file.getAbsolutePath(), methodName.getName());
		return data;
	}

	@DataProvider(name = "OrderHistory")
	public static Object[][] orderHistoryModuleTest(Method methodName) throws Exception {
		MSExcelMethods msExcelMethods = new MSExcelMethods();
		File file = new File("src/test/resources/TestData/OrderHistory.xlsx");
		Object data[][] = msExcelMethods.readDataFromExcel(file.getAbsolutePath(), methodName.getName());
		return data;
	}

	@DataProvider(name = "LeftMenu")
	public static Object[][] leftMenuModuleTest(Method methodName) throws Exception {
		MSExcelMethods msExcelMethods = new MSExcelMethods();
		File file = new File("src/test/resources/TestData/LeftMenu.xlsx");
		Object data[][] = msExcelMethods.readDataFromExcel(file.getAbsolutePath(), methodName.getName());
		return data;
	}

	@DataProvider(name = "ShopByBrands")
	public static Object[][] shopByBrands(Method methodName) throws Exception {
		MSExcelMethods msExcelMethods = new MSExcelMethods();
		File file = new File("src/test/resources/TestData/ShopByBrands.xlsx");
		Object data[][] = msExcelMethods.readDataFromExcel(file.getAbsolutePath(), methodName.getName());
		return data;
	}

	@DataProvider(name = "ChangePassword")
	public static Object[][] ChangePassword(Method methodName) throws Exception {
		MSExcelMethods msExcelMethods = new MSExcelMethods();
		File file = new File("src/test/resources/TestData/ChangePassword.xlsx");
		Object data[][] = msExcelMethods.readDataFromExcel(file.getAbsolutePath(), methodName.getName());
		return data;
	}

	@DataProvider(name = "Locations")
	public static Object[][] Locations(Method methodName) throws Exception {
		MSExcelMethods msExcelMethods = new MSExcelMethods();
		File file = new File("src/test/resources/TestData/Locations.xlsx");
		Object data[][] = msExcelMethods.readDataFromExcel(file.getAbsolutePath(), methodName.getName());
		return data;
	}

	@DataProvider(name = "ProductListAndGrid")
	public static Object[][] ProductListAndGrid(Method methodName) throws Exception {
		MSExcelMethods msExcelMethods = new MSExcelMethods();
		File file = new File("src/test/resources/TestData/ProductListAndGrid.xlsx");
		Object data[][] = msExcelMethods.readDataFromExcel(file.getAbsolutePath(), methodName.getName());
		return data;
	}
}
