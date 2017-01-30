Feature: Test One
		
	Scenario Outline: Verify that 'Return to sign in' link and 'Cancel' button redirect to the correct Sign In page
		Given I access "<site>" site
		When I click on the "Forgot your username?" link in "Login" page
		#
		Then I verify the "Forgot Username" page is displayed
		And I fill in "Forgot Username Email" field with "<email>" value on "Forgot Username" page
		And I click on the "Cancel" button in "Forgot Username" page
		Then I verify the "Sign In" page is displayed
		#		
		When I make a Forgot Username request with "<email>" email
		#
		Then I verify "Request Sent!" message is displayed on the "Forgot Username" page
		Then I verify "We have emailed your username to the email address that we have on file." message is displayed on the "Forgot Username" page		
		And I click on the "Return to sign in" link in "Forgot Username" page
		Then I verify the "Sign In" page is displayed
	Examples:
		| site																														| email										|
		| https://automaincommunity.qa392automation.spigit.com/User/Login	| qeautomation@spigit.com	|