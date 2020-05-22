package com.example.pandemicpack

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_idea_to_do.*
import java.util.*

class IdeaToDo : AppCompatActivity() {
    val Idealist = arrayListOf(
        "Play Boardgame",
        "Make A Tik Tok Video",
        "Learn music instrument",
        "Watch Netflix",
        "Clean Your Room",
        "Start Gardening"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_idea_to_do)
/**
        decidebtn.setOnClickListener {

            val random = Random()
            val randomFood = random.nextInt(Idealist.count())
            selectedIdeatxt.text = Idealist[randomFood]

        }
        addIdeaBtn.setOnClickListener {
            val newFood = addIdeatxt.text.toString()
            Idealist.add(newFood)
            addIdeatxt.text.clear()
        }
        **/
        val context = this
        val db = DataBaseHandler(context)
        addIdeaBtn.setOnClickListener {
            if (addIdeatxt.text.toString().isNotEmpty()) {
                val idea = Idea()
                idea.colIdeas=addIdeatxt.text.toString()
                db.insertData(idea)
                clearField()
            }
            else {
                Toast.makeText(context, "Please fill the field first", Toast.LENGTH_SHORT).show()
            }
        }
        decidebtn.setOnClickListener {
            var data = db.readData()
            if (data.size ==0){
                val Idealist = arrayListOf(
                    "Play Boardgame",
                    "Make A Tik Tok Video",
                    "Learn music instrument",
                    "Watch Netflix",
                    "Clean Your Room",
                    "Start Gardening"
                )
                for (i in Idealist){
                    val idea = Idea()
                    idea.colIdeas=i
                    db.insertData(idea)
                }
                data = db.readData()
                val random = Random()
                val randomID = random.nextInt(data.size)
                selectedIdeatxt.text = data[randomID].colIdeas

            } else {
                val random = Random()
                val randomID = random.nextInt(data.size)
                selectedIdeatxt.text = data[randomID].colIdeas
            }
        }
    }
    private fun clearField() {
        addIdeatxt.text.clear()

    }
}

