package myProjectPackage;

import java.rmi.Remote;
import java.rmi.RemoteException;

// creating the remote interface and added all the operation method
public interface Calculator extends Remote {

    public double multiply(double a, double b) throws RemoteException;

    public double division(double a, double b) throws RemoteException;

    public double add(double a, double b) throws RemoteException;

    public double subtract(double a, double b) throws RemoteException;
}
