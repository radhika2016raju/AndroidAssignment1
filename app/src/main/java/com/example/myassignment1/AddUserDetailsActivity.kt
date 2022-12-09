package com.example.myassignment1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson

class AddUserDetailsActivity : AppCompatActivity() {
    private lateinit var preferenceManager: PreferenceManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_user_details)

        preferenceManager = PreferenceManager(this)

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
            if (!validateEmail(email)) {
                emailId.error = getString(R.string.please_enter_valid_email_id)
                emailId.requestFocus()
                isValid = false

            }

            if (isValid) {
                val gson = Gson()
                userList.add(UserDetails(id, names, email))
                val json: String = gson.toJson(userList)
                preferenceManager.putString(getString(R.string.user_details), json)
                Toast.makeText(
                    this,
                    getString(R.string.adding_user_information_success),
                    Toast.LENGTH_SHORT
                ).show()
                setResult(RESULT_CODE_FOR_USER_DETAILS)
                finish()

            }

        }
    }

}





