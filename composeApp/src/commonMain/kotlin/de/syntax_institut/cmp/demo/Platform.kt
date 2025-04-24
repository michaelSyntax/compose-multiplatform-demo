package de.syntax_institut.cmp.demo

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform