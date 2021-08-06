package com.fansan.paging3demo

import com.fansan.paging3demo.data.entity.Data
import com.fansan.paging3demo.network.ApiService

/**
 *@author  sc
 *@version 2021/8/2
 */

class DataRespority {

    suspend fun loadData(page:Int): MutableList<Data.Entity>{
        val data = ApiService.getService().getList(pageNum = page)
        return data.data?.datas?: mutableListOf()
    }
}