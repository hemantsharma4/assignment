Assignment Coffee Machine

To Install and build run:-
mvn  clean install -DskipTests

To run all test case
mvn test

Assumptions:- Json input doesn't have duplicate keys.

Note:-
1. Parallel processing commented as processing is not thread safe will debug
2. Gson is used to parse the Json file.
3. Test Json file provide in resource