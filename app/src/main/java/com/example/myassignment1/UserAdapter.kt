package com.example.myassignment1


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.myassignmenttask.UserDetails

class UserAdapter(val c: Context, val userList1: ArrayList<UserDetails>) :
    RecyclerView.Adapter<UserAdapter.UserListViewHolder>() {

    inner class UserListViewHolder( v: View) : RecyclerView.ViewHolder(v) {
        var userName: TextView
        var userId: TextView
        var emailId: TextView
        private var deleteUser: ImageView

        init {
            userName = v.findViewById(R.id.tv_UserName)
            userId = v.findViewById(R.id.tv_id)
            emailId = v.findViewById(R.id.tv_email_id)
            deleteUser = v.findViewById(R.id.delete_user)
            deleteUser.setOnClickListener { deleteUserInformation() }
        }

        private fun deleteUserInformation() {

            val v = LayoutInflater.from(c).inflate(R.layout.list_item, null)

            AlertDialog.Builder(c)
                .setTitle(c.getString(R.string.delete))
                .setMessage(c.getString(R.string.are_you_sure_delete_this_information))
                .setPositiveButton(c.getString(R.string.yes)) { dialog, _ ->
                    userList.removeAt(adapterPosition)
                    notifyDataSetChanged()
                    Toast.makeText(c, c.getString(R.string.information_deleted), Toast.LENGTH_SHORT)
                        .show()
                    dialog.dismiss()
                }
                .setNegativeButton(c.getString(R.string.no)) { dialog, _ ->
                    dialog.dismiss()
                }
                .create()
                .show()
        }
    }


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

}

