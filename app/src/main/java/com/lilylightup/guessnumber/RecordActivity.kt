package com.lilylightup.guessnumber

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.Room
import com.lilylightup.guessnumber.data.GameDatabase
import com.lilylightup.guessnumber.data.Record
import kotlinx.android.synthetic.main.activity_record.*

class RecordActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_record)
        val count = intent.getIntExtra("COUNTER", -1)
        counter.setText(count.toString())
        //OnClickListener
        save.setOnClickListener { view ->
            val nick = nicknam.text.toString()
            getSharedPreferences("Guess", Context.MODE_PRIVATE)
                .edit()
                .putInt("REC_COUNT", count)
                .putString("REC_NICKNAME", nick)
                .apply()
            //insect to Room
            Thread() {
                GameDatabase.getInstance(this)?.recordDao()?.insert(Record(nick, count))
            }.start()

            val intent = Intent()
            intent.putExtra("NICK", nick)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}
