package com.wuyingwa.andstudy.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wuyingwa.andstudy.R

class BaseListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base_list)
    }
}
