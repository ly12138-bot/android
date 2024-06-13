package bpi.edu.pharmacy.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import bpi.edu.pharmacy.MainActivity;
import bpi.edu.pharmacy.R;
import bpi.edu.pharmacy.adapter.drugAdapter;
import bpi.edu.pharmacy.bean.drugBean;
import bpi.edu.pharmacy.dao.drugDao;

public class rootManagementActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_root_management);

        ListView drug_list_view = this.findViewById(R.id.root_management_list);
        ArrayList<drugBean> list = drugDao.getAllDrug();
        drugAdapter adapter;
        if(list == null || list.size() == 0){
            drug_list_view.setAdapter(null);
        }else{
            adapter = new drugAdapter(this,list);
            drug_list_view.setAdapter(adapter);
        }

        drug_list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView id = view.findViewById(R.id.drug_list_id);
                Intent intent = new Intent(rootManagementActivity.this,UpdateDrugActivity.class);
                intent.putExtra("id",id.getText().toString());
                startActivity(intent);
            }
        });





        Button add_btn = findViewById(R.id.add_drug_btn);
        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(rootManagementActivity.this,addDrugActivity.class);
                startActivity(intent);
            }
        });

        Button back = findViewById(R.id.add_drug_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(rootManagementActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

}