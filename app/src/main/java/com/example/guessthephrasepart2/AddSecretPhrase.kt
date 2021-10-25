package com.example.guessthephrasepart2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class AddSecretPhrase : AppCompatActivity() {
    private val databaseHelper by lazy{ DatabaseHelper(applicationContext) }
    private lateinit var etPhrase: EditText
    private lateinit var btAdd: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_secret_phrase)
         setTitle("Add Secret Phrase")

        etPhrase = findViewById(R.id.etAdd)
        btAdd =  findViewById(R.id.btAdd)

        btAdd.setOnClickListener{
            if(etPhrase.text.isNotBlank())
            {
                databaseHelper.saveData(etPhrase.text.toString())
                Toast.makeText(
                    applicationContext,
                    "data saved successfully!",
                    Toast.LENGTH_SHORT
                ).show()
            }else
                Toast.makeText(
                    applicationContext,
                    "Field can not be empty! ",
                    Toast.LENGTH_SHORT
                ).show()
        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.mainActivity -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}