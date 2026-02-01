# Barcodes

## About

_(TODO: insert a description of the project here!)_

### Authors

*   Brisha Jain
*   Risa Takemoto

### Resources

*   _(TODO: list your resources here!)_
*   ...

## Write-up

### Part 2.1: Old Hat, New Hat

1. With your partner, brainstorm a list of 
(a) useful functions over strings you’ve used in other languages and 
(b) operations, i.e., common programming patterns, over strings.

Answer:
(a) substring, strlen, strcpy
(b) check specific position of characters in the string and get the length of the string.

2. For each entry in your list, peruse the String class documentation and try to find an equivalent String method that performs the function/operation in question. If you can’t find such a method, write a code snippet that performs the same effect.

Answer: 
substring(int beginIndex, int endIndex)
length()
There is no particular strcpy function in Java because string exist as a data type so we can assign vallues to variables.

### Part 2.2: Iceberg, Right Head!

1. A worked since s1 and s2 are exactly the same string literals with the same memory address.
   B was false because the memory address of s3 and s4 are different.
   C didn't work as well since s5 is made in the heap, it has a different address from string s1.

2. To compare two strings for equality, we must use equals(obj) when we want to check the content of two strings.

3. When we use ==, it compares the memory location of two strings. 2 strings of B and C are in different memory locations.
   
4. Intern method is used to store a string in the string constant pool which is a special memory area within the heap. Thus, s1 and s2 are equal since there are stored in the pool and point to the same memory location.