package com.li.pc.llibrary.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.xutils.x;


/**
 * Created by Mr.wang
 * Date 2016/7/6
 * E-mail 1678173987@qq.com
 * Describe 所有fragment的父类
 */
public class BaseFragment extends Fragment {
    private boolean injected = false;//注入

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        injected = true;
        return x.view().inject(this, inflater, container);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);//判断如果没有注入则进行初始注入
        if (!injected) {
            x.view().inject(this, this.getView());
        }
    }


}
