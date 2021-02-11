package com.rabi.manu.repo

import com.rabi.manu.R
import com.rabi.manu.model.Card
import com.rabi.manu.utils.*

class Data {

    fun get() : MutableList<Card>{
        val cards  = mutableListOf<Card>()

        Card(type = NORMAL_CARD).apply{
            imageResId = R.raw.hello_manisha
            isOnline = false
        }.also{ cards.add(it) }

        Card(type = NORMAL_CARD).apply{
            imageResId = R.raw.happy_bithday_wish
            isOnline = false
        }.also{ cards.add(it) }

        Card(type = NORMAL_CARD).apply{
            imageResId = R.drawable.now_cake_time
            isOnline = false
        }.also{ cards.add(it) }

        Card(type = NORMAL_CARD).apply{
            imageResId = R.raw.blow_air
            isOnline = false
        }.also{ cards.add(it) }


        Card(type = CAKE_CARD).apply{
            imageResId = R.drawable.off_cake_candle_m
        }.also{ cards.add(it) }


        Card(type = NORMAL_CARD).apply{
            imageId = R.raw.mn3
        }.also{ cards.add(it) }


        Card(type = NORMAL_CARD).apply{
            imageId = R.drawable.m1
        }.also{ cards.add(it) }

        Card(type = NORMAL_CARD).apply{
            imageId = R.raw.mm1
        }.also{ cards.add(it) }

        Card(type = NORMAL_CARD).apply{
            imageId = R.drawable.m2
        }.also{ cards.add(it) }


        Card(type = NORMAL_CARD).apply{
            imageId = R.drawable.m3
        }.also{ cards.add(it) }


        Card(type = NORMAL_CARD).apply{
            imageId = R.raw.mm6
        }.also{ cards.add(it) }


        Card(type = NORMAL_CARD).apply{
            imageId = R.drawable.m5
        }.also{ cards.add(it) }


        Card(type = NORMAL_CARD).apply{
            imageId = R.drawable.m6
        }.also{ cards.add(it) }

        Card(type = NORMAL_CARD).apply{
            imageId = R.raw.mmnmn
        }.also{ cards.add(it) }

        Card(type = NORMAL_CARD).apply{
            imageId = R.drawable.m7
        }.also{ cards.add(it) }


        Card(type = NORMAL_CARD).apply{
            imageId = R.drawable.m8
        }.also{ cards.add(it) }


        Card(type = NORMAL_CARD).apply{
            imageId = R.drawable.m9
        }.also{ cards.add(it) }


        Card(type = NORMAL_CARD).apply{
            imageId = R.drawable.m10
        }.also{ cards.add(it) }


        Card(type = NORMAL_CARD).apply{
            imageId = R.drawable.m11
        }.also{ cards.add(it) }


        Card(type = NORMAL_CARD).apply{
            imageId = R.drawable.m12
        }.also{ cards.add(it) }


        Card(type = NORMAL_CARD).apply{
            imageId = R.drawable.m13
        }.also{ cards.add(it) }


        Card(type = NORMAL_CARD).apply{
            imageId = R.drawable.m14
        }.also{ cards.add(it) }


        Card(type = NORMAL_CARD).apply{
            imageId = R.drawable.m15
        }.also{ cards.add(it) }


        Card(type = NORMAL_CARD).apply{
            imageId = R.drawable.m16
        }.also{ cards.add(it) }


        Card(type = NORMAL_CARD).apply{
            imageId = R.drawable.m17
        }.also{ cards.add(it) }

        Card(type = NORMAL_CARD).apply{
            imageId = R.drawable.m18
        }.also{ cards.add(it) }


        Card(type = NORMAL_CARD).apply{
            imageId = R.drawable.m19
        }.also{ cards.add(it) }


        Card(type = NORMAL_CARD).apply{
            imageId = R.drawable.mm5
        }.also{ cards.add(it) }

        Card(type = NORMAL_CARD).apply{
            imageId = R.drawable.mm6
        }.also{ cards.add(it) }


        Card(type = NORMAL_CARD).apply{
            imageId = R.drawable.m4
        }.also{ cards.add(it) }

        return cards
    }
}