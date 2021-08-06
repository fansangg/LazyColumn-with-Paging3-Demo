package com.fansan.paging3demo.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 *@author  sc
 *@version 2021/7/30
 */

@Entity(tableName = "user")
class UserInfo() {

    @PrimaryKey(autoGenerate = true)
    var id = 0

    @ColumnInfo(name = "userName",defaultValue = "33")
    lateinit var name:String

    @ColumnInfo(name = "age",defaultValue = "25")
    var age = 25
}