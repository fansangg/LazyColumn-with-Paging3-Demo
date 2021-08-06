package com.fansan.paging3demo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.fansan.paging3demo.DataRespority
import com.fansan.paging3demo.data.paging.DataSource

/**
 *@author  sc
 *@version 2021/8/2
 */

class MainViewModel:ViewModel() {

    private val respority:DataRespority = DataRespority()

    fun getData() = Pager(PagingConfig(pageSize = 20,initialLoadSize = 20)){
        DataSource(respority)
    }.flow.cachedIn(viewModelScope)
}