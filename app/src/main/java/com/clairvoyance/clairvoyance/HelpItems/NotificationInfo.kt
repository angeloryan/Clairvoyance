package com.clairvoyance.clairvoyance.HelpItems

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.clairvoyance.clairvoyance.MainActivity

class NotificationInfo : AppCompatActivity() {
    private lateinit var mainActivity: MainActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivity = MainActivity()

        setContentView(ComposeView(this).apply {
            setContent {
                Notification()
            }
        })
    }
}

@Composable
fun Title(title: String) {
    Text(
        text = title,
        color = Color.White,
        fontSize = 24.sp,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    )
}

@Composable
fun Notification() {
    Column() {
        Title("Notification Help")

        Text(text = "Question 1",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,)

        Spacer(modifier = Modifier.height(10.dp))

        Text(text = "Answer 1",
            color = Color.White,
            fontSize = 20.sp,)
    }
}