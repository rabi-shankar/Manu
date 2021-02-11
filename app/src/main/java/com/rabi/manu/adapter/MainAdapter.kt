package com.rsmstudio.android.kitty.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.rabi.manu.model.Card
import com.rabi.manu.utils.CAKE_CARD
import com.rabi.manu.fragment.CakeFragment
import com.rsmstudio.android.kitty.fragment.NormalFragment

class MainAdapter(fragment: FragmentActivity, private val cards: List<Card>,
                  private val action :(String , Any?) ->Unit) : FragmentStateAdapter(fragment) {
    override fun getItemCount() = cards.size
    override fun createFragment(position: Int): Fragment {
        val card = cards[position]
        card.position = position

        return when(card.type){
            CAKE_CARD-> CakeFragment(card,action)
            else -> NormalFragment(card)

        }


    }

}