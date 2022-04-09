package com.example.tourgid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tourgid.databinding.ActivityPlaceBinding

class PlaceActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPlaceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlaceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val title = intent.getStringExtra("name")
        val country = intent.getStringExtra("country")
        val full_description = intent.getStringExtra("full_description")
        val imageid = intent.getIntExtra("imageid", R.drawable.kremlin)

        binding.title.text = title
        binding.country.text = country
        binding.fullDescription.text = full_description
        binding.placePic.setImageResource(imageid)



    }
}