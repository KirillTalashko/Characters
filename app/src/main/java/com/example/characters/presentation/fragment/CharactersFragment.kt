package com.example.characters.presentation.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.characters.R
import com.example.characters.databinding.FragmentCharactersBinding
import com.example.characters.domain.repository.CharacterRepositoryImpl
import com.example.characters.domain.state.CharacterFragmentState
import com.example.characters.presentation.fragment.adapter.CharactersAdapter
import com.example.characters.presentation.fragment.viewModel.CharactersViewModel
import com.example.characters.presentation.utils.CustomViewModelFactory

class CharactersFragment : Fragment() {

    private var _binding: FragmentCharactersBinding? = null
    private val binding
        get() = _binding!!

    private val viewModel by lazy(LazyThreadSafetyMode.NONE) {
        ViewModelProvider(
            this,
            factory = CustomViewModelFactory(
                repository = CharacterRepositoryImpl(),
                noDate = getString(R.string.no_date),
                error = getString(R.string.error)
            )
        )[CharactersViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCharactersBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = CharactersAdapter()
        initRecyclerView(adapter)
        observerViewModel(adapter)
    }

    private fun initRecyclerView(adapter: CharactersAdapter) {
        binding.recyclerViewCharacters.adapter = adapter
        binding.recyclerViewCharacters.addOnScrollListener(object :
            RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val layoutManager =
                    binding.recyclerViewCharacters.layoutManager as LinearLayoutManager
                val totalItemCount = layoutManager.itemCount
                val lastVisibleItem = layoutManager.findLastVisibleItemPosition()
                if (!viewModel.getStatusLoading() && lastVisibleItem == totalItemCount - 3) {
                    viewModel.getCharacterData()
                }
            }
        })
    }

    private fun observerViewModel(adapter: CharactersAdapter) {
        viewModel.stateCharacter.observe(viewLifecycleOwner) { stateCharacter ->
            Log.i("youTag", " state $stateCharacter")
            when (stateCharacter) {
                is CharacterFragmentState.Error -> Unit
                CharacterFragmentState.LoadingCharacter -> Unit
                is CharacterFragmentState.SuccessCharacter -> {
                    val currentList = adapter.currentList
                    adapter.submitList(currentList.plus(stateCharacter.character))
                }
            }

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}