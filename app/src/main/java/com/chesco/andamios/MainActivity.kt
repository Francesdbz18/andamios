package com.chesco.andamios

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.chesco.andamios.ui.theme.AppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                Andamio()
            }
        }
    }
}

@Composable
fun Andamio() {
    Scaffold(
        // Barra superior
        topBar = { CustomTopBar() },

        // Barra inferior
        bottomBar = { CustomBottomBar() },

        // Contenido principal
        content = { padding ->
            CustomContent(padding)
        },
        floatingActionButton = { CustomFAB()}
    )
}

@Composable
fun CustomContent(padding: PaddingValues) {
    Column(
        // Modificadores de estilo de la columna
        modifier = Modifier
            // Ocupar todo el espacio disponible
            .fillMaxSize()
            .padding(padding),

        // Contenido de la aplicación
        content = {
            Spacer(Modifier.size(20.dp))
            LazyRowKyara(characterList(), modifier = Modifier)
            Spacer(Modifier.size(20.dp))
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                val listica = mutableListOf<Movie>()
                listica.add(Movie("saving private azu-nyan", "naoko yamada", "https://i.pinimg.com/736x/9b/0f/82/9b0f823ea5aac967326634839834827d.jpg"))
                listica.add(Movie("k-on! the movie", "naoko yamada", "https://i.pinimg.com/736x/9b/0f/82/9b0f823ea5aac967326634839834827d.jpg"))
                listica.add(Movie("k-on! college", "kakifly", "https://i.pinimg.com/736x/9b/0f/82/9b0f823ea5aac967326634839834827d.jpg"))
                listica.add(Movie("k-on!!", "naoko yamada", "https://i.pinimg.com/736x/9b/0f/82/9b0f823ea5aac967326634839834827d.jpg"))
                listica.add(Movie("saving private azu-nyan", "naoko yamada", "https://i.pinimg.com/736x/9b/0f/82/9b0f823ea5aac967326634839834827d.jpg"))
                listica.add(Movie("saving private azu-nyan", "naoko yamada", "https://i.pinimg.com/736x/9b/0f/82/9b0f823ea5aac967326634839834827d.jpg"))
                listica.add(Movie("saving private azu-nyan", "naoko yamada", "https://i.pinimg.com/736x/9b/0f/82/9b0f823ea5aac967326634839834827d.jpg"))
                items(listica) { model ->
                    MovieRow(model = model)
                }
            }
        }
    )
}

@Composable
fun CustomFAB() {
    FloatingActionButton(
        shape = CircleShape,
        onClick = { /*TODO*/ }) {
        Text(
            fontSize = 24.sp, // Tamaño de fuente del texto del botón
            text = "+" // Texto del botón
        )
    }
}

@Composable
fun CustomBottomBar() {
    BottomAppBar {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = null
                )
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.Delete,
                    contentDescription = null
                )
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.ThumbUp,
                    contentDescription = null
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopBar() {
    var displayrow = false
    val haptics = LocalHapticFeedback.current
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = colorScheme.primaryContainer,
            titleContentColor = colorScheme.primary,
        ),
        title = {
            Text(
                "Mis películas",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        navigationIcon = {
            IconButton(onClick = { /* do something */ }) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "Localized description"
                )
            }
        },

        actions = {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Filled.Home,
                    contentDescription = "Localized description"
                )
            }
            IconButton(onClick = { /* do something */ }) {
                Icon(
                    imageVector = Icons.Filled.Settings,
                    contentDescription = "Localized description"
                )
            }
        },
    )
}

data class Movie(val name:String, val director:String, val imageLink: String)

@Composable
fun MovieRow(model: Movie) {
    Row(
        modifier = Modifier
            .padding(20.dp)
            .border(1.dp, colorScheme.primary, shape = RoundedCornerShape(20.dp))
            .fillMaxWidth()
            .background(colorScheme.primaryContainer, shape = RoundedCornerShape(20.dp)),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        AsyncImage(
            model = model.imageLink,
            contentDescription = model.name,
            modifier = Modifier
                .padding(10.dp)
                .width(100.dp)
                .height(90.dp)
        )
        Column(Modifier.align(Alignment.CenterVertically).fillMaxWidth().padding(horizontal = 20.dp)){
            Text(text=model.name,
                style = MaterialTheme.typography.titleSmall
            )
            Spacer(Modifier.size(15.dp))
            Text(text=model.director,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

data class Character (val link: String, val name: String)
fun characterList(): List<Character> {
    return listOf(
        Character("https://static.wikia.nocookie.net/k-on/images/5/58/Yui_Icon.png/revision/latest/scale-to-width-down/250?cb=20140723211155", "yui"),
        Character("https://static.wikia.nocookie.net/k-on/images/a/a4/Mio_Icon.png/revision/latest/scale-to-width-down/250?cb=20140723211223", "mio"),
        Character("https://static.wikia.nocookie.net/k-on/images/7/73/Tsumugi_Icon.png/revision/latest/scale-to-width-down/250?cb=20140723211921", "mugi"),
        Character("https://static.wikia.nocookie.net/k-on/images/7/7a/Ritsu_Icon.png/revision/latest/scale-to-width-down/250?cb=20140723211412", "ricchan"),
        Character("https://static.wikia.nocookie.net/k-on/images/6/61/Azusa_Icon.png/revision/latest/scale-to-width-down/250?cb=20140723212332", "azu-nyan"),
        Character("https://i.pinimg.com/236x/cf/a1/16/cfa116ce0de13679a78345a8f824b8e6.jpg", "sawa-chan"),
        Character("https://static.wikia.nocookie.net/k-on/images/7/7b/Nodoka_newshot.png/revision/latest?cb=20140723210851", "nodoka")
    )
}

@Composable
fun KyaraCard(kyara: Character, modifier: Modifier) {
    Card(modifier = modifier) {
        Column(
            modifier = Modifier.padding(16.dp).size(140.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            AsyncImage(
                model = kyara.link,
                contentDescription = kyara.name,
                modifier = Modifier
                    .padding(6.dp).size(90.dp).clip(CircleShape)
            )
            Text(
                text = kyara.name,
                modifier = Modifier.padding(bottom = 3.dp),
                fontWeight = FontWeight.Bold,
            )
        }
    }
}

@Composable
fun LazyRowKyara(kyaraList: List<Character>, modifier: Modifier) {
    LazyRow(modifier = modifier) {
        items(kyaraList) { kyara ->
            KyaraCard(kyara = kyara, modifier = Modifier.padding(8.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppTheme {
        Andamio()
    }
}