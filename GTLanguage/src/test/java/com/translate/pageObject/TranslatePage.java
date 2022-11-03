package com.translate.pageObject;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class TranslatePage {
	
	WebDriver driver;
	public String SpanishWord;
	
	//Page Object Model : Elements stored together

	By leftMenu = By.xpath("(//*[@class='akczyd']/button/span)[1]"); 

	By sourceLanguage = By.xpath("(//div[text()='German' and @class='Llmcnf'])[1]"); 
	
	By ListofRightDropDown=By.xpath("(//div[@class='dykxn MeCBDd j33Gae'])[1]//div[@class='qSb8Pe' ]");
	
	By ListofLeftDropDown=By.xpath("(//div[@class='vSUSRc' and @jsname='JpRUfc'])[2]//div[@class='qSb8Pe']");
	
    By leftMenuSearchBox=By.xpath("(//div[@class='fMHXgc qkH7ie'])[1]//input"); 
	
	By RightMenuSearchBox=By.xpath("(//div[@class='fMHXgc qkH7ie'])[2]//input");

	By rightMenu = By.xpath("(//div[@jsname='ji7Qmb']//following-sibling ::button[@jsname='zumM6d'])[1]");
	
	By SearchTextS = By.xpath("//span[text()='Spanish' and @class='hBxMjb']");
	
	By SearchTextG = By.xpath("//span[text()='German' and @class='hBxMjb']");

	By leftTextArea = By.cssSelector(".er8xn");

	By SpanishText = By.xpath("(//span[text()='Democracia'])[1]");

	By SpanishToGenmanText = By.xpath("(//span[text()='Demokratie'])[1]");

	By SelectInputToolMenu = By.xpath("//a[@class='ita-kd-icon-button ita-kd-dropdown ita-kd-right']");

	By Crossbutton = By.xpath("(//button[@jsname='X5DuWc'])[3]");

	By DirectKeyBoardbutton = By.xpath("//span[@class='ita-kd-img ita-icon-0 ita-kd-icon ita-kd-icon-span']");

	
	
	//constructor to initialized driver 
	public TranslatePage(WebDriver ddriver) {
		driver = ddriver;
		PageFactory.initElements(ddriver, this);
	}

	
	//Below are all Operation Methods Used for this test.

	public void clickLeftMenu() {
		try {
			Thread.sleep(3000);
			WebElement LeftGerman = driver.findElement(leftMenu);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click()", LeftGerman);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	//this method is selecting German as language from dropdown from xls data
	public void selectGerman(String GermanLag)
	{
	   try {
		Thread.sleep(3000);
		List<WebElement> listofLanguage=driver.findElements(ListofRightDropDown);
		System.out.println(GermanLag);
		for(WebElement listR :listofLanguage)
		{
			if(listR.getText().equals(GermanLag)){
				listR.click();
				break;
			}
		}
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
	}
	
	
	
	//This method removed as to search German
	/*public void SearchBoxleft(String GermanLag) {
		try {
			Thread.sleep(3000);
			WebElement searchBar = driver.findElement(leftMenuSearchBox);
			searchBar.sendKeys("German");
			Thread.sleep(3000);
		     driver.findElement(SearchTextG).click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}*/


	
	public void clickRightMenu() {

		try {
			Thread.sleep(3000);
			WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(10));
			w.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@jsname='ji7Qmb']//following-sibling ::button[@jsname='zumM6d'])[1]")));
			WebElement rightSpanish = driver.findElement(rightMenu);
			JavascriptExecutor jss = (JavascriptExecutor) driver;
			jss.executeScript("arguments[0].click();", rightSpanish);
			Thread.sleep(3000);
	
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
	}

	
	//this method is selecting Spanish as language from dropdown from xls data
	public void selectSpanish(String LanSpanish)
	{

	try {
		Thread.sleep(3000);
		List<WebElement> listofLanguageLeft=driver.findElements(ListofLeftDropDown);
		System.out.println(LanSpanish);
		for(WebElement listL :listofLanguageLeft)
		{
			if(listL.getText().equals(LanSpanish)){
				listL.click();
				break;
			}
		}
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
				
	}
	

	//This method removed as to search Spanish
	/*public void SearchBoxright(String LanSpanish ) {
	
		try {
			Thread.sleep(3000);
			WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(10));
			w.until(ExpectedConditions.visibilityOfElementLocated(RightMenuSearchBox));
			WebElement searchBarSpanish = driver.findElement(RightMenuSearchBox);
			searchBarSpanish.sendKeys("Spanish");
			Thread.sleep(3000);
			Actions actions=new Actions(driver);
			driver.findElement(SearchTextS).click();
			actions.sendKeys(Keys.ENTER).build().perform();
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
	}*/


	
	
	public void sendTextInTextArea(String LeftText) {

		try {
			Thread.sleep(3000);
			WebElement ltextBox = driver.findElement(leftTextArea);
			ltextBox.sendKeys(LeftText);
			Actions actions = new Actions(driver);
			actions.sendKeys(Keys.ENTER).build().perform();
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
	}

	
	
	// to verify text converted
	public String getTargetText(String exText) {
		try {
			Thread.sleep(3000);
			String SpanishWord = driver.findElement(SpanishText).getText();
			Assert.assertEquals(SpanishWord, exText);
			Thread.sleep(3000);
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
		return SpanishWord;
	}

	
	
	public void clickOnSwapButton() {
		try {
			Thread.sleep(3000);
			Actions action = new Actions(driver);
			action.keyDown(Keys.SHIFT);
			action.keyDown(Keys.CONTROL);
			action.sendKeys("s");
			action.build().perform();

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}

	}

	
	
	public void CheckSwapClickResult() throws InterruptedException {
		try {
			Thread.sleep(3000);
			String convertedText = driver.findElement(SpanishToGenmanText).getText();
			Assert.assertEquals("Demokratie", convertedText);
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
	}

	
	
	public void clearGermanText() throws InterruptedException {
		try {
			Thread.sleep(3000);
			WebElement leftBoxTextAfterCompletion = driver.findElement(leftTextArea);
			leftBoxTextAfterCompletion.click();
			leftBoxTextAfterCompletion.clear();
			Thread.sleep(3000);
			WebElement closebutton = driver.findElement(Crossbutton);
			JavascriptExecutor jsb = (JavascriptExecutor) driver;
			jsb.executeScript("arguments[0].click()", closebutton);
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}

	}

	

	public void SelectToolMenuoption() throws InterruptedException {
		try {
			Thread.sleep(3000);
			driver.findElement(SelectInputToolMenu).click();
			Actions action = new Actions(driver);
			action.sendKeys(Keys.ARROW_DOWN);
			action.sendKeys(Keys.ARROW_DOWN);
			action.sendKeys(Keys.ENTER);
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}

	}
	
	

	//This is typing "Hi!"
	
	public void EnterHiAtKeyboard() throws InterruptedException {
		Thread.sleep(3000);
		try {
			
			driver.findElement(DirectKeyBoardbutton).click();
			WebElement capletter = driver.findElement(By.id("K20"));
			capletter.click();
			WebElement Hletter = driver.findElement(By.id("K72"));
			Hletter.click();
			capletter.click();
			WebElement Iletter = driver.findElement(By.id("K73"));
			Iletter.click();
			WebElement keyPatterenChange = driver.findElement(By.id("K16"));
			keyPatterenChange.click();
			WebElement exclamatoryMark = driver.findElement(By.id("K49"));
			Thread.sleep(3000);
			exclamatoryMark.click();
			Thread.sleep(5000);
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
	}
	
	
	// This method to type "Lorem ipsum dolor" without reusable method
	
		public void EnterAnyWordKeyboard() throws InterruptedException {
			Thread.sleep(3000);
			try {			
				driver.findElement(DirectKeyBoardbutton).click();
				WebElement capletter = driver.findElement(By.id("K20"));
				capletter.click();
				WebElement lletter = driver.findElement(By.id("K76"));
				lletter.click();
				capletter.click();
				WebElement oletter = driver.findElement(By.id("K79"));
				oletter.click();
				WebElement rletter = driver.findElement(By.id("K82"));
				rletter.click();
				WebElement eletter = driver.findElement(By.id("K69"));
				Thread.sleep(3000);
				eletter.click();
				WebElement mletter = driver.findElement(By.id("K77"));
				mletter.click();
				WebElement spacebutton = driver.findElement(By.id("K32"));
				spacebutton.click();
				WebElement iletter = driver.findElement(By.id("K73"));
				iletter.click();
				WebElement pletter = driver.findElement(By.id("K80"));
				pletter.click();
				WebElement sletter = driver.findElement(By.id("K83"));
				sletter.click();
				WebElement uletter = driver.findElement(By.id("K85"));
				Thread.sleep(3000);
				uletter.click();
				mletter.click();
				spacebutton.click();
				WebElement dletter = driver.findElement(By.id("K68"));
				dletter.click();
				oletter.click();
				WebElement llletter = driver.findElement(By.id("K76"));
				llletter.click();
				oletter.click();
				rletter.click();
				Thread.sleep(5000);
			} catch (Exception e) {

				System.out.println(e.getMessage());
			}
		}
		
	

				//passing Any phase by reusable function using screen keyboard
		
				public void EnterAnyTextKeyboard(String phase) throws InterruptedException {
					Thread.sleep(3000);
					try {			
						WebElement sceKey= driver.findElement(DirectKeyBoardbutton);
						sceKey.click();
						for(int i=0;i<phase.length();i++) {
							
							if(phase.charAt(i)== ' ') {
								WebElement spacebutton = driver.findElement(By.id("K32"));
								spacebutton.click();
							}
							else if(phase.charAt(i)>= 'A' && phase.charAt(i)<= 'Z')
							{
								WebElement capletter = driver.findElement(By.id("K20"));
								capletter.click();
								WebElement letter = driver.findElement(By.xpath("//span[text()= '"+phase.charAt(i)+"']"));
								letter.click();
								capletter.click();
							}
	
							else {
			
							WebElement letter = driver.findElement(By.xpath("//span[text()= '"+phase.charAt(i)+"']"));
							letter.click();
							}
						}
			
						Thread.sleep(5000);
					} catch (Exception e) {

						System.out.println(e.getMessage());
					}
				}
}
