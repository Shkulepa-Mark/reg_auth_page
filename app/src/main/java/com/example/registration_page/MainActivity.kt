package com.example.registration_page

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userLogin: EditText = findViewById(R.id.user_login)
        val userEmail: EditText = findViewById(R.id.user_email)
        val userPass: EditText = findViewById(R.id.user_password)
        val button:Button = findViewById(R.id.button_reg)

        val linkToAuth: TextView = findViewById(R.id.link_to_auth)

        linkToAuth.setOnClickListener{
            val intent = Intent(this,AuthActivity::class.java)
            startActivity(intent)
        }

        button.setOnClickListener()
        {
            val login = userLogin.text.toString().trim()
            val email = userEmail.text.toString().trim()
            val password= userPass.text.toString().trim()

            if(login == "" || email == "" || password == "")
            {
                Toast.makeText(this,"Не все поля заполнены!",Toast.LENGTH_LONG).show()
            }
            else
            {
                val user = User(login,email,password)

                val db = DbHelper(this,null)
                db.addUser(user)
                Toast.makeText(this,"Пользователь $user добавлен",Toast.LENGTH_LONG).show()

                userLogin.text.clear()
                userEmail.text.clear()
                userPass.text.clear()
            }
        }
    }
}