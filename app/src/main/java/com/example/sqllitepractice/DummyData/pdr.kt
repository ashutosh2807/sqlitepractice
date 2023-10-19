package com.example.sqllitepractice.DummyData

data class pdr(
    val limit: Int,
    val products: List<ProductX>,
    val skip: Int,
    val total: Int
)