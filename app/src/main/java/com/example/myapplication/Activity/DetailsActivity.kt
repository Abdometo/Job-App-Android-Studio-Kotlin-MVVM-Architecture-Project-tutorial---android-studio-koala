package com.example.myapplication.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.bumptech.glide.Glide
import com.example.myapplication.Fragment.AboutFragment
import com.example.myapplication.Fragment.CompanyFragment
import com.example.myapplication.Fragment.ReviewFragment
import com.example.myapplication.Model.JobModel
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {
    // binding
    lateinit var binding:ActivityDetailsBinding
    // job Model
    private lateinit var item:JobModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        getBundle()
        setupViewPager()
    }

    private fun getBundle() {
        item = intent.getParcelableExtra("object")!!


        binding.titleText.text = item.title
        binding.companyText.text = item.company
        binding.locationText.text=item.location
        binding.jobTypeText.text=item.time
        binding.workingModelText.text=item.model
        binding.levelText.text=item.level
        binding.salaryText.text=item.salary


        val drawableResourceId = resources.getIdentifier(item.picUrl,"drawable",packageName)


        Glide
            .with(this)
            .load(drawableResourceId)
            .into(binding.picDetails)



        binding.backButton.setOnClickListener{
            finish()
        }
    }

    private fun setupViewPager(){
        val adapter = ViewPagerAdapter(supportFragmentManager)
        val tab1 = AboutFragment()
        val tab2 = CompanyFragment()
        val tab3 = ReviewFragment()

        val bundle1 = Bundle()
        bundle1.putString("description",item.description)
        bundle1.putString("about",item.about)


        tab1.arguments = bundle1
        tab2.arguments = Bundle()
        tab3.arguments = Bundle()


        adapter.addFrag(tab1,"About")
        adapter.addFrag(tab2,"Company")
        adapter.addFrag(tab3,"Review")

        binding.viewPager.adapter = adapter
        binding.tabLayout.setupWithViewPager(binding.viewPager)


    }
    private class ViewPagerAdapter(fm:FragmentManager):FragmentPagerAdapter(fm) {

        private val fragmentList = arrayListOf<Fragment>()
        private val fragmentTitleList = arrayListOf<String>()

        override fun getCount(): Int = fragmentList.size

        override fun getItem(position: Int): Fragment = fragmentList[position]
        fun addFrag(fragment:Fragment,title:String){
            fragmentList.add(fragment)
            fragmentTitleList.add(title)
        }

        override fun getPageTitle(position: Int):CharSequence? = fragmentTitleList[position]
    }



}