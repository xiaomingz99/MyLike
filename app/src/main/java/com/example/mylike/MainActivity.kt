package com.example.mylike

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var countLike: Int=0
    private var countDislike: Int=0
    private lateinit var sharedPreferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("MainActivity","onCreate")
        //Initialize shared preferences
        sharedPreferences = getPreferences(Context.MODE_PRIVATE)



        imageViewUp.setOnClickListener {
            countLike++
            textViewUp.text = countLike.toString()
        }

        imageViewDown.setOnClickListener {
            countDislike++
            textViewDown.text = countDislike.toString()
        }

    }

    override fun onStart() {
        Log.d("MainActivity","onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.d("MainActivity","onResume")
        //Retrieve the stored values
        countLike = sharedPreferences.getInt(getString(R.string.like), 0)
        countDislike = sharedPreferences.getInt(getString(R.string.dislike), 0)
        textViewUp.text = countLike.toString()
        textViewDown.text = countDislike.toString()

        super.onResume()
    }

    override fun onStop() {
        Log.d("MainActivity","onStop")
        super.onStop()
    }

    override fun onPause() {
        Log.d("MainActivity","onPause")
        with(sharedPreferences.edit()){
            putInt(getString(R.string.like),countLike)
            putInt(getString(R.string.dislike),countDislike)
            commit()
        }

        super.onPause()
    }

    override fun onDestroy() {
        Log.d("MainActivity","onDestroy")
        super.onDestroy()
    }



}
