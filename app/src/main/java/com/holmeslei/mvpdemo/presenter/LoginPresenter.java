package com.holmeslei.mvpdemo.presenter;

/**
 * Description:   登录的Presenter接口，实现类为LoginPresenterImpl，完成登陆的验证，以及销毁当前view
 * author         xulei
 * Date           2017/5/31
 */

public interface LoginPresenter {
    void comfirmLogin(String name, String password);

    void onDestory();
}
