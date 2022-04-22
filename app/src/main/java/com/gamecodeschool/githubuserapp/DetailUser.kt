package com.gamecodeschool.githubuserapp


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView

class DetailUser : AppCompatActivity() {

    companion object{
        const val DETAIL_USER = "detail_user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_user)

        val dtName: TextView = findViewById(R.id.name)
        val dtUsername: TextView = findViewById(R.id.user_name)
        val dtAvatar: ImageView = findViewById(R.id.img_photo)
        val dtRepository: TextView =findViewById(R.id.repository)
        val dtFollower: TextView = findViewById(R.id.follower)
        val dtFollowing: TextView = findViewById(R.id.following)
        val dtLocation: TextView = findViewById(R.id.location)
        val dtCompany: TextView = findViewById(R.id.company)

        val dtUser = intent.getParcelableExtra<DetailUserParcel>(DETAIL_USER) as DetailUserParcel
        Log.d("Detail Data", dtUser?.name.toString())

        dtAvatar.setImageResource(dtUser.avatar)
        dtName.text = dtUser.name
        dtUsername.text = dtUser.username
        dtRepository.text = dtUser.repository
        dtFollower.text = dtUser.follower
        dtFollowing.text = dtUser.following
        dtLocation.text = dtUser.location
        dtCompany.text = dtUser.company
    }
}