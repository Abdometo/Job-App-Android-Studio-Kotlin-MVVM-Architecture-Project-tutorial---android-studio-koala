package com.example.myapplication.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.databinding.ViewholderCategoryBinding

class CategoryAdapter(private val items:List<String>,val clickListener: ClickListener)
    :RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

        // context
        private lateinit var context: Context

        // selected positions
        private var selectedPositions = -1
        private var  lastSelectedPositions = -1


    // ViewHolder
    inner class CategoryViewHolder(val binding:ViewholderCategoryBinding):RecyclerView.ViewHolder(binding.root)

    // implement Methods

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
         context = parent.context
        val binding = ViewholderCategoryBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val item=items[position]
        holder.binding.catText.text=item

        holder.binding.root.setOnClickListener{
            lastSelectedPositions=selectedPositions
            selectedPositions=position
            notifyItemChanged(lastSelectedPositions)
            notifyItemChanged(selectedPositions)
            clickListener.onClick(position.toString())
        }
        if(selectedPositions==position){
            holder.binding.catText.setBackgroundResource(R.drawable.purple_full_corner)
            holder.binding.catText.setTextColor(context.resources.getColor(R.color.white))
        }else{
            holder.binding.catText.setBackgroundResource(R.drawable.grey_full_corner_bg)
            holder.binding.catText.setTextColor(context.resources.getColor(R.color.black))

        }
    }

    override fun getItemCount(): Int {
        return items.size
    }


    interface ClickListener{
        fun onClick(category: String)
    }
}