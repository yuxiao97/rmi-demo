package com.yuxiao.demo.client.com.yuxiao.demo;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * RMI远程服务获取
 * @author yuxiao
 * @date 2021-04-12 17:13
 */
public class RemoteServiceReference {

    private static Registry registry;

    static {
        try {
            registry = LocateRegistry.getRegistry("localhost", 8080);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }



    public static <T> T  getRemoteService(String serviceName) throws RemoteException {
        try {
            return (T)registry.lookup(serviceName);
        } catch (NotBoundException e) {
            e.printStackTrace();
            System.out.println("Remote service:["+serviceName+"] not found.");
            return null;
        }
    }


}
