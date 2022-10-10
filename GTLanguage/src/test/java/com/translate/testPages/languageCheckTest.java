package com.translate.testPages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.translate.utilities.XLUtils;
import com.translate.pageObject.TranslatePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class languageCheckTest {
	WebDriver driver;

	@BeforeTest
	public void setup() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

	}

	@Test(dataProvider="TranslateData")
	public void googleTranslate(String souLan,String transLan,String iniText,String exptText) throws InterruptedException {
		
		driver.get("https://translate.google.com/");
		TranslatePage translatePage = new TranslatePage(driver);
		translatePage.clickLeftMenu();
		translatePage.SearchBoxleft(souLan);
		translatePage.clickRightMenu();
		translatePage.SearchBoxright(transLan);
		translatePage.sendTextInTextArea(iniText);
		translatePage.getTargetText(exptText);
		translatePage.clickOnSwapButton();
		translatePage.CheckSwapClickResult();
		translatePage.clearGermanText();
		translatePage.EnterHiAtKeyboard();

	}
	
	
	@DataProvider(name="TranslateData")
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/TestData/testdataN.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);
		
		String TestCasedata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				TestCasedata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);
			}
				
		}
	return TestCasedata;
	
	}


	@AfterTest()
	public void tearDown() {
		driver.close();
		driver.quit();

	}

}