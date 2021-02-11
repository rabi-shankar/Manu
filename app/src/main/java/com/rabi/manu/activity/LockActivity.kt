package com.rabi.manu.activity

import android.content.Intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.rabi.manu.R
import com.rabi.manu.utils.hideStatusBar
import kotlinx.android.synthetic.main.activity_lock.*

class LockActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lock)
        hideStatusBar()
        val password = "8762"
        unlock_btn.setOnClickListener {
            val key =lock_key.text.toString()
            if(key.length == 4 && key  == password ){
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }else {
                Toast.makeText(this,"Wrong Password!",Toast.LENGTH_SHORT).show()
                lock_key.text.clear()
            }

        }
    }

    override fun onStart() {
        super.onStart()
        hideStatusBar()
    }
}