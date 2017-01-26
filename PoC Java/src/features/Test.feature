Feature: Test

	Scenario Outline: Login to main site
		Given I navigate to <site> url
		Then I login to the site using <username> username and <password> password credentials
	Examples:
		| site																														| username	| password		|		
		| https://automaincommunity.qa392automation.spigit.com/User/Login	| autobot5	| Spigit.123	|
		
	Scenario Outline: Login to main site again
		Given I navigate to <site> url
		Then I login to the site using <username> username and <password> password credentials
	Examples:
		| site																														| username	| password		|		
		| https://automaincommunity.qa392automation.spigit.com/User/Login	| autobot5	| Spigit.123	|