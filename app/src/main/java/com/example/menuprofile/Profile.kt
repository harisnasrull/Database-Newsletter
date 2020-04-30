package com.example.menuprofile

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_profile.*

class Profile : AppCompatActivity() {

    private val PRIVATE_MODE = 0
    private val PREF_NAME = "bitlabs"
    var sharedPref : SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        sharedPref = this.getSharedPreferences(PREF_NAME,PRIVATE_MODE)
        user_profile_name.setText(sharedPref!!.getString("user-name",""))
        user_profile_email.setText(sharedPref!!.getString("user-email",""))
    }
}
