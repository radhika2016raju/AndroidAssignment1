package com.example.myassignment1


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ShowListActivity : AppCompatActivity() {
    private lateinit var addsBtn: FloatingActionButton
    private lateinit var recv: RecyclerView
    private lateinit var recyclerAdapter: RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.show_user_list)

        recv = findViewById(R.id.mRecycler)
        addsBtn = findViewById(R.id.addingBtn)

        addsBtn.setOnClickListener {

            val intent = Intent(this, AddUserDetailsActivity::class.java)
            startActivityForResult(intent, 100)

        }

        recyclerAdapter = RecyclerAdapter(this, userList)
        recv.layoutManager = LinearLayoutManager(this)
        recv.adapter = recyclerAdapter

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 100) {
            recyclerAdapter.notifyDataSetChanged()
        }
    }
}


