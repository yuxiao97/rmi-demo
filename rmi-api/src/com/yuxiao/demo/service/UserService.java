package com.yuxiao.demo.service;

import com.yuxiao.demo.com.yuxiao.demo.dto.UserInfo;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 定义远程服务接口，必须集成Remote接口
 * @author yuxiao
 * @date 2021-04-12 16:56
 */
public interface UserService extends Remote {

    UserInfo getUnameById(int uid) throws RemoteException;

}
