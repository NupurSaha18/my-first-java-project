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

//  scanner class initialization
            Scanner input = new Scanner(System.in);

// for taking user input
            System.out.println("Enter a: ");
            double a = input.nextDouble();
            System.out.println("Enter b: ");
            double b = input.nextDouble();

// for choosing operation
            System.out.println("1.Add 2.Subtract 3.Multiply 4.Divide ");
            System.out.println("Enter choice:");
            int choice = input.nextInt();

// switch to choosing operation
            switch (choice) {
                case 1:
                    double addResult = ob.add(a, b);
                    System.out.println(addResult);
                    break;
                case 2:
                    double subResult = ob.subtract(a, b);
                    System.out.println(subResult);
                    break;
                case 3:
                    double multResult = ob.multiply(a, b);
                    System.out.println(multResult);
                    break;
                case 4:
                    double divisionResult = ob.division(a, b);
                    System.out.println(divisionResult);
                    break;
                default:
                    System.out.println("Invalid operation");
            }
            input.close();

        } catch (ArithmeticException e) {
            System.out.println("Math error occurred: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Failed to connect to server" + e);
        }
    }
}
