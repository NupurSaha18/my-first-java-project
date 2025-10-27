package myProjectPackage;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculator extends Remote {

public int multiply(int a, int b) throws RemoteException;

public int division(int a, int b) throws RemoteException;
}
