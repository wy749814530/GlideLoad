package com.glideUtils;

/**
 * Created by Administrator on 2020/3/20 0020.
 */

public interface ProgressListener {
    void onProgress(int progress);

    void onLoadResult(boolean result);
}