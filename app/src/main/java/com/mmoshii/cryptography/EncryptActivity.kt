package com.mmoshii.cryptography

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class EncryptActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_encrypt)

        val encryptCodeField = findViewById<EditText>(R.id.encryptCode)
        val messageField = findViewById<EditText>(R.id.message)
        val encryptButton = findViewById<Button>(R.id.encrypt_button)

        encryptButton.setOnClickListener {
            val encryptCode = encryptCodeField.text.toString()
            val message = messageField.text.toString()
            val (encryptedMessage, fullEncryptKey) = encryptMessage(encryptCode, message)
            val intent = Intent(this@EncryptActivity, OutputActivity::class.java)
            intent.putExtra("ChiperMessage", encryptedMessage)
            intent.putExtra("ChiperCode", fullEncryptKey)
            startActivity(intent)
            finish()
        }
    }

    private fun encryptMessage(encryptCode: String, message: String): Pair<String, String> {
        val alphabet = ('A'..'Z') + ('a'..'z')
        val encryptKey = mutableListOf<Char>()

        encryptCode.forEach { if (it in alphabet && it !in encryptKey) encryptKey.add(it) }
        alphabet.forEach { if (it !in encryptKey) encryptKey.add(it) }

        val encryptedMessage = message.map { encryptKey[alphabet.indexOf(it)] }.joinToString("")
        val fullEncryptKey = encryptKey.joinToString(" ")

        return Pair(encryptedMessage, fullEncryptKey)
    }
}