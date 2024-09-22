package com.example.myapplication.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.example.myapplication.databinding.ActivityIntroBinding

class IntroActivity : AppCompatActivity() {
    // Binding
    lateinit var binding:ActivityIntroBinding
    //............................................//
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // goButton
        binding.goButton.setOnClickListener{
            startActivity(Intent(this@IntroActivity, MainActivity::class.java))
        }

        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
    }
}