Feature: Adactin login validation 
Scenario Outline: Adactin credentials verfification 
	Given user is on Adactin page 
	When user enters the "<username>" and "<password>" 
	Then user clicks the login button 
	
	Examples: 
		|username|password|
		|suseendran08|ssndrn|
		|Susee|pass123|
		|Indran|pass123|
		|Java|pass123|
	