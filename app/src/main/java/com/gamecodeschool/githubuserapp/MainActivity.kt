package com.gamecodeschool.githubuserapp


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gamecodeschool.githubuserapp.DetailUser.Companion.DETAIL_USER

class MainActivity : AppCompatActivity() {
    private lateinit var ftUser: RecyclerView
    private val list = ArrayList<DetailUserParcel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ftUser = findViewById(R.id.ft_user)
        ftUser.setHasFixedSize(true)

        list.addAll(listUserGit)
        showRecyclerList()
    }

    private val listUserGit: ArrayList<DetailUserParcel>
    get(){
        val dataName = resources.getStringArray(R.array.name)
        val dataUsername = resources.getStringArray(R.array.username)
        val dataAvatar = resources.obtainTypedArray(R.array.avatar)
        val dataRepository = resources.getStringArray(R.array.repository)
        val dataFollower = resources.getStringArray(R.array.followers)
        val dataFollowing = resources.getStringArray(R.array.following)
        val dataLocation = resources.getStringArray(R.array.location)
        val dataCompany = resources.getStringArray(R.array.company)

        val listUser = ArrayList<DetailUserParcel>()
        for (i in dataName.indices){
            val userGit = DetailUserParcel(dataName[i], dataUsername[i], dataAvatar.getResourceId(i, -1),dataRepository[i],dataFollower[i], dataFollowing[i], dataLocation[i], dataCompany[i])
            listUser.add(userGit)
        }
        return listUser
    }

    private fun showRecyclerList(){
        ftUser.layoutManager = LinearLayoutManager(this)
        val listUserAdapter = ListUserAdapter(list)
        ftUser.adapter = listUserAdapter

        listUserAdapter.setOnItemClickback(object : ListUserAdapter.OnItemClickCallback{
            override fun onItemClicked(data: DetailUserParcel) {
                val(name, username, avatar, repository, follower, following, location, company)=data
                val detailData = DetailUserParcel(name, username, avatar, repository, follower, following, location, company)
                val intentToDetailUser = Intent(this@MainActivity,DetailUser::class.java)
                intentToDetailUser.putExtra(DETAIL_USER, detailData)
                startActivity(intentToDetailUser)
            }

        })
    }

}