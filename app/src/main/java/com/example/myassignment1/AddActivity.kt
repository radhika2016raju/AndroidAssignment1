package com.example.myassignment1

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class AddActivity : AppCompatActivity() {
    private lateinit var addsBtn: FloatingActionButton
    private lateinit var recv: RecyclerView


    // private latent var userList:ArrayList<UserDetails>
    private lateinit var recyclerAdapter: RecyclerAdapter

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adduser)

        // userList = ArrayList()

        recv = findViewById(R.id.mRecycler)
        addsBtn = findViewById(R.id.addingBtn)

        addsBtn.setOnClickListener {
            val intent = Intent(this, AddItemActivity::class.java)
            startActivity(intent)
        }

        recyclerAdapter = RecyclerAdapter(this, userList)

        recv.layoutManager = LinearLayoutManager(this)
        recv.adapter = recyclerAdapter
        recyclerAdapter.notifyDataSetChanged()

        Toast.makeText(this, "Adding User Information Success", Toast.LENGTH_SHORT).show()

    }
}


