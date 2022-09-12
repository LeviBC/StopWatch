package com.example.stopwatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.sax.StartElementListener
import android.util.Log
import android.widget.Button
import android.widget.Chronometer
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    //make a classwide static constant in kotlin
    companion object{
        //all your static constants go here
        val TAG = "MainActivity"
    }
    private lateinit var chronometer: Chronometer
    private lateinit var stop: Button
    private lateinit var start:Button
    private lateinit var constraint: ConstraintLayout



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate: ")
        wireWidgets()
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: ")
    }

    override fun onResume() {
        super.onResume()
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onResume: ")
    }

    override fun onPause() {
        super.onPause()
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onPause: ")
    }

    override fun onStop() {
        super.onStop()
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onStop: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onDestroy: ")
    }
    private fun wireWidgets(){
        chronometer = findViewById(R.id.chronometer_main_stopwatch)
        stop = findViewById(R.id.button_main_stop)
        start = findViewById(R.id.button_main_start)
        constraint = findViewById(R.id.constraint_main_layout)
    }
}