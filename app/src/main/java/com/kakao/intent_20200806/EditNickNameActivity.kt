package com.kakao.intent_20200806

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit_nick_name.*

class EditNickNameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_nick_name)

        okBtn.setOnClickListener {

//            완료버튼-복귀:finish()
//            백버튼을 눌러서 종료하는 것과 구별해야 함
            val resultIntent = Intent()

//           입력된 닉네임 : putExtra
            val inputNickName = edtNickName.text.toString()
            resultIntent.putExtra("newNickName", inputNickName)

//            OK버튼을 눌렀다고 명시 + 데이터를 담고 있는 resultIntent
            setResult(Activity.RESULT_OK, resultIntent)

            finish()
        }
    }
}