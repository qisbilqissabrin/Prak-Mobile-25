package com.example.ifunsoed

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ifunsoed.data.model.BookDoc
import com.example.ifunsoed.ui.adapter.BookAdapter
import com.example.ifunsoed.viewmodel.MainViewModel
import com.example.ifunsoed.databinding.ActivityDaftarBukuBinding
import com.example.ifunsoed.ui.adapter.onBookClickListener
import com.example.ifunsoed.ui.fragment.BookDetailFragment

class DaftarBukuActivity : AppCompatActivity(), onBookClickListener {
    private lateinit var binding: ActivityDaftarBukuBinding
    private val viewModel: MainViewModel by viewModels()
    private val adapter = BookAdapter(emptyList(),this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDaftarBukuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recycleView.layoutManager = LinearLayoutManager(this)
        binding.recycleView.adapter = adapter

        viewModel.books.observe(this) {
            adapter.setData(it)
        }

        viewModel.fetchBooks("kotlin programing")
    }

    override fun onBookClick(book: BookDoc) {
        book.let{ b ->
            BookDetailFragment(
                b.title ?: "-",
                b.authorName ?. joinToString ("-") ?: "Unknow Author",
                "${b.firstPublishYear}",
                b.coverID ?: 0
            ).show (supportFragmentManager, BookDetailFragment::class.java.simpleName)
        }
    }
}