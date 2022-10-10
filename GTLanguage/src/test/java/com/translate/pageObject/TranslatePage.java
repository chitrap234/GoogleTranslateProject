package com.translate.pageObject;


import java.time.Duration;
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

	public void SearchBoxleft(String GermanLag) {
		try {
			Thread.sleep(3000);
			WebElement searchBar = driver.findElement(leftMenuSearchBox);
			searchBar.sendKeys("German");
			Thread.sleep(3000);
		     driver.findElement(SearchTextG).click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}


	
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

	
	public void SearchBoxright(String LanSpanish ) {
	
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
	}


	
	
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
	
	

	
	public void EnterHiAtKeyboard() throws InterruptedException {
		Thread.sleep(3000);
		try {
			
			driver.findElement(DirectKeyBoardbutton).click();

			WebElement Hletter = driver.findElement(By.id("K72"));
			Hletter.click();
			WebElement Iletter = driver.findElement(By.id("K73"));
			Iletter.click();
			WebElement keyPatterenChange = driver.findElement(By.id("K16"));
			keyPatterenChange.click();
			WebElement exclamatoryMark = driver.findElement(By.id("K49"));
			exclamatoryMark.click();
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
	}
}
