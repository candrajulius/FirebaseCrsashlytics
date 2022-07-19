package com.candra.firebasecrsashlytics

import android.util.Log
import com.google.firebase.crashlytics.FirebaseCrashlytics
import timber.log.Timber

// Timber saat Release
class ReleaseTree : Timber.Tree(){
    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        if (priority == Log.ERROR || priority == Log.WARN){
            if (t == null){
                FirebaseCrashlytics.getInstance().log(message)
            }else{
                FirebaseCrashlytics.getInstance().recordException(t)
            }
        }
    }
}
/*
Di sini Anda membuat Custom Tree dengan cara extend ke kelas Timber.Tree(). Nah, di sini Anda menggunakan Crashlytics untuk mengirimkan log yang berupa eror atau warning. Jika dilihat di sini Anda menggunakan fungsi yang baru yaitu recordException(). Fungsi ini digunakan untuk mengirimkan pesan eror ke Firebase Crashlytics namun sifatnya tidak fatal. Artinya ia tidak sampai menyebabkan aplikasi crash / force close.
 */