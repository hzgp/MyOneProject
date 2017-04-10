package com.zjb.main;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends Activity {
    int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.synctest_main);
    }
  /*  */

    /**
     * @param view
     *//*
    public  void click(View view){
        final SyncTest rs = new SyncTest();

        new Thread() {
            public void run() {
                rs.a();
            }
        }.start();

        new Thread() {
            public void run() {
                rs.b();
            }
        }.start();rs

        rs.c();
    }*/
    public void click(View view) {

        new Thread() {
            public void run() {
                for (; i <1; i++) {
                    TestDao.insert("a", i, MainActivity.this);
                }
            }
        }.start();

        new Thread() {
            public void run() {
                TestDao.quarea("b", i, MainActivity.this,5);
            }
        }.start();
        new Thread() {
            public void run() {
                TestDao.quarea("C", i, MainActivity.this,5);
            }
        }.start();

    }

}
