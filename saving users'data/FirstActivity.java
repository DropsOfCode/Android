package com.example.a01.androidtest;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Map;


public class FirstActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etNumber;
    private EditText etPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        initView();
        Map<String,String> infos = FileSavaQQ.getInfomation(this);
        if(infos!=null){
            this.etNumber.setText(infos.get("number"));
            this.etPassword.setText(infos.get("password"));
        }
    }

    public void initView(){
        this.etNumber = (EditText)findViewById(R.id.first_text1);
        this.etPassword = (EditText)findViewById(R.id.first_text2);
        this.btnLogin = (Button)findViewById(R.id.first_button1);
        this.btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String number = etNumber.getText().toString().trim();
        String password = etPassword.getText().toString();
        if(TextUtils.isEmpty(number)) {
            Toast.makeText(FirstActivity.this, "没有输入用户名", Toast.LENGTH_SHORT).show();
            return ;
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(FirstActivity.this, "没有输入密码", Toast.LENGTH_SHORT).show();
            return ;
        }

        boolean save = FileSavaQQ.setInfomation(FirstActivity.this,number,password);
        if(save){
            Toast.makeText(FirstActivity.this, "保存成功", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(FirstActivity.this, "保存失败", Toast.LENGTH_SHORT).show();
        }
    }
}
