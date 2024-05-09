package com.example.auto_price_lookup

import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.auto_price_lookup.ui.theme.AutoPricelookupTheme

class MainActivity : ComponentActivity() {
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        Log.d("TAG", "onCreateOptionsMenu: normal working!");
        menuInflater.inflate(R.menu.options_menu, menu);
        return true;
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("TAG", "onCreateOptionsMenu: trace working!");
        enableEdgeToEdge()
        setContent {
            AutoPricelookupTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                            name = "Android",
                            modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
            text = "Hello $name!",
            modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AutoPricelookupTheme {
        Greeting("Android")
    }
}