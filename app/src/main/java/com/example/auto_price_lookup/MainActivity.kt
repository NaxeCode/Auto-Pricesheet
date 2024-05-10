package com.example.auto_price_lookup

import android.app.SearchManager
import android.content.ComponentName
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.SearchView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.auto_price_lookup.ui.theme.AutoPricelookupTheme

class MainActivity : AppCompatActivity() {
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.options_menu, menu)

        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView = menu?.findItem(R.id.search)?.actionView as SearchView
        val component = ComponentName(this, SearchResultsActivity::class.java)
        val searchableInfo = searchManager.getSearchableInfo(component)
        searchView.setSearchableInfo(searchableInfo)

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