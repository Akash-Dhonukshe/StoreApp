package com.example.storeapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.storeapp.databinding.ItemViewPagerBinding

class ViewPagerAdapter(val imageList: List<Int>) :
    RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        val binding = ItemViewPagerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewPagerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        val currentItem = imageList[position]
        holder.itemViewPagerBinding.itemViewPageIv.setImageResource(currentItem)
    }

    class ViewPagerViewHolder(val itemViewPagerBinding: ItemViewPagerBinding) : RecyclerView.ViewHolder(itemViewPagerBinding.root) {

    }
}