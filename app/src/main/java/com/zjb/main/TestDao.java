package com.zjb.main;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Created by DiLin on 2017/4/5.
 */

public class TestDao {
    private static SQLiteDatabase db;
    private static Object locker = new Object();

    public TestDao(Context context) {
        SQLiteOpenHelper helper = new MyDBHelper(context);
        db = helper.getWritableDatabase();
    }

    public static synchronized void insert(String lable, int a, Context context) {
        try {
            if (db == null) {
                SQLiteOpenHelper helper = new MyDBHelper(context);
                db = helper.getWritableDatabase();
            }
            ContentValues values = new ContentValues();
            values.put("id_", 1);
            values.put("name", "" + a);
            Log.i("TAG", Thread.currentThread().getName() + " "
                    + lable + "-->inser  " + a);
            db.insert("mystable", null, values);
        } catch (Exception ex) {

        } finally {
            if (db != null) {
                db.close();
                db = null;
            }

        }

    }

    public static ArrayList<String> quarea(String lable, int a, Context context) {
        ArrayList<String> data = new ArrayList<String>();
        Cursor cursor = null;
        try {
            if (db == null) {
                SQLiteOpenHelper helper = new MyDBHelper(context);
                db = helper.getReadableDatabase();
            }

            Log.i("TAG", Thread.currentThread().getName() + " "
                    + lable + "-->" + a);
            cursor = db.rawQuery("select * from mystable", null);

            if (cursor != null) {
                synchronized (locker) {
                    while (cursor.moveToNext()) {
                        TimeUnit.SECONDS.sleep(1);
                        Log.i("TAG", Thread.currentThread().getName() + " "
                                + lable + "-->quarea  " + a + cursor.getString(cursor.getColumnIndex("name")));
                    }
                }
            }
        } catch (Exception ex) {

        } finally {
            if (cursor != null) {
                cursor.close();
            }
            if (db != null) {
                db.close();
                db = null;
            }

        }
        return data;
    }

    public static  ArrayList<String> quarea(String lable, int a, Context context, int count) {
        Log.i("TAG", Thread.currentThread().getName() + " "
                + lable + "-->" + a);
        ArrayList<String> data = new ArrayList<String>();
        Cursor cursor = null;
        synchronized (locker) {
        try {
            if (db == null) {
                SQLiteOpenHelper helper = new MyDBHelper(context);
                db = helper.getReadableDatabase();
            }


            cursor = db.rawQuery("select * from mystable", null);
            int i=0;
            if (cursor != null) {

                    while (cursor.moveToNext()&&i<count) {
                        i++;
                        TimeUnit.SECONDS.sleep(1);
                        Log.i("TAG", Thread.currentThread().getName() + " "
                                + lable + "-->quarea  " + a + cursor.getString(cursor.getColumnIndex("name")));
                    }

            }else{
                Log.i("TAG","NULL");
            }
        } catch (Exception ex) {
            Log.i("TAG","Exception-->"+ex.getMessage());

        } finally {
            if (cursor != null) {
                cursor.close();
            }
            if (db != null) {
                db.close();
                db = null;
            }

        }
        }
        return data;
    }

}
