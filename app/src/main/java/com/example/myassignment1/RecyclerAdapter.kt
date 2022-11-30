package com.example.myassignment1


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.myassignmenttask.UserDetails

class RecyclerAdapter(val context: Context, private val userList: ArrayList<UserDetails>) :
    RecyclerView.Adapter<RecyclerAdapter.ListViewHolder>() {
    inner class ListViewHolder(val v: View) : RecyclerView.ViewHolder(v) {
        var username: TextView = v.findViewById(R.id.tv_UserName)
        var userid: TextView = v.findViewById(R.id.tv_id)
        var email: TextView

        init {
            email = v.findViewById(R.id.tv_emailid)


        }
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val newList = userList[position]
        holder.username.text = newList.Username
        holder.userid.text = newList.Userid
        holder.email.text = newList.email
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.list_item, parent, false)
        return ListViewHolder(v)

    }
}

