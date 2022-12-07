package com.example.myassignment1

import android.content.Context
import android.content.SharedPreferences
import com.example.myassignment1.PrefConstants.IS_LOGIN
import com.example.myassignment1.PrefConstants.PREF_NAME
import com.example.myassignment1.PrefConstants.PRIVATE_MODE
import com.google.gson.Gson


class PreferenceManager(context: Context) {

    val pref: SharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    val editor: SharedPreferences.Editor = pref.edit()

    fun putBoolean(key: String, value: Boolean) {
        pref.edit().putBoolean(key, value).apply()
    }

    fun putString(key: String, value: String) {
        pref.edit().putString(key, value).apply()
    }


    fun isLogin(): Boolean {
        return pref.getBoolean(IS_LOGIN, false)
    }

}



