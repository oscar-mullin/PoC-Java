Feature: Test Two

#	Scenario Outline: Login to main site
#		Given I access "<site>" site
#		Then I login to the site using <username> username and <password> password credentials
#	Examples:
#		| site																														| username	| password		|		
#		| https://automaincommunity.qa392automation.spigit.com/User/Login	| autobot5	| Spigit.123	|
		
		
		
  Scenario Outline: Verify that the username is validated
    Given I access "<site>" site    
    And I fill in "Username" field with "<wrong_username>" value on "Login" page
    And I fill in "Password" field with "<password>" value on "Login" page
    And I click on the "Submit" button in "Login" page
		Then I verify "Username or password you entered is incorrect." message is displayed on the "Login" page
  Examples:
    | site                                            								| user    | password	| wrong_username  |
    | https://automaincommunity.qa392automation.spigit.com/User/Login	| autobot5| Spigit.123| autoqa.1x       |
    #| https://automaincommunity.qa392automation.spigit.com/User/Login	| autobot5| Spigit.123| autoqa_1x       |
    #| https://automaincommunity.qa392automation.spigit.com/User/Login	| autobot5| Spigit.123| qa1x            |
    #| https://automaincommunity.qa392automation.spigit.com/User/Login	| autobot5| Spigit.123| autoqa-one-1x   |	