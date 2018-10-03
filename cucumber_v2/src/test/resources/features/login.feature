
Feature: login feature file

  
  Scenario: successful login scenario
	Given the user launched the app url in the browser
	And the login page details are displayed
	When the user enters the value for the username field
	And the user enters the value for the password field
	And clicks on login button
	Then the user should be redirected to the home page
	  
