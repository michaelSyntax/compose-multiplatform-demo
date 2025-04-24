package de.syntax_institut.cmp.demo.core

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import de.syntax_institut.cmp.demo.navigation.BottomNavigationBar
import de.syntax_institut.cmp.demo.navigation.NavigationItem
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun App() {
    MaterialTheme {
        var selectedNavItem by rememberSaveable { mutableStateOf(NavigationItem.Random) }
        val navController = rememberNavController()

        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .safeDrawingPadding(),
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
                val screenModifier = Modifier.fillMaxSize().padding(innerPadding)
                AppNavHost(
                    modifier = screenModifier,
                    navController = navController,
                    selectedNavItem = selectedNavItem
                )
            }
        )
    }
}