package com.example.gardeningjournalapp

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gardeningjournalapp.data.Plant
import com.example.gardeningjournalapp.databinding.ItemRowBinding

class ListAdapter : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var plantList = emptyList<Plant>()

    class MyViewHolder(private val binding: ItemRowBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(plant: Plant) {
            binding.txtPlantName.text = plant.plantName
            binding.txtPlantType.text = plant.plantType
            binding.txtWaterFrequency.text = plant.waterFrequency.toString()
            binding.txtPlantDate.text = plant.plantDate
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return plantList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = plantList[position]
        holder.bind(currentItem)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(plant: List<Plant>) {
        this.plantList = plant
        notifyDataSetChanged()
    }
}