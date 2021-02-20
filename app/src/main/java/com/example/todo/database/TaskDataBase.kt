package com.example.todo.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.todo.database.Dao.TaskDao
import com.example.todo.database.model.Task

@Database(entities = [Task::class],version = 1,exportSchema = false)
abstract class TaskDataBase : RoomDatabase() {
    abstract fun Daotask() : TaskDao

    companion object{
        private var database :TaskDataBase?=null
        private var DATA_BASEName :String = "task-db"
        fun getInstance(context: Context) :TaskDataBase{
            if(database==null){
                //creat
                database=Room.databaseBuilder(context,TaskDataBase::class.java, DATA_BASEName)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
            }
            return database!!
        }
    }

}