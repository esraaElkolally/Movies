package com.example.postslistapp.model.common

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.Target.SIZE_ORIGINAL
import com.example.postslistapp.R

fun ImageView.loadImage(path: String?) {
    if (!path.isNullOrEmpty()) {
        Glide.with(context)
            .load(path)
            .centerCrop()
            .override(SIZE_ORIGINAL)
            .into(this)
    }
}

fun Context.toast(
    context: Context = applicationContext,
    message: String,
    duration: Int = Toast.LENGTH_SHORT
) {
    Toast.makeText(context, message, duration).show()
}

fun Context.copy(text:String?) {
    val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    val clip: ClipData = ClipData.newPlainText(applicationContext.getString(R.string.torrent_url),text )
    clipboard.setPrimaryClip(clip)
}