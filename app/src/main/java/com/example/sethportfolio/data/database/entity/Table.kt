package com.example.sethportfolio.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Table")
data class Table(
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0
)