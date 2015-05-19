-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Contents
_____________________________________________________________________________________________________________________________________________________________________________________
1. NumberGuesser.java. This is the application. It can be launched by either 
   A) executing the NumberGuesser.class in target/classes/com/pthopa folder
      first cd to the folder target/classes  and then
      java com.pthopa.NumberGuesser
      or 
    B) by executing the jar file in target/pthopa-0.0.1-SNAPSHOT.jar
       first cd to the folder target and then
       java -jar pthopa-0.0.1-SNAPSHOT.jar
       
2. NumberGuesserTest.java. This contains the unit tests. The tests cover a range of possible numnbers that may be selected by players and also edge cases.
   The test can be run using maven.
   First cd to the root folder ie pthopa and run
   mvn test    
       
3. You may also build the application using maven.
   cd to the root folder ie pthopa and run (this will also run the junit tests)
   mvn clean package
   to rebuild the application.

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Assumptions
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
1) Using at least Java 1.6.  Higher versions ok
2) This program will guess a number between 1 and 1000. It can easily be changed to guess a bigger change, by changing the values of the variables MIN and MAX in NumberGuesser.java



