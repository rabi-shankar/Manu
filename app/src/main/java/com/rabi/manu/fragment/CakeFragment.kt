package com.rabi.manu.fragment

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.os.PowerManager
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.rabi.manu.R
import com.rabi.manu.activity.MainActivity
import com.rabi.manu.model.Card
import com.rabi.manu.utils.hideStatusBar
import com.rabi.manu.utils.AudioSensor
import kotlinx.android.synthetic.main.cake_card_layout.*
import kotlinx.android.synthetic.main.cake_card_layout.view.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import nl.dionsegijn.konfetti.models.Shape
import nl.dionsegijn.konfetti.models.Size


class CakeFragment (private var card: Card, val action :(String, Any?) -> Unit) : Fragment(R.layout.cake_card_layout){

    private var actionDuration: Long = 0
    private var isSensorActive = false

    //config state
    private var mThreshold = 6
    private lateinit var mWakeLock: PowerManager.WakeLock
    private lateinit var mSensor : AudioSensor

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        hideStatusBar()
        mSensor = AudioSensor()
        val powerManager = context?.getSystemService(Context.POWER_SERVICE) as PowerManager
        mWakeLock = powerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "CakeFragment:NoiseAlert")
        cake_view.setImageResource(R.drawable.on_cake_candle_gif_m)
    }

    override fun onStart() {
        super.onStart()
        hideStatusBar()
    }
    override fun onResume() {
        super.onResume()
        when(isSensorActive){
            false -> startSensor()
        }
        if(MainActivity.cakeFlg){
            action("input_disable",null)
            MainActivity.cakeFlg = false
        }
    }



    override fun onStop() {
        super.onStop()
        stopSensor()
    }

    private fun startSensor(){
        isSensorActive = true
        GlobalScope.launch (Dispatchers.Main){
            mSensor.start()
            if (!mWakeLock.isHeld) {
                mWakeLock.acquire(10*60*1000L /*10 minutes*/)
            }
            while (isSensorActive){
                if (mSensor.getAmplitude() > mThreshold) initVisual()
                delay(300L)
            }
        }.start()
    }

    private fun stopSensor(){
        if (mWakeLock.isHeld) mWakeLock.release()
        mSensor.stop()
        isSensorActive = false
    }

    private suspend  fun initVisual() {
        if (actionDuration + 400 > System.currentTimeMillis()) {
            stopSensor()
            action("start_song",null)
            cake_view.setImageResource(R.drawable.on_to_off_cake_gif_m)
            streamFromTop()
            delay(3600)
            try{
                cake_view.setImageResource(card.imageResId)
            }catch (e: KotlinNullPointerException){
                Log.e("TAB","${e.stackTrace}")
            }

            if(MainActivity.cakeFlg){
                action("input_enable",null)
                MainActivity.cakeFlg = false
            }
        }
        actionDuration = System.currentTimeMillis()
    }



    private fun streamFromTop() {
        viewKonfetti.build()
            .addColors(Color.YELLOW, Color.GREEN, Color.MAGENTA)
            .setDirection(0.0, 359.0)
            .setSpeed(1f, 5f)
            .setFadeOutEnabled(true)
            .setTimeToLive(1500L)
            .addShapes(Shape.Square, Shape.Circle)
            .addSizes(Size(12))
            .setPosition(-50f, view!!.viewKonfetti.width + 50f, -50f, -50f)
            .streamFor(150, 4000L)
    }
}