package com.example.android.marsphotos.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.android.marsphotos.databinding.FragmentOverviewBinding
import com.example.android.marsphotos.databinding.GridViewItemBinding
import com.example.android.marsphotos.network.MarsPhoto

class OverViewAdapter :ListAdapter<MarsPhoto, OverViewAdapter.OverViewHolder>(DiffCallback)
{
    class OverViewHolder(private var binding: GridViewItemBinding): RecyclerView.ViewHolder(binding.root)
    {
        fun bind(MarsPhoto: MarsPhoto)
        {
            binding.photo = MarsPhoto
            binding.executePendingBindings()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OverViewHolder {
        return OverViewHolder(GridViewItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: OverViewHolder, position: Int)
    {
        val marsPhoto = getItem(position)
        holder.bind(marsPhoto)
    }
    companion object DiffCallback: DiffUtil.ItemCallback<MarsPhoto>(){
        override fun areItemsTheSame(oldItem: MarsPhoto, newItem: MarsPhoto): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MarsPhoto, newItem: MarsPhoto): Boolean {
            return oldItem.imgSrcUrl == newItem.imgSrcUrl
        }

    }

}
