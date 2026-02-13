Feature: Amazon best seller laptops validation

   Scenario: Validate best seller laptops are displayed
   Given user is on Amazon home page
   When user searches for "Laptop"
   Then limitedtimedeal search results should be displayed on Amazon
   Then  top 10 laptops with limited time deal
   
