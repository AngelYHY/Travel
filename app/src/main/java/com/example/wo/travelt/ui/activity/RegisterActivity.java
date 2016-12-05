package com.example.wo.travelt.ui.activity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.wo.travelt.R;
import com.example.wo.travelt.base.BaseActivity;
import com.example.wo.travelt.presenter.impl.RegisterPresenterImpl;
import com.example.wo.travelt.view.IRegisterView;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by freestar on 2016/11/4.
 */

public class RegisterActivity extends BaseActivity implements IRegisterView {
    @Inject
    RegisterPresenterImpl mPresenter;

    @Bind(R.id.title)
    TextView mTitle;
    @Bind(R.id.et_name)
    EditText mEtName;
    @Bind(R.id.et_psw)
    EditText mEtPsw;
    @Bind(R.id.et_confirm_psw)
    EditText mEtConfirmPsw;

    private String mPhoneNum;

    @Override
    protected void initView() {
        mTitle.setText("用户注册");
        Bundle bundle = getIntent().getExtras();
        mPhoneNum = bundle.getString("phoneNum");
        mPresenter.attachView(this);
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_register;
    }

    @Override
    protected void initInjector() {
        super.initInjector();
        mActivityComponent.inject(this);
        mIPresenter = mPresenter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_register)
    public void onClick() {
        mPresenter.register(mEtName.getText().toString(), mEtPsw.getText().toString(), mEtConfirmPsw.getText().toString(), mPhoneNum);
    }

    @Override
    public void go(boolean flag) {
        if (flag) {
            readyGo(MainActivity.class);
        } else {
            readyGo(PhoneRegisterActivity.class);
        }
    }
}
