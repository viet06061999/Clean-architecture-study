package com.example.presentation.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.presentation.base.BaseAdapter
import com.example.presentation.base.BaseViewHolder
import com.example.presentation.databinding.ItemVideoBinding
import com.example.presentation.entities.VideoUIEntity

class VideoAdapter(val onClick: ((VideoUIEntity) -> Unit)) :
    BaseAdapter<VideoUIEntity, ItemVideoBinding>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<VideoUIEntity, ItemVideoBinding> {
        return VideoVH(
            ItemVideoBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            onClick
        )
    }

    private class VideoVH(
        val itemVideoBinding: ItemVideoBinding,
        onClick: ((VideoUIEntity) -> Unit)?
    ) : BaseViewHolder<VideoUIEntity, ItemVideoBinding>(
        itemVideoBinding, onClick
    ) {
        override fun onBind(itemData: VideoUIEntity) {
            super.onBind(itemData)
            itemVideoBinding.video = itemData
        }
    }
}