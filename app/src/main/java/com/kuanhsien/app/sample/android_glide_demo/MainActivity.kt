package com.kuanhsien.app.sample.android_glide_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Demo 1: Simplest call
        Glide.with(this).load("http://goo.gl/gEgYUd").into(iv_demo_a)

        // Demo 2: Simplest call with comment
        Glide.with(this)
            // 使用 Application context，Glide Request 不會受 Activity 生命周期影響。
            // 使用 Activity context，Glide Request 會受 Activity 生命周期控制。


            // [Load from]
            // .load(path) // 可以從多種媒體資源 load 圖片，包括 url, uri, local file, resource id, ...
            .load("http://goo.gl/gEgYUd")


            // [Cache strategy]
            // DiskCacheStrategy.ALL：Caches remote data with both DATA and RESOURCE, and local data with RESOURCE only.
            // DiskCacheStrategy.DATA：Writes retrieved data directly to the disk cache before it's decoded.
            // DiskCacheStrategy.RESOURCE：Writes resources to disk after they've been decoded.
            // DiskCacheStrategy.NONE：Saves no data to cache.

            // 預設 ?
            // 若只是 download 但不需要改圖，是否不需要使用 ALL (DiskCacheStrategy.RESOURCE ??? DATA ???)
            .diskCacheStrategy(DiskCacheStrategy.DATA)


            // [Skip memory cache]
            // True to allow the resource to skip the memory cache. (not guarantee)
            // If a request is already pending for this resource and that
            // request is not also skipping the memory cache, the resource will be cached in memory.
            .skipMemoryCache(true)


            // [Priority]
            // Priorities for completing loads. If more than one load is queued at a time, the load with the
            // higher priority will be started first. Priorities are considered best effort,
            // there are no guarantees about the order in which loads will start or finish.

            // Priority.IMMEDIATE
            // Priority.HIGH
            // Priority.NORMAL
            // Priority.LOW
            // Default: Priority.NORMAL
            .priority(Priority.HIGH)


            // [Animation]
            // Disables resource decoders that return animated resources so any resource returned will be static.
            // 移除所有動畫
            .dontAnimate()
            //.animate(int animationId) // start animation after load resource complete


            // [Placeholder]
            .placeholder(R.drawable.img_placeholder) // placeholder while loading image
            .error(R.drawable.img_exclamation) // placeholder when loading fail

            // [Request Listener]
            // 為了節省 Memory，不需要每個 Request 都 new Listener，可以用同一個 Listener。
//            .listener(new RequestListener<String, GlideDrawable>() {
                // onError
//                @Override
//                public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
//                    return false;
//                }
//
                // onComplete
//                @Override
//                public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
//                    return false;
//                }
//            })

            // 重新設定圖片長寬
            .override(200, 200)


            // Image ScaleType
            .centerCrop()


            // [Into ImageView]
            // 把圖片放到哪個 view 中
            //.into(customeView.imageview)
            .into(iv_demo_b)
    }
}
