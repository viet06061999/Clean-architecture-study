package com.example.presentation.binding

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.AnimationDrawable
import android.graphics.drawable.Drawable
import android.net.Uri
import android.widget.ImageView
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory
import com.example.presentation.R


@BindingAdapter(value = ["image", "sex"], requireAll = false)
fun loadImage(view: ImageView, imageUrl: String?, sex: String?) {
    val animationDrawable =
        ContextCompat.getDrawable(view.context, R.drawable.gradient_list) as AnimationDrawable
    animationDrawable.apply {
        setEnterFadeDuration(2000)
        setExitFadeDuration(4000)
        start()
    }
    val factory =
        DrawableCrossFadeFactory.Builder().setCrossFadeEnabled(true).build()
    val url = imageUrl?.let {
        GlideUrl(
            imageUrl, LazyHeaders.Builder()
                .addHeader("User-Agent", "5")
                .build()
        )
    }
    if (!imageUrl.isNullOrBlank()) {
        Glide.with(view.context)
            .load(url)
            .placeholder(animationDrawable)
            .transition(withCrossFade(factory))
            .error(R.drawable.img_no_image_to_show)
            .into(view)
    } else {
        view.setImageDrawable(
            AppCompatResources.getDrawable(
                view.context,
                R.drawable.img_no_image_to_show
            )
        )
    }
}

@BindingAdapter("imageUri")
fun loadImage(view: ImageView, imageUri: Uri?) {
    if (imageUri != null) {
        Glide.with(view.context)
            .load(imageUri)
            .transition(DrawableTransitionOptions.withCrossFade())
            .error(R.drawable.img_no_image_to_show)
            .into(view)
    }
}

@BindingAdapter("imageDrawable")
fun loadImage(view: ImageView, drawable: Drawable) {
    val options = BitmapFactory.Options()
    options.inJustDecodeBounds = true
    options.inSampleSize = 2
    options.inJustDecodeBounds = false
    options.inTempStorage = ByteArray(16 * 1024)
    val resizedBitmap = Bitmap.createScaledBitmap(drawable.toBitmap(620, 900), 620, 900, false)

    Glide.with(view.context)
        .load(resizedBitmap)
        .transition(DrawableTransitionOptions.withCrossFade())
        .error(R.drawable.img_no_image_to_show)
        .into(view)
}
