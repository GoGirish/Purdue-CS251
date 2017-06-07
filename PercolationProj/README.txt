README FILE
_____________________________________________________________

To run programs, first type the following into terminal:

javac ­classpath .:stdlib.jar WeightedQuickUnionUF.java

javac ­classpath .:stdlib.jar QuickUnionUF.java

javac ­classpath .:stdlib.jar Percolation.java

javac ­classpath .:stdlib.jar PercolationQuick.java

javac ­classpath .:stdlib.jar PercolationVisualizer.java

javac ­classpath .:stdlib.jar PercolationStats.java

javac ­classpath .:stdlib.jar VisualizeFrames.java
____________________________________________________________

To run Percolation.java, type:

java ­classpath .:stdlib.jar Percolation < \\Insert_txt_file_here.txt//

examples:
java ­classpath .:stdlib.jar Percolation < DemoYes.txt
_________________________________________________________________

To run PercolationVisualizer.java, type:

java ­classpath .:stdlib.jar PercolationVisualizer < \\Insert_txt_file_here.txt//
____________________________________________________________________________________

To run PercolationStats.java, type

java ­classpath .:stdlib.jar PercolationStats \\N=size of grid// \\T=number of trial runs// \\"fast" or "slow"//

fast=WeightedQuickUnionUF implementation.
slow=QuickUnionUF implementation.

examples:

java ­classpath .:stdlib.jar PercolationStats 10 30 fast
this runs PercolationStats at a 10x10 grid, collecting data for 30 trials using the WeightedQuickUnionUF implementation.
___________________________________________________________________________________________________________