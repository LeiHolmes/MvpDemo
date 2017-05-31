package com.holmeslei.mvpdemo.model;

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
