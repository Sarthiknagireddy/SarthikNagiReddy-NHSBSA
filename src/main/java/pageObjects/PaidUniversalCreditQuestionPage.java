package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PaidUniversalCreditQuestionPage extends BasePage
{
	@FindBy(how = How.XPATH, using = "//label[contains(@for, 'yes-universal')]")
	private WebElement yesUniversalCreditRadioButton;
	
	@FindBy(how = How.ID, using = "//label[contains(@for, 'not-yet')]")
	private WebElement notyetUniversalCreditRadioButton;
	
	@FindBy(how = How.ID, using = "//label[contains(@for, 'different-benefit')]")
	private WebElement differentBenifitRadioButton;
		
	public PaidUniversalCreditQuestionPage(WebDriver driver) 
	{
		super(driver);
	}
	
	public void selectYesUniversalCreditRadioButton()
	{
		yesUniversalCreditRadioButton.click();
	}
	
	

}
