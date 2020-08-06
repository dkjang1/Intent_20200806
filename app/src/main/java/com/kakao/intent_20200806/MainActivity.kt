package com.kakao.intent_20200806

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        moveToFirstBtn.setOnClickListener {
//            FirstActivity 이동
            val myIntent = Intent(this, FirstActivity::class.java)
            startActivity(myIntent)

        }

        moveToSecondBtn.setOnClickListener {

//            SecondActivity 메시지전달+이동
            val inputMessage = messageEdt.text.toString()
            val myIntent = Intent(this, SecondActivity::class.java)
//            생성된 Intent 변수에 이름표를 붙인상태로 첨부
            myIntent.putExtra("message", inputMessage)
            startActivity(myIntent)


        }

    }
}