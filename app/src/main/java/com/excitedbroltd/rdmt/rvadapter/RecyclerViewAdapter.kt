package com.excitedbroltd.rdmt.rvadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.excitedbroltd.rdmt.R
import com.excitedbroltd.rdmt.roomdatabase.User

class RecyclerViewAdapter() :
    RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {
    private var listItem = emptyList<User>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_itm, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount() = listItem.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val user = listItem[position]
        holder.id.text = (1 + position).toString()
        holder.name.text = user.name
        holder.age.text = user.age.toString()
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val id = itemView.findViewById<TextView>(R.id.rv_id)
        val name = itemView.findViewById<TextView>(R.id.rv_name)
        val age = itemView.findViewById<TextView>(R.id.rv_age)

        val linearLayout = itemView.findViewById<LinearLayout>(R.id.ll_listItem)
    }

    fun setData(listItem: List<User>) {
        this.listItem = listItem
    }
}
