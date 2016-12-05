package com.example.wo.travelt.ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.wo.travelt.R;
import com.example.wo.travelt.base.BaseActivity;
import com.example.wo.travelt.presenter.impl.LoginPresenterImpl;
import com.example.wo.travelt.view.ILoginView;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.OnClick;

import static com.example.wo.travelt.R.id.tv_register;

/**
 * Created by freestar on 2016/11/2.
 */

public class LoginActivity extends BaseActivity implements ILoginView {
    @Inject
    LoginPresenterImpl mPresenter;

    @Bind(R.id.title)
    TextView mTitle;
    @Bind(R.id.et_name)
    EditText mEtName;
    @Bind(R.id.et_psw)
    EditText mEtPsw;
    @Bind(R.id.check_remember)
    CheckBox mCheckRemember;
    @Bind(R.id.check_auto)
    CheckBox mCheckAuto;
    @Bind(R.id.btn_login)
    Button mBtnLogin;
    @Bind(R.id.tv_forget_psw)
    TextView mTvForgetPsw;
    @Bind(tv_register)
    TextView mTvRegister;

    @Override
    protected void initView() {
        mTitle.setText("账户登录");
        mPresenter.attachView(this);
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_login;
    }

    @Override
    protected void initInjector() {
        super.initInjector();
        mActivityComponent.inject(this);
        mIPresenter = mPresenter;
    }

    @Override
    public void login() {
        readyGoThenKill(MainActivity.class);
    }

    @OnClick({R.id.btn_login, R.id.tv_forget_psw, R.id.tv_register})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                mPresenter.login(mEtName.getText().toString(), mEtPsw.getText().toString(), mCheckRemember.isChecked(), mCheckAuto.isChecked());
                break;
            case R.id.tv_forget_psw:
                readyGo(GetBackPSWActivity.class);
                break;
            case tv_register:
                readyGo(PhoneRegisterActivity.class);
                break;
        }
    }

}
