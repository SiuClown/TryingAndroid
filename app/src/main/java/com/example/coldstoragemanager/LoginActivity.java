package com.example.coldstoragemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.example.coldstoragemanager.utils.ToastUtil;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private DBOpenHelper mDBOpenHelper;
    private TextView mTvLoginActivityRegister;
    private RelativeLayout RegisterActivity;
    private EditText mEtLoginUserName;
    private EditText mEtLoginUserPSW;
    private LinearLayout mLlLoginA;
    private Button mBtnLoginl;
    private Button mBtnLogin2r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();

    }

    private void initView(){
        mEtLoginUserName = findViewById(R.id.et_login_name);
        mEtLoginUserPSW = findViewById(R.id.et_login_pwd);
        mBtnLoginl = findViewById(R.id.btn_login);
        mBtnLogin2r = findViewById(R.id.btn_go_register);

        mBtnLoginl.setOnClickListener(this);
        mBtnLogin2r.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        String LoginS = "登录成功";
        String LoginF = "登录失败";
        String LoginUserW = "账号或密码错误，请重新输入";
        String LoginEmpty = "请输入账号或密码";
        switch (view.getId()){
            case R.id.btn_login:
                //获取登录用户名以及密码
                String lUsername = mEtLoginUserName.getText().toString().trim();
                String lUserpassword = mEtLoginUserPSW.getText().toString().trim();

                //判断登录是否规范
                if(!TextUtils.isEmpty(lUsername)&&!TextUtils.isEmpty(lUserpassword)){
                    ArrayList<User> data = mDBOpenHelper.getAllDate();
                    boolean match = false;
                    for(int i = 0;i < data.size();i++){
                        User user = data.get(i);
                        if(lUsername.equals(user.getName())&&lUserpassword.equals(user.getPassword())){
                            match = true;
                            break;
                        } else{
                            match = false;
                        }
                    }
                    if(match){
                        ToastUtil.showMsg(getApplicationContext(),LoginS);
                        Intent L2Mintent = new Intent(this,MainActivity.class);
                        startActivity(L2Mintent);//跳转
                        finish();//完成跳转并释放本页
                    }else {
                        ToastUtil.showMsg(getApplicationContext(),LoginF+LoginUserW);
                    }
                }else {
                    ToastUtil.showMsg(getApplicationContext(),LoginEmpty);
                }

            case R.id.btn_go_register:
                Intent L2Rintent = new Intent(this,RegisterActivity.class);
                startActivity(L2Rintent);
                finish();
        }
    }
}