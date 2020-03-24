package com.glideload;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.glideUtils.GlideUtils;
import com.glideUtils.ProgressListener;

public class MainActivity extends AppCompatActivity {
    String TAG = "MainActivity";
    String imgUrl = "https://tmp-beijing.s3.cn-north-1.amazonaws.com.cn/image/time_img_introduce.gif";
    ImageView ivImage;
    TextView tvProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ivImage = findViewById(R.id.iv_image);
        tvProgress = findViewById(R.id.tv_progress);


        GlideUtils.loadProgress(this, ivImage, imgUrl, new ProgressListener() {
            @Override
            public void onProgress(final int progress) {
                tvProgress.setText(progress + "%");
            }

            @Override
            public void onLoadResult(final boolean result) {
                Log.d(TAG, "onLoadResult: " + result);
                if (result) {
                    tvProgress.setText("");
                } else {
                    tvProgress.setText("下载失败");
                }
            }
        });
    }
}
