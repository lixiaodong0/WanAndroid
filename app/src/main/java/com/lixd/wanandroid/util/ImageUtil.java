package com.lixd.wanandroid.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ImageUtil {


    public static final void loadImage(Context context, ImageView view, String url) {
        Glide.with(context)
                .load(url)
                .into(view);
    }
}
