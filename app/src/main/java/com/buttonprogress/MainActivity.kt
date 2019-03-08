package com.buttonprogress

import android.graphics.PorterDuff
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_submit.setText("Start")
        btn_submit.setButtonListener(object : ProgressButton.OnButtonClickListener {
            override fun onButtonClick() {
                btn_submit.showLoading()
                Handler().postDelayed({
                    btn_submit.hideLoading()
                    btn_submit.setText("End")
                    btn_submit.setTextColor(R.color.white)
                }, 2000)
            }
        })
    }
}
