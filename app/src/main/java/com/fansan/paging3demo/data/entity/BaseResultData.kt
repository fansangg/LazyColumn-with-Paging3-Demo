package com.fansan.paging3demo.data.entity

/**
 *@author  sc
 *@version 2021/8/6
 */

data class BaseResultData<T>(
    val `data`: T,
    val errorCode: Int,
    val errorMsg: String
)
