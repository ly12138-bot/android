package bpi.edu.pharmacy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.CircleIndicator;

import java.util.ArrayList;
import java.util.List;


import bpi.edu.pharmacy.activity.rootLoginActivity;
import bpi.edu.pharmacy.activity.rootManagementActivity;
import bpi.edu.pharmacy.activity.userLoginActivity;
import bpi.edu.pharmacy.activity.userPurchaseActivity;
import bpi.edu.pharmacy.activity.userRegisterActivity;
import bpi.edu.pharmacy.bean.ImageBean;
import bpi.edu.pharmacy.db.DataBase;

public class MainActivity extends AppCompatActivity {
    private Banner banner;
    private List<ImageBean> imageList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DataBase dataBase = new DataBase(MainActivity.this);
        SQLiteDatabase db = dataBase.getWritableDatabase();//获取连接
        dataBase.db = db;

        setContentView(R.layout.activity_main);

        Button user_btn = findViewById(R.id.user);
        Button root_btn = findViewById(R.id.root);

        banner = findViewById(R.id.banner);

        imageList.add(new ImageBean(R.drawable.a,"图片1"));
        imageList.add(new ImageBean(R.drawable.b,"图片2"));
        imageList.add(new ImageBean(R.drawable.c,"图片3"));


        //调试
//        Intent intent = new Intent(MainActivity.this, userPurchaseActivity.class);
//        startActivity(intent);

        banner.setAdapter(new BannerImageAdapter<ImageBean>(imageList){
            @Override
            public void onBindView(BannerImageHolder holder, ImageBean imageList, int position, int size) {
                holder.imageView.setImageResource(imageList.getImg());
            }
        }).addBannerLifecycleObserver(this).setIndicator(new CircleIndicator(this));

        user_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, userLoginActivity.class);
                startActivity(intent);
            }
        });
        root_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, rootLoginActivity.class);
                startActivity(intent);
            }
        });

    }
}