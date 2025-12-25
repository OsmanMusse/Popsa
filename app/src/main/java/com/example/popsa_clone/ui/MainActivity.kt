package com.example.popsa_clone.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import com.example.popsa_clone.PopsaNavHost
import com.example.popsa_clone.ui.theme.PopsaCloneTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            navigationBarStyle = SystemBarStyle.dark(Color.Black.toArgb())
        )
        setContent {
            PopsaCloneTheme {
                PopsaNavHost()
            }
        }
    }
}
