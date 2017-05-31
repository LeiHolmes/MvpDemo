package com.holmeslei.mvpdemo.model;


import android.os.Handler;

import com.holmeslei.mvpdemo.listener.onLoginEventListener;

/**
 * Description:   LoginModel的实现类，模拟请求服务器延时2s回应
 * author         xulei
 * Date           2017/5/31
 */

public class LoginModelImple implements LoginModel {
    @Override
    public void login(final String name, final String password, final onLoginEventListener onLoginEventListener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if ("xulei".equals(name) && "123456".equals(password)) {
                    onLoginEventListener.onSuccess();
                } else if (!"xulei".equals(name) && "123456".equals(password)) {
                    onLoginEventListener.onNameError();
                } else if ("xulei".equals(name) && !"123456".equals(password)) {
                    onLoginEventListener.onPasswordError();
                } else {
                    onLoginEventListener.onAllError();
                }
            }
        }, 2000);
    }
}
