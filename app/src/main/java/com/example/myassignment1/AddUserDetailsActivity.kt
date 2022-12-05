package com.example.myassignment1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
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

            var isValid: Boolean = true
            if (!emptyValidation(names)) {
                userName.error = getString(R.string.please_enter_user_name)
                userName.requestFocus()
                isValid = false
            }

            if (!emptyValidation(id)) {
                userId.error = getString(R.string.please_enter_user_id)
                userId.requestFocus()
                isValid = false
            }


            if (!emptyValidation(email)) {
                emailId.error = getString(R.string.please_enter_user_email)
                emailId.requestFocus()
                isValid = false
            }
            if(!validateEmail(email)){
                emailId.error = getString(R.string.please_enter_valid_email_id)
                emailId.requestFocus()
                isValid = false

            }

            if (isValid) {
                userList.add(UserDetails(id, names, email))
                Toast.makeText(
                    this,
                    getString(R.string.adding_user_information_success),
                    Toast.LENGTH_SHORT
                ).show()
                setResult(100)
                finish()

            }

        }
    }

}



