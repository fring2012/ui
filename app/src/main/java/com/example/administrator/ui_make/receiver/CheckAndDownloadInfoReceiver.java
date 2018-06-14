package com.example.administrator.ui_make.receiver;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Trace;
import android.util.Log;

public class CheckAndDownloadInfoReceiver extends BroadcastReceiver {
    private static final String TAG = "CheckAndDownloadInfoReceiver";
    @SuppressLint("LongLogTag")
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG,"onReceive(Context context, Intent intent)");
        int state = intent.getIntExtra("state",0);
        switch (state) {
            case 0:
                int resultState = intent.getIntExtra("resultState", 0);
                if (resultState == 1000) {
                    String versionName = intent.getStringExtra("versionName");
                    String content = intent.getStringExtra("content");
                    Log.d(TAG, "resultState:" + resultState + "versionName:" + versionName + "content:" + content);
                } else {
                    String error = intent.getStringExtra("error");
                    Log.d(TAG, "resultState:" + resultState + "error:" + error);
                }
                break;
            case 1:
                int progress =intent.getIntExtra("progress",0);
                Log.d(TAG, "progress:" + progress);
                break;
            case 3:
                String policyException = intent.getStringExtra("exception");
                Log.d(TAG, "exception:" + policyException);
        }
    }
}
