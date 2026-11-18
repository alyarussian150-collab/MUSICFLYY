data class Track(
    val id: String,
    val name: String,
    val artist_name: String,
    val image: String,
    val audio: String
)
data class TrackResponse(val results: List<Track>)

interface JamendoApi {
    @GET("tracks/")
    suspend fun trending(
        @Query("client_id") id: String = "YOUR_CLIENT_ID",
        @Query("format") format: String = "json",
        @Query("limit") limit: Int = 30,
        @Query("order") order: String = "popularity_week"
    ): TrackResponse
}

val api: JamendoApi = Retrofit.Builder()
    .baseUrl("https://api.jamendo.com/v3.0/")
    .addConverterFactory(GsonConverterFactory.create())
    .build().create(JamendoApi::class.java)
