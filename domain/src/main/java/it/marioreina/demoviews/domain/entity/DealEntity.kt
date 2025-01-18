package it.marioreina.demoviews.domain.entity

import it.marioreina.demoviews.data.model.deal.DealResponse
import java.io.Serializable
import java.net.URLDecoder

data class DealEntity(
    val dealID: String?,
    val dealRating: String?,
    val gameID: String?,
    val internalName: String?,
    val isOnSale: String?,
    val lastChange: Long?,
    val metacriticLink: String?,
    val metacriticScore: String?,
    val normalPrice: String,
    val releaseDate: Long?,
    val salePrice: String?,
    val savings: String?,
    val steamAppID: String?,
    val steamRatingCount: String?,
    val steamRatingPercent: String?,
    val steamRatingText: String?,
    val storeID: String?,
    val thumb: String?,
    val title: String
): Serializable

fun MutableList<DealResponse>.toEntity(): MutableList<DealEntity> {
    return this.map {
        it.toEntity()
    }.toMutableList()
}

fun DealResponse.toEntity(): DealEntity {
    return DealEntity(
        dealID = URLDecoder.decode(dealID ?: "", "UTF-8"),
        dealRating = dealRating,
        gameID = gameID,
        internalName = internalName,
        isOnSale = isOnSale,
        lastChange = lastChange,
        metacriticLink = metacriticLink,
        metacriticScore = metacriticScore,
        normalPrice = normalPrice ?: "",
        releaseDate = releaseDate,
        salePrice = salePrice,
        savings = savings,
        steamAppID = steamAppID,
        steamRatingCount = steamRatingCount,
        steamRatingPercent = steamRatingPercent,
        steamRatingText = steamRatingText,
        storeID = storeID,
        thumb = thumb,
        title = title ?: ""
    )
}