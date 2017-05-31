package com.holmeslei.mvpdemo.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.holmeslei.mvpdemo.R;
import com.holmeslei.mvpdemo.presenter.LoginPresenter;
import com.holmeslei.mvpdemo.presenter.LoginPresenterImpl;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Description:   1. 使用MVP模式之后，Activity主要做一些UI上的操作。
 *                2. LoginView封装一些操作UI的方法，由LoginActivity实现。
 *                3. LoginPresenter负责View与Model的交互，由LoginPresenterImpl实现。
 *                   LoginPresenter接收到View的登录点击事件后，将业务逻辑交给LoginModel去处理。
 *                4. LoginModel负责具体的业务逻辑处理，由LoginModelImple实现
 *                   这里是判断输入的用户名与密码是否正确，将处理结果返回给LoginPresenter。
 *                5. LoginPresenter根据返回的不同数据通过LoginView调用View上不同的操作
 * author         xulei
 * Date           2017/5/31 11:58
 */
public class LoginActivity extends Activity implements LoginView {
    @BindView(R.id.login_progress)
    ProgressBar progressBar;
    @BindView(R.id.login_name)
    EditText etName;
    @BindView(R.id.login_password)
    EditText etPassword;

    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        loginPresenter = new LoginPresenterImpl(this);
    }

    @OnClick(R.id.login_start)
    public void onLoginClick(View view) {
        loginPresenter.comfirmLogin(etName.getText().toString(), etPassword.getText().toString());
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showNameError() {
        Toast.makeText(this, "用户名错误", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showPasswordError() {
        Toast.makeText(this, "密码错误", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showAllError() {
        Toast.makeText(this, "用户名与密码错误", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoginToast() {
        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        loginPresenter.onDestory();
        super.onDestroy();
    }
}
