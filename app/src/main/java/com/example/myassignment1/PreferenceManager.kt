package com.example.myassignment1

import android.content.Context
import android.content.SharedPreferences
import com.example.myassignment1.PrefConstants.IS_LOGIN
import com.example.myassignment1.PrefConstants.PREF_NAME


class PreferenceManager(context: Context) {

    val pref: SharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    val editor: SharedPreferences.Editor = pref.edit()


    fun putBoolean(key: String, value: Boolean) {
        pref.edit().putBoolean(key, value).apply()
    }

    fun putString(key: String, value: String) {
        pref.edit().putString(key, value).apply()
    }

    fun getString(key: String): String? {
        return pref.getString(key, null)
    }

    fun getBoolean(): Boolean {
        return pref.getBoolean(IS_LOGIN, false)
    }

}





