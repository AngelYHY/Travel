package com.example.wo.travelt.ui.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.wo.travelt.R;
import com.example.wo.travelt.base.BaseActivity;
import com.example.wo.travelt.widget.PhoneUtil;

import java.util.concurrent.TimeUnit;

import butterknife.Bind;
import butterknife.OnClick;
import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;

/**
 * Created by freestar on 2016/11/4.
 */
public class PhoneRegisterActivity extends BaseActivity {

    @Bind(R.id.title)
    TextView mTitle;
    @Bind(R.id.et_phone_num)
    EditText mEtPhoneNum;
    @Bind(R.id.et_code)
    EditText mEtCode;
    @Bind(R.id.btn_code)
    Button mBtnCode;

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            int event = msg.arg1;
            int result = msg.arg2;
            Object data = msg.obj;

            if (result == SMSSDK.RESULT_COMPLETE) {
                // 短信注册成功后，返回MainActivity,然后提示
                if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {
                    // 验证码验证成功
                    showMsg("验证码验证成功");
                    Bundle bundle = new Bundle();
                    bundle.putString("phoneNum", mEtPhoneNum.getText().toString());
                    readyGo(RegisterActivity.class, bundle);
                } else if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE) {
                    showMsg("验证码已经发送");
                }
            } else {
                hideDialog();
                showMsg("验证失败" + data.toString());
                ((Throwable) data).printStackTrace();
            }
        }
    };

    @Override
    protected void initView() {
        mTitle.setText("手机注册");
        init();
    }

    private void init() {
        SMSSDK.initSDK(this, "19970dba255ca", "3e08c714d3bc00cec888313d04d50188");
        EventHandler eventHandler = new EventHandler() {
            @Override
            public void afterEvent(int event, int result, Object data) {
                Message msg = new Message();
                msg.arg1 = event;
                msg.arg2 = result;
                msg.obj = data;
                mHandler.sendMessage(msg);
            }
        };
        SMSSDK.registerEventHandler(eventHandler);
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_phone_register;
    }

    @OnClick({R.id.btn_code, R.id.btn_register})
    public void onClick(View view) {
        String num = mEtPhoneNum.getText().toString();
        switch (view.getId()) {
            case R.id.btn_code:
                if (!PhoneUtil.judgePhoneNums(num)) {
                    showMsg("手机号格式不正确");
                    return;
                }
                SMSSDK.getVerificationCode("86", num);
                mBtnCode.setClickable(false);
                countdown().subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onCompleted() {
                        mBtnCode.setText("获取验证码");
                        mBtnCode.setClickable(true);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Integer integer) {
                        mBtnCode.setText(String.format("重新发送(%s)", integer));
                    }
                });
                break;
            case R.id.btn_register:
                if (PhoneUtil.judgePhoneNums(num)) {
                    SMSSDK.submitVerificationCode("86", num, mEtCode.getText().toString());
                } else {
                    showMsg("手机号格式不正确");
                }
                break;
        }
    }

    private Observable<Integer> countdown() {
        return Observable.interval(0, 1, TimeUnit.SECONDS)
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Func1<Long, Integer>() {
                    @Override
                    public Integer call(Long aLong) {
                        return 30 - aLong.intValue();
                    }
                }).take(30 + 1);
    }
}
