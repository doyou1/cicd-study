package com.example.api

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

data class ResultItem(
    val sourceLanguage: String = "",
    val input: String = "",
    val targetLanguage: String = "",
    val result: String = ""
)
