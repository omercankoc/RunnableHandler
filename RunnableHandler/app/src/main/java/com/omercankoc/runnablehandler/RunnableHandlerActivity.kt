package com.omercankoc.runnablehandler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class RunnableHandlerActivity : AppCompatActivity() {

    private lateinit var textViewTime : TextView
    private lateinit var buttonStart : Button
    private lateinit var buttonStop : Button

    private var time : Int = 0
    private var hour : Int = 0
    private var minute : Int = 0
    private var second : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_runnable_handler)

        textViewTime = findViewById(R.id.textViewTime)
        buttonStart = findViewById(R.id.buttonStart)
        buttonStop = findViewById(R.id.buttonStop)
    }

    private fun timer(time: Int){

        var second : Int = time
        var minute : Int = second / 60
        second %= 60
        val hour : Int = minute / 60
        minute %= 60

        if(second < 10 && minute < 10 && hour < 10){
            textViewTime.text = "0$hour:0$minute:0$second"
        } else if(second < 10 && minute < 10 && hour >= 10){
            textViewTime.text = "$hour:0$minute:0$second"
        } else if(second < 10 && minute >= 10 && hour < 10){
            textViewTime.text = "0$hour:$minute:0$second"
        } else if(second >= 10 && minute < 10 && hour < 10){
            textViewTime.text = "0$hour:0$minute:$second"
        } else if(second >= 10 && minute >= 10 && hour < 10){
            textViewTime.text = "0$hour:$minute:$second"
        } else if(second < 10 && minute >= 10 && hour >= 10){
            textViewTime.text = "$hour:$minute:0$second"
        } else if(second >= 10 && minute < 10 && hour >= 10){
            textViewTime.text = "$hour:0$minute:$second"
        } else if(second >= 10 && minute >= 10 && hour >= 10){
            textViewTime.text = "$hour:$minute:$second"
        }
    }

    fun start(view : View){

    }

    fun stop(view : View){

    }
}