package com.bindu.electronicsale.model


data class Television(
    val itemid: Int,
    val type: String,
    val name: String,
    val description: String,
    val year: Int,
    val price: Double
)

data class TelevisionObject(val televisions: List<Television>)