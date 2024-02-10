package com.example.newnoteapp

import android.content.Intent
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlin.math.floor

class MainActivity : AppCompatActivity() {
    lateinit var notes: Array<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        notes = resources.getStringArray(R.array.Notes)

        val recyclerView = findViewById<View>(R.id.rvNotes) as RecyclerView
        val Addbutton=findViewById<FloatingActionButton>(R.id.fab)
        Addbutton.setOnClickListener {
            val Intent=Intent(this,MainActivity3::class.java)
            startActivity(Intent)
        }

        val layoutManager : RecyclerView.LayoutManager = GridLayoutManager(this, span())

        recyclerView.itemAnimator = DefaultItemAnimator()

        recyclerView.layoutManager = layoutManager

        val adapter : RecyclerView.Adapter<*> = CardAdapter(this, notes)

        recyclerView.adapter = adapter

        Toast.makeText(this@MainActivity,"Hello World",Toast.LENGTH_SHORT).show()


    }
    private fun span() : Int{
        val screenWidth = Resources.getSystem().displayMetrics.widthPixels
        val cardDimen = resources.getDimension(R.dimen.cardview)
        return floor((screenWidth/cardDimen).toDouble()).toInt()
    }
}