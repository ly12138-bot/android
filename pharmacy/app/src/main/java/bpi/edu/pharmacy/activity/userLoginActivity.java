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

public class userLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        EditText username = findViewById(R.id.user_login_username_editText);

        EditText userpwd = findViewById(R.id.user_login_pwd_editText);
        Button login_btn = findViewById(R.id.user_login_btn);
        Button reg_btn = findViewById(R.id.user_register_btn);

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(username.getText().toString() == "" || userpwd.getText().toString() == ""){
                    Toast.makeText(userLoginActivity.this,"请输入用户名或密码",Toast.LENGTH_SHORT).show();
                }else{
                    userBean user = UserDao.getUserById(username.getText().toString(),userpwd.getText().toString());
                    if(user == null){
                        Toast.makeText(userLoginActivity.this,"用户名或密码输入错误",Toast.LENGTH_SHORT).show();
                    }else{
                        Intent intent = new Intent(userLoginActivity.this,userPurchaseActivity.class);
                        startActivity(intent);
                    }

                }
            }
        });

        reg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(userLoginActivity.this,userRegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}