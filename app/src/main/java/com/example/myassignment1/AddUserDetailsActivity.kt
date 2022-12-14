package com.example.myassignment1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.myassignmenttask.UserDetails

class AddUserDetailsActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_user_details)


        val userName: EditText = findViewById(R.id.et_name)
        val userId: EditText = findViewById(R.id.et_id)
        val emailId: EditText = findViewById(R.id.et_email)
        val addButton: Button = findViewById(R.id.btn_add_user)


        addButton.setOnClickListener {


            val names = userName.text.toString()
            val id = userId.text.toString()
            val email = emailId.text.toString()

            val valid = true

            if (valid) {
                if (!EmptyValidation(names)) {
                    userName.error = getString(R.string.Required)
                    userName.requestFocus()
                }

                if (!EmptyValidation(id)) {
                    userId.error = getString(R.string.Required)

                    userId.requestFocus()

                }
                if (!EmptyValidation(email)) {
                    emailId.error = getString(R.string.Required)
                    emailId.requestFocus()

                } else {

                    userList.add(UserDetails(id, names, email))
                    val intent = Intent(this, ShowListActivity::class.java)
                    startActivity(intent)
                    finish()
                }

            }
        }
    }
}


