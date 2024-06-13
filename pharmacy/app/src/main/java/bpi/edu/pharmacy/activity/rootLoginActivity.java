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

public class rootLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_root_login);
        EditText name = findViewById(R.id.root_username_editText);
        EditText pwd = findViewById(R.id.root_pwd_editText);
        Button login_btn = findViewById(R.id.root_login_btn);
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(name.getText().toString() == "" || pwd.getText().toString() == ""){
                    Toast.makeText(rootLoginActivity.this,"请输入用户名或密码",Toast.LENGTH_SHORT).show();
                }else{
                    userBean user = UserDao.getUserById(name.getText().toString(),pwd.getText().toString());
                    if(user == null && user.getUserPow().equals("0")){
                        Toast.makeText(rootLoginActivity.this,"用户名或密码输入错误",Toast.LENGTH_SHORT).show();
                    }else{
                        Intent intent = new Intent(rootLoginActivity.this,rootManagementActivity.class);
                        startActivity(intent);
                    }

                }
            }
        });

    }
}