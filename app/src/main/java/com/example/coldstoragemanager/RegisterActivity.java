package com.example.coldstoragemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText mEtRegisterUserName;
    private EditText mEtRegisterUserPSW;
    private EditText mEtRegisterUserPhone;
    private EditText mEtRegisterUserMail;
    private EditText mEtRegisterUserPosition;
    private Button mBtnRegister;

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

        mBtnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

    }
}