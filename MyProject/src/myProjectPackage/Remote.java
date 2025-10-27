package myProjectPackage;

import java.rmi.*;
import java.rmi.server.*;

public  class Remote extends UnicastRemoteObject implements Calculator {
    protected Remote() throws RemoteException {
        super();
    }

    @Override
    public double multiply(double a, double b) {
        return (a * b);
    }

    @Override
    public double division(double a, double b){
        return (a / b);
    }

    @Override
    public double add(double a, double b){
    return a+b ;
    }

    @Override
    public double subtract(double a, double b) throws RemoteException {
        return a-b;
    }
}