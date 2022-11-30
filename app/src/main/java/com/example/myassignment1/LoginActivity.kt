package com.example.myassignment1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

    private lateinit var etusername: EditText
    private lateinit var etpassword: EditText
    private lateinit var btnlogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnlogin = findViewById(R.id.btn_login)
        etusername = findViewById(R.id.et_username)
        etpassword = findViewById(R.id.et_password)

        btnlogin.setOnClickListener {
            val username = etusername.text.toString()
            val password = etpassword.text.toString()



            if (username == "" || password == "") {
                if (!validateUsername(username)) {
                    etusername.error = getString(R.string.Required)
                    etusername.requestFocus()
                }

                if (!validatePassword(password)) {
                    etpassword.error = getString(R.string.Required)
                    etpassword.requestFocus()
                }
            } else {

                if (username == USER_NAME && password == PASSWORD) {
                    val intent = Intent(this, AddItemActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {

                    Toast.makeText(this, "Entered UserName and Password is Wrong", Toast.LENGTH_SHORT).show()

                }
            }
        }
    }
}



