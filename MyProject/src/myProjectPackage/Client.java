package myProjectPackage;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
//import java.rmi.registry.*;

public class Client {
public static void main(String[] args) {
    try{
        Registry registry = LocateRegistry.getRegistry("localhost",5000);
        Calculator ob = (Calculator) registry.lookup("rmi://localhost/CalculatorService");

        Scanner input = new Scanner(System.in);
        double a = input.nextDouble();
        double b = input.nextDouble();

        System.out.println("Enter Operator(+,-,*,/): ");
        String operator = input.next();

        switch (operator){
            case "+":
                double addResult = ob.add(a,b);
                System.out.println(addResult);
                break;
            case "-":
                double subResult = ob.subtract(a,b);
                System.out.println(subResult);
                break;
            case "*":
                double multResult = ob.multiply(a,b);
                System.out.println(multResult);
                break;
            case "/":
                double divisionResult = ob.division(a,b);
                System.out.println(divisionResult);
                break;
            default:
                System.out.println("Invalid operation");
        }

        input.close();
    } catch (ArithmeticException e) {
        System.out.println("Math error occurred: " + e.getMessage());
    }

    catch(Exception e){
        System.out.println("Failed to connect to server"+e);
    }
}
}
