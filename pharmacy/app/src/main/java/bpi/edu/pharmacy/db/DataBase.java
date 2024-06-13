package bpi.edu.pharmacy.db;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import bpi.edu.pharmacy.bean.drugBean;
import bpi.edu.pharmacy.bean.userBean;
import bpi.edu.pharmacy.dao.UserDao;
import bpi.edu.pharmacy.dao.drugDao;


public class DataBase extends SQLiteOpenHelper {

    //数据库名称
    private static final String DB_NAME = "pharmacy.db";

    //通过db来操作数据库
    public static SQLiteDatabase db = null;

    private static final int VERSION = 4;//数据库的版本

    private Context context;



    public DataBase(Context context){
        super(context,DB_NAME,null,VERSION,null);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //取消外键
        db.execSQL("PRAGMA foreign_keys = false");

        //创建用户表
        db.execSQL("drop table if exists user");//如果存在用户表则删除
        //用户ID，密码，店名，描述，类型，图片
        db.execSQL("create table user(userName varchar(20) primary key," +
                "userPassword varchar(20)," +
                "userSex varchar(20)," +
                "userPhone varchar(20)," +
                "userAddress varchar(20)," +
                "userPow varchar(20))");

        UserDao.addUser(db,new userBean("root","123","12345678910","北京","男","1"));


        //创建药品表
        db.execSQL("drop table if exists drug");//如果存在用户表则删除
        //药品编号 药品名称 药品价格 药品简介
        db.execSQL("create table drug(d_id varchar(20) primary key," +
                "d_name varchar(20)," +
                "d_type varchar(20)," +
                "d_price varchar(20)," +
                "d_introduce varchar(20))");

        db.execSQL("PRAGMA foreign_keys = true");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        onCreate(sqLiteDatabase);
    }

}