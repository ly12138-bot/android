package bpi.edu.pharmacy.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import bpi.edu.pharmacy.R;
import bpi.edu.pharmacy.bean.userBean;
import bpi.edu.pharmacy.dao.UserDao;

public class userRegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register);
        EditText username = findViewById(R.id.user_register_name_edittext);
        EditText password = findViewById(R.id.user_register_password_edittext);
        EditText repassword = findViewById(R.id.user_register_repassword_edittext);
        EditText phone = findViewById(R.id.user_register_phone_edittext);
        EditText address = findViewById(R.id.user_register_address_edittext);
        EditText sex = findViewById(R.id.user_register_sex_edittext);
        Button reg_btn = findViewById(R.id.register_btn);
        Button back_btn = findViewById(R.id.register_back_btn);
        reg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usernametext = username.getText().toString();
                String passwordtext = password.getText().toString();
                String repasswordtext = repassword.getText().toString();
                String phonetext = phone.getText().toString();
                String addresstext = address.getText().toString();
                String sextext = sex.getText().toString();
                if(usernametext.isEmpty()){
                    Toast.makeText(userRegisterActivity.this,"请输入用户名",Toast.LENGTH_SHORT).show();
                }else if (passwordtext.isEmpty()){
                    Toast.makeText(userRegisterActivity.this,"请输入密码",Toast.LENGTH_SHORT).show();
                }else if(!passwordtext.equals(repasswordtext)){
                    Toast.makeText(userRegisterActivity.this,"两次密码不一致",Toast.LENGTH_SHORT).show();
                }else if (phonetext.isEmpty()){
                    Toast.makeText(userRegisterActivity.this,"请输入手机号",Toast.LENGTH_SHORT).show();
                }else if (addresstext.isEmpty()){
                    Toast.makeText(userRegisterActivity.this,"请输入地址",Toast.LENGTH_SHORT).show();
                }else if (sextext.isEmpty()){
                    Toast.makeText(userRegisterActivity.this,"请输入性别",Toast.LENGTH_SHORT).show();
                }else {
                    userBean user = new userBean(usernametext, passwordtext, phonetext, addresstext, sextext, "0");
                    long result = UserDao.addUser(user);
                    if(result > 0){
                        Toast.makeText(userRegisterActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }
            }
        });

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}