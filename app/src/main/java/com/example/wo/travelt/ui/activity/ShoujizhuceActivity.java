package com.example.wo.travelt.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wo.travelt.R;
import com.example.wo.travelt.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by freestar on 2016/11/4.
 */
public class ShoujizhuceActivity extends BaseActivity {
    @Bind(R.id.phone_register_back)
    ImageView phoneRegisterBack;
    @Bind(R.id.iv_phone_register_logo)
    ImageView ivPhoneRegisterLogo;
    @Bind(R.id.iv_login_name)
    ImageView ivLoginName;
    @Bind(R.id.tv_login_name)
    TextView tvLoginName;
    @Bind(R.id.et_zphone)
    EditText etZphone;
    @Bind(R.id.iv_login_password)
    ImageView ivLoginPassword;
    @Bind(R.id.tv_login_password)
    TextView tvLoginPassword;
    @Bind(R.id.et_zyanzhengma)
    EditText etZyanzhengma;
    @Bind(R.id.btn_zhuceyanzhenma)
    Button btnZhuceyanzhenma;
    @Bind(R.id.btn_shoujizhuce)
    Button btnShoujizhuce;

    @Override
    protected void initView() {

    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_shoujizhuce;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_zhuceyanzhenma, R.id.btn_shoujizhuce})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_zhuceyanzhenma:
                break;
            case R.id.btn_shoujizhuce:
                break;
        }
    }
}
