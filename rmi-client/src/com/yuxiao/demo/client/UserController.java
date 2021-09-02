package com.yuxiao.demo.client;

import com.yuxiao.demo.client.com.yuxiao.demo.RemoteServiceReference;
import com.yuxiao.demo.com.yuxiao.demo.dto.UserInfo;
import com.yuxiao.demo.service.UserService;

import java.rmi.RemoteException;

/**
 * @author yuxiao
 * @date 2021-04-12 17:01
 */
public class UserController {


    public static void main(String[] args) throws RemoteException {
        String serviceName = UserService.class.getSimpleName();
        UserService userService = RemoteServiceReference.getRemoteService(serviceName);
        if(userService != null) {
            UserInfo userInfo = userService.getUnameById(111);
            System.out.println(userInfo);
        } else {
            System.out.println(serviceName+" Not found.");
        }
    }

}
