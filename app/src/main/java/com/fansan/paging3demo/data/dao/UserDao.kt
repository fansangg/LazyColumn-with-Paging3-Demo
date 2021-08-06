package com.fansan.paging3demo.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.fansan.paging3demo.data.entity.UserInfo

/**
 *@author  sc
 *@version 2021/7/30
 */

@Dao
interface UserDao {

    @Insert
    fun insert(user:UserInfo)


}