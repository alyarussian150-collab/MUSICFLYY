@Composable
fun HomeScreen(vm: HomeViewModel = viewModel(), onPlay: (List<Track>, Int) -> Unit) {
    Column(Modifier.fillMaxSize().padding(16.dp)) {
        Text("Music Flyy", fontSize = 28.sp, fontWeight = FontWeight.Bold)
        Text("Trending Now", Modifier.padding(vertical = 12.dp))
        LazyColumn {
            itemsIndexed(vm.tracks) { i, t ->
                Row(
                    Modifier.fillMaxWidth().clickable { onPlay(vm.tracks, i) }.padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    AsyncImage(t.image, null, Modifier.size(56.dp).clip(RoundedCornerShape(8.dp)))
                    Column(Modifier.padding(start = 12.dp)) {
                        Text(t.name, maxLines = 1)
                        Text(t.artist_name, fontSize = 12.sp, color = Color.Gray)
                    }
                }
            }
        }
    }
}
