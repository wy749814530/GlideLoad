# GlideLoad
带进度的Glide加载

```java

/**
 * 带进度的Glide加载方式
 *
 * @param context
 * @param ivView
 * @param url
 * @param progressListener
 */
public static void loadProgress(Context context, ImageView ivView, final String url, ProgressListener progressListener)

EXP:
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
```
