package com.mmoshii.cryptography

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        findViewById<Button>(R.id.encrypt_button).setOnClickListener {
            startActivity(Intent(this, EncryptActivity::class.java))
        }

        findViewById<Button>(R.id.decrypt_button).setOnClickListener {
            startActivity(Intent(this, DecryptActivity::class.java))
        }
    }
}