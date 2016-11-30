package com.example.wo.travelt.ui.activity;

import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wo.travelt.R;
import com.example.wo.travelt.base.BaseActivity;
import com.example.wo.travelt.presenter.impl.LoginPresenterImpl;
import com.example.wo.travelt.view.ILoginView;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.OnClick;

import static com.example.wo.travelt.R.id.btn_zhuce;

/**
 * Created by freestar on 2016/11/2.
 */

public class LoginActivity extends BaseActivity implements ILoginView {
    @Inject
    LoginPresenterImpl loginPresenter;

    @Bind(R.id.login_back)
    ImageView loginBack;
    @Bind(R.id.iv_login_logo)
    ImageView ivLoginLogo;
    @Bind(R.id.iv_login_name)
    ImageView ivLoginName;
    @Bind(R.id.tv_login_name)
    TextView tvLoginName;
    @Bind(R.id.et_name)
    EditText etName;
    @Bind(R.id.iv_login_password)
    ImageView ivLoginPassword;
    @Bind(R.id.tv_login_password)
    TextView tvLoginPassword;
    @Bind(R.id.et_psw)
    EditText etPsw;
    @Bind(R.id.dcheckBox2)
    CheckBox dcheckBox2;
    @Bind(R.id.dcheckBox)
    CheckBox dcheckBox;
    @Bind(R.id.btn_login)
    Button btnlogin;
    @Bind(R.id.btn_wangjimima)
    Button btnWangjimima;
    @Bind(btn_zhuce)
    Button btnZhuce;
    ScaleAnimation scale;

    @Override
    protected void initView() {
        scale = (ScaleAnimation) AnimationUtils.loadAnimation(this, R.anim.scale);

        loginPresenter.attachView(this);
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_login;
    }

    @Override
    protected void initInjector() {
        super.initInjector();
        mActivityComponent.inject(this);
        mIPresenter = loginPresenter;
    }

    @Override
    public void login() {
        readyGo(MainActivity.class);
    }

    @OnClick({R.id.dcheckBox2, R.id.dcheckBox, R.id.btn_login, R.id.btn_wangjimima, btn_zhuce})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.dcheckBox2:
                break;
            case R.id.dcheckBox:
                break;
            case R.id.btn_login:
                loginPresenter.login(etName.getText().toString(), etPsw.getText().toString());
                break;
            case R.id.btn_wangjimima:
                btnWangjimima.startAnimation(scale);
                readyGo(ZhaomimaActivity.class);
                break;
            case btn_zhuce:
                btnZhuce.startAnimation(scale);
                readyGo(ShoujizhuceActivity.class);
                break;
        }
    }
}
