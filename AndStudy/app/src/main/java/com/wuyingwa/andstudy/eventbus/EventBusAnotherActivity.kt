package com.wuyingwa.andstudy.eventbus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wuyingwa.andstudy.R
import kotlinx.android.synthetic.main.activity_event_bus_another.*
import org.greenrobot.eventbus.EventBus

class EventBusAnotherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_bus_another)

        tv_send.setOnClickListener{
            EventBus.getDefault().post(MessageEvent("From Another Activity Clicked Message"))
        }

        tv_send_in_thread.setOnClickListener {
            Thread(Runnable { EventBus.getDefault().post(MessageEvent("From Another Activity Message in thread" + Thread.currentThread().name)) }).start()
        }

        tv_send_sticky.setOnClickListener {
            EventBus.getDefault().postSticky(MessageEvent("From Another Activity Sticky Message"))
        }
    }
}
