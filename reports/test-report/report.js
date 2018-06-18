$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("booking.feature");
formatter.feature({
  "line": 1,
  "name": "booking up",
  "description": "",
  "id": "booking-up",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "decline payment for a booking up",
  "description": "",
  "id": "booking-up;decline-payment-for-a-booking-up",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "user logs in and make a booking from Madrid to Ibiza on 25/09/2018 for 2 adults",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "user pays for booking with card number 2312334567213444 expiry on 03/2020 and ccv 333",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "user should get payment declined message",
  "keyword": "Then "
});
formatter.match({
  "location": "BookingUpTest.givenStatement()"
});
formatter.result({
  "duration": 33404746897,
  "status": "passed"
});
formatter.match({
  "location": "BookingUpTest.whenStatement()"
});
formatter.result({
  "duration": 5446753537,
  "status": "passed"
});
formatter.match({
  "location": "BookingUpTest.thenStatement()"
});
formatter.result({
  "duration": 3338741,
  "status": "passed"
});
});