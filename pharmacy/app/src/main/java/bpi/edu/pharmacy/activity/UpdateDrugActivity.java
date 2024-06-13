package bpi.edu.pharmacy.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import bpi.edu.pharmacy.R;
import bpi.edu.pharmacy.dao.drugDao;

public class UpdateDrugActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_drug);
        String id_update = getIntent().getStringExtra("id");
        EditText id = findViewById(R.id.drug_update_id_edittext);
        EditText name = findViewById(R.id.drug_update_name_edittext);
        EditText price = findViewById(R.id.drug_update_price_edittext);
        EditText type = findViewById(R.id.drug_update_type_edittext);
        EditText jj = findViewById(R.id.drug_update_jj_edittext);
        Button update_btn = findViewById(R.id.drug_update_btn);
        Button back_btn = findViewById(R.id.drug_update_back_btn);
        id.setText(id_update);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UpdateDrugActivity.this,rootManagementActivity.class);
                startActivity(intent);
            }
        });
        update_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long result = drugDao.updateDrug(name.getText().toString(),type.getText().toString(),price.getText().toString(),jj.getText().toString(),id.getText().toString());
                if(result > 0){
                    Toast.makeText(UpdateDrugActivity.this,"修改成功",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(UpdateDrugActivity.this,rootManagementActivity.class);
                    startActivity(intent);
                }
            }
        });


    }
}