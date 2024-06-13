package bpi.edu.pharmacy.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import bpi.edu.pharmacy.R;
import bpi.edu.pharmacy.activity.addDrugActivity;
import bpi.edu.pharmacy.activity.rootManagementActivity;
import bpi.edu.pharmacy.bean.drugBean;
import bpi.edu.pharmacy.dao.drugDao;

public class drugAdapter extends ArrayAdapter<drugBean> {
    private ArrayList<drugBean> list;

    public drugAdapter(@NonNull Context context, ArrayList<drugBean> list) {
        super(context, R.layout.drug_list,list);
        this.list = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.drug_list,parent,false);
        }
        TextView drug_name = convertView.findViewById(R.id.drug_list_name);
        TextView drug_type = convertView.findViewById(R.id.drug_list_type);
        TextView drug_jj = convertView.findViewById(R.id.drug_list_jj);
        TextView drug_price = convertView.findViewById(R.id.drug_list_price);
        TextView drug_id = convertView.findViewById(R.id.drug_list_id);
        drugBean drugBean = list.get(position);
        drug_id.setText(drugBean.getD_id());
        drug_type.setText(drugBean.getD_type());
        drug_name.setText(drugBean.getD_name());
        drug_jj.setText(drugBean.getD_jj());
        drug_price.setText(drugBean.getD_price());
        Button del_btn = convertView.findViewById(R.id.drug_list_delete_btn);
        del_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long result = drugDao.deleteDrug(drug_id.getText().toString());
                if(result > 0){
                    Toast.makeText(getContext(),"删除成功",Toast.LENGTH_SHORT).show();
                    remove(getItem(position));
                    notifyDataSetChanged();
                }
            }
        });
        return convertView;
    }
}
