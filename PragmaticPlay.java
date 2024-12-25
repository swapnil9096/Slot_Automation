package Games;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BaseMethods.BaseClass;
import Pages.PragmaticPlayPage;

public class PragmaticPlay extends BaseClass {

	PragmaticPlayPage pragmaticGamePlay;

	public PragmaticPlay() {
		super();
	}

	@BeforeTest()
	public void setUp() {
		init();
		pragmaticGamePlay = new PragmaticPlayPage();
	}

	@AfterTest()
	public void tearDown() {
		driver.quit();
	}

	@Test()
	public void playGame() throws InterruptedException {
		pragmaticGamePlay.playGame(true,100);
	}
	
	
}
