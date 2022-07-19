package com.candra.firebasecrsashlytics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.crashlytics.FirebaseCrashlytics
import timber.log.Timber
import java.lang.RuntimeException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnCrash = findViewById<Button>(R.id.btn_crash)

        Timber.d("Test debugging")

        btnCrash.setOnClickListener {
            // Code untuk membuat log
            FirebaseCrashlytics.getInstance().log("Clicked on button")
            // Kode untuk mengirimkan data
            FirebaseCrashlytics.getInstance().setCustomKey("str_key","some_data")
            try {
                throw RuntimeException("Test crash") // Kode untuk membuat crash
            }catch (e: Exception){
                Timber.e("Test non fatal exception")
            }
        }
        setToolbar()
    }

    private fun setToolbar(){
        supportActionBar?.apply {
            title = getString(R.string.name_developer)
            subtitle = getString(R.string.app_name)
        }
    }
}
/*
Penggunaan Timber
Untuk menggunakan Timber Anda bisa menggunakan kode seperti berikut:
Timber.d(tourism.data.toString())
Sama seperti Log Anda juga bisa menggunakan macam-macam tipe sesuai prioritas seperti:
Timber.d untuk debug

Timber.e untuk error

Timber.w untuk warning

Timber.v untuk verbose

Timber.i untuk info

Lalu bagaimana jika anda ingin menambahkan tag sendiri? Anda bisa menggunakan format berikut
Timber.tag("YourTag").d(tourism.data.toString())
 */