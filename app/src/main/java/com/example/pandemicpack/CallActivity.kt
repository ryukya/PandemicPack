package com.example.pandemicpack

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_call.*


class CallActivity : AppCompatActivity() {
    internal  var nGen="112"
    internal  var nAmb="999"
    internal  var nFir="998"
    internal  var nPol="997"
    internal  var nEU="112"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_call)
        bGen.setOnClickListener {
            nGen = nGen.trim()
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + Uri.encode(nGen)))
            startActivity(intent)
        }

        bAmbu.setOnClickListener {
            var num = nAmb.trim()
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + Uri.encode(num)))
            startActivity(intent)
        }
        bFires.setOnClickListener {
            var num = nFir.trim()
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + Uri.encode(num)))
            startActivity(intent)
        }
        bPolices.setOnClickListener {
            var num = nPol.trim()
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + Uri.encode(num)))
            startActivity(intent)
        }
        bEuro.setOnClickListener {
            var num = nEU.trim()
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + Uri.encode(num)))
            startActivity(intent)
        }


        }
    }


