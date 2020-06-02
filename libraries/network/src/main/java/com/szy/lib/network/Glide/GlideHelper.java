package com.szy.lib.network.Glide;


import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.szy.lib.network.R;

/**
 * Created by bingju on 2017/1/11.
 */
public class GlideHelper {
    /**
     * 初始化Glide三方库
     *
     * @param application
     */
    public static void initGlide(Application application) {
        //因为Glide默认不支持https图片的加载，所以对源码进行了修改。glide的初始化放到了清单文件中
//        Glide.get(application).register(GlideUrl.class, InputStream.class,
//                new OkHttpUrlLoader.Factory(new OkHttpClient()));
    }


    public static void showCircleCrop(Context context, String url, ImageView img) {
        Glide.with(context)
                .load(url)
                .apply(new RequestOptions()
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .placeholder(R.mipmap.icon_load_photo_loading)
                        .error(R.mipmap.icon_load_photo_error)
                        .bitmapTransform(new CircleCrop()))
                .into(img);
    }

    public static void showCircleCrop(Context context, String url, ImageView img, int placeholder_icon) {
        Glide.with(context)
                .load(url)
                .apply(new RequestOptions()
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .placeholder(placeholder_icon)
                        .error(R.mipmap.icon_load_photo_error)
                        .bitmapTransform(new CircleCrop()))
                .into(img);
    }

    /**
     * 加载网络图片并传递给imageview
     *
     * @param context  上下文对象
     * @param imageUrl 图片的网络地址
     * @param img      imageview对象
     */
    public static void showImage(Context context, String imageUrl, ImageView img) {
        if (imageUrl != null && imageUrl.length() > 0) {
            Glide.with(context)
                    .load(imageUrl)
                    .apply(new RequestOptions()
                            .diskCacheStrategy(DiskCacheStrategy.ALL)
                            .placeholder(R.mipmap.icon_load_photo_loading)
                            .error(R.mipmap.icon_load_photo_error))
                    .into(img);
        }

    }

    public static void showImage(Context context, String imageUrl, ImageView img, int error_icon) {
        if (imageUrl != null && imageUrl.length() > 0) {
            Glide.with(context)
                    .load(imageUrl)
                    .apply(new RequestOptions()
                            .diskCacheStrategy(DiskCacheStrategy.ALL)
                            .error(error_icon))
                    .into(img);
        }

    }


    /**
     * 加载图片并进行裁剪为圆形
     *
     * @param context
     * @param urle
     * @param img
     * @param placeholder_icon
     */
    public static void showRoundedCorners(Context context, String url, ImageView img, int placeholder_icon) {
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(placeholder_icon)
                .error(placeholder_icon);
        requestOptions.transform(new GlideRoundTransform(context, 1));//处理CenterCrop的情况 解决方法
        Glide.with(context)
                .load(url)
                .apply(requestOptions)
                .into(img);
    }

    /**
     * 加载网络图片并传递给imageview
     *
     * @param context          上下文对象
     * @param imageUrl         图片的网络地址
     * @param img              imageview对象
     * @param placeholder_icon 默认加载图片
     * @param error_icon       加载失败展示的图片
     */
    public static void showImage(Context context, String imageUrl, ImageView img, int placeholder_icon, int error_icon) {
        if (context != null) {
            if (imageUrl != null && imageUrl.length() > 0) {
                Glide.with(context)
                        .load(imageUrl)
                        .apply(new RequestOptions()
                                .placeholder(placeholder_icon)
                                .error(error_icon)
                                .diskCacheStrategy(DiskCacheStrategy.ALL))
                        .into(img);
            }
        }


    }

    public static void showImage(Context context, byte[] imageUrl, ImageView iv) {
        Glide.with(context)
                .load(imageUrl)
                .apply(new RequestOptions()
                        .diskCacheStrategy(DiskCacheStrategy.ALL))
                .into(iv);
    }


}
