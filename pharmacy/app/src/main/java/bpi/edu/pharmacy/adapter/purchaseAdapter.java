package bpi.edu.pharmacy.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import bpi.edu.pharmacy.MainActivity;
import bpi.edu.pharmacy.R;
import bpi.edu.pharmacy.activity.userLoginActivity;
import bpi.edu.pharmacy.bean.GwcList;
import bpi.edu.pharmacy.bean.drugBean;
import bpi.edu.pharmacy.dao.drugDao;
import bpi.edu.pharmacy.tts.tts;

public class purchaseAdapter extends ArrayAdapter<drugBean> {
    private ArrayList<drugBean> list;


    public purchaseAdapter(@NonNull Context context, ArrayList<drugBean> list) {
        super(context, R.layout.purchase_list,list);
        this.list = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.purchase_list,parent,false);
        }
        TextView drug_name = convertView.findViewById(R.id.purchase_list_name);
        TextView drug_type = convertView.findViewById(R.id.purchase_list_type);
        TextView drug_jj = convertView.findViewById(R.id.purchase_list_jj);
        TextView drug_price = convertView.findViewById(R.id.purchase_list_price);
        TextView drug_id = convertView.findViewById(R.id.purchase_list_id);
        drugBean drugBean = list.get(position);
        drug_id.setText(drugBean.getD_id());
        drug_type.setText(drugBean.getD_type());
        drug_name.setText(drugBean.getD_name());
        drug_jj.setText(drugBean.getD_jj());
        drug_price.setText(drugBean.getD_price());
        Button add_btn = convertView.findViewById(R.id.purchase_list_add_btn);
        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GwcList.list.add(drugDao.getDrugBean(drug_id.getText().toString()));
                Toast.makeText(getContext(),"添加成功",Toast.LENGTH_SHORT).show();
            }
        });

        tts t = new tts(getContext());
        ImageButton img = convertView.findViewById(R.id.bf);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textToSpeak = "药名" + drug_name.getText().toString() + "药类型" + drug_type.getText().toString() + "简介" + drug_jj.getText().toString() + "价格" + drug_price.getText().toString(); // 指定的文字
                t.speak(textToSpeak);
            }
        });


        return convertView;
    }
}
