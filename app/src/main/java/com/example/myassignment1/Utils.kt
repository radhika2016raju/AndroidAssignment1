package com.example.myassignment1

import android.text.TextUtils


private val emailPattern by lazy {
    "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" + "\\@" + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" + "(" +
        "\\." + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" + ")+"
}


fun validateUsername(Username: String): Boolean {
    if (TextUtils.isEmpty(Username)) {
        return false
    }
    return true
}

fun validatePassword(Password: String): Boolean {
    if (TextUtils.isEmpty(Password)) {
        return false
    }
    return true
}

fun validateEmail(emailId: String): Boolean {
    if (TextUtils.isEmpty(emailId))  {
        return false
    }
    if (emailId.matches(emailPattern.toRegex())) {
        return true
    }
    return false
}

fun validateUserId(Userid: String): Boolean {
    if (TextUtils.isEmpty(Userid)) {
        return false
    }
    return true
}





