package com.ibk.kotlinexperiences

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ibk.kotlinexperiences.databinding.ActivityMainBinding
import com.ibk.kotlinexperiences.preferencesdatastore.PreferenceDataStoreActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnDataStore.setOnClickListener {
            startActivity(Intent(this, PreferenceDataStoreActivity::class.java))
        }
    }
}