/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Alice Yu
 */
package base;
import java.util.Scanner;
import java.lang.Math;

/*
Exercise 13 - Determining Compound Interest
Simple interest is something you use only when making a quick guess.
Most investments use a compound interest formula, which will be much more accurate.
And this formula requires you to incorporate exponents into your programs.

Write a program to compute the value of an investment compounded over time.
The program should ask for the starting amount, the number of years to invest, the interest rate,
and the number of periods per year to compound.

The formula you’ll use for this is A = P(1 + r/n)^(n*t) where

P is the principal amount.
r is the annual rate of interest.
t is the number of years the amount is invested.
n is the number of times the interest is compounded per year.
A is the amount at the end of the investment.

Example Output
What is the principal amount? 1500
What is the rate? 4.3
What is the number of years? 6
What is the number of times the interest is compounded per year? 4
$1500 invested at 4.3% for 6 years compounded 4 times per year is $1938.84.

Constraints
Prompt for the rate as a percentage (like 15, not .15). Divide the input by 100 in your program.
Ensure that fractions of a cent are rounded up to the next penny.
Ensure that the output is formatted as money.

Challenges
Ensure that all of the inputs are numeric and that the program will not let the user proceed without valid inputs.
Create a version of the program that works in reverse, so you can determine the initial amount you’d need to invest to reach a specific goal.
Implement this program as a GUI app that automatically updates the values when any value changes.
 */

public class App {
    Scanner in = new Scanner(System.in);

    public static void main(String[] args)
    {
        App myApp = new App();

        double principal= myApp.readInputDouble("What is the principal amount? ");
        double interest = myApp.readInputDouble("What is the rate? ");
        int years = myApp.readInputInteger("What is the number of years? ");
        int compoundYears = myApp.readInputInteger("What is the number of times the interest is compounded per year? ");

        double rDividedByn = (interest / 100 ) / compoundYears;
        double nt = years * compoundYears;
        double compoundInterest = principal * Math.pow((1 + rDividedByn), nt);

        String outputString = ("$" + principal + " invested at " + interest +
                "% for " + years + " years compounded " + compoundYears + " times per year is $" +
                String.format("%.2f", compoundInterest) + ".");
        myApp.printOutput(outputString);
    }

    public int readInputInteger(String input)
    {
        System.out.print(input);
        String num = in.next();
        return Integer.parseInt(num);
    }

    public double readInputDouble(String input)
    {
        System.out.print(input);
        String num = in.next();
        return Double.parseDouble(num);
    }

    public void printOutput(String input)
    {
        System.out.println(input);
    }
}
