package com.mobillabor.moblab.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.mobillabor.moblab.R
import com.mobillabor.moblab.adapters.CharacterAdapter
import com.mobillabor.moblab.adapters.OnCharacterClickListener
import com.mobillabor.moblab.model.Character
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment: Fragment(), OnCharacterClickListener {
    private val characterListViewModel by viewModels<MainViewModel>()
    val characterAdapter = CharacterAdapter(this)
    lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstance: Bundle?
    ): View? {
        return inflater.inflate(R.layout.main_fragment,container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.adapter = characterAdapter
        characterListViewModel.characterList.observe(viewLifecycleOwner) { list ->
            characterAdapter.submitList(list)
        }
    }

    override fun onCharacterSelected(h: Character) {
        val bundle = Bundle()
        bundle.putString("charID", h._id)
        findNavController().navigate(R.id.action_mainFragment_to_detailsFragment, bundle)
    }


}