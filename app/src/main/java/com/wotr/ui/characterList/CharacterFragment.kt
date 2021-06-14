package com.wotr.ui.characterList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.wotr.ui.characterList.adapter.CharacterAdapter

class CharacterFragment : Fragment() {

    private val binding: FragmentCharactersBinding by lazy {
        FragmentCharactersBinding.inflate(layoutInflater)
    }

    private val viewModel: CharacterViewModel by viewModels()

    private lateinit var adapter: CharacterAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupView()
        setupListeners()
    }

    private fun setupView() {
        adapter = CharacterAdapter()

        binding.rvCharacters.adapter = adapter
        binding.rvCharacters.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun setupListeners() {
        viewModel.booksResult.observe(viewLifecycleOwner, ::onCharactersResult)
        viewModel.booksError.observe(viewLifecycleOwner) { onCharactersError() }

        binding.rlCharacters.setOnRefreshListener { findCharacters() }

        findCharacters()
    }

    private fun findCharacters() {
        binding.errorView.hide()
        viewModel.getCharacters()
    }

    private fun onCharactersResult(books: List<CharacterDto>) {
        adapter.books = books
        binding.rlCharacters.isRefreshing = false
        binding.rvCharacters.visibility = View.VISIBLE
    }

    private fun onCharactersError() {
        binding.rlCharacters.isRefreshing = false
        binding.rvCharacters.visibility = View.GONE
        binding.errorView.show()
    }

}