package myProjectPackage;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

// client class main method implementation
public class Client {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 5000);
            Calculator ob = (Calculator) registry.lookup("rmi://localhost/CalculatorService");

// scanner class initialization for taking user input
            Scanner input = new Scanner(System.in);

//for performing operation interactively
            boolean overallContinue = true;
            while (overallContinue) {
//for taking user input
                System.out.println("Enter a: ");
                double a = input.nextDouble();
                System.out.println("Enter b: ");
                double b = input.nextDouble();
//choosing operation
                boolean pairContinue = true;
                while (pairContinue) {
                    System.out.println("1.Add  2.Subtract  3.Multiply  4.Divide  5.Change a & b  6.Exit");
                    System.out.println("Enter choice:");
                    int choice = input.nextInt();
//switch to choose operation
                    switch (choice) {
                        case 1:
                            System.out.println("Result: " + ob.add(a, b));
                            break;
                        case 2:
                            System.out.println("Result: " + ob.subtract(a, b));
                            break;
                        case 3:
                            System.out.println("Result: " + ob.multiply(a, b));
                            break;
                        case 4:
                            if (b == 0) {
                                System.out.println("Cannot divide by zero!");
                            } else {
                                System.out.println("Result: " + ob.division(a, b));
                            }
                            break;
                        case 5:
                            pairContinue = false;
                            break;
                        case 6:
                            pairContinue = false;
                            overallContinue = false;
                            break;
                        default:
                            System.out.println("Invalid operation");
                            break;
                    }

                    System.out.println(); // blank line for readability
                }
            }

            input.close();

        } catch (ArithmeticException e) {
            System.out.println("Math error occurred: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Failed to connect to server: " + e);
        }
    }
}