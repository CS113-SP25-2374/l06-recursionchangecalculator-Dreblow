[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/Q8GX3Ogb)
# CS113 Lab 06
## [Recursive] Change Calculator (Programming Project #7, pg. 291):

Using the provided ChangeCalculatorRecursive class, implement the recursive method `calculateRecursive(int)` which will dispense change for a given amount of money. The method will **return a list** of the total number of combinations of quarters, dimes, nickels, and pennies that equal the desired amount and all the combinations as well. Avoid duplication.

**_NOTE:_** _Your program should dispense the highest coin first (quarters, then dimes, then nickels, then pennies)._ The helper method `combinationToString(int[] combination)` will format your string for you with an array of "1q 2d 3n 4p". An example string is below:

``` 
0q 0d 0n 5p 
``` 

Your method will be compared against the `calculateLinear(int)` for accuracy!

----------

### Make sure to commit + push *before* leaving the lab so your work is saved!

>Pro-Tip:
>- Refer to the given documentation in the ChangeCalculator class as you plan and design your implementation of its methods. 
