# Marvel
Hardcoded a Comic ID, to retrieve that comic from Marvel's Developer API and display the comic books title, description and cover image withing a Jetpack Compose screen.

Utilizing an Presentation, Domain and Data layer pattern. The Data layer has the Repository and Network implementations. The Domain layer has the Interfaces, business code and could have Use Cases eventually. The Presentation layer has UI in an MVVM design pattern. You’ll see that I’m using Jetpack Compose for screen views; and Coroutines for managing suspend functions.

Libraries Used:
- Retrofit and OkHttp: Networking library for working with the Marvel network API and for adding authorizing keys as query parameters.
- KotlinX: for deserializing json from network respoonses.
- Hilt/Dagger: for dependency injection.
- Coil: Image networking library that works well with Composables.
- Jetpack Compose: for generating screen
