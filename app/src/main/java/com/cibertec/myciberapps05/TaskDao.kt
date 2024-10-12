package com.cibertec.myciberapps05

import androidx.room.Dao
import androidx.room.Query

@Dao // sqlite
interface TaskDao {

    @Query("SELECT * FROM task_table")
    fun getAllTasks(): List<Task>

}