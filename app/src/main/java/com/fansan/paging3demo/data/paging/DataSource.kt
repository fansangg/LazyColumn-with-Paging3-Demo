package com.fansan.paging3demo.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.fansan.paging3demo.DataRespority
import com.fansan.paging3demo.data.entity.Data

/**
 *@author  sc
 *@version 2021/8/2
 */

class DataSource(private val respority: DataRespority) : PagingSource<Int, Data.Entity>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Data.Entity> {
        return try {
            val pageKey = params.key ?: 540
            val responseData = respority.loadData(page = pageKey)
            val nextPage = if (responseData.isEmpty()) null else pageKey.plus(1)
            LoadResult.Page(
                data = responseData,
                prevKey = null,
                nextKey = nextPage
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Data.Entity>): Int? {
        return state.anchorPosition
    }
}