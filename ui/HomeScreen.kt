class HomeViewModel : ViewModel() {
    var tracks by mutableStateOf<List<Track>>(emptyList())
        private set

    init {
        viewModelScope.launch {
            runCatching { api.trending() }
                .onSuccess { tracks = it.results }
        }
    }
}
