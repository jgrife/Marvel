package com.example.marvel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import com.example.marvel.domain.models.Comic
import com.example.marvel.presentation.ui.theme.MarvelTheme
import com.example.marvel.presentation.ui.theme.Typography
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainActviityViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MarvelTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    viewModel.state.comic?.run {
                        ComicDetailsScreen(
                            comic = this,
                            modifier = Modifier.padding(innerPadding)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ComicDetailsScreen(
    comic: Comic,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .background(MaterialTheme.colorScheme.surface)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        SubcomposeAsyncImage(
            model = comic.thumbnailPortrait,
            contentDescription = "",
            modifier = modifier
                .fillMaxWidth()
                .aspectRatio(16 / 9f)
                .clip(RoundedCornerShape(16.dp)),
            loading = {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(20.dp),
                        strokeWidth = 2.dp,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            },
            error = {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.errorContainer),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = stringResource(id = R.string.error_could_not_load_image),
                        color = MaterialTheme.colorScheme.error
                    )
                }
            }
        )
        Text(
            text = comic.title,
            style = Typography.titleMedium
        )
        Text(
            text = comic.description,
            style = Typography.bodySmall
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ComicDetailsScreenPreview() {
    MarvelTheme {
        ComicDetailsScreen(
            comic = Comic(
                id = 1,
                title = "Spider Man",
                description = "A long description",
                thumbnailPortrait = ""
            )
        )
    }
}