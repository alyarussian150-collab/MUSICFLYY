class MainActivity : ComponentActivity() {
    private var controller: MediaController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val token = SessionToken(this, ComponentName(this, PlaybackService::class.java))
        val future = MediaController.Builder(this, token).buildAsync()
        future.addListener({ controller = future.get() }, MoreExecutors.directExecutor())

        setContent {
            MusicFlyyTheme {
                Surface(Modifier.fillMaxSize()) {
                    HomeScreen { list, index ->
                        controller?.apply {
                            setMediaItems(list.map {
                                MediaItem.Builder()
                                    .setUri(it.audio)
                                    .setMediaMetadata(
                                        MediaMetadata.Builder()
                                            .setTitle(it.name)
                                            .setArtist(it.artist_name)
                                            .setArtworkUri(Uri.parse(it.image))
                                            .build()
                                    ).build()
                            }, index, 0)
                            prepare(); play()
                        }
                    }
                }
            }
        }
    }
}
