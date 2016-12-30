package com.li.pc.llibrary.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;

import com.li.pc.llibrary.R;


/**
 * Created by pc on 2016/8/23.
 * pop帮助类
 */
public class PopHelp {
    /**
     * 获取pop布局View
     *
     * @param context
     * @param layoutId
     * @return
     */
    public static View getView(Context context, int layoutId) {
        View v = ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(layoutId, null);
        return v;
    }

    /**
     * 初始化pop窗口，默认一些设置
     *
     * @param context
     * @param v
     * @param atLocationId
     * @return
     */
    public static PopupWindow initPop(Activity context, View v, int atLocationId) {
        PopupWindow window = new PopupWindow(v, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setFocusable(true); // 设置popWindow弹出窗体可点击，这句话必须添加，并且是true
        window.setBackgroundDrawable(new ColorDrawable(0xb000000)); // 实例化一个ColorDrawable颜色为半透明
        window.setAnimationStyle(R.style.mypopwindow_anim_style); // 设置popWindow的显示和消失动画
        window.showAtLocation(context.findViewById(atLocationId), Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0); // 在底部显示
        return window;
    }
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////例子////////////////////////////////////////////////////////////////////////////////////////////////////////
//private void createPop() {
//    View view = PopHelp.getView(this, R.layout.pop_my_collection);
//    PopupWindow win = PopHelp.initPop(this, view, R.id.tv_title);
//    TextView tv_my_collection_detaile = (TextView) view.findViewById(R.id.tv_my_collection_detaile);
//    ImageView iv_my_collection_quan = (ImageView) view.findViewById(R.id.iv_my_collection_quan);
//    //设置按钮监听
//    tv_my_collection_detaile.setOnClickListener(click);
//    iv_my_collection_quan.setOnClickListener(click);
//}
//
//    private View.OnClickListener click = new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            switch (view.getId()) {
//                case R.id.iv_my_collection_quan://全选
//                    showToast("全选");
//                    break;
//                case R.id.tv_my_collection_detaile://删除
//                    showToast("全部删除");
//                    break;
//            }
//        }
//    };