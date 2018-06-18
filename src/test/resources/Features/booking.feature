Feature: booking up

Scenario: decline payment for a booking up
    Given user logs in and make a booking from Madrid to Ibiza on 25/09/2018 for 2 adults
    When user pays for booking with card number 2312334567213444 expiry on 03/2020 and ccv 333
    Then user should get payment declined message
