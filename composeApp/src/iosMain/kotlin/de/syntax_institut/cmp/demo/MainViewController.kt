package de.syntax_institut.cmp.demo

import androidx.compose.ui.window.ComposeUIViewController
import de.syntax_institut.cmp.demo.core.App
import de.syntax_institut.cmp.demo.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) { App() }