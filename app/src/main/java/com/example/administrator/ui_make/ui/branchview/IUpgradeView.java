package com.example.administrator.ui_make.ui.branchview;

import com.example.administrator.ui_make.ui.branchview.viewgroup.LeafViewGroup.LeafOnClickListener;

/**
 * Created by raise.yang on 18/05/31.
 */

public interface IUpgradeView {



    /**
     * 设置一个tag标记
     *
     * @return
     */
    void setTag(Object obj);

    Object getTag();
    /**
     * 设置显示文本
     */
    IUpgradeView setText(String str);

    /**
     * 设置进度
     *
     * @param i range[0,100]
     */
    IUpgradeView setProgress(int i);

    int getProgress();

    /**
     * 设置已经完成
     *
     * @return
     */
    IUpgradeView setFinished();

    /**
     * 设置初始状态
     *
     * @return
     */
    IUpgradeView setIdle();


    /**
     * 设置监听
     * @param listener
     */
    IUpgradeView setLeafListener(LeafOnClickListener listener);


    /*
    *
     */
    void setState(int state);
}