REST parameters validation using Jersey framework.

http://localhost:9090/student/address          [The Content-Type should be set to "application/json" for request raised to server]

Valid Input
{"name":"Donald","street":"Stree no 27","city":"Sydney","phone":"(123) 123-1234","zip":"12345-6789"}

Response:
Message from Server :
Name : Donald, Street: Stree no 27, Phone : (123) 123-1234, city: Sydney

Invalid phone number
{"name":"Donald","street":"Stree no 27","city":"Sydney","phone":"(123)123-1234","zip":"12345-6789"}

Exception:
registerAddress.arg0 {Invalid address: Check your phone number or zip}