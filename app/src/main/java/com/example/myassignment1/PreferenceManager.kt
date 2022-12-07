package com.example.myassignment1

import android.content.Context
import android.content.SharedPreferences
import com.example.myassignmenttask.UserDetails
import com.google.gson.Gson


class PreferenceManager(context: Context) {
val PRIVATE_MODE=0

        val pref: SharedPreferences = context.getSharedPreferences(PREF_NAME,PRIVATE_MODE)
        val editor: SharedPreferences.Editor = pref.edit()
        val gson = Gson()


        fun saveDetailsTopref(userList: ArrayList<UserDetails>) {
            editor.putString("userList", gson.toJson(userList))
            editor.apply()


        }


        fun setLogin(isLogin: Boolean) {
            editor.putBoolean(IS_LOGIN, isLogin)
            editor.apply()
        }


        fun setUsername(Username: String) {
            editor.putString("username", Username)
            editor.apply()
        }

        fun isLogin(): Boolean {
            return pref.getBoolean(IS_LOGIN, false)
        }

        fun setUserList(userList: ArrayList<UserDetails>) {
            editor.putString("Userlist", userList.toString())
            editor.apply()
        }
    }



