package bpi.edu.pharmacy.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import bpi.edu.pharmacy.bean.drugBean;
import bpi.edu.pharmacy.bean.userBean;
import bpi.edu.pharmacy.db.DataBase;

public class drugDao {
    public static SQLiteDatabase db = DataBase.db;
    //获取所有药品信息
    public static ArrayList<drugBean> getAllDrug(){
        Cursor r = db.rawQuery("select * from drug",null);
        ArrayList<drugBean> list = new ArrayList<>();
        while(r.moveToNext()){
            String id = r.getString(0);
            String name = r.getString(1);
            String type = r.getString(2);
            String price = r.getString(3);
            String jj = r.getString(4);
            drugBean drugBean = new drugBean(id,name,type,price,jj);
            list.add(drugBean);
        }
        return list;
    }

    //添加药品
    public static long addDrug(drugBean drug){
        ContentValues values = new ContentValues();
        values.put("d_id",drug.getD_id());
        values.put("d_name",drug.getD_name());
        values.put("d_type",drug.getD_type());
        values.put("d_price",drug.getD_price());
        values.put("d_introduce",drug.getD_jj());
        long row = db.insert("drug",null,values);
        return row;
    }

    public static long addDrug(SQLiteDatabase db,drugBean drug){
        ContentValues values = new ContentValues();
        values.put("d_id",drug.getD_id());
        values.put("d_name",drug.getD_name());
        values.put("d_type",drug.getD_type());
        values.put("d_price",drug.getD_price());
        values.put("d_introduce",drug.getD_jj());
        long row = db.insert("drug",null,values);
        return row;
    }

    public static long deleteDrug(String id){
        try{
            db.execSQL("delete from drug where d_id=?",new String[]{id});
            return 1;
        }catch (Exception e){
            return 0;
        }
    }
    public static long updateDrug(String ...data){

        ContentValues values = new ContentValues();
        values.put("d_name",data[0]);
        values.put("d_type",data[1]);
        values.put("d_price",data[2]);
        values.put("d_introduce",data[3]);
        long rowId = db.update("drug",values,"d_id=?",new String[]{data[4]});
        return rowId;

    }

    public static drugBean getDrugBean(String id){
        String sql = "select * from drug where d_id=?";
        String values[] = {id};
        Cursor res= db.rawQuery(sql,values);
        while(res.moveToNext()){
            String did = res.getString(0);
            String name = res.getString(1);
            String type = res.getString(2);
            String price = res.getString(3);
            String jj = res.getString(4);

            drugBean drugBean = new drugBean(did,name,type,price,jj);
            return drugBean;
        }
        return null;
    }

}
