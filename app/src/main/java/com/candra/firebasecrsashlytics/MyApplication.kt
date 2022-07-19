package com.candra.firebasecrsashlytics

import android.app.Application
import timber.log.Timber

open class MyApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }else{
            Timber.plant(ReleaseTree())
        }
    }
}
/*
Untuk inisiasi Timber, Anda cukup menggunakan fungsi **plant** dengan paramter Tree yang ingin
ditanam(baca: dicatat)
Timber menyediakan DebugTree untuk Tree versi debug,
namun jika Anda ingin membuat Tree sendiri dengan membuat class yang extend ke class Tree seperti ReleaseTree.
 */