package bpi.edu.pharmacy.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import bpi.edu.pharmacy.R;
import bpi.edu.pharmacy.adapter.gwcAdapter;
import bpi.edu.pharmacy.adapter.purchaseAdapter;
import bpi.edu.pharmacy.bean.GwcList;
import bpi.edu.pharmacy.bean.drugBean;
import bpi.edu.pharmacy.dao.drugDao;

public class gwcActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gwc);
        ListView listView = findViewById(R.id.gwc_list_view);

        gwcAdapter adapter;
        if(GwcList.list == null || GwcList.list.size() == 0){
            listView.setAdapter(null);
        }else{
            adapter = new gwcAdapter(this,GwcList.list);
            listView.setAdapter(adapter);
        }

        Button btn = findViewById(R.id.gwc_list_back_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}