package com.example.postslistapp.model.entities

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

data class MovieModel(
    val status: String,
    val status_message: String,
    val data: Data
)

data class Data(

    val movie_count: Int,
    val limit: Int,
    val page_number: Int,
    val movies: List<Movies>
)

@Parcelize
data class Movies (

    val id: Int,
    val url: String,
    val imdb_code: String,
    val title: String,
    val title_english: String,
    val title_long: String,
    val slug: String,
    val year: Int,
    val rating: Double,
    val runtime: Int,
    val genres: List<String>,
    val summary: String,
    val description_full: String,
    val synopsis: String,
    val yt_trailer_code: String,
    val language: String,
    val mpa_rating: String,
    val background_image: String,
    val background_image_original: String,
    val small_cover_image: String,
    val medium_cover_image: String,
    val large_cover_image: String,
    val state: String,
    val torrents: List<Torrents>,
    val date_uploaded: String,
    val date_uploaded_unix: Int
):Parcelable
@Parcelize
data class Torrents(

    val url: String,
    val hash: String,
    val quality: String,
    val type: String,
    val seeds: Int,
    val peers: Int,
    val size: String,
    val size_bytes:Long,
    val date_uploaded: String,
    val date_uploaded_unix: Int
):Parcelable