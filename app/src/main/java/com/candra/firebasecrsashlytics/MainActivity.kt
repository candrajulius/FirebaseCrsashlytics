package com.candra.firebasecrsashlytics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.crashlytics.FirebaseCrashlytics
import java.lang.RuntimeException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnCrash = findViewById<Button>(R.id.btn_crash)
        btnCrash.setOnClickListener {
            // Code untuk membuat log
            FirebaseCrashlytics.getInstance().log("Clicked on button")
            // Kode untuk mengirimkan data
            FirebaseCrashlytics.getInstance().setCustomKey("str_key","some_data")
            throw RuntimeException("Test crash") // Kode untuk membuat crash
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