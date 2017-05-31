package com.holmeslei.mvpdemo.model;

/**
 * Description:   模拟登陆的操作的接口，实现类为LoginModelImpl，相当于Model层
 * author         xulei
 * Date           2017/5/31
 */

public interface LoginModel {
    void login(String name, String password, onLoginEventListener onLoginEventListener);
}
