package de.syntax_institut.cmp.demo.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun BottomNavigationBar(
    navItems: List<NavigationItem>,
    onNavItemSelection: (NavigationItem) -> Unit,
    selectedNavItem: NavigationItem
) {
    NavigationBar {
        navItems.forEach { navItem ->
            NavigationBarItem(
                selected = selectedNavItem == navItem,
                onClick = { onNavItemSelection(navItem) },
                icon = { Icon(navItem.icon, navItem.icon.name) },
                label = { Text(navItem.label) }
            )
        }
    }
}