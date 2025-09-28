package com.example.ifunsoed

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ifunsoed.ui.adapter.BookAdapter
import com.example.ifunsoed.viewmodel.MainViewModel
import com.example.ifunsoed.databinding.ActivityDaftarBukuBinding

class DaftarBukuActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDaftarBukuBinding
    private val viewModel: MainViewModel by viewModels ()
    private val adapter = BookAdapter ( emptyList())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDaftarBukuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recycleView.layoutManager = LinearLayoutManager(this)
        binding.recycleView.adapter = adapter

        viewModel.books.observe( this){
            adapter.setData(it)
        }

        viewModel.fetchBooks( "kotlin programing")
    }
}