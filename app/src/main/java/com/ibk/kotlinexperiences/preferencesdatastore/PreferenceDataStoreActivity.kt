package com.ibk.kotlinexperiences.preferencesdatastore

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ibk.kotlinexperiences.databinding.ActivityPreferenceDataStoreBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PreferenceDataStoreActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPreferenceDataStoreBinding
    lateinit var keyValueManager: KeyValueManager
    var key = ""
    var value = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPreferenceDataStoreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Get reference to our userManager class
        keyValueManager = KeyValueManager(this)

        binding.btnSave.setOnClickListener {
            key = binding.etKey.text.toString()
            value = binding.etValue.text.toString()

            // Stores the values
            // Since the storeUser function of UserManager
            // class is a suspend function
            // So this has to be done in a coroutine scope
            GlobalScope.launch {
                keyValueManager.storeUser(key, value)
            }
        }

    }
}