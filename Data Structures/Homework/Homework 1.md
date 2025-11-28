Alexis Baker


Data Structures


Homework 1


11/28/2025


**Write a Java function to reverse an array in place: swap the first element and the last, the second and the next-to-last, etc. You don't need to write a whole program and run it. Here is the signature: `static void reverse(int[] array)`**
See HW1Q1.java

**Write a Java program to solve the first problem in the book. Read the input (either from a file or terminal) one line at a time and then write the lines out in reverse order, so that the last input line is printed first, then the second last input line, and so on.**
See HW1Q2.java

**Write a function to read the first 50 lines of input and then write them out in reverse order. Read the next 50 lines and then write them out in reverse order. Do this until there are no more lines left to read, at which point any remaining lines should be output in reverse order.**
See HW1Q3.java

**Read the input one line at a time and write each line to the output if it is not a duplicate of some previous input line. Take special care so that a file with a lot of duplicate lines does not use more memory than what is required for the number of unique lines.**
See HW1Q4.java

**A matched string is a sequence of {, }, (, ), [, and ] characters that are properly matched. For example, “{{()[]}}” is a matched string, but “{{()]}” is not, since the second { is matched with a ]. Explain how to use a stack so that, given a string of length n, you can determine if it is a matched string in O(n) time.**
Initialize a stack. Traverse it. If it's an opening character, push it; if it's a closing character, check the stack. If it's empty, return `false`. Otherwise, pop the top element and check if it matches. If at the end of the string the stack is empty, that means everything matched. This process takes O(n) time.