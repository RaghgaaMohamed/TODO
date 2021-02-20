package com.example.todo.database.Dao

import androidx.room.*
import com.example.todo.database.model.Task

@Dao
interface TaskDao {

    @Insert
    fun addtask(task : Task)
    @Update
    fun updatetask(task: Task)
    @Delete
    fun deletetask(task: Task)
    @Query("select * from Task")
    fun gettasks():List<Task>
    @Query("select * from Task where title like :word or description like :word")
    fun searchtask(word :String) : List<Task>
}