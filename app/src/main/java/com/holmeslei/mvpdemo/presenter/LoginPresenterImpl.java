package com.holmeslei.mvpdemo.presenter;

import com.holmeslei.mvpdemo.model.LoginModel;
import com.holmeslei.mvpdemo.model.LoginModelImple;
import com.holmeslei.mvpdemo.model.onLoginEventListener;
import com.holmeslei.mvpdemo.view.LoginView;

/**
 * Description:   登录Presenter接口的实现类
 * 在这里进行Model层和View层的交互和操作
 * author         xulei
 * Date           2017/5/31
 */

public class LoginPresenterImpl implements LoginPresenter, onLoginEventListener {
    private LoginView loginView;
    private LoginModel loginModell;

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        loginModell = new LoginModelImple();
    }

    @Override
    public void comfirmLogin(String name, String password) {
        if (loginView != null)
            loginView.showProgress();
        loginModell.login(name, password, this);
    }

    @Override
    public void onDestory() {
        loginView = null;
    }

    @Override
    public void onNameError() {
        if (loginView != null) {
            loginView.hideProgress();
            loginView.showNameError();
        }
    }

    @Override
    public void onPasswordError() {
        if (loginView != null) {
            loginView.hideProgress();
            loginView.showPasswordError();
        }
    }

    @Override
    public void onAllError() {
        if (loginView != null) {
            loginView.hideProgress();
            loginView.showAllError();
        }
    }

    @Override
    public void onSuccess() {
        if (loginView != null) {
            loginView.hideProgress();
            loginView.showLoginToast();
        }
    }
}
