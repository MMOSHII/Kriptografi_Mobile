package com.mmoshii.cryptography

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class OutputActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_output)

        val chiperMessage = intent.getStringExtra("ChiperMessage")
        val chiperCode = intent.getStringExtra("ChiperCode")
        val messageOutput: TextView = findViewById(R.id.message)
        val codeOutput: TextView = findViewById(R.id.encryptCode)
        val backButton = findViewById<Button>(R.id.buttonHome)

        messageOutput.text = chiperMessage
        codeOutput.text = chiperCode

        messageOutput.setOnClickListener {
            val textToCopy = messageOutput.text.toString()

            if (textToCopy.isNotEmpty()) {
                val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                val clip = ClipData.newPlainText("Copied Text", textToCopy)
                clipboard.setPrimaryClip(clip)

                Toast.makeText(this, "Copied to clipboard", Toast.LENGTH_SHORT).show()
            }
        }

        codeOutput.setOnClickListener {
            val textToCopy = codeOutput.text.toString()

            if (textToCopy.isNotEmpty()) {
                val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                val clip = ClipData.newPlainText("Copied Text", textToCopy)
                clipboard.setPrimaryClip(clip)

                Toast.makeText(this, "Copied to clipboard", Toast.LENGTH_SHORT).show()
            }
        }

        backButton.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }
    }
}