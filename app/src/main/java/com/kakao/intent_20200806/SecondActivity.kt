package com.kakao.intent_20200806

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_first.*
import kotlinx.android.synthetic.main.activity_second.*
import kotlinx.android.synthetic.main.activity_second.goBackToMainBtn

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val receivedMessage = intent.getStringExtra("message")
        receivedMessageTxt.text = receivedMessage

        goBackToMainBtn.setOnClickListener {
//            MainActivity 이동
//            finish() //액티비티종료
            onBackPressed() //뒤로가기

        }
    }
}