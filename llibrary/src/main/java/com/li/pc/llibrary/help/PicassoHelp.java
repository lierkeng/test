package com.li.pc.llibrary.help;

import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import org.xutils.x;

/**
 * author   ：mo
 * data     ：2016/12/7
 * time     ：13:44
 * function :
 */

public class PicassoHelp {
    public static void loadPicasso(String imageUrl, ImageView imageView){
        Picasso.with(x.app()).load(imageUrl).into(imageView);
    }
}
