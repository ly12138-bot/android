package bpi.edu.pharmacy.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import bpi.edu.pharmacy.R;
import bpi.edu.pharmacy.bean.drugBean;
import bpi.edu.pharmacy.dao.drugDao;

public class addDrugActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_drug);
        EditText id = findViewById(R.id.drug_add_id_edittext);
        EditText name = findViewById(R.id.drug_add_name_edittext);
        EditText price = findViewById(R.id.drug_add_price_edittext);
        EditText type = findViewById(R.id.drug_add_type_edittext);
        EditText jj = findViewById(R.id.drug_add_jj_edittext);
        Button add_btn = findViewById(R.id.drug_add_btn);
        Button back_btn = findViewById(R.id.drug_add_back_btn);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(addDrugActivity.this,rootManagementActivity.class);
                startActivity(intent);
            }
        });
        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drugBean drugBean = new drugBean(id.getText().toString(),name.getText().toString(),type.getText().toString(),price.getText().toString(),jj.getText().toString());
                long result = drugDao.addDrug(drugBean);
                if(result > 0){
                    Toast.makeText(addDrugActivity.this,"添加成功",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(addDrugActivity.this,rootManagementActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(addDrugActivity.this,"id重复",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}