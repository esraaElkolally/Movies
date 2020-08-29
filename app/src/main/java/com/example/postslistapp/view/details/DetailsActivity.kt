package com.example.postslistapp.view.details

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.databinding.DataBindingUtil
import com.example.postslistapp.model.common.copy
import com.example.postslistapp.model.common.loadImage
import com.example.postslistapp.R
import com.example.postslistapp.databinding.ActivityDetailsBinding
import com.example.postslistapp.model.common.Constants.Companion.MOVIE_MODEL
import com.example.postslistapp.model.common.Utils.Companion.download
import com.example.postslistapp.model.entities.Movies
import com.example.postslistapp.model.common.toast

class DetailsActivity : AppCompatActivity() {

    lateinit var binding: ActivityDetailsBinding
    private val _PermissionCode = 1
    private lateinit var torrentLink: String
    private val PERMISSIONS = listOf(
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.WRITE_EXTERNAL_STORAGE
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_details)
        val movieModel: Movies? = intent?.extras?.getParcelable(MOVIE_MODEL)
        movieModel?.let {
            binding.model = movieModel
            torrentLink = binding.model?.torrents?.get(0)?.url?:""
            binding.superheroeImage.loadImage(movieModel.background_image)
            binding.downloadTorrent.setOnClickListener(View.OnClickListener { askForPermission() })

        }

    }


    fun copy(view: View) {
        copy(binding.model?.torrents?.get(0)?.url)
        toast(view.context, resources.getString(R.string.copy_successfully), Toast.LENGTH_LONG)

    }

    private fun askForPermission() {
        if (hasPermissions(this, PERMISSIONS)) {
            download(this, binding.model!!.title, torrentLink)
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(PERMISSIONS.toTypedArray(), _PermissionCode)
            }
        }
    }

    companion object {
        fun open(activity: Activity, movieModel: Movies) {
            val intent = Intent(activity, DetailsActivity::class.java)
            intent.putExtra(MOVIE_MODEL, movieModel)
            activity.startActivity(intent)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == _PermissionCode && hasPermissions(this, PERMISSIONS)) {

            download(this, binding.model!!.title, torrentLink)
        }
    }

    private fun hasPermissions(context: Context?, permissions: List<String>): Boolean {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && context != null) {
            return permissions.all { permission ->
                ActivityCompat.checkSelfPermission(
                    context,
                    permission
                ) == PackageManager.PERMISSION_GRANTED
            }
        }

        return true
    }


}


