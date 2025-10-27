package myProjectPackage;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
//import java.rmi.registry.*;

public class Client {
public static void main(String[] args) {
    try{
        Registry registry = LocateRegistry.getRegistry("localhost",5000);
        Calculator ob = (Calculator) registry.lookup("rmi://localhost/CalculatorService");

        int value = ob.multiply(6, 5);
       int value2 = ob.division(30,10);
        System.out.println(value);
        System.out.println(value2);
    } catch (ArithmeticException e) {
        System.out.println("Math error occurred: " + e.getMessage());
    }

    catch(Exception e){
        System.out.println("Failed to connect to server"+e);
    }
}
}
