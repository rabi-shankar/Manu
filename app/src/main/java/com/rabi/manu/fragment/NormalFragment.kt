package com.rsmstudio.android.kitty.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.rabi.manu.utils.load
import com.rabi.manu.R
import com.rabi.manu.model.Card
import com.rabi.manu.utils.hideStatusBar
import com.rabi.manu.utils.visible
import kotlinx.android.synthetic.main.normal_card_layout.*

class NormalFragment (private var card: Card) : Fragment(R.layout.normal_card_layout){

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        hideStatusBar()
        if(card.isOnline){
            rest_image.visible()
            rest_image.load(card.imageId)
        }else{
            animation_image.visible()
            animation_image.setImageResource(card.imageResId)
        }
    }

    override fun onStart() {
        super.onStart()
        hideStatusBar()
    }
}