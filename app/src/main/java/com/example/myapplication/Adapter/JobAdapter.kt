package com.example.myapplication.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.Activity.DetailsActivity
import com.example.myapplication.Model.JobModel
import com.example.myapplication.databinding.ViewholderJobBinding

class JobAdapter(private val items:List<JobModel>):RecyclerView.Adapter<JobAdapter.JobViewHolder>() {


    // context
    private lateinit var context: Context


    // View Holder
    inner class JobViewHolder(val binding:ViewholderJobBinding):RecyclerView.ViewHolder(binding.root)

    // implement Methods
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobViewHolder {
        context = parent.context
        val binding = ViewholderJobBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return JobViewHolder(binding)
    }

    override fun onBindViewHolder(holder: JobViewHolder, position: Int) {
        val item = items[position]

        holder.binding.titleText.text = item.title
        holder.binding.companyText.text = item.company
        holder.binding.locationText.text=item.location
        holder.binding.timeText.text = item.time
        holder.binding.levelText.text=item.level
        holder.binding.salaryText.text = item.salary

        val drawableResourceId = holder.itemView.resources
            .getIdentifier(item.picUrl,"drawable",holder.itemView.context.packageName)


        Glide
            .with(holder.itemView.context)
            .load(drawableResourceId)
            .into(holder.binding.picDetails)


        holder.itemView.setOnClickListener{
            val intent = Intent(context,DetailsActivity::class.java)
            intent.putExtra("object",item)
            holder.itemView.context.startActivity(intent)

        }


        
    }

    override fun getItemCount(): Int {
        return items.size
    }
}