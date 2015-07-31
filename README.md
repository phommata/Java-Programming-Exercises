# Java-Programming-Exercises
Java Programming Exercises

<h4>Integer Search Problem</h4>
IntSearch.java

Implement a findMatches function that takes a query value and a pre-sorted array of integers that may contain duplicates. It should find and return

• The index of the first instance of the query value in the array, or -1 if the query value does not exist in the array.

• The number of times the query value appears in the array (0 if the query value does not exist in the array).

As an example, if findMatches is called, and 

• query = 8

• values = { 0, 1, 2, 3, 4, 4, 5, 6, 7, 8, 8, 8, 9 } 

then it should return,

• firstMatchIndex = 9, because values[9] is the first occurrence of 8

• numberOfMatches = 3, because there are three occurrences of 8

<h4>The Stamps Problem</h4>
StampDispenser.java

The StampDispenser class represents a postage stamp vending machine.  The machine contains stamps of different values. The machine will always have a stamp with a value of 1 cent and the machine will never run out of any type of stamp. The machine should allow a consumer of the class to calculate the minimum number of stamps that the machine can dispense to fill a given request. 

As an example, suppose an instance of StampDispenser was created with stampDenominations, {90, 30, 24, 10, 6, 2, 1}, and calcMinNumStampsToFillRequest(int) was called with request, 34.  The call should return 2, as 34 cents can best be filled by one 24 cent stamp and one 10 cent stamp.

Things to keep in mind:
1.	Assume that a junior programmer is going to read your code. You should include comments and any other aides that you use to communicate your code to other developers.
2.	Optimize the code for speed.
3.	The code should compile and work. 
4.	The code should work for countries with high denomination values where stamp values of 1000 or 9000 are common. 
