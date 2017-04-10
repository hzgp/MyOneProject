package com.zjb.main;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by DiLin on 2017/4/5.
 */

public class MyDBHelper extends SQLiteOpenHelper {
    private static  final String VERSION_NAME="v1.0";
    private static  final int VERSION_NUM=1;
    public MyDBHelper(Context context) {
        super(context, VERSION_NAME, null, VERSION_NUM);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
       sqLiteDatabase.execSQL("create table if not exists mystable(id_ intger ,name varchar(5))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
