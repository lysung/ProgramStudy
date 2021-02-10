package com.wuyingwa.andstudy.funs

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.wuyingwa.andstudy.StuApplication

fun showToast(msg: String) {
    Toast.makeText(StuApplication.appContext, msg, Toast.LENGTH_SHORT).show()
}

fun openActivity(context: Context?, clazz: Class<out Activity>) {
    val intent: Intent = Intent(context, clazz)
    context?.startActivity(intent)
}