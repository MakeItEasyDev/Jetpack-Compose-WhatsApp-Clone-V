package com.jetpack.whatsappclone.view

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.jetpack.whatsappclone.R
import com.jetpack.whatsappclone.model.SampleData
import com.jetpack.whatsappclone.ui.theme.WhatsAppChatBg
import com.jetpack.whatsappclone.ui.theme.WhatsAppOutgoingMsg
import com.jetpack.whatsappclone.ui.theme.WhatsAppThemeColor
import java.text.SimpleDateFormat
import java.util.*

@SuppressLint("SimpleDateFormat")
@Composable
fun WhatsAppChatList(navController: NavHostController) {
    val date = SimpleDateFormat("hh:mm a")
    val strDate: String = date.format(Date())
    val menuExpanded = remember { mutableStateOf(false) }

    val chatListItem = listOf(
        SampleData("Name 1", "Hi, Welcome", "Sample Url", strDate),
        SampleData("Name 2", "Hi, Welcome", "Sample Url", strDate),
        SampleData("Name 3", "Hi, Welcome", "Sample Url", strDate),
        SampleData("Name 4", "Hi, Welcome", "Sample Url", strDate),
        SampleData("Name 5", "Hi, Welcome", "Sample Url", strDate),
        SampleData("Name 6", "Hi, Welcome", "Sample Url", strDate),
        SampleData("Name 7", "Hi, Welcome", "Sample Url", strDate),
        SampleData("Name 8", "Hi, Welcome", "Sample Url", strDate),
        SampleData("Name 9", "Hi, Welcome", "Sample Url", strDate),
        SampleData("Name 10", "Hi, Welcome", "Sample Url", strDate)
    )

    val topBar: @Composable () -> Unit = {
        TopAppBar(
            title = {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        Icons.Filled.ArrowBack,
                        contentDescription = "Back Arrow",
                        tint = Color.White
                    )
                    Image(
                        painter = painterResource(id = R.drawable.ic_run_circle),
                        contentDescription = "User Image",
                        modifier = Modifier
                            .height(60.dp)
                            .width(60.dp)
                            .padding(0.dp, 5.dp, 5.dp, 5.dp)
                    )
                    Column(
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "0123456789",
                            color = Color.White,
                            fontSize = 12.sp
                        )
                    }
                }
            },
            actions = {
                IconButton(onClick = {  }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_videocam_24),
                        contentDescription = "",
                        tint = Color.White
                    )
                }
                IconButton(onClick = {
                    menuExpanded.value = true
                }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_call_24),
                        contentDescription = "",
                        tint = Color.White
                    )
                }
                IconButton(onClick = {  }) {
                    Icon(
                        Icons.Filled.MoreVert,
                        contentDescription = "",
                        tint = Color.White
                    )
                }

                Column(
                    modifier = Modifier.wrapContentSize(Alignment.TopStart)
                ) {
                    DropdownMenu(
                        expanded = menuExpanded.value,
                        onDismissRequest = {
                            menuExpanded.value = false
                        },
                        modifier = Modifier
                            .width(200.dp)
                            .wrapContentSize(Alignment.TopStart)
                    ) {
                        DropdownMenuItem(onClick = {  }) {
                            Text(text = "Add to contacts")
                        }
                        DropdownMenuItem(onClick = {  }) {
                            Text(text = "Report")
                        }
                        DropdownMenuItem(onClick = {  }) {
                            Text(text = "Block")
                        }
                        DropdownMenuItem(onClick = {  }) {
                            Text(text = "Search")
                        }
                        DropdownMenuItem(onClick = {  }) {
                            Text(text = "Mute notifications")
                        }
                        DropdownMenuItem(onClick = {  }) {
                            Text(text = "Wallpaper")
                        }
                        DropdownMenuItem(onClick = {  }) {
                            Text(text = "More")
                        }
                    }
                }
            },
            backgroundColor = WhatsAppThemeColor,
            elevation = AppBarDefaults.TopAppBarElevation
        )
    }

    Scaffold(
        topBar = {
            topBar()
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(WhatsAppChatBg)
                    .padding(10.dp)
            ) {
                LazyColumn {
                    items(chatListItem.size) { index ->
                        ChatListItem(chatListItem[index], index)
                    }
                }
            }
        },
        bottomBar = {
            //BottomDesign()
        }
    )
}

@Composable
fun ChatListItem(data: SampleData, index: Int) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        if (index % 2 == 0) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(0.4f)
                    .clip(RoundedCornerShape(10.dp))
                    .background(WhatsAppOutgoingMsg)
                    .padding(5.dp)
            ) {
                Text(
                    text = data.desc,
                    color = Color.Black,
                    fontSize = 15.sp
                )
                Text(
                    text = data.createdDate,
                    color = Color.LightGray,
                    fontSize = 10.sp,
                    textAlign = TextAlign.End,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        } else {
            Column(
                modifier = Modifier
                    .fillMaxWidth(0.4f)
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color.White)
                    .padding(5.dp)
                    .align(Alignment.End)
            ) {
                Text(
                    text = data.desc,
                    color = Color.Black,
                    fontSize = 15.sp
                )
                Text(
                    text = data.createdDate,
                    color = Color.LightGray,
                    fontSize = 10.sp,
                    textAlign = TextAlign.End,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}



















