package com.example.ese1_labtest

import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ese1_labtest.databinding.ActivityRegistrationBinding

class RegistrationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegistrationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btnRegister: Button = binding.btnRegister
        val etName: EditText = binding.etName
        val etEmail: EditText = binding.etEmail
        val etPhoneNumber: EditText = binding.etPhoneNumber

        btnRegister.setOnClickListener {
            val name = etName.text.toString()
            val email = etEmail.text.toString()
            val phoneNumber = etPhoneNumber.text.toString()

            if (isValidInput(name, email, phoneNumber)) {
                // Save user data to database or perform registration API call
                Toast.makeText(this, "Registration successful!", Toast.LENGTH_SHORT).show()
                finish() // Close registration activity
            } else {
                Toast.makeText(this, "Please enter valid information", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun isValidInput(name: String, email: String, phoneNumber: String): Boolean {
        return name.isNotBlank() && email.isNotBlank() && Patterns.EMAIL_ADDRESS.matcher(email).matches() && phoneNumber.isNotBlank()
    }
}
