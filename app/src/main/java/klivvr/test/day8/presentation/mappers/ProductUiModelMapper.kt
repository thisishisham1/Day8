package klivvr.test.day8.presentation.mappers

import klivvr.test.day8.data.models.Product
import klivvr.test.day8.presentation.models.ProductUiModel

fun Product.toUi(onClick: () -> Unit) = ProductUiModel(
    id = id,
    title = title,
    price = price,
    thumbnail = thumbnail,
    images = images,
    onClick = onClick
)