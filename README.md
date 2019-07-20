**Making a Pawn visit all cells in a 10 * 10 board exactly once**

**Algorithm**
I have used Warnsdorff's heuristic to find a path covering all board cell once.


The driver program tries to find such a path starting for cell 0,0 and keep trying all other cells as start
cell until one such path is found. If after trying every cell as start cell, no path is found then print
the message not found otherwise print the path found.

**How to run**
Please follow the below given steps to run the program:

1. Build it first. Go to project home directory and then type the below given command:
   ./gradlew clean assemble

2. Go to directory project_home/build/libs and then type below command:
   java -jar assignment-1.0-SNAPSHOT.jar

3. Wait and see the program display the found path on your terminal.

NOTE: The above steps to run are given for Ubuntu. To run on windows the following steps should work( but not tested because I did not have access to Windows OS):

1. Build it first. Go to project home directory and then type the below given command:
   ./gradlew.bat clean assemble

2. Go to directory project_home/build/libs and then type below command:
   java -jar assignment-1.0-SNAPSHOT.jar

3. Wait and see the program display the found path on your terminal.

