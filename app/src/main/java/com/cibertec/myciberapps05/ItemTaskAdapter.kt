package com.cibertec.myciberapps05

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cibertec.myciberapps05.databinding.ItemTaskBinding

class ItemTaskAdapter() : RecyclerView.Adapter<ItemTaskViewHolder>() {

    private var listTask: List<Task> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemTaskViewHolder {
        val binding = ItemTaskBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ItemTaskViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemTaskViewHolder, position: Int) {
        val currentItem = listTask[position]
        holder.bind(currentItem)
    }

    override fun getItemCount() = listTask.size


}

class ItemTaskViewHolder(private val binding: ItemTaskBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Task) {
        binding.tvName.text = item.name
    }

}