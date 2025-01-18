package it.marioreina.demoviews.deal

import it.marioreina.demoviews.domain.entity.DealEntity

data class DealState(
    val dealList: MutableList<DealEntity>? = null,
    val isFirstAccess: Boolean = false,
    val isLoading: Boolean = false,
)
