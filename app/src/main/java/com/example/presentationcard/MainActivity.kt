package com.example.presentationcard

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.presentationcard.ui.theme.PresentationCardTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                PresentationCardApp()
            }
        }
    }
}

@Composable
fun PresentationCardApp() {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0x4F43A047))
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Spacer(modifier = Modifier.padding(top = 0.dp))
        GreetingContent(
            imageRender = painterResource(id = R.drawable.android_logo),
            fullName = "Paul Santillan",
            title = "Software Developer"
        )
        GreetingInfo()
    }
}

@Composable
private fun GreetingContent(imageRender: Painter, fullName: String, title: String) {
    Column(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = imageRender,
            contentDescription = null,
            Modifier
                .padding(top = 4.dp)
                .size(140.dp)
                .background(Color(0xFF00374D)),
            contentScale = ContentScale.Crop
        )
        Text(
            text = fullName,
            fontSize = 40.sp,
            modifier = Modifier
                .padding(top = 4.dp, bottom = 4.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(bottom = 4.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            color = Color(0xFF004D40)
        )
    }
}

@Composable
private fun GreetingInfo() {
    Column(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        GreetingDetails(
            icon = Icons.Filled.Phone,
            details = "+51 924 284 957",
            iconColor = Color(0xFF004D40)
        )
        GreetingDetails(
            icon = Icons.Filled.Share,
            details = "@paulsantillan",
            iconColor = Color(0xFF004D40)
        )
        GreetingDetails(
            icon = Icons.Filled.Email,
            details = "paulggsch@gmail.com",
            iconColor = Color(0xFF004D40)
        )
    }
}

@Composable
private fun GreetingDetails(
    icon: ImageVector,
    details: String,
    iconColor: Color = MaterialTheme.colorScheme.primary
) {
    Row(
        modifier = Modifier
            .padding(top = 4.dp, bottom = 4.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(imageVector = icon, contentDescription = null, tint = iconColor)
        Text(
            text = details, modifier = Modifier
                .width(200.dp)
                .padding(start = 4.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PresentationCardPreview() {
    PresentationCardTheme {
        PresentationCardApp()
    }
}