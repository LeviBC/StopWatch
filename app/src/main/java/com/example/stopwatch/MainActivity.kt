package com.example.stopwatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.widget.Button
import android.widget.Chronometer
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.coroutines.NonCancellable.start

class MainActivity : AppCompatActivity() {
    //make a classwide static constant in kotlin
    companion object{
        //all your static constants go here
        val TAG = "MainActivity"

    }
    private lateinit var chronometer: Chronometer
    private lateinit var reset: Button
    private lateinit var startAndStop: Button
    private lateinit var constraint: ConstraintLayout
    private var working = false
    private var timeStopped = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate: ")
        wireWidgets()



        startAndStop.setOnClickListener{
            Log.d(TAG, "onCreate: button clicked")
            if(!working) {
                startAndStop.setText("Stop")
                chronometer.start()
                working = true
                chronometer.base = timeStopped + SystemClock.elapsedRealtime()

            }
            else{
                startAndStop.setText("Start")
                chronometer.stop()
                working = false
                timeStopped = (chronometer.base - SystemClock.elapsedRealtime()).toInt()
            }
            reset.setOnClickListener {
                chronometer.base = SystemClock.elapsedRealtime()
                chronometer.stop()
                startAndStop.setText("Start")

            }
        }


    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: ")



    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: ")
    }

    override fun onPause() {
        super.onPause()

        Log.d(TAG, "onPause: ")

    }

    override fun onStop() {
        super.onStop()

        Log.d(TAG, "onStop: ")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d(TAG, "onDestroy: ")
    }
    private fun wireWidgets(){
        chronometer = findViewById(R.id.chronometer_main_stopwatch)
        reset = findViewById(R.id.button_main_reset)
        startAndStop = findViewById(R.id.button_main_startAndStop)
        constraint = findViewById(R.id.constraint_main_layout)
    }
}