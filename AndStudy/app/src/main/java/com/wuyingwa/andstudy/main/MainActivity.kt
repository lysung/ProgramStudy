package com.wuyingwa.andstudy.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import androidx.appcompat.app.ActionBarDrawerToggle
import com.wuyingwa.andstudy.R
import com.wuyingwa.andstudy.funs.showToast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.include_toolbar.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {
        setSupportActionBar(toolbar)

        toolbar.title = "Toolbar"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setLogo(R.mipmap.ic_launcher)
        toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.search -> {
                    showToast("search")
                }
                R.id.share -> {
                    showToast("share")
                }
                R.id.settings -> {
                    showToast("settings")
                }
            }
            true
        }

        val actionBarDrawerToggle =
            ActionBarDrawerToggle(this, drawer, toolbar, R.string.open, R.string.close)
        actionBarDrawerToggle.syncState()
        drawer.addDrawerListener(actionBarDrawerToggle)
        tv_close.setOnClickListener { drawer.closeDrawer(Gravity.LEFT) }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true

    }
}
