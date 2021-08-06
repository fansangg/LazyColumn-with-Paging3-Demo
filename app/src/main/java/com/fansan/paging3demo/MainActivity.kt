package com.fansan.paging3demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.fansan.paging3demo.ui.theme.Paging3DemoTheme
import com.fansan.paging3demo.viewmodel.MainViewModel
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private val model: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val scope = rememberCoroutineScope()
            val scaffoldState = rememberScaffoldState()
            val lazycoloumnState = rememberLazyListState()
            val pagingItems = model.getData().collectAsLazyPagingItems()
            Paging3DemoTheme {
                // A surface container using the 'background' color from the theme
                Scaffold(scaffoldState = scaffoldState,
                    topBar = {
                        TopAppBar(title = {
                            Text(
                                modifier = Modifier.fillMaxWidth(),
                                text = "首页",
                                fontSize = 16.sp,
                                color = Color.White,
                                fontWeight = FontWeight.SemiBold
                            )
                        }, navigationIcon = {
                            IconButton(
                                onClick = {
                                    scope.launch { scaffoldState.drawerState.open() }
                                },
                                content = {
                                    Icon(Icons.Default.Menu, contentDescription = "菜单")
                                })
                        }, modifier = Modifier.clickable {
                            scope.launch {
                                lazycoloumnState.scrollToItem(0)
                            }
                        })
                    },
                    drawerContent = {
                        MainDrawer()
                    }
                ) {
                    Surface(color = MaterialTheme.colors.background) {
                        pagingItems.apply {
                            if (loadState.refresh is LoadState.Loading) {
                                LoadingScreen()
                            } else if (loadState.refresh is LoadState.Error) {
                                ErrorScreen {
                                    refresh()
                                }
                            } else if (loadState.refresh is LoadState.NotLoading && itemCount == 0) {
                                EmptyScreen()
                            } else {
                                LazyColumn(state = lazycoloumnState) {
                                    items(items = pagingItems) { data ->
                                        if (data != null) {
                                            MainItem(item = data)
                                        }
                                    }

                                    when (loadState.append) {
                                        is LoadState.Error -> {
                                            item {
                                                ErrorItem {
                                                    retry()
                                                }
                                            }
                                        }

                                        is LoadState.NotLoading -> {
                                            if (loadState.refresh !is LoadState.Loading)
                                                item { NoMoreDataItem() }
                                        }

                                        is LoadState.Loading -> {
                                            item {
                                                LoadingItem()
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Paging3DemoTheme {
        Greeting("Android")
    }
}