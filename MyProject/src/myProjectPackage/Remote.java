package myProjectPackage;

import java.rmi.*;
import java.rmi.server.*;

// implement all the methods one by one
public class Remote extends UnicastRemoteObject implements Calculator {
    protected Remote() throws RemoteException {
        super();
    }

    //  for multiplication
    @Override
    public double multiply(double a, double b) {
        return (a * b);
    }

    // for division
    @Override
    public double division(double a, double b) {
        return (a / b);
    }

    // for doing addition
    @Override
    public double add(double a, double b) {
        return a + b;
    }

    // for subtraction
    @Override
    public double subtract(double a, double b)  {
        return a - b;
    }
}