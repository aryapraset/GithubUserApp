package com.gamecodeschool.githubuserapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DetailUserParcel(
    var name: String,
    var username: String,
    var avatar: Int,
    var repository: String,
    var follower: String,
    var following: String,
    var location: String,
    var company: String
):Parcelable
