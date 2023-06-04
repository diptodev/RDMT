package com.excitedbroltd.rdmt

import android.app.AlertDialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.excitedbroltd.rdmt.di.application.DatabaseApplication
import com.excitedbroltd.rdmt.mvvm.MyViewModel
import com.excitedbroltd.rdmt.roomdatabase.MyViewModelFactory
import com.excitedbroltd.rdmt.roomdatabase.User
import com.excitedbroltd.rdmt.rvadapter.RecyclerListener
import com.excitedbroltd.rdmt.rvadapter.RecyclerViewAdapter
import javax.inject.Inject

class MainActivity : ComponentActivity(), RecyclerListener {
    private val TAG = "MainActivity"
    private lateinit var name: EditText
    private lateinit var age: EditText
    private lateinit var addUserBtn: Button
    private lateinit var dialog: AlertDialog.Builder
    private lateinit var myViewModel: MyViewModel
    private var id = 0

    @Inject
    lateinit var factory: MyViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.acitiviy_main)
        (application as DatabaseApplication).databaseComponent.inject(this)
        dialog = AlertDialog.Builder(this)
        myViewModel = ViewModelProvider(this, factory)[MyViewModel::class.java]
        val rv = findViewById<RecyclerView>(R.id.rv_view)
        val linearLayout = LinearLayoutManager(this)
        rv.layoutManager = linearLayout
        val myadapter = RecyclerViewAdapter(this)
        rv.adapter = myadapter
        name = findViewById(R.id.editTextText)
        age = findViewById(R.id.editTextNumber)
        addUserBtn = findViewById(R.id.button)
        addUserBtn.setOnClickListener {
            if (name.text.isNotEmpty() && age.text.isNotEmpty()) {
                if (addUserBtn.text.toString() == "Update") {
                    myViewModel.updatePerson(
                        User(
                            id,
                            name.text.toString(),
                            Integer.parseInt(age.text.toString())
                        )
                    )
                    addUserBtn.text = "Submit"
                } else {
                    myViewModel.addUser(
                        User(
                            0,
                            name.text.toString(),
                            Integer.parseInt(age.text.toString())
                        )
                    )
                }
                age.text.clear()
                name.text.clear()
            } else {
                Toast.makeText(this, "Fill all the field", Toast.LENGTH_SHORT).show()
            }
        }
        myViewModel.getUserdata().observe(this)
        {
            myadapter.setData(it)
            myadapter.notifyDataSetChanged()
        }
    }

    override fun onClick(user: User) {
        dialog.setTitle("Update or delete data")
            .setPositiveButton("Update") { dialog, _ ->
                updatePerson(user)
                dialog.dismiss()
            }
            .setNegativeButton("Delete") { dialog, _ ->
                deletePerson(user)
                dialog.dismiss()
            }
            .show()
            .setCancelable(true)
    }

    private fun deletePerson(user: User) {
        myViewModel.deletePerson(user)
        Toast.makeText(this, "Person Deleted", Toast.LENGTH_SHORT).show()
    }

    private fun updatePerson(user: User) {
        addUserBtn.text = "Update"
        age.setText(user.age.toString())
        name.setText(user.name)
        id = user.id
    }
}

