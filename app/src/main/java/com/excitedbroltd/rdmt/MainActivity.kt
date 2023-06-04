package com.excitedbroltd.rdmt

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.excitedbroltd.rdmt.mvvm.MyViewModel
import com.excitedbroltd.rdmt.roomdatabase.MyViewModelFactory
import com.excitedbroltd.rdmt.rvadapter.RecyclerViewAdapter

class MainActivity : ComponentActivity() {
    private val TAG = "MainActivity"
    private lateinit var name: EditText
    private lateinit var age: EditText
    private lateinit var addUserBtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.acitiviy_main)
        val factory = MyViewModelFactory(this)
        val myViewModel = ViewModelProvider(this, factory)[MyViewModel::class.java]
        val rv = findViewById<RecyclerView>(R.id.rv_view)
        val linearLayout = LinearLayoutManager(this)
        rv.layoutManager = linearLayout
        val myadapter = RecyclerViewAdapter()
        rv.adapter = myadapter
        name = findViewById(R.id.editTextText)
        age = findViewById(R.id.editTextNumber)
        addUserBtn = findViewById(R.id.button)
        addUserBtn.setOnClickListener {
            myViewModel.addUser(0, name.text.toString(), age.text.toString())
        }
        myViewModel.getUserdata().observe(this) {
            myadapter.setData(it)
            myadapter.notifyDataSetChanged()
        }
    }
}

