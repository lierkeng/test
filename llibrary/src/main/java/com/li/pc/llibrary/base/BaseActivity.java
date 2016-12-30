package com.li.pc.llibrary.base;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.li.pc.llibrary.utils.UtilsActivityCollector;
import com.zhy.autolayout.AutoLayoutActivity;

import org.xutils.common.util.LogUtil;
import org.xutils.x;

/**
 * 默认使用的高度是设备的可用高度，也就是不包括状态栏和底部的操作栏的，如果你希望拿设备的物理高度进行百分比化：

 可以在Application的onCreate方法中进行设置:

 public class UseDeviceSizeApplication extends Application
 {
 @Override
 public void onCreate()
 {
 super.onCreate();
 AutoLayoutConifg.getInstance().useDeviceSize();
 }
 }
 */
public abstract class BaseActivity extends AutoLayoutActivity {
    /** Notification管理 */
    public NotificationManager mNotificationManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        UtilsActivityCollector.addActivity(this);
        initService();
    }
    public final <E extends View> E getView(int id) {
        try {
            return (E) findViewById(id);
        } catch (ClassCastException ex) {
            LogUtil.e("==========================="+"不能将视图投射到具体的类.", ex);
            throw ex;
        }
    }
    /**
     * 关闭所有加载过的activity，即为退出程序
     */
    public void fishesAll() {
        UtilsActivityCollector.finishAll();
    }

    /**
     * 吐司
     *
     * @param text
     */
    public void ShowToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        UtilsActivityCollector.removeActivity(this);
    }
    /**
     * 初始化要用到的系统服务
     */
    private void initService() {
        mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }

    /**
     * 清除当前创建的通知栏
     */
    public void clearNotify(int notifyId){
        mNotificationManager.cancel(notifyId);//删除一个特定的通知ID对应的通知
//		mNotification.cancel(getResources().getString(R.string.app_name));
    }

    /**
     * 清除所有通知栏
     * */
    public void clearAllNotify() {
        mNotificationManager.cancelAll();// 删除你发的所有通知
    }

    /**
     * @获取默认的pendingIntent,为了防止2.3及以下版本报错
     * @flags属性:
     * 在顶部常驻:Notification.FLAG_ONGOING_EVENT
     * 点击去除： Notification.FLAG_AUTO_CANCEL
     */
    public PendingIntent getDefalutIntent(int flags){
        PendingIntent pendingIntent= PendingIntent.getActivity(this, 1, new Intent(), flags);
        return pendingIntent;
    }
}
