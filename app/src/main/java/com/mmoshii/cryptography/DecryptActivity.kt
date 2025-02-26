package com.mmoshii.cryptography

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class DecryptActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_decrypt)

        val chiperCodeField = findViewById<EditText>(R.id.ChiperCode)
        val chiperMessageField = findViewById<EditText>(R.id.ChiperMessage)
        val decryptButton = findViewById<Button>(R.id.decrypt_button)

        decryptButton.setOnClickListener {
            val encryptCode = chiperCodeField.text.toString()
            val chiperMessage = chiperMessageField.text.toString()
            val decryptedMessage = decryptMessage(encryptCode, chiperMessage)
            val intent = Intent(this@DecryptActivity, OutputActivity::class.java)
            intent.putExtra("ChiperMessage", decryptedMessage)
            intent.putExtra("ChiperCode", encryptCode)
            startActivity(intent)
            finish()
        }
    }

    private fun decryptMessage(encryptCode: String, chiperMessage: String): String {
        val alphabet = ('A'..'Z') + ('a'..'z')
        val encryptKey = encryptCode.split(" ")
        return chiperMessage.map { alphabet[encryptKey.indexOf(it.toString())] }.joinToString("")
    }
}
