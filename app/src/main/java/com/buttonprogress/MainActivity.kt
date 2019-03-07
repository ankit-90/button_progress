package com.buttonprogress

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_submit.setButtonListener(object : ProgressButton.OnButtonClickListener {
            override fun onButtonClick() {
                btn_submit.showLoading()
                Handler().postDelayed({
                    btn_submit.hideLoading()
                }, 2000)
            }

        })
    }
}
