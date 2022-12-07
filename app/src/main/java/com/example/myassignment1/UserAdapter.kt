package com.example.myassignment1


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.myassignmenttask.UserDetails

class UserAdapter() :
    RecyclerView.Adapter<UserAdapter.UserListViewHolder>() {

    var userList = ArrayList<UserDetails>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.list_item, parent, false)
        return UserListViewHolder(v)

    }

    override fun onBindViewHolder(holder: UserListViewHolder, position: Int) {
        val newList = userList[position]
        holder.userName.text = newList.userName
        holder.userId.text = newList.userId
        holder.emailId.text = newList.emailId
    }

    override fun getItemCount(): Int {
        return userList.size
    }


    inner class UserListViewHolder(val v: View) : RecyclerView.ViewHolder(v) {

        var userName: TextView = v.findViewById(R.id.tv_UserName)
        var userId: TextView = v.findViewById(R.id.tv_id)
        var emailId: TextView = v.findViewById(R.id.tv_email_id)
    }

}

