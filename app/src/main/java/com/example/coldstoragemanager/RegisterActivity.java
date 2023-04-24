package com.example.coldstoragemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.coldstoragemanager.utils.ToastUtil;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private DBOpenHelper mDBOpenHelper;
    private EditText mEtRegisterUserName;
    private EditText mEtRegisterUserPSW;
    private EditText mEtRegisterUserPhone;
    private EditText mEtRegisterUserMail;
    private EditText mEtRegisterUserPosition;
    private Button mBtnRegister;
    private Button mBtnRegister_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initView();
    }

    private void initView() {
        mEtRegisterUserName = findViewById(R.id.et_register_name);
        mEtRegisterUserPSW = findViewById(R.id.et_register_pwd);
        mEtRegisterUserPhone = findViewById(R.id.et_register_phone);
        mEtRegisterUserMail = findViewById(R.id.et_register_mailadress);
        mEtRegisterUserPosition = findViewById(R.id.et_register_position);
        mBtnRegister = findViewById(R.id.btn_register);
        mBtnRegister_back = findViewById(R.id.btn_register_back);

        mBtnRegister.setOnClickListener(this);
        mBtnRegister_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String RegisterS = "注册成功";
        String RegisterF = "注册失败，请联系管理员";
        String backS = "返回到登录页";
        switch (view.getId()){
            case R.id.btn_register:
                //获取注册用户名以及密码
                String rUsername = mEtRegisterUserName.getText().toString().trim();
                String rUserPassword  = mEtRegisterUserPSW.getText().toString().trim();
                String rUserPhone  = mEtRegisterUserPhone.getText().toString().trim();
                String rUserMali  = mEtRegisterUserMail.getText().toString().trim();
                String rUserPosition  = mEtRegisterUserPosition.getText().toString().trim();
                //判断注册是否规范
                if(!TextUtils.isEmpty(rUsername)&&!TextUtils.isEmpty(rUserPassword)){
                    ToastUtil.showMsg(getApplicationContext(),RegisterS);
                    mDBOpenHelper.add(rUsername ,rUserPhone ,rUserPhone ,rUserMali ,rUserPosition);
                    Intent R2Mintent = new Intent(this,MainActivity.class);
                    startActivity(R2Mintent);
                    finish();
                }else{
                    ToastUtil.showMsg(getApplicationContext(),RegisterF);
                }
            case R.id.btn_register_back:
                ToastUtil.showMsg(getApplicationContext(),backS);
                Intent R2Lintent = new Intent(this,LoginActivity.class);
                startActivity(R2Lintent);
                finish();
        }
    }

}