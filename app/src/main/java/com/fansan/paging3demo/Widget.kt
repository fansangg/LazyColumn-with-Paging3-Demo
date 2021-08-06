package com.fansan.paging3demo

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fansan.paging3demo.data.entity.Data

/**
 *@author  sc
 *@version 2021/8/5
 */

@Composable
fun MainItem(item: Data.Entity) {
    Column(
        Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(color = Color.White)
    ) {
        Text(
            text = item.title,
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp,
            color = Color.Black,
            overflow = TextOverflow.Ellipsis,
            maxLines = 2,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(start = 10.dp, top = 3.dp, bottom = 5.dp, end = 10.dp)
        )

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.5.dp)
        )

        Text(
            text = item.link,
            fontWeight = FontWeight.Normal,
            fontSize = 15.sp,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            color = Color.Blue,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(Color.White)
                .padding(start = 10.dp, top = 5.dp, bottom = 5.dp, end = 10.dp)
        )

        Box(
            Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(end = 10.dp, top = 5.dp, bottom = 5.dp, start = 10.dp)
        ) {

            Text(
                text = if (item.shareUser.isNotEmpty()) item.shareUser else item.author,
                Modifier
                    .fillMaxWidth()
                    .align(alignment = Alignment.CenterStart),
                fontSize = 14.sp,
                color = Color(33, 33, 33),
                fontWeight = FontWeight.ExtraLight
            )

            Box(
                Modifier
                    .align(alignment = Alignment.CenterEnd)
                    .clip(shape = RoundedCornerShape(8.dp))
                    .background(color = Color.Red)
            ) {
                Text(
                    text = item.superChapterName,
                    Modifier
                        .align(alignment = Alignment.Center)
                        .padding(start = 5.dp, top = 2.dp, end = 5.dp, bottom = 2.dp),
                    fontSize = 12.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Medium
                )

            }

        }

        Spacer(
            modifier = Modifier
                .background(color = Color.Gray)
                .fillMaxWidth()
                .height(1.5.dp)
        )

    }
}

@Composable
fun LoadingItem() {
    Box(
        Modifier
            .height(45.dp)
            .fillMaxWidth()
            .background(color = Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxHeight()
                .wrapContentWidth()
                .align(Alignment.Center)
        ) {
            CircularProgressIndicator()
            Text(
                text = "正在加载中...",
                color = Color.Black,
                fontSize = 15.sp,
                fontWeight = FontWeight.Black
            )
        }
    }
}

@Composable
fun ErrorItem(retryClick: () -> Unit) {
    Text(
        text = "加载失败,请重试",
        modifier = Modifier
            .fillMaxWidth()
            .height(45.dp)
            .background(color = Color.White)
            .clickable(onClick = retryClick),
        fontSize = 15.sp,
        color = Color.Black,
        textAlign = TextAlign.Center
    )
}

@Composable
fun NoMoreItem() {
    Text(
        text = "没有更多数据了",
        modifier = Modifier
            .fillMaxWidth()
            .height(45.dp)
            .background(color = Color.White),
        fontSize = 15.sp,
        color = Color.Black,
        textAlign = TextAlign.Center
    )
}

@Composable
fun ErrorScreen(retryClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Column(
            modifier = Modifier
                .wrapContentSize()
                .align(Alignment.Center)
        ) {
            Text(
                text = "出错了！", color = Color.Black,
                textAlign = TextAlign.Center,
                fontSize = 18.sp,
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = { retryClick.invoke() }) {
                Text(
                    text = "点击重试",
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    fontSize = 15.sp
                )
            }
        }
    }
}

@Composable
fun EmptyScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Text(
            text = "没有数据！", color = Color.Black,
            textAlign = TextAlign.Center,
            fontSize = 15.sp,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Composable
fun LoadingScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        CircularProgressIndicator(modifier = Modifier.align(alignment = Alignment.Center))
    }
}

@Composable
fun MainDrawer() {
    Box(
        Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Text(
            text = "这是Drawer",
            fontSize = 18.sp,
            color = Color.Red,
            modifier = Modifier.align(alignment = Alignment.Center)
        )
    }
}