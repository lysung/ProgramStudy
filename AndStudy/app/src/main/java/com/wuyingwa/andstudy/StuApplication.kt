package com.wuyingwa.andstudy

import android.app.Application
import android.content.Context

class StuApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        appContext = this
    }

    companion object {
        lateinit var appContext: Context
    }

}