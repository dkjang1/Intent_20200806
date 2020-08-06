package com.kakao.intent_20200806

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit_nick_name.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

//    1000 이라는 숫자가 닉넹임을 변경하는 요청이라는것을 인식하기 어렵다
//    멤버변수 지정
    val REQ_FOR_NICKNAME = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        moveToFirstBtn.setOnClickListener {
//            FirstActivity 이동
            val myIntent = Intent(this, FirstActivity::class.java)
            startActivity(myIntent)
        }

        messageEdt.setText("안녕하세요!~")
        moveToSecondBtn.setOnClickListener {
//            SecondActivity 메시지전달+이동
            val inputMessage = messageEdt.text.toString()
            val myIntent = Intent(this, SecondActivity::class.java)
//            생성된 Intent 변수에 이름표를 붙인상태로 첨부
            myIntent.putExtra("message", inputMessage)
            startActivity(myIntent)
        }

        changeNickNameBtn.setOnClickListener {
//            닉네임변경화면 이동
            val myIntent = Intent(this, EditNickNameActivity::class.java)
//            고유숫자를 임의로 지정 -> 멤버변수로 가독성 향상
//            startActivityForResult(myIntent, 1000)
            startActivityForResult(myIntent, REQ_FOR_NICKNAME)
        }

    }
}