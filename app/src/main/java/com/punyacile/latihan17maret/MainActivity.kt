package com.punyacile.latihan17maret

import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.punyacile.latihan17maret.R
import com.punyacile.latihan17maret.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    //viewBinding
    private lateinit var binding: ActivityMainBinding

    //pilihBahasa(Localization)
    private lateinit var pilihBahasa:TextView
    private lateinit var editor: SharedPreferences.Editor
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        //viweBinding
        setContentView(binding.root)
        binding.btn1.setOnClickListener{
            startActivity(Intent(this,Home::class.java))
        }
        binding.tv2.setOnClickListener{
            startActivity(Intent(this,Register::class.java))
        }

        //localization
        LoadLocald()

        pilihBahasa = findViewById(R.id.pilihBahasa)
        pilihBahasa.setOnClickListener(View.OnClickListener {
            changeLanguage()
        })
    }

    private fun changeLanguage() {
        val list = arrayOf("Indonesia","English","France")
        val alertDialog = AlertDialog.Builder(this)
        alertDialog.setTitle("Pilih Bahasa")
        alertDialog.setSingleChoiceItems(list,-1,DialogInterface.OnClickListener {
                dialog, i ->

            if (i==0){
                setLocale("id")
                recreate()

            }else if (i==1){
                setLocale("en")
                recreate()

            }else if (i==2){
                setLocale("fr")
                recreate()
            }
        })
        alertDialog.setNeutralButton("Cancle",DialogInterface.OnClickListener { dialog, which ->
            dialog.cancel()
        })

        val mDialog = alertDialog.create()
        mDialog.show()
    }

    private fun setLocale(language: String) {
        val local = Locale(language)
        Locale.setDefault(local)

        val config = Configuration()
        config.locale = local
        baseContext.resources.updateConfiguration(config,baseContext.resources.displayMetrics)
        editor = getSharedPreferences(" ", MODE_PRIVATE).edit()
        editor.putString("Pilih Bahasa",language)
        editor.apply()
    }

    private fun LoadLocald() {
        sharedPreferences = getSharedPreferences("Settings", MODE_PRIVATE)
        val language = sharedPreferences.getString("Pilih Bahasa", " ")
        if (language != null) {
            setLocale(language)
        }
    }

}