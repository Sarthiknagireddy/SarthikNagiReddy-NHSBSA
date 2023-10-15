package com.project.NHSBSA.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import envReader.EnvReader;
import pageObjects.*;
ter
public class EligibilityChecker
{
	WebDriver driver = Hooks.driver;
	
	@Given("^I am on the NHS Costs checker tool$")
	public void i_am_on_the_NHS_Costs_checker_tool() throws Throwable
	{
		// Navigate to the NHS Costs Checker tool
		 driver.get(EnvReader.getProperty("URL")); 
	}

	@Given("^I am a citizen of Wales$")
	public void i_am_a_citizen_of_Wales() throws Throwable
	{
		NhsStartPage nhsStartPage = new NhsStartPage(driver);
		nhsStartPage.clickOnNextButton();
		
		CountryPage countryPage = new CountryPage(driver);
		countryPage.clickOnWalesRadioBtn(); // Selects Country as Wales
		countryPage.clickOnNextButton();
	}

	@When("^I put my circumstances into the Checker tool$")
	public void i_put_my_circumstances_into_the_Checker_tool() throws Throwable 
	{
		/*** 
		 * Used below Happy path for execution
		 * GPInScotlandOrWales - Yes
		 * DentalPracticeCountry - Yes
		 * DOB - 01, 01, 1961
		 * DoYouLiveWithAPartner - Yes
		 * DoYouOrYourPartnerCliamAnyBenefitsOrTaxCredits - Yes 
		 * PaidUniversalCredit - Yes
		 * UniversalCreditClaim - Yes
		 * TakeHome - No
		 * InjuryOrIllnessPage - No
		 * CareHomePage - No
		 * Savings - No
		 */

		System.out.println("GP in Scotland or Wales Page");
		GPInScotlandOrWalesPage gPInScotlandOrWalesPage = new GPInScotlandOrWalesPage(driver);
		gPInScotlandOrWalesPage.clickOnYesRadioButton();
		gPInScotlandOrWalesPage.clickOnNextButton();

		System.out.println("Dental Practice Country Page");
		DentalPracticeCountryPage dentalPracticeCountryPage = new DentalPracticeCountryPage(driver);
		dentalPracticeCountryPage.clickOnWalesRadioBtn();
		dentalPracticeCountryPage.clickOnNextButton();

		System.out.println("DOB page 01 01 1961");
		DateOfBirthPage dateOfBirthPage = new DateOfBirthPage(driver);
		dateOfBirthPage.enterDateOfBirth("01", "01", "1961");
		dateOfBirthPage.clickOnNextButton();
		
		System.out.println("DoYouLiveWithAPartner page");
		DoYouLiveWithAPartner doYouLiveWithAPartner = new DoYouLiveWithAPartner(driver);
		doYouLiveWithAPartner.clickOnYesRadioButton();
		doYouLiveWithAPartner.clickOnNextButton();
		
		System.out.println("DoYouOrYourPartnerCliamAnyBenefitsOrTaxCredits page");
		DoYouOrYourPartnerCliamAnyBenefitsOrTaxCredits doYouOrYourPartnerCliamAnyBenefitsOrTaxCredits = new DoYouOrYourPartnerCliamAnyBenefitsOrTaxCredits(driver);
		doYouOrYourPartnerCliamAnyBenefitsOrTaxCredits.clickOnYesRadioButton();
		doYouOrYourPartnerCliamAnyBenefitsOrTaxCredits.clickOnNextButton();
		
		System.out.println("PaidUniversalCreditQuestion page");
		PaidUniversalCreditQuestionPage paidUniversalCredit = new PaidUniversalCreditQuestionPage(driver);
		paidUniversalCredit.selectYesUniversalCreditRadioButton();
		paidUniversalCredit.clickOnNextButton();
		
		System.out.println("UniversalCreditClaim page");
		UniversalCreditClaimPage universalCreditClaimPage = new UniversalCreditClaimPage(driver);
		universalCreditClaimPage.clickOnYesRadioButton();
		universalCreditClaimPage.clickOnNextButton();
		
		System.out.println("TakeHome page");
		TakeHomePage takeHomePage = new TakeHomePage(driver);
		takeHomePage.clickOnNoRadioButton();
		takeHomePage.clickOnNextButton();

		System.out.println("InjuryOrIllness page");
		InjuryOrIllnessPage injuryOrIllnessPage = new InjuryOrIllnessPage(driver);
		injuryOrIllnessPage.clickOnNoRadioButton();
		injuryOrIllnessPage.clickOnNextButton();

		System.out.println("CareHome page");
		CareHomePage careHomePage = new CareHomePage(driver);
		careHomePage.clickOnNoRadioButton();
		careHomePage.clickOnNextButton();

		System.out.println("Savings page");
		SavingsPage savingsPage = new SavingsPage(driver);
		savingsPage.clickOnNoRadioButton();
		savingsPage.clickOnNextButton();
		
	}

	@Then("^I should get a result of whether I will get help or not$")
	public void i_should_get_a_result_of_whether_I_will_get_help_or_not() throws Throwable 
	{
		ResultsPage resultsPage = new ResultsPage(driver);
		String heading = resultsPage.getHeading();
		
		Assert.assertTrue(heading.equalsIgnoreCase("Based on what you've told us\n" + 
				"You get help with NHS costs"), "Not Result Page");
	}

	
}
