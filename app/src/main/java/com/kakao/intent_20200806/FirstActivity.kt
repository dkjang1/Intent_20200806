package com.kakao.intent_20200806

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_first.*
import kotlinx.android.synthetic.main.activity_main.*

class FirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        goBackToMainBtn.setOnClickListener {
//            MainActivity 이동
            finish() //액티비티종료
//            onBackPressed() //뒤로가기
//            val myIntent = Intent(this,MainActivity::class.java)
//            startActivity(myIntent)

        }

    }
}