package klivvr.test.day8.presentation.models


data class ProductUiModel(
    val id: Int?,
    val title: String?,
    val price: Double?,
    val thumbnail: String?,
    val images: List<String>?,
    val onClick: () -> Unit = {}
)