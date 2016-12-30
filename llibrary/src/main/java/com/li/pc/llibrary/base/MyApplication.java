package com.li.pc.llibrary.base;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.multidex.MultiDex;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.li.pc.llibrary.R;
import com.li.pc.llibrary.help.ImageLoaderHelp;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.tencent.bugly.crashreport.CrashReport;
import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

import org.xutils.x;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Mr.wang
 * Date 2016/7/6
 * E-mail 1678173987@qq.com
 * Describe 定义自己的application 用户初始化一些东西
 */
public class MyApplication extends Application {
    private static Context mContext;
    private static Thread mMainThread;
    private static long mMainThreadId;
    private static Looper mMainLooper;
    private static Handler mMainHander;
    private List<AppCompatActivity> mList = new LinkedList<>();

    @Override
    public void onCreate() {
        super.onCreate();

        //初始化xutils
        x.Ext.init(this);
        x.Ext.setDebug(true); // 是否输出debug日志, 开启debug会影响性能.
        //    解决65536
        MultiDex.install(this);
        //应用程序的上下文
        mContext = getApplicationContext();
        //主线程
        mMainThread = Thread.currentThread();
        //主线程Id
        //mMainThreadId=mMainThread.getId();
        mMainThreadId = android.os.Process.myTid();
        mMainLooper = getMainLooper();
        //创建主线程的Handler
        mMainHander = new Handler();

//        initImageLoader();
        ImageLoaderHelp.ImageLoaderCongig();
        Fresco.initialize(this);
        UMShareAPI.get(this);//友盟分享
        initUM();
        initBugly();
    }





    // 添加 AppCompatActivity
    public void addActivity(AppCompatActivity activity) {
        mList.add(activity);
    }

    //关闭每一个list内的AppCompatActivity
    public void exit() {
        try {
            for (AppCompatActivity activity : mList) {
                if (activity != null)
                    activity.finish();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.exit(0);
        }
    }
















    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
    private void initBugly() {
        CrashReport.initCrashReport(getApplicationContext(), "01b3e13b00", false);
//        CrashReport.testJavaCrash();
        CrashReport.initCrashReport(getApplicationContext());
        Context context = getApplicationContext();
// 获取当前包名
        String packageName = context.getPackageName();
// 获取当前进程名
        String processName = getProcessName(android.os.Process.myPid());
// 设置是否为上报进程
        CrashReport.UserStrategy strategy = new CrashReport.UserStrategy(context);
        strategy.setUploadProcess(processName == null || processName.equals(packageName));
// 初始化Bugly
        CrashReport.initCrashReport(context, "01b3e13b00", false, strategy);
// 如果通过“AndroidManifest.xml”来配置APP信息，初始化方法如下
// CrashReport.initCrashReport(context, strategy);
    }
    /**
     * 获取进程号对应的进程名
     *
     * @param pid 进程号
     * @return 进程名
     */
    private static String getProcessName(int pid) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("/proc/" + pid + "/cmdline"));
            String processName = reader.readLine();
            if (!TextUtils.isEmpty(processName)) {
                processName = processName.trim();
            }
            return processName;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return null;
    }
    /**
     * 友盟推送
     */
    private void initUM() {
        PushAgent mPushAgent = PushAgent.getInstance(this);
        //注册推送服务，每次调用register方法都会回调该接口
        mPushAgent.register(new IUmengRegisterCallback() {

            @Override
            public void onSuccess(String deviceToken) {
                //注册成功会返回device token
                Log.i("deviceTokenssssss", deviceToken);
            }

            @Override
            public void onFailure(String s, String s1) {

            }
        });
    }

    {
        PlatformConfig.setWeixin("wxd172f9f6f1f2380f", "1d25229f380092ca1e58b1df008feec7");
//        PlatformConfig.setSinaWeibo("2177800190", "b07594ade08d3d13720a5a8ed7fd9379");
//        Config.REDIRECT_URL = "http://sns.whalecloud.com/sina2/callback";
//        PlatformConfig.setQQZone("1105832548", "51Xa27tBwu7p3p7v");
    }
    public static Context getContext() {
        return mContext;
    }

    public static Thread getMainThread() {
        return mMainThread;
    }

    public static long getMainThreadId() {
        return mMainThreadId;
    }

    public static Looper getMainThreadLooper() {
        return mMainLooper;
    }

    public static Handler getMainHander() {
        return mMainHander;
    }

    private final static void initImageLoader() {
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(mContext)
                .defaultDisplayImageOptions(getDefaultDisplayOption())//显示图片的参数，传入自己配置过得DisplayImageOption对象
                .memoryCache(new LruMemoryCache(50 * 1024 * 1024)) //缓存策略
                .memoryCacheExtraOptions(320, 480) //即保存的每个缓存文件的最大长宽
                .threadPoolSize(8) //线程池内线程的数量，默认是3
                .threadPriority(Thread.NORM_PRIORITY - 2) //当同一个Uri获取不同大小的图片，缓存到内存时，只缓存一个。默认会缓存多个不同的大小的相同图片
                .denyCacheImageMultipleSizesInMemory() //拒绝同一个url缓存多个图片
                .diskCacheSize(50 * 1024 * 1024) //设置磁盘缓存大小 50M
                .diskCacheFileNameGenerator(new Md5FileNameGenerator()) //将保存的时候的URI名称用MD5 加密
                .tasksProcessingOrder(QueueProcessingType.LIFO)//设置图片下载和显示的工作队列排序
                .build();
        ImageLoader.getInstance().init(config);
    }

    private final static DisplayImageOptions getDefaultDisplayOption() {
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .showImageForEmptyUri(R.drawable.a)  // 设置图片Uri为空或是错误的时候显示的图片
                .showImageOnFail(R.drawable.b)     //  设置图片加载或解码过程中发生错误显示的图片
                .cacheInMemory(true) // 设置下载的图片是否缓存在内存中
                .cacheOnDisk(true) // 设置下载的图片是否缓存在SD卡中
                .showImageOnLoading(R.drawable.a)
                .build();
        return options;
    }
}
