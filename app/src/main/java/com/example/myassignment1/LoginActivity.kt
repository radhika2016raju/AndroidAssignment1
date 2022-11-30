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



            if (username == "" || password == "") {
                if (!EmptyValidation(username)) {
                    etUsername.error = getString(R.string.Required)
                    etUsername.requestFocus()
                }

                if (!EmptyValidation(password)) {
                    etPassword.error = getString(R.string.Required)
                    etPassword.requestFocus()
                }
            } else {

                if (username == USER_NAME && password == PASSWORD) {
                    val intent = Intent(this,ShowListActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {

                    Toast.makeText(this, "Entered UserName and Password is Wrong", Toast.LENGTH_SHORT).show()

                }
            }
        }
    }
}



