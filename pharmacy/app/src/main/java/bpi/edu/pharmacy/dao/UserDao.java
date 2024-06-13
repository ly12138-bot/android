package bpi.edu.pharmacy.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import bpi.edu.pharmacy.bean.userBean;
import bpi.edu.pharmacy.db.DataBase;

public class UserDao {
    public static SQLiteDatabase db = DataBase.db;

    //注册用户
    public static long addUser(userBean user){
        ContentValues values = new ContentValues();
        values.put("userName",user.getUserName());
        values.put("userPassword",user.getUserPassword());
        values.put("userSex",user.getUserSex());
        values.put("userPhone",user.getUserPhone());
        values.put("userAddress",user.getUserAddress());
        values.put("userPow",user.getUserPow());
        long row = db.insert("user",null,values);
        return row;
    }
    //管理员
    public static long addUser(SQLiteDatabase db,userBean user){
        ContentValues values = new ContentValues();
        values.put("userName",user.getUserName());
        values.put("userPassword",user.getUserPassword());
        values.put("userSex",user.getUserSex());
        values.put("userPhone",user.getUserPhone());
        values.put("userAddress",user.getUserAddress());
        values.put("userPow",user.getUserPow());
        long row = db.insert("user",null,values);
        return row;
    }

    //登录验证
    public static userBean getUserById(String id,String pwd){
        String sql = "select * from user where userName=? and userPassword=?";
        String values[] = {id,pwd};
        Cursor res= db.rawQuery(sql,values);
        while(res.moveToNext()){
            String name = res.getString(0);
            String password = res.getString(1);
            String sex = res.getString(2);
            String phone = res.getString(3);
            String address = res.getString(4);
            String pow = res.getString(5);

            userBean user = new userBean(name,password,sex,phone,address,pow);
            return user;

        }
        return null;
    }


}
