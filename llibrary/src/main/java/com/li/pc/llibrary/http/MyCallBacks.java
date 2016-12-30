package com.li.pc.llibrary.http;

import android.util.Log;

import org.xutils.common.Callback;
import org.xutils.ex.HttpException;

/**
 * 
 * @tags  :网络请求回调
 * @author: moshangpiaoxu
 * @data  : 2016-1-4
 * @time  : 下午5:54:33
 */
public class MyCallBacks implements Callback.CommonCallback<String> {

	private String result = null;
	private boolean hasError = false;
	@Override
	public void onCancelled(CancelledException arg0) {
		// TODO Auto-generated method stub
		Log.i("网络请求", "取消");
	}

	@Override
	public void onError(Throwable ex, boolean arg1) {
		Log.i("网络请求", "失败");// TODO Auto-generated method stub
		Log.i("网络请求", "失败"+ex);// TODO Auto-generated method stub
		hasError = true;
		if (ex instanceof HttpException) { // 网络错误
			HttpException httpEx = (HttpException) ex;
			int responseCode = httpEx.getCode();
			String responseMsg = httpEx.getMessage();
			String errorResult = httpEx.getResult();
			// ...
		} else { // 其他错误
			// ...
		}
	}

	@Override
	public void onFinished() {
		// TODO Auto-generated method stub
		this.result = result;
		if (!hasError && result != null) {
			Log.i("网络请求", "完成");
		}
	}
	@Override
	public void onSuccess(String result) {
		// TODO Auto-generated method stub
		this.result = result;
		Log.i("网络请求", "成功");
	}


}
