package com.example.marvel

import com.example.marvel.domain.MarvelRepository
import com.example.marvel.domain.models.Comic
import com.example.marvel.domain.util.Result
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.anyInt
import org.mockito.Mockito.mock
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.stub

class MainActviityViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    @Test
    fun `verify initial state`() {
        val repository = mock(MarvelRepository::class.java)
        val viewModel = MainActviityViewModel(repository)

        assertNull(viewModel.state.comic)
    }

    @Test
    fun `verify set state`() = runTest {
        val comic = Comic(
            id = 100,
            title = "Sentinel (2003) #7",
            description = "In the aftermath of the events of the first story arc, Juston must decide his next move!  But has the Marvel Universe given birth to a new hero ... or to a monster?\r\n\r\n32 PGS.(each)/MARVEL PSR...$2.50",
            thumbnailPortrait = "https://i.annihil.us/u/prod/marvel/i/mg/6/20/5b464dc1c4517/portrait_xlarge.jpg"
        )
        val repository = mock(MarvelRepository::class.java)
        repository.stub {
            onBlocking { getComic(anyInt()) }.doReturn(Result.Success(comic))
        }
        val viewModel = MainActviityViewModel(repository)

        val expectedState = ComicDetailsState(
            comic = comic
        )

        assertEquals(expectedState, viewModel.state)
    }
}