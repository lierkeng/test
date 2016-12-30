package com.li.pc.llibrary.http;

import android.os.Handler;
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONObject;
import org.xutils.common.util.LogUtil;
import org.xutils.http.app.ResponseParser;
import org.xutils.http.request.UriRequest;
import org.xutils.x;

import java.lang.reflect.Type;

/**
 * Created by Mr.wang
 * Date 2016/7/11  18:08
 * E-mail 1678173987@qq.com
 * Describe 使用gson进行解析json数据
 */
public class MyJsonToResponse implements ResponseParser {

    Handler handler = new Handler();

    @Override
    public void checkResponse(UriRequest request) throws Throwable {
        LogUtil.i(request+"");
    }

    @Override
    public Object parse(Type resultType, Class<?> resultClass, final String result) throws Throwable {
        LogUtil.i("result"+result);
//        //进行判断是否为code 是否为0,进行json解析，
//        JSONObject jsonObject=new JSONObject(result);
//        String code=jsonObject.getString("code");
//        if(code.equals("0")){
            return new Gson().fromJson(result,resultType);
//        }else{
//            //即为code!=0的时候
//            JSONObject data=jsonObject.getJSONObject("data");
//            final String des = data.getString("des");
//            //打印des
//            handler.post(new Runnable() {
//                @Override
//                public void run() {
//                    Toast.makeText(x.app(), des, Toast.LENGTH_SHORT).show();
//                }
//            });
//            return null;
//        }

    }
}
