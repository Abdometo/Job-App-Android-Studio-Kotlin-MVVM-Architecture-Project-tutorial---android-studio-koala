package com.example.myapplication.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.ArrayAdapter
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.Adapter.CategoryAdapter
import com.example.myapplication.Adapter.JobAdapter
import com.example.myapplication.Model.JobModel
import com.example.myapplication.R
import com.example.myapplication.ViewModel.MainViewModel
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // Binding
    lateinit var binding:ActivityMainBinding
    // View Model
    private val mainViewModel:MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)




        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        initLocation()
        initCategory()
        initSuggest()
        initRecent("0")
    }

    private fun initRecent(cat:String) {
        var data:List<JobModel>

        if(cat=="0"){
            data = mainViewModel.loadData().sortedBy {
                it.category
            }

        }else{
            data = mainViewModel.loadData().filter { it.category==cat }
        }


        binding.recyclerViewRecent.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        binding.recyclerViewRecent.adapter=JobAdapter(data)

    }

    private fun initSuggest() {
        binding.progressBarSuggested.visibility = View.VISIBLE
        binding.recyclerViewSuggest.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        binding.recyclerViewSuggest.adapter=JobAdapter(mainViewModel.loadData())
        binding.progressBarSuggested.visibility = View.GONE

    }

    private fun initCategory() {
        binding.progressBarCategory.visibility = View.VISIBLE
        binding.recyclerViewCategory.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        binding.recyclerViewCategory.adapter=CategoryAdapter(mainViewModel.loadCategory(),object :CategoryAdapter.ClickListener{
            override fun onClick(category: String) {
                initRecent(category)

            }
        })
        binding.progressBarCategory.visibility = View.GONE
    }

    private fun initLocation() {
        val adapter = ArrayAdapter(this,R.layout.spinner_item,mainViewModel.loadLocation())
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.locationSpinner.adapter=adapter
    }
}