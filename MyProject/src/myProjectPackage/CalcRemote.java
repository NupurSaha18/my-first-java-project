package myProjectPackage;

import java.rmi.*;
import java.rmi.server.*;

public  class CalcRemote extends UnicastRemoteObject implements Calculator {
    protected CalcRemote() throws RemoteException {
        super();
    }

    @Override
    public int multiply(int a, int b) {
        return (a * b);
    }

    @Override
    public int division(int a, int b) {

        return (a / b);
    }
}