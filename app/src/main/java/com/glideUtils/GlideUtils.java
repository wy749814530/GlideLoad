package com.glideUtils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.glideload.GlideApp;
import com.glideload.R;

/**
 * Created by Administrator on 2020/3/24 0024.
 */

public class GlideUtils {

    public static void loadProgress(Context mContext, ImageView ivView, final String url, ProgressListener progressListener) {
        ProgressInterceptor.addListener(url, progressListener);
        GlideApp.with(mContext).load(url).placeholder(R.mipmap.loading).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE).addListener(new RequestListener<Drawable>() {
            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                if (ProgressInterceptor.getListener(url) != null) {
                    ProgressInterceptor.getListener(url).onLoadResult(false);
                }
                ProgressInterceptor.removeListener(url);
                return false;
            }

            @Override
            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                if (ProgressInterceptor.getListener(url) != null) {
                    ProgressInterceptor.getListener(url).onLoadResult(true);
                }
                ProgressInterceptor.removeListener(url);
                return false;
            }
        }).into(ivView);
    }
}
