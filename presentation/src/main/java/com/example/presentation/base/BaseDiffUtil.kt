package com.example.presentation.base

import androidx.recyclerview.widget.DiffUtil
import com.example.presentation.entities.GeneraEntity

class BaseDiffUtil<T : GeneraEntity> : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem.areItemsTheSame(newItem)
    }

    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem.areContentsTheSame(newItem)
    }
}
