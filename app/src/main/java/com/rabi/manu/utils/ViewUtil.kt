package com.rabi.manu.utils

import android.view.View
import android.view.animation.AnimationUtils
import com.rabi.manu.R


const val PUSH_DOWN_IN = R.anim.push_down_in
const val PUSH_DOWN_OUT = R.anim.push_down_out
const val PUSH_LEFT_IN =  R.anim.push_left_in
const val PUSH_LEFT_OUT = R.anim.push_left_out
const val PUSH_RIGHT_IN = R.anim.push_right_in
const val PUSH_RIGHT_OUT = R.anim.push_right_out
const val PUSH_UP_IN = R.anim.push_up_in
const val PUSH_UP_OUT = R.anim.push_up_out

fun View.gone(animationName :Int = 0){
    if(visibility != View.GONE   || visibility == View.VISIBLE) {
        visibility = View.GONE
        animation(animationName)
    }
}

fun View?.invisible(animationName :Int = 0) {

    if(this?.visibility == View.VISIBLE) {
        visibility = View.INVISIBLE
        animation(animationName)
    }
}

fun View.visible(animationName :Int = 0){
    if(visibility == View.INVISIBLE || visibility == View.GONE) {
        visibility = View.VISIBLE
        animation(animationName)
    }
}

fun View.animation(animationName :Int = 0){
    if(animationName != 0) when(animationName) {
        PUSH_DOWN_IN -> animPushDownIn()
        PUSH_DOWN_OUT -> animPushDownOut()
        PUSH_LEFT_IN -> animPushLeftIn()
        PUSH_LEFT_OUT -> animPushLeftOut()
        PUSH_RIGHT_IN -> animPushRightIn()
        PUSH_RIGHT_OUT -> animPushRightOut()
        PUSH_UP_IN -> animPushUpIn()
        PUSH_UP_OUT -> animPushUpOut()
    }
}


fun View.animPushDownIn(){
    startAnimation(AnimationUtils.loadAnimation(context!!.applicationContext, PUSH_DOWN_IN))
}

fun View.animPushDownOut(){
    startAnimation(AnimationUtils.loadAnimation(context!!.applicationContext, PUSH_DOWN_OUT ))
}

fun View.animPushLeftIn(){
    startAnimation(AnimationUtils.loadAnimation(context!!.applicationContext, PUSH_LEFT_IN))
}

fun View.animPushLeftOut(){
    startAnimation(AnimationUtils.loadAnimation(context!!.applicationContext, PUSH_LEFT_OUT))
}

fun View.animPushRightIn(){
    startAnimation(AnimationUtils.loadAnimation(context!!.applicationContext, PUSH_RIGHT_IN ))
}

fun View.animPushRightOut(){
    startAnimation(AnimationUtils.loadAnimation(context!!.applicationContext, PUSH_RIGHT_OUT ))
}

fun View.animPushUpIn(){
    startAnimation(AnimationUtils.loadAnimation(context!!.applicationContext, PUSH_UP_IN))
}

fun View.animPushUpOut(){
    startAnimation(AnimationUtils.loadAnimation(context!!.applicationContext, PUSH_UP_OUT))
}
