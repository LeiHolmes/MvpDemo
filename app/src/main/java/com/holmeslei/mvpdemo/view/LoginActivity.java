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


public class LoginActivity extends Activity implements LoginView {
    private EditText etName;
    private EditText etPassword;
    private ProgressBar progressBar;

    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        loginPresenter = new LoginPresenterImpl(this);
    }

    private void initView() {
        etName = (EditText) findViewById(R.id.login_name);
        etPassword = (EditText) findViewById(R.id.login_password);
        progressBar = (ProgressBar) findViewById(R.id.login_progress);
    }

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
