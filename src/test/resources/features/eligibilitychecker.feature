@EndToEnd
Feature: NHS Costs checker End to End journey
	As a person from Wales
	I need to know what help I can get with my NHS costs
	So that I can get the treatment I need

	Background:
    Given I am on the NHS Costs checker tool

  Scenario: UK Test Ticket
      Given I am a citizen of Wales
	  When I put my circumstances into the Checker tool
	  Then I should get a result of whether I will get help or not