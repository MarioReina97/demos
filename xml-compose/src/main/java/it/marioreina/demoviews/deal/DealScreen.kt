package it.marioreina.demoviews.deal

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import coil3.compose.AsyncImagePainter
import coil3.compose.rememberAsyncImagePainter
import it.marioreina.demoviews.R
import it.marioreina.demoviews.domain.entity.DealEntity

@Composable
fun DealScreen(
    dealState: DealState,
    onError: (Throwable) -> Unit? = {  }
) {
    Scaffold { modifier ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = dimensionResource(id = R.dimen.margin5))
        ) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.padding(modifier)
            ) {
                items(items = dealState.dealList?.toList() ?: listOf()) { deal ->
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(dimensionResource(id = R.dimen.padding10)),
                        horizontalAlignment = Alignment.Start
                    ) {
                        val painter = rememberAsyncImagePainter(model = deal.thumb)
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(dimensionResource(id = R.dimen.size50)),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painter,
                                contentDescription = null,
                                modifier = Modifier.fillMaxSize()
                            )

                            if (painter.state.collectAsState().value is AsyncImagePainter.State.Loading) {
                                CircularProgressIndicator(
                                    modifier = Modifier.fillMaxSize()
                                )
                            }
                        }

                        // Title
                        Text(
                            text = deal.title,
                            style = MaterialTheme.typography.labelLarge,
                            modifier = Modifier
                                .padding(top = dimensionResource(id = R.dimen.margin5))
                                .fillMaxWidth(),
                            maxLines = 2,
                            minLines = 2,
                            overflow = TextOverflow.Ellipsis,
                        )

                        // Price
                        Row(
                            modifier = Modifier.padding(top = dimensionResource(id = R.dimen.margin2)),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = String.format("%s$", deal.salePrice),
                                style = MaterialTheme.typography.bodyLarge,
                                modifier = Modifier
                            )

                            Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.margin2)))

                            Text(
                                text = deal.normalPrice,
                                style = MaterialTheme.typography.bodyMedium,
                                modifier = Modifier,
                                textDecoration = TextDecoration.LineThrough
                            )
                        }
                    }
                }
            }

            // Progress indicator centered on the screen
            if (dealState.isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(dimensionResource(id = R.dimen.padding10))
                )
            }
        }
    }

}

@Composable
@Preview
fun PreviewDealScreen() {
    DealScreen(
        dealState = DealState(
            dealList = mutableListOf(
                DealEntity(
                    dealID = null,
                    dealRating = null,
                    gameID = null,
                    internalName = null,
                    isOnSale = null,
                    lastChange = null,
                    metacriticLink = null,
                    metacriticScore = null,
                    normalPrice = "principes",
                    releaseDate = null,
                    salePrice = null,
                    savings = null,
                    steamAppID = null,
                    steamRatingCount = null,
                    steamRatingPercent = null,
                    steamRatingText = null,
                    storeID = null,
                    thumb = null,
                    title = "sociosqu"
                ),
                DealEntity(
                    dealID = null,
                    dealRating = null,
                    gameID = null,
                    internalName = null,
                    isOnSale = null,
                    lastChange = null,
                    metacriticLink = null,
                    metacriticScore = null,
                    normalPrice = "principes",
                    releaseDate = null,
                    salePrice = null,
                    savings = null,
                    steamAppID = null,
                    steamRatingCount = null,
                    steamRatingPercent = null,
                    steamRatingText = null,
                    storeID = null,
                    thumb = null,
                    title = "sociosqu"
                )
            ), isFirstAccess = false, isLoading = true
        )
    )
}