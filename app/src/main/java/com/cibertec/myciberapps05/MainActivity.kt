package com.cibertec.myciberapps05

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.cibertec.myciberapps05.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

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

        }

        loadAllTask()
    }

    private fun loadAllTask() {
        val taskList = database.taskDao().getAllTasks()
        adapter.addItems(taskList)
    }
}