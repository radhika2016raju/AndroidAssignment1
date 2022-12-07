package com.example.myassignment1


import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myassignmenttask.UserDetails
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


@Suppress("DEPRECATION")
class ShowListActivity : AppCompatActivity() {

    private lateinit var preferenceManager: PreferenceManager
    private lateinit var pref: SharedPreferences
    private lateinit var addsBtn: FloatingActionButton
    private lateinit var recv: RecyclerView
    private lateinit var recyclerAdapter:UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.show_user_list)
        init()
        checkLogin()
        loadData()
    }

    private fun loadData() {
        val pref = getSharedPreferences(PREF_NAME, MODE_PRIVATE)
        val gson = Gson()
        val json = pref.getString("UserDetails", null)
        if (json != null) {
            val type: Type = object : TypeToken<ArrayList<UserDetails?>?>() {}.type
           userList = gson.fromJson<Any>(json, type) as ArrayList<UserDetails>
            Log.d("size", "${userList.size}")
            recyclerAdapter.notifyDataSetChanged()
        }
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.option_menus, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.logout -> displayAlertLogout()
        }
        return super.onOptionsItemSelected(item)

    }

    private fun displayAlertLogout() {
        val builder = AlertDialog.Builder(this)
        builder.setMessage(getString(R.string.do_you_really_want_to_logout))

        builder.setPositiveButton(getString(R.string.yes)) { dialog, which ->
            val editor: SharedPreferences.Editor = preferenceManager.editor
            editor.clear()
            editor.apply()
            val intent = Intent(
                applicationContext,
                LoginActivity::class.java
            )
            startActivity(intent)
            finish()
        }

        builder.setNegativeButton(getString(R.string.no)) { dialog, which ->
            dialog.dismiss()
        }
        builder.create().show()
    }

    private fun init() {
        preferenceManager = PreferenceManager(this)

        recv = findViewById(R.id.mRecycler)
        addsBtn = findViewById(R.id.addingBtn)


        addsBtn.setOnClickListener {

            val intent = Intent(this, AddUserDetailsActivity::class.java)
            startActivityForResult(intent, 100)

        }

        recyclerAdapter = UserAdapter(this, userList)
        recv.layoutManager = LinearLayoutManager(this)
        recv.adapter = recyclerAdapter

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 100) {
            recyclerAdapter.notifyDataSetChanged()
        }
    }

    private fun checkLogin() {
        if (!preferenceManager.isLogin()) {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onStop() {
        super.onStop()
    }
}





