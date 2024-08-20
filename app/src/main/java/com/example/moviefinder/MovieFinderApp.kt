package com.example.moviefinder

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MovieFinderApp : Application() {

    override fun onCreate() {
        super.onCreate()
        Log.e("tag", "in app onCreate")
    }
}