package com.holmeslei.mvpdemo.view;

/**
 * Description:   LoginActivity的View接口
 * author         xulei
 * Date           2017/5/31
 */

public interface LoginView {
    void showProgress();

    void hideProgress();

    void showNameError();

    void showPasswordError();

    void showAllError();

    void showLoginToast();
}
