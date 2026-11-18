private val Dark = darkColorScheme(
    primary = Color(0xFF9B5CFF),
    background = Color(0xFF0D0D12),
    surface = Color(0xFF1A1A22),
    onBackground = Color.White,
    onSurface = Color.White
)

@Composable
fun MusicFlyyTheme(content: @Composable () -> Unit) =
    MaterialTheme(colorScheme = Dark, content = content)
