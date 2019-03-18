# Java3Week8CalculatorBackend

There are 2 ways how to use this RESTful API Service...
1. Use different action names with parameters. Examples...
http://localhost:8080/test/rest/calculate/divide/3.1/2
http://localhost:8080/test/rest/calculate/multiply/3.1/-2
http://localhost:8080/test/rest/calculate/add/-2/-1.1
http://localhost:8080/test/rest/calculate/subtract/2/1.1

2. Use expression...
http://localhost:8080/test/rest/calculate/-7+2
http://localhost:8080/test/rest/calculate/3.5-2
http://localhost:8080/test/rest/calculate/-7%7C2 ("/" symbol is not allowed, I've used "|" symbol for division.)
http://localhost:8080/test/rest/calculate/2*2
