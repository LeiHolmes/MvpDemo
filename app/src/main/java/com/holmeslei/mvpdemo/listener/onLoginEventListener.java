package com.holmeslei.mvpdemo.listener;

/**
 * Description:
 * author         xulei
 * Date           2017/5/31
 */

public interface onLoginEventListener {
    void onNameError();

    void onPasswordError();

    void onAllError();

    void onSuccess();
}
