package com.zjb.main;

import android.util.Log;

import java.util.concurrent.TimeUnit;

/**
 * Created by DiLin on 2017/4/5.
 */

public class SyncTest {
    public Object lock=new Object();
    public void a(){
        Log.i("TAG",Thread.currentThread().getName()
                + ":not synchronized in a()");
        synchronized (lock) {
            for (int i = 0; i < 5; i++) {
                Log.i("TAG",Thread.currentThread().getName()
                        + ":synchronized in a()");
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void b(){
        Log.i("TAG",Thread.currentThread().getName()
                + ":not synchronized in b()");
        synchronized (lock) {
            for (int i = 0; i < 5; i++) {
                Log.i("TAG",Thread.currentThread().getName()
                        + ":synchronized in b()");
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void c(){
        Log.i("TAG",Thread.currentThread().getName()
                + ":not synchronized in c()");
        synchronized (lock) {
            for (int i = 0; i < 5; i++) {
                Log.i("TAG",Thread.currentThread().getName()
                        + ":synchronized in c()");
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
