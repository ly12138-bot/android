package bpi.edu.pharmacy.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import bpi.edu.pharmacy.MainActivity;
import bpi.edu.pharmacy.R;
import bpi.edu.pharmacy.adapter.drugAdapter;
import bpi.edu.pharmacy.adapter.purchaseAdapter;
import bpi.edu.pharmacy.bean.drugBean;
import bpi.edu.pharmacy.dao.drugDao;

public class userPurchaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_purchase);
        ListView listView = findViewById(R.id.user_purchase_list);
        ArrayList<drugBean> list = drugDao.getAllDrug();
        purchaseAdapter adapter;
        if(list == null || list.size() == 0){
            listView.setAdapter(null);
        }else{
            adapter = new purchaseAdapter(this,list);
            listView.setAdapter(adapter);
        }

        Button ck_btn = findViewById(R.id.ck_drug_btn);
        ck_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(userPurchaseActivity.this,gwcActivity.class);
                startActivity(intent);
            }
        });

        Button back_btn = findViewById(R.id.back_drug_btn);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(userPurchaseActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });



    }
}