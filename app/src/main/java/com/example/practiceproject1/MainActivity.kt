package com.example.practiceproject1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.practiceproject1.model.Product
import com.example.practiceproject1.ui.theme.theme.Practiceproject1Theme
import com.example.practiceproject1.view.AppNavigation
import com.example.practiceproject1.view.MainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            Practiceproject1Theme {
                AppNavigation()
            }
        }
    }
}