package com.example.androidquiz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.androidquiz.ui.knowledgeBase.KnowledgeBaseScreen
import com.example.androidquiz.ui.theme.AndroidQuizTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidQuizTheme {
                // A surface container using the 'background' color from the theme
                KnowledgeBaseScreen()
            }
        }
    }
}
