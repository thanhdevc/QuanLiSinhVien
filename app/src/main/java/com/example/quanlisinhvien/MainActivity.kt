package com.example.quanlisinhvien

import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quanlisinhvien.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        val list = mutableListOf<studentModel>()
        val adapter : Adapter

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.rvlist.layoutManager = LinearLayoutManager(this)
        adapter = Adapter(list)
        binding.rvlist.adapter = adapter



        binding.button.setOnClickListener{
            list.add(studentModel(binding.editTextName.text.toString(), binding.editTextMSSV.text.toString()))
            adapter.notifyDataSetChanged()
            binding.editTextName.setText("")
            binding.editTextMSSV.setText("")
            binding.editTextName.requestFocus()

        }

    }
}