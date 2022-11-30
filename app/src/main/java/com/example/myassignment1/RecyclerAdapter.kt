package com.example.myassignment1


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.myassignmenttask.UserDetails

class RecyclerAdapter(val context: Context, val userList: ArrayList<UserDetails>) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    inner class ViewHolder(val v: View) : RecyclerView.ViewHolder(v) {
        var userName: TextView
        var userId: TextView
        var emailId: TextView

        init {

            userName = v.findViewById(R.id.tv_UserName)
            userId = v.findViewById(R.id.tv_id)
            emailId = v.findViewById(R.id.tv_emailid)


        }
    }

    override fun onBindViewHolder(holder:ViewHolder, position: Int) {
        val newList = userList[position]
        holder.userName.text = newList.UserName
        holder.userId.text = newList.Userid
        holder.emailId.text = newList.emailId
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.list_item, parent, false)
        return ViewHolder(v)

    }
}

