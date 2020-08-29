package com.example.postslistapp.model.common

import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import android.os.Environment
import android.webkit.URLUtil
import android.widget.Toast
import com.example.postslistapp.R

class Utils {
    companion object {
        fun download(context: Context, title: String, fileUrl: String) {
            if (!fileUrl.isEmpty()) {
                if (URLUtil.isValidUrl(fileUrl)) {
                    val uri = Uri.parse(fileUrl)
                    val downloadmanager =
                        context.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
                    val req = DownloadManager.Request(uri)
                    req.setAllowedNetworkTypes(
                            DownloadManager.Request.NETWORK_WIFI
                                    or DownloadManager.Request.NETWORK_MOBILE
                        )
                        .setAllowedOverRoaming(false)
                        .setTitle(title)
                        .setDescription(context.getString(R.string.downloading))
                        .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
                        .setDestinationInExternalPublicDir(
                            Environment.DIRECTORY_DOWNLOADS,
                            title
                        )
                    downloadmanager.enqueue(req)
                } else {
                    context.toast(context,context.getString(R.string.invalidUrl),Toast.LENGTH_LONG)
                }
            }
        }
    }
}