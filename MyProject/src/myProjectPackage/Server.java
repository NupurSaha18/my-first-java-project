package myProjectPackage;

import java.rmi.*;
import java.rmi.registry.*;

public class Server {
public static void main(String[] args) {
    try{
        Registry registry = LocateRegistry.createRegistry(5000);

        Calculator ob = new Remote();
        registry.rebind("rmi://localhost/CalculatorService", ob);
        System.out.println("Server is ready");
    }
    catch(Exception e){
        System.out.println("Server failed"+e);
    }
}
}
