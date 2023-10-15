package pageObjects;
public class DentalPracticeCountryPage extends BasePage
{
    @FindBy(how = How.ID, using = "radio-wales")
    private WebElement walesRadioButton;


    public DentalPracticeCountryPage(WebDriver driver)
    {
        super(driver);
    }

    public void clickOnWalesRadioBtn()
    {
        walesRadioButton.click();
    }
}

