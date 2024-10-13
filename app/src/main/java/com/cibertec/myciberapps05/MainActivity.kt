package com.cibertec.myciberapps05

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import com.cibertec.myciberapps05.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val result =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->

        }

    private lateinit var binding: ActivityMainBinding
    private lateinit var database: MyDatabase
    private lateinit var adapter: ItemTaskAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database = MyDatabase.getDatabase(this)
        adapter = ItemTaskAdapter()

        binding.listTask.layoutManager = LinearLayoutManager(this)
        binding.listTask.adapter = adapter

        binding.fabAddTask.setOnClickListener {
            val intent = Intent(this, NewTaskActivity::class.java)
            result.launch(intent)
        }

        loadAllTask()
    }

    private fun loadAllTask() {
        val taskList = database.taskDao().getAllTasks()
        adapter.addItems(taskList)
    }
}