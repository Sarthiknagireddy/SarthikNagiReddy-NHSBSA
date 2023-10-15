package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class CountryPage extends BasePage 
{
	@FindBy(how = How.ID, using = "label-wales")
	private WebElement walesRadioButton;
	
	
	public CountryPage(WebDriver driver) 
	{
		super(driver);
	}

    public void clickOnWalesRadioBtn() 
	{
		walesRadioButton.click();
    }

}
