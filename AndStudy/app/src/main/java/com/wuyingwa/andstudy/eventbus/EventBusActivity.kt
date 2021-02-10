package com.wuyingwa.andstudy.eventbus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import com.wuyingwa.andstudy.R
import com.wuyingwa.andstudy.funs.openActivity
import com.wuyingwa.andstudy.funs.showToast
import kotlinx.android.synthetic.main.activity_event_bus.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class EventBusActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_bus)

        tv_send.setOnClickListener{
            EventBus.getDefault().post(MessageEvent("Clicked Message"))
        }

        tv_send_in_thread.setOnClickListener {
            Thread(Runnable { EventBus.getDefault().post(MessageEvent("Message in thread" + Thread.currentThread().name)) }).start()
        }

        tv_send_in_new_activity.setOnClickListener {
            openActivity(this, EventBusAnotherActivity::class.java)
        }

        btn_register.setOnClickListener {
            if (!EventBus.getDefault().isRegistered(this)) {
                EventBus.getDefault().register(this)
            }
        }

        btn_unregister.setOnClickListener {
            if (EventBus.getDefault().isRegistered(this)) {
                EventBus.getDefault().unregister(this)
            }
        }

//        EventBus.getDefault().register(this)

    }

//    override fun onDestroy() {
//        EventBus.getDefault().unregister(this)
//        super.onDestroy()
//    }

//    override fun onStart() {
//        super.onStart()
//        EventBus.getDefault().register(this)
//    }
//
//    override fun onStop() {
//        super.onStop()
//        EventBus.getDefault().unregister(this)
//    }

    @Subscribe(threadMode = ThreadMode.POSTING, sticky = true)
    fun onStickyEvent(event: MessageEvent) {
        addMessage(event)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessage(event: MessageEvent) {
        addMessage(event)
    }

    private fun addMessage(event: MessageEvent) {
        showToast(event.msg?:"empty message")
        val current = tv_message.text.toString()
        tv_message.text = if (TextUtils.isEmpty(current)){
            ""
        }else{
            current + "\n"
        } + event.msg
    }
}
