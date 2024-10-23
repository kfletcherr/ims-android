package com.example.ims_android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier

class TScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TScreen()
        }
    }
}

@Composable
fun TabScreen() {
    val tabs = listOf("Tab 1", "Tab 2", "Tab 3")
    val selectedTabIndex = remember { mutableStateOf(0) }

    Scaffold(
        bottomBar = {
            TabRow(selectedTabIndex.value) {
                tabs.forEachIndexed { index, tab ->
                    Tab(
                        selected = selectedTabIndex.value == index,
                        onClick = { selectedTabIndex.value = index },
                        text = { Text(text = tab) }
                    )
                }
            }
        }
    ) { innerPadding ->
        Surface(modifier = Modifier.fillMaxSize().padding(innerPadding)) {
            when (selectedTabIndex.value) {
                0 -> TabContent("Camera/Scanner Page")
                1 -> TabContent("History Page")
                2 -> TabContent("Future Settings Page")
            }
        }
    }
}

@Composable
fun TabContent(content: String) {
    Text(text = content, fontSize = 24.sp)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TabScreen()
}
