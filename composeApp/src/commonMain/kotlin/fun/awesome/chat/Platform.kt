package `fun`.awesome.chat

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform