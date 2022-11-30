package com.example.myassignment1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.myassignmenttask.UserDetails

class AddItemActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.edit_item)


        val userName: EditText = findViewById(R.id.et_name)
        val userid: EditText = findViewById(R.id.et_id)
        val emailId: EditText = findViewById(R.id.et_email)
        val addButton: Button = findViewById(R.id.btn_add)


        addButton.setOnClickListener {


            val names = userName.text.toString()
            val id = userid.text.toString()
            val email = emailId.text.toString()

            val valid = true

            if (valid) {
                if (!validateUsername(names)) {
                    userName.error = getString(R.string.Required)
                    userName.requestFocus()
                }

                if (!validateUserId(id)) {
                    userid.error = getString(R.string.Required)

                    userid.requestFocus()

                }
                if (!validateEmail(email)) {
                    emailId.error = getString(R.string.Required)
                    emailId.requestFocus()

                } else {

                    userList.add(UserDetails("UserId: $id", "UserName:$names", "email:$email"))
                    val intent = Intent(this, AddActivity::class.java)
                    startActivity(intent)
                }

            }
        }
    }
}


