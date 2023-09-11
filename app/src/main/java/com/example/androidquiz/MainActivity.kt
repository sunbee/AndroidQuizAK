package com.example.androidquiz

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.androidquiz.ui.knowledgeBase.KnowledgeBaseScreen
import com.example.androidquiz.ui.knowledgeBase.KnowledgeBaseViewModel
import com.example.androidquiz.ui.theme.AndroidQuizTheme
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel

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

    override fun onBackPressed() {
        Log.d("MAIN", "Back pressed!")
    }
}
