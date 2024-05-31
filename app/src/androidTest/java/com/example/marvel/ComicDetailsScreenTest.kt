package com.example.marvel

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.marvel.domain.models.Comic
import com.example.marvel.presentation.ui.theme.MarvelTheme
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ComicDetailsScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun comicDetailsScreenTest() {
        composeTestRule.setContent {
            MarvelTheme {
                ComicDetailsScreen(
                    comic = Comic(
                        id = 100,
                        title = "Sentinel (2003) #7",
                        description = "In the aftermath of the events of the first story arc, Juston must decide his next move!  But has the Marvel Universe given birth to a new hero ... or to a monster?\r\n\r\n32 PGS.(each)/MARVEL PSR...$2.50",
                        thumbnailPortrait = "https://i.annihil.us/u/prod/marvel/i/mg/6/20/5b464dc1c4517/portrait_xlarge.jpg"
                    )
                )
            }
        }

        composeTestRule.onNodeWithText("Sentinel (2003) #7").assertIsDisplayed()
    }
}