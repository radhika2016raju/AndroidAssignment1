package com.example.myassignment1

import android.text.TextUtils


private val emailPattern by lazy {
    "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" + "\\@" + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" + "(" +
        "\\." + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" + ")+"
}


fun EmptyValidation(str: String): Boolean {
    if (TextUtils.isEmpty(str)) {
        return false
    }
    return true
}


fun validateEmail(emailId: String): Boolean {
    if (emailId.matches(emailPattern.toRegex())) {
        return true
    }
    return false
}






