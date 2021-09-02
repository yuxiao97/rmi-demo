package com.yuxiao.demo.service.impl;

import com.yuxiao.demo.com.yuxiao.demo.dto.UserInfo;
import com.yuxiao.demo.service.UserService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;

/**
 * 必须继承UnicastRemoteObject，以允许JVM创建远程的存根/代理。
 * @author yuxiao
 * @date 2021-04-12 16:58
 */
public class UserServiceImpl extends UnicastRemoteObject implements UserService {

    public UserServiceImpl() throws RemoteException {
    }

    @Override
    public UserInfo getUnameById(int uid) throws RemoteException {
        if(uid > 0){
            UserInfo userInfo = new UserInfo();
            userInfo.setUid(uid);
            userInfo.setAge(new Random().nextInt(20));
            userInfo.setName("我叫"+uid);
            return userInfo;
        }
        throw new RemoteException("参数错误");
    }
}
