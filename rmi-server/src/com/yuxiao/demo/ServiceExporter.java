package com.yuxiao.demo;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Enumeration;

/**
 * 服务暴露器
 *
 * @author yuxiao
 * @date 2021-04-12 17:06
 */
public class ServiceExporter {

    private static String basePackage = "com.yuxiao.demo.service.impl";

    private static Registry registry;

    static {
        try {
            registry = LocateRegistry.createRegistry(8080);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }


    /**
     * 暴露service包下的服务，按服务接口名称暴露服务
     */
    public static void exporter() throws IOException {
        String basePackageFilePath = basePackage.replace(".", "/");
        ClassLoader classLoader = ServiceExporter.class.getClassLoader();
        Enumeration<URL> resources = classLoader.getResources(basePackageFilePath);
        while (resources.hasMoreElements()) {
            URL url = resources.nextElement();
            String protocol = url.getProtocol();
            if("file".equals(protocol)) {
                String filePath = url.getFile();
                File dir = new File(filePath);
                if(!dir.exists() || !dir.isDirectory()) {
                    return;
                }
                File[] files = dir.listFiles();
                for (File file : files) {
                    // 如果是java类文件 去掉后面的.class 只留下类名
                    String className = file.getName().substring(0, file.getName().length() - 6);
                    try {
                        Class<?> aClass = classLoader.loadClass(basePackage + '.' + className);
                        exporter((Remote) aClass.newInstance());
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (AlreadyBoundException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            } else if("jar".equals(protocol)) {

            }
        }
    }

    /**
     * 暴露服务指定的服务
     * 如果此处的暴露服务暴露到"注册中心"，则可以实现Java的Dubbo服务
     *
     * @param serviceClazz
     * @throws AlreadyBoundException
     * @throws RemoteException
     */
    public static void exporter(Remote serviceClazz) throws AlreadyBoundException, RemoteException {
        String serviceName = serviceClazz.getClass().getInterfaces()[0].getSimpleName();
        registry.bind(serviceName, serviceClazz);
        System.out.println(serviceName + " export finished.");
    }

}
