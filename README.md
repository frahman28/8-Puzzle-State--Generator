# 8-Puzzle-State-Generator
Based on two inputted 8 puzzle states, all reachable states are generated and displayed, including common reachable states between the two.
![image](https://user-images.githubusercontent.com/92721094/176572504-0accbe7c-dc84-4813-82bf-21ddd53dc808.png) <br />
The program can be run via the batch file as well as importing the project and running it via the Java file in a development environment/program.
Running the batch file will prompt the command line where the states can be inputted.
The input string requires a blank space to represent the moving empty square in the puzzle.
E.g. The above states would be represented by:
     '8 6547231' and ' 12345678' respectively
The results are saved in the text file 'Output.txt'. This file will store, all reachable states for both states, the number of all reachable states for both states, the reachable states which are common for both states and the number of these.
