// Write Java program for the following - 
// It should  run till user enters any other option than add or sub or multiply or divide
// Prompt user to enter the input operation : (add|subtract|multiply|divide) & 2 numbers(double)
// Display the result of the operation.
// Use Scanner for accepting all inputs from user. 
// Hint : use switch-case

import java.util.Scanner;

class Calculator {

    public static void main(String[] args) {
        Scanner myscan = new Scanner(System.in);
        System.out.println("\n*********CALCULATOR*********\n");
        boolean my_flag = false;

        while (!my_flag) {
            System.out.print("Enter First Number: ");
            double num1 = myscan.nextDouble();
            System.out.print("Enter Second Number: ");
            double num2 = myscan.nextDouble();
            System.out.print("Enter operation you wanna do(add|subtract|multiply|divide): ");
            switch (myscan.next()) {

                case "add":
                    System.out.println("Addition is " + (num1 + num2));
                    break;
                case "subtract":
                    System.out.println("Subtraction is " + (num1 - num2));
                    break;
                case "multiply":
                    System.out.println("Multiplication is " + (num1 * num2));
                    break;
                case "divide":
                    System.out.println("Addition is " + (num1 / num2));
                    break;
                default:
                    System.out.println("Invalid operation");
                    my_flag = true;

            }

        }

        myscan.close();
    }
}
