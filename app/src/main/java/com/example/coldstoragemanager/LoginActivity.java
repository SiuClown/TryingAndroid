package com.example.coldstoragemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
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
        switch (view.getId()){
            case R.id.btn_login:
                String name = mEtLoginUserName.getText().toString().trim();
                String password = mEtLoginUserPSW.getText().toString().trim();
        }
    }
}