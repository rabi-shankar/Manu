package com.rabi.manu.observer

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rabi.manu.model.Card
import com.rabi.manu.repo.MainRepository
import com.rabi.manu.utils.DataState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class MainViewModel : ViewModel(){

    val repo = MainRepository()

    private val _cards: MutableLiveData<DataState<List<Card>>> = MutableLiveData()
    val cards: LiveData<DataState<List<Card>>>
        get() = _cards



    @ExperimentalCoroutinesApi
    fun registerForEvent(introductionStateEvent: CardEvent){
        viewModelScope.launch {
            when(introductionStateEvent){
               is CardEvent.GetCardsEvent -> {
                    repo.getCards().onEach {
                        _cards.value = it
                    }.launchIn(viewModelScope)
                }

                CardEvent.None -> {
                    // who cares
                }
            }
        }
    }

}


sealed class CardEvent{
    object GetCardsEvent: CardEvent()
    object None: CardEvent()
}
