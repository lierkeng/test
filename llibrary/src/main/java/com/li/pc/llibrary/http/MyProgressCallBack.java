package com.li.pc.llibrary.http;

import org.xutils.common.Callback;
import org.xutils.common.util.LogUtil;


/**
 * 
 * @tags  : 带进度条的回调
 * @author: moshangpiaoxu
 * @data  : 2016-1-4
 * @time  : 下午5:54:56
 */
public class MyProgressCallBack<T> implements Callback.ProgressCallback<T>{

	@Override
	public void onCancelled(CancelledException arg0) {
		// TODO Auto-generated method stub
		LogUtil.i("=================取消==============================");
	}

	@Override
	public void onError(Throwable arg0, boolean arg1) {
		// TODO Auto-generated method stub
		LogUtil.i("=================错误==============================");
	}

	@Override
	public void onFinished() {
		// TODO Auto-generated method stub
		LogUtil.i("=================结束==============================");
	}

	@Override
	public void onSuccess(T  arg0) {
		// TODO Auto-generated method stub
		LogUtil.i("=================成功==============================");
	}

	@Override
	public void onLoading(long arg0, long arg1, boolean arg2) {
		// TODO Auto-generated method stub
		LogUtil.i("=================正在加载==============================");
	}

	@Override
	public void onStarted() {
		// TODO Auto-generated method stub
		LogUtil.i("=================开始加载==============================");
	}

	@Override
	public void onWaiting() {
		// TODO Auto-generated method stub
		LogUtil.i("=================等待==============================");
	}

}
