Alexis Baker


Data Structures


Homework 2


11/28/2025


**Write  a Java function to read from input one line at a time and write each line to the output only if you have already read this line before. (The end result is that you remove the first occurrence of each line.) Take special care so that a file with a lot of duplicate lines does not use more memory than what is required for the number of unique lines. It should probably take a filename as a parameter.**
See HW2Q1.java

**Write a Java function to read the entire input one line at a time. Then output all lines sorted by length, with the shortest lines first. In the case where two lines have the same length, resolve their order using the usual “sorted order.” For 2 lines with the same length, the one that appeared first is printed first. Duplicate lines should be printed only once.**
See HW2Q2.java

**The List method addAll(i;c) inserts all elements of the Collection c into the list at position i. Explain why, for the data structures in this chapter, it is not efficient to implement addAll(i;c) by repeated calls to add(i;x). Design and implement a more efficient implementation. You can simplify the problem by assuming that the List and c are implemented with arrays.**
Using add(i; x) repeatedly is inefficient due to having to shift multiple elements, and shifting multiple elements multiple times, depending on where in the stack they're plaaced. For code, see HW2Q3.java.

**Implement a method rotate(a, r) that “rotates” the array a so that a[i] moves to a[(i + r) mod a.length], for all i in [0 ... a.length].**
See HW2Q4.java.