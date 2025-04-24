package de.syntax_institut.cmp.demo

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import composemultiplatformdemo.composeapp.generated.resources.Res
import composemultiplatformdemo.composeapp.generated.resources.compose_multiplatform
import de.syntax_institut.cmp.demo.navigation.BottomNavigationBar
import de.syntax_institut.cmp.demo.navigation.NavigationItem
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun App() {
    MaterialTheme {
        var selectedNavItem by rememberSaveable { mutableStateOf(NavigationItem.Random) }
        var showContent by remember { mutableStateOf(false) }

        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .safeDrawingPadding(),
            topBar = {
                TopAppBar(
                    title = {}
                )
            },
            bottomBar = {
                BottomAppBar(
                    content = {
                        BottomNavigationBar(
                            navItems = NavigationItem.entries,
                            onNavItemSelection = { selectedNavItem = it },
                            selectedNavItem = selectedNavItem
                        )
                    }
                )
            },
            content = { innerPadding ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Button(
                        onClick = {

                        }
                    ) {
                        Text(text = "Click me!")
                    }
                    AnimatedVisibility(showContent) {
                        val greeting = remember { Greeting().greet() }
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(Res.drawable.compose_multiplatform),
                                contentDescription = null
                            )
                            Text(text = "Compose: $greeting")
                        }
                    }
                }
            }
        )
    }
}