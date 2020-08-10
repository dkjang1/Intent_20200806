package com.kakao.intent_20200806

import android.app.Activity
import android.content.Intent
import android.net.Uri
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

        kakaoPlayStoreLinkBtn.setOnClickListener {
            val myUri = Uri.parse("market://details?id=com.kakao.talk")
            val myIntent = Intent(Intent.ACTION_VIEW, myUri)
            startActivity(myIntent)
        }

        naverLinkBtn.setOnClickListener {
            val myUri = Uri.parse("https://www.naver.com")
            val myIntent = Intent(Intent.ACTION_VIEW, myUri)
            startActivity(myIntent)
        }

        smsBtn.setOnClickListener {
            val inputPhoneNum = phoneNumEdt.text.toString()
            val myUri = Uri.parse("smsto:${inputPhoneNum}")
            val myIntent = Intent(Intent.ACTION_SENDTO, myUri)
//            문자전송화면이동시 미리문구를 적어서 보내자
//            myIntent를 가지고 갈때
            myIntent.putExtra("sms_body","이앱을 플레이스토어에서 설치해 주세요.")
            startActivity(myIntent)
        }

        callBtn.setOnClickListener {
            val inputPhoneNum = phoneNumEdt.text.toString()
            val myUri = Uri.parse("tel:${inputPhoneNum}")
            val myIntent = Intent(Intent.ACTION_CALL, myUri)
            startActivity(myIntent)
        }

        dialBtn.setOnClickListener {
            val inputPhoneNum = phoneNumEdt.text.toString()
            val myUri = Uri.parse("tel:${inputPhoneNum}")
            val myIntent = Intent(Intent.ACTION_DIAL, myUri)
            startActivity(myIntent)
        }

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

    //    결과를 알아올때 실행되는 함수 - 오버라이딩
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

//        requestCode를 우선검사 => 뭘가지러 닉네임을 가지러 다녀온건지 확인
        if (requestCode == REQ_FOR_NICKNAME) {
//            닉네임 변경은 확인을 눌렀을때만 하고 싶다
//            확인이 눌렀는지? resultCode의 값이 RESULT_OK와 같은지
            if (resultCode == Activity.RESULT_OK) {

//                돌아올때 들고온 새 닉네임을 txt에 반영 : data
                val newNickName = data?.getStringExtra("newNickName")

                nickNameTxt.text = newNickName

            }
        }

    }

}