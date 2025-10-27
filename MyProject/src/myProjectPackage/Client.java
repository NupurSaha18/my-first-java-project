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
        double addResult = ob.add(a,b);
        System.out.println(addResult);

    } catch (ArithmeticException e) {
        System.out.println("Math error occurred: " + e.getMessage());
    }

    catch(Exception e){
        System.out.println("Failed to connect to server"+e);
    }
}
}
