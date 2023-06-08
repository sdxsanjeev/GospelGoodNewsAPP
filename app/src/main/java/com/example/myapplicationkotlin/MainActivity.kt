package com.example.myapplicationkotlin

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.util.Log
import android.widget.EditText

class MainActivity : AppCompatActivity() {
     private var  a:Int = 0
     private var b: Int = 0
    private lateinit var button:Button
    private lateinit var textView:TextView
    private lateinit var textView3: TextView
    private lateinit var InputTextView:EditText
    private lateinit var retrievePrevGospelNews:Button
    private lateinit var sharedPreference:SharedPreferences
    private lateinit var editor:SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.e("TAG","onCreate is called ")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initialize()

    }
    private fun initialize(){

        button=findViewById(R.id.button1)
        retrievePrevGospelNews=findViewById(R.id.button2)
        textView=findViewById(R.id.textView)
        InputTextView=findViewById(R.id.InputEditText)

        button.setOnClickListener {
            textView.text = Save(InputTextView.text.toString()).toString()
        }
        retrievePrevGospelNews.setOnClickListener {
            textView.text = Retrieve(InputTextView.text.toString())
        }
         sharedPreference = getSharedPreferences("MyGoodNewsGospel", MODE_PRIVATE)
    }

    private fun Save(StringToSave:String):String{

        val editor = sharedPreference.edit()
        return if(StringToSave!=""){
            editor.putString("firstNews",StringToSave)
            editor.commit()
            "Saved Successfully !!!"
        } else "Nothing to Save,Please enter some Good News !"

    }
    private fun Retrieve(key: String): String? {

        return sharedPreference.getString("firstNews", "")

    }
    private fun Response(a:Int):Int{

        if(a==0)
            return 1
        var fact:Int=1
        for(i in 1..a){
            fact *= i
        }
        return 3

    }

    private companion object{
        private const val TAG:String="MainActivity"
    }
}