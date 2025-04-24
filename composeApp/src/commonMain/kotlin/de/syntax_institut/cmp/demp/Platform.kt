package de.syntax_institut.cmp.demp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform