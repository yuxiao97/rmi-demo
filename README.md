# rmi-demo
使用RMI(Remote Method Invoke)进行的远程方法调用。

# 什么是RMI？
RMI（Remote Method Invoke），远程方法调用，是JAVA提供的一种远程服务调用。

# RMI的使用
## 暴露服务
对外提供服务的接口需要实现`java.rmi.Remote`接口。
Remote接口用于标识其方法可以从非本地虚拟机调用的接口。 任何作为远程对象的对象都必须直接或间接实现此接口。 只有在“远程接口”（扩展java.rmi.Remote的接口）中指定的那些方法才可远程使用。
实现类可以实现任意数量的远程接口，并且可以扩展其他远程实现类。 

接口的实现需要继承`java.rmi.server.UnicastRemoteObject`，以允许JVM创建远程的存根/代理。

接口和服务都定义好了，剩下的就是暴露服务，以便可以远程通过网络进行调用。暴露服务需要通过`LocalRegistry`，通过创建一个本地服务注册，来将需要暴露的服务暴露出去，
如`LocalRegistry.createRegistry(8080)`，表示在8080端口进行服务的暴露，然后通过`registry.bind(serviceName, serviceClazz)`将暴露的服务绑定到LocalRegistry上，
此时要暴露的服务算是暴露出去了，客户端发起调用即可。服务暴露具体参考rmi-server中的`com.yuxiao.demo.ServiceExporter`。

## 引用服务
