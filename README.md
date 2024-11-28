QUADTREE PROJECT README

This project implements a Quadtree data structure to efficiently manage and query rectangles in a 2D space. 
The code supports basic operations like insert, delete, find, update, and dump.


REQUIREMENTS
To run this project, you need the following:

Java installed
A terminal or IDE (Eclipse)

RUNNING THE PROJECT
Step 1: Compile the Code

In the terminal, navigate to the project directory and compile all .java files:

javac -d out src/main/java/quadtree/*.java

Step 2: Create a Command File

Create a command file (e.g., commands.cmmd) containing the commands you want to execute. Commands include (update, insert, find, dump, and delete)

Step 3: Run the Code

Run the program with the command file as an argument:

java -cp out quadtree.Main commands.cmmd  

OUTPUT:
The output in terminal should look a little something like this 

Inserted: Rectangle at (10.00, 10.00): 5.00x5.00
Inserted: Rectangle at (20.00, 20.00): 8.00x8.00
Found: Rectangle at (10.00, 10.00): 5.00x5.00
Updated: Rectangle at (10.00, 10.00) from 5.00x5.00 to 6.00x6.00
Deleted: Rectangle at (20.00, 20.00): 8.00x8.00
Dumping Quadtree:
Leaf Node - Rectangle at (-50.0, -50.0): 100.0x100.0
	Rectangle at (10.00, 10.00): 6.00x6.00
