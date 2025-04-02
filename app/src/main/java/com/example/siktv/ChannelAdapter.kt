package com.example.siktv

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.siktv.databinding.ChannelItemBinding
import com.bumptech.glide.Glide

class ChannelAdapter(
    private val channelList: List<Channel>,
    private val context: Context,
    private val onClick: (Channel) -> Unit
) : RecyclerView.Adapter<ChannelAdapter.ChannelViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChannelViewHolder {
        // ربط XML بـ ViewBinding باستخدام ChannelItemBinding
        val binding = ChannelItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return ChannelViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ChannelViewHolder, position: Int) {
        val channel = channelList[position]
        holder.bind(channel)
    }

    override fun getItemCount(): Int = channelList.size

    inner class ChannelViewHolder(private val binding: ChannelItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(channel: Channel) {
            binding.channelName.text = channel.name
            // استخدام Glide لتحميل الصورة من الرابط
            Glide.with(context).load(channel.logoUrl).into(binding.channelLogo)
            binding.root.setOnClickListener {
                onClick(channel)
            }
        }
    }
}
