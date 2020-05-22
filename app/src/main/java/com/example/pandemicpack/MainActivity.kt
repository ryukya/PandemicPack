package com.example.pandemicpack

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        RQna.setOnClickListener {
            val intent = Intent(this, QnA::class.java)
            startActivity(intent)
        }
        RGrap.setOnClickListener {
            val intent = Intent(this, LiveGraph::class.java)
            startActivity(intent)
        }
        RCall.setOnClickListener {
            val intent = Intent(this, CallActivity::class.java)
            startActivity(intent)
        }
        RAct.setOnClickListener {
            val intent = Intent(this, IdeaToDo::class.java)
            startActivity(intent)
        }
        RHealt.setOnClickListener {
            val intent = Intent(this, HealthCheck::class.java)
            startActivity(intent)
        }
        RCrowd.setOnClickListener {
            val intent = Intent(this, CrowdActivity::class.java)
            startActivity(intent)
        }
        ibtn.setOnClickListener{
            showDialog()
        }
    }
    private fun showDialog(){
        lateinit var dialog: AlertDialog
        val builder = AlertDialog.Builder(this)
        builder.setTitle("About")
        builder.setMessage("Pandemic Package is an app with multiple features to help you -> " +
                "get the latest COVID info and graph, get ideas in quarantine, check your body fit, " +
                "emergency call and traffic info around you for pysichal distancing. ")


        dialog = builder.create()
        dialog.show()
    }
}
