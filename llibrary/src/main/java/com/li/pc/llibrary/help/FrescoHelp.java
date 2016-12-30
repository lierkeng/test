package com.li.pc.llibrary.help;

import android.net.Uri;
import android.widget.ImageView;

/**
 * author   ：mo
 * data     ：2016/12/7
 * time     ：14:12
 * function :
 * <p>
 * <com.facebook.drawee.view.SimpleDraweeView
 * android:id="@+id/my_image_view"
 * android:layout_width="20dp"   // 不支持wrap_content 如果要设置宽高比, 需要在Java代码中指定setAspectRatio(1.33f);
 * android:layout_height="20dp"    // 不支持wrap_content
 * fresco:fadeDuration="300"
 * fresco:actualImageScaleType="focusCrop"
 * // 设置图片缩放. 通常使用focusCrop,该属性值会通过算法把人头像放在中间
 * fresco:placeholderImage="@color/wait_color"
 * // 下载成功之前显示的图片
 * fresco:placeholderImageScaleType="fitCenter"
 * <p>
 * fresco:failureImage="@drawable/error"
 * // 加载失败的时候显示的图片
 * fresco:failureImageScaleType="centerInside"
 * fresco:retryImage="@drawable/retrying"
 * // 加载失败,提示用户点击重新加载的图片(会覆盖failureImage的图片)
 * fresco:retryImageScaleType="centerCrop"
 * fresco:progressBarImage="@drawable/progress_bar"// 提示用户正在加载,和加载进度无关
 * fresco:progressBarImageScaleType="centerInside"
 * fresco:progressBarAutoRotateInterval="1000"
 * fresco:backgroundImage="@color/blue"
 * fresco:overlayImage="@drawable/watermark"
 * fresco:pressedStateOverlayImage="@color/red"
 * fresco:roundAsCircle="false"
 * // 是不是设置圆圈
 * fresco:roundedCornerRadius="1dp"
 * // 圆角角度,180的时候会变成圆形图片
 * fresco:roundTopLeft="true"
 * fresco:roundTopRight="false"
 * fresco:roundBottomLeft="false"
 * fresco:roundBottomRight="true"
 * fresco:roundWithOverlayColor="@color/corner_color"
 * fresco:roundingBorderWidth="2dp"
 * fresco:roundingBorderColor="@color/border_color"
 * />
 * <p>
 * 修改图片尺寸
 * Uri uri = "file:///mnt/sdcard/MyApp/myfile.jpg";
 * int width = 50, height = 50;
 * ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri)
 * .setResizeOptions(new ResizeOptions(width, height))
 * .build();
 * PipelineDraweeController controller = Fresco.newDraweeControllerBuilder()
 * .setOldController(mDraweeView.getController())
 * .setImageRequest(request)
 * .build();
 * mSimpleDraweeView.setController(controller);
 * <p>
 * <p>
 * 自动旋转
 * ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri)
 * .setAutoRotateEnabled(true)
 * .build();
 */

public class FrescoHelp {

    public static void loadFresco(String imageUrl, ImageView imageView) {
        Uri uri = Uri.parse(imageUrl);
        imageView.setImageURI(uri);
    }
}
