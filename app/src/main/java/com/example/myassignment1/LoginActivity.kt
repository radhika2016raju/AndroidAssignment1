package com.example.myassignment1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    private lateinit var preferenceManager: PreferenceManager
    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        init()
        checkLogin()
        onClick()
    }

    private fun init() {
        preferenceManager = PreferenceManager(this)

        btnLogin = findViewById(R.id.btn_login)
        etUsername = findViewById(R.id.et_user_name)
        etPassword = findViewById(R.id.et_password)
    }

    private fun checkLogin() {
        if (preferenceManager.isLogin()) {
            val intent = Intent(this, ShowListActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, getString(R.string.login_successfully), Toast.LENGTH_SHORT)
                .show()
            finish()

        }
    }

    fun onClick() {

        btnLogin.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()

            var isValidLoginCreds: Boolean = true

            if (TextUtils.isEmpty(username)) {
                etUsername.error = getString(R.string.please_enter_username)
                etUsername.requestFocus()
                isValidLoginCreds = false
            } else if (username != USER_NAME) {
                etUsername.error = getString(R.string.please_enter_valid_username)
                etUsername.requestFocus()
                isValidLoginCreds = false
            } else {
                etUsername.error = null

            }

            if (TextUtils.isEmpty(password)) {
                etPassword.error = getString(R.string.please_enter_password)
                etPassword.requestFocus()
                isValidLoginCreds = false
            } else if (password != PASSWORD) {
                etPassword.error = getString(R.string.please_enter_valid_password)
                etPassword.requestFocus()
                isValidLoginCreds = false
            } else {
                etPassword.error = null

            }

            if (isValidLoginCreds) {
                preferenceManager.setLogin(true)
                preferenceManager.setUsername(username)
                val intent = Intent(this, ShowListActivity::class.java)
                startActivity(intent)
                Toast.makeText(this, getString(R.string.login_successfully), Toast.LENGTH_SHORT)
                    .show()
                finish()
            }

        }
    }
}









