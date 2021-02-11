package com.rabi.manu.activity

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.rabi.manu.R
import com.rabi.manu.model.Card
import com.rabi.manu.observer.CardEvent
import com.rabi.manu.observer.MainViewModel
import com.rabi.manu.utils.*
import com.rsmstudio.android.kitty.adapter.MainAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var player: MediaPlayer
    private var activePlayer = false

    companion  object {
        var cakeFlg : Boolean = true
    }

    @ExperimentalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        hideStatusBar()
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        subscribeCardEventObservers()
        viewModel.registerForEvent(CardEvent.GetCardsEvent)
        mute_song.setOnClickListener { stopSong() }
    }

    override fun onStop() {
        super.onStop()
        stopSong()
    }

    override fun onStart() {
        super.onStart()
        hideStatusBar()
    }

    private fun subscribeCardEventObservers() {
        view_pager.setPageTransformer(DefaultTransformer())
        view_pager.orientation = ViewPager2.ORIENTATION_VERTICAL
        viewModel.cards.observe(this, {
            when(it){
                is DataState.Success<List<Card>> -> setCardAdapter(it.data)
                is DataState.Error -> {}
                is DataState.Loading ->{}
            }
        })
    }

    private fun setCardAdapter(list : List<Card>){
        if(list.isNotEmpty()){
            viewModel.cards.observe(this, {
                view_pager.adapter = MainAdapter(this,list){ action, _ ->
                    when(action){
                        "input_disable" -> view_pager.isUserInputEnabled = false
                        "input_enable" -> view_pager.isUserInputEnabled = true
                        "start_song" -> startSong()
                    }

                }
            })
        }
    }


    private fun startSong() {

        GlobalScope.launch(Dispatchers.Main){
            mute_song.visible(PUSH_LEFT_IN)
            player = MediaPlayer.create(this@MainActivity, R.raw.happy_bday_many_people_voice)
            player.isLooping = false // Set looping
            player.setVolume(100F,100F)
            if(player.isPlaying) player.stop()
            player.start()
            activePlayer = player.isPlaying
            view_pager.isUserInputEnabled = true
            player.setOnCompletionListener {
                stopSong()
            }
        }.start()

    }

    private fun stopSong() {
        if(activePlayer){
            mute_song.invisible(PUSH_RIGHT_OUT)
            activePlayer = false
            player.stop()
            player.release()
        }
    }


}

