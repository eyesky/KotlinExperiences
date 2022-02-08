package com.ibk.kotlinexperiences.preferencesdatastore

import android.content.Context
import androidx.datastore.preferences.createDataStore
import androidx.datastore.preferences.edit
import androidx.datastore.preferences.preferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class KeyValueManager(context: Context) {

    private val dataStore = context.createDataStore(name = "user_prefs")

    // Create some keys we will use them to store and retrieve the data
    companion object {
        val USER_KEY_KEY = preferencesKey<String>("KEY")
        val USER_VALUE_KEY = preferencesKey<String>("VALUE")
    }

    // Store user data
    // refer to the data store and using edit
    // we can store values using the keys
    suspend fun storeUser(key: String, value: String) {
        dataStore.edit {
            it[USER_KEY_KEY] = key
            it[USER_VALUE_KEY] = value

            // here it refers to the preferences we are editing

        }
    }

    // flow comes from the kotlin coroutine
    val userAgeFlow: Flow<String> = dataStore.data.map {
        it[USER_KEY_KEY] ?: ""
    }

    val userNameFlow: Flow<String> = dataStore.data.map {
        it[USER_VALUE_KEY] ?: ""
    }

}
