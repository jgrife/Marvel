package com.example.marvel.data.models

import com.example.marvel.domain.models.Comic
import kotlinx.serialization.Serializable

@Serializable
data class ComicDTO(
    val characters: CharactersDTO,
    val collections: List<CollectionDTO>,
    val creators: CreatorsDTO,
    val dates: List<DateDTO>,
    val description: String,
    val diamondCode: String,
    val digitalId: Int,
    val ean: String,
    val events: EventsDTO,
    val format: String,
    val id: Int,
    val images: List<ImageDTO>,
    val isbn: String,
    val issn: String,
    val issueNumber: Int,
    val modified: String,
    val pageCount: Int,
    val prices: List<PriceDTO>,
    val resourceURI: String,
    val series: Series,
    val stories: StoriesDTO,
    val textObjects: List<TextObjectDTO>,
    val thumbnail: ThumbnailDTO,
    val title: String,
    val upc: String,
    val urls: List<UrlDTO>,
    val variantDescription: String
)

fun ComicDTO.toComic(): Comic {
    return Comic(
        id = id,
        title = title
    )
}