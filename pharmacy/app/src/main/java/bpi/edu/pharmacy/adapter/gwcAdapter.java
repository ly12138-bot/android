package bpi.edu.pharmacy.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import android.widget.TextView;


import java.util.ArrayList;

import bpi.edu.pharmacy.R;
import bpi.edu.pharmacy.bean.GwcList;
import bpi.edu.pharmacy.bean.drugBean;


public class gwcAdapter extends ArrayAdapter<drugBean> {

    public gwcAdapter(@NonNull Context context, ArrayList<drugBean> list) {
        super(context, R.layout.drug_list,list);
        GwcList.list = list;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.gwc_list,parent,false);
        }

        TextView gwc_name = convertView.findViewById(R.id.gwc_list_name);
        TextView gwc_type = convertView.findViewById(R.id.gwc_list_type);
        TextView gwc_jj = convertView.findViewById(R.id.gwc_list_jj);
        TextView gwc_price = convertView.findViewById(R.id.gwc_list_price);
        TextView gwc_id = convertView.findViewById(R.id.gwc_list_id);
        drugBean drugbean = GwcList.list.get(position);
        gwc_id.setText(drugbean.getD_id());
        gwc_type.setText(drugbean.getD_type());
        gwc_name.setText(drugbean.getD_name());
        gwc_jj.setText(drugbean.getD_jj());
        gwc_price.setText(drugbean.getD_price());
        return convertView;
    }
}


   