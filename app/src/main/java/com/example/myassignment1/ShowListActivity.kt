package com.example.myassignment1

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ShowListActivity : AppCompatActivity() {
    private lateinit var addsBtn: FloatingActionButton
    private lateinit var recv: RecyclerView
    private lateinit var recyclerAdapter: RecyclerAdapter

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.show_user_list)
        recv = findViewById(R.id.mRecycler)
        addsBtn = findViewById(R.id.addingBtn)

        addsBtn.setOnClickListener {
            val intent = Intent(this, AddUserDetailsActivity::class.java)
            startActivity(intent)
        }

        recyclerAdapter = RecyclerAdapter(this, userList)

        recv.layoutManager = LinearLayoutManager(this)
        recv.adapter = recyclerAdapter
        recyclerAdapter.notifyDataSetChanged()

        Toast.makeText(this, getString(R.string.adding_user_information_success), Toast.LENGTH_SHORT).show()

    }
}


