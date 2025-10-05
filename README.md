Insertion Sort Benchmark
Project Overview

This project implements and analyzes the Insertion Sort algorithm in Java.
It measures execution time, comparisons, and swaps for different types of input arrays.
The results are presented in the analysis-report.pdf document with tables and performance plots.

The goal of this assignment is to understand how input order affects the performance of Insertion Sort.

Implementation Details

Algorithm: InsertionSort.java
Located in src/main/java/algorithms/.
Uses a helper class PerformanceTracker.java to record:

Number of comparisons

Number of swaps

Execution time in milliseconds

Benchmark Runner: BenchmarkRunner.java
Located in src/main/java/cli/.
It generates different types of input arrays: Random, Sorted, Reversed, and Nearly Sorted.
The benchmark runs for several input sizes (n = 100, 1000, 5000, 10000) and prints the results to the console.

Metrics Class: PerformanceTracker.java
Records sorting statistics and calculates total execution time using System.nanoTime().

Testing

Unit tests are implemented in InsertionSortTest.java using JUnit 5.

To run all tests:

mvn test


All tests verify that:

The array is correctly sorted.

The algorithm works for empty and single-element arrays.

Running the Benchmark

To compile and run the program:

mvn clean compile exec:java


Alternatively, specify the main class explicitly:

mvn clean compile exec:java -Dexec.mainClass=cli.BenchmarkRunner


Example output:

=== RANDOM INPUT ===
n = 1000  → Time: 2.6 ms | Comparisons: 256000 | Swaps: 255000

Performance Analysis

The performance plots are stored in the folder docs/performance-plots/:

Execution Time vs Input Size

Comparisons vs Input Size

Swaps vs Input Size

The detailed analysis and visual results are available in docs/analysis-report.pdf.

Conclusion

Insertion Sort performs efficiently on small or nearly sorted datasets.
However, its performance decreases significantly for large or reversed arrays due to its quadratic time complexity, O(n²).

This experiment demonstrates how input structure influences sorting algorithm performance.

Tools and Dependencies

Java 17

Maven

JUnit 5

Exec Maven Plugin