package com.example.myassignment1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLogin = findViewById(R.id.btn_login)
        etUsername = findViewById(R.id.et_user_name)
        etPassword = findViewById(R.id.et_password)

        btnLogin.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()

            if (!emptyValidation(username)) {
                etUsername.error = getString(R.string.please_enter_username)
                etUsername.requestFocus()
            } else if (username != USER_NAME) {

                Toast.makeText(
                    this,
                    getString(R.string.please_enter_valid_username),
                    Toast.LENGTH_SHORT
                ).show()

            }


            if (!emptyValidation(PASSWORD)) {
                etPassword.error = getString(R.string.please_enter_password)
                etPassword.requestFocus()
            } else if (password != PASSWORD) {

                Toast.makeText(
                    this,
                    getString(R.string.please_enter_valid_password),
                    Toast.LENGTH_SHORT
                ).show()


            }
            if (username == USER_NAME && password == PASSWORD) {
                val intent = Intent(this, ShowListActivity::class.java)
                startActivity(intent)
                Toast.makeText(this, getString(R.string.login_successfully), Toast.LENGTH_SHORT)
                    .show()
                finish()
            }

        }
    }
}







