package com.example.administrator.ui_make.ui.activity;


import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Build.VERSION_CODES;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.util.Log;

import com.example.administrator.ui_make.R;
import com.example.administrator.ui_make.ui.branchview.IUpgradeView;
import com.example.administrator.ui_make.ui.branchview.viewgroup.LeafViewGroup;
import com.example.administrator.ui_make.ui.branchview.viewgroup.LeafViewGroup.LeafOnClickListener;

import java.io.File;

import butterknife.BindView;


public class MainActivity extends BaseActivity {
    private static final String TAG = "MainActivity";
    @BindView(R.id.branch_ecu)
    IUpgradeView branchViewGroup;

    @RequiresApi(api = VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Uri.fromFile(new File(""));

        branchViewGroup.setLeafListener(new LeafOnClickListener(){

;            @Override
            public void checkVersion() {
                Log.d(TAG,"checkVersion() start");
                Intent intent = new Intent();
                setParams(intent);
                intent.setComponent(new ComponentName("com.abupdate.apk_up_receiver",
                        "com.abupdate.apk_up_receiver.broadcast.ApkUpInfoReceiver"));
                intent.setAction("broadcast.ApkUpInfoReceiver");
                intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
                sendBroadcast(intent);
                Log.d(TAG,"checkVersion() end");
            }

            @Override
            public void downloadVersion() {
                branchViewGroup.setState(LeafViewGroup.UPGRADE_VERSION);
                branchViewGroup.setText("下载中");
                branchViewGroup.setProgress(60);
            }

            @Override
            public void rebootUpgrade() {
                branchViewGroup.setState(LeafViewGroup.CHECK_VERSION);
                branchViewGroup.setFinished();
            }
        });
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_main;
    }

    public void setParams(Intent intent){
        String packageName = getApplicationContext().getPackageName();

        intent.putExtra("packageName",packageName);
        intent.putExtra("receiverName", "CheckAndDownloadInfoReceiver");
        intent.putExtra("receiverClass","com.example.administrator.ui_make.receiver.CheckAndDownloadInfoReceiver");
        intent.putExtra("mid","4325");
        intent.putExtra("deviceType","phone");
        intent.putExtra("device","MI3C");
        intent.putExtra("oem","212");
        intent.putExtra("platform","BRCM23550");
        intent.putExtra("productId","1525594277");
        intent.putExtra("productSecret","c380eaa48f0248f9878a14857844d133");
    }

}
