package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import BaseMethods.BaseClass;

public class PragmaticPlayPage extends BaseClass {

	Actions action = new Actions(driver);

	public PragmaticPlayPage() {
		super();
	}

	By iframe = By.xpath("//iframe[@id='iframe']");
	By fullScreen = By.xpath("//span[contains(text(),'Full screen')]");
	By exitFullScreen = By.xpath("//span[text()='Full screen']");
	By yearOld = By.xpath("//a[@class='top-btn']");
	By acceptAllCokkies = By.xpath("(//button[@aria-label='Reject All'])[1]");
	By hideTornamentPopup = By.xpath("//div[@class='ppg-section__hide']");
	By gameCanvas = By.cssSelector("canvas[width='1410']");

	public void playGame(boolean flag, int spins) throws InterruptedException {
		driver.findElement(yearOld).click();
		Thread.sleep(2000);
		driver.findElement(acceptAllCokkies).click();
		Thread.sleep(10000);

		for (int count = 0; count <= spins; count++) {

			if (flag == true)
				action.keyDown(Keys.SPACE).build().perform();
			else {
				action.keyDown(Keys.SPACE).build().perform();
				action.keyUp(Keys.SPACE).build().perform();
			}
			try {
				driver.switchTo().parentFrame();
				WebElement hidePopup = driver.findElement(hideTornamentPopup);
				action.moveToElement(hidePopup).click().build().perform();
				System.out.println("Cliked on hide pop-up");
			} catch (Exception exception) {};

			driver.switchTo().frame(driver.findElement(iframe));
			WebElement canvas = driver.findElement(gameCanvas);
			action.moveToElement(canvas, 50, 0).click().build().perform();
			Thread.sleep(1000);
		}
	}

}
