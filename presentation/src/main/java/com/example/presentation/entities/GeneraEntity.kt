package com.example.presentation.entities

interface GeneraEntity {
    fun areItemsTheSame(newItem: GeneraEntity): Boolean
    fun areContentsTheSame(newItem: GeneraEntity): Boolean
}
