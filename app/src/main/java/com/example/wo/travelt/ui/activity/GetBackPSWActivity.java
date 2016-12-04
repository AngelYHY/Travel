package com.example.wo.travelt.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.wo.travelt.R;
import com.example.wo.travelt.base.BaseActivity;
import com.example.wo.travelt.presenter.impl.GetBackPSWPresenterImpl;
import com.example.wo.travelt.view.IGetBackPSWView;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by freestar on 2016/11/4.
 */
public class GetBackPSWActivity extends BaseActivity implements IGetBackPSWView {

    @Inject
    GetBackPSWPresenterImpl mPresenter;

    @Bind(R.id.title)
    TextView mTitle;
    @Bind(R.id.et_phone_num)
    EditText mEtPhoneNum;
    @Bind(R.id.et_psw)
    EditText mEtPsw;

    @Override
    protected void initView() {
        mTitle.setText("找回密码");

        mPresenter.attachView(this);
    }

    @Override
    protected void initInjector() {
        super.initInjector();
        mActivityComponent.inject(this);
        mIPresenter = mPresenter;
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_get_back_psw;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_code, R.id.btn_confirm})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_code:
                break;
            case R.id.btn_confirm:

                break;
        }
    }
}
